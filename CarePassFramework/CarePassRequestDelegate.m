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

#import "CarePassRequestDelegate.h"

@implementation CarePassRequestDelegate
@synthesize response;
@synthesize error;
@synthesize exception;

-(id)init
{
    self = [super init];
    if (self)
    {
        response  = nil;
        exception = nil;
        error     = nil;
    }
    return self;
}

-(bool)isFinishedOrFailed
{
    return (response != nil || error != nil || exception != nil);
}

-(void)request:(CarePassServiceRequest *)request didReceiveResponse:(NSURLResponse *)aResponse
{
//    AMZLogDebug(@"didReceiveResponse");
}

-(void)request:(CarePassServiceRequest *)request didCompleteWithResponse:(CarePassServiceResponse *)aResponse
{
//    AMZLogDebug(@"didCompleteWithResponse");
    [response release];
    response         = [aResponse retain];
    response.request = request;
}

-(void)request:(CarePassServiceRequest *)request didReceiveData:(NSData *)data
{
//    AMZLogDebug(@"didReceiveData");
}

-(void)request:(CarePassServiceRequest *)request didSendData:(NSInteger)bytesWritten totalBytesWritten:(NSInteger)totalBytesWritten totalBytesExpectedToWrite:(NSInteger)totalBytesExpectedToWrite
{
//    AMZLogDebug(@"didSendData");
}

-(void)request:(CarePassServiceRequest *)request didFailWithError:(NSError *)theError
{
//    AMZLogDebug(@"didFailWithError: %@", theError);
    [error release];
    error = [theError retain];
}

-(void)request:(CarePassServiceRequest *)request didFailWithServiceException:(NSException *)theException
{
//    AMZLogDebug(@"didFailWithServiceException");
    [exception release];
    exception = [theException retain];
}

-(void)dealloc
{
    [error release];
    [exception release];
    [response release];
    
    [super dealloc];
}

@end