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

#import "HHSFDARecallsSearchResponseUnmarshaller.h"

@implementation HHSFDARecallsSearchResponseUnmarshaller

+(HHSFDARecallsSearchResponse *)unmarshall:(NSDictionary *)jsonObject {
    HHSFDARecallsSearchResponse *results = [[[HHSFDARecallsSearchResponse alloc] init] autorelease];
    
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
                    // no recalls for this drug - return empty response
                    return results;
                } else {
                    // error retrieving data - kick up an exception
                    NSString *errorMessage = [NSString stringWithFormat:@"error retrieving HHS FDA REcall data: %@ - %@", error, message];
                    [results setException:[CarePassServiceException exceptionWithMessage:errorMessage]];
                }
            } 
        } else {        // loop through the list values
            
            // pull out the values
            for (id recall in jsonObject) {
                HHSFDARecallsSearchResult *recallResult = [[HHSFDARecallsSearchResult alloc] init];
                recallResult.date = [recall objectForKey:@"date"];
                recallResult.reason = [recall objectForKey:@"reason"];
                recallResult.company = [recall objectForKey:@"company"];
                recallResult.brandName = [recall objectForKey:@"brandName"];
                recallResult.productDescription = [recall objectForKey:@"productDescription"];
                recallResult.companyReleaseLink = [recall objectForKey:@"companyReleaseLink"];
                recallResult.photosLink = [recall objectForKey:@"photosLink"];
                
                [[results searchResults] addObject:recallResult];        
                [recallResult release];
            }
        }
    }
    
    return results;
}

-(HHSFDARecallsSearchResponse *)response {
    if (nil == response) {
        response = [[HHSFDARecallsSearchResponse alloc] init];
    }
    return response;
}


-(void)dealloc {
    [response release];
    [super dealloc];
}


@end
