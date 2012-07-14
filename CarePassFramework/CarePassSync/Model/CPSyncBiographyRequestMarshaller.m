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

#import "CPSyncBiographyRequestMarshaller.h"

@implementation CPSyncBiographyRequestMarshaller

+(CarePassServiceRequest *)createRequest:(CPSyncBiographyRequest *)bioRequest {
    return [CPSyncBiographyRequestMarshaller createRequest:bioRequest andType:@"GET"];
}

+(CarePassServiceRequest *)createRequest:(CPSyncBiographyRequest *)bioRequest andType:(NSString *)requestType {
    
    CarePassServiceRequest *request = [[CPSyncRequest alloc] init];
    
    if (bioRequest != nil) {
        [request setDelegate:[bioRequest delegate]];
        [request setCredentials:[bioRequest credentials]];
        [request setRequestTag:[bioRequest requestTag]];
    }
    
    if ([requestType isEqualToString:@"GET"]) {
        [request setEndpoint:[bioRequest requestEndpoint]];
    } else if ([requestType isEqualToString:@"SAVE"]) {
        [request setEndpoint:[bioRequest requestEndpoint]];
        [request setHttpMethod:@"PUT"];
    }
    
    return [request autorelease];
}

@end
