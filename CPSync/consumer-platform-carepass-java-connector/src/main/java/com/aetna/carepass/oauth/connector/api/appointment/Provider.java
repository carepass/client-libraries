package com.aetna.carepass.oauth.connector.api.appointment;

public class Provider {

	private String id;
	private String providerFirstName;
	private String providerLastName;
	private String providerSpecialty;
	private String providerIdType;
	private String  providerIdValue;
	
	public String getProviderFirstName() {
		return providerFirstName;
	}
	public void setProviderFirstName(String providerFirstName) {
		this.providerFirstName = providerFirstName;
	}
	public String getProviderLastName() {
		return providerLastName;
	}
	public void setProviderLastName(String providerLastName) {
		this.providerLastName = providerLastName;
	}
	public String getProviderSpecialty() {
		return providerSpecialty;
	}
	public void setProviderSpecialty(String providerSpecialty) {
		this.providerSpecialty = providerSpecialty;
	}
	public String getProviderIdType() {
		return providerIdType;
	}
	public void setProviderIdType(String providerIdType) {
		this.providerIdType = providerIdType;
	}
	public String getProviderIdValue() {
		return providerIdValue;
	}
	public void setProviderIdValue(String providerIdValue) {
		this.providerIdValue = providerIdValue;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	
	
}
