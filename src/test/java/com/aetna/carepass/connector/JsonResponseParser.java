/**
 * 
 */
package com.aetna.carepass.connector;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;

import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

/**
 * @author rnorris
 *
 */
public class JsonResponseParser implements ResponseParser {

	/* (non-Javadoc)
	 * @see com.aetna.carepass.ResponseParser#parseResponse(java.net.HttpURLConnection)
	 */
	@Override
	public JsonElement parseResponse(HttpURLConnection httpURLConnection) throws IOException, RequestException {
		JsonParser parser = null;
		JsonElement element = null;
		
		int responseCode = httpURLConnection.getResponseCode();
		
		if(responseCode == 200) {
			parser = new JsonParser();
			element = parser.parse(new InputStreamReader(httpURLConnection.getInputStream()));
		} else {
			throw new RequestException(responseCode, httpURLConnection.getResponseMessage());
		}
		
		return element;
	}

}
