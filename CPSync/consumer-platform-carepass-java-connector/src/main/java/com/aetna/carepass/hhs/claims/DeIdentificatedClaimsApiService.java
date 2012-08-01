package com.aetna.carepass.hhs.claims;

import java.io.IOException;
import java.net.MalformedURLException;

import com.aetna.carepass.hhs.claims.types.DeIdentificatedClaimsSearch;
import com.aetna.carepass.hhs.util.InvalidCredentialException;

public interface DeIdentificatedClaimsApiService {

	/**
	 * Retrieves claims data
	 * 
	 * @param ndc
	 *            National Drug Code Directory of 2 or 3 segments separated by
	 * @param gender
	 *            Gender of a member.
	 * @param birthyearfrom
	 *            Range start of birth year of a member.
	 * @param birthyearto
	 *            Range end of birth year of a member.
	 * @param from
	 *            Start date to search claims.
	 * @param to
	 *            End date to search claims.
	 * @param page
	 *            Number of page. (Each page contains 500 results)
	 * @return DeIdentificatedClaimsSearch
	 * @throws InvalidCredentialException
	 * @throws IOException
	 * @throws MalformedURLException
	 * @throws IllegalArgumentException
	 */
	public DeIdentificatedClaimsSearch searchDeIdentificatedClaims(String ndc,
			String gender, Integer birthyearfrom, Integer birthyearto,
			String from, String to, Integer page)
			throws InvalidCredentialException, IOException,
			MalformedURLException, IllegalArgumentException;
}
