package com.aetna.carepass.oauth.connector.scribe.api;

import org.scribe.builder.api.DefaultApi20;
import org.scribe.extractors.AccessTokenExtractor;
import org.scribe.extractors.JsonTokenExtractor;
import org.scribe.model.OAuthConfig;
import org.scribe.utils.Preconditions;
import static org.scribe.utils.URLUtils.*;

public class CarePassApi extends DefaultApi20 {

	private static final String AUTHORIZE_URL = "https://www.carepass.com/carepass/oauth/authorize?" +
			"client_id=%s&redirect_uri=%s&response_type=code&scope=";

	private static final String SCOPED_AUTHORIZE_URL = "&scope=%s";

	private static final String ACCESS_TOKEN_ENDPOINT ="https://www.carepass.com/carepass/oauth/token?grant_type=authorization_code";
	
	private String scope;
	
	
	public String getScope() {
		return scope;
	}

	public void setScope(String scope) {
		this.scope = scope;
	}

	@Override
	public String getAccessTokenEndpoint() {
		return ACCESS_TOKEN_ENDPOINT;
	}

	@Override
	public String getAuthorizationUrl(OAuthConfig config) {
		Preconditions.checkValidUrl(config.getCallback(),
				"Must provide a valid url as callback");
		// Append scope if present
		if (config.hasScope()) {
			return String.format(AUTHORIZE_URL+scope+SCOPED_AUTHORIZE_URL, config.getApiKey(),
					formURLEncode(config.getCallback()),
					formURLEncode(config.getScope()));
		} else {
			return String.format(AUTHORIZE_URL+scope, config.getApiKey(),
					formURLEncode(config.getCallback()));
		}
	}

	@Override
	public AccessTokenExtractor getAccessTokenExtractor() {
		return new JsonTokenExtractor();
	}

}
