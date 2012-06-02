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

#import "HHSARTSearchRequestMarshaller.h"

@implementation HHSARTSearchRequestMarshaller

+(CarePassServiceRequest *)createRequest:(HHSARTSearchRequest *)artSearchRequest {
    CarePassServiceRequest *request = [[HHSRequest alloc] init];
    
    [request setDelegate:[artSearchRequest delegate]];
    [request setCredentials:[artSearchRequest credentials]];
    [request setEndpoint:[artSearchRequest requestEndpoint]];
    [request setRequestTag:[artSearchRequest requestTag]];
    
    if (artSearchRequest != nil) {
        if (artSearchRequest.clinicName != nil) {
            [request setParameterValue:[NSString stringWithFormat:@"%@", artSearchRequest.clinicName] forKey:[NSString stringWithFormat:@"%@", @"clinicname"]];
        }
        if (artSearchRequest.city != nil) {
            [request setParameterValue:[NSString stringWithFormat:@"%@", artSearchRequest.city] forKey:[NSString stringWithFormat:@"%@", @"city"]];
        }
        if (artSearchRequest.state != nil) {
            [request setParameterValue:[NSString stringWithFormat:@"%@", artSearchRequest.state] forKey:[NSString stringWithFormat:@"%@", @"state"]];
        }
        if (artSearchRequest.medicalDirector != nil) {
            [request setParameterValue:[NSString stringWithFormat:@"%@", artSearchRequest.medicalDirector] forKey:[NSString stringWithFormat:@"%@", @"medicaldirector"]];
        }
        if (artSearchRequest.year != nil) {
            [request setParameterValue:[NSString stringWithFormat:@"%@", artSearchRequest.year] forKey:[NSString stringWithFormat:@"%@", @"year"]];
        }
        if (artSearchRequest.exactSearch) {
            [request setParameterValue:[NSString stringWithFormat:@"%@", @"exactMatch"] forKey:[NSString stringWithFormat:@"%@", @"exactmatch"]];
        }
    }
    
    return [request autorelease];
}

@end
