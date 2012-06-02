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

#import "HHSDrugsNDCResponseUnmarshaller.h"

@implementation HHSDrugsNDCResponseUnmarshaller

+(HHSDrugsNDCResponse *)unmarshall:(NSDictionary *)jsonObject {
    HHSDrugsNDCResponse *results = [[[HHSDrugsNDCResponse alloc] init] autorelease];
    
    if (jsonObject != nil && [jsonObject count] > 0) {
        
        for (id result in jsonObject) {
            
            // loop through the packages values
            NSMutableDictionary *packages = [result objectForKey:@"packageInfo"];
            for (id package in packages) {
                HHSDrugsNDCPackageResult *packageResult = [[HHSDrugsNDCPackageResult alloc] init];
                packageResult.ndc3Segment = [package objectForKey:@"ndc3Segment"];
                packageResult.packageDescription = [package objectForKey:@"packageDescription"];
                
                [[results.searchResult packages] addObject:packageResult];        
                [packageResult release];
            }
            
            results.searchResult.nda = [result objectForKey:@"nda"];
            results.searchResult.ndc2segment = [result objectForKey:@"ndc2Segment"];
            results.searchResult.strength = [result objectForKey:@"strength"];
            results.searchResult.labelerName = [result objectForKey:@"labelerName"];
            results.searchResult.proprietaryName = [result objectForKey:@"proprietaryName"];
            results.searchResult.unit = [result objectForKey:@"unit"];
            results.searchResult.nonProprietaryName = [result objectForKey:@"nonProprietaryName"];
            results.searchResult.substanceName = [result objectForKey:@"substanceName"];
            results.searchResult.dosageFormname = [result objectForKey:@"dosageFormname"];
            results.searchResult.routeName = [result objectForKey:@"routeName"];
            results.searchResult.startMarketing_date = [result objectForKey:@"startMarketing_date"];
            results.searchResult.endMarketing_date = [result objectForKey:@"endMarketing_date"];
        }
    }
    
    
    return results;
}

-(HHSDrugsNDCResponse *)response {
    if (nil == response) {
        response = [[HHSDrugsNDCResponse alloc] init];
    }
    return response;
}


-(void)dealloc {
    [response release];
    [super dealloc];
}

@end
