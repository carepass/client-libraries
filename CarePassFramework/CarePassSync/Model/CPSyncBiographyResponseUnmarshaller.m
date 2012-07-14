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

#import "CPSyncBiographyResponseUnmarshaller.h"

@implementation CPSyncBiographyResponseUnmarshaller

+(CPSyncBiographyResponse *)unmarshall:(NSDictionary *)jsonObject  {
    
    CPSyncBiographyResponse *results = [[[CPSyncBiographyResponse alloc] init] autorelease];
    
    if (jsonObject != nil && [jsonObject count] > 0) {
        CPSyncBiographyResult *biographyResult = [results result];
        
        biographyResult.firstName = [jsonObject objectForKey:@"firstName"];
        biographyResult.lastName = [jsonObject objectForKey:@"lastName"];
        biographyResult.prefix = [jsonObject objectForKey:@"prefix"];
        biographyResult.suffix = [jsonObject objectForKey:@"suffix"];
        biographyResult.language = [jsonObject objectForKey:@"language"];
        biographyResult.gender = [jsonObject objectForKey:@"gender"];
        biographyResult.dateOfBirth = [jsonObject objectForKey:@"dateOfBirth"];
        
        for (id phone in [jsonObject objectForKey:@"phones"]) {
            CPSyncBioPhoneResult *phoneResult = [[CPSyncBioPhoneResult alloc] init];
            phoneResult.phoneId = [phone objectForKey:@"id"];
            phoneResult.number = [phone objectForKey:@"number"];
            phoneResult.phoneType = [phone objectForKey:@"phoneType"];
            
            [biographyResult.phones addObject:phoneResult];
            [phoneResult release];
        }

        for (id email in [jsonObject objectForKey:@"emailAddresses"]) {
            CPSyncBioEmailResult *emailResult = [[CPSyncBioEmailResult alloc] init];
            emailResult.emailId = [email objectForKey:@"id"];
            emailResult.address = [email objectForKey:@"address"];
            if ((id)[email objectForKey:@"isPrimary"] == (id)kCFBooleanTrue) {
                emailResult.isPrimary = TRUE;
            } else {
                emailResult.isPrimary = FALSE;
            }
            
            [biographyResult.emailAddresses addObject:emailResult];
            [emailResult release];
        }

        for (id address in [jsonObject objectForKey:@"addresses"]) {
            CPSyncBioAddressResult *addressResult = [[CPSyncBioAddressResult alloc] init];
            addressResult.addressId = [address objectForKey:@"id"];
            addressResult.line1 = [address objectForKey:@"line1"];
            addressResult.line2 = [address objectForKey:@"line2"];
            addressResult.apt = [address objectForKey:@"apt"];
            addressResult.postalCode = [address objectForKey:@"postalCode"];
            addressResult.postalCodeExtended = [address objectForKey:@"postalCodeExtended"];
            addressResult.city = [address objectForKey:@"city"];
            addressResult.state = [address objectForKey:@"state"];
            addressResult.country = [address objectForKey:@"country"];
            
            [biographyResult.addresses addObject:addressResult];
            [addressResult release];
        }

    }
    
    return results;
}

-(CPSyncBiographyResponse *)response {
    if (nil == response) {
        response = [[CPSyncBiographyResponse alloc] init];
    }
    return response;
}


-(void)dealloc {
    [response release];
    [super dealloc];
}

@end
