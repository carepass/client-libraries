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
import org.springframework.web.bind.annotation.RequestMethod;

import com.aetna.carepass.oauth.connector.api.fitness.Fitness;
import com.aetna.carepass.oauth.connector.service.CarePassOAuth;
import com.aetna.carepass.oauth.connector.service.EndpointException;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

@Service
public class FitnessServiceImpl implements FitnessService {

	private static final String BASE_URL = "https://api.carepass.com";
	private static final String USER_DIR_API = "/user-directory-api";
	@Autowired
	private CarePassOAuth carePassOAuth;

	/**
	 * {@inheritDoc}
	 */
	public String getFitnessTypes()throws EndpointException{
		if (!carePassOAuth.isAccessTokenReady()) {
			throw new EndpointException("There is not a valid access token");
		}
		OAuthService service = carePassOAuth.getService();
		Token accessToken = carePassOAuth.retrieveOauthToken();
		OAuthRequest oauthRequest = new OAuthRequest(Verb.GET, BASE_URL
				+ USER_DIR_API + "/fitness/activities/types");

		oauthRequest.addHeader("Accept", "application/json");
		oauthRequest.addHeader("Content-Type",
				"application/json; charset=utf-8");
		service.signRequest(accessToken, oauthRequest);
		Response oauthResponse = oauthRequest.send();

		if (oauthResponse.getCode() == HttpURLConnection.HTTP_OK) {
			JsonParser parser = new JsonParser();
			JsonElement element = parser.parse(oauthResponse.getBody());
			if(element instanceof JsonArray){
				return ((JsonArray)element).toString();
			}

		} 
			throw new EndpointException(oauthResponse.getBody());

	}
	/**
	 * {@inheritDoc}
	 */
	public Fitness findFitnessById(int id) throws EndpointException {
		if (!carePassOAuth.isAccessTokenReady()) {
			throw new EndpointException("There is not a valid access token");
		}
		OAuthService service = carePassOAuth.getService();
		Token accessToken = carePassOAuth.retrieveOauthToken();
		OAuthRequest oauthRequest = new OAuthRequest(Verb.GET, BASE_URL
				+ USER_DIR_API + "/users/currentUser/fitness/activities" + "/"
				+ id);

		oauthRequest.addHeader("Accept", "application/json");
		oauthRequest.addHeader("Content-Type",
				"application/json; charset=utf-8");
		service.signRequest(accessToken, oauthRequest);
		Response oauthResponse = oauthRequest.send();

		if (oauthResponse.getCode() == HttpURLConnection.HTTP_OK) {
			JsonParser parser = new JsonParser();
			JsonElement element = parser.parse(oauthResponse.getBody());

			Gson gson = new Gson();
			return gson.fromJson(element, Fitness.class);
		} else {
			throw new EndpointException(oauthResponse.getBody());
		}

	}

	/**
	 * {@inheritDoc}
	 */
	public List<Fitness> findFitnessByDate(String dateFrom, String dateTo)
			throws EndpointException {
		if (!carePassOAuth.isAccessTokenReady()) {
			throw new EndpointException("There is not a valid access token");
		}
		OAuthService service = carePassOAuth.getService();
		Token accessToken = carePassOAuth.retrieveOauthToken();
		OAuthRequest oauthRequest = new OAuthRequest(Verb.GET, BASE_URL
				+ USER_DIR_API + "/users/currentUser/fitness/activities"
				+ "?dateFrom=" + dateFrom + "&dateTo=" + dateTo);

		oauthRequest.addHeader("Accept", "application/json");
		oauthRequest.addHeader("Content-Type",
				"application/json; charset=utf-8");
		service.signRequest(accessToken, oauthRequest);
		Response oauthResponse = oauthRequest.send();

		if (oauthResponse.getCode() == HttpURLConnection.HTTP_OK) {
			JsonParser parser = new JsonParser();
			JsonArray jsonArray = (JsonArray) parser.parse(oauthResponse
					.getBody());

			List<Fitness> fitnessList = new ArrayList<Fitness>();

			Gson gson = new Gson();

			for (int i = 0; i < jsonArray.size(); i++) {
				fitnessList.add(gson.fromJson(jsonArray.get(i), Fitness.class));
			}

			return fitnessList;
		} else {
			throw new EndpointException(oauthResponse.getBody());
		}
	}

	/**
	 * {@inheritDoc}
	 */
	public List<Fitness> saveFitness(List<Fitness> fitness, RequestMethod method)
			throws EndpointException {
		if (!carePassOAuth.isAccessTokenReady()) {
			throw new EndpointException("There is not a valid access token");
		}
		OAuthService service = carePassOAuth.getService();
		Token accessToken = carePassOAuth.retrieveOauthToken();

		Gson gson = new Gson();
		String jSon = gson.toJson(fitness).toString();
		Verb verb = null;
		if (RequestMethod.POST == method) {
			verb = Verb.POST;
			
			//removing id
			jSon = "[{"+jSon.substring(jSon.indexOf(",") + 1);
		} else {
			verb = Verb.PUT;
		}

		OAuthRequest oauthRequest = new OAuthRequest(verb, BASE_URL + USER_DIR_API
				+ "/users/currentUser/fitness/activities");

		oauthRequest.addPayload(jSon);
		oauthRequest.addHeader("Accept", "application/json");
		oauthRequest.addHeader("Content-Type",
				"application/json; charset=utf-8");
		service.signRequest(accessToken, oauthRequest);
		Response oauthResponse = oauthRequest.send();

		if (oauthResponse.getCode() == HttpURLConnection.HTTP_OK) {
			JsonParser parser = new JsonParser();
			JsonArray jsonArray = (JsonArray) parser.parse(oauthResponse
					.getBody());

			List<Fitness> fitnessList = new ArrayList<Fitness>();

			for (int i = 0; i < jsonArray.size(); i++) {
				fitnessList.add(gson.fromJson(jsonArray.get(i), Fitness.class));
			}

			return fitnessList;
		} else {
			throw new EndpointException("Error code #"
					+ oauthResponse.getCode() + " has occurred\r\n"+oauthResponse.getBody());
		}
	}

}
