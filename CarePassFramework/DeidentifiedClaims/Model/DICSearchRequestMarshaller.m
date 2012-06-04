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

#import "DICSearchRequestMarshaller.h"

@implementation DICSearchRequestMarshaller

+(CarePassServiceRequest *)createRequest:(DICSearchRequest *)searchRequest {
    CarePassServiceRequest *request = [[DICRequest alloc] init];
    
    if (searchRequest != nil) {
        [request setDelegate:[searchRequest delegate]];
        [request setEndpoint:[searchRequest requestEndpoint]];
        [request setCredentials:[searchRequest credentials]];
        [request setRequestTag:[searchRequest requestTag]];
        
        if (searchRequest.ndc != nil) {
            [request setParameterValue:[NSString stringWithFormat:@"%@", searchRequest.ndc] forKey:[NSString stringWithFormat:@"%@", @"ndc"]];
        }
        if (searchRequest.gender != nil) {
            [request setParameterValue:[NSString stringWithFormat:@"%@", searchRequest.gender] forKey:[NSString stringWithFormat:@"%@", @"gender"]];
        }
        if (searchRequest.birthYearFrom != nil) {
            [request setParameterValue:[NSString stringWithFormat:@"%@", searchRequest.birthYearFrom] forKey:[NSString stringWithFormat:@"%@", @"birthyearfrom"]];
        }
        if (searchRequest.birthYearTo != nil) {
            [request setParameterValue:[NSString stringWithFormat:@"%@", searchRequest.birthYearTo] forKey:[NSString stringWithFormat:@"%@", @"birthyearto"]];
        }
        if (searchRequest.from != nil) {
            [request setParameterValue:[NSString stringWithFormat:@"%@", searchRequest.from] forKey:[NSString stringWithFormat:@"%@", @"from"]];
        }
        if (searchRequest.to != nil) {
            [request setParameterValue:[NSString stringWithFormat:@"%@", searchRequest.to] forKey:[NSString stringWithFormat:@"%@", @"to"]];
        }
        if (searchRequest.page != nil) {
            [request setParameterValue:[NSString stringWithFormat:@"%@", searchRequest.page] forKey:[NSString stringWithFormat:@"%@", @"page"]];
        }
    }
    
    return [request autorelease];
}

@end