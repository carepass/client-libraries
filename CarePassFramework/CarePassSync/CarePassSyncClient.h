/*
 * Copyright 2012 Aetna, Inc. or its affiliates. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License").
 * You may not use this file except in compliance with the License.
 * A copy of the License is located at
 *
 *  http://www.apache.org/licenses/LICENSE-2.0.html
 *
 * or in the "license" file accompanying this file. This file is distributed
 * on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either
 * express or implied. See the License for the specific language governing
 * permissions and limitations under the License.
 */

#import "Model/CPSyncIdentityRequest.h"
#import "Model/CPSyncIdentityResponse.h"
#import "Model/CPSyncIdentityRequestMarshaller.h"
#import "Model/CPSyncIdentityResponseUnmarshaller.h"
#import "Model/CPSyncBiographyRequest.h"
#import "Model/CPSyncBiographyResponse.h"
#import "Model/CPSyncBiographyRequestMarshaller.h"
#import "Model/CPSyncBiographyResponseUnMarshaller.h"
#import "Model/CPSyncInsuranceLookupRequest.h"
#import "Model/CPSyncInsuranceLookupRequestMarshaller.h"
#import "Model/CPSyncInsLookupCarrierResponse.h"
#import "Model/CPSyncInsLookupCarrierResponseUnmarshaller.h"
#import "Model/CPSyncInsLookupPlanResponse.h"
#import "Model/CPSyncInsLookupPlanResponseUnmarshaller.h"
#import "Model/CPSyncInsurancePlanRequest.h"
#import "Model/CPSyncInsurancePlanRequestMarshaller.h"
#import "Model/CPSyncInsurancePlanResponse.h"
#import "Model/CPSyncInsurancePlanResponseUnmarshaller.h"
#import "Model/CPSyncFitLookupActivitiesRequest.h"
#import "Model/CPSyncFitLookupActivitiesRequestMarshaller.h"
#import "Model/CPSyncFitLookupActivitiesResponse.h"
#import "Model/CPSyncFitLookupActivitiesResponseUnmarshaller.h"
#import "Model/CPSyncFitActivitiesRequest.h"
#import "Model/CPSyncFitActivitiesRequestMarshaller.h"
#import "Model/CPSyncFitActivitiesResponse.h"
#import "Model/CPSyncFitActivitiesResponseUnmarshaller.h"
#import "Model/CPSyncLifestyleRequest.h"
#import "Model/CPSyncLifestyleRequestMarshaller.h"
#import "Model/CPSyncLifestyleResponse.h"
#import "Model/CPSyncLifestyleResponseUnmarshaller.h"

#import <Foundation/Foundation.h>
#import "CPSyncRequest.h"
#import "CPSyncResponse.h"
#import "../CarePassWebServiceClient.h"

/** <summary>
 * Interface for accessing the CarePass Sync API endpoints.
 *
 *  CarePass Sync API
 * </summary>
 *
 * \ingroup CPS
 */
@interface CarePassSyncClient : CarePassWebServiceClient

/**
 * <p>
 * </p>
 *
 * @param searchRequest Container for the necessary parameters to
 *           execute the identity service method on CarePass Sync.
 *
 * @return The response from the identity service method, as returned by
 *         CarePass Sync.
 *
 *
 * @throws CarePassClientException
 *             If any internal errors are encountered inside the client while
 *             attempting to make the request or handle the response.  For example
 *             if a network connection is not available.
 * @throws CarePassServiceException
 *             If an error response is returned by CarePass indicating
 *             either a problem with the data in the request, or a server side issue.
 */
-(CPSyncIdentityResponse *)getIdentity:(CPSyncIdentityRequest *)searchRequest;

/**
 * <p>
 * </p>
 *
 * @param searchRequest Container for the necessary parameters to
 *           execute the biography get service method on CarePass Sync.
 *
 * @return The response from the biography get service method, as returned by
 *         CarePass Sync.
 *
 *
 * @throws CarePassClientException
 *             If any internal errors are encountered inside the client while
 *             attempting to make the request or handle the response.  For example
 *             if a network connection is not available.
 * @throws CarePassServiceException
 *             If an error response is returned by CarePass indicating
 *             either a problem with the data in the request, or a server side issue.
 */
-(CPSyncBiographyResponse *)getBiography:(CPSyncBiographyRequest *)searchRequest;

/**
 * <p>
 * </p>
 *
 * @param request Container for the necessary parameters to
 *           execute the biography save service method on CarePass Sync.
 *
 * @return The response from the biography save service method, as returned by
 *         CarePass Sync.
 *
 *
 * @throws CarePassClientException
 *             If any internal errors are encountered inside the client while
 *             attempting to make the request or handle the response.  For example
 *             if a network connection is not available.
 * @throws CarePassServiceException
 *             If an error response is returned by CarePass indicating
 *             either a problem with the data in the request, or a server side issue.
 */
//-(CPSyncBiographyResponse *)saveBiography:(CPSyncBiographyRequest *)request;

/**
 * <p>
 * </p>
 *
 * @param request Container for the necessary parameters to
 *           execute the biography save service method on CarePass Sync.
 *
 * @return The response from the biography save service method, as returned by
 *         CarePass Sync.
 *
 *
 * @throws CarePassClientException
 *             If any internal errors are encountered inside the client while
 *             attempting to make the request or handle the response.  For example
 *             if a network connection is not available.
 * @throws CarePassServiceException
 *             If an error response is returned by CarePass indicating
 *             either a problem with the data in the request, or a server side issue.
 */
-(CPSyncInsLookupCarrierResponse *)lookupInsuranceCarriers:(CPSyncInsuranceLookupRequest *)request;

/**
 * <p>
 * </p>
 *
 * @param request Container for the necessary parameters to
 *           execute the biography save service method on CarePass Sync.
 *
 * @return The response from the biography save service method, as returned by
 *         CarePass Sync.
 *
 *
 * @throws CarePassClientException
 *             If any internal errors are encountered inside the client while
 *             attempting to make the request or handle the response.  For example
 *             if a network connection is not available.
 * @throws CarePassServiceException
 *             If an error response is returned by CarePass indicating
 *             either a problem with the data in the request, or a server side issue.
 */
-(CPSyncInsLookupPlanResponse *)lookupInsurancePlans:(CPSyncInsuranceLookupRequest *)request;

/**
 * <p>
 * Looks up all insurance plans for the current user
 * </p>
 *
 * @param request Container for the necessary parameters to
 *           execute the biography save service method on CarePass Sync.
 *
 * @return The response from the biography save service method, as returned by
 *         CarePass Sync.
 *
 *
 * @throws CarePassClientException
 *             If any internal errors are encountered inside the client while
 *             attempting to make the request or handle the response.  For example
 *             if a network connection is not available.
 * @throws CarePassServiceException
 *             If an error response is returned by CarePass indicating
 *             either a problem with the data in the request, or a server side issue.
 */
-(CPSyncInsurancePlanResponse *)getInsurancePlans:(CPSyncInsurancePlanRequest *)planRequest;

/**
 * <p>
 * Gets the single insurance plan as specified by the plan id passed in the request
 * </p>
 *
 * @param request Container for the necessary parameters to
 *           execute the biography save service method on CarePass Sync.
 *
 * @return The response from the biography save service method, as returned by
 *         CarePass Sync.
 *
 *
 * @throws CarePassClientException
 *             If any internal errors are encountered inside the client while
 *             attempting to make the request or handle the response.  For example
 *             if a network connection is not available.
 * @throws CarePassServiceException
 *             If an error response is returned by CarePass indicating
 *             either a problem with the data in the request, or a server side issue.
 */
-(CPSyncInsurancePlanResponse *)getInsurancePlan:(CPSyncInsurancePlanRequest *)planRequest;

/**
 * <p>
 * Updates the insurance plans passed in the request (PUT)
 * </p>
 *
 * @param request Container for the necessary parameters to
 *           execute the biography save service method on CarePass Sync.
 *
 * @return The response from the biography save service method, as returned by
 *         CarePass Sync.
 *
 *
 * @throws CarePassClientException
 *             If any internal errors are encountered inside the client while
 *             attempting to make the request or handle the response.  For example
 *             if a network connection is not available.
 * @throws CarePassServiceException
 *             If an error response is returned by CarePass indicating
 *             either a problem with the data in the request, or a server side issue.
 */
-(CPSyncInsurancePlanResponse *)updateInsurancePlan:(CPSyncInsurancePlanRequest *)planRequest;

/**
 * <p>
 * Saves the insurance plans passed in the request (POST)
 * </p>
 *
 * @param request Container for the necessary parameters to
 *           execute the biography save service method on CarePass Sync.
 *
 * @return The response from the biography save service method, as returned by
 *         CarePass Sync.
 *
 *
 * @throws CarePassClientException
 *             If any internal errors are encountered inside the client while
 *             attempting to make the request or handle the response.  For example
 *             if a network connection is not available.
 * @throws CarePassServiceException
 *             If an error response is returned by CarePass indicating
 *             either a problem with the data in the request, or a server side issue.
 */
-(CPSyncInsurancePlanResponse *)saveInsurancePlans:(CPSyncInsurancePlanRequest *)planRequest;

/**
 * <p> NOT AVAILABLE AS OF JULY 2012
 * </p>
 *
 * @param request Container for the necessary parameters to
 *           execute the lookup activities service method on CarePass Sync.
 *
 * @return The response from the lookup activities service method, as returned by
 *         CarePass Sync.
 *
 *
 * @throws CarePassClientException
 *             If any internal errors are encountered inside the client while
 *             attempting to make the request or handle the response.  For example
 *             if a network connection is not available.
 * @throws CarePassServiceException
 *             If an error response is returned by CarePass indicating
 *             either a problem with the data in the request, or a server side issue.
 */
-(CPSyncFitLookupActivitiesResponse *)lookupActivities:(CPSyncFitLookupActivitiesRequest *)request;

/**
 * <p>
 * Looks up all activities for the current user based on the request passed in
 * </p>
 *
 * @param request Container for the necessary parameters to
 *           execute the get activities service method on CarePass Sync.
 *
 * @return The response from the get activities service method, as returned by
 *         CarePass Sync.
 *
 *
 * @throws CarePassClientException
 *             If any internal errors are encountered inside the client while
 *             attempting to make the request or handle the response.  For example
 *             if a network connection is not available.
 * @throws CarePassServiceException
 *             If an error response is returned by CarePass indicating
 *             either a problem with the data in the request, or a server side issue.
 */
-(CPSyncFitActivitiesResponse *)getActivities:(CPSyncFitActivitiesRequest *)activityRequest;

/**
 * <p>
 * Gets a single activity as specified by the activity id passed in the request
 * </p>
 *
 * @param request Container for the necessary parameters to
 *           execute the get activity service method on CarePass Sync.
 *
 * @return The response from the get activity service method, as returned by
 *         CarePass Sync.
 *
 *
 * @throws CarePassClientException
 *             If any internal errors are encountered inside the client while
 *             attempting to make the request or handle the response.  For example
 *             if a network connection is not available.
 * @throws CarePassServiceException
 *             If an error response is returned by CarePass indicating
 *             either a problem with the data in the request, or a server side issue.
 */
-(CPSyncFitActivitiesResponse *)getActivity:(CPSyncFitActivitiesRequest *)activityRequest;

/**
 * <p>
 * Updates the activities passed in the request (PUT)
 * </p>
 *
 * @param request Container for the necessary parameters to
 *           execute the activity update service method on CarePass Sync.
 *
 * @return The response from the activity update service method, as returned by
 *         CarePass Sync.
 *
 *
 * @throws CarePassClientException
 *             If any internal errors are encountered inside the client while
 *             attempting to make the request or handle the response.  For example
 *             if a network connection is not available.
 * @throws CarePassServiceException
 *             If an error response is returned by CarePass indicating
 *             either a problem with the data in the request, or a server side issue.
 */
-(CPSyncFitActivitiesResponse *)updateActivities:(CPSyncFitActivitiesRequest *)activityRequest;

/**
 * <p>
 * Saves the activities passed in the request (POST)
 * </p>
 *
 * @param request Container for the necessary parameters to
 *           execute the activity save service method on CarePass Sync.
 *
 * @return The response from the activity save service method, as returned by
 *         CarePass Sync.
 *
 *
 * @throws CarePassClientException
 *             If any internal errors are encountered inside the client while
 *             attempting to make the request or handle the response.  For example
 *             if a network connection is not available.
 * @throws CarePassServiceException
 *             If an error response is returned by CarePass indicating
 *             either a problem with the data in the request, or a server side issue.
 */
-(CPSyncFitActivitiesResponse *)saveActivities:(CPSyncFitActivitiesRequest *)activityRequest;

/**
 * <p>
 * Gets all lifestyle items for the current user
 * </p>
 *
 * @param request Container for the necessary parameters to
 *           execute the get lifestyle items service method on CarePass Sync.
 *
 * @return The response from the get lifestyle items service method, as returned by
 *         CarePass Sync.
 *
 *
 * @throws CarePassClientException
 *             If any internal errors are encountered inside the client while
 *             attempting to make the request or handle the response.  For example
 *             if a network connection is not available.
 * @throws CarePassServiceException
 *             If an error response is returned by CarePass indicating
 *             either a problem with the data in the request, or a server side issue.
 */
-(CPSyncLifestyleResponse *)getLifestyleItems:(CPSyncLifestyleRequest *)lifestyleRequest;

/**
 * <p>
 * Gets all lifestyle items for the current user as specified by the lifestyle type 
 * passed in the request
 * </p>
 *
 * @param request Container for the necessary parameters to
 *           execute the get lifestyle items service method on CarePass Sync.
 *
 * @return The response from the get lifestyle items service method, as returned by
 *         CarePass Sync.
 *
 *
 * @throws CarePassClientException
 *             If any internal errors are encountered inside the client while
 *             attempting to make the request or handle the response.  For example
 *             if a network connection is not available.
 * @throws CarePassServiceException
 *             If an error response is returned by CarePass indicating
 *             either a problem with the data in the request, or a server side issue.
 */
-(CPSyncLifestyleResponse *)getLifestyleItem:(CPSyncLifestyleRequest *)lifestyleRequest;

/**
 * <p>
 * Saves the lifestyle items passed in the request (PUT)
 * </p>
 *
 * @param request Container for the necessary parameters to
 *           execute the lifestyle item save service method on CarePass Sync.
 *
 * @return The response from the lifestyle item save service method, as returned by
 *         CarePass Sync.
 *
 *
 * @throws CarePassClientException
 *             If any internal errors are encountered inside the client while
 *             attempting to make the request or handle the response.  For example
 *             if a network connection is not available.
 * @throws CarePassServiceException
 *             If an error response is returned by CarePass indicating
 *             either a problem with the data in the request, or a server side issue.
 */
-(CPSyncLifestyleResponse *)saveLifestyleItems:(CPSyncLifestyleRequest *)lifestyleRequest;

/**
 * <p>
 * Saves the lifestyle items passed in the request to a particular type (PUT)
 * </p>
 *
 * @param request Container for the necessary parameters to
 *           execute the lifestyle item save service method on CarePass Sync.
 *
 * @return The response from the lifestyle item save service method, as returned by
 *         CarePass Sync.
 *
 *
 * @throws CarePassClientException
 *             If any internal errors are encountered inside the client while
 *             attempting to make the request or handle the response.  For example
 *             if a network connection is not available.
 * @throws CarePassServiceException
 *             If an error response is returned by CarePass indicating
 *             either a problem with the data in the request, or a server side issue.
 */
-(CPSyncLifestyleResponse *)saveLifestyleItemsByType:(CPSyncLifestyleRequest *)lifestyleRequest;

@end
