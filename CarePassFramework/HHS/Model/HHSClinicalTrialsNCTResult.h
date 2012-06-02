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

#import <Foundation/Foundation.h>
#import "HHSClinicalTrialsNCTAgesEligibleResult.h"
#import "HHSClinicalTrialsNCTResponsibleParty.h"
#import "HHSClinicalTrialsNCTUrlContactInfo.h"

@interface HHSClinicalTrialsNCTResult : NSObject {
    NSString *lastUpdated;
    NSString *phase;
    NSString *trialId;
    NSMutableDictionary *otherstudyids;
    NSString *sponsor;
    NSString *officialTitle;
    NSString *enrollmentNumber;
    NSString *studyStartDate;
    HHSClinicalTrialsNCTAgesEligibleResult *agesEligible;
    NSString *gendersEligible;
    NSString *acceptsHealthyVolunteers;
    HHSClinicalTrialsNCTResponsibleParty *responsibleParty;
    NSString *studyFirstReceived;
    NSString *healthAuthority;
    NSString *urlClinicalTrials;
    HHSClinicalTrialsNCTUrlContactInfo *urlContactInformation;
    NSString *urlStudyResultsPosted;
}

@property (nonatomic, retain) NSString *lastUpdated;
@property (nonatomic, retain) NSString *phase;
@property (nonatomic, retain) NSString *trialId;
@property (nonatomic, retain) NSMutableDictionary *otherstudyids;
@property (nonatomic, retain) NSString *sponsor;
@property (nonatomic, retain) NSString *officialTitle;
@property (nonatomic, retain) NSString *enrollmentNumber;
@property (nonatomic, retain) NSString *studyStartDate;
@property (nonatomic, retain) HHSClinicalTrialsNCTAgesEligibleResult *agesEligible;
@property (nonatomic, retain) NSString *gendersEligible;
@property (nonatomic, retain) NSString *acceptsHealthyVolunteers;
@property (nonatomic, retain) HHSClinicalTrialsNCTResponsibleParty *responsibleParty;
@property (nonatomic, retain) NSString *studyFirstReceived;
@property (nonatomic, retain) NSString *healthAuthority;
@property (nonatomic, retain) NSString *urlClinicalTrials;
@property (nonatomic, retain) HHSClinicalTrialsNCTUrlContactInfo *urlContactInformation;
@property (nonatomic, retain) NSString *urlStudyResultsPosted;

@end
