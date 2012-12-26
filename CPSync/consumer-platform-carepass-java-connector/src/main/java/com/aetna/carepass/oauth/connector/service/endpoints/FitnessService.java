package com.aetna.carepass.oauth.connector.service.endpoints;

import java.util.List;

import org.springframework.web.bind.annotation.RequestMethod;

import com.aetna.carepass.oauth.connector.api.fitness.Fitness;
import com.aetna.carepass.oauth.connector.service.EndpointException;

public interface FitnessService {
	/**
	 * Retrieves all valid Activity types for look-up purpose.
	 * 
	 * @throws EndpointException
	 */
	public String getFitnessTypes() throws EndpointException;

	/**
	 * Finds a fitness activity by the given id
	 * 
	 * @param id
	 *            the fitness activity's id
	 * @return a Fitness activity for the given id
	 * @throws EndpointException
	 */
	public Fitness findFitnessById(int id) throws EndpointException;

	/**
	 * Find a list of fitness activities according to the given dates
	 * 
	 * @param dateFrom
	 *            <b>required</b> date from
	 * @param dateTo
	 *            date to
	 * @return List of fitness activities
	 * @throws EndpointException
	 */
	public List<Fitness> findFitnessByDate(String dateFrom, String dateTo)
			throws EndpointException;

	/**
	 * Save a fitness activity
	 * 
	 * @param fitness
	 *            the fitness activities that is going to be saved
	 * @param method
	 *            indicates if the operation is a put or post
	 * @return a list of fitness activities endpoint
	 * @throws EndpointException
	 */
	public List<Fitness> saveFitness(List<Fitness> fitness, RequestMethod method)
			throws EndpointException;
}
