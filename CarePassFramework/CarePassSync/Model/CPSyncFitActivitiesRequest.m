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

#import "CPSyncFitActivitiesRequest.h"

@implementation CPSyncFitActivitiesRequest

@synthesize activityId;
@synthesize dateFrom;
@synthesize dateTo;
@synthesize activities;

-(id)init {
    if (self = [super init]) {
        self.requestEndpoint = @"https://api.carepass.com/user-directory-api/users/currentUser/fitness/activities";
        
        activityId = nil;
        dateFrom = nil;
        dateTo = nil;
        activities = [[NSMutableArray alloc] initWithCapacity:1];
    }
    
    return self;
}

-(NSString *)description {
    NSMutableString *buffer = [[NSMutableString alloc] initWithCapacity:256];
    
    [buffer appendString:@"{"];
    [buffer appendString:[[[NSString alloc] initWithFormat:@"Activity Id: %@,", activityId] autorelease]];
    [buffer appendString:[[[NSString alloc] initWithFormat:@"Date from: %@,", dateFrom] autorelease]];
    [buffer appendString:[[[NSString alloc] initWithFormat:@"Date to: %@,", dateTo] autorelease]];
    [buffer appendString:[[[NSString alloc] initWithFormat:@"Activities: %@,", activities] autorelease]];
    [buffer appendString:[super description]];
    [buffer appendString:@"}"];
    
    return [buffer autorelease];
}

-(NSString *)serializedPutRequest {
    
    if ([activities count] >0) {
        // build out the array container for the values
        NSMutableString *result = [[NSMutableString alloc] init];
        NSString *jsonTemplate = @"[%@]";
        bool moreThanOne = false;
        
        // loop through each result, add to the array
        for (CPSyncFitActivitiesResult *attribute in activities) {
            NSMutableDictionary *item = [[NSMutableDictionary alloc] initWithCapacity:23];
            if (attribute.activityId != nil) {
                [item setValue:attribute.activityId forKey:@"id"];
            } 
            if (attribute.desc != nil) {
                [item setValue:attribute.desc forKey:@"desc"];
            } 
            if (attribute.notes != nil) {
                [item setValue:attribute.notes forKey:@"text"];
            } 
            if (attribute.type != nil) {
                [item setValue:attribute.type forKey:@"type"];
            } else {
                [item setValue:@"" forKey:@"type"];
            }
            if (attribute.typeExtra != nil) {
                [item setValue:attribute.typeExtra forKey:@"typeExtra"];
            } 
            if (attribute.date != nil) {
                [item setValue:attribute.date forKey:@"date"];
            } 
            if (attribute.startTime != nil) {
                [item setValue:attribute.startTime forKey:@"startTime"];
            } 
            if (attribute.endTime != nil) {
                [item setValue:attribute.endTime forKey:@"endTime"];
            } 
            if (attribute.startCity != nil) {
                [item setValue:attribute.startCity forKey:@"startCity"];
            } 
            if (attribute.endCity != nil) {
                [item setValue:attribute.endCity forKey:@"endCity"];
            } 
            if (attribute.startCountry != nil) {
                [item setValue:attribute.startCountry forKey:@"startCountry"];
            } 
            if (attribute.endCountry != nil) {
                [item setValue:attribute.endCountry forKey:@"endCountry"];
            } 
            if (attribute.startLat != nil) {
                [item setValue:attribute.startLat forKey:@"startLatitude"];
            } 
            if (attribute.startLng != nil) {
                [item setValue:attribute.startLng forKey:@"startLongitude"];
            } 
            if (attribute.endLat != nil) {
                [item setValue:attribute.endLat forKey:@"endLatitude"];
            } 
            if (attribute.endLng != nil) {
                [item setValue:attribute.endLng forKey:@"endLongitude"];
            } 
            if (attribute.caloriesBurned != nil) {
                [item setValue:attribute.caloriesBurned forKey:@"caloriesBurned"];
            } 
            if (attribute.distance != nil) {
                [item setValue:attribute.distance forKey:@"distance"];
            } 
            if (attribute.distanceUnits != nil) {
                [item setValue:attribute.distanceUnits forKey:@"distanceUnits"];
            } 
            if (attribute.duration != nil) {
                [item setValue:attribute.duration forKey:@"duration"];
            } 
            if (attribute.lastUpdated != nil) {
                [item setValue:attribute.lastUpdated forKey:@"lastUpdated"];
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
    [activityId release];
    [dateFrom release];
    [dateTo release];
    [activities release];
    
    [super dealloc];
}

@end