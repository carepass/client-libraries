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

#import "../HHSResponse.h"
#import "../../JSONKit.h"
#import "../../CarePassServiceException.h"

/**
 * HHS Drugs Search Response
 *
 * \ingroup HHS
 */
@interface HHSDrugsNDCImagesResponse : HHSResponse {
    NSMutableArray *searchResults;
}

-(void)setException:(CarePassServiceException *)theException;

/**
 * Default constructor for a new  object.  Callers should use the
 * property methods to initialize this object after creating it.
 */
-(id)init;

/**
 * The CarePass HHS Drugs NDC Image search results returned from the service
 */
@property (nonatomic, retain) NSMutableArray *searchResults;

/**
 * Returns a value from the search results array for the specified index
 */
-(NSString *)imageURLAtIndex:(int)index;

/**
 * Returns a string representation of this object; useful for testing and
 * debugging.
 *
 * @return A string representation of this object.
 */
-(NSString *)description;

@end
