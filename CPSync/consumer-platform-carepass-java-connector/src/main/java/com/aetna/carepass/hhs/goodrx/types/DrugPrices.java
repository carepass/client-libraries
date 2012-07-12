package com.aetna.carepass.hhs.goodrx.types;

import java.util.List;

public class DrugPrices {

	private String form;
	private String url;
	private String mobile_url;
	private String display;
	private String dosage;
	private String manufacturer;
	private String quantity;
	private List<String> generic;
	private List<Double> price;
	private List<String> brand;

	public String getForm() {
		return form;
	}

	public void setForm(String form) {
		this.form = form;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getMobile_url() {
		return mobile_url;
	}

	public void setMobile_url(String mobile_url) {
		this.mobile_url = mobile_url;
	}

	public String getDisplay() {
		return display;
	}

	public void setDisplay(String display) {
		this.display = display;
	}

	public String getDosage() {
		return dosage;
	}

	public void setDosage(String dosage) {
		this.dosage = dosage;
	}

	public String getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}

	public String getQuantity() {
		return quantity;
	}

	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}

	public List<String> getGeneric() {
		return generic;
	}

	public void setGeneric(List<String> generic) {
		this.generic = generic;
	}

	public List<Double> getPrice() {
		return price;
	}

	public void setPrice(List<Double> price) {
		this.price = price;
	}

	public List<String> getBrand() {
		return brand;
	}

	public void setBrand(List<String> brand) {
		this.brand = brand;
	}

}
