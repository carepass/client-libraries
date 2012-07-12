package com.aetna.carepass.oauth.connector.service.endpoints;

import com.aetna.carepass.oauth.connector.api.biography.Biography;
import com.aetna.carepass.oauth.connector.service.EndpointException;

public interface BiographyService {

	/**
	 * Find current current user biography.
	 * 
	 * @return {@link Biography}
	 */
	public Biography findBiography() throws EndpointException;
}
