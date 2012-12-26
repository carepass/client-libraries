package com.aetna.carepass.oauth.connector.api.appointment;

public class Plan {
	
	private String id;
	private String carrierId;
	private String planId;
	private String subscriberMemberId;
	private String memberId;
	private String groupNumber;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPlanId() {
		return planId;
	}
	public void setPlanId(String planId) {
		this.planId = planId;
	}
	public String getSubscriberMemberId() {
		return subscriberMemberId;
	}
	public void setSubscriberMemberId(String subscriberMemberId) {
		this.subscriberMemberId = subscriberMemberId;
	}
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public String getGroupNumber() {
		return groupNumber;
	}
	public void setGroupNumber(String groupNumber) {
		this.groupNumber = groupNumber;
	}
	public String getCarrierId() {
		return carrierId;
	}
	public void setCarrierId(String carrierId) {
		this.carrierId = carrierId;
	}
	
	
}
