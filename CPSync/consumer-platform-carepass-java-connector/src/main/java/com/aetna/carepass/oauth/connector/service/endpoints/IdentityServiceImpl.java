package com.aetna.carepass.oauth.connector.service.endpoints;

import java.net.HttpURLConnection;

import org.scribe.model.OAuthRequest;
import org.scribe.model.Response;
import org.scribe.model.Token;
import org.scribe.model.Verb;
import org.scribe.oauth.OAuthService;
import org.springframework.beans.factory.annotation.Autowired;

import com.aetna.carepass.oauth.connector.api.identity.Identity;
import com.aetna.carepass.oauth.connector.service.CarePassOAuth;
import com.aetna.carepass.oauth.connector.service.EndpointException;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

public class IdentityServiceImpl implements IdentityService {

	private static final String BASE_URL = "https://api.carepass.com";
	private static final String USER_DIR_API = "/user-directory-api";

	@Autowired
	private CarePassOAuth carePassOAuth;

	public Identity findIdentity() throws EndpointException {
		
		if (!carePassOAuth.isAccessTokenReady()) {
			throw new EndpointException("There is not a valid access token");
		}
		OAuthService service = carePassOAuth.getService();
		Token accessToken = carePassOAuth.retrieveOauthToken();
		OAuthRequest oauthRequest = new OAuthRequest(Verb.GET, BASE_URL
				+ USER_DIR_API + "/users/currentUser");

		oauthRequest.addHeader("Accept", "application/json");
		service.signRequest(accessToken, oauthRequest);
		Response oauthResponse = oauthRequest.send();

		if (oauthResponse.getCode() == HttpURLConnection.HTTP_OK) {
			JsonParser parser = new JsonParser();
			JsonElement element = parser.parse(oauthResponse.getBody());

			Gson gson = new Gson();
			return gson.fromJson(element, Identity.class);
		} else {
			throw new EndpointException(oauthResponse.getBody());
		}

	}
}
