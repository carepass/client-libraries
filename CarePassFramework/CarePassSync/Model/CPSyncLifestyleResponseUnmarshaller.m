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

#import "CPSyncLifestyleResponseUnmarshaller.h"

@implementation CPSyncLifestyleResponseUnmarshaller

+(CPSyncLifestyleResponse *)unmarshall:(NSDictionary *)jsonObject  {
    
    CPSyncLifestyleResponse *results = [[[CPSyncLifestyleResponse alloc] init] autorelease];
    
    if (jsonObject != nil && [jsonObject count] > 0) {
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
        } else {
            NSMutableArray *lifestyleResult = [results results];
            NSMutableDictionary *attributes = [jsonObject objectForKey:@"lifestyleAttributes"];
            
            for (id result in attributes) {
                CPSyncLifestyleResult *lifestyle = [[CPSyncLifestyleResult alloc] init];
                
                lifestyle.lifestyleId = [result objectForKey:@"id"];
                lifestyle.type = [result objectForKey:@"type"];
                lifestyle.name = [result objectForKey:@"name"];
                lifestyle.imageUrl = [result objectForKey:@"imageUrl"];
                
                [lifestyleResult addObject:lifestyle];
                [lifestyle release];
            }
        }
    }
    
    return results;
}

-(CPSyncLifestyleResponse *)response {
    if (nil == response) {
        response = [[CPSyncLifestyleResponse alloc] init];
    }
    return response;
}


-(void)dealloc {
    [response release];
    [super dealloc];
}

@end
