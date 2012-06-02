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

#import "CarePassServiceException.h"

@implementation CarePassServiceException

@synthesize requestId, errorCode, serviceName, statusCode;

+(CarePassServiceException *)exceptionWithMessage:(NSString *)theMessage
{
    CarePassServiceException *e = (CarePassServiceException *)[CarePassServiceException exceptionWithName:@"CarePassServiceException" reason:theMessage userInfo:nil];
    
    e.message = theMessage;
    return e;
}

+(CarePassServiceException *)exceptionWithStatusCode:(NSInteger)theStatusCode
{
    CarePassServiceException *e = (CarePassServiceException *)[CarePassServiceException exceptionWithName:@"CarePassServiceException" reason:nil userInfo:nil];
    
    e.statusCode = theStatusCode;
    return e;
}

+(CarePassServiceException *)exceptionWithMessage:(NSString *)theMessage
                                    withErrorCode:(NSString *)theErrorCode
                                   withStatusCode:(NSInteger)theStatusCode
                                    withRequestId:(NSString *)theRequestId
{
    CarePassServiceException *e = (CarePassServiceException *)[CarePassServiceException exceptionWithName:@"CarePassServiceException" reason:theMessage userInfo:nil];
    
    e.errorCode  = theErrorCode;
    e.statusCode = theStatusCode;
    e.requestId  = theRequestId;
    return e;
}

-(void)setPropertiesWithException:(CarePassServiceException *)theException
{
    self.errorCode   = theException.errorCode;
    self.message     = theException.message;
    self.requestId   = theException.requestId;
    self.statusCode  = theException.statusCode;
    self.serviceName = theException.serviceName;
}

-(id)initWithMessage:(NSString *)theMessage
{
    self = [super initWithMessage:theMessage];
    if (self != nil) {
    }
    
    return self;
}

-(NSString *)description
{
    return [[[NSString alloc] initWithFormat:@"%@ { RequestId:%@, ErrorCode:%@, Message:%@ }", NSStringFromClass([self class]), requestId, errorCode, message] autorelease];
}

-(NSMutableDictionary *)additionalFields
{
    if (nil == additionalFields) {
        additionalFields = [[NSMutableDictionary alloc] initWithCapacity:1];
    }
    return additionalFields;
}

-(void)dealloc
{
    [requestId release];
    [errorCode release];
    [serviceName release];
    [additionalFields release];
    
    [super dealloc];
}

@end
