package com.aetna.carepass.hhs.goodrx;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.List;

import com.aetna.carepass.hhs.goodrx.types.DrugPrices;
import com.aetna.carepass.hhs.util.InvalidCredentialException;

public interface GoodRXApiService {

	/**
	 * Retrieves the lowest available price for a prescription medication
	 * 
	 * @param name
	 *            the drug's name
	 * @param form
	 *            The physical form in which a drug is produced and dispensed
	 * @param dosage
	 *            Representing the dosage measurement of the prescription
	 *            medication
	 * @param quantity
	 *            Float representing the quantity used to derive price
	 * @param manufacturer
	 *            Referencing the manufacturer type of drug, either brand or
	 *            generic
	 * @param ndc
	 *            National Drug Code Directory identifier
	 * @return List<DrugPrices>
	 * @throws InvalidCredentialException
	 * @throws IOException
	 * @throws MalformedURLException
	 */
	public List<DrugPrices> listDrugLowestPrices(String name, String form,
			String dosage, String quantity, String manufacturer, String ndc)
			throws InvalidCredentialException, IOException,
			MalformedURLException;

	/**
	 * Retrieves the available price for a prescription medication
	 * 
	 * @param name
	 *            the drug's name
	 * @param form
	 *            The physical form in which a drug is produced and dispensed
	 * @param dosage
	 *            Representing the dosage measurement of the prescription
	 *            medication
	 * @param quantity
	 *            Float representing the quantity used to derive price
	 * @param manufacturer
	 *            Referencing the manufacturer type of drug, either brand or
	 *            generic
	 * @param ndc
	 *            National Drug Code Directory identifier
	 * @return List<DrugPrices>
	 * @throws InvalidCredentialException
	 * @throws IOException
	 * @throws MalformedURLException
	 */
	public List<DrugPrices> listDrugComparePrices(String name, String form,
			String dosage, String quantity, String manufacturer, String ndc)
			throws InvalidCredentialException, IOException,
			MalformedURLException;
}
