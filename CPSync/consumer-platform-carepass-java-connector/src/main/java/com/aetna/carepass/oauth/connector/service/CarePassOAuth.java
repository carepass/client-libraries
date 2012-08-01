package com.aetna.carepass.oauth.connector.service;

import org.scribe.model.Token;
import org.scribe.oauth.OAuthService;


public interface CarePassOAuth {
	/**
	 * Generates the OAuth hand shake for Care Pass
	 * @param responseCode the authorization code
	 * @throws EndpointException
	 */
	public void grantOauthAccess(String responseCode) throws EndpointException;;
	
	/**
	 * Build the Scribe OAuthService
	 * @return the CarePass OAuthService
	 * 
	 */
	public OAuthService getService();
	
	/**
	 * Creates the Authorization URL
	 * @return the authorization URL
	 */
	public String retrieveInitialRequest();
	
	/**
	 * Checks if the access token is already created
	 * @return true if the access token is created otherwise false.
	 */
	public boolean isAccessTokenReady();
	
	/**
	 * Retrieves the Acess_token
	 * @return The obtained access token.
	 */
	public Token retrieveOauthToken();
		
	

}
