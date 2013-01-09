/*global window */
var CPSyncObject = (function ($) {
    "use strict";
    var baseURL = 'https://api.carepass.com', request;

    request = function (option) {
        $.ajax({
            type: option.method || "GET",
            url: option.url,
            dataType: option.type || "json",
            data: option.data,
            headers : option.headers,
            contentType: option.contentType || 'application/json; charset=utf-8',
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

        insuranceApi: function (bearerAuthorization) {
            var trialContext = this,
                bearerAuth = bearerAuthorization,
                userDirApiUrl = '/user-directory-api';

            return {

                /**
                 * Saves Insurance for current User.
                 *
                 * @param {function}    [options.onSuccess] a callback function called on
                 *
                 * success. takes args data, textStatus
                 * @param {function}  [options.onFailure] a callback function called on
                 *
                 * failure. takes args xhr, msg, exc
                 *
                 */
                saveInsurance: function (dataObject, options) {

                    request({
                        type : "POST",
                        url: baseURL + userDirApiUrl + '/users/currentUser/insurance/plans',
                        data: JSON.stringify(dataObject),
                        headers: {
                            'Authorization': bearerAuth
                        },
                        onSuccess: options.onSuccess,
                        onFailure: options.onFailure,
                        context: trialContext
                    });

                },

                /**
                 * Retrieve plans by plan id
                 *
                 * @param {function}    [options.onSuccess] a callback function called on
                 *
                 * success. takes args data, textStatus
                 * @param {function}  [options.onFailure] a callback function called on
                 *
                 * failure. takes args xhr, msg, exc
                 *
                 */
                getPlansById: function (planId, options) {
                    var theUrl = baseURL + userDirApiUrl + '/users/currentUser/insurance/plans/' + planId;

                    request({
                        url: theUrl,
                        headers: {
                            'Authorization': bearerAuth
                        },
                        onSuccess: options.onSuccess,
                        onFailure: options.onFailure,
                        context: trialContext
                    });
                },

                /**
                 * Retrieve all plans
                 *
                 * @param {function}    [options.onSuccess] a callback function called on
                 *
                 * success. takes args data, textStatus
                 * @param {function}  [options.onFailure] a callback function called on
                 *
                 * failure. takes args xhr, msg, exc
                 *
                 */
                getPlans: function (options) {

                    var theUrl = baseURL + userDirApiUrl + '/users/currentUser/insurance/plans';

                    request({
                        url: theUrl,
                        headers: {
                            'Authorization': bearerAuth
                        },
                        onSuccess: options.onSuccess,
                        onFailure: options.onFailure,
                        context: trialContext
                    });
                },

                /**
                 * Retrieves carrierid and carriername of the insurance for lookup purpose
                 *
                 * @param {function}    [options.onSuccess] a callback function called on
                 *
                 * success. takes args data, textStatus
                 * @param {function}  [options.onFailure] a callback function called on
                 *
                 * failure. takes args xhr, msg, exc
                 *
                 */
                getInsuranceCarriers: function (options) {

                    var theUrl = baseURL + userDirApiUrl + '/insurance/carriers';

                    request({
                        url: theUrl,
                        headers: {
                            'Authorization': bearerAuth
                        },
                        onSuccess: options.onSuccess,
                        onFailure: options.onFailure,
                        context: trialContext
                    });
                },

                /**
                 * Retrieves carrierid, planid and planname of the insurance for lookup purpose
                 *
                 * @param {function}    [options.onSuccess] a callback function called on
                 *
                 * success. takes args data, textStatus
                 * @param {function}  [options.onFailure] a callback function called on
                 *
                 * failure. takes args xhr, msg, exc
                 *
                 */
                getInsurancePlansLookup: function (options) {

                    var theUrl = baseURL + userDirApiUrl + '/insurance/plans';

                    request({
                        url: theUrl,
                        headers: {
                            'Authorization': bearerAuth
                        },
                        onSuccess: options.onSuccess,
                        onFailure: options.onFailure,
                        context: trialContext
                    });
                },

                /**
                 * Update Insurance for current User.
                 *
                 * @param plansData  - json object containing 1 or more plans
                 * @param options
                 * @property {function}    [options.onSuccess] a callback function called on
                 *
                 * success. takes args data, textStatus
                 * @property {function}  [options.onFailure] a callback function called on
                 *
                 * failure. takes args xhr, msg, exc
                 *
                 */
                updateInsurancePlans: function (plansData, options) {

                    var theUrl = baseURL + userDirApiUrl + 'users/currentUser/insurance/plans';

                    request({
                        url: theUrl,
                        headers: {
                            'Authorization': bearerAuth
                        },
                        onSuccess: options.onSuccess,
                        onFailure: options.onFailure,
                        context: trialContext
                    });

                    function setHeader(xhr, token) {
                        xhr.setRequestHeader('Authorization', token);
                    }
                }
            };

        },// end of lifestyle object

        lifeStyleApi: function (bearerAuthorization) {
            var trialContext = this,
                bearerAuth = bearerAuthorization,
                userDirApiUrl = '/user-directory-api';

            return {
                /**
                 * A method used to search for lifestyle
                 * @param attribute
                 * @param options
                 * @property {function}  -  [options.onSuccess] a callback function called on
                 *                          success. takes args data, textStatus
                 * @property {function} -  [options.onFailure] a callback function called on
                 *                          failure. takes args xhr, msg, exc
                 *
                 */

                getLifestyleData: function (attribute, options) {

                    var theUrl = baseURL + userDirApiUrl + '/users/currentUser/lifestyle', searchParams = {};
                    if (attribute) {
                        searchParams.type = attribute;
                    }

                    request({
                        url: theUrl,
                        data : searchParams,
                        headers: {
                            'Authorization': bearerAuth
                        },
                        onSuccess: options.onSuccess,
                        onFailure: options.onFailure,
                        context: trialContext
                    });
                },

                /**
                 * A method used to save lifestyle data
                 *
                 * @param dataObject
                 * @param options
                 * @property {function}
                 *            [options.onSuccess] a callback function called on
                 *
                 * success. takes args data, textStatus
                 * @property {function}
                 *            [options.onFailure] a callback function called on
                 *
                 * failure. takes args xhr, msg, exc
                 *
                 */
                saveLifestyleData: function (dataObject, options) {

                    var theRequestUrl = baseURL + userDirApiUrl + '/users/currentUser/lifestyle';

                    if (dataObject.attribute) {
                        theRequestUrl = theRequestUrl + '/' + dataObject.attribute;
                    }

                    request({
                        url: theRequestUrl,
                        data : JSON.stringify(dataObject),
                        headers: {
                            'Authorization': bearerAuth
                        },
                        onSuccess: options.onSuccess,
                        onFailure: options.onFailure,
                        context: trialContext
                    });
                }

            };

        },// end of lifestyle object

        activitiesApi: function (bearerAuthorization) {
            var trialContext = this,
                bearerAuth = bearerAuthorization,
                userDirApiUrl = '/user-directory-api';

            return {

                /**
                 * Retrieves the Activities data for the current user for the given date range.
                 *
                 * @param fromDate Format: MM/DD/YYYY Example Values: 12/10/2010
                 * @param toDate Format: MM/DD/YYYY Example Values: 01/30/2012
                 *
                 * @param options
                 * @property {function}
                 *            [options.onSuccess] a callback function called on
                 *
                 * success. takes args data, textStatus
                 * @property {function}
                 *            [options.onFailure] a callback function called on
                 *
                 * failure. takes args xhr, msg, exc
                 *
                 */
                getUserActivityByDateRange: function (fromDate, toDate, options) {

                    var theUrl = baseURL + userDirApiUrl + '/users/currentUser/fitness/activities', searchParams = {};
                    if (fromDate) {
                        searchParams.dateFrom = fromDate;
                    }

                    if (toDate) {
                        searchParams.dateTo = toDate;
                    }

                    request({
                        url: theUrl,
                        data : searchParams,
                        headers: {
                            'Authorization': bearerAuth
                        },
                        onSuccess: options.onSuccess,
                        onFailure: options.onFailure,
                        context: trialContext
                    });
                },


                /***
                 * Retrieves the Activities data for the current user for the given activity id.
                 * @param activityId
                 * @example example 1296
                 * @param options
                 */
                getUserActivityById: function (activityId, options) {

                    var theRequestUrl = baseURL + userDirApiUrl + '/users/currentUser/fitness/activity/' + activityId;

                    request({
                        url: theRequestUrl,
                        headers: {
                            'Authorization': bearerAuth
                        },
                        onSuccess: options.onSuccess,
                        onFailure: options.onFailure,
                        context: trialContext
                    });
                },

                /***
                 * Retrieves all valid Activity types for look-up purpose.
                 *
                 */
                getActivityTypes: function (options) {

                    var theRequestUrl = baseURL + userDirApiUrl + '/fitness/activities/types';

                    request({
                        url: theRequestUrl,
                        headers: {
                            'Authorization': bearerAuth
                        },
                        onSuccess: options.onSuccess,
                        onFailure: options.onFailure,
                        context: trialContext
                    });
                },

                /***
                 * Creates activity data for the current user.
                 * @param dataObject reflecting the data structure as per api
                 * @param options
                 */
                createActivityData: function (dataObject, options) {

                    var theRequestUrl = baseURL + userDirApiUrl + '/users/currentUser/fitness/activities';

                    request({
                        type : 'POST',
                        url: theRequestUrl,
                        data : JSON.stringify(dataObject),
                        headers: {
                            'Authorization': bearerAuth
                        },
                        onSuccess: options.onSuccess,
                        onFailure: options.onFailure,
                        context: trialContext
                    });
                },

                /***
                 * Update activity data for the current user. PUT /users/currentUser/fitness/activities
                 *
                 * @param dataObject reflecting the data structure as per api
                 * @param options
                 */
                updateActivityData: function (dataObject, options) {

                    var theRequestUrl = baseURL + userDirApiUrl + '/users/currentUser/fitness/activities';

                    request({
                        type : 'PUT',
                        url: theRequestUrl,
                        data : JSON.stringify(dataObject),
                        headers: {
                            'Authorization': bearerAuth
                        },
                        onSuccess: options.onSuccess,
                        onFailure: options.onFailure,
                        context: trialContext
                    });
                }
            };

        },// end of lifestyle object

        biographyApi: function (bearerAuthorization) {
            var drugsContext = this,
                bearerAuth = bearerAuthorization,
                userDirApiUrl = '/user-directory-api';

            return {
                /**
                 * Get a user's identity
                 */
                getUserIdentity: function (options) {

                    var theUrl = baseURL + userDirApiUrl + '/users/currentUser';

                    request({
                        url: theUrl,
                        headers: {
                            'Authorization': bearerAuth
                        },
                        onSuccess: options.onSuccess,
                        onFailure: options.onFailure,
                        context: drugsContext
                    });
                },

                /**
                 * Get a user's identity
                 */
                getUserBiography: function (options) {

                    var theUrl = baseURL + userDirApiUrl + '/users/currentUser/biography';

                    request({
                        url: theUrl,
                        headers: {
                            'Authorization': bearerAuth
                        },
                        onSuccess: options.onSuccess,
                        onFailure: options.onFailure,
                        context: drugsContext
                    });
                },
                /**
                 * Creates (if one does not exist) or updates in context user's biography
                 * @param dataObject - user Biography object
                 * @param options
                 */
                saveUserBiography: function (dataObject, options) {

                    var theUrl = baseURL + userDirApiUrl + '/users/currentUser/biography';

                    request({
                        type : "PUT",
                        url: theUrl,
                        data : JSON.stringify(dataObject),
                        headers: {
                            'Authorization': bearerAuth
                        },
                        onSuccess: options.onSuccess,
                        onFailure: options.onFailure,
                        context: drugsContext
                    });
                }
            };
        },// end of biography object
        appointmentsAPI: function (bearerAuthorization) {
            var drugsContext = this,
                bearerAuth = bearerAuthorization,
                userDirApiUrl = '/user-directory-api';

            return {


                /**
                 * Get all appointments by appointmentId
                 */
                getAppointmentById: function (appointmentId, options) {

                    var theUrl = baseURL + userDirApiUrl + '/users/currentUser/appointments/' + appointmentId;

                    request({
                        url: theUrl,
                        headers: {
                            'Authorization': bearerAuth
                        },
                        onSuccess: options.onSuccess,
                        onFailure: options.onFailure,
                        context: drugsContext
                    });
                },

                /**
                 * Update an appointment for the current user.
                 * @param dataObj - user Biography object
                 * @param options
                 */

                updateAppointment: function (dataObj, options) {

                    var theUrl = baseURL + userDirApiUrl + '/users/currentUser/appointments';

                    request({
                        type : "PUT",
                        url: theUrl,
                        data : dataObj,
                        headers: {
                            'Authorization': bearerAuth
                        },
                        onSuccess: options.onSuccess,
                        onFailure: options.onFailure,
                        context: drugsContext
                    });
                },

                /**
                 * Create an appointment for the current user
                 * @param dataObj
                 * @param options
                 */
                createAppointment: function (dataObj, options) {

                    var theUrl = baseURL + userDirApiUrl + '/users/currentUser/appointments';

                    request({
                        type : "POST",
                        url: theUrl,
                        data : dataObj,
                        headers: {
                            'Authorization': bearerAuth
                        },
                        onSuccess: options.onSuccess,
                        onFailure: options.onFailure,
                        context: drugsContext
                    });
                },
                /**
                 * Create an appointment for the current user
                 * @param npiProviderId
                 * @param afterDate
                 * @param options
                 * @param carepassProviderId
                 */
                getAppointmentsByDateNpiOrCarePassProviderId: function (afterDate, carepassProviderId, npiProviderId, options) {
                    var theUrl = baseURL + userDirApiUrl + '/users/currentUser/appointments', searchParams = {};
                    if (afterDate) {
                        searchParams.afterDate = afterDate;
                    }

                    if (carepassProviderId) {
                        searchParams.carepassProviderId = carepassProviderId;
                    }

                    if (npiProviderId) {
                        searchParams.npiProviderId = npiProviderId;
                    }

                    request({
                        url: theUrl,
                        data : searchParams,
                        headers: {
                            'Authorization': bearerAuth
                        },
                        onSuccess: options.onSuccess,
                        onFailure: options.onFailure,
                        context: drugsContext
                    });
                },

                /**
                 * Delete an appointment for the current user.
                 * @param appointmentId
                 * @param options
                 */
                deleteAppointment: function (appointmentId, options) {

                    var theUrl = baseURL + userDirApiUrl + '/users/currentUser/appointments/' + appointmentId;

                    request({
                        type : "POST",
                        url: theUrl,
                        headers: {
                            'Authorization': bearerAuth
                        },
                        onSuccess: options.onSuccess,
                        onFailure: options.onFailure,
                        context: drugsContext
                    });
                }
            };
        } // end of appointments object
    };
}(window.jQuery));