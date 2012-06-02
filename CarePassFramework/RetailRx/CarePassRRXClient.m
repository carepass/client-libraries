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

#import "CarePassRRXClient.h"

@implementation CarePassRRXClient

-(id)initWithCredentials:(CarePassCredentials *)theCredentials
{
    if (self = [super initWithCredentials:theCredentials]) {
        // default, near useless endpoint
        self.endpoint = @"https://api.carepass.com/hhs-directory-api/";
    }
    return self;
}

#pragma mark Service Requests

-(RRXSearchResponse *)lowSearch:(RRXSearchRequest *)searchRequest {
    CarePassServiceRequest *request = [RRXSearchRequestMarshaller createRequest:searchRequest];
    
    return (RRXSearchResponse *)[self invoke:request rawRequest:searchRequest unmarshallerDelegate:[RRXSearchResponseUnmarshaller class]];
}

-(RRXSearchResponse *)compareSearch:(RRXSearchRequest *)searchRequest {
    CarePassServiceRequest *request = [RRXSearchRequestMarshaller createRequest:searchRequest andType:@"COMPARE"];
    
    return (RRXSearchResponse *)[self invoke:request rawRequest:searchRequest unmarshallerDelegate:[RRXSearchResponseUnmarshaller class]];
}

#pragma mark memory management

-(void)dealloc {
    [super dealloc];
}

@end
