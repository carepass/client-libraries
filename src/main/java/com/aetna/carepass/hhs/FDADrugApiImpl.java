/**
 * 
 */
package com.aetna.carepass.hhs;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import com.aetna.carepass.connector.CarePassApi;
import com.aetna.carepass.connector.RESTConnector;
import com.aetna.carepass.connector.RequestException;
import com.aetna.carepass.hhs.types.Alternative;
import com.aetna.carepass.hhs.types.Document;
import com.aetna.carepass.hhs.types.DrugResource;
import com.aetna.carepass.hhs.types.Nda;
import com.google.gson.Gson;
import com.google.gson.JsonArray;

/**
 * /applications
 * 
 * @author rnorris
 * 
 */
public class FDADrugApiImpl extends CarePassApi implements FDADrugApi {

	private static final String ENDPOINT_URL = "https://api.carepass.com/hhs-directory-api/applications";

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.aetna.carepass.hhs.HHSApi#getDocuments(java.lang.String)
	 */
	@Override
	public List<Document> getDocuments(String nda) throws RequestException,
			IOException {

		RESTConnector restConnector = getRestConnector();

		String urlPattern = "%s/%s/documents?apikey=%s";

		try {
			restConnector.setUrl(new URL(String.format(urlPattern,
					ENDPOINT_URL, nda, getApiKey())));
		} catch (MalformedURLException e) {
			throw new IllegalArgumentException(e.getMessage());
		}

		JsonArray documentArray = (JsonArray) restConnector.executeQuery();

		List<Document> documentList = new ArrayList<Document>();
		Gson gson = new Gson();

		for (int i = 0; i < documentArray.size(); i++) {
			documentList
					.add(gson.fromJson(documentArray.get(i), Document.class));
		}

		return documentList;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.aetna.carepass.hhs.HHSApi#getAllNDA(java.lang.String)
	 */

	@Override
	public List<Nda> getAllNDA(String nda) throws RequestException, IOException {

		// https://qaapi.aetna.com/hhs-directory-api/applications/NDA003444
		// https://qaapi.aetna.com/hhs-directory-api/applications/NDA003444
		RESTConnector restConnector = getRestConnector();

		String openEndpointPattern = "%s/%s?apikey=%s";

		try {
			restConnector.setUrl(new URL(String.format(openEndpointPattern,
					ENDPOINT_URL, nda, getApiKey())));
		} catch (MalformedURLException e) {
			throw new IllegalArgumentException(e.getMessage());
		}

		JsonArray ndaResArray = (JsonArray) restConnector.executeQuery();
		List<Nda> ndaResourceList = new ArrayList<Nda>();

		Gson gson = new Gson();
		for (int i = 0; i < ndaResArray.size(); i++) {
			ndaResourceList.add(gson.fromJson(ndaResArray.get(i), Nda.class));
		}

		return ndaResourceList;

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.aetna.carepass.hhs.HHSApi#getAllAlternatives(java.lang.String)
	 */
	@Override
	public List<Alternative> getAllAlternatives(String nda)
			throws RequestException, IOException {

		// https://qaapi.aetna.com/hhs-directory-api/applications/NDA003444/alternatives
		// https://qaapi.aetna.com/hhs-directory-api/applications/NDA003444/alternatives

		RESTConnector restConnector = getRestConnector();

		String urlPattern = "%s/%s/alternatives?apikey=%s";

		try {
			restConnector.setUrl(new URL(String.format(urlPattern,
					ENDPOINT_URL, nda, getApiKey())));
		} catch (MalformedURLException e) {
			throw new IllegalArgumentException(e.getMessage());
		}
		JsonArray ndaResArray = (JsonArray) restConnector.executeQuery();
		List<Alternative> ndaAlternativesList = new ArrayList<Alternative>();

		Gson gson = new Gson();

		for (int i = 0; i < ndaResArray.size(); i++) {
			ndaAlternativesList.add(gson.fromJson(ndaResArray.get(i),
					Alternative.class));
		}

		return ndaAlternativesList;

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.aetna.carepass.hhs.HHSApi#listDrugResources(java.lang.String)
	 */
	@Override
	public List<DrugResource> listDrugResources(String nda)
			throws RequestException, IOException {

		RESTConnector restConnector = getRestConnector();

		String urlPattern = "%s/%s/drugresources?apikey=%s";

		try {
			restConnector.setUrl(new URL(String.format(urlPattern,
					ENDPOINT_URL, nda, getApiKey())));
		} catch (MalformedURLException e) {
			throw new IllegalArgumentException(e.getMessage());
		}

		JsonArray drugResArray = (JsonArray) restConnector.executeQuery();

		List<DrugResource> drugResourceList = new ArrayList<DrugResource>();

		Gson gson = new Gson();

		for (int i = 0; i < drugResArray.size(); i++) {
			drugResourceList.add(new DrugResource(gson.fromJson(
					drugResArray.get(i), String.class)));
		}

		return drugResourceList;
	}

}
