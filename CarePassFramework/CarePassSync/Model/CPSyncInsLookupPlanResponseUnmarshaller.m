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

#import "CPSyncInsLookupPlanResponseUnmarshaller.h"

@implementation CPSyncInsLookupPlanResponseUnmarshaller
+(CPSyncInsLookupPlanResponse *)unmarshall:(NSDictionary *)jsonObject  {
    
    CPSyncInsLookupPlanResponse *results = [[[CPSyncInsLookupPlanResponse alloc] init] autorelease];
    
    if (jsonObject != nil && [jsonObject count] > 0) {
        for (id result in jsonObject) {
            NSString *carrierId = [result objectForKey:@"carrierId"];
            NSMutableDictionary *carrier = (NSMutableDictionary *)[results.result objectForKey:carrierId];
            if (carrier == nil) {
                carrier = [[[NSMutableDictionary alloc] initWithCapacity:1] autorelease];
                [results.result setObject:carrier forKey:carrierId];
            }
            [carrier setObject:[result objectForKey:@"id"] forKey:[result objectForKey:@"planName"]];
        }
    }
    
    return results;
}

-(CPSyncInsLookupPlanResponse *)response {
    if (nil == response) {
        response = [[CPSyncInsLookupPlanResponse alloc] init];
    }
    return response;
}


-(void)dealloc {
    [response release];
    [super dealloc];
}

@end
