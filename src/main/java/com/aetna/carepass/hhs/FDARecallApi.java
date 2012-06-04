/**
 * 
 */
package com.aetna.carepass.hhs;

import java.io.IOException;
import java.util.List;

import com.aetna.carepass.DrugRecallSearchParameters;
import com.aetna.carepass.connector.RequestException;
import com.aetna.carepass.hhs.types.FDARecallSearch;

/**
 * @author rnorris
 * 
 */
public interface FDARecallApi {

	/**
	 * Finds a FDA Recall based on the given parameter and value.
	 * @param searchParameters TODO
	 * 
	 * @return List<FDARecallSearch>
	 * @throws RequestException
	 *             TODO
	 * @throws IOException
	 *             TODO
	 */
	public abstract List<FDARecallSearch> listFDARecall(
			DrugRecallSearchParameters searchParameters) throws RequestException,
			IOException;
}
