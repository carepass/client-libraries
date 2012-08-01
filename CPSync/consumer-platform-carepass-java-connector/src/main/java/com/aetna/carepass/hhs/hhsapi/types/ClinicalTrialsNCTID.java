package com.aetna.carepass.hhs.hhsapi.types;

public class ClinicalTrialsNCTID {
	private String trialId;
	private String sponsor;
	private String phase;
	private String officialTitle;
	private String enrollmentNumber;
	private String studyStartDate;
	private String gendersEligible;
	private String acceptsHealthyVolunteers;
	private String studyFirstReceived;
	private String lastUpdated;
	private String healthAuthority;
	private String urlClinicalTrials;
	private ClinicalTrialsOtherStudies otherStudyIds;
	private UrlContactInformation urlContactInformation;
	private AgesEligible agesEligible;
	private ResponsibleParty responsibleParty;

	public String getTrialId() {
		return trialId;
	}

	public void setTrialId(String trialId) {
		this.trialId = trialId;
	}

	public String getSponsor() {
		return sponsor;
	}

	public void setSponsor(String sponsor) {
		this.sponsor = sponsor;
	}

	public String getPhase() {
		return phase;
	}

	public void setPhase(String phase) {
		this.phase = phase;
	}

	public String getOfficialTitle() {
		return officialTitle;
	}

	public void setOfficialTitle(String officialTitle) {
		this.officialTitle = officialTitle;
	}

	public String getEnrollmentNumber() {
		return enrollmentNumber;
	}

	public void setEnrollmentNumber(String enrollmentNumber) {
		this.enrollmentNumber = enrollmentNumber;
	}

	public String getStudyStartDate() {
		return studyStartDate;
	}

	public void setStudyStartDate(String studyStartDate) {
		this.studyStartDate = studyStartDate;
	}

	public String getGendersEligible() {
		return gendersEligible;
	}

	public void setGendersEligible(String gendersEligible) {
		this.gendersEligible = gendersEligible;
	}

	public String getAcceptsHealthyVolunteers() {
		return acceptsHealthyVolunteers;
	}

	public void setAcceptsHealthyVolunteers(String acceptsHealthyVolunteers) {
		this.acceptsHealthyVolunteers = acceptsHealthyVolunteers;
	}

	public String getStudyFirstReceived() {
		return studyFirstReceived;
	}

	public void setStudyFirstReceived(String studyFirstReceived) {
		this.studyFirstReceived = studyFirstReceived;
	}

	public String getLastUpdated() {
		return lastUpdated;
	}

	public void setLastUpdated(String lastUpdated) {
		this.lastUpdated = lastUpdated;
	}

	public String getHealthAuthority() {
		return healthAuthority;
	}

	public void setHealthAuthority(String healthAuthority) {
		this.healthAuthority = healthAuthority;
	}

	public String getUrlClinicalTrials() {
		return urlClinicalTrials;
	}

	public void setUrlClinicalTrials(String urlClinicalTrials) {
		this.urlClinicalTrials = urlClinicalTrials;
	}

	public ClinicalTrialsOtherStudies getOtherStudyIds() {
		return otherStudyIds;
	}

	public void setOtherStudyIds(ClinicalTrialsOtherStudies otherStudyIds) {
		this.otherStudyIds = otherStudyIds;
	}

	public UrlContactInformation getUrlContactInformation() {
		return urlContactInformation;
	}

	public void setUrlContactInformation(UrlContactInformation urlContactInformation) {
		this.urlContactInformation = urlContactInformation;
	}

	public AgesEligible getAgesEligible() {
		return agesEligible;
	}

	public void setAgesEligible(AgesEligible agesEligible) {
		this.agesEligible = agesEligible;
	}

	public ResponsibleParty getResponsibleParty() {
		return responsibleParty;
	}

	public void setResponsibleParty(ResponsibleParty responsibleParty) {
		this.responsibleParty = responsibleParty;
	}

	
}
