CarePass JavaScript Client Libraries
====================================

The goal of these libraries is to remove the need for a CarePass developer to manage the baseline connectivity and data un-packing of interacting with the CarePass APIs.

There are two main libraries, CarepassSync for interaction around the current user and HTS which contains interactions for drugs, claims, clinical trials.

Installation
============

There is nothing to install. This library is simply a wrapper around existing REST services offered up by CarePass. 

Adding the CarePass JavaScript Client Libraries to Your Project
=========================================================
To include the libraries in your project a reference to the api.js file must be made.

> <script type="text/javascript" src = "api.js"></script>

To include the Carepass sync libraries a reference to the cpsync.js file must be made.

> <script type="text/javascript" src = "cpsync.js"></script>

Key Ideas and Basic Usage
=========================

The first step is to make a reference to the object you're interested in CarepassSync (CPSyncObject) or HTS (HTSObject). This is done by declaring a new instance of the object:
 
	var htsObj = new HTSObject();
	
FOr the HTSObject you can get an instance of the API you're interested in, in this case its the clinicalTrialsAPI. The developer API is a requirement for the constructor.

	var theUserApi = 'zasasfa75sdwyv2589asdf';
	var clinicalTrialsObject = new htsObj.clinicalTrialsAPI(theUserApi);
	var trialsData = clinicalTrialsObject.getTrialsByNCTId('myNCTID');
	
This retrieves a JSON object which can be accessed using DOT notation

	trialsData.trialName;
	
The same obtains for the CPSyncObject except the constructor parameter is the access token for the user

	var cpSyncObj = new CPSyncObject();
	var theBioApi = new cpObj.biographyApi('Bearer 8834901dac4568a27da681cdd155ec0a6209');
	var bioData = theBioApi.getUserIdentity();
	
	bioData.firstName; 
	
There is no requirement to close any connections or any other interaction.

Thereafter access is allowed to to multiple APIs once the developer apiKey (access token) or is specified. The apis available are:

HTS Object
	* ClinicalTrialsAPI
	* DrugsAPI
	* deIdentifiedClaimsAPI
	* goodRxAPI
	* MedCostOfCareAPI

CPSync Object
	* biographyApi
	* insuranceApi
	* lifeStyleApi
	* activitiesApi