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

#import "CarePassWebServiceClient.h"

@implementation CarePassWebServiceClient

@synthesize endpoint, maxRetries, timeout, userAgent, delay;

-(id)initWithCredentials:(CarePassCredentials *)theCredentials
{
    if (self = [self init]) {
        credentials = [theCredentials retain];
        maxRetries  = 5;
        timeout     = 240;
        delay       = 0.2;
        userAgent   = [[CarePassSDKUtil userAgentString] retain];
    }
    return self;
}

+(id)constructResponseFromRequest:(CarePassServiceRequest *)request
{
    NSString *requestClassName  = NSStringFromClass([request class]);
    NSString *responseClassName = [[requestClassName substringToIndex:[requestClassName length] - 7] stringByAppendingFormat:@"Response"];
    
    id       response = [[NSClassFromString(responseClassName) alloc] init];
    
    if (nil == response) {
        response = [CarePassServiceResponse new];
    }
    
    return [response autorelease];
}

-(CarePassServiceResponse *)invoke:(CarePassServiceRequest *)generatedRequest rawRequest:(CarePassServiceRequestConfig *)originalRequest unmarshallerDelegate:(Class)unmarshallerDelegate
{
    if (nil == generatedRequest) {
        @throw [CarePassClientException exceptionWithMessage : @"Request cannot be nil."];
    }
    
    [generatedRequest setUserAgent:self.userAgent];
    
    if (nil == generatedRequest.endpoint) {
        generatedRequest.endpoint = [self endpoint];
    }
    if (nil == generatedRequest.credentials) {
        [generatedRequest setCredentials:credentials];
    }
    
    
#ifdef GHUNIT_CLI
    if ( [generatedRequest.endpoint hasPrefix:@"https://"]) {
        generatedRequest.endpoint = [generatedRequest.endpoint stringByReplacingOccurrencesOfString:@"https://" withString:@"http://"];
    }
#endif
    
    [generatedRequest sign];
    NSMutableURLRequest *urlRequest = [generatedRequest configureURLRequest];
    
    CarePassServiceResponse *response = nil;
    int                   retries   = 0;
    while (retries < self.maxRetries) {
        
        response = [CarePassWebServiceClient constructResponseFromRequest:generatedRequest];
        [response setRequest:generatedRequest];
        response.unmarshallerDelegate = unmarshallerDelegate;
        
        [urlRequest setTimeoutInterval:self.timeout];

        // TODO: move this?
        // Setting this here and not the CarePassServiceRequest because S3 extends that class and sets its own Content-Type Header.
        [urlRequest addValue:@"application/x-www-form-urlencoded; charset=utf-8" forHTTPHeaderField:@"Content-Type"];
        
        NSURLConnection *urlConnection = [NSURLConnection connectionWithRequest:urlRequest delegate:response];
        originalRequest.urlConnection = urlConnection;
        
        if ([generatedRequest delegate] == nil) {
            NSTimer *timeoutTimer = [NSTimer scheduledTimerWithTimeInterval:self.timeout target:response selector:@selector(timeout) userInfo:nil repeats:NO];
            generatedRequest.delegate = [[[CarePassRequestDelegate alloc] init] autorelease];
            
            while (![(CarePassRequestDelegate *)(generatedRequest.delegate)isFinishedOrFailed]) {
                [[NSRunLoop currentRunLoop] runMode:NSDefaultRunLoopMode beforeDate:[NSDate distantFuture]];
            }
            
            if (response.didTimeout) {
                [urlConnection cancel];
            }
            else {
                [timeoutTimer invalidate];     //  invalidate also releases the object.
            }
            
            if ( [self shouldRetry:response]) {
                generatedRequest.delegate = nil;
                
                [self pauseExponentially:retries];
                retries++;
            }
            else {
                break;
            }
        }
        else {
            return nil;
        }
    }
    
    if (response.exception != nil) {
        @throw response.exception;
    }
    else {
        if (((CarePassRequestDelegate *)generatedRequest.delegate).exception != nil) {
            @throw((CarePassRequestDelegate *)generatedRequest.delegate).exception;
        }
        else if (((CarePassRequestDelegate *)generatedRequest.delegate).response != nil) {
            return ((CarePassRequestDelegate *)generatedRequest.delegate).response;
        }
        else {
            return nil; //TODO: Throw an exception here CarePassClientException
        }
    }
}

-(bool)shouldRetry:(CarePassServiceResponse *)response
{
    if (response.didTimeout ||
        response.httpStatusCode == 500 ||
        response.httpStatusCode == 503 ||
        (response.exception != nil &&
         response.exception.reason != nil &&
         [response.exception.reason rangeOfString:@"Throttling"].location != NSNotFound)) {
            return YES;
        }
    
    return NO;
}

-(bool)shouldRetry:(CarePassServiceResponse *)response exception:(NSException *)theException
{
    CarePassServiceException *exception = (CarePassServiceException *)theException;
    
    if (response.didTimeout || response.httpStatusCode == 500 || response.httpStatusCode == 503) {
        return YES;
    }
    else if (exception == nil) {
        return NO;
    }
    else if ( [exception.errorCode isEqualToString:@"ProvisionedThroughputExceededException"]) {
        return YES;
    }
    else if (exception.reason != nil && [exception.reason rangeOfString:@"Throttling"].location != NSNotFound) {
        return YES;
    }
    
    return NO;
}

-(void)pauseExponentially:(int)tryCount
{
    NSTimeInterval pause = self.delay * (pow(2, tryCount));
    
    [NSThread sleepForTimeInterval:pause];
}

-(void)setUserAgent:(NSString *)newUserAgent
{
    userAgent = [[NSString stringWithFormat:@"%@, %@", newUserAgent, [CarePassSDKUtil userAgentString]] retain];
}

-(void)dealloc
{
    [credentials release];
    [endpoint release];
    [userAgent release];
    
    [super dealloc];
}

@end
