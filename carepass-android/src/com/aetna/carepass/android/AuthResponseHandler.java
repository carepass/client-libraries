package com.aetna.carepass.android;

/**
 * Listener for the {@link AuthTool}, for indicating when the OAuth process is
 * completed, either {@link #onAccessTokenReceived(AuthResponseDetails)
 * successfully} or {@link unsuccessfully}.
 */
public interface AuthResponseHandler {
	void onAccessTokenReceived(AuthResponseDetails response);

	void onAuthFailed(AuthErrorDetails err);
}