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

#import "HHSDrugsSearchResponseUnmarshaller.h"

@implementation HHSDrugsSearchResponseUnmarshaller

+(HHSDrugsSearchResponse *)unmarshall:(NSDictionary *)jsonObject {
    HHSDrugsSearchResponse *results = [[[HHSDrugsSearchResponse alloc] init] autorelease];
    
    if (jsonObject != nil && [jsonObject count] > 0) {
        
        // loop through the list values
        for (id drug in jsonObject) {
            HHSDrugsSearchResult *drugResult = [[HHSDrugsSearchResult alloc] init];
            drugResult.proprietaryName = [drug objectForKey:@"proprietaryName"];
            drugResult.nonProprietaryName = [drug objectForKey:@"nonProprietaryName"];
            drugResult.ndc = [drug objectForKey:@"ndc"];
            
            [[results searchResults] addObject:drugResult];        
            [drugResult release];
        }
    }
    
    return results;
}

-(HHSDrugsSearchResponse *)response {
    if (nil == response) {
        response = [[HHSDrugsSearchResponse alloc] init];
    }
    return response;
}


-(void)dealloc {
    [response release];
    [super dealloc];
}

@end
