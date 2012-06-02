package com.aetna.api.hhs;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.aetna.api.dataTypes.ART;
import com.aetna.api.dataTypes.Alternative;
import com.aetna.api.dataTypes.ClinicalTrialsNCTID;
import com.aetna.api.dataTypes.ClinicalTrialsSearch;
import com.aetna.api.dataTypes.Document;
import com.aetna.api.dataTypes.DrugImage;
import com.aetna.api.dataTypes.DrugNDC;
import com.aetna.api.dataTypes.DrugPackageInfo;
import com.aetna.api.dataTypes.DrugResource;
import com.aetna.api.dataTypes.DrugSearch;
import com.aetna.api.dataTypes.FDARecallSearch;
import com.aetna.api.dataTypes.Nda;

public class CarePassApplication {
	// TODO: Messages
	public static void main(String args[]) {
		System.err.println("Starting Application."); //$NON-NLS-1$
		String nda = "NDA003444";
		String apiKey = "zv66hqmgj575sdwyv2589x58"; //$NON-NLS-1$
		String ndc2 = "0002-4759";
		String ndc3 = "0002-4759-076";
		String drugName = "Cymbalta";
		String searchParameterART = "clinicname";
		String valueART = "Alabama";
		String searchParameterCT = "drugname";
		String valueCT = "DRISDOL";
		String searcParameterFDA="product";
		String valueFDA="Dietary Supplements";
		String nctid = "NCT00835224";

		HHSAPI theAPI = DrugFactory.getHHSApi(apiKey);

		 //FIXME: Set vs List
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
		 // TODO Auto-generated catch block
		 e.printStackTrace();
		 } catch (MalformedURLException e) {
		 // TODO Auto-generated catch block
		 e.printStackTrace();
		 } catch (IOException e) {
		 // TODO Auto-generated catch block
		 e.printStackTrace();
		 }
		
		 List<DrugResource> theDrugResources;
		 try {
		 theDrugResources = theAPI.listDrugResources(nda);
		 System.err
							.println("Drug Resources " + theDrugResources.get(0).getValue()); //$NON-NLS-1$
		 } catch (InvalidCredentialException e) {
		 // TODO Auto-generated catch block
		 e.printStackTrace();
		 } catch (MalformedURLException e) {
		 // TODO Auto-generated catch block
		 e.printStackTrace();
		 } catch (IOException e) {
		 // TODO Auto-generated catch block
		 e.printStackTrace();
		 }
		
		 List<Nda> theNDAs;
		 try {
		 theNDAs = theAPI.getAllNDA(nda);
		 System.err.println("NDA " + theNDAs.get(0));
		 Object x = theNDAs.get(0);
		 } catch (InvalidCredentialException e) {
		 // TODO Auto-generated catch block
		 e.printStackTrace();
		 } catch (MalformedURLException e) {
		 // TODO Auto-generated catch block
		 e.printStackTrace();
		 } catch (IOException e) {
		 // TODO Auto-generated catch block
		 e.printStackTrace();
		 }
		
		 List<Alternative> theNDAAlternatives;
		 try {
		 theNDAAlternatives = theAPI.getAllAlternatives(nda);
		 System.err.println("NDA " + theNDAAlternatives.get(0));
		 Object x = theNDAAlternatives.get(0);
		 } catch (InvalidCredentialException e) {
		 // TODO Auto-generated catch block
		 e.printStackTrace();
		 } catch (MalformedURLException e) {
		 // TODO Auto-generated catch block
		 e.printStackTrace();
		 } catch (IOException e) {
		 // TODO Auto-generated catch block
		 e.printStackTrace();
		 }
		
		
		 List<DrugSearch> theDrugSearchList;
		 try{
		 theDrugSearchList = theAPI.listDrugs(drugName);
		 }catch(InvalidCredentialException e){
		 e.printStackTrace();
		 }catch(MalformedURLException e){
		 e.printStackTrace();
		 }catch(IOException e){
		 e.printStackTrace();
		 }
		
		
		 List<DrugImage> theDrugImg;
		 try {
		 theDrugImg = theAPI.getAllDrugImages(ndc2);
		 System.err.println(theDrugImg.isEmpty() ? "nothing" : theDrugImg
		 .get(0));
		 } catch (InvalidCredentialException e) {
		 // TODO Auto-generated catch block
		 e.printStackTrace();
		 } catch (MalformedURLException e) {
		 // TODO Auto-generated catch block
		 e.printStackTrace();
		 } catch (IOException e) {
		 // TODO Auto-generated catch block
		 e.printStackTrace();
		 }
		
		 List<DrugNDC> theDrugNDC2;
		
		 try {
		 theDrugNDC2 = theAPI.getAllDrugByNDC(ndc2);
		
		 } catch (InvalidCredentialException e) {
		 // TODO Auto-generated catch block
		 e.printStackTrace();
		 } catch (MalformedURLException e) {
		 // TODO Auto-generated catch block
		 e.printStackTrace();
		 } catch (IOException e) {
		 // TODO Auto-generated catch block
		 e.printStackTrace();
		 }
		
		 List<DrugPackageInfo> theDrugPackageInfo;
		 try{
		 theDrugPackageInfo = theAPI.getAllDrugPackageInfo(ndc2,ndc3);
		 }catch(InvalidCredentialException e){
		 e.printStackTrace();
		 }catch(MalformedURLException e){
		 e.printStackTrace();
		 }catch(IOException e){
		 e.printStackTrace();
		 }
		
		
		 List<ART> theARTList;
		 try{
		 Map<String,String> searchParameters = new HashMap<String, String>();
		 searchParameters.put(searchParameterART, valueART);
		 theARTList = theAPI.listARTs(searchParameters, true);
		 }catch(InvalidCredentialException e){
		 e.printStackTrace();
		 }catch(MalformedURLException e){
		 e.printStackTrace();
		 }catch(IOException e){
		 e.printStackTrace();
		 }
		
		 List<ClinicalTrialsNCTID> theClinicalTrialsNCTIDList;
		 try{
		
		 theClinicalTrialsNCTIDList = theAPI.listClinicalTrialsNCTID(nctid);
		 }catch(InvalidCredentialException e){
		 e.printStackTrace();
		 }catch(MalformedURLException e){
		 e.printStackTrace();
		 }catch(IOException e){
		 e.printStackTrace();
		 }

		ClinicalTrialsSearch theClinicalTrial;
		try {
			Map<String, String> searchParameters = new HashMap<String, String>();
			searchParameters.put(searchParameterCT, valueCT);
			theClinicalTrial = theAPI.listClinicalTrials(searchParameters);
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
		} catch (InvalidCredentialException e) {
			e.printStackTrace();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}