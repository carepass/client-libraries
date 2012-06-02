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

#import "CarePassHHSClientTests.h"

@implementation CarePassHHSClientTests

- (void)setUp {
    [super setUp];
    
    // Set-up code here.
    CarePassCredentials *credentials = [[CarePassCredentials alloc] initWithAPIKey:API_KEY_ID];
    client = [[CarePassHHSClient alloc] initWithCredentials:credentials];
    [credentials release];
}

- (void)tearDown {
    // Tear-down code here.
    [client release];
    
    [super tearDown];
}

- (void)testARTSearch_Simple {
    @try {
        HHSARTSearchRequest *searchRequest = [[HHSARTSearchRequest alloc] init];
        searchRequest.city = @"birmingham";
        HHSARTSearchResponse *response = [client artSearch:searchRequest];
        
        STAssertNotNil(response, @"Response should not be nil");
        STAssertTrue([response.searchResults count] >= 4, @"Wrong number of result returned");
        
        [searchRequest release];
    }
    @catch (CarePassClientException *exception) {
        NSLog(@"Exception = %@", exception);
        STFail(@"Exception occured = %@", exception);
    }

}

- (void)testARTSearch_Complex {
    @try {
        HHSARTSearchRequest *searchRequest = [[HHSARTSearchRequest alloc] init];
        
        searchRequest.city = @"birmingham";
        searchRequest.medicalDirector = @"Steinkampf";
        searchRequest.year = @"2008";
        
        HHSARTSearchResponse *response = [client artSearch:searchRequest];
        
        STAssertNotNil(response, @"Response should not be nil");
        STAssertTrue([response.searchResults count] == 1, @"Wrong number of results returned");
        STAssertTrue([[[response searchResultObjectAtIndex:0] yearHistory] count] == 1, @"Wrong number of years returned");
        STAssertTrue([[[[response searchResultObjectAtIndex:0] searchYearResultObjectAtIndex:0] year] isEqualToString:@"2008"], @"Wrong year returned");
        
        [searchRequest release];
    }
    @catch (CarePassClientException *exception) {
        NSLog(@"Exception = %@", exception);
        STFail(@"Exception occured = %@", exception);
    }
    
}

- (void)testFDARecallSearch_Simple {
    @try {
        HHSFDARecallsSearchRequest *searchRequest = [[HHSFDARecallsSearchRequest alloc] init];
        searchRequest.product = @"tylenol";
        HHSFDARecallsSearchResponse *response = [client fdaRecallSearch:searchRequest];
        
        STAssertNotNil(response, @"Response should not be nil");
        STAssertTrue([response.searchResults count] >= 4, @"Wrong number of result returned");
        
        [searchRequest release];
    }   
    @catch (CarePassClientException *exception) {
        NSLog(@"Exception = %@", exception);
        STFail(@"Exception occured = %@", exception);
    }
    
}

- (void)testFDARecallSearch_Complex {
    @try {
        HHSFDARecallsSearchRequest *searchRequest = [[HHSFDARecallsSearchRequest alloc] init];
        
        searchRequest.product = @"tylenol";
        searchRequest.date = @"2012-02-17";
        
        HHSFDARecallsSearchResponse *response = [client fdaRecallSearch:searchRequest];
        
        STAssertNotNil(response, @"Response should not be nil");
        STAssertTrue([response.searchResults count] == 1, @"Wrong number of results returned");
        STAssertTrue([[[response searchResultObjectAtIndex:0] reason] isEqualToString:@"difficulty using the Infants TYLENOL SimpleMeasure dosing system"], @"Wrong reason returned");
        
        [searchRequest release];
    }
    @catch (CarePassClientException *exception) {
        NSLog(@"Exception = %@", exception);
        STFail(@"Exception occured = %@", exception);
    }
    
}

- (void)testFDADrugSearch {
    @try {
        HHSFDADrugsRequest *searchRequest = [[HHSFDADrugsRequest alloc] init];
        searchRequest.nda = @"NDA003444";
        HHSFDADrugsResponse *response = [client fdaDrugsSearch:searchRequest];
        
        STAssertNotNil(response, @"Response should not be nil");
        STAssertTrue([response.result.nda isEqualToString:searchRequest.nda], @"Wrong nda returned");
        
        [searchRequest release];
    }
    @catch (CarePassClientException *exception) {
        NSLog(@"Exception = %@", exception);
        STFail(@"Exception occured = %@", exception);
    }
    
}

- (void)testFDADrugDocumentsSearch {
    @try {
        HHSFDADrugsRequest *searchRequest = [[HHSFDADrugsRequest alloc] init];
        searchRequest.nda = @"NDA003444";
        HHSFDADrugsDocumentsResponse *response = [client fdaDrugsDocumentsSearch:searchRequest];
        
        STAssertNotNil(response, @"Response should not be nil");
        
        [searchRequest release];
    }
    @catch (CarePassClientException *exception) {
        NSLog(@"Exception = %@", exception);
        STFail(@"Exception occured = %@", exception);
    }
    
}

- (void)testFDADrugResourcesSearch {
    @try {
        HHSFDADrugsRequest *searchRequest = [[HHSFDADrugsRequest alloc] init];
        searchRequest.nda = @"NDA003444";
        HHSFDADrugsResourcesResponse *response = [client fdaDrugsResourcesSearch:searchRequest];
        
        STAssertNotNil(response, @"Response should not be nil");
        
        [searchRequest release];
    }
    @catch (CarePassClientException *exception) {
        NSLog(@"Exception = %@", exception);
        STFail(@"Exception occured = %@", exception);
    }
    
}

- (void)testFDADrugAlternativesSearch {
    @try {
        HHSFDADrugsRequest *searchRequest = [[HHSFDADrugsRequest alloc] init];
        searchRequest.nda = @"NDA003444";
        HHSFDADrugsAlternativesResponse *response = [client fdaDrugsAlternativesSearch:searchRequest];
        
        STAssertNotNil(response, @"Response should not be nil");
        
        [searchRequest release];
    }
    @catch (CarePassClientException *exception) {
        NSLog(@"Exception = %@", exception);
        STFail(@"Exception occured = %@", exception);
    }
    
}

- (void)testClinicalTrialsSearch_Simple {
    @try {
        HHSClinicalTrialsSearchRequest *searchRequest = [[HHSClinicalTrialsSearchRequest alloc] init];
        searchRequest.drugname = @"prozac";
        HHSClinicalTrialsSearchResponse *response = [client clinicalTrialsSearch:searchRequest];
        
        STAssertNotNil(response, @"Response should not be nil");
        STAssertTrue([response.searchResult.trials count] >= 4, @"Wrong number of result returned");
        
        [searchRequest release];
    }
    @catch (CarePassClientException *exception) {
        NSLog(@"Exception = %@", exception);
        STFail(@"Exception occured = %@", exception);
    }
    
}

- (void)testClinicalTrialsSearch_Complex {
    @try {
        HHSClinicalTrialsSearchRequest *searchRequest = [[HHSClinicalTrialsSearchRequest alloc] init];
        
        searchRequest.drugname = @"tylenol";
        searchRequest.status = @"open";
        searchRequest.state1 = @"NA:US:AL";
        searchRequest.firstreceivedfrom = @"1/1/2005";
        searchRequest.firstreceivedto = @"1/1/2012";
        
        HHSClinicalTrialsSearchResponse *response = [client clinicalTrialsSearch:searchRequest];
        
        STAssertNotNil(response, @"Response should not be nil");
        STAssertTrue([response.searchResult.trials count] == 4, @"Wrong number of results returned");
        STAssertTrue([[[response clinicalTrialsObjectAtIndex:0] conditionSummary] isEqualToString:@"Fever"], @"Wrong reason returned");
        
        [searchRequest release];
    }
    @catch (CarePassClientException *exception) {
        NSLog(@"Exception = %@", exception);
        STFail(@"Exception occured = %@", exception);
    }
    
}

- (void)testClinicalTrialsNCTSearch {
    @try {
        HHSClinicalTrialsNCTRequest *searchRequest = [[HHSClinicalTrialsNCTRequest alloc] init];
        searchRequest.nctid = @"NCT00835224";
        HHSClinicalTrialsNCTResponse *response = [client clinicalTrialsNCTSearch:searchRequest];
        
        STAssertNotNil(response, @"Response should not be nil");
        //        STAssertTrue([response.result count] >= 4, @"Wrong number of result returned");
        
        [searchRequest release];
    }
    @catch (CarePassClientException *exception) {
        NSLog(@"Exception = %@", exception);
        STFail(@"Exception occured = %@", exception);
    }
    
}

- (void)testDrugsSearch {
    @try {
        HHSDrugsSearchRequest *searchRequest = [[HHSDrugsSearchRequest alloc] init];
        searchRequest.name = @"Cymbalta";
        HHSDrugsSearchResponse *response = [client drugsSearch:searchRequest];
        
        STAssertNotNil(response, @"Response should not be nil");
        //        STAssertTrue([response.result count] >= 4, @"Wrong number of result returned");
        
        [searchRequest release];
    }
    @catch (CarePassClientException *exception) {
        NSLog(@"Exception = %@", exception);
        STFail(@"Exception occured = %@", exception);
    }
    
}

- (void)testDrugsNDCSearch {
    @try {
        HHSDrugsNDCRequest *searchRequest = [[HHSDrugsNDCRequest alloc] init];
        searchRequest.ndc2 = @"0002-4760";
        HHSDrugsNDCResponse *response = [client drugsNDC:searchRequest];
        
        STAssertNotNil(response, @"Response should not be nil");
        STAssertTrue([response.searchResult.ndc2segment isEqualToString:searchRequest.ndc2], @"Wrong ndc2 returned");
        
        [searchRequest release];
    }
    @catch (CarePassClientException *exception) {
        NSLog(@"Exception = %@", exception);
        STFail(@"Exception occured = %@", exception);
    }
    
}

- (void)testDrugsNDCPackagesSearch {
    @try {
        HHSDrugsNDCRequest *searchRequest = [[HHSDrugsNDCRequest alloc] init];
        searchRequest.ndc2 = @"0002-4760";
        searchRequest.ndc3 = @"0002-4760-76";
        HHSDrugsNDCPackagesResponse *response = [client drugsNDCPackages:searchRequest];
        
        STAssertNotNil(response, @"Response should not be nil");
        STAssertTrue([response.searchResult.ndc3Segment isEqualToString:searchRequest.ndc3], @"Wrong ndc3 returned");
        
        [searchRequest release];
    }
    @catch (CarePassClientException *exception) {
        NSLog(@"Exception = %@", exception);
        STFail(@"Exception occured = %@", exception);
    }
    
}

- (void)testDrugsNDCImagesSearch {
    @try {
        HHSDrugsNDCRequest *searchRequest = [[HHSDrugsNDCRequest alloc] init];
        searchRequest.ndc2 = @"0002-4760";
        HHSDrugsNDCImagesResponse *response = [client drugsNDCImages:searchRequest];
        
        STAssertNotNil(response, @"Response should not be nil");
        STAssertTrue([response.searchResults count] >= 11, @"Wrong number of results returned");
        
        [searchRequest release];
    }
    @catch (CarePassClientException *exception) {
        NSLog(@"Exception = %@", exception);
        STFail(@"Exception occured = %@", exception);
    }
    
}

@end
