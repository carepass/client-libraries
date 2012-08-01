package com.aetna.carepass.hhs.hhsapi.types;

import java.util.List;

public class Alternative {
	
	private List<Drug> drugs;
	private String dosageForm;
	private String dosageRoute;
	private String strength;

	public List<Drug> getDrugs() {
		return drugs;
	}

	public void setDrugs(List<Drug> drugs) {
		this.drugs = drugs;
	}

	public String getDosageForm() {
		return dosageForm;
	}

	public void setDosageForm(String dosageForm) {
		this.dosageForm = dosageForm;
	}

	public String getDosageRoute() {
		return dosageRoute;
	}

	public void setDosageRoute(String dosageRoute) {
		this.dosageRoute = dosageRoute;
	}

	public String getStrength() {
		return strength;
	}

	public void setStrength(String strength) {
		this.strength = strength;
	}

}
