package com.aetna.carepass.hhs.hhsapi.types;

import java.util.List;

/**
 * 
 * Package Info of a drug
 *
 */
public class DrugPackageInfo {
	private String ndc3Segment;
	private String packageDescription;
	private List<DrugImprint> imprint;

	public String getNdc3Segment() {
		return ndc3Segment;
	}

	public void setNdc3Segment(String ndc3Segment) {
		this.ndc3Segment = ndc3Segment;
	}

	public String getPackageDescription() {
		return packageDescription;
	}

	public void setPackageDescription(String packageDescription) {
		this.packageDescription = packageDescription;
	}

	public List<DrugImprint> getImprint() {
		return imprint;
	}

	public void setImprint(List<DrugImprint> imprint) {
		this.imprint = imprint;
	}

}
