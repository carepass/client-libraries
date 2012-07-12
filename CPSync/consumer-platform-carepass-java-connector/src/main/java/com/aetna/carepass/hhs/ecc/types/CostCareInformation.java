package com.aetna.carepass.hhs.ecc.types;

public class CostCareInformation {
	
	private int id;
	private float in;
	private float out;
	private String type;
	private String description;
	private String category;
	private String subcategory;
	private String code;
	private String zip;
	private String lastupdated;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public float getIn() {
		return in;
	}
	public void setIn(float in) {
		this.in = in;
	}
	public float getOut() {
		return out;
	}
	public void setOut(float out) {
		this.out = out;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getSubcategory() {
		return subcategory;
	}
	public void setSubcategory(String subcategory) {
		this.subcategory = subcategory;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getZip() {
		return zip;
	}
	public void setZip(String zip) {
		this.zip = zip;
	}
	public String getLastupdated() {
		return lastupdated;
	}
	public void setLastupdated(String lastupdated) {
		this.lastupdated = lastupdated;
	}
	
	

}
