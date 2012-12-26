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

import com.aetna.carepass.oauth.connector.api.appointment.Appointment;
import com.aetna.carepass.oauth.connector.service.CarePassOAuth;
import com.aetna.carepass.oauth.connector.service.EndpointException;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

@Service
public class AppointmentServiceImpl implements AppointmentService {
	private static final String BASE_URL = "https://api.carepass.com";
	private static final String USER_DIR_API = "/user-directory-api";
	private static final String APPOINTMENT_URI = "/users/currentUser/appointments";
	@Autowired
	private CarePassOAuth carePassOAuth;

	/**
	 * {@inheritDoc}
	 */
	public List<Appointment> findAppointmentById(int id)
			throws EndpointException {

		return scribeOAuthHandle(Verb.GET, APPOINTMENT_URI + "/" + id);

	}

	public List<Appointment> findAppointment(String afterDate,
			String carepassProviderId, String npiProviderId)
			throws EndpointException {

		StringBuilder sb = new StringBuilder();
		if (afterDate != null && !afterDate.isEmpty()) {
			sb.append("afterDate=").append(afterDate).append("&");
		}
		if (carepassProviderId != null && !carepassProviderId.isEmpty()) {
			sb.append("carepassProviderId=").append(carepassProviderId)
					.append("&");
		}
		if (npiProviderId != null && !npiProviderId.isEmpty()) {
			sb.append("ProviderIdValue=").append(npiProviderId).append("&");
		}
		if (sb.toString().isEmpty()) {
			throw new EndpointException("No search parameters given");
		}
		String something = sb.toString();
		something = something.substring(0, something.length() - 1);

		return scribeOAuthHandle(Verb.GET, APPOINTMENT_URI + "?" + something);

	}

	/**
	 * {@inheritDoc}
	 */
	public Appointment saveAppointment(Appointment appointment,
			RequestMethod method) throws EndpointException {

		Gson gson = new Gson();
		String jSon = gson.toJson(appointment).toString();
		Verb verb = null;
		if (RequestMethod.POST == method) {
			verb = Verb.POST;
		} else {
			verb = Verb.PUT;
		}

		return scribeOAuthHandle(verb, APPOINTMENT_URI, jSon);
	}

	/**
	 * Scribe oauth handling
	 * 
	 * @param verb
	 *            the Method for the request
	 * @param uri
	 *            the fragment of the call
	 * @param payload
	 *            if it pass parameters to the request.
	 * @return the Appointment response list
	 * @throws EndpointException
	 */
	private Appointment scribeOAuthHandle(Verb verb, String uri, String payload)
			throws EndpointException {
		if (!carePassOAuth.isAccessTokenReady()) {
			throw new EndpointException("There is not a valid access token");
		}
		OAuthService service = carePassOAuth.getService();
		Token accessToken = carePassOAuth.retrieveOauthToken();
		OAuthRequest oauthRequest = new OAuthRequest(verb, BASE_URL
				+ USER_DIR_API + uri);

		oauthRequest.addPayload(payload);

		oauthRequest.addHeader("Accept", "application/json");
		oauthRequest.addHeader("Content-Type",
				"application/json; charset=utf-8");
		service.signRequest(accessToken, oauthRequest);
		return parseResponseSave(oauthRequest.send());
	}

	private List<Appointment> scribeOAuthHandle(Verb verb, String uri)
			throws EndpointException {
		if (!carePassOAuth.isAccessTokenReady()) {
			throw new EndpointException("There is not a valid access token");
		}

		Token accessToken = carePassOAuth.retrieveOauthToken();
		OAuthRequest oauthRequest = new OAuthRequest(verb, BASE_URL
				+ USER_DIR_API + uri);

		oauthRequest.addHeader("Accept", "application/json");
		oauthRequest.addHeader("Content-Type",
				"application/json; charset=utf-8");
		oauthRequest.addHeader("Authorization","Bearer "+ accessToken.getToken());

		return parseResponseGet(oauthRequest.send());
	}

	/**
	 * Parses the response to an Appointment.
	 * 
	 * @param oauthResponse
	 *            the server response after the oauth request
	 * @return the Appointment response
	 * @throws EndpointException
	 * 
	 */
	private Appointment parseResponseSave(Response oauthResponse)
			throws EndpointException {
		if (oauthResponse.getCode() == HttpURLConnection.HTTP_OK) {
			JsonParser parser = new JsonParser();
			JsonElement jsonElement = parser.parse(oauthResponse.getBody());

			Gson gson = new Gson();
			return gson.fromJson(jsonElement, Appointment.class);
		} else {
			throw new EndpointException("Error code #"
					+ oauthResponse.getCode() + " has occurred");
		}
	}

	/**
	 * Parses the response to an Appointment list for get request.
	 * 
	 * @param oauthResponse
	 *            the server response after the oauth request
	 * @return the Appointment response list
	 * @throws EndpointException
	 * 
	 */
	private List<Appointment> parseResponseGet(Response oauthResponse)
			throws EndpointException {
		if (oauthResponse.getCode() == HttpURLConnection.HTTP_OK) {
			JsonParser parser = new JsonParser();
			JsonArray jsonArray = (JsonArray) parser.parse(oauthResponse
					.getBody());

			List<Appointment> appointmentList = new ArrayList<Appointment>();

			Gson gson = new Gson();

			for (int i = 0; i < jsonArray.size(); i++) {
				appointmentList.add(gson.fromJson(jsonArray.get(i),
						Appointment.class));
			}

			return appointmentList;
		} else {
			throw new EndpointException(oauthResponse.getBody());
		}
	}
}
