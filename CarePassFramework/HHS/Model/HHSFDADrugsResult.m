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

#import "HHSFDADrugsResult.h"

@implementation HHSFDADrugsResult

@synthesize nda;
@synthesize resources;
@synthesize alternatives;
@synthesize documents;

-(id)init {
    if (self = [super init]) {
        resources = [[NSMutableArray alloc] initWithCapacity:1];
        documents = [[NSMutableArray alloc] initWithCapacity:1];
    }
    
    return self;
}

-(void)dealloc {
    [nda release];
    [resources release];
    [alternatives release];
    [documents release];
    
    [super dealloc];
}

@end
