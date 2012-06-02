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

#import "HHSClinicalTrialsNCTRequestMarshaller.h"

@implementation HHSClinicalTrialsNCTRequestMarshaller

+(CarePassServiceRequest *)createRequest:(HHSClinicalTrialsNCTRequest *)clinicalTrialsNCTRequest {
    
    CarePassServiceRequest *request = [[HHSRequest alloc] init];
    
    [request setDelegate:[clinicalTrialsNCTRequest delegate]];
    [request setCredentials:[clinicalTrialsNCTRequest credentials]];
    [request setRequestTag:[clinicalTrialsNCTRequest requestTag]];
    
    if (clinicalTrialsNCTRequest != nil) {
        if (clinicalTrialsNCTRequest.nctid != nil) {
            [request setEndpoint:[NSString stringWithFormat:@"%@/%@",[clinicalTrialsNCTRequest requestEndpoint], clinicalTrialsNCTRequest.nctid]];
        }
    }
    
    return [request autorelease];
}

@end
