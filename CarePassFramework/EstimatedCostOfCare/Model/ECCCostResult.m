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

#import "ECCCostResult.h"

@implementation ECCCostResult

@synthesize identifier;
@synthesize type;
@synthesize description;
@synthesize category;
@synthesize subcategory;
@synthesize costInMarket;
@synthesize costOutMarket;
@synthesize code;
@synthesize zip;
@synthesize lastUpdated;

-(void)dealloc {
    [identifier release];
    [type release];
    [description release];
    [category release];
    [subcategory release];
    [costInMarket release];
    [costOutMarket release];
    [code release];
    [zip release];
    [lastUpdated release];
    
    [super dealloc];
}

@end
