package com.aetna.carepass.android;

import android.os.Parcel;
import android.os.Parcelable;

public class AuthRequestDetails implements Parcelable {
	private String apiKey;

	private String sharedSecret;

	private String redirectUri;

	private String requestedScope = "IDENTITY";

	public static final Parcelable.Creator<AuthRequestDetails> CREATOR 
		= new Creator<AuthRequestDetails>() {
			@Override
			public AuthRequestDetails[] newArray(int size) {
				return new AuthRequestDetails[size];
			}
			
			@Override
			public AuthRequestDetails createFromParcel(Parcel source) {
			String apiKey = source.readString();
			String sharedSecret = source.readString();
			String redirectUri = source.readString();
			String requestedScope = source.readString();
			return new AuthRequestDetails(apiKey, sharedSecret, redirectUri,
					requestedScope);
			}
		};
	public AuthRequestDetails(String apiKey, String sharedSecret,
			String redirectUri, String requestedScope) {
		super();
		this.apiKey = apiKey;
		this.sharedSecret = sharedSecret;
		this.redirectUri = redirectUri;
		this.requestedScope = requestedScope;
	}

	public String getApiKey() {
		return apiKey;
	}

	public void setApiKey(String apiKey) {
		this.apiKey = apiKey;
	}

	public String getSharedSecret() {
		return sharedSecret;
	}

	public void setSharedSecret(String sharedSecret) {
		this.sharedSecret = sharedSecret;
	}

	public String getRedirectUri() {
		return redirectUri;
	}

	public void setRedirectUri(String redirectUri) {
		this.redirectUri = redirectUri;
	}

	public String getRequestedScope() {
		return requestedScope;
	}

	public void setRequestedScope(String requestedScope) {
		this.requestedScope = requestedScope;
	}

	@Override
	public int describeContents() {
		return 0;
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {
		dest.writeString(apiKey);
		dest.writeString(sharedSecret);
		dest.writeString(redirectUri);
		dest.writeString(requestedScope);
	}
	
	

}
