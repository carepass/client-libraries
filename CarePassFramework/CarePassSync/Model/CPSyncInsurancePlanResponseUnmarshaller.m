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

#import "CPSyncInsurancePlanResponseUnmarshaller.h"

@implementation CPSyncInsurancePlanResponseUnmarshaller

+(CPSyncInsurancePlanResponse *)unmarshall:(NSDictionary *)jsonObject  {
    
    CPSyncInsurancePlanResponse *results = [[[CPSyncInsurancePlanResponse alloc] init] autorelease];
    
    if (jsonObject != nil && [jsonObject count] > 0) {
        NSString *errorCode = [jsonObject objectForKey:@"errorCode"];
        NSString *error = [jsonObject objectForKey:@"error"];
        NSString *message = [jsonObject objectForKey:@"message"];
        if (errorCode != nil || error != nil || message != nil) {
            if ([errorCode isEqualToString:@"000"]) {
                // no plans for this user - return empty response
                return results;
            } else {
                // error retrieving data - kick up an exception
                NSString *errorMessage = [NSString stringWithFormat:@"error retrieving insurance data: %@%@", error, message];
                [results setException:[CarePassServiceException exceptionWithMessage:errorMessage]];
            }
        } else {
            NSMutableArray *planResult = [results results];
            
            for (id result in jsonObject) {
                CPSyncInsurancePlanResult *plan = [[CPSyncInsurancePlanResult alloc] init];
                plan.userPlanId = [result objectForKey:@"id"];
                plan.aliasName = [result objectForKey:@"aliasName"];
                plan.carrierId = [result objectForKey:@"carrierId"];
                plan.planId = [result objectForKey:@"planId"];
                plan.memberName = [result objectForKey:@"memberName"];
                plan.planType = [result objectForKey:@"planType"];
                plan.effectiveDate = [result objectForKey:@"effectiveDate"];
                plan.memberId = [result objectForKey:@"memberId"];
                
                [planResult addObject:plan];
                [plan release];
            }
        }
    }
    
    return results;
}

-(CPSyncInsurancePlanResponse *)response {
    if (nil == response) {
        response = [[CPSyncInsurancePlanResponse alloc] init];
    }
    return response;
}


-(void)dealloc {
    [response release];
    [super dealloc];
}

@end
