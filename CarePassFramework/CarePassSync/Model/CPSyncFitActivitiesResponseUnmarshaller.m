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

#import "CPSyncFitActivitiesResponseUnmarshaller.h"

@implementation CPSyncFitActivitiesResponseUnmarshaller

+(CPSyncFitActivitiesResponse *)unmarshall:(NSDictionary *)jsonObject  {
    
    CPSyncFitActivitiesResponse *results = [[[CPSyncFitActivitiesResponse alloc] init] autorelease];
    
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
                    NSString *errorMessage = [NSString stringWithFormat:@"error retrieving activity data: %@ - %@", error, message];
                    [results setException:[CarePassServiceException exceptionWithMessage:errorMessage]];
                }
            } else {
                // it's a single result sent back from the get call - parse it
                NSMutableArray *activityResult = [results results];
                CPSyncFitActivitiesResult *activity = [self parseJSON:jsonObject];
                [activityResult addObject:activity];
            }
        } else {
            NSMutableArray *activityResult = [results results];
            
            for (id result in jsonObject) {
                CPSyncFitActivitiesResult *activity = [self parseJSON:result];
                [activityResult addObject:activity];
            }
        }
    }
    
    return results;
}

+(CPSyncFitActivitiesResult *) parseJSON:(NSDictionary *)jsonObject {
    
    CPSyncFitActivitiesResult *activity = [[CPSyncFitActivitiesResult alloc] init];
    
    activity.activityId = [jsonObject objectForKey:@"id"];
    activity.desc = [jsonObject objectForKey:@"desc"];
    activity.notes = [jsonObject objectForKey:@"text"];
    activity.type = [jsonObject objectForKey:@"type"];
    activity.typeExtra = [jsonObject objectForKey:@"typeExtra"];
    activity.date = [jsonObject objectForKey:@"date"];
    activity.startTime = [jsonObject objectForKey:@"startTime"];
    activity.endTime = [jsonObject objectForKey:@"endTime"];
    activity.startCity = [jsonObject objectForKey:@"startCity"];
    activity.endCity = [jsonObject objectForKey:@"endCity"];
    activity.startCountry = [jsonObject objectForKey:@"startCountry"];
    activity.endCountry = [jsonObject objectForKey:@"endCountry"];
    activity.startLat = [jsonObject objectForKey:@"startLatitude"];
    activity.startLng = [jsonObject objectForKey:@"startLongitude"];
    activity.endLat = [jsonObject objectForKey:@"endLatitude"];
    activity.endLng = [jsonObject objectForKey:@"endLongitude"];
    activity.caloriesBurned = [jsonObject objectForKey:@"caloriesBurned"];
    activity.distance = [jsonObject objectForKey:@"distance"];
    activity.distanceUnits = [jsonObject objectForKey:@"distanceUnits"];
    activity.duration = [jsonObject objectForKey:@"duration"];
    activity.lastUpdated = [jsonObject objectForKey:@"lastUpdated"];
    
    return [activity autorelease];

}

-(CPSyncFitActivitiesResponse *)response {
    if (nil == response) {
        response = [[CPSyncFitActivitiesResponse alloc] init];
    }
    return response;
}

-(void)dealloc {
    [response release];
    [super dealloc];
}

@end
