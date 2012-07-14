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

#import "CarePassSyncClientTests.h"

#import <UIKit/UIKit.h>

@implementation CarePassSyncClientTests

- (void)setUp {
    [super setUp];
    
    // Set-up code here.
    CarePassCredentials *credentials = [[CarePassCredentials alloc] initWithAPIKey:API_KEY_ID withClientId:API_CLIENT_ID withAccessToken:APP_ACCESS_TOKEN];
    client = [[CarePassSyncClient alloc] initWithCredentials:credentials];
    [credentials release];
}

- (void)tearDown {
    // Tear-down code here.
    [client release];
    
    [super tearDown];
}

- (void)testIdentity_Get {
    @try {
        CPSyncIdentityRequest *request = [[CPSyncIdentityRequest alloc] init];
        CPSyncIdentityResponse *response = [client getIdentity:request];
        
        STAssertNotNil(response, @"Response should not be nil");
        STAssertTrue([response.result.email isEqualToString:@"julliette@medullan.com"], @"Wrong email address returned");
        
        [request release];
    }
    @catch (CarePassClientException *exception) {
        NSLog(@"Exception = %@", exception);
        STFail(@"Exception occured = %@", exception);
    }    
}

- (void)testBiography_Get {
    @try {
        CPSyncBiographyRequest *request = [[CPSyncBiographyRequest alloc] init];
        CPSyncBiographyResponse *response = [client getBiography:request];
        
        STAssertNotNil(response, @"Response should not be nil");
        STAssertTrue([response.result.firstName isEqualToString:@"Julliette"], @"Wrong firstName returned");
        STAssertTrue([response.result.emailAddresses count] > 0, @"Wrong number of emails returned");
        CPSyncBioEmailResult *value = [response.result.emailAddresses objectAtIndex:0];
        STAssertTrue([value.address isEqualToString:@"julliette@medullan.com"], @"Wrong email address returned");
        
        [request release];
    }
    @catch (CarePassClientException *exception) {
        NSLog(@"Exception = %@", exception);
        STFail(@"Exception occured = %@", exception);
    }    
}

/* BIOGRAPHY SAVE NOT AVAILABLE AS OF JULY 2012
 
- (void)testBiography_Save {
    @try {
        
        // get the user first
        CPSyncBiographyRequest *request = [[CPSyncBiographyRequest alloc] init];
        CPSyncBiographyResponse *response = [client getBiography:request];
        
        // verify the get
        STAssertNotNil(response, @"Response should not be nil");
        STAssertTrue([response.result.firstName isEqualToString:@"Julliette"], @"Wrong firstName returned");
        int emailCount = [response.result.emailAddresses count];
        STAssertTrue(emailCount > 0, @"Wrong number of emails returned");
        CPSyncBioEmailResult *value = [response.result.emailAddresses objectAtIndex:0];
        STAssertTrue([value.address isEqualToString:@"julliette@medullan.com"], @"Wrong email address returned");
        
        // update the user's values by adding another email address
        CPSyncBioEmailResult *newEmail = [[CPSyncBioEmailResult alloc] init];
        NSString *address = [NSString stringWithFormat:@"julliette+%d@medullan.com", emailCount];
        newEmail.address = address;
        newEmail.isPrimary = false;
        [response.result.emailAddresses addObject:newEmail];
        
        // send them back to be saved
        request.biography = response.result;
        CPSyncBiographyResponse *updated = [client saveBiography:request];
        
        // verify the results of the save
        STAssertNotNil(updated, @"Response should not be nil");
        STAssertTrue([updated.result.firstName isEqualToString:@"Julliette"], @"Wrong firstName returned");
        STAssertTrue([updated.result.emailAddresses count] == emailCount + 1, @"Wrong number of emails returned");
        value = [updated.result.emailAddresses objectAtIndex:emailCount];
        STAssertTrue([value.address isEqualToString:address], @"Wrong email address returned");
        
        // do another get to make sure the data is persisted
        
        [request release];
    }
    @catch (CarePassClientException *exception) {
        NSLog(@"Exception = %@", exception);
        STFail(@"Exception occured = %@", exception);
    }    
}
 
 */

/* INSURANCE CARRIER AND PLAN LOOKUP NOT AVAILABLE AS OF JULY 2012
- (void) testInsuranceLookup_Carriers {
    @try {
        CPSyncInsuranceLookupRequest *request = [[CPSyncInsuranceLookupRequest alloc] init];
        CPSyncInsLookupCarrierResponse *response = [client lookupInsuranceCarriers:request];
        
        STAssertNotNil(response, @"Response should not be nil");
        STAssertTrue(true, @"");
        
        [request release];
    }
    @catch (CarePassClientException *exception) {
        NSLog(@"Exception = %@", exception);
        STFail(@"Exception occured = %@", exception);
    }    
}

- (void) testInsuranceLookup_Plans {
    @try {
        CPSyncInsuranceLookupRequest *request = [[CPSyncInsuranceLookupRequest alloc] init];
        CPSyncInsLookupPlanResponse *response = [client lookupInsurancePlans:request];
        
        STAssertNotNil(response, @"Response should not be nil");
        STAssertTrue(true, @"");
        
        [request release];
    }
    @catch (CarePassClientException *exception) {
        NSLog(@"Exception = %@", exception);
        STFail(@"Exception occured = %@", exception);
    }    
}
 
 */

- (void) testInsurancePlans_GetAll {
    @try {
        CPSyncInsurancePlanRequest *request = [[CPSyncInsurancePlanRequest alloc] init];
        CPSyncInsurancePlanResponse *response = [client getInsurancePlans:request];
        
        STAssertNotNil(response, @"Response should not be nil");
        STAssertNil([response exception], @"Exception should be nil");
        STAssertTrue(true, @"");
        
        [request release];
    }
    @catch (CarePassClientException *exception) {
        NSLog(@"Exception = %@", exception);
        STFail(@"Exception occured = %@", exception);
    }    
}

- (void) testInsurancePlans_GetAll_NoneFound {
    @try {
        CarePassCredentials *credentials = [[CarePassCredentials alloc] initWithAPIKey:API_KEY_ID withClientId:API_CLIENT_ID withAccessToken:APP_NO_ACCESS_TOKEN];
        CarePassSyncClient *tempClient = [[CarePassSyncClient alloc] initWithCredentials:credentials];
        [credentials release];
        
        CPSyncInsurancePlanRequest *request = [[CPSyncInsurancePlanRequest alloc] init];
        CPSyncInsurancePlanResponse *response = [tempClient getInsurancePlans:request];
        [tempClient release];
        
        STAssertTrue([response.results count] == 0, @"Wrong number of results returned");
        
        [request release];
    }
    @catch (CarePassClientException *exception) {
        NSLog(@"Exception = %@", exception);
    }    
}

- (void) testInsurancePlans_GetOne {
    @try {
        CPSyncInsurancePlanRequest *request = [[CPSyncInsurancePlanRequest alloc] init];
        request.planId = @"";
        CPSyncInsurancePlanResponse *response = [client getInsurancePlan:request];
        
        STAssertNotNil(response, @"Response should not be nil");
        STAssertTrue(true, @"");
        
        [request release];
    }
    @catch (CarePassClientException *exception) {
        NSLog(@"Exception = %@", exception);
        STFail(@"Exception occured = %@", exception);
    }    
}

- (void) testInsurancePlans_GetOne_Error {
    @try {
        CarePassCredentials *credentials = [[CarePassCredentials alloc] initWithAPIKey:API_KEY_ID withClientId:API_CLIENT_ID withAccessToken:APP_NO_ACCESS_TOKEN];
        CarePassSyncClient *tempClient = [[CarePassSyncClient alloc] initWithCredentials:credentials];
        [credentials release];
        
        CPSyncInsurancePlanRequest *request = [[CPSyncInsurancePlanRequest alloc] init];
        request.planId = @"";
        [tempClient getInsurancePlan:request];
        [tempClient release];
        
        STFail(@"Exception should have occurred!");
        
        [request release];
    }
    @catch (CarePassClientException *exception) {
        NSLog(@"Exception = %@", exception);
    }    
}

/* INSURANCE SAVE AND UPDATE NOT AVAILABLE AS OF JULY 2012
- (void) testInsurancePlans_Update {
    @try {
        
        // get one
        CPSyncInsurancePlanRequest *request = [[CPSyncInsurancePlanRequest alloc] init];
        request.planId = @"";
        CPSyncInsurancePlanResponse *response = [client getInsurancePlan:request];
        
        // validate that one was returned properly
        STAssertNotNil(response, @"Response should not be nil");
        STAssertTrue(true, @"");
        
        // make some changes
        
        // save
        
        // validate response
        
        [request release];
    }
    @catch (CarePassClientException *exception) {
        NSLog(@"Exception = %@", exception);
        STFail(@"Exception occured = %@", exception);
    }    
}



- (void) testInsurancePlans_Save {
    @try {
        
        // create a a new plan
        CPSyncInsurancePlanResult *newPlan = [[CPSyncInsurancePlanResult alloc] init];
        newPlan.aliasName = @"alias name";
        newPlan.carrierId = @"13";
        newPlan.planId = @"470";
        newPlan.memberName = @"Joe Doe";
        newPlan.planType = @"Medical";
        newPlan.effectiveDate = @"2011-12-24";
        newPlan.memberId = @"0001";
        CPSyncInsurancePlanRequest *request = [[CPSyncInsurancePlanRequest alloc] init];
        [request.plans addObject:newPlan];
        
        CPSyncInsurancePlanResponse *response = [client saveInsurancePlans:request];
        
        // validate that they were returned properly
        STAssertNotNil(response, @"Response should not be nil");
        STAssertTrue(true, @"");
        
        [newPlan release];
        [request release];
    }
    @catch (CarePassClientException *exception) {
        NSLog(@"Exception = %@", exception);
        STFail(@"Exception occured = %@", exception);
    }    
}

 */

/* ACTIVITIES LOOKUP NOT AVAILABLE AS OF JULY 2012
 
- (void) testActivities_Lookup {
    @try {
        CPSyncFitLookupActivitiesRequest *request = [[CPSyncFitLookupActivitiesRequest alloc] init];
        CPSyncFitLookupActivitiesResponse *response = [client lookupActivities:request];
        
        STAssertNotNil(response, @"Response should not be nil");
        STAssertTrue(true, @"");
        
        [request release];
    }
    @catch (CarePassClientException *exception) {
        NSLog(@"Exception = %@", exception);
        STFail(@"Exception occured = %@", exception);
    }    
}
 
 */

- (void) testActivities_GetAll {
    @try {
        CPSyncFitActivitiesRequest *request = [[CPSyncFitActivitiesRequest alloc] init];
        request.dateFrom = @"12/10/2010";
        CPSyncFitActivitiesResponse *response = [client getActivities:request];
        
        STAssertNotNil(response, @"Response should not be nil");
        STAssertNil([response exception], @"Exception should be nil");
        STAssertTrue([response.results count] > 0, @"at least one result should be returned");
        
        [request release];
    }
    @catch (CarePassClientException *exception) {
        NSLog(@"Exception = %@", exception);
        STFail(@"Exception occured = %@", exception);
    }    
}

- (void) testActivities_GetAll_NoneFound {
    @try {
        CarePassCredentials *credentials = [[CarePassCredentials alloc] initWithAPIKey:API_KEY_ID withClientId:API_CLIENT_ID withAccessToken:APP_NO_ACCESS_TOKEN];
        CarePassSyncClient *tempClient = [[CarePassSyncClient alloc] initWithCredentials:credentials];
        [credentials release];
        
        CPSyncFitActivitiesRequest *request = [[CPSyncFitActivitiesRequest alloc] init];
        request.dateFrom = @"12/10/2010";
        request.dateTo = @"01/30/2012";
        CPSyncFitActivitiesResponse *response = [tempClient getActivities:request];
        [tempClient release];
        
        STAssertTrue([response.results count] == 0, @"Wrong number of results returned");
        
        [request release];
    }
    @catch (CarePassClientException *exception) {
        NSLog(@"Exception = %@", exception);
    }    
}

- (void) testActivities_GetOne {
    @try {
        CPSyncFitActivitiesRequest *request = [[CPSyncFitActivitiesRequest alloc] init];
        request.activityId = @"57715";
        CPSyncFitActivitiesResponse *response = [client getActivity:request];
        
        STAssertNotNil(response, @"Response should not be nil");
        STAssertTrue([response.results count] > 0, @"at least one result should be returned");
        
        [request release];
    }
    @catch (CarePassClientException *exception) {
        NSLog(@"Exception = %@", exception);
        STFail(@"Exception occured = %@", exception);
    }    
}

- (void) testActivities_GetOne_Error {
    @try {
        CarePassCredentials *credentials = [[CarePassCredentials alloc] initWithAPIKey:API_KEY_ID withClientId:API_CLIENT_ID withAccessToken:APP_NO_ACCESS_TOKEN];
        CarePassSyncClient *tempClient = [[CarePassSyncClient alloc] initWithCredentials:credentials];
        [credentials release];
        
        CPSyncFitActivitiesRequest *request = [[CPSyncFitActivitiesRequest alloc] init];
        request.activityId = @"";
        [tempClient getActivity:request];
        [tempClient release];
        
        STFail(@"Exception should have occurred!");
        
        [request release];
    }
    @catch (CarePassClientException *exception) {
        NSLog(@"Exception = %@", exception);
    }    
}

- (void) testActivities_Update {
    @try {
        
        // get one
        CPSyncFitActivitiesRequest *request = [[CPSyncFitActivitiesRequest alloc] init];
        request.activityId = @"57739";
        CPSyncFitActivitiesResponse *response = [client getActivity:request];
        
        // validate that one was returned properly
        STAssertNotNil(response, @"Response should not be nil");
        STAssertTrue([response.results count] > 0, @"at least one result should be returned");
        
        // make some changes
        CPSyncFitActivitiesResult *result = [response.results objectAtIndex:0];
        result.caloriesBurned = [NSNumber numberWithInt:255];
        [request.activities addObject:result];
        
        // save
        CPSyncFitActivitiesResponse *updateResponse = [client updateActivities:request];
        
        // validate response
        STAssertNotNil(updateResponse, @"Response should not be nil");
        STAssertTrue([updateResponse.results count] == [response.results count], @"result count should not change");
        
        [request release];
    }
    @catch (CarePassClientException *exception) {
        NSLog(@"Exception = %@", exception);
        STFail(@"Exception occured = %@", exception);
    }    
}


- (void) testActivities_Save {
    @try {
        
        // create a a new plan
        CPSyncFitActivitiesResult *newActivity = [[CPSyncFitActivitiesResult alloc] init];
        newActivity.type = @"Hiking";
        newActivity.duration = [NSNumber numberWithInt:200];
        newActivity.date = @"02/02/2012 10:10:10";
        CPSyncFitActivitiesRequest *request = [[CPSyncFitActivitiesRequest alloc] init];
        [request.activities addObject:newActivity];
        
        CPSyncFitActivitiesResponse *response = [client saveActivities:request];
        
        // validate that they were returned properly
        STAssertNotNil(response, @"Response should not be nil");
        STAssertTrue([response.results count] > 0, @"at least one result should be returned");
        STAssertNotNil([[response.results objectAtIndex:0] activityId], @"activity id should be populated");
        
        [newActivity release];
        [request release];
    }
    @catch (CarePassClientException *exception) {
        NSLog(@"Exception = %@", exception);
        STFail(@"Exception occured = %@", exception);
    }    
}

- (void) testLifestyles_GetAll {
    @try {
        CPSyncLifestyleRequest *request = [[CPSyncLifestyleRequest alloc] init];
        CPSyncLifestyleResponse *response = [client getLifestyleItems:request];
        
        STAssertNotNil(response, @"Response should not be nil");
        STAssertNil([response exception], @"Exception should be nil");
        STAssertTrue([response.results count] >= 3, @"Wrong number of lifestyle results returned");
        
        [request release];
    }
    @catch (CarePassClientException *exception) {
        NSLog(@"Exception = %@", exception);
        STFail(@"Exception occured = %@", exception);
    }    
}

- (void) testLifestyles_GetAll_NoneFound {
    @try {
        CarePassCredentials *credentials = [[CarePassCredentials alloc] initWithAPIKey:API_KEY_ID withClientId:API_CLIENT_ID withAccessToken:APP_NO_ACCESS_TOKEN];
        CarePassSyncClient *tempClient = [[CarePassSyncClient alloc] initWithCredentials:credentials];
        [credentials release];
        
        CPSyncLifestyleRequest *request = [[CPSyncLifestyleRequest alloc] init];
        CPSyncLifestyleResponse *response = [tempClient getLifestyleItems:request];
        [tempClient release];
        
        STAssertTrue([response.results count] == 0, @"Wrong number of results returned");
        
        [request release];
    }
    @catch (CarePassClientException *exception) {
        NSLog(@"Exception = %@", exception);
    }    
}


- (void) testLifestyles_GetByType {
    @try {
        CPSyncLifestyleRequest *request = [[CPSyncLifestyleRequest alloc] init];
        request.lifestyleType = @"sports";
        CPSyncLifestyleResponse *response = [client getLifestyleItem:request];
        
        STAssertNotNil(response, @"Response should not be nil");
        STAssertTrue([response.results count] == 1, @"Wrong number of lifestyle results returned");
        
        [request release];
    }
    @catch (CarePassClientException *exception) {
        NSLog(@"Exception = %@", exception);
        STFail(@"Exception occured = %@", exception);
    }    
}

- (void) testLifestyles_GetByType_NoneFound {
    @try {
        CarePassCredentials *credentials = [[CarePassCredentials alloc] initWithAPIKey:API_KEY_ID withClientId:API_CLIENT_ID withAccessToken:APP_NO_ACCESS_TOKEN];
        CarePassSyncClient *tempClient = [[CarePassSyncClient alloc] initWithCredentials:credentials];
        [credentials release];
        
        CPSyncLifestyleRequest *request = [[CPSyncLifestyleRequest alloc] init];
        request.lifestyleType = @"sports";
        CPSyncLifestyleResponse *response = [tempClient getLifestyleItem:request];
        [tempClient release];
        
        STAssertTrue([response.results count] == 0, @"Wrong number of results returned");
        
        [request release];
    }
    @catch (CarePassClientException *exception) {
        NSLog(@"Exception = %@", exception);
        STFail(@"Exception occured = %@", exception);
    }    
}


- (void) testLifestyles_AddNew {
    @try {
        
        // create one
        CPSyncLifestyleResult *newLifestyle = [[CPSyncLifestyleResult alloc] init];
        newLifestyle.type = @"Movies";
        newLifestyle.name = @"Fletch III";
        
        CPSyncLifestyleRequest *request = [[CPSyncLifestyleRequest alloc] init];
        [request.lifestyleItems addObject:newLifestyle];
        [newLifestyle release];
        CPSyncLifestyleResponse *response = [client saveLifestyleItems:request];
        
        // validate that one was returned properly
        STAssertNotNil(response, @"Response should not be nil");
        
        [request release];
    }
    @catch (CarePassClientException *exception) {
        NSLog(@"Exception = %@", exception);
        STFail(@"Exception occured = %@", exception);
    }    
}


- (void) testLifestyles_UpdateExisting {
    @try {
        
        // create one
        CPSyncLifestyleResult *newLifestyle = [[CPSyncLifestyleResult alloc] init];
        newLifestyle.lifestyleId = @"57583";
        newLifestyle.type = @"Movies";
        newLifestyle.name = @"Fletch Lives";
        
        CPSyncLifestyleRequest *request = [[CPSyncLifestyleRequest alloc] init];
        [request.lifestyleItems addObject:newLifestyle];
        [newLifestyle release];
        CPSyncLifestyleResponse *response = [client saveLifestyleItems:request];
        
        // validate that one was returned properly
        STAssertNotNil(response, @"Response should not be nil");
        
        [request release];
    }
    @catch (CarePassClientException *exception) {
        NSLog(@"Exception = %@", exception);
        STFail(@"Exception occured = %@", exception);
    }    
}


- (void) testLifestylesByType_Update {
    @try {
        
        // create a a new plan
        CPSyncLifestyleResult *newLifestyle = [[CPSyncLifestyleResult alloc] init];
        newLifestyle.lifestyleId = @"57583";
        newLifestyle.type = @"Movies";
        newLifestyle.name = @"Fletch";
        CPSyncLifestyleRequest *request = [[CPSyncLifestyleRequest alloc] init];
        [request.lifestyleItems addObject:newLifestyle];
        request.lifestyleType = @"Movies";
        [newLifestyle release];
        CPSyncLifestyleResponse *response = [client saveLifestyleItems:request];
        
        // validate that one was returned properly
        STAssertNotNil(response, @"Response should not be nil");
        
        [request release];
    }
    @catch (CarePassClientException *exception) {
        NSLog(@"Exception = %@", exception);
        STFail(@"Exception occured = %@", exception);
    }    
}

@end