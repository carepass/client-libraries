CarePass JavaScript Client Libraries
====================================

The goal of these libraries is to remove the need for a CarePass developer to manage the baseline connectivity and data un-packing of interacting with the CarePass APIs.

There are two main libraries, CarepassSync for interaction around the current user and HTS which contains interactions for drugs, claims, clinical trials.

### Installation

There is nothing to install. This library is simply a wrapper around existing REST services offered up by CarePass.

In order to use the CarePass Sync library the client application needs to start the OAuth 2 authentication work flow. The OAuth work flow has 2 main steps
we should be interested in :
- **Step 1** - the first is the call to the *authorize* endpoint to retrieve the grant code which is seen in the section *Retrieving Grant Code* below. 
- **Step 2** - after receiving the access code is to retrieve the access token by calling the *token* endpoint as seen in *Exchanging Grant Code for Access Token*.

### Retrieving Grant Code

```html
    <script type="text/javascript" charset="utf-8">
      $(function () {

        var setting =
          {
            'host':     "https://www.carepass.com/carepass/oauth"
          , 'clientId': YOUR_CLIENT_ID
          , 'scope': : "IDENTITY,INSURANCE,FITNESS,LIFESTYLE,APPOINTMENT"
          , 'redirectUrl': YOUR_APPLICATION_CAREPASS_REDIRECT_URL
          };

        var endUserAuthorizationEndpoint = setting.host + "/authorize";
        
        var authUrl = endUserAuthorizationEndpoint + $.param({		
                      	response_type : code,
                      	client_id : setting.clientId, 
                      	scope : setting.scope,
                      	redirect_uri : setting.redirectUrl
                      });

          $("a.connect").attr("href", authUrl);
      });
    </script>
    </head>
    <body> 
    	<a class="connect" href="">Connect</a> 
  	</body>
```
  	
The application will redirect to Carepass for the user to enter their username/password. Once they are successfully 
authenticated the user is redirected back to their application based on the redirect url setup with a grant code.
  	  	  	
`http://{YOUR_APPLICATION_CAREPASS_REDIRECT_URL}?code={ACCESS_CODE}`
	
Using the received grant code, call is made to /token endpoint with additional parameters as seen below

### Exchanging Grant Code for Access Token

```javascript	
        var endUserAuthorizationEndpoint = setting.host + "/token";

        $.ajax({
			type : "POST",
			url : endUserAuthorizationEndpoint,
			data : {
				response_type : 'code',
				client_id : setting.clientId,
            	grant_type : 'authorization_code', 
            	code : ACCESS_CODE_FROM_SUCCESS_AUTH,
            	client_secret : setting.client_secret,
            	redirect_uri : YOUR_APPLICATION_CAREPASS_REDIRECT_URL
            },
			success : function(data) {
				//data.access_token;
				console.log(data);
			},
			error : function(data) {
				//Something went wrong
				console.log(data);
			}
		});  
```
	
The retrieved access_token should be stored locally as it is used in the CPSync calls as seen below in the examples.
	
### Adding the CarePass JavaScript Client Libraries to Your Project

To include the libraries in your project a reference to the api.js file must be made.

> <script type="text/javascript" src = "api.js"></script>

To include the Carepass sync libraries a reference to the cpsync.js file must be made.

> <script type="text/javascript" src = "cpsync.js"></script>

### Key Ideas and Basic Usage

The first step is to make a reference to the object you're interested in CarepassSync (CPSyncObject) or HTS (HTSObject). This is done by declaring a new instance of the object:
 
	var htsObj = new HTSObject();
	
FOr the HTSObject you can get an instance of the API you're interested in, in this case its the clinicalTrialsAPI. The developer API is a requirement for the constructor.

```javascript
	var theUserApi = 'your_user_api';
	var clinicalTrialsObject = new htsObj.clinicalTrialsAPI(theUserApi);
	var trialsData = clinicalTrialsObject.getTrialsByNCTId('myNCTID');
```
	
This retrieves a JSON object which can be accessed using DOT notation

	trialsData.trialName;
	
The same obtains for the CPSyncObject except the constructor parameter is the access token for the user

```javascript
	var cpSyncObj = new CPSyncObject();
	var theBioApi = new cpObj.biographyApi('Bearer {token_retrieved_from carepass}');
	var bioData = theBioApi.getUserIdentity();	
	bioData.firstName; 
```
	
There is no requirement to close any connections or any other interaction.

Thereafter access is allowed to to multiple APIs once the developer apiKey (access token) or is specified. The apis available are:

>HTS Object
>	* ClinicalTrialsAPI
>	* DrugsAPI
>	* deIdentifiedClaimsAPI
>	* goodRxAPI
>	* MedCostOfCareAPI

>CPSync Object
>	* biographyApi
>	* insuranceApi
>	* lifeStyleApi
>	* activitiesApi
>   * appointmentsApi
