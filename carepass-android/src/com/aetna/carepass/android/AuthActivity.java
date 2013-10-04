package com.aetna.carepass.android;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import org.json.JSONException;
import org.json.JSONObject;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.net.http.SslError;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.webkit.SslErrorHandler;
import android.webkit.WebView;
import android.webkit.WebViewClient;

/**
 * This activity using the Aetna CarePass OAuth 2 api. If you don't have an
 * access token, or your access token is out of date, call
 * `startActivityForResult` it an `Intent` with the EXTRA including the api key
 * your app is using, its shared secret, and the redirect URI.
 * 
 * Generally, it is simpler to not start this activity directly, but instead use 
 * {@link AuthTool} or {@link InitFragment} to handle the creation for you.
 * 
 * When the activity completes, it will return a bundle including the access
 * code, if it is set, in the `EXTRA_ACCESS_TOKEN` extra. It will also return
 * the scope value in the `EXTRA_SCOPE` parameter, which *may* be different from
 * the passed in value, when / if CarePass supports *optional* permissions. The
 * expiration time, specified as a `long` in milliseconds, is returned in the
 * `EXTRA_EXPIRES_IN` extra.
 * 
 * For mocking and testing, you may pass in a modified {@link CarePassUris} as
 * the {@link #EXTRA_URIS} so that the requests are sent to the server of your
 * choice.
 */
public class AuthActivity extends Activity {

	/**
	 * An input data extra, this must be a {@link CarePassUris} object. It is
	 * useful during testing if you are logging into a mock CarePass server.
	 */
	public static final String EXTRA_URIS = "EXTRA_URIS";
	public static final String EXTRA_AUTH_REQUEST = "EXTRA_AUTH_REQUEST";

	public static final String EXTRA_AUTH_RESPONSE = "EXTRA_AUTH_RESPONSE";

	/**
	 * Sent on the response intent, this extra is set to an 
	 * {@link AuthErrorDetails} object. When this occurs, the result will
	 * be {@link #RESULT_AUTH_ERR}.
	 */
	public static final String EXTRA_ERROR = "EXTRA_ERROR";

	/**
	 * If the result is not <code>RESULT_OK</code> or 
	 * <code>RESULT_CANCELED</code>, it might be this error, which indicates
	 * a problem logging in. See the {@link #EXTRA_ERROR relevant extra} for
	 * more details, which is passed as the `data` object in the 
	 * <code>onActivityResult</code> method. 
	 */
	public static final int RESULT_AUTH_ERR = RESULT_FIRST_USER + 0;

	protected static final boolean D = false;

	private AuthRequestDetails request;

	private CarePassUris uris;

	@SuppressLint("SetJavaScriptEnabled")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		Intent data = getIntent();
		Bundle extras = data.getExtras();
		request = extras.getParcelable(EXTRA_AUTH_REQUEST);
		if (extras.containsKey(EXTRA_URIS)) {
			uris = extras.getParcelable(EXTRA_URIS);
		} else {
			uris = new CarePassUris();
		}

		WebView webview = new WebView(this);
		// XXX is this necessary?
		webview.getSettings().setJavaScriptEnabled(true);
		webview.setVisibility(View.VISIBLE);

		/* WebViewClient must be set BEFORE calling loadUrl! */
		webview.setWebViewClient(new WebViewClient() {
			private boolean done;

			@Override
			public boolean shouldOverrideUrlLoading(WebView view, String url) {
				if (null == url) {
					return super.shouldOverrideUrlLoading(view, url);
				}
				if (url.startsWith(request.getRedirectUri()) && !done) {
					Uri finishedPage = Uri.parse(url);
					handleRedirect(finishedPage);
					return true;
				}
				return super.shouldOverrideUrlLoading(view, url);
			}

			@Override
			public void onReceivedError(WebView view, int errorCode,
					String description, String failingUrl) {
				if (done)
					return;
				done = true;
				errRespond("" + errorCode, description);
			}

			@Override
			public void onReceivedSslError(WebView view,
					SslErrorHandler handler, SslError error) {
				if (done)
					return;
				done = true;
				if (error.hasError(SslError.SSL_UNTRUSTED)) {
					errRespond(getString(R.string.error_ssl_untrusted),
							error.toString());
				} else {
					errRespond("" + error.getPrimaryError(), error.toString());
				}
			}

			@Override
			public void onPageFinished(WebView view, String url) {
				if (done)
					return;
				if (D)
					Log.i(CarePassUris.TAG, "page finished: " + url);
				Uri finishedPage = Uri.parse(url);
				if (url.startsWith(request.getRedirectUri())) {
					handleRedirect(finishedPage);
					return;
				}
			}

			private void handleRedirect(Uri finishedPage) {
				final String code = finishedPage.getQueryParameter("code");
				if (null != code && !"".equals(code)) {
					handleAuthCode(code);
					return;
				}
				final String error = finishedPage.getQueryParameter("error");
				final String errorDescription = finishedPage
						.getQueryParameter("errorDescription");
				done = true;
				if (null != error) {
					errRespond(error, errorDescription);
				} else {
					errRespond("Unspecified", "");
				}
			}

			private void handleAuthCode(final String code) {
				done = true;
				setContentView(R.layout.carepass_loading);
				Thread t = new Thread(new Runnable() {
					@Override
					public void run() {
						Uri accessUrl = makeAccessUrl(code);
						try {
							URL u = new URL(accessUrl.toString());
							int responseCode;
							String responseString = "", errorString = "";
							HttpURLConnection con = (HttpURLConnection) u
									.openConnection();
							boolean httpErrCode = false;
							try {
								con.connect();
								responseCode = con.getResponseCode();
								httpErrCode = responseCode < 200
										|| 300 <= responseCode;
								if (httpErrCode) {
									// unexpected values
									errorString = Utils.readAllAndClose(con
											.getErrorStream());
								}
								responseString = Utils.readAllAndClose(con
										.getInputStream());
							} finally {
								con.disconnect();
							}
							if (!"".equals(errorString)) {
								// maybe an error was specified
								try {
									JSONObject errObj = new JSONObject(
											errorString);
									if (errObj.has("error")) {
										handleErrorResponse(responseCode,
												errObj);
										return;
									} else {
										if (D)
											Log.w(CarePassUris.TAG,
													"error not found in error stream: "
															+ errorString);
									}
								} catch (JSONException e) {
									if (D)
										Log.w(CarePassUris.TAG,
												"error not found in error stream: "
														+ errorString, e);
									handleErrorResponse(responseCode, null);
								}
							}
							JSONObject obj = new JSONObject(responseString);
							if (httpErrCode || obj.has("error")) {
								handleErrorResponse(responseCode, obj);
								return;
							}
							final long expiry = 1000L * obj
									.getLong("expires_in");
							final String scope = obj.getString("scope");
							final String accessToken = obj
									.getString("access_token");
							final long expiration = expiry
									+ System.currentTimeMillis();
							final AuthResponseDetails currentResponse = new AuthResponseDetails(
									expiration, scope, accessToken);

							// assert
							// "bearer".equals(obj.getString("token_type"));

							// Log.d("REMOVE", accessToken);

							runOnUiThread(new Runnable() {
								@Override
								public void run() {
									Intent data = new Intent();
									data.putExtra(EXTRA_AUTH_RESPONSE,
											currentResponse);
									setResult(RESULT_OK, data);
									finish();
								}
							});

						} catch (MalformedURLException e) {
							if (D)
								Log.e(CarePassUris.TAG,
										"Bad auth uri: " + e.getMessage(), e);
							else
								Log.w(CarePassUris.TAG,
										"Bad auth uri: " + e.getMessage());
							errRespond("Invalid URI", e.getMessage());
						} catch (IOException e) {
							if (D)
								Log.e(CarePassUris.TAG, "Connection problem: "
										+ e.getMessage(), e);
							else
								Log.w(CarePassUris.TAG, "Connection problem: "
										+ e.getMessage());
							errRespond("IO Error", e.getMessage());
						} catch (JSONException e) {
							if (D)
								Log.e(CarePassUris.TAG,
										"JSON problem: " + e.getMessage(), e);
							else
								Log.w(CarePassUris.TAG,
										"JSON problem: " + e.getMessage());
							errRespond("Invalid Response", e.getMessage());
						}
					}

					private void handleErrorResponse(int responseCode,
							JSONObject errObj) {
						if (null == errObj) {
							// switch(responseCode) {
							// case 401:
							// case 403:
							// default:
							// }
							errRespond("HTTP Error", "" + responseCode);
							return;
						}
						if (403 == responseCode) {
							try {
								errRespond("invalid_client",
										errObj.getJSONObject("error")
												.getString("message"));
							} catch (JSONException e) {
								errRespond("invalid_client", errObj.toString());
							}
							return;
							// } else if(401 == responseCode) {
						}
						if (errObj.has("message")) {
							try {
								String msg = errObj.getString("message");
								String desc = errObj.get("error").toString();
								if ("Expired Token".equals(msg)) {
									msg = "expired_access_token";
								} else if ("Missing redirect_uri".equals(msg)) {
									msg = "missing_redirect_uri";
								} else if ("Authorization code is invalid"
										.equals(msg)) {
									msg = "invalid_authorization_code";
								}
								errRespond(msg, desc);
								return;
							} catch (JSONException e) {
								if (D)
									Log.e(CarePassUris.TAG, "JSON problem: "
											+ e.getMessage(), e);
								else
									Log.w(CarePassUris.TAG, "JSON problem: "
											+ e.getMessage());
							}
						}
						errRespond("Unspecified", errObj.toString());
					}
				});
				t.setName("auth-access");
				t.start();
			}
		});

		Uri authUri = makeAuthUrl();
		if (D)
			Log.i(CarePassUris.TAG, "Login URI: " + authUri);
		// ??? Should we instead load in the user's preferred browser?
		// startActivityForResult(new Intent(Intent.ACTION_VIEW, authUri), 2);
		webview.loadUrl(authUri.toString());
		setContentView(webview);
	}

	protected void errRespond(String err, String description) {
		Intent data = new Intent();
		data.putExtra(EXTRA_ERROR, new AuthErrorDetails(err, description));
		setResult(RESULT_AUTH_ERR, data);
		finish();
	}

	private Uri makeAccessUrl(String userAuthCode) {
		return makeAccessUrl(request.getApiKey(), request.getRedirectUri(),
				userAuthCode);
	}

	private Uri makeAccessUrl(String clientId, String redirectUri,
			String authCode) {

		// https://www.carepass.com/carepass/oauth/token?grant_type=authorization_code
		// &client_id={client_id}&code={code}&redirect_uri={redirect_uri}&client_secret={client_secret}
		return Uri
				.parse(uris.OAUTH_TOKEN)
				.buildUpon()
				.appendQueryParameter("grant_type", "authorization_code")
				.appendQueryParameter("redirect_uri", redirectUri)
				.appendQueryParameter("client_id", clientId)
				.appendQueryParameter("code", authCode)
				.appendQueryParameter("client_secret",
						request.getSharedSecret()).build();
	}

	private Uri makeAuthUrl() {
		return makeAuthUrl(request.getRequestedScope(),
				request.getRedirectUri(), request.getApiKey());
	}

	private Uri makeAuthUrl(String scope, String redirectUri, String clientId) {
		return Uri.parse(uris.OAUTH_AUTH).buildUpon()
				.appendQueryParameter("scope", scope)
				.appendQueryParameter("redirect_uri", redirectUri)
				.appendQueryParameter("client_id", clientId)
				.appendQueryParameter("response_type", "code").build();
	}
}
