package com.aetna.carepass.hhs.hhsapi.types;

public class ResponsibleParty {
	private String organization;
	private String nameTitle;
	private String responsiblePartyType;
	private String investigatorAffiliation;
	private String investigatorFullName;
	private String investigatorTitle;

	public String getOrganization() {
		return organization;
	}

	public void setOrganization(String organization) {
		this.organization = organization;
	}

	public String getNameTitle() {
		return nameTitle;
	}

	public void setNameTitle(String nameTitle) {
		this.nameTitle = nameTitle;
	}

	public String getResponsiblePartyType() {
		return responsiblePartyType;
	}

	public void setResponsiblePartyType(String responsiblePartyType) {
		this.responsiblePartyType = responsiblePartyType;
	}

	public String getInvestigatorAffiliation() {
		return investigatorAffiliation;
	}

	public void setInvestigatorAffiliation(String investigatorAffiliation) {
		this.investigatorAffiliation = investigatorAffiliation;
	}

	public String getInvestigatorFullName() {
		return investigatorFullName;
	}

	public void setInvestigatorFullName(String investigatorFullName) {
		this.investigatorFullName = investigatorFullName;
	}

	public String getInvestigatorTitle() {
		return investigatorTitle;
	}

	public void setInvestigatorTitle(String investigatorTitle) {
		this.investigatorTitle = investigatorTitle;
	}

}
