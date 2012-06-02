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

#import "HHSFDADrugsRequestMarshaller.h"

@implementation HHSFDADrugsRequestMarshaller

+(CarePassServiceRequest *)createRequest:(HHSFDADrugsRequest *)fdaDrugsRequest {
    
    return [HHSFDADrugsRequestMarshaller createRequest:fdaDrugsRequest andType:@"DRUGS"];
}

+(CarePassServiceRequest *)createRequest:(HHSFDADrugsRequest *)fdaDrugsRequest andType:(NSString *)requestType {
    
    CarePassServiceRequest *request = [[HHSRequest alloc] init];
    
    [request setDelegate:[fdaDrugsRequest delegate]];
    [request setCredentials:[fdaDrugsRequest credentials]];
    [request setRequestTag:[fdaDrugsRequest requestTag]];
    
    NSString *nda = @"";
    if (fdaDrugsRequest != nil) {
        if (fdaDrugsRequest.nda != nil) {
            nda = [NSString stringWithFormat:@"%@", fdaDrugsRequest.nda];
        }
    }
    
    if ([requestType isEqualToString:@"DRUGS"]) {
        [request setEndpoint:[NSString stringWithFormat:@"%@/%@",[fdaDrugsRequest requestEndpoint], nda]];
    } else if ([requestType isEqualToString:@"RESOURCES"]) {
        [request setEndpoint:[NSString stringWithFormat:@"%@/%@/drugsresources",[fdaDrugsRequest requestEndpoint], nda]];
    } else if ([requestType isEqualToString:@"ALTERNATIVES"]) {
        [request setEndpoint:[NSString stringWithFormat:@"%@/%@/alternatives",[fdaDrugsRequest requestEndpoint], nda]];
    } else if ([requestType isEqualToString:@"DOCUMENTS"]) {
        [request setEndpoint:[NSString stringWithFormat:@"%@/%@/documents",[fdaDrugsRequest requestEndpoint], nda]];
    }
    
    return [request autorelease];
    
}

@end
