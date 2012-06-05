package com.aetna.carepass.claims;

import java.io.IOException;
import java.net.MalformedURLException;

import com.aetna.carepass.claims.types.DeIdentificatedClaimsSearch;
import com.aetna.carepass.connector.RESTConnector;
import com.aetna.carepass.util.InvalidCredentialException;
import com.google.gson.Gson;
import com.google.gson.JsonElement;

public class DeIdentificatedClaimsAPI {

	private final String API_KEY_PARAMETER = "apikey";
	private final String INVALID_APIs = "Invalid Credential Specified"; //$NON-NLS-1$
	private final String CLAIMS_URL_PREFIX = "https://api.carepass.com/claims-directory-api/claims/";

	private String apiKey;

	/***
	 * Retrieve current api key that was specified
	 * 
	 * @return apiKey
	 */
	public String getApiKey() {
		return apiKey;
	}

	/***
	 * @param apiKey
	 *            the API key
	 */
	public DeIdentificatedClaimsAPI(String apiKey) {
		this.apiKey = apiKey;
	}

	/**
	 * Retrieves claims data 
	 * 
	 * @param ndc National Drug Code Directory of 2 or 3 segments separated by
	 * @param gender Gender of a member.
	 * @param birthyearfrom Range start of birth year of a member.
	 * @param birthyearto Range end of birth year of a member.
	 * @param from Start date to search claims.
	 * @param to End date to search claims.
	 * @param page Number of page. (Each page contains 500 results)
	 * @return DeIdentificatedClaimsSearch
	 * @throws InvalidCredentialException
	 * @throws IOException
	 * @throws MalformedURLException
	 */
	public DeIdentificatedClaimsSearch searchDeIdentificatedClaims(String ndc,
			String gender, Integer birthyearfrom, Integer birthyearto,
			String from, String to, Integer page)
			throws InvalidCredentialException, IOException,
			MalformedURLException {

		apiKeyAuthorized();

		StringBuilder sb = new StringBuilder();
		if (ndc != null && !ndc.trim().isEmpty()) {
			sb.append("ndc=").append(ndc).append("&");
		}
		if (gender != null && !gender.trim().isEmpty()) {
			sb.append("gender=").append(gender).append("&");
		}
		if (birthyearfrom != null) {
			sb.append("birthyearfrom=").append(birthyearfrom).append("&");
		}
		if (birthyearto != null) {
			sb.append("birthyearto=").append(birthyearto).append("&");
		}
		if (from != null && !from.trim().isEmpty()) {
			sb.append("from=").append(from).append("&");
		}
		if (to != null && !to.trim().isEmpty()) {
			sb.append("to=").append(to).append("&");
		}
		if (page != null) {
			sb.append("page=").append(page).append("&");
		}

		String parameters = sb.toString();
		if (parameters.isEmpty()) {
			throw new IllegalArgumentException(
					"At leat one parameter is required");
		}
		RESTConnector restConnect = new RESTConnector(CLAIMS_URL_PREFIX
				+ "search?" + parameters + API_KEY_PARAMETER + "=" + apiKey); //$NON-NLS-1$ //$NON-NLS-2$
		JsonElement diClaimsElements = restConnect.executeQuery();

		Gson gson = new Gson();

		return gson.fromJson(diClaimsElements,
				DeIdentificatedClaimsSearch.class);

	}	

	/***
	 * Validates that the apiKey specified is able access the resources
	 * 
	 * @throws InvalidCredentialException
	 */
	private void apiKeyAuthorized() throws InvalidCredentialException {

		if (getApiKey() == null || getApiKey().isEmpty()) {
			throw new InvalidCredentialException(INVALID_APIs);
		}

	}

}
