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

@interface CPSyncBiographyResult : NSObject {
    NSString *firstName;
    NSString *lastName;
    NSString *prefix;
    NSString *suffix;
    NSString *language;
    NSString *gender;
    NSString *dateOfBirth;
    NSMutableArray *phones;
    NSMutableArray *emailAddresses;
    NSMutableArray *addresses;
}

/** Gets and sets the firstName property */
@property (nonatomic, retain) NSString *firstName;

/** Gets and sets the lastName property */
@property (nonatomic, retain) NSString *lastName;

/** Gets and sets the prefix property */
@property (nonatomic, retain) NSString *prefix;

/** Gets and sets the suffix property */
@property (nonatomic, retain) NSString *suffix;

/** Gets and sets the language property */
@property (nonatomic, retain) NSString *language;

/** Gets and sets the gender property */
@property (nonatomic, retain) NSString *gender;

/** Gets and sets the dateOfBirth property */
@property (nonatomic, retain) NSString *dateOfBirth;

/** Gets and sets the phones property */
@property (nonatomic, retain) NSMutableArray *phones;

/** Gets and sets the emailAddresses property */
@property (nonatomic, retain) NSMutableArray *emailAddresses;

/** Gets and sets the addresses property */
@property (nonatomic, retain) NSMutableArray *addresses;

@end