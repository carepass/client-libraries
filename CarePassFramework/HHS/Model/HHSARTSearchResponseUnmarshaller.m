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

#import "HHSARTSearchResponseUnmarshaller.h"

@implementation HHSARTSearchResponseUnmarshaller

+(HHSARTSearchResponse *)unmarshall:(NSDictionary *)jsonObject {
    
    HHSARTSearchResponse *results = [[[HHSARTSearchResponse alloc] init] autorelease];
    
    if (jsonObject != nil && [jsonObject count] > 0) {
        // loop through the list values
        for (id clinic in jsonObject) {
            HHSARTSearchResult *clinicResult = [[HHSARTSearchResult alloc] init];
            clinicResult.currClinNameAll = [clinic objectForKey:@"currClinNameAll"];
            clinicResult.clinCityCode = [clinic objectForKey:@"clinCityCode"];
            clinicResult.clinStateCode = [clinic objectForKey:@"clinStateCode"];
            clinicResult.stateCode = [clinic objectForKey:@"stateCode"];
            
            // each clinic needs to pull out the year data
            NSMutableDictionary *yearHistory = [clinic objectForKey:@"yearHistory"];
            for (id year in yearHistory) {
                HHSARTSearchYearResult *yearResult = [[HHSARTSearchYearResult alloc] init];
                yearResult.year = [year objectForKey:@"year"];
                
                NSMutableDictionary *yearData = [year objectForKey:@"data"];
                for( NSString *key in yearData ) {
                    [yearResult.data setValue:[yearData objectForKey:key] forKey:key];
                }
                
                [[clinicResult yearHistory] addObject:yearResult];            
                [yearResult release];
            }
            
            [[results searchResults] addObject:clinicResult];        
            [clinicResult release];
        }
    }
    
    return results;
}

-(HHSARTSearchResponse *)response {
    if (nil == response) {
        response = [[HHSARTSearchResponse alloc] init];
    }
    return response;
}


-(void)dealloc {
    [response release];
    [super dealloc];
}

@end
