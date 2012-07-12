package com.aetna.carepass.hhs.hhsapi.types;

import java.util.List;

public class ClinicalTrialsSearch {
	
	private String totalResults;
	private String totalPages;
	private String page;
	private String order;
	private String score;
	private String nctid;
	private String url;
	private String title;
	private String status;
	private String conditionitionSummary;
	private String lastChanged;
	private List<ClinicalTrials> clinicalTrials;

	public String getTotalResults() {
		return totalResults;
	}

	public void setTotalResults(String totalResults) {
		this.totalResults = totalResults;
	}

	public String getTotalPages() {
		return totalPages;
	}

	public void setTotalPages(String totalPages) {
		this.totalPages = totalPages;
	}

	public String getPage() {
		return page;
	}

	public void setPage(String page) {
		this.page = page;
	}

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

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getConditionitionSummary() {
		return conditionitionSummary;
	}

	public void setConditionitionSummary(String conditionitionSummary) {
		this.conditionitionSummary = conditionitionSummary;
	}

	public String getLastChanged() {
		return lastChanged;
	}

	public void setLastChanged(String lastChanged) {
		this.lastChanged = lastChanged;
	}

	public List<ClinicalTrials> getClinicalTrials() {
		return clinicalTrials;
	}

	public void setClinicalTrials(List<ClinicalTrials> clinicalTrials) {
		this.clinicalTrials = clinicalTrials;
	}
	

}
