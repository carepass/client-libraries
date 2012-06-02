package com.aetna.api.dataTypes.hhs;

public class DrugResource {
	private String value;
	
	public DrugResource (String theValue){
		setValue(theValue);
	}

	/**
	 * @return the value
	 */
	public String getValue() {
		return value;
	}

	/**
	 * @param value the value to set
	 */
	public void setValue(String value) {
		this.value = value;
	}

}
