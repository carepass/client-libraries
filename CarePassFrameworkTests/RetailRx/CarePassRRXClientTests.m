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

#import "CarePassRRXClientTests.h"

#import <UIKit/UIKit.h>
//#import "application_headers" as required

@implementation CarePassRRXClientTests

- (void)setUp {
    [super setUp];
    
    // Set-up code here.
    CarePassCredentials *credentials = [[CarePassCredentials alloc] initWithAPIKey:API_KEY_ID];
    client = [[CarePassRRXClient alloc] initWithCredentials:credentials];
    [credentials release];
}

- (void)tearDown {
    // Tear-down code here.
    [client release];
    
    [super tearDown];
}

- (void)testRRXLowSearch_Simple {
    @try {
        RRXSearchRequest *searchRequest = [[RRXSearchRequest alloc] init];
        searchRequest.name = @"Avastin";
        RRXSearchResponse *response = [client lowSearch:searchRequest];
        
        STAssertNotNil(response, @"Response should not be nil");
        STAssertTrue([response.searchResult.price count] == 1, @"Wrong number of price results returned");
        
        [searchRequest release];
    }
    @catch (CarePassClientException *exception) {
        NSLog(@"Exception = %@", exception);
        STFail(@"Exception occured = %@", exception);
    }    
}

- (void)testRRXCompareSearch_Simple {
    @try {
        RRXSearchRequest *searchRequest = [[RRXSearchRequest alloc] init];
        searchRequest.name = @"Avastin";
        RRXSearchResponse *response = [client compareSearch:searchRequest];
        
        STAssertNotNil(response, @"Response should not be nil");
        STAssertTrue([response.searchResult.price count] == 3, @"Wrong number of price results returned");
        
        [searchRequest release];
    }
    @catch (CarePassClientException *exception) {
        NSLog(@"Exception = %@", exception);
        STFail(@"Exception occured = %@", exception);
    }    
}

@end
