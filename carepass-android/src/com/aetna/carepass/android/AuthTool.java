package com.aetna.carepass.android;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.preference.PreferenceManager;

public class AuthTool {
	public static final String PREF_TOKEN = "com.aetna.carepass.android.AccessToken";
	public static final String PREF_TOKEN_EXP = "com.aetna.carepass.android.AccessTokenExpiry";
	public static final String PREF_CAREPASS_SCOPE = "com.aetna.carepass.android.AccessScope";

	protected Activity c;
	
	protected AuthRequestDetails request;
	
	protected AuthResponseDetails response;
	
	protected AuthErrorDetails err;
	
	protected AuthResponseHandler responseHandler;
	
	public AuthTool(Activity ctx, AuthRequestDetails request) {
		super();
		this.c = ctx;
		this.request = request;
	}
	
	public void setResponseHandler(AuthResponseHandler responseHandler) {
		this.responseHandler = responseHandler;
	}

	public Intent startAuth() {
		Intent intent = new Intent(c, AuthActivity.class);
		intent.putExtra(AuthActivity.EXTRA_AUTH_REQUEST, request);
		return intent;
	}

	public boolean handleResult(int resultCode, Intent data) {
		if(Activity.RESULT_CANCELED == resultCode) {
			err = new AuthErrorDetails( "Canceled", "");
			if(null != responseHandler) {
				responseHandler.onAuthFailed(err);
			}
			return false;
		}
		if(Activity.RESULT_OK != resultCode) {
			err = data.getExtras().getParcelable( AuthActivity.EXTRA_ERROR );
			if(null != responseHandler) {
				responseHandler.onAuthFailed(err);
			}
			return false;
		}
		response = data.getExtras().getParcelable(AuthActivity.EXTRA_AUTH_RESPONSE);
		Runnable r = new Runnable() {
			@Override
			public void run() {
				storeResponse( c, response );
				if(null != responseHandler) {
					responseHandler.onAccessTokenReceived(response);
				}
			}
		};
		Thread t = new Thread(r);
		t.setName("carepass-identity");
		t.start();
		return true;
	}

	public static void storeResponse(Context activity,
			AuthResponseDetails response) {
		PreferenceManager
			.getDefaultSharedPreferences(activity.getApplicationContext())
			.edit()
				.putString(PREF_TOKEN, response.getAccessToken())
				.putLong(PREF_TOKEN_EXP, response.getExpiry())
				.putString(PREF_CAREPASS_SCOPE, response.getReceivedScope())
			.commit();
	}

	public AuthResponseDetails getResponse() {
		return response;
	}
	
	public AuthErrorDetails getErr() {
		return err;
	}

}
