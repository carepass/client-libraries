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

#import <Foundation/Foundation.h>

/** Represents the Year portion of the response body from a HHS ART Search response
 *
 * \ingroup HHS
 */
@interface HHSARTSearchYearResult : NSObject {
    NSMutableDictionary *data;
    NSString *year;
//    NSString *ivfRate;
//    NSString *giftRate;
//    NSString *ziftRate;
//    NSString *comboRate;
//    NSString *icsiRate;
//    NSString *unstimulatedRate;
//    NSString *gestRate;
//    NSString *pgdRate;
//    NSString *esetTotal;
//    NSString *diagTubalRate;
//    NSString *diagOvulatoryRate;
//    NSString *diagDorRate;
//    NSString *diagEndometriosisRate;
//    NSString *diagUterineRate;
//    NSString *diagMaleRate;
//    NSString *diagOtherRate;
//    NSString *diagUnknownRate;
//    NSString *diagComboNoMaleRate;
//    NSString *diagComboMaleRate;
//    NSString *medicalDirector;
//    NSString *fshNdCycle1;
//    NSString *fshNdCycle2;
//    NSString *fshNdCycle3;
//    NSString *fshNdCycle4;
//    NSString *fshNdCycle5;
//    NSString *fshNdImplant1;
//    NSString *fshNdImplant2;
//    NSString *fshNdImplant3;
//    NSString *fshNdImplant4;
//    NSString *fshNdImplant5;
//    NSString *fshNdPregRate1;
//    NSString *fshNdPregRate2;
//    NSString *fshNdPregRate3;
//    NSString *fshNdPregRate4;
//    NSString *fshNdPregRate5;
//    NSString *fshNdLvBirthsRate1;
//    NSString *fshNdLvBirthsRate2;
//    NSString *fshNdLvBirthsRate3;
//    NSString *fshNdLvBirthsRate4;
//    NSString *fshNdLvBirthsRate5;
//    NSString *fshCi1;
//    NSString *fshCi2;
//    NSString *fshCi3;
//    NSString *fshCi4;
//    NSString *fshCi5;
//    NSString *fshNdRetsRate1;
//    NSString *fshNdRetsRate2;
//    NSString *fshNdRetsRate3;
//    NSString *fshNdRetsRate4;
//    NSString *fshNdRetsRate5;
//    NSString *fshNdTransRate1;
//    NSString *fshNdTransRate2;
//    NSString *fshNdTransRate3;
//    NSString *fshNdTransRate4;
//    NSString *fshNdTransRate5;
//    NSString *fshNdSnglLbTransRate1;
//    NSString *fshNdSnglLbTransRate2;
//    NSString *fshNdSnglLbTransRate3;
//    NSString *fshNdSnglLbTransRate4;
//    NSString *fshNdSnglLbTransRate5;
//    NSString *fshNdCansRate1;
//    NSString *fshNdCansRate2;
//    NSString *fshNdCansRate3;
//    NSString *fshNdCansRate4;
//    NSString *fshNdCansRate5;
//    NSString *fshNdEmbryosRate1;
//    NSString *fshNdEmbryosRate2;
//    NSString *fshNdEmbryosRate3;
//    NSString *fshNdEmbryosRate4;
//    NSString *fshNdEmbryosRate5;
//    NSString *fshNdTwinPregsRate1;
//    NSString *fshNdTwinPregsRate2;
//    NSString *fshNdTwinPregsRate3;
//    NSString *fshNdTwinPregsRate4;
//    NSString *fshNdTwinPregsRate5;
//    NSString *fshNdTripPregsRate1;
//    NSString *fshNdTripPregsRate2;
//    NSString *fshNdTripPregsRate3;
//    NSString *fshNdTripPregsRate4;
//    NSString *fshNdTripPregsRate5;
//    NSString *fshNdMultInfsRate1;
//    NSString *fshNdMultInfsRate2;
//    NSString *fshNdMultInfsRate3;
//    NSString *fshNdMultInfsRate4;
//    NSString *fshNdMultInfsRate5;
//    NSString *thwNdTransfers1;
//    NSString *thwNdTransfers2;
//    NSString *thwNdTransfers3;
//    NSString *thwNdTransfers4;
//    NSString *thwNdTransfers5;
//    NSString *thwNdLvBirthsRate1;
//    NSString *thwNdLvBirthsRate2;
//    NSString *thwNdLvBirthsRate3;
//    NSString *thwNdLvBirthsRate4;
//    NSString *thwNdLvBirthsRate5;
//    NSString *thwNdEmbryosRate1;
//    NSString *thwNdEmbryosRate2;
//    NSString *thwNdEmbryosRate3;
//    NSString *thwNdEmbryosRate4;
//    NSString *thwNdEmbryosRate5;
//    NSString *fshDnrTransfers;
//    NSString *thwDnrTransfers;
//    NSString *fshDnrLvBirthsRate;
//    NSString *thwDnrLvBirthsRate;
//    NSString *fshDnrEmbryosRate;
//    NSString *thwDnrEmbryosRate;
//    NSString *donorEgg;
//    NSString *donorEmbryo;
//    NSString *singleWomen;
//    NSString *surrogates;
//    NSString *cryopreservation;
//    NSString *sartMember;
//    NSString *accreditation;
}

/** Gets and sets the lastModified property */
@property (nonatomic, retain) NSMutableDictionary *data;
@property (nonatomic, retain) NSString *year;
//@property (nonatomic, retain) NSString *ivfRate;
//@property (nonatomic, retain) NSString *giftRate;
//@property (nonatomic, retain) NSString *ziftRate;
//@property (nonatomic, retain) NSString *comboRate;
//@property (nonatomic, retain) NSString *icsiRate;
//@property (nonatomic, retain) NSString *unstimulatedRate;
//@property (nonatomic, retain) NSString *gestRate;
//@property (nonatomic, retain) NSString *pgdRate;
//@property (nonatomic, retain) NSString *esetTotal;
//@property (nonatomic, retain) NSString *diagTubalRate;
//@property (nonatomic, retain) NSString *diagOvulatoryRate;
//@property (nonatomic, retain) NSString *diagDorRate;
//@property (nonatomic, retain) NSString *diagEndometriosisRate;
//@property (nonatomic, retain) NSString *diagUterineRate;
//@property (nonatomic, retain) NSString *diagMaleRate;
//@property (nonatomic, retain) NSString *diagOtherRate;
//@property (nonatomic, retain) NSString *diagUnknownRate;
//@property (nonatomic, retain) NSString *diagComboNoMaleRate;
//@property (nonatomic, retain) NSString *diagComboMaleRate;
//@property (nonatomic, retain) NSString *medicalDirector;
//@property (nonatomic, retain) NSString *fshNdCycle1;
//@property (nonatomic, retain) NSString *fshNdCycle2;
//@property (nonatomic, retain) NSString *fshNdCycle3;
//@property (nonatomic, retain) NSString *fshNdCycle4;
//@property (nonatomic, retain) NSString *fshNdCycle5;
//@property (nonatomic, retain) NSString *fshNdImplant1;
//@property (nonatomic, retain) NSString *fshNdImplant2;
//@property (nonatomic, retain) NSString *fshNdImplant3;
//@property (nonatomic, retain) NSString *fshNdImplant4;
//@property (nonatomic, retain) NSString *fshNdImplant5;
//@property (nonatomic, retain) NSString *fshNdPregRate1;
//@property (nonatomic, retain) NSString *fshNdPregRate2;
//@property (nonatomic, retain) NSString *fshNdPregRate3;
//@property (nonatomic, retain) NSString *fshNdPregRate4;
//@property (nonatomic, retain) NSString *fshNdPregRate5;
//@property (nonatomic, retain) NSString *fshNdLvBirthsRate1;
//@property (nonatomic, retain) NSString *fshNdLvBirthsRate2;
//@property (nonatomic, retain) NSString *fshNdLvBirthsRate3;
//@property (nonatomic, retain) NSString *fshNdLvBirthsRate4;
//@property (nonatomic, retain) NSString *fshNdLvBirthsRate5;
//@property (nonatomic, retain) NSString *fshCi1;
//@property (nonatomic, retain) NSString *fshCi2;
//@property (nonatomic, retain) NSString *fshCi3;
//@property (nonatomic, retain) NSString *fshCi4;
//@property (nonatomic, retain) NSString *fshCi5;
//@property (nonatomic, retain) NSString *fshNdRetsRate1;
//@property (nonatomic, retain) NSString *fshNdRetsRate2;
//@property (nonatomic, retain) NSString *fshNdRetsRate3;
//@property (nonatomic, retain) NSString *fshNdRetsRate4;
//@property (nonatomic, retain) NSString *fshNdRetsRate5;
//@property (nonatomic, retain) NSString *fshNdTransRate1;
//@property (nonatomic, retain) NSString *fshNdTransRate2;
//@property (nonatomic, retain) NSString *fshNdTransRate3;
//@property (nonatomic, retain) NSString *fshNdTransRate4;
//@property (nonatomic, retain) NSString *fshNdTransRate5;
//@property (nonatomic, retain) NSString *fshNdSnglLbTransRate1;
//@property (nonatomic, retain) NSString *fshNdSnglLbTransRate2;
//@property (nonatomic, retain) NSString *fshNdSnglLbTransRate3;
//@property (nonatomic, retain) NSString *fshNdSnglLbTransRate4;
//@property (nonatomic, retain) NSString *fshNdSnglLbTransRate5;
//@property (nonatomic, retain) NSString *fshNdCansRate1;
//@property (nonatomic, retain) NSString *fshNdCansRate2;
//@property (nonatomic, retain) NSString *fshNdCansRate3;
//@property (nonatomic, retain) NSString *fshNdCansRate4;
//@property (nonatomic, retain) NSString *fshNdCansRate5;
//@property (nonatomic, retain) NSString *fshNdEmbryosRate1;
//@property (nonatomic, retain) NSString *fshNdEmbryosRate2;
//@property (nonatomic, retain) NSString *fshNdEmbryosRate3;
//@property (nonatomic, retain) NSString *fshNdEmbryosRate4;
//@property (nonatomic, retain) NSString *fshNdEmbryosRate5;
//@property (nonatomic, retain) NSString *fshNdTwinPregsRate1;
//@property (nonatomic, retain) NSString *fshNdTwinPregsRate2;
//@property (nonatomic, retain) NSString *fshNdTwinPregsRate3;
//@property (nonatomic, retain) NSString *fshNdTwinPregsRate4;
//@property (nonatomic, retain) NSString *fshNdTwinPregsRate5;
//@property (nonatomic, retain) NSString *fshNdTripPregsRate1;
//@property (nonatomic, retain) NSString *fshNdTripPregsRate2;
//@property (nonatomic, retain) NSString *fshNdTripPregsRate3;
//@property (nonatomic, retain) NSString *fshNdTripPregsRate4;
//@property (nonatomic, retain) NSString *fshNdTripPregsRate5;
//@property (nonatomic, retain) NSString *fshNdMultInfsRate1;
//@property (nonatomic, retain) NSString *fshNdMultInfsRate2;
//@property (nonatomic, retain) NSString *fshNdMultInfsRate3;
//@property (nonatomic, retain) NSString *fshNdMultInfsRate4;
//@property (nonatomic, retain) NSString *fshNdMultInfsRate5;
//@property (nonatomic, retain) NSString *thwNdTransfers1;
//@property (nonatomic, retain) NSString *thwNdTransfers2;
//@property (nonatomic, retain) NSString *thwNdTransfers3;
//@property (nonatomic, retain) NSString *thwNdTransfers4;
//@property (nonatomic, retain) NSString *thwNdTransfers5;
//@property (nonatomic, retain) NSString *thwNdLvBirthsRate1;
//@property (nonatomic, retain) NSString *thwNdLvBirthsRate2;
//@property (nonatomic, retain) NSString *thwNdLvBirthsRate3;
//@property (nonatomic, retain) NSString *thwNdLvBirthsRate4;
//@property (nonatomic, retain) NSString *thwNdLvBirthsRate5;
//@property (nonatomic, retain) NSString *thwNdEmbryosRate1;
//@property (nonatomic, retain) NSString *thwNdEmbryosRate2;
//@property (nonatomic, retain) NSString *thwNdEmbryosRate3;
//@property (nonatomic, retain) NSString *thwNdEmbryosRate4;
//@property (nonatomic, retain) NSString *thwNdEmbryosRate5;
//@property (nonatomic, retain) NSString *fshDnrTransfers;
//@property (nonatomic, retain) NSString *thwDnrTransfers;
//@property (nonatomic, retain) NSString *fshDnrLvBirthsRate;
//@property (nonatomic, retain) NSString *thwDnrLvBirthsRate;
//@property (nonatomic, retain) NSString *fshDnrEmbryosRate;
//@property (nonatomic, retain) NSString *thwDnrEmbryosRate;
//@property (nonatomic, retain) NSString *donorEgg;
//@property (nonatomic, retain) NSString *donorEmbryo;
//@property (nonatomic, retain) NSString *singleWomen;
//@property (nonatomic, retain) NSString *surrogates;
//@property (nonatomic, retain) NSString *cryopreservation;
//@property (nonatomic, retain) NSString *sartMember;
//@property (nonatomic, retain) NSString *accreditation;

@end
