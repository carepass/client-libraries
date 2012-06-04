/**
 * 
 */
package com.aetna.carepass.hhs;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import com.aetna.carepass.DrugRecallSearchParameters;
import com.aetna.carepass.connector.CarePassApi;
import com.aetna.carepass.connector.RESTConnector;
import com.aetna.carepass.connector.RequestException;
import com.aetna.carepass.hhs.types.FDARecallSearch;
import com.google.gson.Gson;
import com.google.gson.JsonArray;

/**
 * @author rnorris
 * 
 */
public class FDARecallApiImpl extends CarePassApi implements FDARecallApi {

	private static final String ENDPOINT_URL = "https://api.carepass.com/hhs-directory-api/fdarecalls/search";

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.aetna.carepass.hhs.HHSApi#listFDARecall(java.util.Map)
	 */
	@Override
	public List<FDARecallSearch> listFDARecall(
			DrugRecallSearchParameters searchParameters)
			throws RequestException, IOException {

		RESTConnector restConnector = getRestConnector();
		searchParameters.setApiKey(getApiKey());

		String urlPattern = "%s?%s";

		restConnector.setUrl(new URL(String.format(urlPattern, ENDPOINT_URL,
				searchParameters.toQueryString())));

		JsonArray fdaRecallArray = (JsonArray) restConnector.executeQuery();
		List<FDARecallSearch> fdaRecallList = new ArrayList<FDARecallSearch>();

		Gson gson = new Gson();

		for (int i = 0; i < fdaRecallArray.size(); i++) {
			fdaRecallList.add(gson.fromJson(fdaRecallArray.get(i),
					FDARecallSearch.class));
		}

		return fdaRecallList;

	}
}
