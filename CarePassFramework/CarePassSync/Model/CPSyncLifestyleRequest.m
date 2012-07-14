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

#import "CPSyncLifestyleRequest.h"

@implementation CPSyncLifestyleRequest

@synthesize lifestyleType;
@synthesize lifestyleItems;

-(id)init {
    if (self = [super init]) {
        self.requestEndpoint = @"https://api.carepass.com/user-directory-api/users/currentUser/lifestyle";
        
        lifestyleType = nil;
        lifestyleItems = [[NSMutableArray alloc] initWithCapacity:1];
    }
    
    return self;
}

-(NSString *)description {
    NSMutableString *buffer = [[NSMutableString alloc] initWithCapacity:256];
    
    [buffer appendString:@"{"];
    [buffer appendString:[[[NSString alloc] initWithFormat:@"Lifestyle type: %@,", lifestyleType] autorelease]];
    [buffer appendString:[[[NSString alloc] initWithFormat:@"Lifestyle items: %@,", lifestyleItems] autorelease]];
    [buffer appendString:[super description]];
    [buffer appendString:@"}"];
    
    return [buffer autorelease];
}

-(NSString *)serializedPutRequest {
    
    if ([lifestyleItems count] >0) {
        // build out the array container for the values
        NSMutableString *result = [[NSMutableString alloc] init];
        NSString *jsonTemplate = @"{\"lifestyleAttributes\":[%@]}";
        bool moreThanOne = false;
        
        // loop through each result, add to the array
        for (CPSyncLifestyleResult *attribute in lifestyleItems) {
            NSMutableDictionary *item = [[NSMutableDictionary alloc] initWithCapacity:4];
            if (attribute.lifestyleId != nil) {
                [item setValue:attribute.lifestyleId forKey:@"id"];
            } 
            if (attribute.name != nil) {
                [item setValue:attribute.name forKey:@"name"];
            } else {
                [item setValue:@"" forKey:@"name"];
            }
            if (attribute.type != nil) {
                [item setValue:attribute.type forKey:@"type"];
            } else {
                [item setValue:@"" forKey:@"type"];
            }
            if (attribute.imageUrl != nil) {
                [item setValue:attribute.imageUrl forKey:@"imageUrl"];
            } else {
                [item setValue:@"" forKey:@"imageUrl"];
            }
            
            // add each dictionary to the container array
            if (moreThanOne) {
                [result appendString:[NSString stringWithFormat:@",%@", [item JSONString]]];
            } else {
                [result appendString:[NSString stringWithFormat:jsonTemplate, [item JSONString]]];
            }
            [item release];
        }
                
        return [result autorelease];
    } 
    
    return nil;
}

-(void)dealloc {
    [lifestyleType release];
    [lifestyleItems release];
    
    [super dealloc];
}

@end