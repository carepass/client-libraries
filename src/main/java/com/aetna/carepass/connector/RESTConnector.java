package com.aetna.carepass.connector;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

import com.aetna.carepass.JsonResponseParserTest;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.google.gson.stream.JsonReader;

public class RESTConnector implements Connector {

	private ResponseParser responseParser;
	private URL url;

	/**
	 * 
	 */
	public URL getUrl() {
		return url;
	}
	
	/**
	 * 
	 */
	public RESTConnector() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * 
	 * @param url
	 */
	public void setUrl(URL url) {
		this.url = url;
	}
	
	/**
	 * 
	 * @param url
	 */
	public RESTConnector(URL url) {
		this.url = url;
	}
	
	/**
	 * 
	 * @param url
	 * @deprecated
	 * @throws MalformedURLException
	 */
	public RESTConnector(String url) throws MalformedURLException {
		this.url = new URL(url);
	}

	/**
	 * 
	 * @return
	 */
	public ResponseParser getResponseParser() {
		return responseParser;
	}

	/**
	 * 
	 * @param responseParser
	 */
	public void setResponseParser(ResponseParser responseParser) {
		this.responseParser = responseParser;
	}

	/**
	 * @return
	 * @throws IOException
	 * @throws RequestException
	 */
	public JsonElement executeQuery() throws RequestException, IOException {
		HttpURLConnection urlConnection = (HttpURLConnection) url
				.openConnection();
		urlConnection.connect();

		JsonElement responseElement = responseParser
				.parseResponse(urlConnection);
		return responseElement;
	}
}
