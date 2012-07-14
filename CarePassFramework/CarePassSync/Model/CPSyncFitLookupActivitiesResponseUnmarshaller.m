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

#import "CPSyncFitLookupActivitiesResponseUnmarshaller.h"

@implementation CPSyncFitLookupActivitiesResponseUnmarshaller

+(CPSyncFitLookupActivitiesResponse *)unmarshall:(NSDictionary *)jsonObject  {
    
    CPSyncFitLookupActivitiesResponse *results = [[[CPSyncFitLookupActivitiesResponse alloc] init] autorelease];
    
    if (jsonObject != nil && [jsonObject count] > 0) {
        NSString *error = [jsonObject objectForKey:@"message"];
        if (error != nil) {
            // error retrieving data - kick up an exception
            NSString *errorMessage = [NSString stringWithFormat:@"error retrieving activity lookup data: %@", error];
            [results setException:[CarePassServiceException exceptionWithMessage:errorMessage]];
        } else {
            for (id result in jsonObject) {
                [results.result addObject:result];
            }
        }
    }
    
    return results;
}

-(CPSyncFitLookupActivitiesResponse *)response {
    if (nil == response) {
        response = [[CPSyncFitLookupActivitiesResponse alloc] init];
    }
    return response;
}


-(void)dealloc {
    [response release];
    [super dealloc];
}

@end
