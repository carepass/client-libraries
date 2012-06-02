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
#import "HHSFDADrugsResponse.h"
#import "HHSFDADrugsAlternativesResponse.h"
#import "HHSFDADrugsDocumentsResponse.h"
#import "HHSFDADrugsResourcesResponse.h"
#import "HHSFDADrugsResult.h"
#import "HHSFDADrugsAlternativesResult.h"
#import "HHSFDADrugsAlternativesDrugResult.h"
#import "HHSFDADrugsDocumentResult.h"
#import "HHSFDADrugsResourcesResult.h"
#import "../../JSONKit.h"

@interface HHSFDADrugsResponseUnmarshaller : NSObject {
    HHSResponse *response;
}

@property (nonatomic, readonly) HHSResponse *response;

+(HHSResponse *)unmarshall:(NSDictionary *)jsonObject;
+(HHSFDADrugsAlternativesResult *)createAlternativesResult:(NSDictionary *)jsonObject;
+(NSMutableArray *)createDocumentsResult:(NSDictionary *)jsonObject;
+(NSMutableArray *)createResourcesResult:(NSDictionary *)jsonObject;

@end