package com.aetna.carepass.oauth.connector.api.appointment;

public class Appointment {

	private String appointmentStart;
	private String appointmentEnd;
	private String scheduledDate;
	private String type;
	private String reason;
	private int npiProviderId;
	private String facilityName;
	private String line1;
	private String line2;
	private String city;
	private String state;
	private String postalCode;
	private int carrierId;
	private int planId;
	private int carepassProviderId;
	private String status;
	private String id;

	public String getAppointmentStart() {
		return appointmentStart;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setAppointmentStart(String appointmentStart) {
		this.appointmentStart = appointmentStart;
	}

	public String getAppointmentEnd() {
		return appointmentEnd;
	}

	public void setAppointmentEnd(String appointmentEnd) {
		this.appointmentEnd = appointmentEnd;
	}

	public String getScheduledDate() {
		return scheduledDate;
	}

	public void setScheduledDate(String scheduledDate) {
		this.scheduledDate = scheduledDate;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public int getNpiProviderId() {
		return npiProviderId;
	}

	public void setNpiProviderId(int npiProviderId) {
		this.npiProviderId = npiProviderId;
	}

	public String getFacilityName() {
		return facilityName;
	}

	public void setFacilityName(String facilityName) {
		this.facilityName = facilityName;
	}

	public String getLine1() {
		return line1;
	}

	public void setLine1(String line1) {
		this.line1 = line1;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public int getCarrierId() {
		return carrierId;
	}

	public void setCarrierId(int carrierId) {
		this.carrierId = carrierId;
	}

	public int getPlanId() {
		return planId;
	}

	public void setPlanId(int planId) {
		this.planId = planId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getLine2() {
		return line2;
	}

	public void setLine2(String line2) {
		this.line2 = line2;
	}

	public int getCarepassProviderId() {
		return carepassProviderId;
	}

	public void setCarepassProviderId(int carepassProviderId) {
		this.carepassProviderId = carepassProviderId;
	}

}
