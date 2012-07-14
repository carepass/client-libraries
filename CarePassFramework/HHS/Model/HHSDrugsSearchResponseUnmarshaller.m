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

#import "HHSDrugsSearchResponseUnmarshaller.h"

@implementation HHSDrugsSearchResponseUnmarshaller

+(HHSDrugsSearchResponse *)unmarshall:(NSDictionary *)jsonObject {
    HHSDrugsSearchResponse *results = [[[HHSDrugsSearchResponse alloc] init] autorelease];
    
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
                    NSString *errorMessage = [NSString stringWithFormat:@"error retrieving HHS Drugs data: %@ - %@", error, message];
                    [results setException:[CarePassServiceException exceptionWithMessage:errorMessage]];
                }
            } 
        } else { 
            // loop through the list values
            for (id drug in jsonObject) {
                HHSDrugsSearchResult *drugResult = [[HHSDrugsSearchResult alloc] init];
                drugResult.proprietaryName = [drug objectForKey:@"proprietaryName"];
                drugResult.nonProprietaryName = [drug objectForKey:@"nonProprietaryName"];
                drugResult.ndc = [drug objectForKey:@"ndc"];
                
                [[results searchResults] addObject:drugResult];        
                [drugResult release];
            }
        }
    }
    
    return results;
}

-(HHSDrugsSearchResponse *)response {
    if (nil == response) {
        response = [[HHSDrugsSearchResponse alloc] init];
    }
    return response;
}


-(void)dealloc {
    [response release];
    [super dealloc];
}

@end
