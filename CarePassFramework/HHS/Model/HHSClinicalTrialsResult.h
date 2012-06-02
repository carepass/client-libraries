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

@interface HHSClinicalTrialsResult : NSObject {
    NSString *order;
    NSString *score;
    NSString *nctid;
    NSString *url;
    NSString *title;
    NSString *statusOpen;
    NSString *conditionSummary;
    NSString *lastChanged;
}

/** Gets and sets the lastModified property */
@property (nonatomic, retain) NSString *order;
@property (nonatomic, retain) NSString *score;
@property (nonatomic, retain) NSString *nctid;
@property (nonatomic, retain) NSString *url;
@property (nonatomic, retain) NSString *title;
@property (nonatomic, retain) NSString *statusOpen;
@property (nonatomic, retain) NSString *conditionSummary;
@property (nonatomic, retain) NSString *lastChanged;

@end