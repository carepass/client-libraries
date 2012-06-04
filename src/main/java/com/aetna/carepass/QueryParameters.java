/**
 * 
 */
package com.aetna.carepass;

import java.util.HashMap;

/**
 * @author rnorris
 *
 */
public abstract class QueryParameters extends HashMap<String, String> {

	private static final String STRING_EQUALS = "=";
	private static final String STRING_AMPERSAND = "&";

	/**
	 * 
	 */
	private static final long serialVersionUID = -2085535302106838929L;

	public final void setApiKey(String key) {
		put("apikey", key);
	}

	/**
	 * @return
	 */
	public String toQueryString() {
		StringBuffer queryStringBuffer = new StringBuffer();
		
		for(String key : keySet()) {
			StringBuffer pairBuffer = new StringBuffer();
			pairBuffer.append(key).append(STRING_EQUALS).append(get(key));
			queryStringBuffer.append(pairBuffer.toString()).append(STRING_AMPERSAND);
		}
		
		String queryString = queryStringBuffer.deleteCharAt(queryStringBuffer.lastIndexOf(STRING_AMPERSAND)).toString();
		return queryString;
	}
	
	@Override
	public String toString() {
		return toQueryString();
	}
}
