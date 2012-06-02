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

#import "HHSClinicalTrialsSearchRequest.h"

@implementation HHSClinicalTrialsSearchRequest

@synthesize drugname;
@synthesize status;
@synthesize page;
@synthesize condition;
@synthesize state1;
@synthesize state2;
@synthesize state3;
@synthesize country1;
@synthesize country2;
@synthesize country3;
@synthesize firstreceivedfrom;
@synthesize firstreceivedto;
@synthesize lastupdatedfrom;
@synthesize lastupdatedto;

-(id)init {
    if (self = [super init]) {
        
        self.requestEndpoint = @"https://api.carepass.com/hhs-directory-api/clinicaltrials/search";
        
        drugname = nil;
        status = nil;
        page = nil;
        condition = nil;
        state1 = nil;
        state2 = nil;
        state3 = nil;
        country1 = nil;
        country2 = nil;
        country3 = nil;
        firstreceivedfrom = nil;
        firstreceivedto = nil;
        lastupdatedfrom = nil;
        lastupdatedto = nil;
    }
    
    return self;
}

-(NSString *)description {
    NSMutableString *buffer = [[NSMutableString alloc] initWithCapacity:256];
    
    [buffer appendString:@"{"];
    [buffer appendString:[[[NSString alloc] initWithFormat:@"Drug name: %@,", drugname] autorelease]];
    [buffer appendString:[[[NSString alloc] initWithFormat:@"Status: %@,", status] autorelease]];
    [buffer appendString:[[[NSString alloc] initWithFormat:@"Page: %@,", page] autorelease]];
    [buffer appendString:[[[NSString alloc] initWithFormat:@"Condition: %@,", condition] autorelease]];
    [buffer appendString:[[[NSString alloc] initWithFormat:@"State 1: %@,", state1] autorelease]];
    [buffer appendString:[[[NSString alloc] initWithFormat:@"State 2: %@,", state2] autorelease]];
    [buffer appendString:[[[NSString alloc] initWithFormat:@"State 3: %@,", state3] autorelease]];
    [buffer appendString:[[[NSString alloc] initWithFormat:@"Country 1: %@,", country1] autorelease]];
    [buffer appendString:[[[NSString alloc] initWithFormat:@"Country 2: %@,", country2] autorelease]];
    [buffer appendString:[[[NSString alloc] initWithFormat:@"Country 3: %@,", country3] autorelease]];
    [buffer appendString:[[[NSString alloc] initWithFormat:@"First received from: %@,", firstreceivedfrom] autorelease]];
    [buffer appendString:[[[NSString alloc] initWithFormat:@"First received to: %@,", firstreceivedto] autorelease]];
    [buffer appendString:[[[NSString alloc] initWithFormat:@"Last updated from: %@,", lastupdatedfrom] autorelease]];
    [buffer appendString:[[[NSString alloc] initWithFormat:@"Last updated to: %@,", lastupdatedto] autorelease]];
    [buffer appendString:[super description]];
    [buffer appendString:@"}"];
    
    return [buffer autorelease];
}

-(void)dealloc {
    [drugname release];
    [status release];
    [page release];
    [condition release];
    [state1 release];
    [state2 release];
    [state3 release];
    [country1 release];
    [country2 release];
    [country3 release];
    [firstreceivedfrom release];
    [firstreceivedto release];
    [lastupdatedfrom release];
    [lastupdatedto release];
    
    [super dealloc];
}

@end
