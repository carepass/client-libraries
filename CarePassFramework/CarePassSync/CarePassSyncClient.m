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

#import "CarePassSyncClient.h"

@implementation CarePassSyncClient

-(id)initWithCredentials:(CarePassCredentials *)theCredentials
{
    if (self = [super initWithCredentials:theCredentials]) {
        // default, near useless endpoint
        self.endpoint = @"https://api.carepass.com/user-directory-api/";
    }
    return self;
}

#pragma mark Service Requests

-(CPSyncIdentityResponse *)getIdentity:(CPSyncIdentityRequest *)searchRequest {
    CarePassServiceRequest *request = [CPSyncIdentityRequestMarshaller createRequest:searchRequest];
    
    return (CPSyncIdentityResponse *)[self invoke:request rawRequest:searchRequest unmarshallerDelegate:[CPSyncIdentityResponseUnmarshaller class]];
}

-(CPSyncBiographyResponse *)getBiography:(CPSyncBiographyRequest *)searchRequest {
    CarePassServiceRequest *request = [CPSyncBiographyRequestMarshaller createRequest:searchRequest andType:@"GET"];
    
    return (CPSyncBiographyResponse *)[self invoke:request rawRequest:searchRequest unmarshallerDelegate:[CPSyncBiographyResponseUnmarshaller class]];
}

//-(CPSyncBiographyResponse *)saveBiography:(CPSyncBiographyRequest *)request {
//    CarePassServiceRequest *saveRequest = [CPSyncBiographyRequestMarshaller createRequest:request andType:@"SAVE"];
//    
//    return (CPSyncBiographyResponse *)[self invoke:saveRequest rawRequest:request unmarshallerDelegate:[CPSyncBiographyResponseUnmarshaller class]];    
//}

-(CPSyncInsLookupCarrierResponse *)lookupInsuranceCarriers:(CPSyncInsuranceLookupRequest *)lookupRequest {
    CarePassServiceRequest *request = [CPSyncInsuranceLookupRequestMarshaller createRequest:lookupRequest];
    
    return (CPSyncInsLookupCarrierResponse *)[self invoke:request rawRequest:lookupRequest unmarshallerDelegate:[CPSyncInsLookupCarrierResponseUnmarshaller class]];
}

-(CPSyncInsLookupPlanResponse *)lookupInsurancePlans:(CPSyncInsuranceLookupRequest *)lookupRequest {
    CarePassServiceRequest *request = [CPSyncInsuranceLookupRequestMarshaller createRequest:lookupRequest andType:@"PLANS"];
    
    return (CPSyncInsLookupPlanResponse *)[self invoke:request rawRequest:lookupRequest unmarshallerDelegate:[CPSyncInsLookupPlanResponseUnmarshaller class]];
}

-(CPSyncInsurancePlanResponse *)getInsurancePlans:(CPSyncInsurancePlanRequest *)planRequest {
    CarePassServiceRequest *request = [CPSyncInsurancePlanRequestMarshaller createRequest:planRequest andType:@"GET"];
    
    return (CPSyncInsurancePlanResponse *)[self invoke:request rawRequest:planRequest unmarshallerDelegate:[CPSyncInsurancePlanResponseUnmarshaller class]];
}

-(CPSyncInsurancePlanResponse *)getInsurancePlan:(CPSyncInsurancePlanRequest *)planRequest {
    CarePassServiceRequest *request = [CPSyncInsurancePlanRequestMarshaller createRequest:planRequest andType:@"GET"];
    
    return (CPSyncInsurancePlanResponse *)[self invoke:request rawRequest:planRequest unmarshallerDelegate:[CPSyncInsurancePlanResponseUnmarshaller class]];
}

-(CPSyncInsurancePlanResponse *)updateInsurancePlan:(CPSyncInsurancePlanRequest *)planRequest {
    CarePassServiceRequest *request = [CPSyncInsurancePlanRequestMarshaller createRequest:planRequest andType:@"UPDATE"];
    
    return (CPSyncInsurancePlanResponse *)[self invoke:request rawRequest:planRequest unmarshallerDelegate:[CPSyncInsurancePlanResponseUnmarshaller class]];
}

-(CPSyncInsurancePlanResponse *)saveInsurancePlans:(CPSyncInsurancePlanRequest *)planRequest {
    CarePassServiceRequest *request = [CPSyncInsurancePlanRequestMarshaller createRequest:planRequest andType:@"SAVE"];
    
    return (CPSyncInsurancePlanResponse *)[self invoke:request rawRequest:planRequest unmarshallerDelegate:[CPSyncInsurancePlanResponseUnmarshaller class]];
}

/* NOT AVAILABLE AS OF JULY 2012 */
 
-(CPSyncFitLookupActivitiesResponse *)lookupActivities:(CPSyncFitLookupActivitiesRequest *)lookupRequest {
    CarePassServiceRequest *request = [CPSyncFitLookupActivitiesRequestMarshaller createRequest:lookupRequest];
    
    return (CPSyncFitLookupActivitiesResponse *)[self invoke:request rawRequest:lookupRequest unmarshallerDelegate:[CPSyncFitLookupActivitiesResponseUnmarshaller class]];    
}

-(CPSyncFitActivitiesResponse *)getActivities:(CPSyncFitActivitiesRequest *)activityRequest {
    CarePassServiceRequest *request = [CPSyncFitActivitiesRequestMarshaller createRequest:activityRequest andType:@"GET"];
    
    return (CPSyncFitActivitiesResponse *)[self invoke:request rawRequest:activityRequest unmarshallerDelegate:[CPSyncFitActivitiesResponseUnmarshaller class]];
}

-(CPSyncFitActivitiesResponse *)getActivity:(CPSyncFitActivitiesRequest *)activityRequest {
    CarePassServiceRequest *request = [CPSyncFitActivitiesRequestMarshaller createRequest:activityRequest andType:@"GET"];
    
    return (CPSyncFitActivitiesResponse *)[self invoke:request rawRequest:activityRequest unmarshallerDelegate:[CPSyncFitActivitiesResponseUnmarshaller class]];
}

-(CPSyncFitActivitiesResponse *)updateActivities:(CPSyncFitActivitiesRequest *)activityRequest {
    CarePassServiceRequest *request = [CPSyncFitActivitiesRequestMarshaller createRequest:activityRequest andType:@"UPDATE"];
    
    return (CPSyncFitActivitiesResponse *)[self invoke:request rawRequest:activityRequest unmarshallerDelegate:[CPSyncFitActivitiesResponseUnmarshaller class]];
}

-(CPSyncFitActivitiesResponse *)saveActivities:(CPSyncFitActivitiesRequest *)activityRequest {
    CarePassServiceRequest *request = [CPSyncFitActivitiesRequestMarshaller createRequest:activityRequest andType:@"SAVE"];
    
    return (CPSyncFitActivitiesResponse *)[self invoke:request rawRequest:activityRequest unmarshallerDelegate:[CPSyncFitActivitiesResponseUnmarshaller class]];
}

-(CPSyncLifestyleResponse *)getLifestyleItems:(CPSyncLifestyleRequest *)lifestyleRequest {
    CarePassServiceRequest *request = [CPSyncLifestyleRequestMarshaller createRequest:lifestyleRequest andType:@"GET"];
    
    return (CPSyncLifestyleResponse *)[self invoke:request rawRequest:lifestyleRequest unmarshallerDelegate:[CPSyncLifestyleResponseUnmarshaller class]];
}

-(CPSyncLifestyleResponse *)getLifestyleItem:(CPSyncLifestyleRequest *)lifestyleRequest {
    CarePassServiceRequest *request = [CPSyncLifestyleRequestMarshaller createRequest:lifestyleRequest andType:@"GET"];
    
    return (CPSyncLifestyleResponse *)[self invoke:request rawRequest:lifestyleRequest unmarshallerDelegate:[CPSyncLifestyleResponseUnmarshaller class]];
}

-(CPSyncLifestyleResponse *)saveLifestyleItems:(CPSyncLifestyleRequest *)lifestyleRequest {
    CarePassServiceRequest *request = [CPSyncLifestyleRequestMarshaller createRequest:lifestyleRequest andType:@"UPDATE"];
    
    return (CPSyncLifestyleResponse *)[self invoke:request rawRequest:lifestyleRequest unmarshallerDelegate:[CPSyncLifestyleResponseUnmarshaller class]];
}

-(CPSyncLifestyleResponse *)saveLifestyleItemsByType:(CPSyncLifestyleRequest *)lifestyleRequest {
    CarePassServiceRequest *request = [CPSyncLifestyleRequestMarshaller createRequest:lifestyleRequest andType:@"UPDATE"];
    
    return (CPSyncLifestyleResponse *)[self invoke:request rawRequest:lifestyleRequest unmarshallerDelegate:[CPSyncLifestyleResponseUnmarshaller class]];
}

#pragma mark memory management

-(void)dealloc {
    [super dealloc];
}

@end
