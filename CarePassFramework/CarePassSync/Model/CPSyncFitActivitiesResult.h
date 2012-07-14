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

#import <Foundation/Foundation.h>

@interface CPSyncFitActivitiesResult : NSObject {
    NSString *activityId;
    NSString *desc;
    NSString *notes;
    NSString *type;
    NSString *typeExtra;
    NSString *date;
    NSString *startTime;
    NSString *endTime;
    NSString *startCity;
    NSString *endCity;
    NSString *startState;
    NSString *endState;
    NSString *startCountry;
    NSString *endCountry;
    NSDecimalNumber *startLat;
    NSDecimalNumber *startLng;
    NSDecimalNumber *endLat;
    NSDecimalNumber *endLng;
    NSNumber *caloriesBurned;
    NSDecimalNumber *distance;
    NSString *distanceUnits;
    NSNumber *duration;
    NSString *lastUpdated;
}

/** Gets and sets the activityId property */
@property (nonatomic, retain) NSString *activityId;

/** Gets and sets the desc property */
@property (nonatomic, retain) NSString *desc;

/** Gets and sets the notes property */
@property (nonatomic, retain) NSString *notes;

/** Gets and sets the type property */
@property (nonatomic, retain) NSString *type;

/** Gets and sets the typeExtra property */
@property (nonatomic, retain) NSString *typeExtra;

/** Gets and sets the date property */
@property (nonatomic, retain) NSString *date;

/** Gets and sets the startTime property */
@property (nonatomic, retain) NSString *startTime;

/** Gets and sets the endTime property */
@property (nonatomic, retain) NSString *endTime;

/** Gets and sets the startCity property */
@property (nonatomic, retain) NSString *startCity;

/** Gets and sets the endCity property */
@property (nonatomic, retain) NSString *endCity;

/** Gets and sets the startState property */
@property (nonatomic, retain) NSString *startState;

/** Gets and sets the endState property */
@property (nonatomic, retain) NSString *endState;

/** Gets and sets the startCountry property */
@property (nonatomic, retain) NSString *startCountry;

/** Gets and sets the endCountry property */
@property (nonatomic, retain) NSString *endCountry;

/** Gets and sets the startLat property */
@property (nonatomic, retain) NSDecimalNumber *startLat;

/** Gets and sets the startLng property */
@property (nonatomic, retain) NSDecimalNumber *startLng;

/** Gets and sets the endLat property */
@property (nonatomic, retain) NSDecimalNumber *endLat;

/** Gets and sets the endLng property */
@property (nonatomic, retain) NSDecimalNumber *endLng;

/** Gets and sets the caloriesBurned property */
@property (nonatomic, retain) NSNumber *caloriesBurned;

/** Gets and sets the distance property */
@property (nonatomic, retain) NSDecimalNumber *distance;

/** Gets and sets the distanceUnits property */
@property (nonatomic, retain) NSString *distanceUnits;

/** Gets and sets the duration property */
@property (nonatomic, retain) NSNumber *duration;

/** Gets and sets the lastUpdated property */
@property (nonatomic, retain) NSString *lastUpdated;

@end