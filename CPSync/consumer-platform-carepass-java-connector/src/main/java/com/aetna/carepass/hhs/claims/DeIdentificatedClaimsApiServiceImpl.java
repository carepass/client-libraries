package com.aetna.carepass.hhs.claims;

import java.io.IOException;
import java.net.MalformedURLException;

import com.aetna.carepass.hhs.claims.types.DeIdentificatedClaimsSearch;
import com.aetna.carepass.hhs.connector.RestConnectorService;
import com.aetna.carepass.hhs.connector.RestConnectorServiceImpl;
import com.aetna.carepass.hhs.util.HhsConstants;
import com.aetna.carepass.hhs.util.InvalidCredentialException;
import com.google.gson.Gson;
import com.google.gson.JsonElement;

public class DeIdentificatedClaimsApiServiceImpl implements DeIdentificatedClaimsApiService {

	public static final String CLAIMS_URL_PREFIX = "https://api.carepass.com/claims-directory-api/claims/";

	private final RestConnectorService restConnector = new RestConnectorServiceImpl();

	private String apiKey;
	/***
	 * Retrieve current api key that was specified
	 * 
	 * @return apiKey
	 */
	public String getApiKey() {
		return apiKey;
	}

	public void setApiKey(String apiKey) {
		this.apiKey = apiKey;
	}

	
	/**
	 *{@inheritDoc}
	 */
	public DeIdentificatedClaimsSearch searchDeIdentificatedClaims(String ndc,
			String gender, Integer birthyearfrom, Integer birthyearto,
			String from, String to, Integer page)
			throws InvalidCredentialException, IOException,
			MalformedURLException, IllegalArgumentException {

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
		restConnector.formatUrl(CLAIMS_URL_PREFIX + "search?" + parameters
				+ HhsConstants.API_KEY_PARAMETER + "=" + apiKey);

		JsonElement diClaimsElements = restConnector.executeQuery();

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
			throw new InvalidCredentialException(HhsConstants.INVALID_APIs);
		}

	}

}
