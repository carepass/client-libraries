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

#import "ECCCostRequest.h"

@implementation ECCCostRequest

@synthesize code;
@synthesize zipcode;
@synthesize latitude;
@synthesize longitude;

-(id)init {
    if (self = [super init]) {
        
        self.requestEndpoint = @"https://api.carepass.com/ecc-directory-api";
        
        code = nil;
        zipcode = nil;
        latitude = nil;
        longitude = nil;
    }
    
    return self;
}

-(NSString *)description {
    NSMutableString *buffer = [[NSMutableString alloc] initWithCapacity:256];
    
    [buffer appendString:@"{"];
    [buffer appendString:[[[NSString alloc] initWithFormat:@"Code: %@,", code] autorelease]];
    [buffer appendString:[[[NSString alloc] initWithFormat:@"Zip code: %@,", zipcode] autorelease]];
    [buffer appendString:[[[NSString alloc] initWithFormat:@"Latitude: %@,", latitude] autorelease]];
    [buffer appendString:[[[NSString alloc] initWithFormat:@"Longitude: %@,", longitude] autorelease]];
    [buffer appendString:[super description]];
    [buffer appendString:@"}"];
    
    return [buffer autorelease];
}

-(void)dealloc {
    [code release];
    [zipcode release];
    [latitude release];
    [longitude release];
    
    [super dealloc];
}

@end

