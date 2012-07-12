package com.aetna.carepass.hhs.ecc.types;

public class Cpt {
	
	private String shortName;
	private String longName;
	private String cptCode;
	public String getShortName() {
		return shortName;
	}
	public void setShortName(String shortName) {
		this.shortName = shortName;
	}
	public String getLongName() {
		return longName;
	}
	public void setLongName(String longName) {
		this.longName = longName;
	}
	public String getCptCode() {
		return cptCode;
	}
	public void setCptCode(String cptCode) {
		this.cptCode = cptCode;
	}
	
	
}
