package com.aetna.carepass.hhs;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.List;

import com.aetna.carepass.connector.RESTConnector;
import com.aetna.carepass.hhs.types.ART;
import com.aetna.carepass.hhs.types.Alternative;
import com.aetna.carepass.hhs.types.ClinicalTrialsNCTID;
import com.aetna.carepass.hhs.types.ClinicalTrialsSearch;
import com.aetna.carepass.hhs.types.Document;
import com.aetna.carepass.hhs.types.DrugImage;
import com.aetna.carepass.hhs.types.DrugNDC;
import com.aetna.carepass.hhs.types.DrugPackageInfo;
import com.aetna.carepass.hhs.types.DrugResource;
import com.aetna.carepass.hhs.types.FDARecallSearch;
import com.aetna.carepass.hhs.types.Nda;
import com.aetna.carepass.util.InvalidCredentialException;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;

/**
 * 
 * HHS application program interface java endpoitns.
 * 
 */
public class HHSAPI {

	private String apiKey;
	private final String API_KEY_PARAMETER = "apikey";
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

	private final String INVALID_APIs = "Invalid Credential Specified"; //$NON-NLS-1$

	/***
	 * Retrieve current api key that was specified
	 * 
	 * @return apiKey
	 */
	public String getApiKey() {
		return apiKey;
	}

	@SuppressWarnings("unused")
	private HHSAPI() {
	}

	/***
	 * @param apiKey
	 *            the API key
	 */
	public HHSAPI(String apiKey) {
		this.apiKey = apiKey;
	}

	/**
	 * Retrieves list of Drug Documents
	 * 
	 * @param nda
	 *            The NDA code
	 * @return List<Document>
	 * @throws InvalidCredentialException
	 * @throws IOException
	 * @throws MalformedURLException
	 */
	public List<Document> getDocuments(String nda)
			throws InvalidCredentialException, IOException,
			MalformedURLException {

		apiKeyAuthorized();

		RESTConnector restConnect = new RESTConnector(HHS_URL_PREFIX
				+ HHS_APPLICATION_API + nda + HHS_DOCUMENT_ENDPOINT
				+ "?" + API_KEY_PARAMETER + "=" + apiKey); //$NON-NLS-1$ //$NON-NLS-2$
		JsonArray documentArray = (JsonArray) restConnect.executeQuery();

		List<Document> documentList = new ArrayList<Document>();
		Gson gson = new Gson();

		for (int i = 0; i < documentArray.size(); i++) {
			documentList
					.add(gson.fromJson(documentArray.get(i), Document.class));
		}

		return documentList;
	}

	/***
	 * Retrieves a list of NDAs based on the NDA supplied
	 * 
	 * @param nda
	 *            The NDA code
	 * @return List<Nda>
	 * @throws InvalidCredentialException
	 * @throws IOException
	 * @throws MalformedURLException
	 */

	public List<Nda> getAllNDA(String nda) throws InvalidCredentialException,
			IOException, MalformedURLException {

		apiKeyAuthorized();
		// https://qaapi.aetna.com/hhs-directory-api/applications/NDA003444
		// https://qaapi.aetna.com/hhs-directory-api/applications/NDA003444

		RESTConnector restConnect = new RESTConnector(HHS_URL_PREFIX
				+ HHS_APPLICATION_API + nda
				+ "?" + API_KEY_PARAMETER + "=" + apiKey); //$NON-NLS-1$ //$NON-NLS-2$
		JsonArray ndaResArray = (JsonArray) restConnect.executeQuery();
		List<Nda> ndaResourceList = new ArrayList<Nda>();

		Gson gson = new Gson();
		for (int i = 0; i < ndaResArray.size(); i++) {
			ndaResourceList.add(gson.fromJson(ndaResArray.get(i), Nda.class));
		}

		return ndaResourceList;

	}

	/**
	 * Retrieves alternative therapies for the provided
	 * 
	 * @param nda
	 *            The NDA code
	 * @return List<Alternatives>
	 * @throws InvalidCredentialException
	 * @throws IOException
	 * @throws MalformedURLException
	 */
	public List<Alternative> getAllAlternatives(String nda)
			throws InvalidCredentialException, IOException,
			MalformedURLException {

		apiKeyAuthorized();
		// https://qaapi.aetna.com/hhs-directory-api/applications/NDA003444/alternatives
		// https://qaapi.aetna.com/hhs-directory-api/applications/NDA003444/alternatives

		RESTConnector restConnect = new RESTConnector(HHS_URL_PREFIX
				+ HHS_APPLICATION_API + nda + HHS_DRUGS_ALTERNATIVES_ENDPOINT
				+ "?" + API_KEY_PARAMETER + "=" + apiKey); //$NON-NLS-1$ //$NON-NLS-2$
		JsonArray ndaResArray = (JsonArray) restConnect.executeQuery();
		List<Alternative> ndaAlternativesList = new ArrayList<Alternative>();

		Gson gson = new Gson();

		for (int i = 0; i < ndaResArray.size(); i++) {
			ndaAlternativesList.add(gson.fromJson(ndaResArray.get(i),
					Alternative.class));
		}

		return ndaAlternativesList;

	}

	// TODO: Refactor to use

	/***
	 * Retrieves a list of DrugResources
	 * 
	 * InvalidCredentialException
	 * 
	 * @param nda
	 *            The NDA code
	 * @return List<DrugResource>
	 * @throws InvalidCredentialException
	 * @throws IOException
	 * @throws MalformedURLException
	 */
	public List<DrugResource> listDrugResources(String nda)
			throws InvalidCredentialException, IOException,
			MalformedURLException {

		apiKeyAuthorized();

		RESTConnector restConnect = new RESTConnector(HHS_URL_PREFIX
				+ HHS_APPLICATION_API + nda + HHS_DRUGS_RESOURCES_ENDPOINT
				+ "?" + API_KEY_PARAMETER + "=" + apiKey); //$NON-NLS-1$ //$NON-NLS-2$
		JsonArray drugResArray = (JsonArray) restConnect.executeQuery();

		List<DrugResource> drugResourceList = new ArrayList<DrugResource>();

		Gson gson = new Gson();

		for (int i = 0; i < drugResArray.size(); i++) {
			drugResourceList.add(new DrugResource(gson.fromJson(
					drugResArray.get(i), String.class)));
		}

		return drugResourceList;
	}

	/**
	 * Finds a drug based on drug name
	 * 
	 * @param drugName
	 *            The drug name
	 * @return List<Drug>
	 * @throws InvalidCredentialException
	 * @throws IOException
	 * @throws MalformedURLException
	 */
//	public List<DrugSearch> listDrugs(String drugName)
//			throws InvalidCredentialException, IOException,
//			MalformedURLException {
//
//		apiKeyAuthorized();
//
//		RESTConnector restConnect = new RESTConnector(
//				HHS_URL_PREFIX
//						+ HHS_APPLICATION_API
//						+ "search?name=" + drugName + "&" + API_KEY_PARAMETER + "=" + apiKey); //$NON-NLS-1$ //$NON-NLS-2$
//		JsonArray drugsArray = (JsonArray) restConnect.executeQuery();
//
//		List<DrugSearch> drugsList = new ArrayList<DrugSearch>();
//
//		Gson gson = new Gson();
//
//		for (int i = 0; i < drugsArray.size(); i++) {
//			drugsList.add(gson.fromJson(drugsArray.get(i), DrugSearch.class));
//		}
//
//		return drugsList;
//	}

	/**
	 * Retrieves a list of images of the drugs for the given NDC2 segment
	 * 
	 * @param ndc2
	 *            the given NDC2 segment
	 * @return List<DrugImage>
	 * @throws InvalidCredentialException
	 * @throws IOException
	 * @throws MalformedURLException
	 */
	public List<DrugImage> getAllDrugImages(String ndc2)
			throws InvalidCredentialException, IOException,
			MalformedURLException {

		apiKeyAuthorized();
		ndcValidation(ndc2);
		// https://qaapi.aetna.com/hhs-directory-api/drugs/0002-4759/images

		RESTConnector restConnect = new RESTConnector(HHS_URL_PREFIX
				+ HHS_DRUGS_API + ndc2 + HHS_DRUGS_IMAGES_ENDPOINT
				+ "?" + API_KEY_PARAMETER + "=" + apiKey); //$NON-NLS-1$ //$NON-NLS-2$
		JsonArray ndaResArray = (JsonArray) restConnect.executeQuery();
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
	 * Retrieves a list of drugs according to the NC2 segment with its package
	 * info and imprints
	 * 
	 * @param ndc2
	 *            the NDC two segment
	 * @return List<DrugNDC>
	 * @throws InvalidCredentialException
	 * @throws IOException
	 * @throws MalformedURLException
	 */
	public List<DrugNDC> getAllDrugByNDC(String ndc2)
			throws InvalidCredentialException, IOException,
			MalformedURLException {

		apiKeyAuthorized();
		ndcValidation(ndc2);
		// https://qaapi.aetna.com/hhs-directory-api/drugs/0002-4759

		RESTConnector restConnect = new RESTConnector(HHS_URL_PREFIX
				+ HHS_DRUGS_API + ndc2 + "?" + API_KEY_PARAMETER + "=" + apiKey); //$NON-NLS-1$ //$NON-NLS-2$
		JsonArray ndaResArray = (JsonArray) restConnect.executeQuery();
		List<DrugNDC> drugNDCList = new ArrayList<DrugNDC>();
		Gson gson = new Gson();
		for (int i = 0; i < ndaResArray.size(); i++) {
			drugNDCList.add(gson.fromJson(ndaResArray.get(i), DrugNDC.class));
		}

		return drugNDCList;
	}

	/**
	 * Retrieves the package info of drug according to the given NDC2 segment
	 * and the NDC3 segment
	 * 
	 * @param ndc2
	 *            the NDC two segment
	 * @param ndc3
	 *            the NDC three segment
	 * @return List<DrugPackageInfo>
	 * @throws InvalidCredentialException
	 * @throws IOException
	 * @throws MalformedURLException
	 */
	public List<DrugPackageInfo> getAllDrugPackageInfo(String ndc2, String ndc3)
			throws InvalidCredentialException, IOException,
			MalformedURLException {

		apiKeyAuthorized();
		ndcValidation(ndc2);
		ndcValidation(ndc3);

		// https://qaapi.aetna.com/hhs-directory-api/drugs/0002-4759/package/0002-4759-076

		RESTConnector restConnect = new RESTConnector(HHS_URL_PREFIX
				+ HHS_DRUGS_API + ndc2 + HHS_DRUGS_PACKAGE_ENDPOINT + ndc3
				+ "?" + API_KEY_PARAMETER + "=" + apiKey); //$NON-NLS-1$ //$NON-NLS-2$
		JsonArray ndaResArray = (JsonArray) restConnect.executeQuery();
		List<DrugPackageInfo> drugPackageInfo = new ArrayList<DrugPackageInfo>();
		Gson gson = new Gson();

		for (int i = 0; i < ndaResArray.size(); i++) {
			drugPackageInfo.add(gson.fromJson(ndaResArray.get(i),
					DrugPackageInfo.class));
		}

		return drugPackageInfo;
	}

	/**
	 * Finds a ART based on the given parameter and value
	 * 
	 * @param clinicName
	 *            Name of clinic
	 * @param city
	 *            Name of a City
	 * @param state
	 *            Name of a state
	 * @param medicaldirector
	 *            Medical director
	 * @param year
	 *            year
	 * @param exactMatch
	 *            true if and only if it requires exact match.
	 * @return List<ART>
	 * @throws InvalidCredentialException
	 * @throws IOException
	 * @throws MalformedURLException
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

		RESTConnector restConnect = new RESTConnector(HHS_URL_PREFIX
				+ HHS_ART_API
				+ "search?" + sb.toString() + API_KEY_PARAMETER + "=" + apiKey); //$NON-NLS-1$ //$NON-NLS-2$
		JsonArray artArray = (JsonArray) restConnect.executeQuery();
		List<ART> artList = new ArrayList<ART>();

		Gson gson = new Gson();

		for (int i = 0; i < artArray.size(); i++) {
			artList.add(gson.fromJson(artArray.get(i), ART.class));
		}

		return artList;
	}

	/**
	 * Finds clinical trials information according to the registry number
	 * indicated
	 * 
	 * @param nctid
	 *            The NCT id
	 * @return List<ClinicalTrialsNCTID>
	 * @throws InvalidCredentialException
	 * @throws IOException
	 * @throws MalformedURLException
	 */
	public List<ClinicalTrialsNCTID> listClinicalTrialsNCTID(String nctid)
			throws InvalidCredentialException, IOException,
			MalformedURLException {

		apiKeyAuthorized();

		RESTConnector restConnect = new RESTConnector(HHS_URL_PREFIX
				+ HHS_CLINICAL_TRIALS_API + nctid
				+ "?" + API_KEY_PARAMETER + "=" + apiKey); //$NON-NLS-1$ //$NON-NLS-2$
		JsonArray clinicalTrialsArray = (JsonArray) restConnect.executeQuery();

		List<ClinicalTrialsNCTID> clinicalTrialsList = new ArrayList<ClinicalTrialsNCTID>();

		Gson gson = new Gson();

		for (int i = 0; i < clinicalTrialsArray.size(); i++) {
			clinicalTrialsList.add(gson.fromJson(clinicalTrialsArray.get(i),
					ClinicalTrialsNCTID.class));
		}

		return clinicalTrialsList;
	}

	/**
	 * Finds a Clinical Trial based on the given parameter and value
	 * 
	 * @param drugname
	 *            Name of drug
	 * @param status
	 *            Status of clinical trials / open or closed
	 * @param page
	 *            Page number. Each page has until 500 results. (e.g. page=1
	 *            return the last 500 clinical trials).
	 * @param condition
	 *            conditioning summary
	 * @param state1
	 *            Locations to find trials state 1.
	 * @param state2
	 *            Locations to find trials state 2.
	 * @param state3
	 *            Locations to find trials state 3.
	 * @param country1
	 *            Locations to find trials country 1.
	 * @param country2
	 *            Locations to find trials country 2.
	 * @param country3
	 *            Locations to find trials country 3.
	 * @param firstreceivedfrom
	 *            The first received date is the date when the clinical trial
	 *            was first submitted to ClinicalTrials.gov
	 * @param firstreceivedto
	 *            First Received To: The first received date is the date when
	 *            the clinical trial was first submitted to ClinicalTrials.gov
	 * @param lastupdatedfrom
	 *            The last updated date is the most recent date when changes to
	 *            a clinical trial were submitted to ClinicalTrials.gov
	 * @param lastupdatedto
	 *            The last updated date is the most recent date when changes to
	 *            a clinical trial were submitted to ClinicalTrials.gov
	 * @return ClinicalTrialsSearch
	 * @throws InvalidCredentialException
	 * @throws IOException
	 * @throws MalformedURLException
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

		RESTConnector restConnect = new RESTConnector(HHS_URL_PREFIX
				+ HHS_CLINICAL_TRIALS_API + "search?" + sb.toString()
				+ API_KEY_PARAMETER + "=" + apiKey); //$NON-NLS-1$ //$NON-NLS-2$		
		JsonElement clinicalTrialsElement = restConnect.executeQuery();

		return new Gson().fromJson(clinicalTrialsElement,
				ClinicalTrialsSearch.class);

	}

	/**
	 * Finds a FDA Recall based on the given parameter and value.
	 * 
	 * @param product Product of recall
	 * @param date Date of recall (pattern: yyyy-mm-dd)
	 * @param pastdays Search all recalls from today until today-pastdays
	 * @return List<FDARecallSearch>
	 * @throws InvalidCredentialException
	 * @throws IOException
	 * @throws MalformedURLException
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

		RESTConnector restConnect = new RESTConnector(HHS_URL_PREFIX
				+ HHS_FDA_RECALLS_API + "search?" + sb.toString()
				+ API_KEY_PARAMETER + "=" + apiKey); //$NON-NLS-1$ //$NON-NLS-2$
		JsonArray fdaRecallArray = (JsonArray) restConnect.executeQuery();
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
			throw new InvalidCredentialException(INVALID_APIs);
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
