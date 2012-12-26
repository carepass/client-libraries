package com.aetna.carepass.hhs.ecc;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.aetna.carepass.hhs.connector.RestConnectorService;
import com.aetna.carepass.hhs.connector.RestConnectorServiceImpl;
import com.aetna.carepass.hhs.ecc.types.Categories;
import com.aetna.carepass.hhs.ecc.types.CostCareInformation;
import com.aetna.carepass.hhs.ecc.types.Cpt;
import com.aetna.carepass.hhs.util.HhsConstants;
import com.aetna.carepass.hhs.util.InvalidCredentialException;
import com.google.gson.Gson;
import com.google.gson.JsonArray;

@Service
public class EccApiServiceImpl implements EccApiService {

	private final String ECC_URL_PREFIX = "https://api.carepass.com/ecc-directory-api/";
	private final String ECC_MEDICAL_ENDPOINT = "med/";
	private final String ECC_DENTAL_ENDPOINT = "dental/";
	private final String ECC_CATGORIES_ENDPOINT = "categories";

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
	public List<CostCareInformation> listECCMedicalInformation(String cpt,
			String lat, String lng) throws InvalidCredentialException,
			IOException, MalformedURLException {

		apiKeyAuthorized();

		restConnector.formatUrl(ECC_URL_PREFIX + ECC_MEDICAL_ENDPOINT + cpt
				+ "/" + lat + "," + lng + "?" + HhsConstants.API_KEY_PARAMETER
				+ "=" + apiKey);
		JsonArray eccMedicalInformationArry = (JsonArray) restConnector
				.executeQuery();

		List<CostCareInformation> eccMedInformationList = new ArrayList<CostCareInformation>();
		Gson gson = new Gson();

		for (int i = 0; i < eccMedicalInformationArry.size(); i++) {
			eccMedInformationList
					.add(gson.fromJson(eccMedicalInformationArry.get(i),
							CostCareInformation.class));
		}

		return eccMedInformationList;
	}

	/**
	 * {@inheritDoc}
	 */
	public List<CostCareInformation> listECCMedicalInformation(String cpt,
			String zip) throws InvalidCredentialException, IOException,
			MalformedURLException {

		apiKeyAuthorized();

		restConnector
				.formatUrl(ECC_URL_PREFIX
						+ ECC_MEDICAL_ENDPOINT
						+ cpt
						+ "/zip/" + zip + "?" + HhsConstants.API_KEY_PARAMETER + "=" + apiKey); //$NON-NLS-1$ //$NON-NLS-2$
		JsonArray eccMedicalInformationArry = (JsonArray) restConnector
				.executeQuery();

		List<CostCareInformation> eccMedInformationList = new ArrayList<CostCareInformation>();
		Gson gson = new Gson();

		for (int i = 0; i < eccMedicalInformationArry.size(); i++) {
			eccMedInformationList
					.add(gson.fromJson(eccMedicalInformationArry.get(i),
							CostCareInformation.class));
		}

		return eccMedInformationList;
	}

	/**
	 * {@inheritDoc}
	 */
	public List<Cpt> listECCMedCPTCodes() throws InvalidCredentialException,
			IOException, MalformedURLException {

		apiKeyAuthorized();

		restConnector.formatUrl(ECC_URL_PREFIX + ECC_MEDICAL_ENDPOINT
				+ "cpt" + "?" + HhsConstants.API_KEY_PARAMETER + "=" + apiKey); //$NON-NLS-1$ //$NON-NLS-2$
		JsonArray cptCodeArray = (JsonArray) restConnector.executeQuery();

		List<Cpt> cptCodeList = new ArrayList<Cpt>();
		Gson gson = new Gson();

		for (int i = 0; i < cptCodeArray.size(); i++) {
			cptCodeList.add(gson.fromJson(cptCodeArray.get(i), Cpt.class));
		}

		return cptCodeList;
	}

	/**
	 * {@inheritDoc}
	 */
	public List<CostCareInformation> listECCDentalInformation(String cdt,
			String lat, String lng) throws InvalidCredentialException,
			IOException, MalformedURLException {

		apiKeyAuthorized();

		restConnector
				.formatUrl(ECC_URL_PREFIX
						+ ECC_DENTAL_ENDPOINT
						+ cdt
						+ "/" + lat + "," + lng + "?" + HhsConstants.API_KEY_PARAMETER + "=" + apiKey); //$NON-NLS-1$ //$NON-NLS-2$
		JsonArray eccDentalInformationArry = (JsonArray) restConnector
				.executeQuery();

		List<CostCareInformation> eccDentalInformationList = new ArrayList<CostCareInformation>();
		Gson gson = new Gson();

		for (int i = 0; i < eccDentalInformationArry.size(); i++) {
			eccDentalInformationList
					.add(gson.fromJson(eccDentalInformationArry.get(i),
							CostCareInformation.class));
		}

		return eccDentalInformationList;
	}

	/**
	 * {@inheritDoc}
	 */
	public List<CostCareInformation> listECCDentalInformation(String cdt,
			String zip) throws InvalidCredentialException, IOException,
			MalformedURLException {

		apiKeyAuthorized();

		restConnector
				.formatUrl(ECC_URL_PREFIX
						+ ECC_DENTAL_ENDPOINT
						+ cdt
						+ "/zip/" + zip + "?" + HhsConstants.API_KEY_PARAMETER + "=" + apiKey); //$NON-NLS-1$ //$NON-NLS-2$
		JsonArray eccDentalInformationArry = (JsonArray) restConnector
				.executeQuery();

		List<CostCareInformation> eccDentalInformationList = new ArrayList<CostCareInformation>();
		Gson gson = new Gson();

		for (int i = 0; i < eccDentalInformationArry.size(); i++) {
			eccDentalInformationList
					.add(gson.fromJson(eccDentalInformationArry.get(i),
							CostCareInformation.class));
		}

		return eccDentalInformationList;
	}

	/**
	 * {@inheritDoc}
	 */
	public List<Cpt> listECCDentalCPTCodes() throws InvalidCredentialException,
			IOException, MalformedURLException {

		apiKeyAuthorized();

		restConnector.formatUrl(ECC_URL_PREFIX + ECC_DENTAL_ENDPOINT
				+ "cdt" + "?" + HhsConstants.API_KEY_PARAMETER + "=" + apiKey); //$NON-NLS-1$ //$NON-NLS-2$
		JsonArray cptCodeArray = (JsonArray) restConnector.executeQuery();

		List<Cpt> cptCodeList = new ArrayList<Cpt>();
		Gson gson = new Gson();

		for (int i = 0; i < cptCodeArray.size(); i++) {
			cptCodeList.add(gson.fromJson(cptCodeArray.get(i), Cpt.class));
		}

		return cptCodeList;
	}

	/**
	 * {@inheritDoc}
	 */
	public List<Categories> listCategories() throws InvalidCredentialException,
			IOException, MalformedURLException {

		apiKeyAuthorized();

		restConnector.formatUrl(ECC_URL_PREFIX + ECC_CATGORIES_ENDPOINT
				+ "?" + HhsConstants.API_KEY_PARAMETER + "=" + apiKey); //$NON-NLS-1$ //$NON-NLS-2$
		JsonArray categoriesArray = (JsonArray) restConnector.executeQuery();

		List<Categories> categoriesList = new ArrayList<Categories>();
		Gson gson = new Gson();

		for (int i = 0; i < categoriesArray.size(); i++) {
			Categories cat = new Categories();
			cat.setValue(gson.fromJson(categoriesArray.get(i), String.class));
			categoriesList.add(cat);
		}

		return categoriesList;

	}

	/**
	 * {@inheritDoc}
	 */
	public List<Categories> retrieveSubCategories(String category)
			throws InvalidCredentialException, IOException,
			MalformedURLException {

		apiKeyAuthorized();

		if (category == null || category.isEmpty()) {
			category = "";
		}
		restConnector
				.formatUrl(ECC_URL_PREFIX
						+ ECC_CATGORIES_ENDPOINT
						+ "/" + category + "?" + HhsConstants.API_KEY_PARAMETER + "=" + apiKey); //$NON-NLS-1$ //$NON-NLS-2$
		JsonArray categoriesArray = (JsonArray) restConnector.executeQuery();

		List<Categories> categoriesList = new ArrayList<Categories>();
		Gson gson = new Gson();

		for (int i = 0; i < categoriesArray.size(); i++) {
			Categories cat = new Categories();
			cat.setValue(gson.fromJson(categoriesArray.get(i), String.class));
			categoriesList.add(cat);
		}

		return categoriesList;

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
