package com.aetna.api.hhs;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.aetna.api.connector.RESTConnector;
import com.aetna.api.dataTypes.ART;
import com.aetna.api.dataTypes.Alternative;
import com.aetna.api.dataTypes.ClinicalTrialsNCTID;
import com.aetna.api.dataTypes.ClinicalTrialsSearch;
import com.aetna.api.dataTypes.Document;
import com.aetna.api.dataTypes.DrugImage;
import com.aetna.api.dataTypes.DrugNDC;
import com.aetna.api.dataTypes.DrugPackageInfo;
import com.aetna.api.dataTypes.DrugResource;
import com.aetna.api.dataTypes.DrugSearch;
import com.aetna.api.dataTypes.FDARecallSearch;
import com.aetna.api.dataTypes.Nda;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;

public class HHSAPI {

	String _apiKey;
	private static final String INVALID_APIs = Messages
			.getString("HHS_Excep_InvalidCred"); //$NON-NLS-1$

	/***
	 * Retrieve current api key that was specified
	 * 
	 * @return apiKey
	 */
	public String getApiKey() {
		return _apiKey;
	}

	@SuppressWarnings("unused")
	private HHSAPI() {
	}

	/***
	 * @param apiKey
	 */
	public HHSAPI(String apiKey) {
		_apiKey = apiKey;
	}

	/***
	 * Retrieves list of Drug Documents
	 * 
	 * @param nda
	 * @return List<Document>
	 * @throws InvalidCredentialException
	 */
	public List<Document> getDocuments(String nda)
			throws InvalidCredentialException, IOException,
			MalformedURLException {

		apiKeyAuthorized();

		RESTConnector restConnect = new RESTConnector(
				Messages.getString("HHS_URL_Prefix") + nda + Messages.getString("HHS_Document_EndPoint")); //$NON-NLS-1$ //$NON-NLS-2$
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
	 * @return List<Nda>
	 * @throws InvalidCredentialException
	 */

	// TODO: ZThis needs to be cleaned up
	public List<Nda> getAllNDA(String nda) throws InvalidCredentialException,
			IOException, MalformedURLException {

		apiKeyAuthorized();
		// https://qaapi.aetna.com/hhs-directory-api/applications/NDA003444
		// https://qaapi.aetna.com/hhs-directory-api/applications/NDA003444

		RESTConnector restConnect = new RESTConnector(
				Messages.getString("HHS_URL_Prefix") + nda); //$NON-NLS-1$ //$NON-NLS-2$
		JsonArray ndaResArray = (JsonArray) restConnect.executeQuery();
		List<Nda> ndaResourceList = new ArrayList<Nda>();

		Gson gson = new Gson();
		for (int i = 0; i < ndaResArray.size(); i++) {
			// System.err.println(ndaResArray.get(i));
			ndaResourceList.add(gson.fromJson(ndaResArray.get(i), Nda.class));
		}

		return ndaResourceList;

	}

	/**
	 * Retrieves alternative therapies for the provided
	 * 
	 * @param nda
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

		RESTConnector restConnect = new RESTConnector(
				Messages.getString("HHS_URL_Prefix") + nda + Messages.getString("HHS_Drugs_Alternatives")); //$NON-NLS-1$ //$NON-NLS-2$
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
	 * @return List<DrugResource>
	 * 
	 */
	public List<DrugResource> listDrugResources(String nda)
			throws InvalidCredentialException, IOException,
			MalformedURLException {

		apiKeyAuthorized();

		RESTConnector restConnect = new RESTConnector(
				Messages.getString("HHS_URL_Prefix") + nda + Messages.getString("HHS_DrugsResources_EndPoint")); //$NON-NLS-1$ //$NON-NLS-2$
		JsonArray drugResArray = (JsonArray) restConnect.executeQuery();

		List<DrugResource> drugResourceList = new ArrayList<DrugResource>();

		Gson gson = new Gson();

		for (int i = 0; i < drugResArray.size(); i++) {
			System.err.println(drugResArray.get(i));
			drugResourceList.add(new DrugResource(gson.fromJson(
					drugResArray.get(i), String.class)));
		}

		return drugResourceList;
	}

	/**
	 * Finds a drug based on drug name
	 * 
	 * @param drugName
	 * @return List<Drug>
	 * @throws InvalidCredentialException
	 */
	public List<DrugSearch> listDrugs(String drugName)
			throws InvalidCredentialException, IOException,
			MalformedURLException {

		apiKeyAuthorized();

		RESTConnector restConnect = new RESTConnector(
				Messages.getString("HHS_Drugs_URL_Prefix") + "search?name=" + drugName); //$NON-NLS-1$ //$NON-NLS-2$
		JsonArray drugsArray = (JsonArray) restConnect.executeQuery();

		List<DrugSearch> drugsList = new ArrayList<DrugSearch>();

		Gson gson = new Gson();

		for (int i = 0; i < drugsArray.size(); i++) {
			System.err.println(drugsArray.get(i));
			drugsList.add(gson.fromJson(drugsArray.get(i), DrugSearch.class));
		}

		return drugsList;
	}

	/**
	 * Retrieves a list of images of the drugs for the given NDC2 segment
	 * 
	 * @param ndc2
	 *            the given NDC2 segment
	 * @return {@link List }
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

		RESTConnector restConnect = new RESTConnector(
				Messages.getString("HHS_Drugs_URL_Prefix") + ndc2 + Messages.getString("HHS_Drugs_Images")); //$NON-NLS-1$ //$NON-NLS-2$
		JsonArray ndaResArray = (JsonArray) restConnect.executeQuery();
		List<DrugImage> drugImagesList = new ArrayList<DrugImage>();
		Gson gson = new Gson();

		for (int i = 0; i < ndaResArray.size(); i++) {
			// System.err.println(ndaResArray.get(i));
			drugImagesList.add(gson.fromJson(ndaResArray.get(i),
					DrugImage.class));
		}

		return drugImagesList;
	}

	/**
	 * Retrieves a list of drugs according to the NC2 segment with its package
	 * info and imprints
	 * 
	 * @param ndc2
	 * @return {@link List}
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

		RESTConnector restConnect = new RESTConnector(
				Messages.getString("HHS_Drugs_URL_Prefix") + ndc2); //$NON-NLS-1$ //$NON-NLS-2$
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
	 * @param ndc3
	 * @return {@link List}
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

		RESTConnector restConnect = new RESTConnector(
				Messages.getString("HHS_Drugs_URL_Prefix") + ndc2 + Messages.getString("HHS_Drugs_Package") + ndc3); //$NON-NLS-1$ //$NON-NLS-2$
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
	 * @param searchParameter
	 *            the parameters for the ART search
	 * @param exactMatch
	 * @return List<ART>
	 * @throws InvalidCredentialException
	 * @throws IOException
	 * @throws MalformedURLException
	 */
	public List<ART> listARTs(Map<String, String> searchParameter,
			boolean exactMatch) throws InvalidCredentialException, IOException,
			MalformedURLException {

		apiKeyAuthorized();

		String parameters = searchParsing(searchParameter);
		if (exactMatch) {
			parameters = parameters + "&exactMatch=true";
		}

		RESTConnector restConnect = new RESTConnector(
				Messages.getString("HHS_ART_URL_Prefix") + parameters); //$NON-NLS-1$ //$NON-NLS-2$
		JsonArray artArray = (JsonArray) restConnect.executeQuery();
		List<ART> artList = new ArrayList<ART>();

		Gson gson = new Gson();

		for (int i = 0; i < artArray.size(); i++) {
			System.err.println(artArray.get(i));
			artList.add(gson.fromJson(artArray.get(i), ART.class));
		}

		return artList;
	}

	/**
	 * Finds clinical trials information according to the registry number
	 * indicated
	 * 
	 * @param nctid
	 *            the nct id
	 * @return List<ClinicalTrialsNCTID>
	 * @throws InvalidCredentialException
	 * @throws IOException
	 * @throws MalformedURLException
	 */
	public List<ClinicalTrialsNCTID> listClinicalTrialsNCTID(String nctid)
			throws InvalidCredentialException, IOException,
			MalformedURLException {

		apiKeyAuthorized();

		RESTConnector restConnect = new RESTConnector(
				Messages.getString("HHS_Clinical_Trials_URL_Prefix") + nctid); //$NON-NLS-1$ //$NON-NLS-2$
		JsonArray clinicalTrialsArray = (JsonArray) restConnect.executeQuery();

		List<ClinicalTrialsNCTID> clinicalTrialsList = new ArrayList<ClinicalTrialsNCTID>();

		Gson gson = new Gson();

		for (int i = 0; i < clinicalTrialsArray.size(); i++) {
			System.err.println(clinicalTrialsArray.get(i));
			clinicalTrialsList.add(gson.fromJson(clinicalTrialsArray.get(i),
					ClinicalTrialsNCTID.class));
		}

		return clinicalTrialsList;
	}

	/**
	 * Finds a Clinical Trial based on the given parameter and value
	 * 
	 * @param searchParameter
	 *            the parameters for the clinical trials search
	 * @return {@link ClinicalTrailsSearch}
	 * @throws InvalidCredentialException
	 * @throws IOException
	 * @throws MalformedURLException
	 */
	public ClinicalTrialsSearch listClinicalTrials(
			Map<String, String> searchParameter)
			throws InvalidCredentialException, IOException,
			MalformedURLException {

		apiKeyAuthorized();

		RESTConnector restConnect = new RESTConnector(
				Messages.getString("HHS_Clinical_Trials_URL_Prefix") + searchParsing(searchParameter)); //$NON-NLS-1$ //$NON-NLS-2$
		JsonElement clinicalTrialsElement = restConnect.executeQuery();

		System.err.println(clinicalTrialsElement);
		return new Gson().fromJson(clinicalTrialsElement,
				ClinicalTrialsSearch.class);

	}

	/**
	 * Finds a FDA Recall based on the given parameter and value
	 * 
	 * @param searchParameter
	 *            the parameters for the clinical trials search
	 * @return List<FDARecallSearch>
	 * @throws InvalidCredentialException
	 * @throws IOException
	 * @throws MalformedURLException
	 */
	public List<FDARecallSearch> listFDARecall(
			Map<String, String> searchParameter)
			throws InvalidCredentialException, IOException,
			MalformedURLException {

		apiKeyAuthorized();

		RESTConnector restConnect = new RESTConnector(
				Messages.getString("HHS_FDA_Recalls_URL_Prefix") + searchParsing(searchParameter)); //$NON-NLS-1$ //$NON-NLS-2$
		JsonArray fdaRecallArray = (JsonArray) restConnect.executeQuery();
		List<FDARecallSearch> fdaRecallList = new ArrayList<FDARecallSearch>();

		Gson gson = new Gson();

		for (int i = 0; i < fdaRecallArray.size(); i++) {
			System.err.println(fdaRecallArray.get(i));
			fdaRecallList.add(gson.fromJson(fdaRecallArray.get(i),
					FDARecallSearch.class));
		}

		return fdaRecallList;

	}

	/**
	 * Common search url fragment builder
	 * 
	 * @param searchParameter
	 * @return the search url fragment
	 */
	private String searchParsing(Map<String, String> searchParameter) {
		StringBuilder sb = new StringBuilder();
		sb.append("search?");
		for (Map.Entry<String, String> entry : searchParameter.entrySet()) {
			sb.append(entry.getKey()).append("=").append(entry.getValue())
					.append("&");
		}
		String result = sb.toString();
		return result.substring(0, result.length() - 1);
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
