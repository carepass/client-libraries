package com.aetna.carepass.goodrx;


import java.io.IOException;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.List;

import com.aetna.carepass.connector.RESTConnector;
import com.aetna.carepass.connector.RequestException;
import com.aetna.carepass.goodrx.types.DrugPrices;
import com.aetna.carepass.util.InvalidCredentialException;
import com.google.gson.Gson;
import com.google.gson.JsonArray;

/**
 * 
 * GoodRX application program interface java endpoitns.
 * 
 */
public class GoodRXAPI {
	private final String API_KEY_PARAMETER = "apikey";
	private static final String INVALID_APIs = "Invalid Credential Specified"; //$NON-NLS-1$

	private final String GOOD_RX_DRUG_PRICES_URL_PREFIX = "https://api.carepass.com/good-rx-api/drugprices/";
	private final String GOOD_RX_DRUG_PRICES_COMPARE_ENDPOINT = "compare";
	private final String GOOD_RX_DRUG_PRICES_LOW_ENDPOINT = "low";

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
	 * @throws RequestException 
	 */
	public List<DrugPrices> listDrugLowestPrices(String name, String form,
			String dosage, String quantity, String manufacturer, String ndc)
			throws InvalidCredentialException, IOException,
			MalformedURLException, RequestException {

		apiKeyAuthorized();

		StringBuilder sb = new StringBuilder();
		if (name != null && !name.trim().isEmpty()) {
			sb.append("name=").append(name).append("&");
		}
		if (form != null && !form.trim().isEmpty()) {
			sb.append("form=").append(form).append("&");
		}
		if (dosage != null && !dosage.trim().isEmpty()) {
			sb.append("dosage=").append(dosage).append("&");
		}
		if (quantity != null && !quantity.trim().isEmpty()) {
			sb.append("quantity=").append(quantity).append("&");
		}

		if (manufacturer != null && !manufacturer.trim().isEmpty()) {
			sb.append("manufacturer=").append(manufacturer).append("&");
		}
		if (ndc != null && !ndc.trim().isEmpty()) {
			sb.append("ndc=").append(ndc).append("&");
		}

		String parameters = sb.toString();
		if (parameters.isEmpty()) {
			throw new IllegalArgumentException(
					"At least one parameter is required");
		}
		if (!parameters.contains("name=") && !parameters.contains("ndc=")) {
			throw new IllegalArgumentException("Name or NDC is required");
		}
		RESTConnector restConnect = new RESTConnector(
				GOOD_RX_DRUG_PRICES_URL_PREFIX
						+ GOOD_RX_DRUG_PRICES_COMPARE_ENDPOINT
						+ "?" + parameters + API_KEY_PARAMETER + "=" + apiKey); //$NON-NLS-1$ //$NON-NLS-2$
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
	 * Retrieves the available price for a prescription medication
	 * 
	 * @param searchParameter
	 *            the drug's parameters
	 * @return List<DrugPrices>
	 * @throws InvalidCredentialException
	 * @throws IOException
	 * @throws MalformedURLException
	 * @throws RequestException 
	 */
	public List<DrugPrices> listDrugComparePrices(String name, String form,
			String dosage, String quantity, String manufacturer, String ndc)
			throws InvalidCredentialException, IOException,
			MalformedURLException, RequestException {

		apiKeyAuthorized();

		StringBuilder sb = new StringBuilder();
		if (name != null && !name.trim().isEmpty()) {
			sb.append("name=").append(name).append("&");
		}
		if (form != null && !form.trim().isEmpty()) {
			sb.append("form=").append(form).append("&");
		}
		if (dosage != null && !dosage.trim().isEmpty()) {
			sb.append("dosage=").append(dosage).append("&");
		}
		if (quantity != null && !quantity.trim().isEmpty()) {
			sb.append("quantity=").append(quantity).append("&");
		}

		if (manufacturer != null && !manufacturer.trim().isEmpty()) {
			sb.append("manufacturer=").append(manufacturer).append("&");
		}
		if (ndc != null && !ndc.trim().isEmpty()) {
			sb.append("ndc=").append(ndc).append("&");
		}

		String parameters = sb.toString();
		if (parameters.isEmpty()) {
			throw new IllegalArgumentException(
					"At least one parameter is required");
		}
		if (!parameters.contains("name=") && !parameters.contains("ndc=")) {
			throw new IllegalArgumentException("Name or NDC is required");
		}
		
		RESTConnector restConnect = new RESTConnector(
				GOOD_RX_DRUG_PRICES_URL_PREFIX
						+ GOOD_RX_DRUG_PRICES_LOW_ENDPOINT +"?"
						+ parameters + API_KEY_PARAMETER
						+ "=" + apiKey); //$NON-NLS-1$ //$NON-NLS-2$
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
