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

#import "HHSClinicalTrialsNCTResponseUnmarshaller.h"

@implementation HHSClinicalTrialsNCTResponseUnmarshaller

@synthesize response;

+(HHSClinicalTrialsNCTResponse *)unmarshall:(NSDictionary *)jsonObject {
    HHSClinicalTrialsNCTResponse *results = [[[HHSClinicalTrialsNCTResponse alloc] init] autorelease];
    
    if (jsonObject != nil && [jsonObject count] > 0) {
        HHSClinicalTrialsNCTResult *searchResult = results.searchResult;
        
        for (id result in jsonObject) {
            
            searchResult.lastUpdated = [result objectForKey:@"lastUpdated"];
            searchResult.phase = [result objectForKey:@"phase"];
            searchResult.trialId = [result objectForKey:@"trialId"];
            
            // loop through the study ids and add them to the dictionary
            NSMutableDictionary *studyIds = [result objectForKey:@"otherstudyids"];
            for( NSString *key in studyIds ) {
                [searchResult.otherstudyids setValue:[studyIds objectForKey:key] forKey:key];
            }
            
            searchResult.sponsor = [result objectForKey:@"sponsor"];
            searchResult.officialTitle = [result objectForKey:@"officialTitle"];
            searchResult.enrollmentNumber = [result objectForKey:@"enrollmentNumber"];
            searchResult.studyStartDate = [result objectForKey:@"studyStartDate"];
            
            // Build out the agesEligible object
            NSMutableDictionary *ages = [result objectForKey:@"agesEligible"];
            searchResult.agesEligible.minimumAge = [ages objectForKey:@"minimumAge"];
            searchResult.agesEligible.maximum_age = [ages objectForKey:@"maximum_age"];
            
            searchResult.gendersEligible = [result objectForKey:@"gendersEligible"];
            searchResult.acceptsHealthyVolunteers = [result objectForKey:@"acceptsHealthyVolunteers"];
            
            // Build out the responsibleParty object
            NSMutableDictionary *parties = [result objectForKey:@"responsibleParty"];
            searchResult.responsibleParty.organization = [parties objectForKey:@"organization"];
            searchResult.responsibleParty.nameTitle = [parties objectForKey:@"nameTitle"];
            searchResult.responsibleParty.responsiblePartyType = [parties objectForKey:@"responsiblePartyType"];
            searchResult.responsibleParty.investigatorAffiliation = [parties objectForKey:@"investigatorAffiliation"];
            searchResult.responsibleParty.investigatorFullName = [parties objectForKey:@"investigatorFullName"];
            searchResult.responsibleParty.investigatorTitle = [parties objectForKey:@"investigatorTitle"];
            
            searchResult.healthAuthority = [result objectForKey:@"healthAuthority"];
            searchResult.urlClinicalTrials = [result objectForKey:@"urlClinicalTrials"];
            
            // Build out the urlContactInformation object
            NSMutableDictionary *contactInfo = [result objectForKey:@"urlContactInformation"];
            searchResult.urlContactInformation.description = [contactInfo objectForKey:@"description"];
            searchResult.urlContactInformation.urlContactInformation = [contactInfo objectForKey:@"urlContactInformation"];
            
            searchResult.urlStudyResultsPosted = [result objectForKey:@"urlStudyResultsPosted"];
        }
        
    }
    
    return results;
}

-(HHSClinicalTrialsNCTResponse *)response {
    if (nil == response) {
        response = [[HHSClinicalTrialsNCTResponse alloc] init];
    }
    return response;
}


-(void)dealloc {
    [response release];
    [super dealloc];
}

@end
