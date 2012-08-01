package com.aetna.carepass.hhs.hhsapi.types;

import java.util.List;

public class ART {

	private String currClinNameAll;
	private String clinCityCode;
	private String clinStateCode;
	private String stateCode;
	private List<ARTYearHistory> yearHistory;

	public String getCurrClinNameAll() {
		return currClinNameAll;
	}

	public void setCurrClinNameAll(String currClinNameAll) {
		this.currClinNameAll = currClinNameAll;
	}

	public String getClinCityCode() {
		return clinCityCode;
	}

	public void setClinCityCode(String clinCityCode) {
		this.clinCityCode = clinCityCode;
	}

	public String getClinStateCode() {
		return clinStateCode;
	}

	public void setClinStateCode(String clinStateCode) {
		this.clinStateCode = clinStateCode;
	}

	public String getStateCode() {
		return stateCode;
	}

	public void setStateCode(String stateCode) {
		this.stateCode = stateCode;
	}

	public List<ARTYearHistory> getYearHistory() {
		return yearHistory;
	}

	public void setYearHistory(List<ARTYearHistory> yearHistory) {
		this.yearHistory = yearHistory;
	}

}
