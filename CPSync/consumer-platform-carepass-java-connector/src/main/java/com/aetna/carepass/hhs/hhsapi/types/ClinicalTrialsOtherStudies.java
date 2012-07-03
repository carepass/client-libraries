package com.aetna.carepass.hhs.hhsapi.types;

import java.util.List;

public class ClinicalTrialsOtherStudies {
	private List<String> secondaryId;
	private List<String> orgStudyId;

	public List<String> getSecondaryId() {
		return secondaryId;
	}

	public void setSecondaryId(List<String> secondaryId) {
		this.secondaryId = secondaryId;
	}

	public List<String> getOrgStudyId() {
		return orgStudyId;
	}

	public void setOrgStudyId(List<String> orgStudyId) {
		this.orgStudyId = orgStudyId;
	}

}
