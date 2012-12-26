package com.aetna.carepass.oauth.connector.service.endpoints;

import java.net.HttpURLConnection;
import java.util.ArrayList;
import java.util.List;

import org.scribe.model.OAuthRequest;
import org.scribe.model.Response;
import org.scribe.model.Token;
import org.scribe.model.Verb;
import org.scribe.oauth.OAuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aetna.carepass.oauth.connector.api.insurance.Insurance;
import com.aetna.carepass.oauth.connector.service.CarePassOAuth;
import com.aetna.carepass.oauth.connector.service.EndpointException;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

@Service
public class InsuranceServiceImpl implements InsuranceService {
	private static final String BASE_URL = "https://api.carepass.com";
	private static final String USER_DIR_API = "/user-directory-api";
	@Autowired
	private CarePassOAuth carePassOAuth;

	/**
	 * {@inheritDoc}
	 */
	public Insurance findInsurancePlanById(int insurancePlansId)
			throws EndpointException {
		if (!carePassOAuth.isAccessTokenReady()) {
			throw new EndpointException("There is not a valid access token");
		}
		OAuthService service = carePassOAuth.getService();
		Token accessToken = carePassOAuth.retrieveOauthToken();
		OAuthRequest oauthRequest = new OAuthRequest(Verb.GET, BASE_URL
				+ USER_DIR_API + "/users/currentUser/insurance/plans/"
				+ insurancePlansId);

		oauthRequest.addHeader("Accept", "application/json");
		service.signRequest(accessToken, oauthRequest);
		Response oauthResponse = oauthRequest.send();

		if (oauthResponse.getCode() == HttpURLConnection.HTTP_OK) {
			JsonParser parser = new JsonParser();
			JsonElement jsonElement = parser.parse(oauthResponse.getBody());

			Gson gson = new Gson();

			return gson.fromJson(jsonElement, Insurance.class);

		} else {
			throw new EndpointException(oauthResponse.getBody());
		}

	}

	/**
	 * {@inheritDoc}
	 */
	public List<Insurance> findInsurancePlan() throws EndpointException {
		if (!carePassOAuth.isAccessTokenReady()) {
			throw new EndpointException("There is not a valid access token");
		}
		OAuthService service = carePassOAuth.getService();
		Token accessToken = carePassOAuth.retrieveOauthToken();
		OAuthRequest oauthRequest = new OAuthRequest(Verb.GET, BASE_URL
				+ USER_DIR_API + "/users/currentUser/insurance/plans");

		oauthRequest.addHeader("Accept", "application/json");
		service.signRequest(accessToken, oauthRequest);
		Response oauthResponse = oauthRequest.send();

		if (oauthResponse.getCode() == HttpURLConnection.HTTP_OK) {
			JsonParser parser = new JsonParser();
			JsonArray jsonArray = (JsonArray) parser.parse(oauthResponse
					.getBody());

			List<Insurance> insuranceList = new ArrayList<Insurance>();
			Gson gson = new Gson();
			for (int i = 0; i < jsonArray.size(); i++) {
				insuranceList.add(gson.fromJson(jsonArray.get(i),
						Insurance.class));
			}

			return insuranceList;
		} else {
			throw new EndpointException(oauthResponse.getBody());
		}

	}

}
