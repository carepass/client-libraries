/**
 * 
 */
package com.aetna.carepass.connector;

/**
 * @author rnorris
 *
 */
public class RequestException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int code;
	
	public RequestException(int code, String message) {
		super(message);
		
		this.code = code;
	}
	
	public int getCode() {
		return code;
	}
}
