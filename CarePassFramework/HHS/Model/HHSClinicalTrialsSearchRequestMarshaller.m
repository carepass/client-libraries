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

#import "HHSClinicalTrialsSearchRequestMarshaller.h"

@implementation HHSClinicalTrialsSearchRequestMarshaller

+(CarePassServiceRequest *)createRequest:(HHSClinicalTrialsSearchRequest *)clinicalTrialsSearchRequest {
    
    CarePassServiceRequest *request = [[HHSRequest alloc] init];
    
    [request setDelegate:[clinicalTrialsSearchRequest delegate]];
    [request setCredentials:[clinicalTrialsSearchRequest credentials]];
    [request setEndpoint:[clinicalTrialsSearchRequest requestEndpoint]];
    [request setRequestTag:[clinicalTrialsSearchRequest requestTag]];
    
    if (clinicalTrialsSearchRequest != nil) {
        if (clinicalTrialsSearchRequest.drugname != nil) {
            [request setParameterValue:[NSString stringWithFormat:@"%@", clinicalTrialsSearchRequest.drugname] forKey:[NSString stringWithFormat:@"%@", @"drugname"]];
        }
        if (clinicalTrialsSearchRequest.status != nil) {
            [request setParameterValue:[NSString stringWithFormat:@"%@", clinicalTrialsSearchRequest.status] forKey:[NSString stringWithFormat:@"%@", @"status"]];
        }
        if (clinicalTrialsSearchRequest.page != nil) {
            [request setParameterValue:[NSString stringWithFormat:@"%@", clinicalTrialsSearchRequest.page] forKey:[NSString stringWithFormat:@"%@", @"page"]];
        }
        if (clinicalTrialsSearchRequest.condition != nil) {
            [request setParameterValue:[NSString stringWithFormat:@"%@", clinicalTrialsSearchRequest.condition] forKey:[NSString stringWithFormat:@"%@", @"condition"]];
        }
        if (clinicalTrialsSearchRequest.state1 != nil) {
            [request setParameterValue:[NSString stringWithFormat:@"%@", clinicalTrialsSearchRequest.state1] forKey:[NSString stringWithFormat:@"%@", @"state1"]];
        }
        if (clinicalTrialsSearchRequest.state2 != nil) {
            [request setParameterValue:[NSString stringWithFormat:@"%@", clinicalTrialsSearchRequest.state2] forKey:[NSString stringWithFormat:@"%@", @"state2"]];
        }
        if (clinicalTrialsSearchRequest.state3 != nil) {
            [request setParameterValue:[NSString stringWithFormat:@"%@", clinicalTrialsSearchRequest.state3] forKey:[NSString stringWithFormat:@"%@", @"state3"]];
        }
        if (clinicalTrialsSearchRequest.country1 != nil) {
            [request setParameterValue:[NSString stringWithFormat:@"%@", clinicalTrialsSearchRequest.country1] forKey:[NSString stringWithFormat:@"%@", @"country1"]];
        }
        if (clinicalTrialsSearchRequest.country2 != nil) {
            [request setParameterValue:[NSString stringWithFormat:@"%@", clinicalTrialsSearchRequest.country2] forKey:[NSString stringWithFormat:@"%@", @"country2"]];
        }
        if (clinicalTrialsSearchRequest.country3 != nil) {
            [request setParameterValue:[NSString stringWithFormat:@"%@", clinicalTrialsSearchRequest.country3] forKey:[NSString stringWithFormat:@"%@", @"country3"]];
        }
        if (clinicalTrialsSearchRequest.firstreceivedfrom != nil) {
            [request setParameterValue:[NSString stringWithFormat:@"%@", clinicalTrialsSearchRequest.firstreceivedfrom] forKey:[NSString stringWithFormat:@"%@", @"firstreceivedfrom"]];
        }
        if (clinicalTrialsSearchRequest.firstreceivedto != nil) {
            [request setParameterValue:[NSString stringWithFormat:@"%@", clinicalTrialsSearchRequest.firstreceivedto] forKey:[NSString stringWithFormat:@"%@", @"firstreceivedto"]];
        }
        if (clinicalTrialsSearchRequest.lastupdatedfrom != nil) {
            [request setParameterValue:[NSString stringWithFormat:@"%@", clinicalTrialsSearchRequest.lastupdatedfrom] forKey:[NSString stringWithFormat:@"%@", @"lastupdatedfrom"]];
        }
        if (clinicalTrialsSearchRequest.lastupdatedto != nil) {
            [request setParameterValue:[NSString stringWithFormat:@"%@", clinicalTrialsSearchRequest.lastupdatedto] forKey:[NSString stringWithFormat:@"%@", @"lastupdatedto"]];
        }
    }
    
    return [request autorelease];
}

@end
