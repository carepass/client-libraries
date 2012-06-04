/**
 * 
 */
package com.aetna.carepass.connector;

import java.io.IOException;

import com.google.gson.JsonElement;


/**
 * @author n309169
 *
 */
public interface Connector {
	/**
	 * 
	 * @return
	 * @throws RequestException
	 */
	public JsonElement executeQuery() throws RequestException, IOException;
}
