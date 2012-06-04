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
#import "../../CarePassServiceRequestConfig.h"

/**
 * De-identified claims Search Request
 *
 * \ingroup DIC
 */
@interface DICSearchRequest : CarePassServiceRequestConfig {
    NSString *ndc;
    NSString *gender;
    NSString *birthYearFrom;
    NSString *birthYearTo;
    NSString *from;
    NSString *to;
    NSString *page;
}

/** National Drug Code Directory of 2 or 3 segments separated by - */
@property (nonatomic, retain) NSString *ndc;

/** Gender of a member */
@property (nonatomic, retain) NSString *gender;

/** Range start of birth year of a member */
@property (nonatomic, retain) NSString *birthYearFrom;

/** Range end of birth year of a member */
@property (nonatomic, retain) NSString *birthYearTo;

/** Start date to search claims; Format: year + 'Q' + quarter number */
@property (nonatomic, retain) NSString *from;

/** End date to search claims; Format: year + 'Q' + quarter number */
@property (nonatomic, retain) NSString *to;

/** Number of page. (Each page contains 500 results) */
@property (nonatomic, retain) NSString *page;

@end
