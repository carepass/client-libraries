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

#import "CPSyncInsurancePlanRequest.h"

@implementation CPSyncInsurancePlanRequest

@synthesize planId;
@synthesize plans;

-(id)init {
    if (self = [super init]) {
        self.requestEndpoint = @"https://api.carepass.com/user-directory-api/users/currentUser/insurance/plans";
        
        planId = nil;
        plans = [[NSMutableArray alloc] initWithCapacity:1];
    }
    
    return self;
}

-(NSString *)description {
    NSMutableString *buffer = [[NSMutableString alloc] initWithCapacity:256];
    
    [buffer appendString:@"{"];
    [buffer appendString:[[[NSString alloc] initWithFormat:@"Plan Id: %@,", planId] autorelease]];
    [buffer appendString:[[[NSString alloc] initWithFormat:@"PLans: %@,", plans] autorelease]];
    [buffer appendString:[super description]];
    [buffer appendString:@"}"];
    
    return [buffer autorelease];
}

-(NSString *)serializedPutRequest {
    
    if ([plans count] >0) {
        // build out the array container for the values
        NSMutableString *result = [[NSMutableString alloc] init];
        NSString *jsonTemplate = @"[%@]";
        bool moreThanOne = false;
        
        // loop through each result, add to the array
        for (CPSyncInsurancePlanResult *attribute in plans) {
            NSMutableDictionary *item = [[NSMutableDictionary alloc] initWithCapacity:23];
            if (attribute.planId != nil) {
                [item setValue:attribute.planId forKey:@"id"];
            } 
            if (attribute.aliasName != nil) {
                [item setValue:attribute.aliasName forKey:@"aliasName"];
            } else {
                [item setValue:@"" forKey:@"aliasName"];
            }
            if (attribute.carrierId != nil) {
                [item setValue:attribute.carrierId forKey:@"carrierId"];
            } else {
                [item setValue:@"" forKey:@"carrierId"];
            }
            if (attribute.planId != nil) {
                [item setValue:attribute.planId forKey:@"planId"];
            } else {
                [item setValue:@"" forKey:@"planId"];
            }
            if (attribute.memberName != nil) {
                [item setValue:attribute.memberName forKey:@"memberName"];
            } else {
                [item setValue:@"" forKey:@"memberName"];
            }
            if (attribute.planType != nil) {
                [item setValue:attribute.planType forKey:@"planType"];
            } else {
                [item setValue:@"" forKey:@"planType"];
            }
            if (attribute.effectiveDate != nil) {
                [item setValue:attribute.effectiveDate forKey:@"effectiveDate"];
            } else {
                [item setValue:@"" forKey:@"effectiveDate"];
            }
            if (attribute.memberId != nil) {
                [item setValue:attribute.memberId forKey:@"memberId"];
            } else {
                [item setValue:@"" forKey:@"memberId"];
            }
            
            // add each dictionary to the container array
            if (moreThanOne) {
                [result appendString:[NSString stringWithFormat:@",%@", [item JSONString]]];
            } else {
                [result appendString:[NSString stringWithFormat:jsonTemplate, [item JSONString]]];
            }
            [item release];
        }
        
        return [result autorelease];
    } 
    
    return nil;
}

-(void)dealloc {
    [planId release];
    [plans release];
    
    [super dealloc];
}

@end