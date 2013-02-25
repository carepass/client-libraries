package com.aetna.carepass.android;

import android.os.Parcel;
import android.os.Parcelable;

public class AuthResponseDetails implements Parcelable {

	private long expiry;

	private String receivedScope;
	
	private String accessToken;
	
	public static final Parcelable.Creator<AuthResponseDetails> CREATOR
		= new Creator<AuthResponseDetails>() {
			@Override
			public AuthResponseDetails[] newArray(int size) {
				return new AuthResponseDetails[size];
			}
			
			@Override
			public AuthResponseDetails createFromParcel(Parcel source) {
				long expiry = source.readLong();
				String scope = source.readString();
				String token = source.readString();
				return new AuthResponseDetails(expiry, scope, token);
			}
		};

	public AuthResponseDetails(long expiry, String receivedScope, String token) {
		super();
		this.expiry = expiry;
		this.receivedScope = receivedScope;
		this.accessToken = token;
	}

	public long getExpiry() {
		return expiry;
	}

	public void setExpiry(long expiry) {
		this.expiry = expiry;
	}

	public String getReceivedScope() {
		return receivedScope;
	}

	public void setReceivedScope(String receivedScope) {
		this.receivedScope = receivedScope;
	}
	
	public String getAccessToken() {
		return accessToken;
	}

	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}

	@Override
	public int describeContents() {
		return 0;
	}
	@Override
	public void writeToParcel(Parcel dest, int flags) {
		dest.writeLong(expiry);
		dest.writeString(receivedScope);
		dest.writeString(accessToken);
	}

}
