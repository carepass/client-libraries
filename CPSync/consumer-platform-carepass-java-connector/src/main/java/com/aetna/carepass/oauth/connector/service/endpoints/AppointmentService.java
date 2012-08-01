package com.aetna.carepass.oauth.connector.service.endpoints;

import java.util.List;

import org.springframework.web.bind.annotation.RequestMethod;

import com.aetna.carepass.oauth.connector.api.appointment.Appointment;
import com.aetna.carepass.oauth.connector.service.EndpointException;

public interface AppointmentService {

	/**
	 * Search for appointments based on the given id
	 * 
	 * @param id
	 *            the appointment's identification
	 * @return a one element List of appointment
	 * @throws EndpointException
	 */
	public List<Appointment> findAppointmentById(int id)
			throws EndpointException;

	/**
	 * Search for existent appointments
	 * 
	 * @param afterDate
	 *            After appointment creation
	 * 
	 * @param carepassProviderId
	 *            Carepass Provider Id
	 * 
	 * @param npiProviderId
	 *            National identidier for providers
	 * 
	 * @return a list of appointments
	 * @throws EndpointException
	 */
	public List<Appointment> findAppointment(String afterDate,
			String carepassProviderId, String npiProviderId)
			throws EndpointException;

	public Appointment saveAppointment(Appointment appointment,
			RequestMethod method) throws EndpointException;
}
