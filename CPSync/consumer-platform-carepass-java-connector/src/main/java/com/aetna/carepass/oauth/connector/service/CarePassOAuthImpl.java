package com.aetna.carepass.oauth.connector.service;

import org.scribe.builder.ServiceBuilder;
import org.scribe.exceptions.OAuthException;
import org.scribe.model.Token;
import org.scribe.model.Verifier;
import org.scribe.oauth.OAuthService;
import org.springframework.stereotype.Service;

import com.aetna.carepass.oauth.connector.scribe.api.CarePassOAuthData;

@Service
public class CarePassOAuthImpl implements CarePassOAuth {

	private final Token EMPTY_TOKEN = null;

	private CarePassOAuthData data;
	private Token accessToken;

	public CarePassOAuthData getData() {
		return data;
	}

	public void setData(CarePassOAuthData data) {
		this.data = data;
	}

	/**
	 * {@inheritDoc}
	 * 
	 */
	public OAuthService getService() {
		return new ServiceBuilder().provider(data.getApi())
				.apiKey(data.getApiKey()).apiSecret(data.getApiSecret())
				.callback(data.getCallback()).build();
	}

	/**
	 * {@inheritDoc}
	 */
	public void grantOauthAccess(String responseCode)throws EndpointException {
		try{
		Verifier verifier = new Verifier(responseCode);
		accessToken = getService().getAccessToken(null, verifier);
		}catch(OAuthException e){
			throw new EndpointException (e.getMessage());
		}
	
	}

	/**
	 * 
	 * {@inheritDoc}
	 */
	public boolean isAccessTokenReady() {
		return accessToken != null ? true : false;
	}

	/**
	 * {@inheritDoc}
	 */
	public String retrieveInitialRequest() {
		OAuthService service = getService();
		return service.getAuthorizationUrl(EMPTY_TOKEN);
	}

	/**
	 * {@inheritDoc}
	 */	
	public Token retrieveOauthToken() {
		return accessToken;
	}

}
