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

#import "CPSyncFitActivitiesRequestMarshaller.h"

@implementation CPSyncFitActivitiesRequestMarshaller

+(CarePassServiceRequest *)createRequest:(CPSyncFitActivitiesRequest *)activityRequest {
    return [CPSyncFitActivitiesRequestMarshaller createRequest:activityRequest andType:@"GET"];
}

+(CarePassServiceRequest *)createRequest:(CPSyncFitActivitiesRequest *)activityRequest andType:(NSString *)requestType {
    
    CarePassServiceRequest *request = [[CPSyncRequest alloc] init];
    
    if (activityRequest != nil) {
        [request setDelegate:[activityRequest delegate]];
        [request setCredentials:[activityRequest credentials]];
        [request setRequestTag:[activityRequest requestTag]];
        [request setEndpoint:[activityRequest requestEndpoint]];
    }
    
    if ([requestType isEqualToString:@"GET"]) {
        [request setHttpMethod:@"GET"];
        if ([activityRequest activityId] != nil) {
            [request setEndpoint:[NSString stringWithFormat:@"%@/%@", [activityRequest requestEndpoint], [activityRequest activityId]]];
        } else {
            [request setParameterValue:[activityRequest dateFrom] forKey:@"dateFrom"];
            [request setParameterValue:[activityRequest dateTo] forKey:@"dateTo"];
        }
    } else if ([requestType isEqualToString:@"UPDATE"]) {
        [request setHttpMethod:@"PUT"];
        [request setJsonString:[activityRequest serializedPutRequest]];
    } else if ([requestType isEqualToString:@"SAVE"]) {
        [request setHttpMethod:@"POST"];
        [request setJsonString:[activityRequest serializedPutRequest]];
    }
    
    return [request autorelease];
}

@end
