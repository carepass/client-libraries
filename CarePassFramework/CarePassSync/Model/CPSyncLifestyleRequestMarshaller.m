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

#import "CPSyncLifestyleRequestMarshaller.h"

@implementation CPSyncLifestyleRequestMarshaller

+(CarePassServiceRequest *)createRequest:(CPSyncLifestyleRequest *)lifestyleRequest {
    return [CPSyncLifestyleRequestMarshaller createRequest:lifestyleRequest andType:@"GET"];
}

+(CarePassServiceRequest *)createRequest:(CPSyncLifestyleRequest *)lifestyleRequest andType:(NSString *)requestType {
    
    CarePassServiceRequest *request = [[CPSyncRequest alloc] init];
    
    if (lifestyleRequest != nil) {
        [request setDelegate:[lifestyleRequest delegate]];
        [request setCredentials:[lifestyleRequest credentials]];
        [request setRequestTag:[lifestyleRequest requestTag]];
        
        if ([lifestyleRequest lifestyleType] != nil) {
            [request setEndpoint:[NSString stringWithFormat:@"%@/%@", [lifestyleRequest requestEndpoint], [lifestyleRequest lifestyleType]]];
        } else {
            [request setEndpoint:[lifestyleRequest requestEndpoint]];
        }
        
        if ([requestType isEqualToString:@"GET"]) {
            [request setHttpMethod:@"GET"];
        } else if ([requestType isEqualToString:@"UPDATE"]) {
            [request setHttpMethod:@"PUT"];
            // JSONify the lifestyle data passed in
            NSString *temp = [lifestyleRequest serializedPutRequest];
            [request setJsonString:temp];
        } 
    }
    
    return [request autorelease];
}

@end
