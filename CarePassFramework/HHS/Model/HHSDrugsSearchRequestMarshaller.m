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

#import "HHSDrugsSearchRequestMarshaller.h"

@implementation HHSDrugsSearchRequestMarshaller


+(CarePassServiceRequest *)createRequest:(HHSDrugsSearchRequest *)drugsSearchRequest {
    CarePassServiceRequest *request = [[HHSRequest alloc] init];
    
    [request setDelegate:[drugsSearchRequest delegate]];
    [request setCredentials:[drugsSearchRequest credentials]];
    [request setEndpoint:[drugsSearchRequest requestEndpoint]];
    [request setRequestTag:[drugsSearchRequest requestTag]];
    
    if (drugsSearchRequest != nil) {
        if (drugsSearchRequest.name != nil) {
            [request setParameterValue:[NSString stringWithFormat:@"%@", drugsSearchRequest.name] forKey:[NSString stringWithFormat:@"%@", @"name"]];
        }
    }
    
    return [request autorelease];
}

@end
