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

@interface DICResult : NSObject {
    NSString *ndc;
    NSString *ndc11Digit;
    NSString *gender;
    NSString *birthYear;
    NSString *prescSpecialty;
    NSString *threeDigitPhmZip;
    NSString *dispenseQuarter;
    NSString * generic;
    NSString *refillCount;
    NSString *untsDispensedQuantity;
    NSString *daysSupplyCount;
    NSString *threeDigitSubsZip;
}

@property (nonatomic, retain) NSString *ndc;
@property (nonatomic, retain) NSString *ndc11Digit;
@property (nonatomic, retain) NSString *gender;
@property (nonatomic, retain) NSString *birthYear;
@property (nonatomic, retain) NSString *prescSpecialty;
@property (nonatomic, retain) NSString *threeDigitPhmZip;
@property (nonatomic, retain) NSString *dispenseQuarter;
@property (nonatomic, retain) NSString *generic;
@property (nonatomic, retain) NSString *refillCount;
@property (nonatomic, retain) NSString *untsDispensedQuantity;
@property (nonatomic, retain) NSString *daysSupplyCount;
@property (nonatomic, retain) NSString *threeDigitSubsZip;

@end