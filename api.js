/*global window */
var HTSObject = (function ($) {
    "use strict";
    var baseURL = 'https://api.carepass.com', make_request;

    make_request = function (option) {
        $.ajax({
            type: option.method || "GET",
            url: option.url,
            dataType: option.type || "jsonp",
            data: option.data,
            async: option.async || false,
            success: function (data, textStatus) {
                if (option.onSuccess) {
                    option.onSuccess.call(option.context, data, textStatus);
                }
            },
            error: function (data, textStatus) {
                if (option.onFailure) {
                    option.onFailure.call(option.context, data, textStatus);
                }
            }
        });
    };

    return {
        setBaseURL: function (newBaseUrl) {
            baseURL = newBaseUrl;
        },

        clinicalTrialsApi: function (theApiKey) {
            var trialContext = this,
                apiKey = theApiKey,
                subWeb = '/hhs-directory-api',
                url = '/clinicaltrials/',
                request = make_request; // make available in current scope

            return {
                /**
                 *
                 * @param {string}  nctId - Registry number (example:NCT00835224)   (required)
                 * @param {Object}   options - options for the method call
                 * @property {Object} options.performDataValidation: option which determines
                 *                      if the object should perform validation on the parameters
                 *                      before making the api call.
                 * @property {function}
                 *            [options.onSuccess] a callback function called on
                 *
                 * success. takes args data, textStatus
                 * @property {function}
                 *            [options.onFailure] a callback function called on
                 * @return {boolean}
                 */
                getTrialsByNCTId: function (nctId, options) {
                    if (!nctId) {
                        return false;
                    }

                    request({
                        url: baseURL + subWeb + url + nctId,
                        data: {
                            apikey: apiKey
                        },
                        onSuccess: options.onSuccess,
                        onFailure: options.onFailure,
                        context: trialContext
                    });
                },

                /**
                 * A method used to search the clinical trials (at least one
                 * parameter in
                 *
                 * the searchParams parameter is required
                 *
                 * @param searchParams - search parameters for the method    call
                 * @property {string}  - searchParams.drugname: Name of drug (not required)
                 * @property {string}  - searchParams.status: Status of clinical trials /   "open" or "closed" (not required)
                 * @property {int}     - searchParams.page: Page number. Each page has  until 500 results.
                 *                      (e.g. page=1 return the last 500 clinical trials). (not required)
                 * @property {string}  - searchParams.condition: condition summary
                 *                      (example: Depression).(not required)
                 * @property {string} - searchParams.state1: Two letter abbreviation of the state
                 *
                 * to be searched (not required)
                 * @property {string} - searchParams.state2: Two letter abbreviation of the state to be searched
                 *
                 * (not required)
                 * @property {string} - searchParams.state3: Two letter abbreviation of the state to be searched
                 *
                 * (not required)
                 * @property {string} - searchParams.country1: Two letter abbreviation of the region followed by the two
                 *                      letter country code to be searched
                 * (not required)
                 * @property {string} - searchParams.country2: Two letter abbreviation of the
                 *                      region followed by the two letter country code to be searched
                 * (not required)
                 * @property {string} - searchParams.country3: Two letter abbreviation of the
                 *                      region followed by the two letter country code to be searched
                 *                      (not required)
                 * @property {string} - searchParams.firstreceivedfrom: "mm/dd/yyyy" - The first
                 *                      received date is the date when the clinical trial was first
                 *                      submitted to ClinicalTrials.gov. There is often a delay of a few days before
                 *                      the trial is available on the ClinicalTrials.gov website.
                 *
                 * (not required)
                 * @property {string} - searchParams.firstreceivedto: "mm/dd/yyyy" - The first  received date is the
                 *                      date when the clinical trial was first submitted to ClinicalTrials.gov.
                 *                      There is often a delay of a few days before the trial is available on the
                 *                      ClinicalTrials.gov website.
                 *
                 * (not required)
                 * @property {string} - searchParams.lastupdatedfrom: "mm/dd/yyyy" - The last updated date is the most
                 *                      recent date when changes to a clinical trial were submitted to
                 *                      ClinicalTrials.gov. There is often a delay of a few days before the updated
                 *                      trial is available on the ClinicalTrials.gov website.
                 *
                 * (not required)
                 * @property {string} - searchParams.lastupdatedto: "mm/dd/yyyy" - "mm/dd/yyyy" - The last updated date
                 *                      is the most recent date when changes to a clinical trial were
                 *                      submitted to ClinicalTrials.gov. There is often a delay of a few days
                 *                      before the updated trial is available on the ClinicalTrials.gov website.
                 *
                 * (not required)
                 * @property {string} - searchParams.country3: Two letter abbreviation of the region followed by the two
                 *                      letter country code to be searched
                 *
                 *  (not required)
                 * @param options - options for the method call
                 *
                 * @property {string}   - options.performDataValidation: option which determines if the object should
                 *                        perform validation on the parameters before making the api call.
                 * @property {function} - [options.onSuccess] a callback function called on success. takes args data,
                 *                        textStatus
                 * @property {function} - [options.onFailure] a callback function called on
                 *
                 * failure. takes args xhr, msg, exc
                 */
                search: function (searchParams, options) {
                    searchParams = searchParams || {};
                    options = options || {};
                    var statePrefix = 'NA:US:', stateOption = searchParams.state1;
                    if (stateOption) {
                        searchParams.state1 = statePrefix + searchParams.state1;
                    }
                    stateOption = searchParams.state2;
                    if (stateOption) {
                        searchParams.state2 = statePrefix + searchParams.state2;
                    }
                    stateOption = searchParams.state3;
                    if (stateOption) {
                        searchParams.state3 = statePrefix + searchParams.state3;
                    }

                    searchParams.apiKey = apiKey;

                    request({
                        url: baseURL + url + 'search?',
                        data: searchParams,
                        onSuccess: options.onSuccess,
                        onFailure: options.onFailure,
                        context: trialContext
                    });
                }
            };

        },// end of clinicalTrials object
        drugsAPI: function (theApiKey) {
            var drugsContext = this,
                drugsUrl = '/drugs/',
                applicationsUrl = '/applications/',
                artUrl = 'art/',
                drugpricesUrl = '/drugprices/',
                recallsUrl = '/fdarecalls/',
                drugResources = '/drugsresources',
                drugDocuments = '/documents',
                drugsAlternatives = '/alternatives',
                subWeb = '/hhs-directory-api',
                apiKey = theApiKey,
                request = make_request;

            return {
                /**
                 * A method used to search the drug database by New Drug Application Code.
                 * @param {string} drugApplicationCode - New Drug Application Code
                 * @param options
                 * @example
                 * // example:NDA022307)
                 *  (required)
                 */
                getDrugByApplicationCode: function (drugApplicationCode, options) {

                    if (!drugApplicationCode) {
                        return false;
                    }

                    request({
                        url: baseURL + subWeb + applicationsUrl + drugApplicationCode,
                        data: {
                            apikey: apiKey
                        },
                        onSuccess: options.onSuccess,
                        onFailure: options.onFailure,
                        context: drugsContext
                    });
                },

                /**
                 * A method used to Search NDC's associated to a New Drug Application.
                 * @param {string} drugApplicationCode New Drug Application Code
                 * @param options
                 * @example (example:NDA022307) (required)
                 */
                getDrugResourcesByApplicationCode: function (drugApplicationCode, options) {
                    if (!drugApplicationCode) {
                        return false;
                    }

                    request({
                        url: baseURL + subWeb + applicationsUrl + drugApplicationCode + drugResources,
                        data: {
                            apikey: apiKey
                        },
                        onSuccess: options.onSuccess,
                        onFailure: options.onFailure,
                        context: drugsContext
                    });
                },

                /**
                 * A method used to search for therapeutic alternatives by a New Drug Application Code.
                 * @param {string} drugApplicationCode - New Drug Application Code
                 * @param options
                 * @example
                 * // example:NDA022307)
                 *  (required)
                 */
                getDrugAlternativesByApplicationCode: function (drugApplicationCode, options) {
                    if (!drugApplicationCode) {
                        return false;
                    }

                    request({
                        url: baseURL + subWeb + applicationsUrl + drugApplicationCode + drugsAlternatives,
                        data: {
                            apikey: apiKey
                        },
                        onSuccess: options.onSuccess,
                        onFailure: options.onFailure,
                        context: drugsContext
                    });
                },

                /**
                 * A method used to search for drug documents nby drug code
                 * @param {string} drugApplicationCode - New Drug Application Code
                 * @param options
                 * @example
                 * // example:NDA022307)
                 *  (required)
                 */
                getDrugDocumentsByApplicationCode: function (drugApplicationCode, options) {
                    if (!drugApplicationCode) {
                        return false;
                    }

                    request({
                        url: baseURL + subWeb + applicationsUrl + drugApplicationCode + drugDocuments,
                        data: {
                            apikey: apiKey
                        },
                        onSuccess: options.onSuccess,
                        onFailure: options.onFailure,
                        context: drugsContext
                    });
                },

                /**
                 * A method used to search for Assisted Reproductive Technology
                 *
                 * Information
                 *
                 * @param {string} clinicname - Search for all ART that match with the given clinic name
                 * @param {string} city - Search for all ART that match with the given city
                 * @param {string} state - Search for all ART that match with the given state
                 * @param {string} medicaldirector - Search for all ART that match with the given medical director
                 * @param {string} year - Search for all ART that match with the given year
                 * @param {boolean} exactmatch - Search for all ART that exactly
                 * @param {Object} options
                 * matches with the given parameter
                 */
                searchForART: function (clinicname, city, state, medicaldirector, year, exactmatch, options) {
                    var searchParams = {};
                    options = options || {};

                    if (state !== '') {
                        searchParams.state = state;
                    }

                    if (clinicname !== '') {
                        searchParams.clinicname = clinicname;
                    }

                    if (city !== '') {
                        searchParams.city = city;
                    }

                    if (medicaldirector !== '') {
                        searchParams.medicaldirector = medicaldirector;

                    }

                    if (year !== '') {
                        searchParams.year = year;
                    }

                    if (exactmatch) {
                        searchParams.exactmatch = true;

                    }

                    searchParams.apiKey = apiKey;

                    request({
                        url: baseURL + subWeb + '/' + artUrl + 'search',
                        data: searchParams,
                        onSuccess: options.onSuccess,
                        onFailure: options.onFailure,
                        context: drugsContext
                    });


                },

                /**
                 * Maps to the URL drugs/search. Example where the name is Cymbalta
                 * https://api.carepass.com/hhs-directory-api/drugs/search?name=Cymbalta&
                 * @drugName
                 */
                getDrugsByName: function (drugName, options) {

                    var theURL = baseURL + subWeb + drugsUrl + 'search', searchParams = {};
                    options = options || {};

                    searchParams.name = drugName;
                    searchParams.apiKey = apiKey;

                    request({
                        url: theURL,
                        data: searchParams,
                        onSuccess: options.onSuccess,
                        onFailure: options.onFailure,
                        context: drugsContext
                    });

                },

                /**
                 * Returns all image information about the requested NDC
                 * https://api.carepass.com/hhs-directory-api/drugs/0002-4760/images?
                 * @ndc2segment
                 */
                getDrugImagesByURL: function (ndc2segment, options) {

                    var theURL = baseURL + subWeb + drugsUrl + ndc2segment + '/images', searchParams = {};
                    options = options || {};

                    searchParams.ndc2segment = ndc2segment;
                    searchParams.apiKey = apiKey;

                    request({
                        url: theURL,
                        data: searchParams,
                        onSuccess: options.onSuccess,
                        onFailure: options.onFailure,
                        context: drugsContext
                    });

                },

                /**
                 * Returns all information about the requested NDC
                 * https://api.carepass.com/hhs-directory-api/drugs/0002-4760/packages/0002-4760-76
                 * @ndc2segment
                 * @ndc3Segment
                 */
                getDrugsByNDCPackages: function (ndc2Segment, ndc3Segment, options) {

                    var theURL = baseURL + subWeb + drugsUrl + ndc2Segment + '/packages/' + ndc3Segment,
                        searchParams = {};
                    options = options || {};

                    searchParams.apikey = apiKey;

                    request({
                        url: theURL,
                        data: searchParams,
                        onSuccess: options.onSuccess,
                        onFailure: options.onFailure,
                        context: drugsContext
                    });

                },

                fdaRecallSearch: function (searchParams, options) {

                    var theURL = baseURL + subWeb + recallsUrl + 'search';
                    options = options || {};

                    searchParams.apiKey = apiKey;

                    request({
                        url: theURL,
                        data: searchParams,
                        onSuccess: options.onSuccess,
                        onFailure: options.onFailure,
                        context: drugsContext
                    });

                }
            };
        },// end of drugs object
        deIdentifiedClaimsAPI: function (theApiKey) {
            var apiKey = theApiKey,
                claimsUrl = '/claims-directory-api/',
                subWeb = '/hhs-directory-api',
                deIdentContext = this,
                request = make_request;

            return {
                /***
                 * https://developer.carepass.com/io-docs
                 * https://api.carepass.com/claims-directory-api/claims/search?ndc=0004-0098&gender=F&birthyear=1980&from=2010Q1&to=2011Q3&page=1
                 * Search data of claims. At least one parameter is required.
                 * @ndc
                 * @gender
                 * @birthyear
                 * @from
                 * @to
                 * @page
                 */
                search: function (ndc, gender, birthyear, from, to, page, options) {

                    var theURL = baseURL + claimsUrl + 'claims/search', searchParams = {};
                    options = options || {};

                    searchParams.ndc = ndc;
                    searchParams.gender = gender;
                    searchParams.birthyear = birthyear;
                    searchParams.from = from;
                    searchParams.to = to;
                    searchParams.page = page;
                    searchParams.apiKey = apiKey;

                    request({
                        url: theURL,
                        data: searchParams,
                        onSuccess: options.onSuccess,
                        onFailure: options.onFailure,
                        context: deIdentContext
                    });

                }
            };
        },
        goodRxAPI: function (theApiKey) {
            var apiKey = theApiKey,
                drugPricesUrl = '/drugprices',
                deIdentContext = this,
                subWeb = '/good-rx-api',
                request = make_request;

            return {

                /***
                 * https://api.carepass.com/good-rx-api/drugprices/low?name=lipitor
                 * Search low drug price
                 * @name
                 */
                lowPrice: function (name, options) {

                    var theURL = baseURL + subWeb + drugPricesUrl + '/low', searchParams = {};
                    options = options || {};

                    searchParams.name = name;
                    searchParams.apiKey = apiKey;

                    request({
                        url: theURL,
                        data: searchParams,
                        onSuccess: options.onSuccess,
                        onFailure: options.onFailure,
                        context: deIdentContext
                    });
                },

                /***
                 * https://api.carepass.com/good-rx-api/drugprices/compare?name=lipitor&apikey=g2m4m43z7bzhebxv73ehswt8
                 * Compare drug prices
                 * @name
                 */
                compare: function (name, options) {

                    var theURL = baseURL + subWeb + drugPricesUrl + '/compare', searchParams = {};
                    options = options || {};

                    searchParams.name = name;
                    searchParams.apiKey = apiKey;

                    request({
                        url: theURL,
                        data: searchParams,
                        onSuccess: options.onSuccess,
                        onFailure: options.onFailure,
                        context: deIdentContext
                    });

                }
            };
        },
        MedCostOfCareAPI: function (theApiKey) {
            var apiKey = theApiKey,
                medCostCareUrl = '/med/',
                dentalCostCareUrl = '/dental/',
                medCostContext = this,
                subWeb = '/ecc-directory-api',
                request = make_request;

            return {

                /***
                 * Get Cost of Care for lat, lng
                 * https://api.carepass.com/ecc-directory-api/med/99205/38.898717,-77.035974
                 * @cpt - Current medical procedural terminology code
                 * @lat - lat eg. (38.898717)
                 * @lng - lng eg. (-77.035974)
                 */
                CostOfCareLatLngByCPT: function (cpt, lat, lng, options) {

                    var theURL = baseURL + subWeb + medCostCareUrl + cpt + '/' + lat + ',' + lng, searchParams = {};
                    options = options || {};

                    searchParams.apiKey = apiKey;

                    request({
                        url: theURL,
                        data: searchParams,
                        onSuccess: options.onSuccess,
                        onFailure: options.onFailure,
                        context: medCostContext
                    });

                },

                /***
                 * Get Cost of Zip for lat, lng
                 * https://api.carepass.com/ecc-directory-api/med/99205/38.898717,-77.035974
                 * @cpt - Current medical procedural terminology code
                 * @lat - lat eg. (38.898717)
                 * @lng - lng eg. (-77.035974)
                 */
                CostOfCareByZip: function (cpt, zip, options) {

                    var theURL = baseURL + subWeb + medCostCareUrl + cpt + '/zip/' + zip, searchParams = {};
                    options = options || {};

                    searchParams.apiKey = apiKey;

                    request({
                        url: theURL,
                        data: searchParams,
                        onSuccess: options.onSuccess,
                        onFailure: options.onFailure,
                        context: medCostContext
                    });

                },

                /***
                 * Get Cost of Care for lat, lng
                 * https://api.carepass.com/ecc-directory-api/med/99205/38.898717,-77.035974
                 * @cpt - Current medical procedural terminology code
                 * @lat - lat eg. (38.898717)
                 * @lng - lng eg. (-77.035974)
                 */
                DentalCostOfCareLatLngByCPT: function (cpt, lat, lng, options) {
                    var theURL = baseURL + subWeb + dentalCostCareUrl + cpt + '/' + lat + ',' + lng, searchParams = {};
                    options = options || {};
                    searchParams.apiKey = apiKey;

                    request({
                        url: theURL,
                        data: searchParams,
                        onSuccess: options.onSuccess,
                        onFailure: options.onFailure,
                        context: medCostContext
                    });

                },

                /***
                 * Get Cost of Zip for lat, lng
                 * https://api.carepass.com/ecc-directory-api/med/99205/38.898717,-77.035974
                 * @cpt - Current medical procedural terminology code
                 * @lat - lat eg. (38.898717)
                 * @lng - lng eg. (-77.035974)
                 */
                DentalCostOfCareLatLngByZip: function (cpt, zip, options) {

                    var theURL = baseURL + subWeb + dentalCostCareUrl + cpt + '/zip/' + zip, searchParams = {};
                    options = options || {};
                    searchParams.apiKey = apiKey;

                    request({
                        url: theURL,
                        data: searchParams,
                        onSuccess: options.onSuccess,
                        onFailure: options.onFailure,
                        context: medCostContext
                    });
                },

                /**
                 * Get all categories
                 * https://api.carepass.com/ecc-directory-api/categories?
                 */
                getAllCategories: function () {

                    var theURL = baseURL + subWeb + '/categories?apiKey=' + apiKey, searchParams = {};
                    request({
                        url: theURL,
                        data: searchParams,
                        context: medCostContext
                    });
                },

                /**
                 * Get category
                 * https://api.carepass.com/ecc-directory-api/categories?
                 */
                getCategories: function (category, options) {

                    var theURL = baseURL + subWeb + '/categories/' + category, searchParams = {};
                    options = options || {};

                    searchParams.apiKey = apiKey;

                    request({
                        url: theURL,
                        data: searchParams,
                        onSuccess: options.onSuccess,
                        onFailure: options.onFailure,
                        context: medCostContext
                    });
                }
            };
        }
    };
}(window.jQuery));