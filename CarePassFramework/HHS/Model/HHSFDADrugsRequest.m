//
//  HHSFDADrugsSearchRequest.m
//  CarePassFramework
//
//  Created by Julliette Ehlert on 5/25/12.
//  Copyright (c) 2012 __MyCompanyName__. All rights reserved.
//

#import "HHSFDADrugsRequest.h"

@implementation HHSFDADrugsRequest

@synthesize nda;

-(id)init {
    if (self = [super init]) {
        
        self.requestEndpoint = @"https://api.carepass.com/hhs-directory-api/applications";
        
        nda = nil;
    }
    
    return self;
}

-(NSString *)description {
    NSMutableString *buffer = [[NSMutableString alloc] initWithCapacity:256];
    
    [buffer appendString:@"{"];
    [buffer appendString:[[[NSString alloc] initWithFormat:@"NDA: %@,", nda] autorelease]];
    [buffer appendString:[super description]];
    [buffer appendString:@"}"];
    
    return [buffer autorelease];
}

-(void)dealloc {
    [nda release];
    
    [super dealloc];
}

@end
