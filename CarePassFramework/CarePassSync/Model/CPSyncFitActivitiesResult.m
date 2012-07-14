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

#import "CPSyncFitActivitiesResult.h"

@implementation CPSyncFitActivitiesResult

@synthesize activityId;
@synthesize desc;
@synthesize notes;
@synthesize type;
@synthesize typeExtra;
@synthesize date;
@synthesize startTime;
@synthesize endTime;
@synthesize startCity;
@synthesize endCity;
@synthesize startState;
@synthesize endState;
@synthesize startCountry;
@synthesize endCountry;
@synthesize startLat;
@synthesize startLng;
@synthesize endLat;
@synthesize endLng;
@synthesize caloriesBurned;
@synthesize distance;
@synthesize distanceUnits;
@synthesize duration;
@synthesize lastUpdated;

- (void) dealloc {
    
    [activityId release];
    [desc release];
    [notes release];
    [type release];
    [typeExtra release];
    [date release];
    [startTime release];
    [endTime release];
    [startState release];
    [endState release];
    [startCountry release];
    [endCountry release];
    [startLat release];
    [startLng release];
    [endLat release];
    [endLng release];
    [caloriesBurned release];
    [distance release];
    [distanceUnits release];
    [duration release];
    [lastUpdated release];
    
    [super dealloc];
}

@end
