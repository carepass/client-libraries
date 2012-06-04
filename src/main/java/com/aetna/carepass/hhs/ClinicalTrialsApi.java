/**
 * 
 */
package com.aetna.carepass.hhs;

import java.io.IOException;
import java.util.List;

import com.aetna.carepass.connector.RequestException;
import com.aetna.carepass.hhs.types.ClinicalTrialsNCTID;
import com.aetna.carepass.hhs.types.ClinicalTrialsSearch;

/**
 * @author rnorris
 *
 */
public interface ClinicalTrialsApi {

	/**
	 * Finds clinical trials information according to the registry number
	 * indicated
	 * 
	 * @param nctid
	 *            The NCT id
	 * @return List<ClinicalTrialsNCTID>
	 * @throws RequestException TODO
	 * @throws IOException TODO
	 */
	public abstract List<ClinicalTrialsNCTID> listClinicalTrialsNCTID(
			String nctid) throws RequestException, IOException;

	/**
	 * Finds a Clinical Trial based on the given parameter and value
	 * @param searchParameters TODO
	 * 
	 * @return ClinicalTrialsSearch
	 * @throws RequestException TODO
	 * @throws IOException TODO
	 */
	public abstract ClinicalTrialsSearch listClinicalTrials(
			ClinicalTrialsSearchParameters searchParameters)
			throws RequestException, IOException;
}
