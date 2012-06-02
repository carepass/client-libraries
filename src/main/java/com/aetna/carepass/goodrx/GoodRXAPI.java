package com.aetna.carepass.goodrx;


import java.io.IOException;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.aetna.carepass.connector.RESTConnector;
import com.aetna.carepass.goodrx.types.DrugPrices;
import com.aetna.carepass.util.InvalidCredentialException;
import com.aetna.carepass.util.Messages;
import com.google.gson.Gson;
import com.google.gson.JsonArray;

/**
 * 
 * GoodRX application program interface java endpoitns.
 * 
 */
public class GoodRXAPI {
	private String apikeyParam = Messages.getString("API_KEY");
	private String apiKey;
	private static final String INVALID_APIs = Messages
			.getString("HHS_Excep_InvalidCred"); //$NON-NLS-1$

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
	public GoodRXAPI(String apiKey) {
		this.apiKey = apiKey;
	}

	/**
	 * Retrieves the lowest available price for a prescription medication
	 * 
	 * @param searchParameter
	 *            the drug's parameters
	 * @return List<DrugPrices>
	 * @throws InvalidCredentialException
	 * @throws IOException
	 * @throws MalformedURLException
	 */
	public List<DrugPrices> listDrugLowestPrices(Map<String,String> searchParameter)
			throws InvalidCredentialException, IOException,
			MalformedURLException {

		apiKeyAuthorized();

		RESTConnector restConnect = new RESTConnector(
				Messages.getString("GoodRX_Drug_Prices_Low_URL_Prefix") + searchParsing(searchParameter) + apikeyParam + "=" + apiKey); //$NON-NLS-1$ //$NON-NLS-2$
		JsonArray drugLowestPricesArray = (JsonArray) restConnect
				.executeQuery();
		
		List<DrugPrices> drugLowerPricesList = new ArrayList<DrugPrices>();

		Gson gson = new Gson();
        System.err.println(drugLowestPricesArray);
		for (int i = 0; i < drugLowestPricesArray.size(); i++) {
			drugLowerPricesList.add(gson.fromJson(drugLowestPricesArray.get(i),
					DrugPrices.class));
		}

		return drugLowerPricesList;

	}

	/**
	 * Retrieves the available price for a prescription medication
	 * 
	 * @param searchParameter
	 *            the drug's parameters
	 * @return List<DrugPrices>
	 * @throws InvalidCredentialException
	 * @throws IOException
	 * @throws MalformedURLException
	 */
	public List<DrugPrices> listDrugComparePrices(
			Map<String, String> searchParameters)
			throws InvalidCredentialException, IOException,
			MalformedURLException {

		apiKeyAuthorized();

		RESTConnector restConnect = new RESTConnector(
				Messages.getString("GoodRX_Drug_Prices_Compare_URL_Prefix") +  searchParsing(searchParameters) + apikeyParam + "=" + apiKey); //$NON-NLS-1$ //$NON-NLS-2$
		JsonArray drugLowestPricesArray = (JsonArray) restConnect
				.executeQuery();
		List<DrugPrices> drugLowerPricesList = new ArrayList<DrugPrices>();

		Gson gson = new Gson();

		for (int i = 0; i < drugLowestPricesArray.size(); i++) {
			drugLowerPricesList.add(gson.fromJson(drugLowestPricesArray.get(i),
					DrugPrices.class));
		}

		return drugLowerPricesList;

	}

	/**
	 * Common search URL fragment builder
	 * 
	 * @param searchParameter
	 *            . The values are represented in a map where the parameter is
	 *            the key and parameter's value is the value
	 * @return the search URL fragment
	 */
	private String searchParsing(Map<String, String> searchParameter) {
		if (searchParameter == null || searchParameter.isEmpty()) {
			throw new IllegalArgumentException("The are no parameters");
		}
		if (!searchParameter.containsKey("name")
				&& !searchParameter.containsKey("ndc")) {
			throw new IllegalArgumentException(
					"The parameters should include name or ndc");
		}
		StringBuilder sb = new StringBuilder();
		sb.append("?");
		for (Map.Entry<String, String> entry : searchParameter.entrySet()) {
			sb.append(entry.getKey()).append("=").append(entry.getValue())
					.append("&");
		}
		return sb.toString();
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
