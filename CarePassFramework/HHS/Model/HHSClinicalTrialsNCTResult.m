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

#import "HHSClinicalTrialsNCTResult.h"

@implementation HHSClinicalTrialsNCTResult

@synthesize lastUpdated;
@synthesize phase;
@synthesize trialId;
@synthesize otherstudyids;
@synthesize sponsor;
@synthesize officialTitle;
@synthesize enrollmentNumber;
@synthesize studyStartDate;
@synthesize agesEligible;
@synthesize gendersEligible;
@synthesize acceptsHealthyVolunteers;
@synthesize responsibleParty;
@synthesize studyFirstReceived;
@synthesize healthAuthority;
@synthesize urlClinicalTrials;
@synthesize urlContactInformation;
@synthesize urlStudyResultsPosted;

-(id)init {
    if (self = [super init]) {
        otherstudyids = [[NSMutableDictionary alloc] initWithCapacity:1];
        agesEligible = [[HHSClinicalTrialsNCTAgesEligibleResult alloc] init];
        responsibleParty = [[HHSClinicalTrialsNCTResponsibleParty alloc] init];
        urlContactInformation = [[HHSClinicalTrialsNCTUrlContactInfo alloc] init];
    }
    
    return self;
}

-(void)dealloc {
    [lastUpdated release];
    [phase release];
    [trialId release];
    [otherstudyids release];
    [sponsor release];
    [officialTitle release];
    [enrollmentNumber release];
    [studyStartDate release];
    [agesEligible release];
    [gendersEligible release];
    [acceptsHealthyVolunteers release];
    [responsibleParty release];
    [studyFirstReceived release];
    [healthAuthority release];
    [urlClinicalTrials release];
    [urlContactInformation release];
    [urlStudyResultsPosted release];
}


@end
