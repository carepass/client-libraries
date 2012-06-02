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

#import "ECCCostRequestMarshaller.h"

@implementation ECCCostRequestMarshaller

+(CarePassServiceRequest *)createRequest:(ECCCostRequest *)costRequest {
    return [ECCCostRequestMarshaller createRequest:costRequest andType:@"MEDICAL"];    
}

+(CarePassServiceRequest *)createRequest:(ECCCostRequest *)costRequest andType:(NSString *)requestType {
    
    CarePassServiceRequest *request = [[ECCRequest alloc] init];
    
    if (costRequest != nil) {
        [request setDelegate:[costRequest delegate]];
        [request setCredentials:[costRequest credentials]];
        [request setRequestTag:[costRequest requestTag]];
        
        if ([requestType isEqualToString:@"MEDICAL"]) {
            [request setEndpoint:[NSString stringWithFormat:@"%@/med",[costRequest requestEndpoint]]];
        } else if ([requestType isEqualToString:@"DENTAL"]) {
            [request setEndpoint:[NSString stringWithFormat:@"%@/dental",[costRequest requestEndpoint]]];
        }
        
        NSString *code = @"";
        if (costRequest.code != nil){
            code = costRequest.code;
        }
        
        if (costRequest.zipcode != nil) {
            [request setEndpoint: [NSString stringWithFormat:@"%@/%@/zip/%@", [request endpoint], code, costRequest.zipcode]];
        } else if (costRequest.latitude != nil && costRequest.longitude != nil) {
            [request setEndpoint: [NSString stringWithFormat:@"%@/%@/%@,%@", [request endpoint], code, costRequest.latitude, costRequest.longitude]];
        }
    }
    
    return [request autorelease];
}

@end
