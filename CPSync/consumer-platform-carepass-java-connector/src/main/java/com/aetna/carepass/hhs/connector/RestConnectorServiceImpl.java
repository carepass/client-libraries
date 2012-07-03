package com.aetna.carepass.hhs.connector;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

import com.aetna.carepass.hhs.util.InvalidCredentialException;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.google.gson.stream.JsonReader;

public class RestConnectorServiceImpl implements RestConnectorService {

	private URL urlFormatted;

	/**
	 * {@inheritDoc}
	 */
	public void formatUrl(String url) throws MalformedURLException {

		try {
			urlFormatted = new URL(URLEncoder.encode(url, "UTF8")
					.replace("%3A", ":").replace("%2F", "/")
					.replace("%3F", "?").replace("%3D", "=")
					.replace("%26", "&").replace("%2C", ","));
		} catch (UnsupportedEncodingException e) {
			throw new MalformedURLException(e.getMessage());
		}
	}

	/**
	 * {@inheritDoc}
	 * @throws InvalidCredentialException 
	 */
	public JsonElement executeQuery() throws IOException, MalformedURLException, InvalidCredentialException {

		JsonReader reader = null;
		JsonParser parser = null;
		JsonElement theJsonElement = null;

		try {

			HttpURLConnection httpUrlConnection = (HttpURLConnection) this.urlFormatted
					.openConnection();
			this.urlFormatted.openConnection();
			httpUrlConnection.connect();

			if (isSuccessfulResponse(httpUrlConnection.getResponseCode(),
					httpUrlConnection.getResponseMessage())) {
				reader = new JsonReader(new InputStreamReader(
						httpUrlConnection.getInputStream()));
				parser = new JsonParser();
				theJsonElement = parser.parse(reader);
				reader.close();
			}else {
				throw new InvalidCredentialException(httpUrlConnection.getResponseMessage());
			}
		} catch (MalformedURLException malEx) {
			throw malEx;
		} catch (IOException ioEx) {
			throw ioEx;
		}

		return theJsonElement;
	}

	private boolean isSuccessfulResponse(int respCode, String responseMessage) {
		boolean retVal = false;

		if (respCode != 200) {

			retVal = false;
		} else {
			retVal = true;
		}

		return retVal;
	}

}
