package com.aetna.carepass.hhs.hhsapi.types;

public class ClinicalTrials {
	
	private String order;
	private String score;
	private String nctid;
	private String url;
	private String title;
	private String statusOpen;
	private String conditionSummary;
	private String lastChanged;

	public String getOrder() {
		return order;
	}

	public void setOrder(String order) {
		this.order = order;
	}

	public String getScore() {
		return score;
	}

	public void setScore(String score) {
		this.score = score;
	}

	public String getNctid() {
		return nctid;
	}

	public void setNctid(String nctid) {
		this.nctid = nctid;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getStatusOpen() {
		return statusOpen;
	}

	public void setStatusOpen(String statusOpen) {
		this.statusOpen = statusOpen;
	}

	public String getConditionSummary() {
		return conditionSummary;
	}

	public void setConditionSummary(String conditionSummary) {
		this.conditionSummary = conditionSummary;
	}

	public String getLastChanged() {
		return lastChanged;
	}

	public void setLastChanged(String lastChanged) {
		this.lastChanged = lastChanged;
	}

}
