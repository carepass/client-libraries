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

#import "CPSyncBioAddressResult.h"

@implementation CPSyncBioAddressResult

@synthesize addressId;
@synthesize line1;
@synthesize line2;
@synthesize apt;
@synthesize city;
@synthesize postalCode;
@synthesize postalCodeExtended;
@synthesize state;
@synthesize country;

-(void)dealloc {
    
    [addressId release];
    [line1 release];
    [line2 release];
    [apt release];
    [city release];
    [postalCode release];
    [postalCodeExtended release];
    [state release];
    [country release];
    
    [super dealloc];
    
}

@end
