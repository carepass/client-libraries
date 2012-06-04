/**
 * 
 */
package com.aetna.carepass.hhs;

import com.aetna.carepass.QueryParameters;

/**
 * @author rnorris
 *
 */
public class DrugSearchParameters extends QueryParameters {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -7416322761007175671L;

	/**
	 * 
	 * @return
	 */
	public String getDrugName() {
		return get("drugName");
	}
	
	/**
	 * 
	 * @param drugName
	 */
	public void setDrugName(String drugName) {
		put("drugName", drugName);
	}
}
