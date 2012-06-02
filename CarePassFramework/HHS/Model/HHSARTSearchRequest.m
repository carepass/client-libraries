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

#import "HHSARTSearchRequest.h"

@implementation HHSARTSearchRequest

@synthesize clinicName;
@synthesize city;
@synthesize state;
@synthesize medicalDirector;
@synthesize year;
@synthesize exactSearch;

-(id)init
{
    if (self = [super init]) {
        
        self.requestEndpoint = @"https://api.carepass.com/hhs-directory-api/art/search";

        clinicName = nil;
        city = nil;
        state = nil;
        medicalDirector = nil;
        year = nil;
        exactSearch = false;
    }
    
    return self;
}

-(NSString *)description
{
    NSMutableString *buffer = [[NSMutableString alloc] initWithCapacity:256];
    
    [buffer appendString:@"{"];
    [buffer appendString:[[[NSString alloc] initWithFormat:@"ClinicName: %@,", clinicName] autorelease]];
    [buffer appendString:[[[NSString alloc] initWithFormat:@"City: %@,", city] autorelease]];
    [buffer appendString:[[[NSString alloc] initWithFormat:@"State: %@,", state] autorelease]];
    [buffer appendString:[[[NSString alloc] initWithFormat:@"Medical Director: %@,", medicalDirector] autorelease]];
    [buffer appendString:[[[NSString alloc] initWithFormat:@"Year: %@,", year] autorelease]];
    [buffer appendString:[[[NSString alloc] initWithFormat:@"Exact Search: %@,", exactSearch] autorelease]];
    [buffer appendString:[super description]];
    [buffer appendString:@"}"];
    
    return [buffer autorelease];
}

-(void)dealloc
{
    [clinicName release];
    [city release];
    [state release];
    [medicalDirector release];
    [year release];
    
    [super dealloc];
}

@end
