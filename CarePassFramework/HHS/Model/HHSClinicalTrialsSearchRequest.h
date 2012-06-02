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
#import "../../CarePassServiceRequestConfig.h"

@interface HHSClinicalTrialsSearchRequest : CarePassServiceRequestConfig {
    NSString *drugname;
    NSString *status;
    NSString *page;
    NSString *condition;
    NSString *state1;
    NSString *state2;
    NSString *state3;
    NSString *country1;
    NSString *country2;
    NSString *country3;
    NSString *firstreceivedfrom;
    NSString *firstreceivedto;
    NSString *lastupdatedfrom;
    NSString *lastupdatedto;
}



/** Drug name to search for */
@property (nonatomic, retain) NSString *drugname;

/** Trial status to search for */
@property (nonatomic, retain) NSString *status;

/** Page number of results to return */
@property (nonatomic, retain) NSString *page;

/** Condition investigated in the trial to search for */
@property (nonatomic, retain) NSString *condition;

/** First State where trial is taking place to search for */
@property (nonatomic, retain) NSString *state1;

/** Second State where trial is taking place to search for */
@property (nonatomic, retain) NSString *state2;

/** Third State where trial is taking place to search for */
@property (nonatomic, retain) NSString *state3;

/** First country where trial is taking place to search for */
@property (nonatomic, retain) NSString *country1;

/** Second country where trial is taking place to search for */
@property (nonatomic, retain) NSString *country2;

/** Third country where trial is taking place to search for */
@property (nonatomic, retain) NSString *country3;

/** */
@property (nonatomic, retain) NSString *firstreceivedfrom;

/** */
@property (nonatomic, retain) NSString *firstreceivedto;

/** */
@property (nonatomic, retain) NSString *lastupdatedfrom;

/** */
@property (nonatomic, retain) NSString *lastupdatedto;

/**
 * Default constructor for a new HHSClinicalTrialsSearchRequest object.  Callers should use the
 * property methods to initialize this object after creating it.
 */
-(id)init;

/**
 * Returns a string representation of this object; useful for testing and
 * debugging.
 *
 * @return A string representation of this object.
 */
-(NSString *)description;

@end
