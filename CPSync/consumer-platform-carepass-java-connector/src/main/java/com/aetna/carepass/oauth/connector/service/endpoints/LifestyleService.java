package com.aetna.carepass.oauth.connector.service.endpoints;

import com.aetna.carepass.oauth.connector.api.lifestyle.Lifestyle;
import com.aetna.carepass.oauth.connector.service.EndpointException;

public interface LifestyleService {

	/**
	 * Creates or update lifestyle parameters
	 * 
	 * @param lifeStyle
	 *            the lifestyle parameters
	 * @return the saved lifestyle parameters
	 * @throws EndpointException
	 */
	public Lifestyle saveLifestyle(Lifestyle lifeStyle)
			throws EndpointException;

	/**
	 * Finds lifestyle parameters
	 * 
	 * @return the found parameters
	 * @throws EndpointException
	 */
	public Lifestyle findLifeStyle() throws EndpointException;
}
