package com.aetna.carepass.oauth.connector.api.appointment;

public class Appointment {

	private String id;
	private String date;
	private String startTime;
	private String endTime;
	private String scheduledDate;
	private String scheduledTime;
	private String reason;
	private String type;
	private String status;
	private Location location = new Location();
	private  Plan plan = new Plan();
	private Provider provider = new Provider();
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getStartTime() {
		return startTime;
	}
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}
	public String getEndTime() {
		return endTime;
	}
	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}
	public String getScheduledDate() {
		return scheduledDate;
	}
	public void setScheduledDate(String scheduledDate) {
		this.scheduledDate = scheduledDate;
	}
	public String getScheduledTime() {
		return scheduledTime;
	}
	public void setScheduledTime(String scheduledTime) {
		this.scheduledTime = scheduledTime;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	public Location getLocation() {
		return location;
	}
	public void setLocation(Location location) {
		this.location = location;
	}
	public Plan getPlan() {
		return plan;
	}
	public void setPlan(Plan plan) {
		this.plan = plan;
	}
	public Provider getProvider() {
		return provider;
	}
	public void setProvider(Provider provider) {
		this.provider = provider;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	
	
	
}
