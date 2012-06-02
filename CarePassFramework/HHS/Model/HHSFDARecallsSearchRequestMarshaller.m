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

#import "HHSFDARecallsSearchRequestMarshaller.h"

@implementation HHSFDARecallsSearchRequestMarshaller

+(CarePassServiceRequest *)createRequest:(HHSFDARecallsSearchRequest *)fdaRecallSearchRequest
{
    CarePassServiceRequest *request = [[HHSRequest alloc] init];
    
    [request setDelegate:[fdaRecallSearchRequest delegate]];
    [request setCredentials:[fdaRecallSearchRequest credentials]];
    [request setEndpoint:[fdaRecallSearchRequest requestEndpoint]];
    [request setRequestTag:[fdaRecallSearchRequest requestTag]];
    
    if (fdaRecallSearchRequest != nil) {
        if (fdaRecallSearchRequest.date != nil) {
            [request setParameterValue:[NSString stringWithFormat:@"%@", fdaRecallSearchRequest.date] forKey:[NSString stringWithFormat:@"%@", @"date"]];
        }
        if (fdaRecallSearchRequest.pastdays != nil) {
            [request setParameterValue:[NSString stringWithFormat:@"%@", fdaRecallSearchRequest.pastdays] forKey:[NSString stringWithFormat:@"%@", @"pastdays"]];
        }
        if (fdaRecallSearchRequest.product != nil) {
            [request setParameterValue:[NSString stringWithFormat:@"%@", fdaRecallSearchRequest.product] forKey:[NSString stringWithFormat:@"%@", @"product"]];
        }
    }
    
    return [request autorelease];
}

@end
