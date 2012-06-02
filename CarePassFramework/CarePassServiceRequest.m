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

#import "CarePassServiceRequest.h"

@implementation CarePassServiceRequest

@synthesize httpMethod;
@synthesize parameters;
@synthesize endpoint;
@synthesize userAgent;
@synthesize credentials;
@synthesize urlConnection;
@synthesize requestTag;
@synthesize serviceName;
@synthesize hostName;


-(void)sign
{
    [self setParameterValue:credentials.apiKey forKey:@"apikey"];
//    [self setParameterValue:@"2"                                        forKey:@"SignatureVersion"];
//    [self setParameterValue:[NSDate ISO8061FormattedCurrentTimestamp]   forKey:@"Timestamp"];
//    [self setParameterValue:@"HmacSHA256"                               forKey:@"SignatureMethod"];
    
//    NSData   *dataToSign = [[CarePassAuthUtils getV2StringToSign:[NSURL URLWithString:self.endpoint] request:self] dataUsingEncoding:NSUTF8StringEncoding];
//    NSString *signature  = [CarePassAuthUtils HMACSign:dataToSign withKey:credentials.secretKey usingAlgorithm:kCCHmacAlgSHA256];
//    
//    [self setParameterValue:signature forKey:@"Signature"];
}

-(NSMutableURLRequest *)configureURLRequest
{
    if (self.credentials != nil && self.credentials.securityToken != nil) {
        [self setParameterValue:self.credentials.securityToken forKey:@"SecurityToken"];
    }
    
    [self.urlRequest setHTTPMethod:@"GET"];
//    [self.urlRequest setHTTPBody:[[self queryString] dataUsingEncoding:NSUTF8StringEncoding]];
    [self.urlRequest setValue:self.userAgent forHTTPHeaderField:@"User-Agent"];
    
    NSString * uri = [NSString stringWithFormat:@"%@?%@", self.endpoint, [self queryString]];
    NSURL *url = [NSURL URLWithString:uri];
    [urlRequest setURL:url];
    [urlRequest setValue:[url host] forHTTPHeaderField:@"Host"];
    
    return self.urlRequest;
}

-(NSString *)queryString
{
    NSMutableString *buffer = [[NSMutableString alloc] initWithCapacity:256];
    
    NSArray         *keys       = [[self parameters] allKeys];
    NSArray         *sortedKeys = [keys sortedArrayUsingSelector:@selector(compare:)];
    for (int index = 0; index < [sortedKeys count]; index++) {
        NSString *key   = [sortedKeys objectAtIndex:index];
        NSString *value = (NSString *)[[self parameters] valueForKey:key];
        
        [buffer appendString:[CarePassSDKUtil urlEncode:key]];
        [buffer appendString:@"="];
        [buffer appendString:[CarePassSDKUtil urlEncode:value]];
        
        if (index < [sortedKeys count] - 1) {
            [buffer appendString:@"&"];
        }
    }
    
    return [buffer autorelease];
}

-(void)setHostName:(NSString *)theHostName 
{
    [hostName release];
    hostName = theHostName;
    [hostName retain];
}

-(NSString *)hostName
{
    // hostName was explicitly set
    if (hostName != nil) {
        return hostName;
    }
    
    NSRange startOfHost = [self.endpoint rangeOfString:@"://"];
    
    return [self.endpoint substringFromIndex:(startOfHost.location + 3)];
}

-(void)setServiceName:(NSString *)theServiceName
{
    [serviceName release];
    serviceName = theServiceName;
    [serviceName retain];
}

//TODO: this needs to be fleshed out to handle all cases
-(NSString *)serviceName
{
    // serviceName was explicitly set
    if (serviceName != nil) {
        return serviceName;
    }
    return nil;
}

-(CarePassURLRequest *)urlRequest
{
    if (nil == urlRequest) {
        urlRequest = [[CarePassURLRequest alloc] init];
    }
    
    return urlRequest;
}

-(void)setUrlRequest:(CarePassURLRequest *)request
{
    if (nil != urlRequest)
    {
        [urlRequest release];
        urlRequest = nil;
    }
    urlRequest = [request retain];
}

-(void)setParameterValue:(NSString *)theValue forKey:(NSString *)theKey
{
    if (nil == parameters) {
        parameters = [[NSMutableDictionary alloc] initWithCapacity:1];
    }
    [parameters setValue:theValue forKey:theKey];
}

-(NSURL *)url
{
    return nil;
}

-(void)setDelegate:(id<CarePassServiceRequestDelegate> )aDelegate
{
    delegate = aDelegate;
}

-(id<CarePassServiceRequestDelegate> )delegate
{
    return delegate;
}

-(void)dealloc
{
    delegate = nil;
    [credentials release];
    [endpoint release];
    [urlRequest release];
    [parameters release];
    [userAgent release];
    [urlConnection release];
    [requestTag release];
    [serviceName release];
    [hostName release];
    
    [super dealloc];
}

@end