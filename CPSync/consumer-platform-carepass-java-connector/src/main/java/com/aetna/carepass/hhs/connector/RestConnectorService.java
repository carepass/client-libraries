package com.aetna.carepass.hhs.connector;

import java.io.IOException;
import java.net.MalformedURLException;

import com.aetna.carepass.hhs.util.InvalidCredentialException;
import com.google.gson.JsonElement;

public interface RestConnectorService {

	/**
	 * Formats the given String into an URL
	 * 
	 * @param url
	 *            the string to be formatted as URL
	 * @throws MalformedURLException
	 *             if there is a formatting error.
	 */
	public void formatUrl(String url) throws MalformedURLException;

	/**
	 * Executes the request to the REST Service and converts data to JsonArray
	 * 
	 * @return JsonElement representing the json from the REST service
	 * @throws IOException
	 *             , MalformedURLExecption
	 */
	public JsonElement executeQuery() throws IOException, MalformedURLException, InvalidCredentialException;
}
