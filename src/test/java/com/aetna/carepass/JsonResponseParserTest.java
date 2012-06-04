package com.aetna.carepass;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.io.IOException;
import java.io.InputStream;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;
import java.net.HttpURLConnection;

import org.junit.Test;
import org.mockito.Mock;

import com.aetna.carepass.connector.JsonResponseParser;
import com.aetna.carepass.connector.RequestException;
import com.google.gson.JsonElement;

public class JsonResponseParserTest {

	@Mock private HttpURLConnection connection;
	@Mock private InputStream inputStream;
	
	@Test
	public void testParsingResponse_invalidResponse() throws IOException {
		// arrange
		
		PipedOutputStream os = new PipedOutputStream();
		inputStream = new PipedInputStream(os);
		
		String jsonObject = "{ foo: 'bar' }";
		
		os.write(jsonObject.getBytes());
		os.close();
		
		connection = mock(HttpURLConnection.class);
		when(connection.getResponseCode()).thenReturn(404);
		when(connection.getResponseMessage()).thenReturn("Not found");
		when(connection.getInputStream()).thenReturn(inputStream);
		
		JsonResponseParser parser = new JsonResponseParser();
		
		// act
		JsonElement element = null;
		
		try {
			element = parser.parseResponse(connection);
		} catch (RequestException e) {
			assertEquals("Not found", e.getMessage());
			assertEquals(404, e.getCode());
		}
	}
	
	@Test
	public void testParsingResponse_validResponse() throws IOException {
		// arrange
		
		PipedOutputStream os = new PipedOutputStream();
		inputStream = new PipedInputStream(os);
		
		String jsonObject = "{ foo: 'bar' }";
		
		os.write(jsonObject.getBytes());
		os.close();
		
		connection = mock(HttpURLConnection.class);
		when(connection.getResponseCode()).thenReturn(200);
		when(connection.getResponseMessage()).thenReturn("Not found");
		when(connection.getInputStream()).thenReturn(inputStream);
		
		JsonResponseParser parser = new JsonResponseParser();
		
		// act
		JsonElement element = null;
		
		try {
			element = parser.parseResponse(connection);
		} catch (RequestException e) {
			fail("this test should not have failed");
		}
		
		assertEquals("bar", element.getAsJsonObject().getAsJsonPrimitive("foo").getAsString());
	}



}
