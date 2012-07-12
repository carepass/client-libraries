package com.aetna.carepass.hhs.hhsapi;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.List;

import com.aetna.carepass.hhs.hhsapi.types.ART;
import com.aetna.carepass.hhs.hhsapi.types.Alternative;
import com.aetna.carepass.hhs.hhsapi.types.ClinicalTrialsNCTID;
import com.aetna.carepass.hhs.hhsapi.types.ClinicalTrialsSearch;
import com.aetna.carepass.hhs.hhsapi.types.Document;
import com.aetna.carepass.hhs.hhsapi.types.DrugImage;
import com.aetna.carepass.hhs.hhsapi.types.DrugNDC;
import com.aetna.carepass.hhs.hhsapi.types.DrugPackageInfo;
import com.aetna.carepass.hhs.hhsapi.types.DrugResource;
import com.aetna.carepass.hhs.hhsapi.types.DrugSearch;
import com.aetna.carepass.hhs.hhsapi.types.FDARecallSearch;
import com.aetna.carepass.hhs.hhsapi.types.Nda;
import com.aetna.carepass.hhs.util.InvalidCredentialException;

public interface HhsApiService {

	/**
	 * Retrieves list of Drug Documents
	 * 
	 * @param nda
	 *            The NDA code
	 * @return List<Document>
	 * @throws InvalidCredentialException
	 * @throws IOException
	 * @throws MalformedURLException
	 */
	public List<Document> getDocuments(String nda)
			throws InvalidCredentialException, IOException,
			MalformedURLException;

	/***
	 * Retrieves a list of NDAs based on the NDA supplied
	 * 
	 * @param nda
	 *            The NDA code
	 * @return List<Nda>
	 * @throws InvalidCredentialException
	 * @throws IOException
	 * @throws MalformedURLException
	 */

	public List<Nda> getAllNDA(String nda) throws InvalidCredentialException,
			IOException, MalformedURLException;

	/**
	 * Retrieves alternative therapies for the provided
	 * 
	 * @param nda
	 *            The NDA code
	 * @return List<Alternatives>
	 * @throws InvalidCredentialException
	 * @throws IOException
	 * @throws MalformedURLException
	 */
	public List<Alternative> getAllAlternatives(String nda)
			throws InvalidCredentialException, IOException,
			MalformedURLException;

	/***
	 * Retrieves a list of DrugResources
	 * 
	 * InvalidCredentialException
	 * 
	 * @param nda
	 *            The NDA code
	 * @return List<DrugResource>
	 * @throws InvalidCredentialException
	 * @throws IOException
	 * @throws MalformedURLException
	 */
	public List<DrugResource> listDrugResources(String nda)
			throws InvalidCredentialException, IOException,
			MalformedURLException;

	/**
	 * Retrieves a list of images of the drugs for the given NDC2 segment
	 * 
	 * @param ndc2
	 *            the given NDC2 segment
	 * @return List<DrugImage>
	 * @throws InvalidCredentialException
	 * @throws IOException
	 * @throws MalformedURLException
	 */
	public List<DrugImage> getAllDrugImages(String ndc2)
			throws InvalidCredentialException, IOException,
			MalformedURLException;

	/**
	 * Retrieves a list of drugs according to the NC2 segment with its package
	 * info and imprints
	 * 
	 * @param ndc2
	 *            the NDC two segment
	 * @return List<DrugNDC>
	 * @throws InvalidCredentialException
	 * @throws IOException
	 * @throws MalformedURLException
	 */
	public List<DrugNDC> getAllDrugByNDC(String ndc2)
			throws InvalidCredentialException, IOException,
			MalformedURLException;

	/**
	 * Retrieves the package info of drug according to the given NDC2 segment
	 * and the NDC3 segment
	 * 
	 * @param ndc2
	 *            the NDC two segment
	 * @param ndc3
	 *            the NDC three segment
	 * @return List<DrugPackageInfo>
	 * @throws InvalidCredentialException
	 * @throws IOException
	 * @throws MalformedURLException
	 */
	public List<DrugPackageInfo> getAllDrugPackageInfo(String ndc2, String ndc3)
			throws InvalidCredentialException, IOException,
			MalformedURLException;

	/**
	 * Finds a drug based on drug name
	 * 
	 * @param drugName
	 *            The drug name
	 * @return List<Drug>
	 * @throws InvalidCredentialException
	 * @throws IOException
	 * @throws MalformedURLException
	 */
	public List<DrugSearch> listDrugs(String drugName)
			throws InvalidCredentialException, IOException,
			MalformedURLException;

	/**
	 * Finds a ART based on the given parameter and value
	 * 
	 * @param clinicName
	 *            Name of clinic
	 * @param city
	 *            Name of a City
	 * @param state
	 *            Name of a state
	 * @param medicaldirector
	 *            Medical director
	 * @param year
	 *            year
	 * @param exactMatch
	 *            true if and only if it requires exact match.
	 * @return List<ART>
	 * @throws InvalidCredentialException
	 * @throws IOException
	 * @throws MalformedURLException
	 */
	public List<ART> listARTs(String clinicName, String city, String state,
			String medicaldirector, String year, boolean exactMatch)
			throws InvalidCredentialException, IOException,
			MalformedURLException;

	/**
	 * Finds clinical trials information according to the registry number
	 * indicated
	 * 
	 * @param nctid
	 *            The NCT id
	 * @return List<ClinicalTrialsNCTID>
	 * @throws InvalidCredentialException
	 * @throws IOException
	 * @throws MalformedURLException
	 */
	public List<ClinicalTrialsNCTID> listClinicalTrialsNCTID(String nctid)
			throws InvalidCredentialException, IOException,
			MalformedURLException;

	/**
	 * Finds a Clinical Trial based on the given parameter and value
	 * 
	 * @param drugname
	 *            Name of drug
	 * @param status
	 *            Status of clinical trials / open or closed
	 * @param page
	 *            Page number. Each page has until 500 results. (e.g. page=1
	 *            return the last 500 clinical trials).
	 * @param condition
	 *            conditioning summary
	 * @param state1
	 *            Locations to find trials state 1.
	 * @param state2
	 *            Locations to find trials state 2.
	 * @param state3
	 *            Locations to find trials state 3.
	 * @param country1
	 *            Locations to find trials country 1.
	 * @param country2
	 *            Locations to find trials country 2.
	 * @param country3
	 *            Locations to find trials country 3.
	 * @param firstreceivedfrom
	 *            The first received date is the date when the clinical trial
	 *            was first submitted to ClinicalTrials.gov
	 * @param firstreceivedto
	 *            First Received To: The first received date is the date when
	 *            the clinical trial was first submitted to ClinicalTrials.gov
	 * @param lastupdatedfrom
	 *            The last updated date is the most recent date when changes to
	 *            a clinical trial were submitted to ClinicalTrials.gov
	 * @param lastupdatedto
	 *            The last updated date is the most recent date when changes to
	 *            a clinical trial were submitted to ClinicalTrials.gov
	 * @return ClinicalTrialsSearch
	 * @throws InvalidCredentialException
	 * @throws IOException
	 * @throws MalformedURLException
	 */
	public ClinicalTrialsSearch listClinicalTrials(String drugname,
			String status, String page, String condition, String state1,
			String state2, String state3, String country1, String country2,
			String country3, String firstreceivedfrom, String firstreceivedto,
			String lastupdatedfrom, String lastupdatedto)
			throws InvalidCredentialException, IOException,
			MalformedURLException;

	/**
	 * Finds a FDA Recall based on the given parameter and value.
	 * 
	 * @param product
	 *            Product of recall
	 * @param date
	 *            Date of recall (pattern: yyyy-mm-dd)
	 * @param pastdays
	 *            Search all recalls from today until today-pastdays
	 * @return List<FDARecallSearch>
	 * @throws InvalidCredentialException
	 * @throws IOException
	 * @throws MalformedURLException
	 */
	public List<FDARecallSearch> listFDARecall(String product, String date,
			Integer pastdays) throws InvalidCredentialException, IOException,
			MalformedURLException;
}
