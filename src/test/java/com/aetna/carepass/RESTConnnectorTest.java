/**
 * 
 */
package com.aetna.carepass;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import com.aetna.carepass.connector.RESTConnector;
import com.aetna.carepass.connector.RequestException;
import com.aetna.carepass.connector.ResponseParser;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

/**
 * @author rnorris
 *
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest({ URL.class, RESTConnector.class })
public class RESTConnnectorTest {
	
	// @Mock private URL url;
	@Mock private HttpURLConnection urlConnection;
	@Mock private ResponseParser responseParser;
	
	@Test
	public void testExecuteQuery_success() throws RequestException, MalformedURLException {
		// arrange
		
		JsonParser jsonParser = null;
		JsonElement jsonObject = null;
		
		jsonParser = new JsonParser();
		jsonObject = jsonParser.parse("{ \"foo\" : \"bar\" }");
		
		responseParser = mock(ResponseParser.class);
		
		try {
			doReturn(jsonObject).when(responseParser).parseResponse(urlConnection);
		} catch (Exception e) {
			fail("we're giving a proper response, but: " + e.getMessage());
		}
		
		URL url = PowerMockito.mock(URL.class);

		try {
			when(url.openConnection()).thenReturn(urlConnection);

			RESTConnector connector = new RESTConnector();
			connector.setUrl(url);
			connector.setResponseParser(responseParser);
			
			// act
			JsonElement element = connector.executeQuery();
			
			// assert
			verify(urlConnection).connect();
			assertEquals("bar", element.getAsJsonObject().get("foo").getAsJsonPrimitive().getAsString());
		} catch (IOException e) {
			fail("got some ioexception");
		}
	}
	
	@Test(expected=RequestException.class)
	public void testExecuteQuery_failure() throws RequestException, MalformedURLException {
		// arrange
		
		URL url = PowerMockito.mock(URL.class);
		
		JsonParser parser = new JsonParser();
		
		responseParser = mock(ResponseParser.class);
		
		try {
			RequestException re = new RequestException(403, "Forbidden");
			doThrow(re).when(responseParser).parseResponse(urlConnection);
		} catch (Exception e) {
			fail("we're giving a proper response, but: " + e.getMessage());
		}

		try {
			when(url.openConnection()).thenReturn(urlConnection);
			
			RESTConnector connector = new RESTConnector();
			connector.setUrl(url);
			connector.setResponseParser(responseParser);
			
			// act
			JsonElement element = connector.executeQuery();
			
			// assert
			verify(urlConnection).connect();
			assertEquals("bar", element.getAsJsonObject().get("foo").getAsJsonPrimitive().getAsString());
		} catch (IOException e) {
			fail("got some ioexception");
		}
	}

}
