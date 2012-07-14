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

#import "HHSClinicalTrialsSearchResponseUnmarshaller.h"

@implementation HHSClinicalTrialsSearchResponseUnmarshaller
+(HHSClinicalTrialsSearchResponse *)unmarshall:(NSDictionary *)jsonObject {
    
    HHSClinicalTrialsSearchResponse *results = [[[HHSClinicalTrialsSearchResponse alloc] init] autorelease];
    
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
            
            HHSClinicalTrialsSearchResult *searchResult = results.searchResult;
            searchResult.page = [jsonObject objectForKey:@"page"];
            searchResult.totalResults = [jsonObject objectForKey:@"totalResults"];
            searchResult.totalPages = [jsonObject objectForKey:@"totalPages"];
            
            // now, to pull out the individual trial results
            NSMutableDictionary *trials = [jsonObject objectForKey:@"clinicalTrials"];
            for (id trial in trials) {
                HHSClinicalTrialsResult *trialResult = [[HHSClinicalTrialsResult alloc] init];
                trialResult.order = [trial objectForKey:@"order"];
                trialResult.score = [trial objectForKey:@"score"];
                trialResult.nctid = [trial objectForKey:@"nctid"];
                trialResult.url = [trial objectForKey:@"url"];
                trialResult.title = [trial objectForKey:@"title"];
                trialResult.statusOpen = [trial objectForKey:@"statusOpen"];
                trialResult.conditionSummary = [trial objectForKey:@"conditionSummary"];
                trialResult.lastChanged = [trial objectForKey:@"lastChanged"];
                
                [[searchResult trials] addObject:trialResult];
                [trialResult release];
            }
        }
    }
    
    return results;
}

-(HHSClinicalTrialsSearchResponse *)response {
    if (nil == response) {
        response = [[HHSClinicalTrialsSearchResponse alloc] init];
    }
    return response;
}


-(void)dealloc {
    [response release];
    [super dealloc];
}

@end
