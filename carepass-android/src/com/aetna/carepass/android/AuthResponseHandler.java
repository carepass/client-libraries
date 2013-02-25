package com.aetna.carepass.android;

public interface AuthResponseHandler {
	void onAccessTokenReceived(AuthResponseDetails response);

	void onAuthFailed(AuthErrorDetails err);
}