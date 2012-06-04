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

#import "Model/DICSearchRequest.h"
#import "Model/DICSearchRequestMarshaller.h"
#import "Model/DICSearchResponse.h"
#import "Model/DICSearchResponseUnmarshaller.h"

#import "DICRequest.h"
#import "DICResponse.h"
#import "../CarePassWebServiceClient.h"

/** <summary>
 * Interface for accessing the De-identified Claims API endpoints.
 *
 *  CarePass DIC API
 * </summary>
 *
 * \ingroup DIC
 */
@interface CarePassDICClient : CarePassWebServiceClient

/**
 * <p>
 * The search action searches for the details ... based on the parameters supplied in the request
 * </p>
 *
 * @param searchRequest Container for the necessary parameters to
 *           execute the search service method on CarePass API.
 *
 * @return The response from the search service method, as returned by
 *         CarePass API.
 *
 * @throws CarePassClientException
 *             If any internal errors are encountered inside the client while
 *             attempting to make the request or handle the response.  For example
 *             if a network connection is not available.
 * @throws CarePassServiceException
 *             If an error response is returned by CarePass indicating
 *             either a problem with the data in the request, or a server side issue.
 */
-(DICSearchResponse *)search:(DICSearchRequest *)searchRequest;

@end
