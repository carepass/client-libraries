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

import android.content.Intent;
import android.os.Bundle;
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
 * <pre>
 *     PREF_TOKEN: the access bearer token 
 *     PREF_TOKEN_EXP: the expiry time, in system time
 * </pre>
 */
public class InitFragment extends Fragment implements OnClickListener {
	private static final int REQ_CODE_AUTH = 0x1A1;

	protected static final boolean D = false;
	
	protected static final String TAG = "CarePass";

	private TextView text_username;
	private ImageView button_login;
	
	private AuthRequestDetails request;

	protected AuthResponseHandler defaultResponseHandler = new AuthResponseHandler() {
		public void onAuthFailed(AuthErrorDetails err) {
			final String s1 = err.getError();
			// final String s2 = err.getErrorDescription();
			FragmentActivity activity = getActivity();
			if(null == activity) return; // already closed
			activity.runOnUiThread(new Runnable(){
				@Override
				public void run() {
					setDisplayedTextMessage(s1);
				}
			});
		}
		@Override
		public void onAccessTokenReceived(AuthResponseDetails response) {
			String toSay = getString(R.string.failure);
			try {
				URL u = new URL("https://api.carepass.com/user-directory-api/users/currentUser");
				HttpURLConnection con = (HttpURLConnection) u.openConnection();
				BufferedReader reader = null;
				InputStream is = null;
				try {
				con.addRequestProperty("Authorization", "Bearer " + response.getAccessToken());
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

	private AuthTool authTool;

	/**
	 * 
	 */
	public InitFragment() {
	}
	
	public void setResponseHandler(AuthResponseHandler responseHandler) {
		if( null == authTool ) {
			defaultResponseHandler = responseHandler;
		} else {
			authTool.setResponseHandler( responseHandler );
		}
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		request = new AuthRequestDetails(
				getString(R.string.carepass_api_key),
				getString(R.string.carepass_shared_secret),
				getString(R.string.carepass_redirect_uri),
				"IDENTITY");
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
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		authTool = new AuthTool(getActivity(), request);
		authTool.setResponseHandler( defaultResponseHandler );
	}
	
	@Override
	public void onClick(View arg0) {
		Intent i = authTool.startAuth();
		startActivityForResult( i, REQ_CODE_AUTH );
	}


	@Override
	public void onActivityResult(int requestCode, int resultCode, Intent data) {
		super.onActivityResult(requestCode, resultCode, data);
		if(REQ_CODE_AUTH == requestCode) {
			if( authTool.handleResult( resultCode, data ) ){
				text_username.setText(R.string.loading_);
			}
		}
	}

	public void setDisplayedTextMessage(final String s) {
		text_username.setText(s);
	}

	public void setRequestedScope(String requestedScope) {
		request.setRequestedScope(requestedScope);
	}
}
