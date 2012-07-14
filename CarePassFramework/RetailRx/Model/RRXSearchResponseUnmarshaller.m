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

#import "RRXSearchResponseUnmarshaller.h"

@implementation RRXSearchResponseUnmarshaller

+(RRXSearchResponse *)unmarshall:(NSDictionary *)jsonObject  {
    
    RRXSearchResponse *results = [[[RRXSearchResponse alloc] init] autorelease];
    
    if (jsonObject != nil && [jsonObject count] > 0) {
        // if we return anything other than a JKArray, make sure it's not just a message of some sort
        if (![jsonObject isKindOfClass:NSClassFromString(@"JKArray")]) {
            
            NSString *errorCode = [jsonObject objectForKey:@"errorCode"];
            NSString *message = [jsonObject objectForKey:@"message"];
            id error = [jsonObject objectForKey:@"error"];
            // error can be a string or another array
            if ([error isKindOfClass:NSClassFromString(@"JKArray")]) {
                errorCode = [error objectForKey:@"code"];
                message = [error objectForKey:@"message"];
            } 
            
            if (errorCode != nil || error != nil || message != nil) {
                if ([errorCode isEqualToString:@"000"]) {
                    // no activities for this user - return empty response
                    return results;
                } else {
                    // error retrieving data - kick up an exception
                    NSString *errorMessage = [NSString stringWithFormat:@"error retrieving RRX data: %@ - %@", error, message];
                    [results setException:[CarePassServiceException exceptionWithMessage:errorMessage]];
                }
            }
        } else {
            
            RRXSearchResult *drugResult = [results searchResult];
            
            // loop through the list values
            for (id result in jsonObject) {
                drugResult.url = [result objectForKey:@"url"];
                drugResult.display = [result objectForKey:@"display"];
                drugResult.form = [result objectForKey:@"form"];
                drugResult.mobileUrl = [result objectForKey:@"mobileUrl"];
                
                for (id brandName in [result objectForKey:@"brand"]) {
                    [drugResult.brand addObject:brandName];
                }
                
                for (id genericName in [result objectForKey:@"generic"]) {
                    [drugResult.generic addObject:genericName];
                }
                
                drugResult.dosage = [result objectForKey:@"dosage"];
                drugResult.quantity = [result objectForKey:@"quantity"];
                
                for (id price in [result objectForKey:@"price"]) {
                    [drugResult.price addObject:price];
                }
                
                drugResult.manufacturer = [result objectForKey:@"manufacturer"];
            }
        }
    }
    
    return results;
}

-(RRXSearchResponse *)response {
    if (nil == response) {
        response = [[RRXSearchResponse alloc] init];
    }
    return response;
}


-(void)dealloc {
    [response release];
    [super dealloc];
}

@end
