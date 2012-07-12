package com.aetna.carepass.hhs.claims.types;

public class Claim {
	
	private String ndc;
	private String ndc11digit;
	private String gender;
	private String birthYear;
	private String prescSpecialty;
	private String dispenseQuarter;
	private String generic;
	private String newRefillCount;
	private String unitsDispensedQuantity;
	private String daysSupplyCount;
	private String threeDigitSubsZip;
	private String threeDigitPhmZip;

	public String getNdc() {
		return ndc;
	}

	public void setNdc(String ndc) {
		this.ndc = ndc;
	}

	public String getNdc11digit() {
		return ndc11digit;
	}

	public void setNdc11digit(String ndc11digit) {
		this.ndc11digit = ndc11digit;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getBirthYear() {
		return birthYear;
	}

	public void setBirthYear(String birthYear) {
		this.birthYear = birthYear;
	}

	public String getPrescSpecialty() {
		return prescSpecialty;
	}

	public void setPrescSpecialty(String prescSpecialty) {
		this.prescSpecialty = prescSpecialty;
	}

	public String getDispenseQuarter() {
		return dispenseQuarter;
	}

	public void setDispenseQuarter(String dispenseQuarter) {
		this.dispenseQuarter = dispenseQuarter;
	}

	public String getGeneric() {
		return generic;
	}

	public void setGeneric(String generic) {
		this.generic = generic;
	}

	public String getNewRefillCount() {
		return newRefillCount;
	}

	public void setNewRefillCount(String newRefillCount) {
		this.newRefillCount = newRefillCount;
	}

	public String getUnitsDispensedQuantity() {
		return unitsDispensedQuantity;
	}

	public void setUnitsDispensedQuantity(String unitsDispensedQuantity) {
		this.unitsDispensedQuantity = unitsDispensedQuantity;
	}

	public String getDaysSupplyCount() {
		return daysSupplyCount;
	}

	public void setDaysSupplyCount(String daysSupplyCount) {
		this.daysSupplyCount = daysSupplyCount;
	}

	public String getThreeDigitSubsZip() {
		return threeDigitSubsZip;
	}

	public void setThreeDigitSubsZip(String threeDigitSubsZip) {
		this.threeDigitSubsZip = threeDigitSubsZip;
	}

	public String getThreeDigitPhmZip() {
		return threeDigitPhmZip;
	}

	public void setThreeDigitPhmZip(String threeDigitPhmZip) {
		this.threeDigitPhmZip = threeDigitPhmZip;
	}

}
