package com.aetna.carepass.hhs.goodrx;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.List;

import com.aetna.carepass.hhs.connector.RestConnectorService;
import com.aetna.carepass.hhs.connector.RestConnectorServiceImpl;
import com.aetna.carepass.hhs.goodrx.types.DrugPrices;
import com.aetna.carepass.hhs.util.HhsConstants;
import com.aetna.carepass.hhs.util.InvalidCredentialException;
import com.google.gson.Gson;
import com.google.gson.JsonArray;

/**
 * 
 * GoodRX application program interface java endpoitns.
 * 
 */
public class GoodRXApiServiceImpl implements GoodRXApiService {
	

	private final String GOOD_RX_DRUG_PRICES_URL_PREFIX = "https://api.carepass.com/good-rx-api/drugprices/";
	private final String GOOD_RX_DRUG_PRICES_COMPARE_ENDPOINT = "compare";
	private final String GOOD_RX_DRUG_PRICES_LOW_ENDPOINT = "low";

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
	 * {@inheritDoc}
	 */
	public List<DrugPrices> listDrugLowestPrices(String name, String form,
			String dosage, String quantity, String manufacturer, String ndc)
			throws InvalidCredentialException, IOException,
			MalformedURLException {

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
		restConnector.formatUrl(
				GOOD_RX_DRUG_PRICES_URL_PREFIX
						+ GOOD_RX_DRUG_PRICES_COMPARE_ENDPOINT
						+ "?" + parameters + HhsConstants.API_KEY_PARAMETER + "=" + apiKey); //$NON-NLS-1$ //$NON-NLS-2$
		JsonArray drugLowestPricesArray = (JsonArray) restConnector
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
	 *{@inheritDoc}
	 */
	public List<DrugPrices> listDrugComparePrices(String name, String form,
			String dosage, String quantity, String manufacturer, String ndc)
			throws InvalidCredentialException, IOException,
			MalformedURLException {

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

		restConnector.formatUrl(
				GOOD_RX_DRUG_PRICES_URL_PREFIX
						+ GOOD_RX_DRUG_PRICES_LOW_ENDPOINT + "?" + parameters
						+ HhsConstants.API_KEY_PARAMETER + "=" + apiKey); //$NON-NLS-1$ //$NON-NLS-2$
		JsonArray drugLowestPricesArray = (JsonArray) restConnector
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
			throw new InvalidCredentialException(HhsConstants.INVALID_APIs);
		}

	}

}
