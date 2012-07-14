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

#import "DICSearchResponseUnmarshaller.h"

@implementation DICSearchResponseUnmarshaller

+(DICSearchResponse *)unmarshall:(NSDictionary *)jsonObject  {
    
    DICSearchResponse *results = [[[DICSearchResponse alloc] init] autorelease];
    
    if (jsonObject != nil && [jsonObject count] > 0) {
        NSString *errorCode = [jsonObject objectForKey:@"errorCode"];
        NSString *error = [jsonObject objectForKey:@"error"];
        NSString *message = [jsonObject objectForKey:@"message"];
        if (errorCode != nil || error != nil || message != nil) {
            if ([errorCode isEqualToString:@"000"]) {
                // no activities for this user - return empty response
                return results;
            } else {
                // error retrieving data - kick up an exception
                NSString *errorMessage = [NSString stringWithFormat:@"error retrieving lifestyle data: %@%@", error, message];
                [results setException:[CarePassServiceException exceptionWithMessage:errorMessage]];
            }
        } else {
            DICSearchResult *searchResult = results.searchResult;
            searchResult.page = [jsonObject objectForKey:@"page"];
            searchResult.totalResults = [jsonObject objectForKey:@"totalResults"];
            searchResult.totalPages = [jsonObject objectForKey:@"totalPages"];
            
            // now, to pull out the individual claims results
            NSMutableDictionary *claims = [jsonObject objectForKey:@"claims"];
            for (id claim in claims) {
                DICResult *claimResult = [[DICResult alloc] init];
                claimResult.ndc = [claim objectForKey:@"ndc"];
                claimResult.ndc11Digit = [claim objectForKey:@"ndc11Digit"];
                claimResult.gender = [claim objectForKey:@"gender"];
                claimResult.birthYear = [claim objectForKey:@"birthYear"];
                claimResult.prescSpecialty = [claim objectForKey:@"prescSpecialty"];
                claimResult.threeDigitPhmZip = [claim objectForKey:@"threeDigitPhmZip"];
                claimResult.dispenseQuarter = [claim objectForKey:@"dispenseQuarter"];
                claimResult.generic = [claim objectForKey:@"generic"];
                claimResult.refillCount = [claim objectForKey:@"newRefillCount"];
                claimResult.untsDispensedQuantity = [claim objectForKey:@"untsDispensedQuantity"];
                claimResult.daysSupplyCount = [claim objectForKey:@"daysSupplyCount"];
                claimResult.threeDigitSubsZip = [claim objectForKey:@"threeDigitSubsZip"];
                
                [[searchResult claims] addObject:claimResult];
                [claimResult release];
            }
        }
    }
    
    
    return results;
}

-(DICSearchResponse *)response {
    if (nil == response) {
        response = [[DICSearchResponse alloc] init];
    }
    return response;
}


-(void)dealloc {
    [response release];
    [super dealloc];
}

@end
