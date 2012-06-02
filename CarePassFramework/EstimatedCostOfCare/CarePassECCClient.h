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

#import "Model/ECCCostRequest.h"
#import "Model/ECCCostRequestMarshaller.h"
#import "Model/ECCCostResponse.h"
#import "Model/ECCCostResponseUnmarshaller.h"
#import "Model/ECCCategoryRequest.h"
#import "Model/ECCCategoryRequestMarshaller.h"
#import "Model/ECCCategoryResponse.h"
#import "Model/ECCCategoryResponseUnmarshaller.h"

#import "ECCRequest.h"
#import "ECCResponse.h"
#import "../CarePassWebServiceClient.h"

/** <summary>
 * Interface for accessing the Estimated Cost of Care API endpoints.
 *
 *  CarePass ECC API
 * </summary>
 *
 * \ingroup ECC
 */
@interface CarePassECCClient : CarePassWebServiceClient

/**
 * <p>
 * The ARTSearch action searches for ... based on the parameters supplied in the request
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
-(ECCCostResponse *)estimateMedicalCost:(ECCCostRequest *)searchRequest;

/**
 * <p>
 * The ARTSearch action searches for ... based on the parameters supplied in the request
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
-(ECCCostResponse *)estimateDentalCost:(ECCCostRequest *)searchRequest;

/**
 * <p>
 * The ARTSearch action searches for ... based on the parameters supplied in the request
 * </p>
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
-(ECCCategoryResponse *)getCategories;

/**
 * <p>
 * The ARTSearch action searches for ... based on the parameters supplied in the request
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
-(ECCCategoryResponse *)getSubcategories:(ECCCategoryRequest *)searchRequest;

@end
