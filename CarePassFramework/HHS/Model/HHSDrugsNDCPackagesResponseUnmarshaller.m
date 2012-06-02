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

#import "HHSDrugsNDCPackagesResponseUnmarshaller.h"

@implementation HHSDrugsNDCPackagesResponseUnmarshaller

+(HHSDrugsNDCPackagesResponse *)unmarshall:(NSDictionary *)jsonObject {
    HHSDrugsNDCPackagesResponse *results = [[[HHSDrugsNDCPackagesResponse alloc] init] autorelease];
    
    if (jsonObject != nil && [jsonObject count] > 0) {
        
        HHSDrugsNDCPackageResult *drugResult = [results searchResult];
        
        for (id result in jsonObject) {
            
            drugResult.ndc3Segment = [result objectForKey:@"ndc3Segment"];
            drugResult.packageDescription = [result objectForKey:@"packageDescription"];
            
            NSMutableDictionary *imprintDetails = [result objectForKey:@"imprint"];
            for (id imprintResult in imprintDetails) {
                drugResult.imprint.size = [imprintResult objectForKey:@"size"];
                drugResult.imprint.symbol = [imprintResult objectForKey:@"symbol"];
                drugResult.imprint.score = [imprintResult objectForKey:@"score"];
                drugResult.imprint.pillColor = [imprintResult objectForKey:@"pillColor"];
                drugResult.imprint.shape = [imprintResult objectForKey:@"shape"];
                drugResult.imprint.coating = [imprintResult objectForKey:@"coating"];
                drugResult.imprint.textColor = [imprintResult objectForKey:@"textColor"];
            }
            
        }
        
    }
    
    return results;
}

-(HHSDrugsNDCPackagesResponse *)response {
    if (nil == response) {
        response = [[HHSDrugsNDCPackagesResponse alloc] init];
    }
    return response;
}


-(void)dealloc {
    [response release];
    [super dealloc];
}

@end
