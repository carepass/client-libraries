/**
 * 
 */
package com.aetna.carepass.connector;

/**
 * @author rnorris
 *
 */
public abstract class CarePassApi {
	private String apiKey;
	private RESTConnector restConnector;

	/**
	 * 
	 * @return
	 */
	public String getApiKey() {
		return apiKey;
	}
	
	/**
	 * 
	 * @param apiKey
	 */
	public void setApiKey(String apiKey) {
		this.apiKey = apiKey;
	}
	
	/**
	 * 
	 * @return
	 */
	public RESTConnector getRestConnector() {
		return restConnector;
	}
	
	/**
	 * 
	 * @param restConnector
	 */
	public void setRestConnector(RESTConnector restConnector) {
		this.restConnector = restConnector;
	}
}
