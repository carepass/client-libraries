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

#import "CPSyncIdentityResponseUnmarshaller.h"

@implementation CPSyncIdentityResponseUnmarshaller

+(CPSyncIdentityResponse *)unmarshall:(NSDictionary *)jsonObject  {
    
    CPSyncIdentityResponse *results = [[[CPSyncIdentityResponse alloc] init] autorelease];
    
    if (jsonObject != nil && [jsonObject count] > 0) {
        CPSyncIdentityResult *identityResult = [results result];
        
        identityResult.identityId = [jsonObject objectForKey:@"id"];
        identityResult.email = [jsonObject objectForKey:@"email"];
        identityResult.firstName = [jsonObject objectForKey:@"firstName"];
        identityResult.lastName = [jsonObject objectForKey:@"lastName"];
    }
    
    return results;
}

-(CPSyncIdentityResponse *)response {
    if (nil == response) {
        response = [[CPSyncIdentityResponse alloc] init];
    }
    return response;
}


-(void)dealloc {
    [response release];
    [super dealloc];
}

@end
