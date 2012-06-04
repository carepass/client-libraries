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
import com.aetna.carepass.hhs.types.DrugImage;
import com.aetna.carepass.hhs.types.DrugNDC;
import com.aetna.carepass.hhs.types.DrugPackageInfo;
import com.aetna.carepass.hhs.types.DrugSearch;
import com.google.gson.Gson;
import com.google.gson.JsonArray;

/**
 * @author rnorris
 *
 */
public class DrugsApiImpl extends CarePassApi implements DrugsApi {
	
	private static final String ENDPOINT_URL = "https://api.carepass.com/hhs-directory-api/drugs";
	
	/* (non-Javadoc)
	 * @see com.aetna.carepass.hhs.HHSApi#listDrugs(java.lang.String)
	 */
	@Override
	public List<DrugSearch> listDrugs(DrugSearchParameters searchParameters)
			throws RequestException, IOException {

		String searchEndpointPattern = "%s/search?%s";
		
		RESTConnector restConnector = getRestConnector();
		
		searchParameters.setApiKey(getApiKey());
		
		try {
			restConnector.setUrl(new URL(String.format(searchEndpointPattern, ENDPOINT_URL, searchParameters.toQueryString())));
		} catch (MalformedURLException e) {
			throw new IllegalArgumentException(e.getMessage());
		}

		JsonArray drugsArray = (JsonArray) restConnector.executeQuery();

		List<DrugSearch> drugsList = new ArrayList<DrugSearch>();

		Gson gson = new Gson();

		for (int i = 0; i < drugsArray.size(); i++) {
			drugsList.add(gson.fromJson(drugsArray.get(i), DrugSearch.class));
		}

		return drugsList;
	}

	/* (non-Javadoc)
	 * @see com.aetna.carepass.hhs.HHSApi#getAllDrugImages(java.lang.String)
	 */
	@Override
	public List<DrugImage> getAllDrugImages(String ndc2)
			throws RequestException, IOException {

		// FIXME why is this needed?  Does it do anything?
		// ndcValidation(ndc2);
		String urlPattern = "%s/%s/images?apikey=%s";
		// https://qaapi.aetna.com/hhs-directory-api/drugs/0002-4759/images

		RESTConnector restConnector = getRestConnector();
		restConnector.setUrl(new URL(String.format(urlPattern, ENDPOINT_URL, ndc2, getApiKey())));
		
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

	/* (non-Javadoc)
	 * @see com.aetna.carepass.hhs.HHSApi#getAllDrugByNDC(java.lang.String)
	 */
	@Override
	public List<DrugNDC> getAllDrugByNDC(String ndc2)
			throws RequestException, IOException {

		// FIXME Does this do anything?
		// ndcValidation(ndc2);
		// https://qaapi.aetna.com/hhs-directory-api/drugs/0002-4759
		
		String urlPattern = "%s/%s?apikey=%s";

		RESTConnector restConnector = getRestConnector();
		restConnector.setUrl(new URL(String.format(urlPattern, ENDPOINT_URL, ndc2, getApiKey())));
		
		JsonArray ndaResArray = (JsonArray) restConnector.executeQuery();
		List<DrugNDC> drugNDCList = new ArrayList<DrugNDC>();
		Gson gson = new Gson();
		for (int i = 0; i < ndaResArray.size(); i++) {
			drugNDCList.add(gson.fromJson(ndaResArray.get(i), DrugNDC.class));
		}

		return drugNDCList;
	}

	/* (non-Javadoc)
	 * @see com.aetna.carepass.hhs.HHSApi#getAllDrugPackageInfo(java.lang.String, java.lang.String)
	 */
	@Override
	public List<DrugPackageInfo> getAllDrugPackageInfo(String ndc2, String ndc3)
			throws RequestException, IOException {

		
		// FIXME Really?  What DO these do?  No exceptions thrown, no return value...garbage!
		// ndcValidation(ndc2);
		// ndcValidation(ndc3);

		// https://qaapi.aetna.com/hhs-directory-api/drugs/0002-4759/package/0002-4759-076
		
		String urlPattern = "%s/%s/package/%s?apikey=%s";

		RESTConnector restConnector = getRestConnector();
		restConnector.setUrl(new URL(String.format(urlPattern, ENDPOINT_URL, ndc2, ndc3, getApiKey())));
		
		JsonArray ndaResArray = (JsonArray) restConnector.executeQuery();
		List<DrugPackageInfo> drugPackageInfo = new ArrayList<DrugPackageInfo>();
		Gson gson = new Gson();

		for (int i = 0; i < ndaResArray.size(); i++) {
			drugPackageInfo.add(gson.fromJson(ndaResArray.get(i),
					DrugPackageInfo.class));
		}

		return drugPackageInfo;
	}
}
