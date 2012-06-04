/**
 * 
 */
package com.aetna.carepass.hhs;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import com.aetna.carepass.connector.RequestException;
import com.aetna.carepass.hhs.types.ART;

/**
 * @author rnorris
 * 
 */
public interface AssistedReproductionApi {

	/**
	 * 
	 * @param parameters
	 * @return
	 * @throws RequestException
	 * @throws IOException
	 */
	public abstract List<ART> listARTs(ARTSearchParameters parameters) throws RequestException, IOException;

}
