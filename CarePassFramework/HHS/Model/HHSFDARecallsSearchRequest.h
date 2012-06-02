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
#import "CarePassServiceRequestConfig.h"

/**
 * HHS FDA REcalls Search Request
 *
 * \ingroup HHS
 */
@interface HHSFDARecallsSearchRequest : CarePassServiceRequestConfig {
    NSString *product;
    NSString *date;
    NSString *pastdays;
}

/** Clinic name to search for */
@property (nonatomic, retain) NSString *product;

/** City to search for */
@property (nonatomic, retain) NSString *date;

/** Full state name to search for ("ALABAMA" not "AL") */
@property (nonatomic, retain) NSString *pastdays;

/**
 * Default constructor for a new HHSFDARecallsSearchRequest object.  Callers should use the
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
