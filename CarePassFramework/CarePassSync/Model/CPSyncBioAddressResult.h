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

@interface CPSyncBioAddressResult : NSObject {
    NSString *addressId;
    NSString *line1;
    NSString *line2;
    NSString *apt;
    NSString *city;
    NSString *postalCode;
    NSString *postalCodeExtended;
    NSString *state;
    NSString *country;
}

/** Gets and sets the addressId property */
@property (nonatomic, retain) NSString *addressId;

/** Gets and sets the line1 property */
@property (nonatomic, retain) NSString *line1;

/** Gets and sets the line2 property */
@property (nonatomic, retain) NSString *line2;

/** Gets and sets the apt property */
@property (nonatomic, retain) NSString *apt;

/** Gets and sets the city property */
@property (nonatomic, retain) NSString *city;

/** Gets and sets the postalCode property */
@property (nonatomic, retain) NSString *postalCode;

/** Gets and sets the postalCodeExtended property */
@property (nonatomic, retain) NSString *postalCodeExtended;

/** Gets and sets the state property */
@property (nonatomic, retain) NSString *state;

/** Gets and sets the country property */
@property (nonatomic, retain) NSString *country;

@end