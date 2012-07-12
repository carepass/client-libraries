package com.aetna.carepass.hhs.hhsapi;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.List;

import com.aetna.carepass.hhs.connector.RestConnectorService;
import com.aetna.carepass.hhs.connector.RestConnectorServiceImpl;
import com.aetna.carepass.hhs.hhsapi.types.ART;
import com.aetna.carepass.hhs.hhsapi.types.Alternative;
import com.aetna.carepass.hhs.hhsapi.types.ClinicalTrialsNCTID;
import com.aetna.carepass.hhs.hhsapi.types.ClinicalTrialsSearch;
import com.aetna.carepass.hhs.hhsapi.types.Document;
import com.aetna.carepass.hhs.hhsapi.types.DrugImage;
import com.aetna.carepass.hhs.hhsapi.types.DrugNDC;
import com.aetna.carepass.hhs.hhsapi.types.DrugPackageInfo;
import com.aetna.carepass.hhs.hhsapi.types.DrugResource;
import com.aetna.carepass.hhs.hhsapi.types.DrugSearch;
import com.aetna.carepass.hhs.hhsapi.types.FDARecallSearch;
import com.aetna.carepass.hhs.hhsapi.types.Nda;
import com.aetna.carepass.hhs.util.HhsConstants;
import com.aetna.carepass.hhs.util.InvalidCredentialException;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;

/**
 * 
 * HHS application program interface java endpoitns.
 * 
 */
public class HhsApiServiceImpl implements HhsApiService {

	private final String HHS_URL_PREFIX = "https://api.carepass.com/hhs-directory-api/";
	private final String HHS_APPLICATION_API = "applications/";
	private final String HHS_DRUGS_API = "drugs/";
	private final String HHS_ART_API = "art/";
	private final String HHS_CLINICAL_TRIALS_API = "clinicaltrials/";
	private final String HHS_FDA_RECALLS_API = "fdarecalls/";

	private final String HHS_DOCUMENT_ENDPOINT = "/documents";
	private final String HHS_DRUGS_ALTERNATIVES_ENDPOINT = "/alternatives";
	private final String HHS_DRUGS_RESOURCES_ENDPOINT = "/drugsresources";
	private final String HHS_DRUGS_IMAGES_ENDPOINT = "/images";
	private final String HHS_DRUGS_PACKAGE_ENDPOINT = "/packages/";

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
	public List<Document> getDocuments(String nda)
			throws InvalidCredentialException, IOException,
			MalformedURLException {

		apiKeyAuthorized();

		restConnector.formatUrl(HHS_URL_PREFIX + HHS_APPLICATION_API + nda
				+ HHS_DOCUMENT_ENDPOINT
				+ "?" + HhsConstants.API_KEY_PARAMETER + "=" + apiKey); //$NON-NLS-1$ //$NON-NLS-2$
		JsonArray documentArray = (JsonArray) restConnector.executeQuery();

		List<Document> documentList = new ArrayList<Document>();
		Gson gson = new Gson();

		for (int i = 0; i < documentArray.size(); i++) {
			documentList
					.add(gson.fromJson(documentArray.get(i), Document.class));
		}

		return documentList;
	}

	/***
	 * {@inheritDoc}
	 */

	public List<Nda> getAllNDA(String nda) throws InvalidCredentialException,
			IOException, MalformedURLException {

		apiKeyAuthorized();

		restConnector.formatUrl(HHS_URL_PREFIX + HHS_APPLICATION_API + nda
				+ "?" + HhsConstants.API_KEY_PARAMETER + "=" + apiKey); //$NON-NLS-1$ //$NON-NLS-2$
		JsonArray ndaResArray = (JsonArray) restConnector.executeQuery();
		List<Nda> ndaResourceList = new ArrayList<Nda>();

		Gson gson = new Gson();
		for (int i = 0; i < ndaResArray.size(); i++) {
			ndaResourceList.add(gson.fromJson(ndaResArray.get(i), Nda.class));
		}

		return ndaResourceList;

	}

	/**
	 * {@inheritDoc}
	 */
	public List<Alternative> getAllAlternatives(String nda)
			throws InvalidCredentialException, IOException,
			MalformedURLException {

		apiKeyAuthorized();
		restConnector.formatUrl(HHS_URL_PREFIX + HHS_APPLICATION_API + nda
				+ HHS_DRUGS_ALTERNATIVES_ENDPOINT
				+ "?" + HhsConstants.API_KEY_PARAMETER + "=" + apiKey); //$NON-NLS-1$ //$NON-NLS-2$
		JsonArray ndaResArray = (JsonArray) restConnector.executeQuery();
		List<Alternative> ndaAlternativesList = new ArrayList<Alternative>();

		Gson gson = new Gson();

		for (int i = 0; i < ndaResArray.size(); i++) {
			ndaAlternativesList.add(gson.fromJson(ndaResArray.get(i),
					Alternative.class));
		}

		return ndaAlternativesList;

	}

	/**
	 *{@inheritDoc}
	 */
	public List<DrugSearch> listDrugs(String drugName)
			throws InvalidCredentialException, IOException,
			MalformedURLException {

		apiKeyAuthorized();

		restConnector
				.formatUrl(HHS_URL_PREFIX
						+ HHS_APPLICATION_API
						+ "search?name=" + drugName + "&" + HhsConstants.API_KEY_PARAMETER + "=" + apiKey); //$NON-NLS-1$ //$NON-NLS-2$
		JsonArray drugsArray = (JsonArray) restConnector.executeQuery();

		List<DrugSearch> drugsList = new ArrayList<DrugSearch>();

		Gson gson = new Gson();

		for (int i = 0; i < drugsArray.size(); i++) {
			drugsList.add(gson.fromJson(drugsArray.get(i), DrugSearch.class));
		}

		return drugsList;
	}

	/***
	 * {@inheritDoc}
	 */
	public List<DrugResource> listDrugResources(String nda)
			throws InvalidCredentialException, IOException,
			MalformedURLException {

		apiKeyAuthorized();

		restConnector.formatUrl(HHS_URL_PREFIX + HHS_APPLICATION_API + nda
				+ HHS_DRUGS_RESOURCES_ENDPOINT
				+ "?" + HhsConstants.API_KEY_PARAMETER + "=" + apiKey); //$NON-NLS-1$ //$NON-NLS-2$
		JsonArray drugResArray = (JsonArray) restConnector.executeQuery();

		List<DrugResource> drugResourceList = new ArrayList<DrugResource>();

		Gson gson = new Gson();

		for (int i = 0; i < drugResArray.size(); i++) {
			drugResourceList.add(new DrugResource(gson.fromJson(
					drugResArray.get(i), String.class)));
		}

		return drugResourceList;
	}

	/**
	 * {@inheritDoc}
	 */
	public List<DrugImage> getAllDrugImages(String ndc2)
			throws InvalidCredentialException, IOException,
			MalformedURLException {

		apiKeyAuthorized();
		ndcValidation(ndc2);
		restConnector.formatUrl(HHS_URL_PREFIX + HHS_DRUGS_API + ndc2
				+ HHS_DRUGS_IMAGES_ENDPOINT
				+ "?" + HhsConstants.API_KEY_PARAMETER + "=" + apiKey); //$NON-NLS-1$ //$NON-NLS-2$
		JsonArray ndaResArray = (JsonArray) restConnector.executeQuery();
		List<DrugImage> drugImagesList = new ArrayList<DrugImage>();

		Gson gson = new Gson();

		for (int i = 0; i < ndaResArray.size(); i++) {
			DrugImage di = new DrugImage();
			di.setImgURL(gson.fromJson(ndaResArray.get(i), String.class));
			drugImagesList.add(di);
		}

		return drugImagesList;
	}

	/**
	 * {@inheritDoc}
	 */
	public List<DrugNDC> getAllDrugByNDC(String ndc2)
			throws InvalidCredentialException, IOException,
			MalformedURLException {

		apiKeyAuthorized();
		ndcValidation(ndc2);

		restConnector.formatUrl(HHS_URL_PREFIX + HHS_DRUGS_API + ndc2
				+ "?" + HhsConstants.API_KEY_PARAMETER + "=" + apiKey); //$NON-NLS-1$ //$NON-NLS-2$
		JsonArray ndaResArray = (JsonArray) restConnector.executeQuery();
		List<DrugNDC> drugNDCList = new ArrayList<DrugNDC>();
		Gson gson = new Gson();
		for (int i = 0; i < ndaResArray.size(); i++) {
			drugNDCList.add(gson.fromJson(ndaResArray.get(i), DrugNDC.class));
		}

		return drugNDCList;
	}

	/**
	 * {@inheritDoc}
	 */
	public List<DrugPackageInfo> getAllDrugPackageInfo(String ndc2, String ndc3)
			throws InvalidCredentialException, IOException,
			MalformedURLException {

		apiKeyAuthorized();
		ndcValidation(ndc2);
		ndcValidation(ndc3);

		restConnector.formatUrl(HHS_URL_PREFIX + HHS_DRUGS_API + ndc2
				+ HHS_DRUGS_PACKAGE_ENDPOINT + ndc3
				+ "?" + HhsConstants.API_KEY_PARAMETER + "=" + apiKey); //$NON-NLS-1$ //$NON-NLS-2$
		JsonArray ndaResArray = (JsonArray) restConnector.executeQuery();
		List<DrugPackageInfo> drugPackageInfo = new ArrayList<DrugPackageInfo>();
		Gson gson = new Gson();

		for (int i = 0; i < ndaResArray.size(); i++) {
			drugPackageInfo.add(gson.fromJson(ndaResArray.get(i),
					DrugPackageInfo.class));
		}

		return drugPackageInfo;
	}

	/**
	 * {@inheritDoc}
	 */
	public List<ART> listARTs(String clinicName, String city, String state,
			String medicaldirector, String year, boolean exactMatch)
			throws InvalidCredentialException, IOException,
			MalformedURLException {

		apiKeyAuthorized();

		StringBuilder sb = new StringBuilder();

		if (clinicName != null && !clinicName.trim().isEmpty()) {
			sb.append("clinicname=").append(clinicName).append("&");
		}
		if (city != null && !city.trim().isEmpty()) {
			sb.append("city=").append(city).append("&");
		}
		if (state != null && !state.trim().isEmpty()) {
			sb.append("state=").append(state).append("&");
		}
		if (medicaldirector != null && !medicaldirector.trim().isEmpty()) {
			sb.append("medicaldirector=").append(medicaldirector).append("&");
		}
		if (year != null && !year.trim().isEmpty()) {
			sb.append("year=").append(year).append("&");
		}
		if (sb.toString().isEmpty()) {
			throw new IllegalArgumentException(
					"At least one parameter is required");
		}
		if (exactMatch) {
			sb.append("exactMatch=true&");
		}

		restConnector
				.formatUrl(HHS_URL_PREFIX
						+ HHS_ART_API
						+ "search?" + sb.toString() + HhsConstants.API_KEY_PARAMETER + "=" + apiKey); //$NON-NLS-1$ //$NON-NLS-2$
		JsonArray artArray = (JsonArray) restConnector.executeQuery();
		List<ART> artList = new ArrayList<ART>();

		Gson gson = new Gson();

		for (int i = 0; i < artArray.size(); i++) {
			artList.add(gson.fromJson(artArray.get(i), ART.class));
		}

		return artList;
	}

	/**
	 * {@inheritDoc}
	 */
	public List<ClinicalTrialsNCTID> listClinicalTrialsNCTID(String nctid)
			throws InvalidCredentialException, IOException,
			MalformedURLException {

		apiKeyAuthorized();

		restConnector.formatUrl(HHS_URL_PREFIX + HHS_CLINICAL_TRIALS_API
				+ nctid + "?" + HhsConstants.API_KEY_PARAMETER + "=" + apiKey); //$NON-NLS-1$ //$NON-NLS-2$
		JsonArray clinicalTrialsArray = (JsonArray) restConnector
				.executeQuery();

		List<ClinicalTrialsNCTID> clinicalTrialsList = new ArrayList<ClinicalTrialsNCTID>();

		Gson gson = new Gson();

		for (int i = 0; i < clinicalTrialsArray.size(); i++) {
			clinicalTrialsList.add(gson.fromJson(clinicalTrialsArray.get(i),
					ClinicalTrialsNCTID.class));
		}

		return clinicalTrialsList;
	}

	/**
	 * {@inheritDoc}
	 */
	public ClinicalTrialsSearch listClinicalTrials(String drugname,
			String status, String page, String condition, String state1,
			String state2, String state3, String country1, String country2,
			String country3, String firstreceivedfrom, String firstreceivedto,
			String lastupdatedfrom, String lastupdatedto)
			throws InvalidCredentialException, IOException,
			MalformedURLException {

		apiKeyAuthorized();
		StringBuilder sb = new StringBuilder();

		if (drugname != null && !drugname.trim().isEmpty()) {
			sb.append("drugname=").append(drugname).append("&");
		}
		if (status != null && !status.trim().isEmpty()) {
			sb.append("status=").append(status).append("&");
		}
		if (page != null && !page.trim().isEmpty()) {
			sb.append("page=").append(page).append("&");
		}
		if (condition != null && !condition.trim().isEmpty()) {
			sb.append("condition=").append(condition).append("&");
		}
		if (state1 != null && !state1.trim().isEmpty()) {
			sb.append("state1=").append(state1).append("&");
		}
		if (state2 != null && !state2.trim().isEmpty()) {
			sb.append("state2=").append(state2).append("&");
		}
		if (state3 != null && !state3.trim().isEmpty()) {
			sb.append("state3=").append(state3).append("&");
		}
		if (country1 != null && !country1.trim().isEmpty()) {
			sb.append("country1=").append(country1).append("&");
		}
		if (country2 != null && !country2.trim().isEmpty()) {
			sb.append("country2=").append(country2).append("&");
		}
		if (country3 != null && !country3.trim().isEmpty()) {
			sb.append("country3=").append(country3).append("&");
		}
		if (firstreceivedfrom != null && !firstreceivedfrom.trim().isEmpty()) {
			sb.append("firstreceivedfrom=").append(firstreceivedfrom)
					.append("&");
		}
		if (firstreceivedto != null && !firstreceivedto.trim().isEmpty()) {
			sb.append("firstreceivedto=").append(firstreceivedto).append("&");
		}
		if (lastupdatedfrom != null && !lastupdatedfrom.trim().isEmpty()) {
			sb.append("lastupdatedfrom=").append(lastupdatedfrom).append("&");
		}
		if (lastupdatedto != null && !lastupdatedto.trim().isEmpty()) {
			sb.append("lastupdatedto=").append(lastupdatedto).append("&");
		}
		if (sb.toString().isEmpty()) {
			throw new IllegalArgumentException(
					"At least one parameter is required");
		}

		restConnector.formatUrl(HHS_URL_PREFIX + HHS_CLINICAL_TRIALS_API
				+ "search?" + sb.toString() + HhsConstants.API_KEY_PARAMETER
				+ "=" + apiKey); //$NON-NLS-1$ //$NON-NLS-2$		
		JsonElement clinicalTrialsElement = restConnector.executeQuery();

		return new Gson().fromJson(clinicalTrialsElement,
				ClinicalTrialsSearch.class);

	}

	/**
	 * {@inheritDoc}
	 */
	public List<FDARecallSearch> listFDARecall(String product, String date,
			Integer pastdays) throws InvalidCredentialException, IOException,
			MalformedURLException {

		apiKeyAuthorized();

		StringBuilder sb = new StringBuilder();
		if (product != null && !product.trim().isEmpty()) {
			sb.append("product=").append(product).append("&");
		}
		if (date != null && !date.trim().isEmpty()) {
			sb.append("date=").append(date).append("&");
		}
		if (pastdays != null) {
			sb.append("pastdays=").append(product).append("&");
		}
		if (sb.toString().isEmpty()) {
			throw new IllegalArgumentException(
					"At least one parameter is required");
		}

		restConnector.formatUrl(HHS_URL_PREFIX + HHS_FDA_RECALLS_API
				+ "search?" + sb.toString() + HhsConstants.API_KEY_PARAMETER
				+ "=" + apiKey); //$NON-NLS-1$ //$NON-NLS-2$
		JsonArray fdaRecallArray = (JsonArray) restConnector.executeQuery();
		List<FDARecallSearch> fdaRecallList = new ArrayList<FDARecallSearch>();

		Gson gson = new Gson();

		for (int i = 0; i < fdaRecallArray.size(); i++) {
			fdaRecallList.add(gson.fromJson(fdaRecallArray.get(i),
					FDARecallSearch.class));
		}

		return fdaRecallList;

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

	/**
	 * Validates if the NDC was introduced
	 * 
	 * @param ndcCode
	 * @throws IllegalArgumentException
	 */
	private void ndcValidation(String ndcCode) throws IllegalArgumentException {
		if (ndcCode == null || ndcCode.isEmpty()) {
			throw new IllegalArgumentException("The NDC is invalid");
		}
		String[] ndcCheck = ndcCode.split("-");

		if (ndcCheck.length < 2) {
			throw new IllegalArgumentException("The NDC is invalid");
		}

	}
}
