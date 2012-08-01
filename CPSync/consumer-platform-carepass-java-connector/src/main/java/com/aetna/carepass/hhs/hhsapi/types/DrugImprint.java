package com.aetna.carepass.hhs.hhsapi.types;

/**
 * 
 * Imprint information
 *
 */
public class DrugImprint {

	private String size;
	private String symbol;
	private String pillColor;
	private double score;
	private String shape;
	private String textColor;
	public String getSize() {
		return size;
	}
	public void setSize(String size) {
		this.size = size;
	}
	public String getSymbol() {
		return symbol;
	}
	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}
	public String getPillColor() {
		return pillColor;
	}
	public void setPillColor(String pillColor) {
		this.pillColor = pillColor;
	}
	public double getScore() {
		return score;
	}
	public void setScore(double score) {
		this.score = score;
	}
	public String getShape() {
		return shape;
	}
	public void setShape(String shape) {
		this.shape = shape;
	}
	public String getTextColor() {
		return textColor;
	}
	public void setTextColor(String textColor) {
		this.textColor = textColor;
	}
	
	
}
