/**
 * 
 */
package com.aetna.carepass.hhs;

import java.io.IOException;
import java.util.List;

import com.aetna.carepass.connector.RequestException;
import com.aetna.carepass.hhs.types.Alternative;
import com.aetna.carepass.hhs.types.Document;
import com.aetna.carepass.hhs.types.DrugResource;
import com.aetna.carepass.hhs.types.Nda;

/**
 * @author rnorris
 *
 */
public interface FDADrugApi {
	/**
	 * Retrieves list of Drug Documents
	 * 
	 * @param nda
	 *            The NDA code
	 * @return List<Document>
	 * @throws RequestException TODO
	 * @throws IOException TODO
	 */
	public abstract List<Document> getDocuments(String nda)
			throws RequestException, IOException;

	/***
	 * Retrieves a list of NDAs based on the NDA supplied
	 * 
	 * @param nda
	 *            The NDA code
	 * @return List<Nda>
	 * @throws RequestException TODO
	 * @throws IOException TODO
	 */

	public abstract List<Nda> getAllNDA(String nda)
			throws RequestException, IOException;

	/**
	 * Retrieves alternative therapies for the provided
	 * 
	 * @param nda
	 *            The NDA code
	 * @return List<Alternatives>
	 * @throws RequestException TODO
	 * @throws IOException TODO
	 */
	public abstract List<Alternative> getAllAlternatives(String nda)
			throws RequestException, IOException;

	/***
	 * Retrieves a list of DrugResources
	 * 
	 * InvalidCredentialException
	 * 
	 * @param nda
	 *            The NDA code
	 * @return List<DrugResource>
	 * @throws RequestException TODO
	 * @throws IOException TODO
	 */
	public abstract List<DrugResource> listDrugResources(String nda)
			throws RequestException, IOException;
}
