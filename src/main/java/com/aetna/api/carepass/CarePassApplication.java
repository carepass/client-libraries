package com.aetna.api.carepass;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.aetna.api.dataTypes.ecc.Categories;
import com.aetna.api.dataTypes.ecc.CostCareInformation;
import com.aetna.api.dataTypes.ecc.Cpt;
import com.aetna.api.dataTypes.goodrx.DrugPrices;
import com.aetna.api.dataTypes.hhs.ART;
import com.aetna.api.dataTypes.hhs.Alternative;
import com.aetna.api.dataTypes.hhs.ClinicalTrialsNCTID;
import com.aetna.api.dataTypes.hhs.ClinicalTrialsSearch;
import com.aetna.api.dataTypes.hhs.Document;
import com.aetna.api.dataTypes.hhs.DrugImage;
import com.aetna.api.dataTypes.hhs.DrugNDC;
import com.aetna.api.dataTypes.hhs.DrugPackageInfo;
import com.aetna.api.dataTypes.hhs.DrugResource;
import com.aetna.api.dataTypes.hhs.DrugSearch;
import com.aetna.api.dataTypes.hhs.FDARecallSearch;
import com.aetna.api.dataTypes.hhs.Nda;
import com.aetna.api.ecc.ECCApi;
import com.aetna.api.goodrx.GoodRXAPI;
import com.aetna.api.hhs.DrugFactory;
import com.aetna.api.hhs.HHSAPI;
import com.aetna.api.util.InvalidCredentialException;

public class CarePassApplication {
	// TODO: Messages

	public static void main(String args[]) {

		System.err.println("Starting Application."); //$NON-NLS-1$
		CarePassApplication cpApp = new CarePassApplication();
		cpApp.hhsApiTry();
		cpApp.goodRxApiTry();
		cpApp.eccApiTry();

	}

	private void hhsApiTry() {
		String nda = "NDA003444";
		String ndc2 = "0002-4760";
		String ndc3 = "0002-4760-76";
		String drugName = "Cymbalta";
		String searchParameterART = "clinicname";
		String valueART = "Alabama";
		String searchParameterCT = "drugname";
		String valueCT = "DRISDOL";
		String searcParameterFDA = "product";
		String valueFDA = "Dietary Supplements";
		String nctid = "NCT01312441";

		String apiKey = "fd5jvtrrcb8287ym978w7hph"; //$NON-NLS-1$

		HHSAPI theAPI = DrugFactory.getHHSApi(apiKey);
		// FIXME: Set vs List
		List<Document> theDocuments;

		try {
			theDocuments = theAPI.getDocuments(nda);
			if (theDocuments.size() > 0) {
				System.err
						.println("Document URL " + theDocuments.get(0).getUrl()); //$NON-NLS-1$
				System.err
						.println("Document Type" + theDocuments.get(0).getType()); //$NON-NLS-1$
			}
		} catch (InvalidCredentialException e) {
			e.printStackTrace();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		List<DrugResource> theDrugResources;
		try {
			theDrugResources = theAPI.listDrugResources(nda);
			System.err
					.println("Drug Resources " + theDrugResources.get(0).getValue()); //$NON-NLS-1$
		} catch (InvalidCredentialException e) {
			e.printStackTrace();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		List<Nda> theNDAs;
		try {
			theNDAs = theAPI.getAllNDA(nda);
			System.err.println("NDA " + theNDAs.get(0));
		} catch (InvalidCredentialException e) {
			e.printStackTrace();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		List<Alternative> theNDAAlternatives;
		try {
			theNDAAlternatives = theAPI.getAllAlternatives(nda);
			System.err.println("NDA " + theNDAAlternatives.get(0));
		} catch (InvalidCredentialException e) {
			e.printStackTrace();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		List<DrugSearch> theDrugSearchList;
		try {
			theDrugSearchList = theAPI.listDrugs(drugName);
			System.err.println("Drugs " + theDrugSearchList.get(0));
		} catch (InvalidCredentialException e) {
			e.printStackTrace();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		List<DrugImage> theDrugImg;
		try {
			theDrugImg = theAPI.getAllDrugImages(ndc2);
			System.err.println(theDrugImg.isEmpty() ? "nothing" : theDrugImg
					.get(0));
		} catch (InvalidCredentialException e) {
			e.printStackTrace();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		List<DrugNDC> theDrugNDC2;

		try {
			theDrugNDC2 = theAPI.getAllDrugByNDC(ndc2);
			System.err.println("Drugs " + theDrugNDC2.get(0));
		} catch (InvalidCredentialException e) {
			e.printStackTrace();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		List<DrugPackageInfo> theDrugPackageInfo;
		try {
			theDrugPackageInfo = theAPI.getAllDrugPackageInfo(ndc2, ndc3);
			System.err.println("Drugs " + theDrugPackageInfo.get(0));
		} catch (InvalidCredentialException e) {
			e.printStackTrace();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		List<ART> theARTList;
		try {
			Map<String, String> searchParameters = new HashMap<String, String>();
			searchParameters.put(searchParameterART, valueART);
			theARTList = theAPI.listARTs(searchParameters, true);
			System.err.println("ART " + theARTList.get(0));
		} catch (InvalidCredentialException e) {
			e.printStackTrace();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		List<ClinicalTrialsNCTID> theClinicalTrialsNCTIDList;
		try {

			theClinicalTrialsNCTIDList = theAPI.listClinicalTrialsNCTID(nctid);
			System.err.println("Clinical Trials "
					+ theClinicalTrialsNCTIDList.get(0));
		} catch (InvalidCredentialException e) {
			e.printStackTrace();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		ClinicalTrialsSearch theClinicalTrial;
		try {
			Map<String, String> searchParameters = new HashMap<String, String>();
			searchParameters.put(searchParameterCT, valueCT);
			searchParameters.put("page", "2");
			theClinicalTrial = theAPI.listClinicalTrials(searchParameters);
			System.err.println("Clinical Trials " + theClinicalTrial);
		} catch (InvalidCredentialException e) {
			e.printStackTrace();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		List<FDARecallSearch> theFDARecallSearchList;
		try {
			Map<String, String> searchParameters = new HashMap<String, String>();
			searchParameters.put(searcParameterFDA, valueFDA);
			theFDARecallSearchList = theAPI.listFDARecall(searchParameters);
			System.err.println("FDA Recall " + theFDARecallSearchList.get(0));
		} catch (InvalidCredentialException e) {
			e.printStackTrace();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	private void goodRxApiTry() {

		String searcParameterDrugLowerPrices = "name";
		String valueDrugLowerPrices = "aspirin";
		String apiKey = "5bjgdjfu4tv2kgu7hyt5tmqe"; //$NON-NLS-1$

		GoodRXAPI theAPI = new GoodRXAPI(apiKey);

		List<DrugPrices> theDrugLowerPricesList;
		try {
			Map<String, String> searchParameters = new HashMap<String, String>();
			searchParameters.put(searcParameterDrugLowerPrices,
					valueDrugLowerPrices);
			theDrugLowerPricesList = theAPI
					.listDrugLowestPrices(searchParameters);
			System.err.println("Drug Lower Prices "
					+ theDrugLowerPricesList.get(0));
		} catch (InvalidCredentialException e) {
			e.printStackTrace();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		List<DrugPrices> theDrugComparePricesList;
		try {
			Map<String, String> searchParameters = new HashMap<String, String>();
			searchParameters.put(searcParameterDrugLowerPrices,
					valueDrugLowerPrices);
			theDrugComparePricesList = theAPI
					.listDrugComparePrices(searchParameters);
			System.err
					.println("Drug Prices " + theDrugComparePricesList.get(0));
		} catch (InvalidCredentialException e) {
			e.printStackTrace();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void eccApiTry() {
		String apiKey = "45z6eg74j6j2nr6rgvjzdz5c"; //$NON-NLS-1$
		ECCApi theAPI = new ECCApi(apiKey);

		String cpt = "99201";
		String cptLat = "41.6870";
		String cptLng = "-72.7308";
		String cptZip = "06111";

		String cdtLat = "40.5856";
		String cdtLng = "-74.2706";
		String cdtZip = "07001";
		String cdt = "D3310";

		String category = "Dental";

		List<CostCareInformation> theCostOfCareMed;
		try {

			theCostOfCareMed = theAPI.listECCMedicalInformation(cpt, cptLat,
					cptLng);
			System.err.println("Medical ECC " + theCostOfCareMed.get(0));
		} catch (InvalidCredentialException e) {
			e.printStackTrace();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		List<CostCareInformation> theCostOfCareMedZip;
		try {

			theCostOfCareMedZip = theAPI.listECCMedicalInformation(cpt, cptZip);
			System.err.println("Medical ECC " + theCostOfCareMedZip.get(0));
		} catch (InvalidCredentialException e) {
			e.printStackTrace();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		List<Cpt> theCPTMed;
		try {

			theCPTMed = theAPI.listECCMedCPTCodes();
			System.err.println("Medical ECC " + theCPTMed.get(0));
		} catch (InvalidCredentialException e) {
			e.printStackTrace();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		List<CostCareInformation> theCostOfCareDental;
		try {

			theCostOfCareDental = theAPI.listECCDentalInformation(cdt, cdtLat,
					cdtLng);
			System.err.println("Dental ECC " + theCostOfCareDental.get(0));
		} catch (InvalidCredentialException e) {
			e.printStackTrace();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		List<CostCareInformation> theCostOfCareDentalZip;
		try {

			theCostOfCareDentalZip = theAPI.listECCDentalInformation(cdt,
					cdtZip);
			System.err.println("Dental ECC " + theCostOfCareDentalZip.get(0));
		} catch (InvalidCredentialException e) {
			e.printStackTrace();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		List<Cpt> theCPTDental;
		try {

			theCPTDental = theAPI.listECCDentalCPTCodes();
			System.err.println("Dental ECC " + theCPTDental.get(0));
		} catch (InvalidCredentialException e) {
			e.printStackTrace();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		List<Categories> theCategories;
		try {

			theCategories = theAPI.listCategories();
			System.err.println("ECC Categories " + theCategories.get(0));
		} catch (InvalidCredentialException e) {
			e.printStackTrace();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		List<Categories> theSubCategories;
		try {

			theSubCategories = theAPI.retrieveSubCategories(category);
			System.err.println("ECC SubCategories " + theSubCategories.get(0));
		} catch (InvalidCredentialException e) {
			e.printStackTrace();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}