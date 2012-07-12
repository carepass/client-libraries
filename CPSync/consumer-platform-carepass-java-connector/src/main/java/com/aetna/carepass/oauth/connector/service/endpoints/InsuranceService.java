package com.aetna.carepass.oauth.connector.service.endpoints;

import java.util.List;

import com.aetna.carepass.oauth.connector.api.insurance.Insurance;
import com.aetna.carepass.oauth.connector.service.EndpointException;

public interface InsuranceService {

	/**
	 * Search an insurance's plans by id
	 * 
	 * @param insurancePlansId
	 *            the insurance plan id
	 * @return the found insurance
	 * @throws EndpointException
	 */
	public Insurance findInsurancePlanById(int insurancePlansId)
			throws EndpointException;

	/**
	 * Search a list of insurance's plans
	 * 
	 * @return a List of insurance plans
	 * @throws EndpointException
	 */
	public List<Insurance> findInsurancePlan() throws EndpointException;
}
