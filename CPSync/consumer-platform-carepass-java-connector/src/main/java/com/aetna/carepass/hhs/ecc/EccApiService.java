package com.aetna.carepass.hhs.ecc;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.List;

import com.aetna.carepass.hhs.ecc.types.Categories;
import com.aetna.carepass.hhs.ecc.types.CostCareInformation;
import com.aetna.carepass.hhs.ecc.types.Cpt;
import com.aetna.carepass.hhs.util.InvalidCredentialException;

public interface EccApiService {

	/**
	 * Retrieve the Medical Estimated Cost of Care Information based on the CPT,
	 * LAT, LNG
	 * 
	 * @param cpt
	 *            Current procedural terminology code
	 * @param lat
	 *            Degrees latitude
	 * @param lng
	 *            Degrees longitude
	 * @return List<CostCareInformation>
	 * @throws InvalidCredentialException
	 * @throws IOException
	 * @throws MalformedURLException
	 */
	public List<CostCareInformation> listECCMedicalInformation(String cpt,
			String lat, String lng) throws InvalidCredentialException,
			IOException, MalformedURLException;

	/**
	 * Retrieve the Medical Estimated Cost of Care Information based on the CPT,
	 * ZIP
	 * 
	 * @param cpt
	 *            Current procedural terminology code
	 * @param zip
	 *            the Zip code
	 * @return List<CostCareInformation>
	 * @throws InvalidCredentialException
	 * @throws IOException
	 * @throws MalformedURLException
	 */
	public List<CostCareInformation> listECCMedicalInformation(String cpt,
			String zip) throws InvalidCredentialException, IOException,
			MalformedURLException;

	/**
	 * Retrieve a list of all Medical's CPT codes with your short and long
	 * description
	 * 
	 * @return List<Cpt> listECCCPTCodes()
	 * @throws InvalidCredentialException
	 * @throws IOException
	 * @throws MalformedURLException
	 */
	public List<Cpt> listECCMedCPTCodes() throws InvalidCredentialException,
			IOException, MalformedURLException;

	/**
	 * Retrieve the Dental Estimated Cost of Care Information based on the CPT,
	 * LAT, LNG
	 * 
	 * @param cdt
	 *            Current dental terminology code
	 * @param lat
	 *            Degrees latitude
	 * @param lng
	 *            Degrees longitude
	 * @return List<CostCareInformation>
	 * @throws InvalidCredentialException
	 * @throws IOException
	 * @throws MalformedURLException
	 */
	public List<CostCareInformation> listECCDentalInformation(String cdt,
			String lat, String lng) throws InvalidCredentialException,
			IOException, MalformedURLException;

	/**
	 * Retrieve the Dental Estimated Cost of Care Information based on the CDT,
	 * ZIP
	 * 
	 * @param cdt
	 *            Current dental terminology code
	 * @param zip
	 *            the Zip code
	 * @return List<CostCareInformation>
	 * @throws InvalidCredentialException
	 * @throws IOException
	 * @throws MalformedURLException
	 */
	public List<CostCareInformation> listECCDentalInformation(String cdt,
			String zip) throws InvalidCredentialException, IOException,
			MalformedURLException;
	/**
	 * Retrieve a list of all Dental's CPT codes with your short and long
	 * description
	 * 
	 * @return List<Cpt> listECCCPTCodes()
	 * @throws InvalidCredentialException
	 * @throws IOException
	 * @throws MalformedURLException
	 */
	public List<Cpt> listECCDentalCPTCodes() throws InvalidCredentialException,
			IOException, MalformedURLException;
	
	/**
	 * Retrieve list of categories
	 * 
	 * @return List<Categories>
	 * @throws InvalidCredentialException
	 * @throws IOException
	 * @throws MalformedURLException
	 */
	public List<Categories> listCategories() throws InvalidCredentialException,
			IOException, MalformedURLException;
	
	/**
	 * Retrieve list of sub-categories
	 * 
	 * @param category
	 *            the Category name
	 * @return List<Categories>
	 * @throws InvalidCredentialException
	 * @throws IOException
	 * @throws MalformedURLException
	 */
	public List<Categories> retrieveSubCategories(String category)
			throws InvalidCredentialException, IOException,
			MalformedURLException;
}
