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

#import "HHSFDADrugsAlternativesResponseUnmarshaller.h"

@implementation HHSFDADrugsAlternativesResponseUnmarshaller

+(HHSResponse *)unmarshall:(NSDictionary *)jsonObject {
    HHSResponse *results;
    
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
                    NSString *errorMessage = [NSString stringWithFormat:@"error retrieving HHS FDA drug alternatives data: %@ - %@", error, message];
                    @throw [CarePassServiceException exceptionWithMessage:errorMessage];
                }
            } 
        } else {        // loop through the list values
            
            // alternatives!
            HHSFDADrugsAlternativesResponse *alternatives = [[[HHSFDADrugsAlternativesResponse alloc] init] autorelease];
            for (id result in jsonObject) {
                alternatives.alternatives = [HHSFDADrugsResponseUnmarshaller createAlternativesResult:result];
                results = (HHSResponse *)alternatives;
            }
        }
    }
    
    return results;
}

@end
