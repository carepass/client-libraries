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

#import "DICSearchRequest.h"

@implementation DICSearchRequest

@synthesize ndc;
@synthesize gender;
@synthesize birthYearFrom;
@synthesize birthYearTo;
@synthesize from;
@synthesize to;
@synthesize page;

-(id)init {
    if (self = [super init]) {
        
        self.requestEndpoint = @"https://api.carepass.com/claims-directory-api/claims/search";
        
        ndc = nil;
        gender = nil;
        birthYearFrom = nil;
        birthYearTo = nil;
        from = nil;
        to = nil;
        page = nil;
    }
    
    return self;
}

-(NSString *)description {
    NSMutableString *buffer = [[NSMutableString alloc] initWithCapacity:256];
    
    [buffer appendString:@"{"];
    [buffer appendString:[[[NSString alloc] initWithFormat:@"NDC: %@,", ndc] autorelease]];
    [buffer appendString:[[[NSString alloc] initWithFormat:@"Gender: %@,", gender] autorelease]];
    [buffer appendString:[[[NSString alloc] initWithFormat:@"Birth Year From: %@,", birthYearFrom] autorelease]];
    [buffer appendString:[[[NSString alloc] initWithFormat:@"Birth Year To: %@,", birthYearTo] autorelease]];
    [buffer appendString:[[[NSString alloc] initWithFormat:@"From: %@,", from] autorelease]];
    [buffer appendString:[[[NSString alloc] initWithFormat:@"To: %@,", to] autorelease]];
    [buffer appendString:[[[NSString alloc] initWithFormat:@"Page: %@,", page] autorelease]];
    [buffer appendString:[super description]];
    [buffer appendString:@"}"];
    
    return [buffer autorelease];
}

-(void)dealloc {
    [ndc release];
    [gender release];
    [birthYearFrom release];
    [birthYearTo release];
    [from release];
    [to release];
    [page release];
    
    [super dealloc];
}

@end