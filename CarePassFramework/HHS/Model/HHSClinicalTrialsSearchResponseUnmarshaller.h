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
#import "HHSClinicalTrialsSearchResponse.h"
#import "HHSClinicalTrialsSearchResult.h"
#import "HHSClinicalTrialsResult.h"
#import "../../JSONKit.h"

@interface HHSClinicalTrialsSearchResponseUnmarshaller : NSObject {
    HHSClinicalTrialsSearchResponse *response;
}

@property (nonatomic, readonly) HHSClinicalTrialsSearchResponse *response;

+(HHSClinicalTrialsSearchResponse *)unmarshall:(NSDictionary *)jsonObject;

@end
