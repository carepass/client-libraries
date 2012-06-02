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

#import "CarePassECCClientTests.h"

@implementation CarePassECCClientTests

- (void)setUp {
    [super setUp];
    
    // Set-up code here.
    CarePassCredentials *credentials = [[CarePassCredentials alloc] initWithAPIKey:API_KEY_ID];
    client = [[CarePassECCClient alloc] initWithCredentials:credentials];
    [credentials release];
}

- (void)tearDown {
    // Tear-down code here.
    [client release];
    
    [super tearDown];
}

- (void)testMedicalCost_Zip {
    @try {
        ECCCostRequest *searchRequest = [[ECCCostRequest alloc] init];
        searchRequest.code = @"99205";
        searchRequest.zipcode = @"02139";
        ECCCostResponse *response = [client estimateMedicalCost:searchRequest];
        
        STAssertNotNil(response, @"Response should not be nil");
//        STAssertTrue([response.searchResult zip] == 1, @"Wrong number of price results returned");
        
        [searchRequest release];
    }
    @catch (CarePassClientException *exception) {
        NSLog(@"Exception = %@", exception);
        STFail(@"Exception occured = %@", exception);
    }    
}

- (void)testMedicalCost_LatLong {
    @try {
        ECCCostRequest *searchRequest = [[ECCCostRequest alloc] init];
        searchRequest.code = @"99205";
        searchRequest.latitude = @"38.898717";
        searchRequest.longitude = @"-77.035974";
        ECCCostResponse *response = [client estimateMedicalCost:searchRequest];
        
        STAssertNotNil(response, @"Response should not be nil");
        //        STAssertTrue([response.searchResult zip] == 1, @"Wrong number of price results returned");
        
        [searchRequest release];
    }
    @catch (CarePassClientException *exception) {
        NSLog(@"Exception = %@", exception);
        STFail(@"Exception occured = %@", exception);
    }    
}

- (void)testDentalCost_Zip {
    @try {
        ECCCostRequest *searchRequest = [[ECCCostRequest alloc] init];
        searchRequest.code = @"D0274";
        searchRequest.zipcode = @"02139";
        ECCCostResponse *response = [client estimateDentalCost:searchRequest];
        
        STAssertNotNil(response, @"Response should not be nil");
//        STAssertTrue([response.searchResult.price count] == 3, @"Wrong number of price results returned");
        
        [searchRequest release];
    }
    @catch (CarePassClientException *exception) {
        NSLog(@"Exception = %@", exception);
        STFail(@"Exception occured = %@", exception);
    }    
}

- (void)testDentalCost_LatLong {
    @try {
        ECCCostRequest *searchRequest = [[ECCCostRequest alloc] init];
        searchRequest.code = @"D0274";
        searchRequest.latitude = @"38.898717";
        searchRequest.longitude = @"-77.035974";
        ECCCostResponse *response = [client estimateDentalCost:searchRequest];
        
        STAssertNotNil(response, @"Response should not be nil");
        //        STAssertTrue([response.searchResult.price count] == 3, @"Wrong number of price results returned");
        
        [searchRequest release];
    }
    @catch (CarePassClientException *exception) {
        NSLog(@"Exception = %@", exception);
        STFail(@"Exception occured = %@", exception);
    }    
}

- (void)testGetCategories {
    @try {
        ECCCategoryResponse *response = [client getCategories];
        
        STAssertNotNil(response, @"Response should not be nil");
    }
    @catch (NSException *exception) {
        NSLog(@"Exception = %@", exception);
        STFail(@"Exception occured = %@", exception);
    }
}

- (void)testGetSubcategories {
    @try {
        ECCCategoryRequest *searchRequest = [[ECCCategoryRequest alloc] init];
        searchRequest.category = @"Dental";
        ECCCategoryResponse *response = [client getSubcategories:searchRequest];
        
        STAssertNotNil(response, @"Response should not be nil");
        STAssertTrue([response.categories count] == 15, @"Wrong number of subcategory results returned");
        
        [searchRequest release];
    }
    @catch (NSException *exception) {
        NSLog(@"Exception = %@", exception);
        STFail(@"Exception occured = %@", exception);
    }
}

@end
