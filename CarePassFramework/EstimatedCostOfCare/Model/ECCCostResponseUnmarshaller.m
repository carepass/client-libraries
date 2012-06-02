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

#import "ECCCostResponseUnmarshaller.h"

@implementation ECCCostResponseUnmarshaller

+(ECCCostResponse *)unmarshall:(NSDictionary *)jsonObject  {
    
    ECCCostResponse *results = [[[ECCCostResponse alloc] init] autorelease];
    
    if (jsonObject != nil && [jsonObject count] > 0) {
        ECCCostResult *codeResult = [results searchResult];
        
        // loop through the list values (there should only be one)
        for (id result in jsonObject) {
            codeResult.identifier = [result objectForKey:@"id"];
            codeResult.type = [result objectForKey:@"type"];
            codeResult.description = [result objectForKey:@"description"];
            codeResult.category = [result objectForKey:@"category"];
            codeResult.subcategory = [result objectForKey:@"subcategory"];
            codeResult.costInMarket = [result objectForKey:@"in"];
            codeResult.costOutMarket = [result objectForKey:@"out"];
            codeResult.code = [result objectForKey:@"code"];
            codeResult.zip = [result objectForKey:@"zip"];
            codeResult.lastUpdated = [result objectForKey:@"lastUpdated"];
        }
    }
    
    return results;
}

-(ECCCostResponse *)response {
    if (nil == response) {
        response = [[ECCCostResponse alloc] init];
    }
    return response;
}


-(void)dealloc {
    [response release];
    [super dealloc];
}

@end
