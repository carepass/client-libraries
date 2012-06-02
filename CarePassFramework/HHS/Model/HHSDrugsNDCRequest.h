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

#import "../../CarePassServiceRequestConfig.h"

/**
 * HHS Drugs Search Request
 *
 * \ingroup HHS
 */
@interface HHSDrugsNDCRequest : CarePassServiceRequestConfig {
    NSString *ndc2;
    NSString *ndc3;
}

/** National Drug Code Directory, segment 1 and segment 2 separated by "-" to retrieve */
@property (nonatomic, retain) NSString *ndc2;

/** National Drug Code Directory, segment 1, segment 2, and segment 3 separated by "-" to retrieve */
@property (nonatomic, retain) NSString *ndc3;

/**
 * Default constructor for a new HHSARTSearchRequest object.  Callers should use the
 * property methods to initialize this object after creating it.
 */
-(id)init;

/**
 * Returns a string representation of this object; useful for testing and
 * debugging.
 *
 * @return A string representation of this object.
 */
-(NSString *)description;

@end
