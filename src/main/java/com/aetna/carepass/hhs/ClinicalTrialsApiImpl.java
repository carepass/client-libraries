/**
 * 
 */
package com.aetna.carepass.hhs;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import com.aetna.carepass.connector.CarePassApi;
import com.aetna.carepass.connector.RESTConnector;
import com.aetna.carepass.connector.RequestException;
import com.aetna.carepass.hhs.types.ClinicalTrialsNCTID;
import com.aetna.carepass.hhs.types.ClinicalTrialsSearch;
import com.aetna.carepass.util.Messages;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;

/**
 * @author rnorris
 * 
 */
public class ClinicalTrialsApiImpl extends CarePassApi implements
		ClinicalTrialsApi {
	
	private static final String ENDPOINT_URL = "https://api.carepass.com/hhs-directory-api/clinicaltrials";
	private static final String SEARCH_PATTERN = "%s/search?%s";

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.aetna.carepass.hhs.HHSApi#listClinicalTrialsNCTID(java.lang.String)
	 */
	@Override
	public List<ClinicalTrialsNCTID> listClinicalTrialsNCTID(String nctid)
			throws RequestException, IOException {
		
		String urlPattern = "%s/%s?apikey=%s";

		RESTConnector restConnector = getRestConnector();
		restConnector.setUrl(new URL(String.format(urlPattern, ENDPOINT_URL, nctid, getApiKey())));
		
		JsonArray clinicalTrialsArray = (JsonArray) restConnector.executeQuery();

		List<ClinicalTrialsNCTID> clinicalTrialsList = new ArrayList<ClinicalTrialsNCTID>();

		Gson gson = new Gson();

		for (int i = 0; i < clinicalTrialsArray.size(); i++) {
			clinicalTrialsList.add(gson.fromJson(clinicalTrialsArray.get(i),
					ClinicalTrialsNCTID.class));
		}

		return clinicalTrialsList;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.aetna.carepass.hhs.HHSApi#listClinicalTrials(java.util.Map)
	 */
	@Override
	public ClinicalTrialsSearch listClinicalTrials(
			ClinicalTrialsSearchParameters searchParameters) throws RequestException,
			IOException {
		
		searchParameters.setApiKey(getApiKey());

		RESTConnector restConnector = getRestConnector();
		
		restConnector.setUrl(new URL(String.format(SEARCH_PATTERN, ENDPOINT_URL, searchParameters.toQueryString())));		
		
		JsonElement clinicalTrialsElement = restConnector.executeQuery();

		return new Gson().fromJson(clinicalTrialsElement,
				ClinicalTrialsSearch.class);

	}

}
