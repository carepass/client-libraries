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

#import "RRXSearchRequestMarshaller.h"

@implementation RRXSearchRequestMarshaller

+(CarePassServiceRequest *)createRequest:(RRXSearchRequest *)rrxSearchRequest {
    return [RRXSearchRequestMarshaller createRequest:rrxSearchRequest andType:@"LOW"];
}

+(CarePassServiceRequest *)createRequest:(RRXSearchRequest *)rrxSearchRequest andType:(NSString *)requestType {
    
    CarePassServiceRequest *request = [[RRXRequest alloc] init];
    
    if (rrxSearchRequest != nil) {
        [request setDelegate:[rrxSearchRequest delegate]];
        [request setCredentials:[rrxSearchRequest credentials]];
        [request setRequestTag:[rrxSearchRequest requestTag]];
        
        if (rrxSearchRequest.name != nil) {
            [request setParameterValue:[NSString stringWithFormat:@"%@", rrxSearchRequest.name] forKey:[NSString stringWithFormat:@"%@", @"name"]];
        }
        if (rrxSearchRequest.form != nil) {
            [request setParameterValue:[NSString stringWithFormat:@"%@", rrxSearchRequest.form] forKey:[NSString stringWithFormat:@"%@", @"form"]];
        }
        if (rrxSearchRequest.dosage != nil) {
            [request setParameterValue:[NSString stringWithFormat:@"%@", rrxSearchRequest.dosage] forKey:[NSString stringWithFormat:@"%@", @"dosage"]];
        }
        if (rrxSearchRequest.quantity != nil) {
            [request setParameterValue:[NSString stringWithFormat:@"%@", rrxSearchRequest.quantity] forKey:[NSString stringWithFormat:@"%@", @"quantity"]];
        }
        if (rrxSearchRequest.manufacturer != nil) {
            [request setParameterValue:[NSString stringWithFormat:@"%@", rrxSearchRequest.manufacturer] forKey:[NSString stringWithFormat:@"%@", @"manufacturer"]];
        }
        if (rrxSearchRequest.ndc != nil) {
            [request setParameterValue:[NSString stringWithFormat:@"%@", rrxSearchRequest.ndc] forKey:[NSString stringWithFormat:@"%@", @"ndc"]];
        }
    }
    
    if ([requestType isEqualToString:@"LOW"]) {
        [request setEndpoint:[NSString stringWithFormat:@"%@/low",[rrxSearchRequest requestEndpoint]]];
    } else if ([requestType isEqualToString:@"COMPARE"]) {
        [request setEndpoint:[NSString stringWithFormat:@"%@/compare",[rrxSearchRequest requestEndpoint]]];
    }
    
    return [request autorelease];
}

@end