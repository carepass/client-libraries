/**
 * 
 */
package com.aetna.carepass.hhs;

import java.io.IOException;
import java.util.List;

import com.aetna.carepass.connector.RequestException;
import com.aetna.carepass.hhs.types.DrugImage;
import com.aetna.carepass.hhs.types.DrugNDC;
import com.aetna.carepass.hhs.types.DrugPackageInfo;
import com.aetna.carepass.hhs.types.DrugSearch;

/**
 * 
 * /drugs
 * @author rnorris
 *
 */
public interface DrugsApi {
	
	/**
	 * Finds a drug based on drug name
	 * @param searchParameters TODO
	 * 
	 * @return List<Drug>
	 * @throws RequestException TODO
	 * @throws IOException TODO
	 */
	public abstract List<DrugSearch> listDrugs(DrugSearchParameters searchParameters)
			throws RequestException, IOException;

	/**
	 * Retrieves a list of images of the drugs for the given NDC2 segment
	 * 
	 * @param ndc2
	 *            the given NDC2 segment
	 * @return List<DrugImage>
	 * @throws RequestException TODO
	 * @throws IOException TODO
	 */
	public abstract List<DrugImage> getAllDrugImages(String ndc2)
			throws RequestException, IOException;

	/**
	 * Retrieves a list of drugs according to the NC2 segment with its package
	 * info and imprints
	 * 
	 * @param ndc2
	 *            the NDC two segment
	 * @return List<DrugNDC>
	 * @throws RequestException TODO
	 * @throws IOException TODO
	 */
	public abstract List<DrugNDC> getAllDrugByNDC(String ndc2)
			throws RequestException, IOException;

	/**
	 * Retrieves the package info of drug according to the given NDC2 segment
	 * and the NDC3 segment
	 * 
	 * @param ndc2
	 *            the NDC two segment
	 * @param ndc3
	 *            the NDC three segment
	 * @return List<DrugPackageInfo>
	 * @throws RequestException TODO
	 * @throws IOException TODO
	 */
	public abstract List<DrugPackageInfo> getAllDrugPackageInfo(String ndc2,
			String ndc3) throws RequestException, IOException;
}
