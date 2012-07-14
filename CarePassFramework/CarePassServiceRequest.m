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
@synthesize headers;
@synthesize endpoint;
@synthesize userAgent;
@synthesize credentials;
@synthesize urlConnection;
@synthesize requestTag;
@synthesize hostName;
@synthesize jsonString;


-(void)sign {
    
    if (credentials.apiKey != nil) {
        [self setParameterValue:credentials.apiKey forKey:@"apikey"];
    }
    
    if (credentials.clientId != nil) {
        if (credentials.accessToken == nil) {
            // todo: throw an error, since the oauth stuff should happen before now to establish the accessToken
            @throw [CarePassClientException exceptionWithMessage : @"Access token should be assigned before requests are made."];
        } else {
            // sign the request properly
            // Add the appropriate headers
            NSString *headerValue = [NSString stringWithFormat:@"Bearer %@", credentials.accessToken];
            [self setHeaderValue:headerValue forKey:@"Authorization"];
        }
    }
}

-(NSMutableURLRequest *)configureURLRequest {
    
    if (httpMethod == nil) {
        httpMethod = @"GET";
    }
    [self.urlRequest setHTTPMethod:httpMethod];
    [self setHeaderValue:self.userAgent forKey:@"User-Agent"];
    //[self.urlRequest setValue:self.userAgent forHTTPHeaderField:@"User-Agent"];
    [self assignHeaders];
    
    NSString * uri = [NSString stringWithFormat:@"%@?%@", self.endpoint, [self queryString]];
    NSURL *url = [NSURL URLWithString:uri];
    [urlRequest setURL:url];
    [urlRequest setValue:[url host] forHTTPHeaderField:@"Host"];
    
    return self.urlRequest;
}

-(void)assignHeaders {
    
    NSArray         *keys       = [[self headers] allKeys];
    NSArray         *sortedKeys = [keys sortedArrayUsingSelector:@selector(compare:)];
    for (int index = 0; index < [sortedKeys count]; index++) {
        NSString *key   = [sortedKeys objectAtIndex:index];
        NSString *value = (NSString *)[[self headers] valueForKey:key];
        
        [self.urlRequest setValue:value forHTTPHeaderField:key];
    }
}

-(NSString *)queryString {
    
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

-(void)setHostName:(NSString *)theHostName  {
    
    [hostName release];
    hostName = theHostName;
    [hostName retain];
}

-(NSString *)hostName {
    
    // hostName was explicitly set
    if (hostName != nil) {
        return hostName;
    }
    
    NSRange startOfHost = [self.endpoint rangeOfString:@"://"];
    
    return [self.endpoint substringFromIndex:(startOfHost.location + 3)];
}

-(CarePassURLRequest *)urlRequest {
    
    if (nil == urlRequest) {
        urlRequest = [[CarePassURLRequest alloc] init];
    }
    
    return urlRequest;
}

-(void)setUrlRequest:(CarePassURLRequest *)request {
    
    if (nil != urlRequest)
    {
        [urlRequest release];
        urlRequest = nil;
    }
    urlRequest = [request retain];
}

-(void)setParameterValue:(NSString *)theValue forKey:(NSString *)theKey {
    
    if (nil == parameters) {
        parameters = [[NSMutableDictionary alloc] initWithCapacity:1];
    }
    [parameters setValue:theValue forKey:theKey];
}

-(void)setHeaderValue:(NSString *)theValue forKey:(NSString *)theKey {
    
    if (nil == headers) {
        headers = [[NSMutableDictionary alloc] initWithCapacity:1];
    }
    [headers setValue:theValue forKey:theKey];
}

-(NSURL *)url {
    return nil;
}

-(void)setDelegate:(id<CarePassServiceRequestDelegate> )aDelegate {
    delegate = aDelegate;
}

-(id<CarePassServiceRequestDelegate> )delegate {
    return delegate;
}

-(void)dealloc {
    
    delegate = nil;
    [credentials release];
    [endpoint release];
    [urlRequest release];
    [parameters release];
    [headers release];
    [userAgent release];
    [urlConnection release];
    [requestTag release];
    [hostName release];
    [jsonString release];
    
    [super dealloc];
}

@end