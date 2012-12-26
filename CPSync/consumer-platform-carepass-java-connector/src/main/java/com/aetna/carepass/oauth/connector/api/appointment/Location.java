package com.aetna.carepass.oauth.connector.api.appointment;

public class Location {

	private String facilityName;
	private String id;
	private String line1;
	private String line2;
	private String city;
	private String state;
	private String postalCode;
	private String postalCodeExtended;
	private String country;
	
	public String getFacilityName() {
		return facilityName;
	}
	public void setFacilityName(String facilityName) {
		this.facilityName = facilityName;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getLine1() {
		return line1;
	}
	public void setLine1(String line1) {
		this.line1 = line1;
	}
	public String getLine2() {
		return line2;
	}
	public void setLine2(String line2) {
		this.line2 = line2;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getPostalCode() {
		return postalCode;
	}
	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}
	public String getPostalCodeExtended() {
		return postalCodeExtended;
	}
	public void setPostalCodeExtended(String postalCodeExtended) {
		this.postalCodeExtended = postalCodeExtended;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	
	
	

}
