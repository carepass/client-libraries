package com.aetna.carepass.hhs.hhsapi.types;

public class DrugSearch {
	
	private String proprietaryName;
	private String ndc;
	private String nonProprietaryName;

	public String getProprietaryName() {
		return proprietaryName;
	}

	public void setProprietaryName(String proprietaryName) {
		this.proprietaryName = proprietaryName;
	}

	public String getNdc() {
		return ndc;
	}

	public void setNdc(String ndc) {
		this.ndc = ndc;
	}

	public String getNonProprietaryName() {
		return nonProprietaryName;
	}

	public void setNonProprietaryName(String nonProprietaryName) {
		this.nonProprietaryName = nonProprietaryName;
	}

}
