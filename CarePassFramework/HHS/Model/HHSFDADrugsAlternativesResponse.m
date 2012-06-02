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

#import "HHSFDADrugsAlternativesResponse.h"

@implementation HHSFDADrugsAlternativesResponse

@synthesize alternatives;

-(void)setException:(CarePassServiceException *)theException {
    
    CarePassServiceException *newException = nil;
    
    //TODO - fill in exceptions
    //    if ([[theException errorCode] isEqualToString:@"NotFound"]) {
    //        newException = [[SNSNotFoundException alloc] initWithMessage:@""];
    //    }
    //    
    //    if ([[theException errorCode] isEqualToString:@"AuthorizationError"]) {
    //        newException = [[SNSAuthorizationErrorException alloc] initWithMessage:@""];
    //    }
    //    
    //    if ([[theException errorCode] isEqualToString:@"InternalError"]) {
    //        newException = [[SNSInternalErrorException alloc] initWithMessage:@""];
    //    }
    //    
    //    if ([[theException errorCode] isEqualToString:@"InvalidParameter"]) {
    //        newException = [[SNSInvalidParameterException alloc] initWithMessage:@""];
    //    }
    
    if (newException != nil) {
        [newException setPropertiesWithException:theException];
        [exception release];
        exception = newException;
    }
    else {
        [exception release];
        exception = [theException retain];
    }
}

-(NSString *)description {
    NSMutableString *buffer = [[NSMutableString alloc] initWithCapacity:256];
    
    [buffer appendString:@"{"];
    [buffer appendString:[[[NSString alloc] initWithFormat:@"Alternatives: %@,", [alternatives description]] autorelease]];
    [buffer appendString:[super description]];
    [buffer appendString:@"}"];
    
    return [buffer autorelease];
}

-(void)dealloc {

    [alternatives release];
    
    [super dealloc];
}

@end
