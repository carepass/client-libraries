package com.aetna.carepass.ecc;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.List;

import com.aetna.carepass.connector.RESTConnector;
import com.aetna.carepass.ecc.types.Categories;
import com.aetna.carepass.ecc.types.CostCareInformation;
import com.aetna.carepass.ecc.types.Cpt;
import com.aetna.carepass.util.InvalidCredentialException;
import com.aetna.carepass.util.Messages;
import com.google.gson.Gson;
import com.google.gson.JsonArray;

public class ECCApi {
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
	public ECCApi(String apiKey) {
		this.apiKey = apiKey;
	}

	/**
	 * Retrieve the Medical Estimated Cost of Care Information based on the CPT,
	 * LAT, LNG
	 * 
	 * @param cpt
	 *            Current procedural terminology code
	 * @param lat
	 *            Degrees latitude
	 * @param lng
	 *            Degrees longitude
	 * @return List<CostCareInformation>
	 * @throws InvalidCredentialException
	 * @throws IOException
	 * @throws MalformedURLException
	 */
	public List<CostCareInformation> listECCMedicalInformation(String cpt,
			String lat, String lng) throws InvalidCredentialException,
			IOException, MalformedURLException {

		apiKeyAuthorized();

		RESTConnector restConnect = new RESTConnector(
				Messages.getString("ECC_URL_Prefix") + Messages.getString("ECC_Medical") + cpt + "/" + lat + "," + lng + "?" + apikeyParam + "=" + apiKey); //$NON-NLS-1$ //$NON-NLS-2$
		JsonArray eccMedicalInformationArry = (JsonArray) restConnect
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
	 * Retrieve the Medical Estimated Cost of Care Information based on the CPT,
	 * ZIP
	 * 
	 * @param cpt
	 *            Current procedural terminology code
	 * @param zip
	 *            the Zip code
	 * @return List<CostCareInformation>
	 * @throws InvalidCredentialException
	 * @throws IOException
	 * @throws MalformedURLException
	 */
	public List<CostCareInformation> listECCMedicalInformation(String cpt,
			String zip) throws InvalidCredentialException, IOException,
			MalformedURLException {

		apiKeyAuthorized();

		RESTConnector restConnect = new RESTConnector(
				Messages.getString("ECC_URL_Prefix") + Messages.getString("ECC_Medical") + cpt + "/zip/" + zip + "?" + apikeyParam + "=" + apiKey); //$NON-NLS-1$ //$NON-NLS-2$
		JsonArray eccMedicalInformationArry = (JsonArray) restConnect
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
	 * Retrieve a list of all Medical's CPT codes with your short and long
	 * description
	 * 
	 * @return List<Cpt> listECCCPTCodes()
	 * @throws InvalidCredentialException
	 * @throws IOException
	 * @throws MalformedURLException
	 */
	public List<Cpt> listECCMedCPTCodes() throws InvalidCredentialException,
			IOException, MalformedURLException {

		apiKeyAuthorized();

		RESTConnector restConnect = new RESTConnector(
				Messages.getString("ECC_URL_Prefix") + Messages.getString("ECC_Medical") + "cpt" + "?" + apikeyParam + "=" + apiKey); //$NON-NLS-1$ //$NON-NLS-2$
		JsonArray cptCodeArray = (JsonArray) restConnect.executeQuery();

		List<Cpt> cptCodeList = new ArrayList<Cpt>();
		Gson gson = new Gson();

		for (int i = 0; i < cptCodeArray.size(); i++) {
			cptCodeList.add(gson.fromJson(cptCodeArray.get(i), Cpt.class));
		}

		return cptCodeList;
	}

	/**
	 * Retrieve the Dental Estimated Cost of Care Information based on the CPT,
	 * LAT, LNG
	 * 
	 * @param cdt
	 *            Current dental terminology code
	 * @param lat
	 *            Degrees latitude
	 * @param lng
	 *            Degrees longitude
	 * @return List<CostCareInformation>
	 * @throws InvalidCredentialException
	 * @throws IOException
	 * @throws MalformedURLException
	 */
	public List<CostCareInformation> listECCDentalInformation(String cdt,
			String lat, String lng) throws InvalidCredentialException,
			IOException, MalformedURLException {

		apiKeyAuthorized();

		RESTConnector restConnect = new RESTConnector(
				Messages.getString("ECC_URL_Prefix") + Messages.getString("ECC_Dental") + cdt + "/" + lat + "," + lng + "?" + apikeyParam + "=" + apiKey); //$NON-NLS-1$ //$NON-NLS-2$
		JsonArray eccDentalInformationArry = (JsonArray) restConnect
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
	 * Retrieve the Dental Estimated Cost of Care Information based on the CPT,
	 * ZIP
	 * 
	 * @param cdt
	 *            Current dental terminology code
	 * @param zip
	 *            the Zip code
	 * @return List<CostCareInformation>
	 * @throws InvalidCredentialException
	 * @throws IOException
	 * @throws MalformedURLException
	 */
	public List<CostCareInformation> listECCDentalInformation(String cdt,
			String zip) throws InvalidCredentialException, IOException,
			MalformedURLException {

		apiKeyAuthorized();

		RESTConnector restConnect = new RESTConnector(
				Messages.getString("ECC_URL_Prefix") + Messages.getString("ECC_Dental") + cdt + "/zip/" + zip + "?" + apikeyParam + "=" + apiKey); //$NON-NLS-1$ //$NON-NLS-2$
		JsonArray eccDentalInformationArry = (JsonArray) restConnect
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
	 * Retrieve a list of all Dental's CPT codes with your short and long
	 * description
	 * 
	 * @return List<Cpt> listECCCPTCodes()
	 * @throws InvalidCredentialException
	 * @throws IOException
	 * @throws MalformedURLException
	 */
	public List<Cpt> listECCDentalCPTCodes() throws InvalidCredentialException,
			IOException, MalformedURLException {

		apiKeyAuthorized();

		RESTConnector restConnect = new RESTConnector(
				Messages.getString("ECC_URL_Prefix") + Messages.getString("ECC_Dental") + "cdt" + "?" + apikeyParam + "=" + apiKey); //$NON-NLS-1$ //$NON-NLS-2$
		JsonArray cptCodeArray = (JsonArray) restConnect.executeQuery();

		List<Cpt> cptCodeList = new ArrayList<Cpt>();
		Gson gson = new Gson();

		for (int i = 0; i < cptCodeArray.size(); i++) {
			cptCodeList.add(gson.fromJson(cptCodeArray.get(i), Cpt.class));
		}

		return cptCodeList;
	}

	/**
	 * Retrieve list of catergories
	 * 
	 * @return List<Categories>
	 * @throws InvalidCredentialException
	 * @throws IOException
	 * @throws MalformedURLException
	 */
	public List<Categories> listCategories() throws InvalidCredentialException,
			IOException, MalformedURLException {

		apiKeyAuthorized();

		RESTConnector restConnect = new RESTConnector(
				Messages.getString("ECC_URL_Prefix") + Messages.getString("ECC_Categories") + "?" + apikeyParam + "=" + apiKey); //$NON-NLS-1$ //$NON-NLS-2$
		JsonArray categoriesArray = (JsonArray) restConnect.executeQuery();

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
	 * Retrieve list of subcategories
	 * 
	 * @param category
	 *            the Category name
	 * @return List<Categories>
	 * @throws InvalidCredentialException
	 * @throws IOException
	 * @throws MalformedURLException
	 */
	public List<Categories> retrieveSubCategories(String category)
			throws InvalidCredentialException, IOException,
			MalformedURLException {

		apiKeyAuthorized();
		
		if (category == null || category.isEmpty()) {
			category = "";
		}
		RESTConnector restConnect = new RESTConnector(
				Messages.getString("ECC_URL_Prefix") + Messages.getString("ECC_Categories") + "/" + category + "?" + apikeyParam + "=" + apiKey); //$NON-NLS-1$ //$NON-NLS-2$
		JsonArray categoriesArray = (JsonArray) restConnect.executeQuery();

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
			throw new InvalidCredentialException(INVALID_APIs);
		}

	}

}
