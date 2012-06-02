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

@interface HHSFDARecallsSearchResult : NSObject {
    NSString *date;
    NSString *reason;
    NSString *company;
    NSString *brandName;
    NSString *productDescription;
    NSString *companyReleaseLink;
    NSMutableArray *photosLink;
}

/** Gets and sets the lastModified property */
@property (nonatomic, retain) NSString *date;
@property (nonatomic, retain) NSString *reason;
@property (nonatomic, retain) NSString *company;
@property (nonatomic, retain) NSString *brandName;
@property (nonatomic, retain) NSString *productDescription;
@property (nonatomic, retain) NSString *companyReleaseLink;
@property (nonatomic, retain) NSMutableArray *photosLink;

@end
