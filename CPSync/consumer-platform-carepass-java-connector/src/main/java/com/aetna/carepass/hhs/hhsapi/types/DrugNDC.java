package com.aetna.carepass.hhs.hhsapi.types;

import java.util.List;

public class DrugNDC {

	private String nda;
	private String ndc2Segment;
	private String strength;
	private String labelerName;
	private String proprietaryName;
	private String unit;
	private String nonProprietaryName;
	private String substanceName;
	private String dosageFormname;
	private String routeName;
	private String startMarketing_date;
	private String endMarketing_date;
	private List<DrugPackageInfo> packageInfo;
	public String getNda() {
		return nda;
	}
	public void setNda(String nda) {
		this.nda = nda;
	}
	public String getNdc2Segment() {
		return ndc2Segment;
	}
	public void setNdc2Segment(String ndc2Segment) {
		this.ndc2Segment = ndc2Segment;
	}
	public String getStrength() {
		return strength;
	}
	public void setStrength(String strength) {
		this.strength = strength;
	}
	public String getLabelerName() {
		return labelerName;
	}
	public void setLabelerName(String labelerName) {
		this.labelerName = labelerName;
	}
	public String getProprietaryName() {
		return proprietaryName;
	}
	public void setProprietaryName(String proprietaryName) {
		this.proprietaryName = proprietaryName;
	}
	public String getUnit() {
		return unit;
	}
	public void setUnit(String unit) {
		this.unit = unit;
	}
	public String getNonProprietaryName() {
		return nonProprietaryName;
	}
	public void setNonProprietaryName(String nonProprietaryName) {
		this.nonProprietaryName = nonProprietaryName;
	}
	public String getSubstanceName() {
		return substanceName;
	}
	public void setSubstanceName(String substanceName) {
		this.substanceName = substanceName;
	}
	public String getDosageFormname() {
		return dosageFormname;
	}
	public void setDosageFormname(String dosageFormname) {
		this.dosageFormname = dosageFormname;
	}
	public String getRouteName() {
		return routeName;
	}
	public void setRouteName(String routeName) {
		this.routeName = routeName;
	}
	public String getStartMarketing_date() {
		return startMarketing_date;
	}
	public void setStartMarketing_date(String startMarketing_date) {
		this.startMarketing_date = startMarketing_date;
	}
	public String getEndMarketing_date() {
		return endMarketing_date;
	}
	public void setEndMarketing_date(String endMarketing_date) {
		this.endMarketing_date = endMarketing_date;
	}
	public List<DrugPackageInfo> getPackageInfo() {
		return packageInfo;
	}
	public void setPackageInfo(List<DrugPackageInfo> packageInfo) {
		this.packageInfo = packageInfo;
	}
		
	
}
