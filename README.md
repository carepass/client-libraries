CarePass Java Client Libraries
====================================

The goal of these libraries is to remove the need for a CarePass developer to manage the baseline connectivity and data un-packing of interacting with the CarePass APIs.

There are two main libraries, CarepassSync for interaction around the current user and HTS which contains interactions for drugs, claims, clinical trials.

About CarePass APIs
===================
Read all about the available API's at https://developer.carepass.com

CarePass Sync Configuration
===========================

The main configuration for OAuth authentification should looks like the below portion of code, that has to be set in your Spring configuration file


	<!-- OAuth -->
	<bean id="carePassOAuthData"
		class="com.aetna.carepass.oauth.connector.scribe.api.CarePassOAuthData">
		<property name="apiKey" value="YOUR_API_KEY" />
		<property name="apiSecret" value="YOUR_API_SECRET" />
		<property name="callback" value="YOUR_APPLICATION_CAREPASS_REDIRECT_URL" />
		<property name="api" ref="carePassApi" />
	</bean>
	<bean id="carePassOAuthImpl"
		class="com.aetna.carepass.oauth.connector.service.CarePassOAuthImpl">
		<property name="data" ref="carePassOAuthData" />
	</bean>
	<bean id="carePassApi"
		class="com.aetna.carepass.oauth.connector.scribe.api.CarePassApi">
		<property name="scope" value="THE_REQUIRED_SCOPE" />
	</bean>
	<!--End OAuth -->

In order to use the CarePass Sync library the client application needs to start the OAuth 2 authentication work flow. The OAuth work flow has 2 main steps
we should be interested in :
- Step 1 - the first is the call to the *authorize* endpoint  by a request call to USER_APPLICATION_URL/login-carepass where the apiKey, the apiSecret and the return_uri are passed to retrieve the grant code which is seen in the section *Retrieving Grant Code* below. 
- Step 2 - after receiving the access code other call is made to retrieve the access token by calling the *token* endpoint as seen in *Exchanging Grant Code for Access Token*.
	
### Retrieving Grant Code

	@Autowired
	private CarePassOAuth carePassOAuth;

	@RequestMapping(value = { "REQUEST_OAUTH_URI" }, method = RequestMethod.GET)
	public String carePassLogin() {
		return "redirect:" + carePassOAuth.retrieveInitialRequest();
	}
	  	
The application will redirect to Carepass for the user to enter their username/password if it initially does not have the Access Token. Once they are successfully 
authenticated the user is redirected back to their application based on the redirect url setup which redirects to the request mapping "/carepass-callback" with a grant code.
  	  	  	
	http://{YOUR_APPLICATION_CAREPASS_REDIRECT_URL}?code={ACCESS_CODE}
	
Using the received grant code, call is made to /token endpoint with additional parameters as seen below

### Exchanging Grant Code for Access Token
	
    @RequestMapping(value = { "RESPONSE_AUTHENTIFICATION_CODE_URI" }, method = RequestMethod.GET)
	public String carePassLoginSuccess(
			@RequestParam(value = "code", required = false) String oauthVerifier,
			WebRequest request) {
		carePassOAuth.grantOauthAccess(oauthVerifier);
		return "endpoint";
	}
				
The retrieved access_token is stored in the CarePassOAuth service and could be requested to be used. 

CarePass Sync Endpoint Implementation Example
=============================================

The following is an example of an API call after getting the access_token 

	@Autowired
	private IdentityService identityService;

	@RequestMapping(value = { "MAPPED_API_CALL_URI" }, method = RequestMethod.GET)
	public String identityGet(WebRequest request, Model model) {
		try {
		Identity identity=	identityService.findIdentity();
		
		model.addAttribute("firstName", identity.getFirstName());
		model.addAttribute("lastName", identity.getLastName());
		model.addAttribute("email",identity.getEmail());
		
		} catch (EndpointException e) {			
			model.addAttribute("error",e.getMessage());
			e.printStackTrace();
			return "redirect:"+AUTHENTIFICATION_PAGE;
		}
		return "USER_IDENTITY_PAGE";
	}
		
	
CarePass HTS Configuration
===========================

The main configuration for HTS should looks like the below portion of code, that has to be set in your Spring configuration file

	<bean id="hhsApiService" class="com.aetna.carepass.hhs.hhsapi.HhsApiServiceImpl">
		<property name="apiKey" value="HHS_API_KEY"></property>
	</bean>
	<bean id="eccApiService" class="com.aetna.carepass.hhs.ecc.EccApiServiceImpl">
		<property name="apiKey" value="ECC_API_KEY"></property>
	</bean>
	<bean id="goodRXApiService" class="com.aetna.carepass.hhs.goodrx.GoodRXApiServiceImpl">
		<property name="apiKey" value="GOODRX_API_KEY"></property>
	</bean>
	<bean id="deIdentificatedClaimsApiService"
		class="com.aetna.carepass.hhs.claims.DeIdentificatedClaimsApiServiceImpl">
		<property name="apiKey" value="DE_IDENTIFICATED_CLAIMS_API_KEY"></property>
	</bean>


CarePass HTS Endpoint Implementation Example
=============================================

The following is an example of an API an ECC's api call. 

	@RequestMapping(value = { "/MAPPED_API_CALL_URI" }, method = RequestMethod.GET)
	public String listMedicalCCCpt(
			@RequestParam(value = "REQUEST_PARAMETER_1", required = false) String rp1,
			@RequestParam(value = "REQUEST_PARAMETER_2", required = false) String rp2,
			@RequestParam(value = "REQUEST_PARAMETER_3", required = false) String rp3,
			Model model) {
		try {

			List<CostCareInformation> responseList = eccApiService
					.listECCMedicalInformation(rp1, rp2, rp3);
			//Parsing to show in JSON format
			Gson gson = new Gson();
			model.addAttribute("response", gson.toJson(responseList));
		} catch (Exception e) {
			model.addAttribute("error", e.getMessage());
		}
		return "hhs/ecc";
	}
	
Adding the CarePass Java Client Libraries to Your Project
========================================================

The Java Client library for CarePass is a Maven project.  While it is not available in a Maven repository, you may download it and build it locally.  It will load it's own dependencies from external repositories.

1.  The code for the project can be found here:  <https://github.com/carepass/client-libraries/tree/Java>
2.  If you do not already have Maven installed, it can be downloaded here: <http://maven.apache.org/download.html>
3.  Once you have downloaded the code and installed Maven, build the project by using `mvn clean install`

	
You can then add the CarePass Sync and CarePass HTS built project to your own maven project with the below dependency:	
		
	<dependency>
		<groupId>com.aetna.carepass</groupId>
		<artifactId>consumer-platform-carepass-java-connector</artifactId>
	</dependency>



