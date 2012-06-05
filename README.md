CarePass JavaScript Client Libraries
====================================

The goal of these libraries is to remove the need for a CarePass developer to manage the baseline connectivity and data un-packing of interacting with the CarePass APIs.

Installation
============

There is nothing to install. This library is simply a wrapper around existing REST services offered up by CarePass. 

Adding the CarePass JavaScript Client Libraries to Your Project
=========================================================
To include the libraries in your project a reference to the api.js file must be made.

> <script type="text/javascript" src = "api.js"></script>

Key Ideas and Basic Usage
=========================

The first step is to make a reference to the HTSObject. This is done by declaring a new instance of the HTSObject:
 
	var htsObj = new HTSObject();
	
Get an instance of the API you're interested in, in this case its the clinicalTrialsAPI. The developer API is a requirement for the constructor.

	var theUserApi = 'zasasfa75sdwyv2589asdf';
	var clinicalTrialsObject = new htsObj.clinicalTrialsAPI(theUserApi);

This retrieves a JSON object which can be accessed using DOT notation

	clinicalTrialsObject.description

There is no requirement to close any connections or any other interaction.

Thereafter access is allowed to to multiple APIs once the developer apiKey is specified. The apis available are:

	* ClinicalTrialsAPI
	* DrugsAPI
	* deIdentifiedClaimsAPI
	* goodRxAPI
	* MedCostOfCareAPI
