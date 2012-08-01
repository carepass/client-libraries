package com.aetna.carepass.oauth.connector.scribe.api;

public class CarePassOAuthData {
	private String apiKey;
	private String apiSecret;
	private String callback;
	private CarePassApi api;

	public String getApiKey() {
		return apiKey;
	}

	public void setApiKey(String apiKey) {
		this.apiKey = apiKey;
	}

	public String getApiSecret() {
		return apiSecret;
	}

	public void setApiSecret(String apiSecret) {
		this.apiSecret = apiSecret;
	}

	public String getCallback() {
		return callback;
	}

	public void setCallback(String callback) {
		this.callback = callback;
	}

	public CarePassApi getApi() {
		return api;
	}

	public void setApi(CarePassApi api) {
		this.api = api;
	}
}
