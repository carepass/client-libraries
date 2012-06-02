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

#import "Model/HHSFDARecallsSearchRequest.h"
#import "Model/HHSFDARecallsSearchResponse.h"
#import "Model/HHSFDARecallsSearchRequestMarshaller.h"
#import "Model/HHSFDARecallsSearchResponseUnmarshaller.h"
#import "Model/HHSARTSearchRequest.h"
#import "Model/HHSARTSearchResponse.h"
#import "Model/HHSARTSearchRequestMarshaller.h"
#import "Model/HHSARTSearchResponseUnmarshaller.h"
#import "Model/HHSFDADrugsRequest.h"
#import "Model/HHSFDADrugsResponse.h"
#import "Model/HHSFDADrugsResourcesResponse.h"
#import "Model/HHSFDADrugsResourcesResponseUnmarshaller.h"
#import "Model/HHSFDADrugsDocumentsResponse.h"
#import "Model/HHSFDADrugsDocumentsResponseUnmarshaller.h"
#import "Model/HHSFDADrugsAlternativesResponse.h"
#import "Model/HHSFDADrugsAlternativesResponseUnmarshaller.h"
#import "Model/HHSFDADrugsRequestMarshaller.h"
#import "Model/HHSFDADrugsResponseUnmarshaller.h"
#import "Model/HHSClinicalTrialsSearchRequest.h"
#import "Model/HHSClinicalTrialsSearchResponse.h"
#import "Model/HHSClinicalTrialsSearchRequestMarshaller.h"
#import "Model/HHSClinicalTrialsSearchResponseUnmarshaller.h"
#import "Model/HHSClinicalTrialsNCTRequest.h"
#import "Model/HHSClinicalTrialsNCTResponse.h"
#import "Model/HHSClinicalTrialsNCTRequestMarshaller.h"
#import "Model/HHSClinicalTrialsNCTResponseUnmarshaller.h"
#import "Model/HHSDrugsSearchRequest.h"
#import "Model/HHSDrugsSearchResponse.h"
#import "Model/HHSDrugsSearchRequestMarshaller.h"
#import "Model/HHSDrugsSearchResponseUnmarshaller.h"
#import "Model/HHSDrugsNDCRequest.h"
#import "Model/HHSDrugsNDCResponse.h"
#import "Model/HHSDrugsNDCPackagesResponse.h"
#import "Model/HHSDrugsNDCImagesResponse.h"
#import "Model/HHSDrugsNDCRequestMarshaller.h"
#import "Model/HHSDrugsNDCResponseUnmarshaller.h"
#import "Model/HHSDrugsNDCPackagesResponseUnmarshaller.h"
#import "Model/HHSDrugsNDCImagesResponseUnmarshaller.h"


#import "HHSRequest.h"
#import "HHSResponse.h"
#import "../CarePassWebServiceClient.h"

/** <summary>
 * Interface for accessing the HHS API endpoints.
 *
 *  CarePass HHS API
 * </summary>
 *
 * \ingroup HHS
 */
@interface CarePassHHSClient : CarePassWebServiceClient

/**
 * <p>
 * The ARTSearch action searches for the details of an Assistive Reproductive
 * Technology Clinic based on the parameters supplied in the request
 * </p>
 *
 * @param searchRequest Container for the necessary parameters to
 *           execute the ARTSearch service method on CarePass HHS.
 *
 * @return The response from the ARTSearch service method, as returned by
 *         CarePass HHS.
 *
 * @throws HHSInternalErrorException
 * @throws HHSValidationErrorException
 *
 * @throws CarePassClientException
 *             If any internal errors are encountered inside the client while
 *             attempting to make the request or handle the response.  For example
 *             if a network connection is not available.
 * @throws CarePassServiceException
 *             If an error response is returned by CarePass indicating
 *             either a problem with the data in the request, or a server side issue.
 */
-(HHSARTSearchResponse *)artSearch:(HHSARTSearchRequest *)searchRequest;

/**
 * <p>
 * The FDARecall action searches for ... based on the parameters supplied in the request
 * </p>
 *
 * @param searchRequest Container for the necessary parameters to
 *           execute the FDARecall service method on CarePass HHS.
 *
 * @return The response from the FDARecall service method, as returned by
 *         CarePass HHS.
 *
 * @throws HHSInternalErrorException
 * @throws HHSValidationErrorException
 *
 * @throws CarePassClientException
 *             If any internal errors are encountered inside the client while
 *             attempting to make the request or handle the response.  For example
 *             if a network connection is not available.
 * @throws CarePassServiceException
 *             If an error response is returned by CarePass indicating
 *             either a problem with the data in the request, or a server side issue.
 */
-(HHSFDARecallsSearchResponse *)fdaRecallSearch:(HHSFDARecallsSearchRequest *)searchRequest;

/**
 * <p>
 * The FDADrugs action searches for ... based on the parameters supplied in the request
 * </p>
 *
 * @param searchRequest Container for the necessary parameters to
 *           execute the FDARecall service method on CarePass HHS.
 *
 * @return The response from the FDARecall service method, as returned by
 *         CarePass HHS.
 *
 * @throws HHSInternalErrorException
 * @throws HHSValidationErrorException
 *
 * @throws CarePassClientException
 *             If any internal errors are encountered inside the client while
 *             attempting to make the request or handle the response.  For example
 *             if a network connection is not available.
 * @throws CarePassServiceException
 *             If an error response is returned by CarePass indicating
 *             either a problem with the data in the request, or a server side issue.
 */
-(HHSFDADrugsResponse *)fdaDrugsSearch:(HHSFDADrugsRequest *)searchRequest;

/**
 * <p>
 * The FDADrugsResources action searches for ... based on the parameters supplied in the request
 * </p>
 *
 * @param searchRequest Container for the necessary parameters to
 *           execute the FDARecall service method on CarePass HHS.
 *
 * @return The response from the FDARecall service method, as returned by
 *         CarePass HHS.
 *
 * @throws HHSInternalErrorException
 * @throws HHSValidationErrorException
 *
 * @throws CarePassClientException
 *             If any internal errors are encountered inside the client while
 *             attempting to make the request or handle the response.  For example
 *             if a network connection is not available.
 * @throws CarePassServiceException
 *             If an error response is returned by CarePass indicating
 *             either a problem with the data in the request, or a server side issue.
 */
-(HHSFDADrugsResourcesResponse *)fdaDrugsResourcesSearch:(HHSFDADrugsRequest *)searchRequest;

/**
 * <p>
 * The FDADrugsAlternatives action searches for ... based on the parameters supplied in the request
 * </p>
 *
 * @param searchRequest Container for the necessary parameters to
 *           execute the FDARecall service method on CarePass HHS.
 *
 * @return The response from the FDARecall service method, as returned by
 *         CarePass HHS.
 *
 * @throws HHSInternalErrorException
 * @throws HHSValidationErrorException
 *
 * @throws CarePassClientException
 *             If any internal errors are encountered inside the client while
 *             attempting to make the request or handle the response.  For example
 *             if a network connection is not available.
 * @throws CarePassServiceException
 *             If an error response is returned by CarePass indicating
 *             either a problem with the data in the request, or a server side issue.
 */
-(HHSFDADrugsAlternativesResponse *)fdaDrugsAlternativesSearch:(HHSFDADrugsRequest *)searchRequest;

/**
 * <p>
 * The FDADrugsDocuments action searches for ... based on the parameters supplied in the request
 * </p>
 *
 * @param searchRequest Container for the necessary parameters to
 *           execute the FDARecall service method on CarePass HHS.
 *
 * @return The response from the FDARecall service method, as returned by
 *         CarePass HHS.
 *
 * @throws HHSInternalErrorException
 * @throws HHSValidationErrorException
 *
 * @throws CarePassClientException
 *             If any internal errors are encountered inside the client while
 *             attempting to make the request or handle the response.  For example
 *             if a network connection is not available.
 * @throws CarePassServiceException
 *             If an error response is returned by CarePass indicating
 *             either a problem with the data in the request, or a server side issue.
 */
-(HHSFDADrugsDocumentsResponse *)fdaDrugsDocumentsSearch:(HHSFDADrugsRequest *)searchRequest;

/**
 * <p>
 * The ClinicalTrialsSearch action searches for ... based on the parameters supplied in the request
 * </p>
 *
 * @param searchRequest Container for the necessary parameters to
 *           execute the ClinicalTrialsSearch service method on CarePass HHS.
 *
 * @return The response from the ClinicalTrialsSearch service method, as returned by
 *         CarePass HHS.
 *
 * @throws HHSInternalErrorException
 * @throws HHSValidationErrorException
 *
 * @throws CarePassClientException
 *             If any internal errors are encountered inside the client while
 *             attempting to make the request or handle the response.  For example
 *             if a network connection is not available.
 * @throws CarePassServiceException
 *             If an error response is returned by CarePass indicating
 *             either a problem with the data in the request, or a server side issue.
 */
-(HHSClinicalTrialsSearchResponse *)clinicalTrialsSearch:(HHSClinicalTrialsSearchRequest *)searchRequest;

/**
 * <p>
 * The ClinicalTrialsNCTSearch action searches for ... based on the parameters supplied in the request
 * </p>
 *
 * @param searchRequest Container for the necessary parameters to
 *           execute the ClinicalTrialsNCTSearch service method on CarePass HHS.
 *
 * @return The response from the ClinicalTrialsNCTSearch service method, as returned by
 *         CarePass HHS.
 *
 * @throws HHSInternalErrorException
 * @throws HHSValidationErrorException
 *
 * @throws CarePassClientException
 *             If any internal errors are encountered inside the client while
 *             attempting to make the request or handle the response.  For example
 *             if a network connection is not available.
 * @throws CarePassServiceException
 *             If an error response is returned by CarePass indicating
 *             either a problem with the data in the request, or a server side issue.
 */
-(HHSClinicalTrialsNCTResponse *)clinicalTrialsNCTSearch:(HHSClinicalTrialsNCTRequest *)searchRequest;

/**
 * <p>
 * The DrugsSearch action searches for ... based on the parameters supplied in the request
 * </p>
 *
 * @param searchRequest Container for the necessary parameters to
 *           execute the DrugsSearch service method on CarePass HHS.
 *
 * @return The response from the DrugsSearch service method, as returned by
 *         CarePass HHS.
 *
 * @throws HHSInternalErrorException
 * @throws HHSValidationErrorException
 *
 * @throws CarePassClientException
 *             If any internal errors are encountered inside the client while
 *             attempting to make the request or handle the response.  For example
 *             if a network connection is not available.
 * @throws CarePassServiceException
 *             If an error response is returned by CarePass indicating
 *             either a problem with the data in the request, or a server side issue.
 */
-(HHSDrugsSearchResponse *)drugsSearch:(HHSDrugsSearchRequest *)searchRequest;

/**
 * <p>
 * The DrugsNDC action searches for ... based on the parameters supplied in the request
 * </p>
 *
 * @param searchRequest Container for the necessary parameters to
 *           execute the DrugsNDC service method on CarePass HHS.
 *
 * @return The response from the DrugsNDC service method, as returned by
 *         CarePass HHS.
 *
 * @throws HHSInternalErrorException
 * @throws HHSValidationErrorException
 *
 * @throws CarePassClientException
 *             If any internal errors are encountered inside the client while
 *             attempting to make the request or handle the response.  For example
 *             if a network connection is not available.
 * @throws CarePassServiceException
 *             If an error response is returned by CarePass indicating
 *             either a problem with the data in the request, or a server side issue.
 */
-(HHSDrugsNDCResponse *)drugsNDC:(HHSDrugsNDCRequest *)searchRequest;

/**
 * <p>
 * The DrugsNDCPackages action searches for ... based on the parameters supplied in the request
 * </p>
 *
 * @param searchRequest Container for the necessary parameters to
 *           execute the DrugsNDCPackages service method on CarePass HHS.
 *
 * @return The response from the DrugsNDCPackages service method, as returned by
 *         CarePass HHS.
 *
 * @throws HHSInternalErrorException
 * @throws HHSValidationErrorException
 *
 * @throws CarePassClientException
 *             If any internal errors are encountered inside the client while
 *             attempting to make the request or handle the response.  For example
 *             if a network connection is not available.
 * @throws CarePassServiceException
 *             If an error response is returned by CarePass indicating
 *             either a problem with the data in the request, or a server side issue.
 */
-(HHSDrugsNDCPackagesResponse *)drugsNDCPackages:(HHSDrugsNDCRequest *)searchRequest;

/**
 * <p>
 * The DrugsNDCImages action searches for ... based on the parameters supplied in the request
 * </p>
 *
 * @param searchRequest Container for the necessary parameters to
 *           execute the DrugsNDCImages service method on CarePass HHS.
 *
 * @return The response from the DrugsNDCImages service method, as returned by
 *         CarePass HHS.
 *
 * @throws HHSInternalErrorException
 * @throws HHSValidationErrorException
 *
 * @throws CarePassClientException
 *             If any internal errors are encountered inside the client while
 *             attempting to make the request or handle the response.  For example
 *             if a network connection is not available.
 * @throws CarePassServiceException
 *             If an error response is returned by CarePass indicating
 *             either a problem with the data in the request, or a server side issue.
 */
-(HHSDrugsNDCImagesResponse *)drugsNDCImages:(HHSDrugsNDCRequest *)searchRequest;


@end
