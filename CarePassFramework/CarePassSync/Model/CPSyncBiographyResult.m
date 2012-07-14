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

#import "CPSyncBiographyResult.h"

@implementation CPSyncBiographyResult

@synthesize firstName;
@synthesize lastName;
@synthesize prefix;
@synthesize suffix;
@synthesize language;
@synthesize gender;
@synthesize dateOfBirth;
@synthesize phones;
@synthesize emailAddresses;
@synthesize addresses;

-(id)init {
    if (self = [super init]) {
        phones = [[NSMutableArray alloc] initWithCapacity:1];
        emailAddresses = [[NSMutableArray alloc] initWithCapacity:1];
        addresses = [[NSMutableArray alloc] initWithCapacity:1];
    }
    
    return self;
}

-(void)dealloc {
    
    [firstName release];
    [lastName release];
    [prefix release];
    [suffix release];
    [language release];
    [gender release];
    [dateOfBirth release];
    [phones release];
    [emailAddresses release];
    [addresses release];
    
    [super dealloc];

}

@end
