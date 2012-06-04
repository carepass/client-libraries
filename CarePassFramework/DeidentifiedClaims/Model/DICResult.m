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

#import "DICResult.h"

@implementation DICResult

@synthesize ndc;
@synthesize ndc11Digit;
@synthesize gender;
@synthesize birthYear;
@synthesize prescSpecialty;
@synthesize threeDigitPhmZip;
@synthesize dispenseQuarter;
@synthesize generic;
@synthesize refillCount;
@synthesize untsDispensedQuantity;
@synthesize daysSupplyCount;
@synthesize threeDigitSubsZip;


-(void)dealloc {
    [ndc release];
    [ndc11Digit release];
    [gender release];
    [birthYear release];
    [prescSpecialty release];
    [threeDigitPhmZip release];
    [dispenseQuarter release];
    [generic release];
    [refillCount release];
    [untsDispensedQuantity release];
    [daysSupplyCount release];
    [threeDigitSubsZip release];
    
    [super dealloc];
}

@end