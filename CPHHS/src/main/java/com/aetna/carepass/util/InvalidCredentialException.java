/**
 * 
 */
package com.aetna.carepass.util;

/**
 * @author n309169
 *
 */
public class InvalidCredentialException extends Exception {
	
	private String data;
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -3155515161537082843L;
	
	public InvalidCredentialException(String pData){
		data = pData;		
	}

	public String getData() {
		return data;
	}

}
