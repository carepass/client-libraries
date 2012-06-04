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

#import "CarePassDICClientTests.h"

@implementation CarePassDICClientTests

- (void)setUp {
    [super setUp];
    
    // Set-up code here.
    CarePassCredentials *credentials = [[CarePassCredentials alloc] initWithAPIKey:API_KEY_ID];
    client = [[CarePassDICClient alloc] initWithCredentials:credentials];
    [credentials release];
}

- (void)tearDown {
    // Tear-down code here.
    [client release];
    
    [super tearDown];
}

- (void)testSearch_Simple {
    @try {
        DICSearchRequest *searchRequest = [[DICSearchRequest alloc] init];
        searchRequest.ndc = @"0004-0098";
        searchRequest.gender = @"F";
        DICSearchResponse *response = [client search:searchRequest];
        
        STAssertNotNil(response, @"Response should not be nil");
        STAssertTrue([response.searchResult.claims count] >= 35, @"Wrong number of claims results returned");
        
        [searchRequest release];
    }
    @catch (CarePassClientException *exception) {
        NSLog(@"Exception = %@", exception);
        STFail(@"Exception occured = %@", exception);
    }    
}

- (void)testSearch_Complex {
    @try {
        DICSearchRequest *searchRequest = [[DICSearchRequest alloc] init];
        searchRequest.ndc = @"0004-0098";
        searchRequest.gender = @"F";
        searchRequest.birthYearFrom = @"1950";
        searchRequest.birthYearTo = @"1990";
        DICSearchResponse *response = [client search:searchRequest];
        
        STAssertNotNil(response, @"Response should not be nil");
        STAssertTrue([response.searchResult.claims count] >= 26, @"Wrong number of claims results returned");
        
        [searchRequest release];
    }
    @catch (CarePassClientException *exception) {
        NSLog(@"Exception = %@", exception);
        STFail(@"Exception occured = %@", exception);
    }    
}

@end
