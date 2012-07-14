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

#import "CarePassServiceResponse.h"

@implementation CarePassServiceResponse

@synthesize httpStatusCode;
@synthesize isFinishedLoading;
@synthesize request;
@synthesize requestId;
@synthesize didTimeout;
@synthesize unmarshallerDelegate;
@synthesize processingTime;

-(id)init {
    self = [super init];
    if (self != nil) {
        isFinishedLoading = NO;
        didTimeout        = NO;
        exception         = nil;
    }
    
    return self;
}

-(NSData *)body {
    return [NSData dataWithData:body];
}

// TODO: Make the body property readonly when all operations are converted to the delegate technique.
-(void)setBody:(NSData *)data {
    if (nil != body) {
        [body setLength:0];
    }
    body = [[NSMutableData dataWithData:data] retain];
    [self processBody];
}

// Override this to perform processing on the body.
-(void)processBody {
    // Subclasses can use this to build object data from the response, for example
    // parsing JSON content.
}

-(void)postProcess {
}

-(void)timeout
{
    if (!isFinishedLoading && !exception) {
        didTimeout = YES;
        exception  = [[CarePassClientException exceptionWithMessage:@"Request timed out."] retain];
        
        if ([(NSObject *)request.delegate respondsToSelector:@selector(request:didFailWithServiceException:)]) {
            [request.delegate request:request didFailWithServiceException:exception];
        }
    }
}

-(NSException *)exception {
    return exception;
}

#pragma mark NSURLConnection delegate methods

-(void)connection:(NSURLConnection *)connection didReceiveResponse:(NSURLResponse *)response {
    NSHTTPURLResponse *httpResponse = (NSHTTPURLResponse *)response;
    
    self.httpStatusCode = [httpResponse statusCode];
    
    [body setLength:0];
    
    if ([(NSObject *)self.request.delegate respondsToSelector:@selector(request:didReceiveResponse:)]) {
        [self.request.delegate request:self.request didReceiveResponse:response];
    }
}

-(void)connection:(NSURLConnection *)connection didReceiveData:(NSData *)data {
    if (nil == body) {
        body = [[NSMutableData data] retain];
    }
    
    [body appendData:data];
    
    if ([(NSObject *)self.request.delegate respondsToSelector:@selector(request:didReceiveData:)]) {
        [self.request.delegate request:self.request didReceiveData:data];
    }
}

-(void)connectionDidFinishLoading:(NSURLConnection *)connection {
    NSDate *startDate = [NSDate date];
    
    isFinishedLoading = YES;
    
    NSString *jsonString = [[[NSString alloc] initWithData:body encoding:NSUTF8StringEncoding] autorelease];
    
    //    if (self.httpStatusCode == 400) {
    //        NSMutableDictionary   *jsonObject;
    //        if ([jsonString length] != 0) {
    //            jsonObject = [jsonString objectFromJSONString];
    //        }
    //
    //        @throw [CarePassServiceException exceptionWithMessage:[NSString stringWithFormat:@"Validation error: %@", [jsonObject objectForKey:@"message"]] withErrorCode : @"ValidationError" withStatusCode : 400 withRequestId : self.requestId];
    //    } 
    //    else {
    NSLog(@"jsonString: %@", jsonString);
    
    NSMutableDictionary   *jsonObject;
    if ([jsonString length] == 0) {
        jsonObject = nil;
    } else {
        jsonObject = [jsonString objectFromJSONString];
    }
    CarePassServiceResponse *response = [[unmarshallerDelegate performSelector:@selector(unmarshall:) withObject:jsonObject] retain];
    
    if (response.exception) {
        NSException *exceptionFound = [[response.exception copy] autorelease];
        [response release];
        if ([(NSObject *)request.delegate respondsToSelector:@selector(request:didFailWithServiceException:)]) {
            [request.delegate request:request didFailWithServiceException:(CarePassServiceException *)exceptionFound];
            return;
        }
        else {
            @throw exceptionFound;
        }
    }
    
    [response postProcess];
    processingTime          = fabs([startDate timeIntervalSinceNow]);
    response.processingTime = processingTime;    
    
    if ([(NSObject *)request.delegate respondsToSelector:@selector(request:didCompleteWithResponse:)]) {
        [request.delegate request:request didCompleteWithResponse:response];
    }
    
    [response release];
    //    }
    
}

-(void)connection:(NSURLConnection *)connection didFailWithError:(NSError *)error {
    
    if ([(NSObject *)self.request.delegate respondsToSelector:@selector(request:didFailWithError:)]) {
        [self.request.delegate request:self.request didFailWithError:error];
    }
}

-(void)connection:(NSURLConnection *)connection didSendBodyData:(NSInteger)bytesWritten totalBytesWritten:(NSInteger)totalBytesWritten totalBytesExpectedToWrite:(NSInteger)totalBytesExpectedToWrite {
    if ([(NSObject *)self.request.delegate respondsToSelector:@selector(request:didSendData:totalBytesWritten:totalBytesExpectedToWrite:)]) {
        [self.request.delegate request:self.request
                           didSendData:bytesWritten
                     totalBytesWritten:totalBytesWritten
             totalBytesExpectedToWrite:totalBytesExpectedToWrite];
    }
}

//TODO: needed?
-(NSURLRequest *)connection:(NSURLConnection *)connection willSendRequest:(NSURLRequest *)proposedRequest redirectResponse:(NSURLResponse *)redirectResponse
{
    return proposedRequest;
}

-(NSCachedURLResponse *)connection:(NSURLConnection *)connection willCacheResponse:(NSCachedURLResponse *)cachedResponse
{
    return nil;
}

// FOR TESTING ONLY - disables SSL cert checks
//- (BOOL)connection:(NSURLConnection *)connection canAuthenticateAgainstProtectionSpace:(NSURLProtectionSpace *)protectionSpace {
//    return [protectionSpace.authenticationMethod isEqualToString:NSURLAuthenticationMethodServerTrust];
//}

//- (void)connection:(NSURLConnection *)connection didReceiveAuthenticationChallenge:(NSURLAuthenticationChallenge *)challenge {
//    [challenge.sender useCredential:[NSURLCredential credentialForTrust:challenge.protectionSpace.serverTrust] forAuthenticationChallenge:challenge];
//    
//    [challenge.sender continueWithoutCredentialForAuthenticationChallenge:challenge];
//}

#pragma mark memory management

-(void)dealloc
{
    [requestId release];
    [body release];
    [exception release];
    [request release];
    
    [super dealloc];
}

-(NSString *)description
{
    NSMutableString *buffer = [[NSMutableString alloc] initWithCapacity:256];
    
    [buffer appendString:@"{"];
    [buffer appendString:[[[NSString alloc] initWithFormat:@"requestId: %@", requestId] autorelease]];
    [buffer appendString:@"}"];
    
    return [buffer autorelease];
}

@end
