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

@interface CPSyncLifestyleResult : NSObject {
    NSString *lifestyleId;
    NSString *type;
    NSString *name;
    NSString *imageUrl;
}

/** Gets and sets the lifestyle id property */
@property (nonatomic, retain) NSString *lifestyleId;

/** Gets and sets the type property */
@property (nonatomic, retain) NSString *type;

/** Gets and sets the name property */
@property (nonatomic, retain) NSString *name;

/** Gets and sets the imageUrl property */
@property (nonatomic, retain) NSString *imageUrl;

@end