package com.aetna.carepass.oauth.connector.api.biography;

public class EmailAddress {
private int id;
private String address;
private boolean isPrimary;
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getAddress() {
	return address;
}
public void setAddress(String address) {
	this.address = address;
}
public boolean isPrimary() {
	return isPrimary;
}
public void setPrimary(boolean isPrimary) {
	this.isPrimary = isPrimary;
}


}
