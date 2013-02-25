package com.aetna.carepass.android;

import android.os.Parcel;
import android.os.Parcelable;

public class AuthErrorDetails implements Parcelable {
	protected String error;
	
	protected String errorDescription;
	
	public static final Parcelable.Creator<AuthErrorDetails> CREATOR 
	= new Parcelable.Creator<AuthErrorDetails>() {
		@Override
		public AuthErrorDetails[] newArray(int size) {
			return new AuthErrorDetails[size];
		}
		
		@Override
		public AuthErrorDetails createFromParcel(Parcel source) {
		String error = source.readString();
		String errorDescription = source.readString();
		return new AuthErrorDetails(error, errorDescription);
		}
	};

	public AuthErrorDetails(String error, String errorDescription) {
		super();
		this.error = error;
		this.errorDescription = errorDescription;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

	public String getErrorDescription() {
		return errorDescription;
	}

	public void setErrorDescription(String errorDescription) {
		this.errorDescription = errorDescription;
	}
	
	@Override
	public int describeContents() {
		return 0;
	}
	
	@Override
	public void writeToParcel(Parcel dest, int flags) {
		dest.writeString(error);
		dest.writeString(errorDescription);
	}
}
