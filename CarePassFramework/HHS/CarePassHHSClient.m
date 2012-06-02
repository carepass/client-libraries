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

#import "CarePassHHSClient.h"

@implementation CarePassHHSClient

-(id)initWithCredentials:(CarePassCredentials *)theCredentials
{
    if (self = [super initWithCredentials:theCredentials]) {
        // default, near useless endpoint
        self.endpoint = @"https://api.carepass.com/hhs-directory-api/";
    }
    return self;
}

#pragma mark Service Requests

-(HHSARTSearchResponse *)artSearch:(HHSARTSearchRequest *)searchRequest {
    CarePassServiceRequest *request = [HHSARTSearchRequestMarshaller createRequest:searchRequest];
    
    return (HHSARTSearchResponse *)[self invoke:request rawRequest:searchRequest unmarshallerDelegate:[HHSARTSearchResponseUnmarshaller class]];
}

-(HHSFDARecallsSearchResponse *)fdaRecallSearch:(HHSFDARecallsSearchRequest *)searchRequest {
    CarePassServiceRequest *request = [HHSFDARecallsSearchRequestMarshaller createRequest:searchRequest];
    
    return (HHSFDARecallsSearchResponse *)[self invoke:request rawRequest:searchRequest unmarshallerDelegate:[HHSFDARecallsSearchResponseUnmarshaller class]];
}

-(HHSFDADrugsResponse *)fdaDrugsSearch:(HHSFDADrugsRequest *)searchRequest {
    CarePassServiceRequest *request = [HHSFDADrugsRequestMarshaller createRequest:searchRequest];
    
    return (HHSFDADrugsResponse *)[self invoke:request rawRequest:searchRequest unmarshallerDelegate:[HHSFDADrugsResponseUnmarshaller class]];
}

-(HHSFDADrugsResourcesResponse *)fdaDrugsResourcesSearch:(HHSFDADrugsRequest *)searchRequest {
    CarePassServiceRequest *request = [HHSFDADrugsRequestMarshaller createRequest:searchRequest andType:@"RESOURCES"];
    
    return (HHSFDADrugsResourcesResponse *)[self invoke:request rawRequest:searchRequest unmarshallerDelegate:[HHSFDADrugsResourcesResponseUnmarshaller class]];
}

-(HHSFDADrugsAlternativesResponse *)fdaDrugsAlternativesSearch:(HHSFDADrugsRequest *)searchRequest {
    CarePassServiceRequest *request = [HHSFDADrugsRequestMarshaller createRequest:searchRequest andType:@"ALTERNATIVES"];
    
    return (HHSFDADrugsAlternativesResponse *)[self invoke:request rawRequest:searchRequest unmarshallerDelegate:[HHSFDADrugsAlternativesResponseUnmarshaller class]];
}

-(HHSFDADrugsDocumentsResponse *)fdaDrugsDocumentsSearch:(HHSFDADrugsRequest *)searchRequest {
    CarePassServiceRequest *request = [HHSFDADrugsRequestMarshaller createRequest:searchRequest andType:@"DOCUMENTS"];
    
    return (HHSFDADrugsDocumentsResponse *)[self invoke:request rawRequest:searchRequest unmarshallerDelegate:[HHSFDADrugsDocumentsResponseUnmarshaller class]];
}

-(HHSClinicalTrialsSearchResponse *)clinicalTrialsSearch:(HHSClinicalTrialsSearchRequest *)searchRequest {
    CarePassServiceRequest *request = [HHSClinicalTrialsSearchRequestMarshaller createRequest:searchRequest];
    
    return (HHSClinicalTrialsSearchResponse *)[self invoke:request rawRequest:searchRequest unmarshallerDelegate:[HHSClinicalTrialsSearchResponseUnmarshaller class]];
}

-(HHSClinicalTrialsNCTResponse *)clinicalTrialsNCTSearch:(HHSClinicalTrialsNCTRequest *)searchRequest {
    CarePassServiceRequest *request = [HHSClinicalTrialsNCTRequestMarshaller createRequest:searchRequest];
    
    return (HHSClinicalTrialsNCTResponse *)[self invoke:request rawRequest:searchRequest unmarshallerDelegate:[HHSClinicalTrialsNCTResponseUnmarshaller class]];
}

-(HHSDrugsSearchResponse *)drugsSearch:(HHSDrugsSearchRequest *)searchRequest {
    CarePassServiceRequest *request = [HHSDrugsSearchRequestMarshaller createRequest:searchRequest];
    
    return (HHSDrugsSearchResponse *)[self invoke:request rawRequest:searchRequest unmarshallerDelegate:[HHSDrugsSearchResponseUnmarshaller class]];    
}

-(HHSDrugsNDCResponse *)drugsNDC:(HHSDrugsNDCRequest *)searchRequest {
    CarePassServiceRequest *request = [HHSDrugsNDCRequestMarshaller createRequest:searchRequest];
    
    return (HHSDrugsNDCResponse *)[self invoke:request rawRequest:searchRequest unmarshallerDelegate:[HHSDrugsNDCResponseUnmarshaller class]];    
}

-(HHSDrugsNDCPackagesResponse *)drugsNDCPackages:(HHSDrugsNDCRequest *)searchRequest {
    CarePassServiceRequest *request = [HHSDrugsNDCRequestMarshaller createRequest:searchRequest andType:@"PACKAGES"];
    
    return (HHSDrugsNDCPackagesResponse *)[self invoke:request rawRequest:searchRequest unmarshallerDelegate:[HHSDrugsNDCPackagesResponseUnmarshaller class]];    
}

-(HHSDrugsNDCImagesResponse *)drugsNDCImages:(HHSDrugsNDCRequest *)searchRequest {
    CarePassServiceRequest *request = [HHSDrugsNDCRequestMarshaller createRequest:searchRequest andType:@"IMAGES"];
    
    return (HHSDrugsNDCImagesResponse *)[self invoke:request rawRequest:searchRequest unmarshallerDelegate:[HHSDrugsNDCImagesResponseUnmarshaller class]];    
}

#pragma mark memory management

-(void)dealloc {
    [super dealloc];
}

@end
