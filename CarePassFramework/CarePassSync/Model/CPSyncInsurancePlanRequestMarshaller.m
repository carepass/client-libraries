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

#import "CPSyncInsurancePlanRequestMarshaller.h"

@implementation CPSyncInsurancePlanRequestMarshaller

+(CarePassServiceRequest *)createRequest:(CPSyncInsurancePlanRequest *)planRequest {
    return [CPSyncInsurancePlanRequestMarshaller createRequest:planRequest andType:@"GET"];
}

+(CarePassServiceRequest *)createRequest:(CPSyncInsurancePlanRequest *)planRequest andType:(NSString *)requestType {
    
    CarePassServiceRequest *request = [[CPSyncRequest alloc] init];
    
    if (planRequest != nil) {
        [request setDelegate:[planRequest delegate]];
        [request setCredentials:[planRequest credentials]];
        [request setRequestTag:[planRequest requestTag]];
        [request setEndpoint:[planRequest requestEndpoint]];
    }
    
    if ([requestType isEqualToString:@"GET"]) {
        [request setHttpMethod:@"GET"];
        if ([planRequest planId] != nil) {
            [request setEndpoint:[NSString stringWithFormat:@"%@/%@", [planRequest requestEndpoint], [planRequest planId]]];
        }
    } else if ([requestType isEqualToString:@"UPDATE"]) {
        [request setHttpMethod:@"PUT"];
        [request setJsonString:[planRequest serializedPutRequest]];
    } else if ([requestType isEqualToString:@"SAVE"]) {
        [request setHttpMethod:@"POST"];
        [request setJsonString:[planRequest serializedPutRequest]];
    }
    
    return [request autorelease];
}

@end
