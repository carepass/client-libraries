package com.aetna.api.connector;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.google.gson.stream.JsonReader;

public class RESTConnector extends Connector {
	private URL _url;	
	
	/***
	 * Constructor that ensures the URL is well-formed
	 * @param url
	 */
	public RESTConnector(String url){
		
		try {
			
			_url = new URL(URLEncoder.encode(url, "UTF8").
					replace("%3A", ":").replace("%2F", "/").replace("%3F", "?").replace("%3D","=").replace("%26", "&").replace("%2C", ",")
					);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Executes the request to the REST Service and converts data to JsonArray
	 * @return JsonElement representing the json from the REST service
	 * @throws IOException, MalformedURLExecption 
	 */
	public JsonElement executeQuery() throws IOException, MalformedURLException {
				
		JsonReader reader = null;
		JsonParser parser = null;
		JsonElement theJsonElement = null;
		
		try {
			
			HttpURLConnection httpUrlConnection = (HttpURLConnection) this.getUrl().openConnection();
			this.getUrl().openConnection();
			httpUrlConnection.connect();
			
			if (isSuccessfulResponse(httpUrlConnection.getResponseCode(), httpUrlConnection.getResponseMessage())){
				reader = new JsonReader(new InputStreamReader(httpUrlConnection.getInputStream()));
				parser = new JsonParser();		
				theJsonElement = parser.parse(reader);				
				reader.close();
			}			
		} catch (MalformedURLException malEx) {
			throw malEx;
		} catch (IOException ioEx) {
			throw ioEx;
		} 
				
		return theJsonElement;
	}
	
	private boolean isSuccessfulResponse(int respCode, String responseMessage){
		boolean retVal = false;

		if (respCode != 200){
			System.err.println ("Error Code " + respCode + " " + responseMessage);
			retVal = false;
		} else {
			retVal = true;
		}
		
		return retVal;
	}

	public URL getUrl() {
		return _url;
	}
}
