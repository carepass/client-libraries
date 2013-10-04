package com.aetna.carepass.android;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Class for configuring which server to connect to, and how. Useful for 
 * testing with a development CarePass endpoint.
 */
public class CarePassUris implements Parcelable {
	static final String TAG = "CarePassAuth";

	/**
	 * The OAuth URI for acquiring an authorization code.
	 * 
	 * @see https://developer.carepass.com/docs/carepass/
	 */
	public final String OAUTH_AUTH;

	/**
	 * The OAuth URI for acquiring an access token.
	 * 
	 * @see https://developer.carepass.com/docs/carepass/
	 */
	public final String OAUTH_TOKEN;

	private final String IDENTITY_GET = "/user-directory-api/users/currentUser";
	private final String IDENTITY_BIO = "/user-directory-api/users/currentUser/biography";

	/** https://developer.carepass.com/docs/read/carepass/Fitness */

	private final String FITNESS_ALL = "/user-directory-api/users/currentUser/fitness/activities";
	private final String MEASUREMENTS_ALL = "/user-directory-api/users/currentUser/health/body/measurements";
	private final String MEASUREMENTS_LATEST = MEASUREMENTS_ALL + "/latest";

	public final String URL_IDENTITY_GET;
	public final String URL_IDENTITY_BIO;
	public final String URL_FITNESS_ALL;
	public final String URL_MEASUREMENTS_ALL;
	public final String URL_MEASUREMENTS_LATEST;

	public CarePassUris() {
		this(true, "www.carepass.com", "api.carepass.com");
	}

	public CarePassUris(boolean useHttps, String authSite, String webSite) {
		super();
		final String https = useHttps ? "https" : "http";

		final String api = https + "://" + webSite;
		URL_IDENTITY_GET = api + IDENTITY_GET;
		URL_IDENTITY_BIO = api + IDENTITY_BIO;
		URL_FITNESS_ALL = api + FITNESS_ALL;
		URL_MEASUREMENTS_ALL = api + MEASUREMENTS_ALL;
		URL_MEASUREMENTS_LATEST = api + MEASUREMENTS_LATEST;

		final String oauth = https + "://" + authSite + "/carepass/oauth";
		OAUTH_AUTH = oauth + "/authorize";
		OAUTH_TOKEN = oauth + "/token";
	}

	@Override
	public int describeContents() {
		return 0;
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {
		boolean useHttps = OAUTH_AUTH.startsWith("https");
		String authSite = stripSite(useHttps, OAUTH_AUTH);
		String webSite = stripSite(useHttps, URL_IDENTITY_GET);
		dest.writeByte(useHttps ? (byte) 1 : 0);
		dest.writeString(authSite);
		dest.writeString(webSite);
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((OAUTH_AUTH == null) ? 0 : OAUTH_AUTH.hashCode());
		result = prime * result
				+ ((URL_FITNESS_ALL == null) ? 0 : URL_FITNESS_ALL.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CarePassUris other = (CarePassUris) obj;
		if (OAUTH_AUTH == null) {
			if (other.OAUTH_AUTH != null)
				return false;
		} else if (!OAUTH_AUTH.equals(other.OAUTH_AUTH))
			return false;
		if (URL_FITNESS_ALL == null) {
			if (other.URL_FITNESS_ALL != null)
				return false;
		} else if (!URL_FITNESS_ALL.equals(other.URL_FITNESS_ALL))
			return false;
		return true;
	}
	

	private String stripSite(boolean useHttps, String uri) {
		String site = uri.substring(useHttps ? 8 : 7);
		site = site.substring(0, site.indexOf("/"));
		return site;
	}
	
	public static final Parcelable.Creator<CarePassUris> CREATOR
			= new Parcelable.Creator<CarePassUris>() {
		public CarePassUris createFromParcel(Parcel in) {
			boolean useHttps = in.readByte() != 0;
			String authSite = in.readString();
			String webSite = in.readString();
			return new CarePassUris(useHttps, authSite, webSite);
		}

		public CarePassUris[] newArray(int size) {
			return new CarePassUris[size];
		}
	};
}
