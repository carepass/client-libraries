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

#import "HHSDrugsNDCResult.h"

@implementation HHSDrugsNDCResult

@synthesize packages;
@synthesize nda;
@synthesize ndc2segment;
@synthesize strength;
@synthesize labelerName;
@synthesize proprietaryName;
@synthesize unit;
@synthesize nonProprietaryName;
@synthesize substanceName;
@synthesize dosageFormname;
@synthesize routeName;
@synthesize startMarketing_date;
@synthesize endMarketing_date;

-(id)init {
    if (self = [super init]) {
        packages = [[NSMutableArray alloc] initWithCapacity:1];
    }
    
    return self;
}

-(void)dealloc {
    [packages release];
    [nda release];
    [ndc2segment release];
    [strength release];
    [labelerName release];
    [proprietaryName release];
    [unit release];
    [nonProprietaryName release];
    [substanceName release];
    [dosageFormname release];
    [routeName release];
    [startMarketing_date release];
    [endMarketing_date release];
    
    [super dealloc];
}

@end
