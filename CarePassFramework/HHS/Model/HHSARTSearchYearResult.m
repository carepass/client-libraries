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

#import "HHSARTSearchYearResult.h"

@implementation HHSARTSearchYearResult

@synthesize data;
@synthesize year;
//@synthesize ivfRate;
//@synthesize giftRate;
//@synthesize ziftRate;
//@synthesize comboRate;
//@synthesize icsiRate;
//@synthesize unstimulatedRate;
//@synthesize gestRate;
//@synthesize pgdRate;
//@synthesize esetTotal;
//@synthesize diagTubalRate;
//@synthesize diagOvulatoryRate;
//@synthesize diagDorRate;
//@synthesize diagEndometriosisRate;
//@synthesize diagUterineRate;
//@synthesize diagMaleRate;
//@synthesize diagOtherRate;
//@synthesize diagUnknownRate;
//@synthesize diagComboNoMaleRate;
//@synthesize diagComboMaleRate;
//@synthesize medicalDirector;
//@synthesize fshNdCycle1;
//@synthesize fshNdCycle2;
//@synthesize fshNdCycle3;
//@synthesize fshNdCycle4;
//@synthesize fshNdCycle5;
//@synthesize fshNdImplant1;
//@synthesize fshNdImplant2;
//@synthesize fshNdImplant3;
//@synthesize fshNdImplant4;
//@synthesize fshNdImplant5;
//@synthesize fshNdPregRate1;
//@synthesize fshNdPregRate2;
//@synthesize fshNdPregRate3;
//@synthesize fshNdPregRate4;
//@synthesize fshNdPregRate5;
//@synthesize fshNdLvBirthsRate1;
//@synthesize fshNdLvBirthsRate2;
//@synthesize fshNdLvBirthsRate3;
//@synthesize fshNdLvBirthsRate4;
//@synthesize fshNdLvBirthsRate5;
//@synthesize fshCi1;
//@synthesize fshCi2;
//@synthesize fshCi3;
//@synthesize fshCi4;
//@synthesize fshCi5;
//@synthesize fshNdRetsRate1;
//@synthesize fshNdRetsRate2;
//@synthesize fshNdRetsRate3;
//@synthesize fshNdRetsRate4;
//@synthesize fshNdRetsRate5;
//@synthesize fshNdTransRate1;
//@synthesize fshNdTransRate2;
//@synthesize fshNdTransRate3;
//@synthesize fshNdTransRate4;
//@synthesize fshNdTransRate5;
//@synthesize fshNdSnglLbTransRate1;
//@synthesize fshNdSnglLbTransRate2;
//@synthesize fshNdSnglLbTransRate3;
//@synthesize fshNdSnglLbTransRate4;
//@synthesize fshNdSnglLbTransRate5;
//@synthesize fshNdCansRate1;
//@synthesize fshNdCansRate2;
//@synthesize fshNdCansRate3;
//@synthesize fshNdCansRate4;
//@synthesize fshNdCansRate5;
//@synthesize fshNdEmbryosRate1;
//@synthesize fshNdEmbryosRate2;
//@synthesize fshNdEmbryosRate3;
//@synthesize fshNdEmbryosRate4;
//@synthesize fshNdEmbryosRate5;
//@synthesize fshNdTwinPregsRate1;
//@synthesize fshNdTwinPregsRate2;
//@synthesize fshNdTwinPregsRate3;
//@synthesize fshNdTwinPregsRate4;
//@synthesize fshNdTwinPregsRate5;
//@synthesize fshNdTripPregsRate1;
//@synthesize fshNdTripPregsRate2;
//@synthesize fshNdTripPregsRate3;
//@synthesize fshNdTripPregsRate4;
//@synthesize fshNdTripPregsRate5;
//@synthesize fshNdMultInfsRate1;
//@synthesize fshNdMultInfsRate2;
//@synthesize fshNdMultInfsRate3;
//@synthesize fshNdMultInfsRate4;
//@synthesize fshNdMultInfsRate5;
//@synthesize thwNdTransfers1;
//@synthesize thwNdTransfers2;
//@synthesize thwNdTransfers3;
//@synthesize thwNdTransfers4;
//@synthesize thwNdTransfers5;
//@synthesize thwNdLvBirthsRate1;
//@synthesize thwNdLvBirthsRate2;
//@synthesize thwNdLvBirthsRate3;
//@synthesize thwNdLvBirthsRate4;
//@synthesize thwNdLvBirthsRate5;
//@synthesize thwNdEmbryosRate1;
//@synthesize thwNdEmbryosRate2;
//@synthesize thwNdEmbryosRate3;
//@synthesize thwNdEmbryosRate4;
//@synthesize thwNdEmbryosRate5;
//@synthesize fshDnrTransfers;
//@synthesize thwDnrTransfers;
//@synthesize fshDnrLvBirthsRate;
//@synthesize thwDnrLvBirthsRate;
//@synthesize fshDnrEmbryosRate;
//@synthesize thwDnrEmbryosRate;
//@synthesize donorEgg;
//@synthesize donorEmbryo;
//@synthesize singleWomen;
//@synthesize surrogates;
//@synthesize cryopreservation;
//@synthesize sartMember;
//@synthesize accreditation;

-(id)init {
    if (self = [super init]) {
        data = [[NSMutableDictionary alloc] initWithCapacity:1];
    }
    
    return self;
}

-(void)dealloc
{
    [data release];
    [year release];
//    [ivfRate release];
//    [giftRate release];
//    [ziftRate release];
//    [comboRate release];
//    [icsiRate release];
//    [unstimulatedRate release];
//    [gestRate release];
//    [pgdRate release];
//    [esetTotal release];
//    [diagTubalRate release];
//    [diagOvulatoryRate release];
//    [diagDorRate release];
//    [diagEndometriosisRate release];
//    [diagUterineRate release];
//    [diagMaleRate release];
//    [diagOtherRate release];
//    [diagUnknownRate release];
//    [diagComboNoMaleRate release];
//    [diagComboMaleRate release];
//    [medicalDirector release];
//    [fshNdCycle1 release];
//    [fshNdCycle2 release];
//    [fshNdCycle3 release];
//    [fshNdCycle4 release];
//    [fshNdCycle5 release];
//    [fshNdImplant1 release];
//    [fshNdImplant2 release];
//    [fshNdImplant3 release];
//    [fshNdImplant4 release];
//    [fshNdImplant5 release];
//    [fshNdPregRate1 release];
//    [fshNdPregRate2 release];
//    [fshNdPregRate3 release];
//    [fshNdPregRate4 release];
//    [fshNdPregRate5 release];
//    [fshNdLvBirthsRate1 release];
//    [fshNdLvBirthsRate2 release];
//    [fshNdLvBirthsRate3 release];
//    [fshNdLvBirthsRate4 release];
//    [fshNdLvBirthsRate5 release];
//    [fshCi1 release];
//    [fshCi2 release];
//    [fshCi3 release];
//    [fshCi4 release];
//    [fshCi5 release];
//    [fshNdRetsRate1 release];
//    [fshNdRetsRate2 release];
//    [fshNdRetsRate3 release];
//    [fshNdRetsRate4 release];
//    [fshNdRetsRate5 release];
//    [fshNdTransRate1 release];
//    [fshNdTransRate2 release];
//    [fshNdTransRate3 release];
//    [fshNdTransRate4 release];
//    [fshNdTransRate5 release];
//    [fshNdSnglLbTransRate1 release];
//    [fshNdSnglLbTransRate2 release];
//    [fshNdSnglLbTransRate3 release];
//    [fshNdSnglLbTransRate4 release];
//    [fshNdSnglLbTransRate5 release];
//    [fshNdCansRate1 release];
//    [fshNdCansRate2 release];
//    [fshNdCansRate3 release];
//    [fshNdCansRate4 release];
//    [fshNdCansRate5 release];
//    [fshNdEmbryosRate1 release];
//    [fshNdEmbryosRate2 release];
//    [fshNdEmbryosRate3 release];
//    [fshNdEmbryosRate4 release];
//    [fshNdEmbryosRate5 release];
//    [fshNdTwinPregsRate1 release];
//    [fshNdTwinPregsRate2 release];
//    [fshNdTwinPregsRate3 release];
//    [fshNdTwinPregsRate4 release];
//    [fshNdTwinPregsRate5 release];
//    [fshNdTripPregsRate1 release];
//    [fshNdTripPregsRate2 release];
//    [fshNdTripPregsRate3 release];
//    [fshNdTripPregsRate4 release];
//    [fshNdTripPregsRate5 release];
//    [fshNdMultInfsRate1 release];
//    [fshNdMultInfsRate2 release];
//    [fshNdMultInfsRate3 release];
//    [fshNdMultInfsRate4 release];
//    [fshNdMultInfsRate5 release];
//    [thwNdTransfers1 release];
//    [thwNdTransfers2 release];
//    [thwNdTransfers3 release];
//    [thwNdTransfers4 release];
//    [thwNdTransfers5 release];
//    [thwNdLvBirthsRate1 release];
//    [thwNdLvBirthsRate2 release];
//    [thwNdLvBirthsRate3 release];
//    [thwNdLvBirthsRate4 release];
//    [thwNdLvBirthsRate5 release];
//    [thwNdEmbryosRate1 release];
//    [thwNdEmbryosRate2 release];
//    [thwNdEmbryosRate3 release];
//    [thwNdEmbryosRate4 release];
//    [thwNdEmbryosRate5 release];
//    [fshDnrTransfers release];
//    [thwDnrTransfers release];
//    [fshDnrLvBirthsRate release];
//    [thwDnrLvBirthsRate release];
//    [fshDnrEmbryosRate release];
//    [thwDnrEmbryosRate release];
//    [donorEgg release];
//    [donorEmbryo release];
//    [singleWomen release];
//    [surrogates release];
//    [cryopreservation release];
//    [sartMember release];
//    [accreditation release];
    
    [super dealloc];
}

@end
