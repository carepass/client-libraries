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

@interface HHSDrugsNDCResult : NSObject {
    NSMutableArray *packages;
    NSString *nda;
    NSString *ndc2segment;
    NSString *strength;
    NSString *labelerName;
    NSString *proprietaryName;
    NSString *unit;
    NSString *nonProprietaryName;
    NSString *substanceName;
    NSString *dosageFormname;
    NSString *routeName;
    NSString *startMarketing_date;
    NSString *endMarketing_date;
}

@property (nonatomic, retain) NSMutableArray *packages;
@property (nonatomic, retain) NSString *nda;
@property (nonatomic, retain) NSString *ndc2segment;
@property (nonatomic, retain) NSString *strength;
@property (nonatomic, retain) NSString *labelerName;
@property (nonatomic, retain) NSString *proprietaryName;
@property (nonatomic, retain) NSString *unit;
@property (nonatomic, retain) NSString *nonProprietaryName;
@property (nonatomic, retain) NSString *substanceName;
@property (nonatomic, retain) NSString *dosageFormname;
@property (nonatomic, retain) NSString *routeName;
@property (nonatomic, retain) NSString *startMarketing_date;
@property (nonatomic, retain) NSString *endMarketing_date;

@end