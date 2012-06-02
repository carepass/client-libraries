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

#import "CarePassSDKUtil.h"

@implementation CarePassSDKUtil

+(NSString *)userAgentString
{
    NSString *sn  = [[[UIDevice currentDevice] systemName] stringByReplacingOccurrencesOfString:@" " withString:@"-"];
    NSString *sv  = [[UIDevice currentDevice] systemVersion];
    NSString *loc = [[NSLocale currentLocale] localeIdentifier];
    NSString *ua  = [NSString stringWithFormat: [NSString stringWithString:CP_SDK_USER_AGENT_FORMAT], [NSString stringWithString:CP_SDK_VERSION], sn, sv, loc];
    
    return ua;
}

+(NSString *)urlEncode:(NSString *)input
{
    NSString *encoded = (NSString *)CFURLCreateStringByAddingPercentEscapes(NULL, (CFStringRef)input, NULL, (CFStringRef)@"!*'\"();:@&=+$,/?%#[]% ", kCFStringEncodingUTF8);
    
    return [encoded autorelease];
}

@end
