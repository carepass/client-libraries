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

#import "CarePassCredentials.h"

@implementation CarePassCredentials

@synthesize apiKey;
@synthesize clientId;
@synthesize accessToken;

-(id)initWithAPIKey:(NSString *)theAPIKey {
    if (self = [self init]) {
        self.apiKey = theAPIKey;
    }
    return self;
}

-(id)initWithAPIKey:(NSString *)theAPIKey withClientId:(NSString *)theClientId withAccessToken:(NSString *)theAccessToken {
    
    if (self = [self init]) {
        self.apiKey = theAPIKey;
        self.clientId = theClientId;
        self.accessToken = theAccessToken;
    }
    return self;
}

-(void)dealloc {
    [apiKey release];
    [clientId release];
    [accessToken release];
    [super dealloc];
}

@end

