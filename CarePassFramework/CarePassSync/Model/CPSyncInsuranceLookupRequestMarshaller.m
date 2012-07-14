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

#import "CPSyncInsuranceLookupRequestMarshaller.h"

@implementation CPSyncInsuranceLookupRequestMarshaller

+(CarePassServiceRequest *)createRequest:(CPSyncInsuranceLookupRequest *)lookupRequest {
    return [CPSyncInsuranceLookupRequestMarshaller createRequest:lookupRequest andType:@"CARRIERS"];
}

+(CarePassServiceRequest *)createRequest:(CPSyncInsuranceLookupRequest *)lookupRequest andType:(NSString *)requestType {
    
    CarePassServiceRequest *request = [[CPSyncRequest alloc] init];
    
    if (lookupRequest != nil) {
        [request setDelegate:[lookupRequest delegate]];
        [request setCredentials:[lookupRequest credentials]];
        [request setRequestTag:[lookupRequest requestTag]];
    }
    
    if ([requestType isEqualToString:@"CARRIERS"]) {
        [request setEndpoint:[NSString stringWithFormat:@"%@/carriers",[lookupRequest requestEndpoint]]];
    } else if ([requestType isEqualToString:@"PLANS"]) {
        [request setEndpoint:[NSString stringWithFormat:@"%@/plans",[lookupRequest requestEndpoint]]];
    }
    
    return [request autorelease];
}

@end
