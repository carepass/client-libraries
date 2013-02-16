/**
 * 
 */
package com.aetna.carepass.android;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Fragment for adding a "Connect to CarePass" widget to your App.
 * 
 * When the user connects, it saves the current access token to the current
 * context's shared preferences, notably:
 * 
 *     PREF_TOKEN: the access bearer token 
 *     PREF_TOKEN_EXP: the expiry time, in system time
 * 
 * @author David Mihalcik
 */
public class InitFragment extends Fragment implements OnClickListener {
	public static interface AuthResponseHandler {
		void onAccessTokenReceived(String token, long expiresOn, String scope);

		void onAuthFailed(String error, String errorDescription);
	}
	
	private static final int REQ_CODE_AUTH = 0x1A1;

	protected static final boolean D = true;
	
	public static final String PREF_TOKEN = "com.aetna.carepass.android.AccessToken";
	public static final String PREF_TOKEN_EXP = "com.aetna.carepass.android.AccessTokenExpiry";

	private String accessToken;

	private TextView text_username;
	private ImageView button_login;

	private String apiKey;

	private String sharedSecret;

	private String redirectUri;

	private String requestedScope = "IDENTITY";

	private long expiry;

	private String receivedScope;
	
	protected AuthResponseHandler responseHandler = new AuthResponseHandler() {
		public void onAuthFailed(String error, String errorDescription) {
			final String s = errorDescription;
			FragmentActivity activity = getActivity();
			if(null == activity) return; // already closed
			activity.runOnUiThread(new Runnable(){
				@Override
				public void run() {
					setDisplayedTextMessage(s);
				}
			});
		}
		@Override
		public void onAccessTokenReceived(String token, long expiresOn, String scope) {
			String toSay = getString(R.string.failure);
			try {
				URL u = new URL("https://api.carepass.com/user-directory-api/users/currentUser");
				HttpURLConnection con = (HttpURLConnection) u.openConnection();
				BufferedReader reader = null;
				InputStream is = null;
				try {
				con.addRequestProperty("Authorization", "Bearer " + accessToken);
				con.addRequestProperty("Accept", "application/json");
				//con.addRequestProperty("Apikey", getString(R.string.carepass_api_key));
				reader = null;
				is = con.getInputStream();
				reader = new BufferedReader(new InputStreamReader(is));
				
				StringBuilder sb = new StringBuilder();
				for(;;) {
					String nextLine = reader.readLine();
					if(null==nextLine) break;
					sb.append(nextLine);
				}
				JSONTokener tok = new JSONTokener(sb.toString());
				JSONObject obj = new JSONObject(tok);
				String name = obj.getString("firstName") + " "
				+ obj.getString("lastName");
				toSay = getString(R.string.logged_in_as, name);
				} catch (JSONException e) {
					toSay = "Error: " + e.getLocalizedMessage();
					e.printStackTrace();
				} catch (IOException e) {
					toSay = "Error: " + e.getLocalizedMessage();
					e.printStackTrace();
				} finally {
					if(null != reader) {
						reader.close();
					} else if(null != is) {
						is.close();
					}
					con.disconnect();
				}
			} catch (MalformedURLException e) {
				e.printStackTrace();
				toSay = "Error: " + e.getLocalizedMessage();
			} catch (IOException e) {
				toSay = "Error: " + e.getLocalizedMessage();
				e.printStackTrace();
			}
			{
			final String s = toSay;
			FragmentActivity activity = getActivity();
			if(null == activity) return; // already closed
			activity.runOnUiThread(new Runnable(){
				@Override
				public void run() {
					setDisplayedTextMessage(s);
				}
			});
			}
		}
	};

	private String error;

	private String errorDescription;

	/**
	 * 
	 */
	public InitFragment() {
	}
	
	public void setResponseHandler(AuthResponseHandler responseHandler) {
		this.responseHandler = responseHandler;
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		apiKey = getString(R.string.carepass_api_key);
		sharedSecret = getString(R.string.carepass_shared_secret);
		redirectUri = getString(R.string.carepass_redirect_uri);
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View v = inflater.inflate(R.layout.layout_carepass_login, container);
		v.findViewById(R.id.button_carepass_sync).setOnClickListener(this);
		text_username = (TextView)v.findViewById(R.id.carepass_login_text);
		button_login = (ImageView) v.findViewById(R.id.button_carepass_sync);
		button_login.setOnClickListener(this);
		return v;
	}
	
	@Override
	public void onClick(View arg0) {
		startAuth();
	}

	private void startAuth() {
		Intent intent = new Intent(getActivity(), AuthActivity.class);
		intent.putExtra(AuthActivity.EXTRA_API_KEY, apiKey);
		intent.putExtra(AuthActivity.EXTRA_SHARED_SECRET, sharedSecret);
		intent.putExtra(AuthActivity.EXTRA_REDIRECT_URI, redirectUri);
		intent.putExtra(AuthActivity.EXTRA_SCOPE, requestedScope);
		startActivityForResult(intent, REQ_CODE_AUTH);
	}

	@Override
	public void onActivityResult(int requestCode, int resultCode, Intent data) {
		super.onActivityResult(requestCode, resultCode, data);
		if(REQ_CODE_AUTH == requestCode) {
			if(Activity.RESULT_CANCELED == resultCode) {
				error = "Canceled";
				errorDescription = "";
				if(null != responseHandler) {
					responseHandler.onAuthFailed(error,
							errorDescription);
				}
				return;
			}
			if(Activity.RESULT_OK != resultCode) {
				error = data.getExtras().getString(AuthActivity.EXTRA_ERROR);
				errorDescription = data.getExtras().getString(AuthActivity.EXTRA_ERROR_DESCRIPTION);
				if(null != responseHandler) {
					responseHandler.onAuthFailed(error,
							errorDescription);
				}
				return;
			}
			text_username.setText(R.string.loading_);
			accessToken = data.getExtras().getString(AuthActivity.EXTRA_ACCESS_TOKEN);
			long expiresIn = data.getExtras().getLong(AuthActivity.EXTRA_EXPIRES_IN);
			expiry = expiresIn + System.currentTimeMillis();
			receivedScope = data.getExtras().getString(AuthActivity.EXTRA_SCOPE);
			final SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(getActivity().getApplicationContext());
			Runnable r = new Runnable() {
				@Override
				public void run() {
					prefs.edit().putString(PREF_TOKEN, accessToken).putLong(PREF_TOKEN_EXP, expiry).commit();
					if(null != responseHandler) {
						responseHandler.onAccessTokenReceived(accessToken,
								expiry, receivedScope);
					}
				}
			};
			Thread t = new Thread(r);
			t.setName("carepass-identity");
			t.start();
		}
	}

	public String getApiKey() {
		return apiKey;
	}

	public void setApiKey(String apiKey) {
		this.apiKey = apiKey;
	}

	public String getSharedSecret() {
		return sharedSecret;
	}

	public void setSharedSecret(String sharedSecret) {
		this.sharedSecret = sharedSecret;
	}

	public String getRedirectUri() {
		return redirectUri;
	}

	public void setRedirectUri(String redirectUri) {
		this.redirectUri = redirectUri;
	}

	public String getRequestedScope() {
		return requestedScope;
	}

	public void setRequestedScope(String requestedScope) {
		this.requestedScope = requestedScope;
	}

	public String getAccessToken() {
		return accessToken;
	}

	public long getExpiry() {
		return expiry;
	}

	public String getReceivedScope() {
		return receivedScope;
	}

	public void setDisplayedTextMessage(final String s) {
		text_username.setText(s);
	}
}
