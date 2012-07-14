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

#import "ECCCategoryResponseUnmarshaller.h"

@implementation ECCCategoryResponseUnmarshaller

+(ECCCategoryResponse *)unmarshall:(NSDictionary *)jsonObject  {
    
    ECCCategoryResponse *results = [[[ECCCategoryResponse alloc] init] autorelease];
    
    if (jsonObject != nil && [jsonObject count] > 0) {
        // if we return anything other than a JKArray, make sure it's not just a message of some sort
        if (![jsonObject isKindOfClass:NSClassFromString(@"JKArray")]) {
            NSString *errorCode = [jsonObject objectForKey:@"errorCode"];
            NSString *error = [jsonObject objectForKey:@"error"];
            NSString *message = [jsonObject objectForKey:@"message"];
            if (errorCode != nil || error != nil || message != nil) {
                if ([errorCode isEqualToString:@"000"]) {
                    // no activities for this user - return empty response
                    return results;
                } else {
                    // error retrieving data - kick up an exception
                    NSString *errorMessage = [NSString stringWithFormat:@"error retrieving lifestyle data: %@%@", error, message];
                    [results setException:[CarePassServiceException exceptionWithMessage:errorMessage]];
                }
            }
        } else {
            
            // loop through the list values
            for (id result in jsonObject) {
                [results.categories addObject:result];
            }
        }
    }
    
    return results;
}

-(ECCCategoryResponse *)response {
    if (nil == response) {
        response = [[ECCCategoryResponse alloc] init];
    }
    return response;
}


-(void)dealloc {
    [response release];
    [super dealloc];
}

@end
