package com.aetna.carepass.hhs.hhsapi.types;

/**
 * 
 * This class is used to contain the images for a drug according to the NDC2 segment
 * code.
 * 
 */
public class DrugImage {

	private String imgURL;

	public void setImgURL(String imgURL) {
		this.imgURL = imgURL;
	}

	public String getImgURL() {
		return this.imgURL;
	}
}
