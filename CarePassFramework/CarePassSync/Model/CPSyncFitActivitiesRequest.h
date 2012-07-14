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
#import "CPSyncFitActivitiesResult.h"
#import "../../JSONKit.h"

/**
 * CarePass Sync Insurance PLan Request
 *
 * \ingroup CPSync
 */
@interface CPSyncFitActivitiesRequest : CarePassServiceRequestConfig {
    NSString *activityId;
    NSString *dateFrom;
    NSString *dateTo;
    NSMutableArray *activities;
}

/** Retrieve activities for this id */
@property (nonatomic, retain) NSString *activityId;

/** Retrieve activities from this date */
@property (nonatomic, retain) NSString *dateFrom;

/** Retrieve activities to this date */
@property (nonatomic, retain) NSString *dateTo;

/** Activities data to save */
@property (nonatomic, retain) NSMutableArray *activities;

/** JSON representation of the lifestyle items to be saved */
-(NSString *)serializedPutRequest;

@end
