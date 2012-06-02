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

#import "HHSDrugsNDCRequestMarshaller.h"

@implementation HHSDrugsNDCRequestMarshaller

+(CarePassServiceRequest *)createRequest:(HHSDrugsNDCRequest *)drugsNDCRequest {
    
    return [HHSDrugsNDCRequestMarshaller createRequest:drugsNDCRequest andType:@"DRUGS"];
}

+(CarePassServiceRequest *)createRequest:(HHSDrugsNDCRequest *)drugsNDCRequest andType:(NSString *)requestType {
    
    CarePassServiceRequest *request = [[HHSRequest alloc] init];
    
    [request setDelegate:[drugsNDCRequest delegate]];
    [request setCredentials:[drugsNDCRequest credentials]];
    [request setRequestTag:[drugsNDCRequest requestTag]];
    
    NSString *ndc2 = @"";
    NSString *ndc3 = @"";
    if (drugsNDCRequest != nil) {
        if (drugsNDCRequest.ndc2 != nil) {
            ndc2 = [NSString stringWithFormat:@"%@", drugsNDCRequest.ndc2];
        }
        if (drugsNDCRequest.ndc3 != nil) {
            ndc3 = [NSString stringWithFormat:@"%@", drugsNDCRequest.ndc3];
        }
    }
    
    if ([requestType isEqualToString:@"DRUGS"]) {
        [request setEndpoint:[NSString stringWithFormat:@"%@/%@",[drugsNDCRequest requestEndpoint], ndc2]];
    } else if ([requestType isEqualToString:@"PACKAGES"]) {
        [request setEndpoint:[NSString stringWithFormat:@"%@/%@/packages/%@",[drugsNDCRequest requestEndpoint], ndc2, ndc3]];
    } else if ([requestType isEqualToString:@"IMAGES"]) {
        [request setEndpoint:[NSString stringWithFormat:@"%@/%@/images",[drugsNDCRequest requestEndpoint], ndc2]];
    }
    
    return [request autorelease];
    
}

@end
