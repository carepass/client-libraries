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

#import "CPSyncFitLookupActivitiesRequestMarshaller.h"

@implementation CPSyncFitLookupActivitiesRequestMarshaller

+(CarePassServiceRequest *)createRequest:(CPSyncFitLookupActivitiesRequest *)lookupRequest {
    
    CarePassServiceRequest *request = [[CPSyncRequest alloc] init];
    
    if (lookupRequest != nil) {
        [request setDelegate:[lookupRequest delegate]];
        [request setCredentials:[lookupRequest credentials]];
        [request setRequestTag:[lookupRequest requestTag]];
        [request setEndpoint:[lookupRequest requestEndpoint]];
    }
    
    return [request autorelease];
}

@end
