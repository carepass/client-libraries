/**
 * 
 */
package com.aetna.carepass.hhs;

import com.aetna.carepass.QueryParameters;


/**
 * @author rnorris
 *
 */
public class ARTSearchParameters extends QueryParameters {
	 
	/**
	 * 
	 */
	private static final long serialVersionUID = -7750652037070003439L;
	private static final String EXACT_MATCH = "exactMatch";
	private static final String YEAR_KEY = "year";
	private static final String MEDICAL_DIRECTOR_KEY = "medicaldirector";
	private static final String STATE_KEY = "state";
	private static final String CITY_KEY = "city";
	private static final String CLINIC_NAME_KEY = "clinicname";

	/**
	 * 
	 * @param clinicName
	 */
	public void setClinicName(String clinicName) {
		put(CLINIC_NAME_KEY, clinicName);
	}
	
	/**
	 * 
	 * @return
	 */
	public String getClinicName() {
		return get(CLINIC_NAME_KEY);
	}
	
	/**
	 * 
	 * @param city
	 */
	public void setCity(String city) {
		put(CITY_KEY, city);
	}
	
	/**
	 * 
	 * @return
	 */
	public String getCity() {
		return get(CITY_KEY);
	}
	
	/**
	 * 
	 * @param state
	 */
	public void setState(String state) {
		put(STATE_KEY, state);
	}
	
	/**
	 * 
	 * @return
	 */
	public String getState() {
		return get(STATE_KEY);
	}
	
	/**
	 * 
	 * @param medicalDirector
	 */
	public void setMedicalDirector(String medicalDirector) {
		put(MEDICAL_DIRECTOR_KEY, medicalDirector);
	}
	
	/**
	 * 
	 * @return
	 */
	public String getMedicalDirector() {
		return get(MEDICAL_DIRECTOR_KEY);
	}
	
	/**
	 * 
	 * @param year
	 */
	public void setYear(String year) {
		put(YEAR_KEY, year);
	}
	
	/**
	 * 
	 * @return
	 */
	public String getYear() {
		return get(YEAR_KEY);	
	}
	
	/**
	 * 
	 * @param exactMatch
	 */
	public void setExactMatch(boolean exactMatch) {
		put(EXACT_MATCH, Boolean.toString(exactMatch));
	}
	
	/**
	 * 
	 * @return
	 */
	public boolean getExactMatch() {
		return new Boolean(get(EXACT_MATCH)).booleanValue();
	}
	
	
}
