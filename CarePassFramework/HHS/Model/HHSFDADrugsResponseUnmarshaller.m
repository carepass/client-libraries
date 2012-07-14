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

#import "HHSFDADrugsResponseUnmarshaller.h"

@implementation HHSFDADrugsResponseUnmarshaller


+(HHSResponse *)unmarshall:(NSDictionary *)jsonObject {
    HHSFDADrugsResponse *drug = [[[HHSFDADrugsResponse alloc] init] autorelease];
    
    if (jsonObject != nil && [jsonObject count] > 0) {
        // if we return anything other than a JKArray, make sure it's not just a message of some sort
        if (![jsonObject isKindOfClass:NSClassFromString(@"JKArray")]) {
            
            NSString *errorCode = [jsonObject objectForKey:@"errorCode"];
            NSString *message = [jsonObject objectForKey:@"message"];
            id error = [jsonObject objectForKey:@"error"];
            // error can be a string or another array
            if ([error isKindOfClass:NSClassFromString(@"JKArray")]) {
                errorCode = [error objectForKey:@"code"];
                message = [error objectForKey:@"message"];
            } 
            
            if (errorCode != nil || error != nil || message != nil) {
                if ([errorCode isEqualToString:@"000"]) {
                    // no activities for this user - return empty response
                    return drug;
                } else {
                    // error retrieving data - kick up an exception
                    NSString *errorMessage = [NSString stringWithFormat:@"error retrieving HHS FDA drug data: %@ - %@", error, message];
                    [drug setException:[CarePassServiceException exceptionWithMessage:errorMessage]];
                }
            } 
        } else {        // loop through the list values
            for (id result in jsonObject) {
                
                // drugs!
                drug.result.nda = [result objectForKey:@"nda"];
                drug.result.resources = [HHSFDADrugsResponseUnmarshaller createResourcesResult:[result objectForKey:@"drugsResources"]];
                drug.result.alternatives = [HHSFDADrugsResponseUnmarshaller createAlternativesResult:[result objectForKey:@"alternatives"]];
                drug.result.documents = [HHSFDADrugsResponseUnmarshaller createDocumentsResult:[result objectForKey:@"documents"]];
            }
        }
    }
    
    return (HHSResponse *)drug;
}

-(HHSResponse *)response {
    if (nil == response) {
        response = [[HHSResponse alloc] init];
    }
    return response;
}


-(void)dealloc {
    [response release];
    [super dealloc];
}

+(HHSFDADrugsAlternativesResult *)createAlternativesResult:(NSDictionary *)jsonObject {
    
    HHSFDADrugsAlternativesResult *result = [[[HHSFDADrugsAlternativesResult alloc] init] autorelease];
    result.dosageForm = [jsonObject objectForKey:@"dosageForm"];
    result.dosageRoute = [jsonObject objectForKey:@"dosageRoute"];
    result.strength = [jsonObject objectForKey:@"strength"];
    
    NSMutableDictionary *drugs = [jsonObject objectForKey:@"drugs"];
    for (id drug in drugs) {
        HHSFDADrugsAlternativesDrugResult *drugResult = [[HHSFDADrugsAlternativesDrugResult alloc] init];
        drugResult.company = [drug objectForKey:@"company"];
        drugResult.applicationNumber = [drug objectForKey:@"applicationNumber"];
        drugResult.marketingStatus = [drug objectForKey:@"marketingStatus"];
        
        [[result drugs] addObject:drugResult];
        [drugResult release];
    }
    
    return result;    
}

+(NSMutableArray *)createDocumentsResult:(NSDictionary *)jsonObject {
    
    NSMutableArray *result = [[[NSMutableArray alloc] initWithCapacity:1] autorelease];
    
    for (id document in jsonObject) {
        HHSFDADrugsDocumentResult *docResult = [[[HHSFDADrugsDocumentResult alloc] init] autorelease];
        docResult.type = [document objectForKey:@"type"];
        docResult.date = [document objectForKey:@"date"];
        docResult.url = [document objectForKey:@"url"];
        
        [result addObject:docResult];
        [docResult release];
    }
    
    return result;
}

+(NSMutableArray *)createResourcesResult:(NSDictionary *)jsonObject {
    
    NSMutableArray *result = [[[NSMutableArray alloc] initWithCapacity:1] autorelease];
    
    for (id resource in jsonObject) {
        [result addObject:resource];
    }
    
    return result;
}

@end
