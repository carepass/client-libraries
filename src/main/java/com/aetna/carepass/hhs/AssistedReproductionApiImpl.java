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
import com.aetna.carepass.hhs.types.ART;
import com.google.gson.Gson;
import com.google.gson.JsonArray;

/**
 * @author rnorris
 *
 */
public class AssistedReproductionApiImpl extends CarePassApi implements AssistedReproductionApi {

	private static final String ENDPOINT_PATTERN = "%s?%s";
	private static final String URL_ENDPOINT = "https://api.carepass.com/hhs-directory-api/art/search";
	
	/* (non-Javadoc)
	 * @see com.aetna.carepass.hhs.HHSApi#listARTs(java.util.Map, boolean)
	 */
	@Override
	public List<ART> listARTs(ARTSearchParameters parameters) throws RequestException, IOException {

		RESTConnector restConnector = getRestConnector();
		
		parameters.setApiKey(getApiKey());

		try {
			restConnector.setUrl(new URL(String.format(ENDPOINT_PATTERN,
					URL_ENDPOINT, parameters.toQueryString())));
		} catch (MalformedURLException e) {
			throw new IllegalArgumentException(e.getMessage());
		}
		
		JsonArray artArray = (JsonArray) restConnector.executeQuery();
		
		List<ART> artList = new ArrayList<ART>();

		Gson gson = new Gson();

		for (int i = 0; i < artArray.size(); i++) {
			artList.add(gson.fromJson(artArray.get(i), ART.class));
		}

		return artList;
	}

}
