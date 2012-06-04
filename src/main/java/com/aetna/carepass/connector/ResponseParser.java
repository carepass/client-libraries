package com.aetna.carepass.connector;

import java.io.IOException;
import java.net.HttpURLConnection;

import com.google.gson.JsonElement;

public interface ResponseParser {

	public abstract JsonElement parseResponse(
			HttpURLConnection httpURLConnection) throws IOException,
			RequestException;

}