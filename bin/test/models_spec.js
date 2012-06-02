describe("Affected Area", function() {
    var HEAD_REGION = 0;
	var TRUNK_REGION = 2;
	var ARM_REGION = 1;
	var LEG_REGION = 3;	
	var affectedArea;
	beforeEach(function () {
	  //reset affectedArea for each test
      affectedArea = new BodyAtlas.UI.Model.AffectedArea();
    });
	
	describe("Add plaque method", function(){
	    it("should add a plaque only once", function() {
	       var x = 1;
	       var y = 2;
	       var severity = 3; 
	       affectedArea.addPlaque(x,y,severity,HEAD_REGION)//add plaque once
	       expect(affectedArea.length).toEqual(1);
	       affectedArea.addPlaque(x,y,severity,HEAD_REGION) //attempt to add same plaque
	       expect(affectedArea.length).toEqual(1);
	       
	    });
	    it("should add a plaque only once but update the severity if different", function() {
	       var x = 1;
	       var y = 2;
	       var initialSeverity = 1; 
	       var updatedSeverity = 2;
	       affectedArea.addPlaque(x,y,initialSeverity,HEAD_REGION)
	       expect(affectedArea.length).toEqual(1);//plaque added sucessfully
	       affectedArea.addPlaque(x,y,updatedSeverity,HEAD_REGION);
	       expect(affectedArea.length).toEqual(1); //still only one plaque
	       expect(affectedArea.at(0).get('severity')).toEqual(updatedSeverity); //plaque updated successfully
	       //check that other values remain
	       expect(affectedArea.at(0).get('x')).toEqual(x); 
	       expect(affectedArea.at(0).get('y')).toEqual(y);
	       
	       
	    });
	});
	
	describe("getCoverageData method", function(){
	    it("getCoverageData should return the correct data when a plaque is added to the head", function() {	
           var x1 = 1; var y1 = 2;var s1 = 2;        
	       	   	   	  
	       var updatedSeverity = 2;	
	       affectedArea.addPlaque(x1,y1,s1,HEAD_REGION);
	       var coveragedata = affectedArea.getCoverageData();
	       //head should be updated
	       expect(coveragedata.head.plaqueCount).toEqual(1);	   
	       expect(coveragedata.head.severities).toEqual([s1]);
	       
	       //everything esle should be empty
	       expect(coveragedata.trunk.plaqueCount).toEqual(0);
	       expect(coveragedata.legs.plaqueCount).toEqual(0);
	       expect(coveragedata.arms.plaqueCount).toEqual(0);	   
	       expect(coveragedata.trunk.severities).toEqual([]);
	       expect(coveragedata.legs.severities).toEqual([]);
	       expect(coveragedata.arms.severities).toEqual([]);	      
	    });
	    
	    it("getCoverageData should return the correct data when a plaque is added to the body", function() {	       
           var x2 = 12;var y2 = 2;var s2 = 1;        
	       	   	   	  
	       var updatedSeverity = 2;	
	       affectedArea.addPlaque(x2,y2,s2,TRUNK_REGION);
	       var coveragedata = affectedArea.getCoverageData();
	       //trunk should be updated
	       expect(coveragedata.trunk.plaqueCount).toEqual(1);	   
	       expect(coveragedata.trunk.severities).toEqual([s2]);
	       
	       //everything esle should be empty
	       expect(coveragedata.head.plaqueCount).toEqual(0);
	       expect(coveragedata.legs.plaqueCount).toEqual(0);
	       expect(coveragedata.arms.plaqueCount).toEqual(0);	   
	       expect(coveragedata.head.severities).toEqual([]);
	       expect(coveragedata.legs.severities).toEqual([]);
	       expect(coveragedata.arms.severities).toEqual([]);	   	  
	    });
	    
	    it("getCoverageData should return the correct data when a plaque is added to the arms", function() {	
           var x1 = 1; var y1 = 2;var s1 = 2; 
           var x2 = 12;var y2 = 2;var s2 = 1; 
           var x3 = 23;var y3 = 41;var s3 = 3; 
           var x4 = 15;var y4 = 21;var s4 = 2; 
           var x5 = 11;var y5 = 22;var s5 = 3; 
           var x6 = 11;var y6 = 22;var s6 = 3; 
           var x7 = 11;var y7 = 22;var s7 = 4; 
	       	   	   	  
	       var updatedSeverity = 2;	
	       affectedArea.addPlaque(x3,y3,s3,ARM_REGION);
	       var coveragedata = affectedArea.getCoverageData();
	       //arms should be updated
	       expect(coveragedata.arms.plaqueCount).toEqual(1);	   
	       expect(coveragedata.arms.severities).toEqual([s3]);
	       
	       //everything esle should be empty
	       expect(coveragedata.head.plaqueCount).toEqual(0);
	       expect(coveragedata.legs.plaqueCount).toEqual(0);
	       expect(coveragedata.trunk.plaqueCount).toEqual(0);	   
	       expect(coveragedata.head.severities).toEqual([]);
	       expect(coveragedata.legs.severities).toEqual([]);
	       expect(coveragedata.trunk.severities).toEqual([]);
	       expect(coveragedata.head.severities).toEqual([]);	   
	    });
	    
	    
	    it("getCoverageData should return the correct data when a plaque is added to the legs", function() {	
           var x1 = 1; var y1 = 2;var s1 = 2; 
           var x2 = 12;var y2 = 2;var s2 = 1; 
           var x3 = 23;var y3 = 41;var s3 = 3; 
           var x4 = 15;var y4 = 21;var s4 = 2; 
           var x5 = 11;var y5 = 22;var s5 = 3; 
           var x6 = 11;var y6 = 22;var s6 = 3; 
           var x7 = 11;var y7 = 22;var s7 = 4; 
	       	   	   	  
	       var updatedSeverity = 2;	
	       affectedArea.addPlaque(x3,y3,s3,LEG_REGION);
	       var coveragedata = affectedArea.getCoverageData();
	       //legs should be updated
	       expect(coveragedata.legs.plaqueCount).toEqual(1);	   
	       expect(coveragedata.legs.severities).toEqual([s3]);
	       
	       //everything esle should be empty
	       expect(coveragedata.head.plaqueCount).toEqual(0);
	       expect(coveragedata.arms.plaqueCount).toEqual(0);
	       expect(coveragedata.trunk.plaqueCount).toEqual(0);	   
	       expect(coveragedata.head.severities).toEqual([]);
	       expect(coveragedata.arms.severities).toEqual([]);
	       expect(coveragedata.trunk.severities).toEqual([]);	      
	    });
	    
	    it("getCoverageData should return the correct data for legs when a plaque is added to the multiple parts of the body", function() {	
           var x1 = 1; var y1 = 2;var s1 = 2; 
           var x2 = 12;var y2 = 2;var s2 = 1; 
           var x3 = 23;var y3 = 41;var s3 = 3; 
           var x4 = 15;var y4 = 21;var s4 = 2; 
           var x5 = 11;var y5 = 22;var s5 = 3; 
           var x6 = 51;var y6 = 6;var s6 = 3; 
           var x7 = 33;var y7 = 62;var s7 = 4; 
	       	   	   	  
	       var updatedSeverity = 2;	
	       affectedArea.addPlaque(x1,y1,s1,LEG_REGION);
	       affectedArea.addPlaque(x2,y2,s2,ARM_REGION);
	       affectedArea.addPlaque(x3,y3,s3,HEAD_REGION);
	       affectedArea.addPlaque(x4,y4,s4,HEAD_REGION);
	       affectedArea.addPlaque(x5,y5,s5,TRUNK_REGION);
	       affectedArea.addPlaque(x6,y6,s6,HEAD_REGION);
	       affectedArea.addPlaque(x7,y7,s7,ARM_REGION);
	       var coveragedata = affectedArea.getCoverageData();
	       
	       //legs should be updated
	       expect(coveragedata.legs.plaqueCount).toEqual(1);	   
	       expect(coveragedata.legs.severities).toEqual([s1]);
	     });
	    
	    it("getCoverageData should return the correct data for arms when a plaque is added to the multiple parts of the body", function() {	
           var x1 = 1; var y1 = 2;var s1 = 2; 
           var x2 = 12;var y2 = 2;var s2 = 1; 
           var x3 = 23;var y3 = 41;var s3 = 3; 
           var x4 = 15;var y4 = 21;var s4 = 2; 
           var x5 = 11;var y5 = 22;var s5 = 3; 
           var x6 = 51;var y6 = 6;var s6 = 3; 
           var x7 = 33;var y7 = 62;var s7 = 4; 
	       	   	   	  
	       var updatedSeverity = 2;	
	       affectedArea.addPlaque(x1,y1,s1,LEG_REGION);
	       affectedArea.addPlaque(x2,y2,s2,ARM_REGION);
	       affectedArea.addPlaque(x3,y3,s3,HEAD_REGION);
	       affectedArea.addPlaque(x4,y4,s4,HEAD_REGION);
	       affectedArea.addPlaque(x5,y5,s5,TRUNK_REGION);
	       affectedArea.addPlaque(x6,y6,s6,HEAD_REGION);
	       affectedArea.addPlaque(x7,y7,s7,ARM_REGION);
	       var coveragedata = affectedArea.getCoverageData();
	       
	       //arms should be updated
	       expect(coveragedata.arms.plaqueCount).toEqual(2);	   	   	   
	       expect(coveragedata.arms.severities).toEqual([s2, s7]);   
	       
	    });
	    it("getCoverageData should return the correct data for head when a plaque is added to the multiple parts of the body", function() {	
           var x1 = 1; var y1 = 2;var s1 = 2; 
           var x2 = 12;var y2 = 2;var s2 = 1; 
           var x3 = 23;var y3 = 41;var s3 = 3; 
           var x4 = 15;var y4 = 21;var s4 = 2; 
           var x5 = 11;var y5 = 22;var s5 = 3; 
           var x6 = 51;var y6 = 6;var s6 = 3; 
           var x7 = 33;var y7 = 62;var s7 = 4; 
	       	   	   	  
	       var updatedSeverity = 2;	
	       affectedArea.addPlaque(x1,y1,s1,LEG_REGION);
	       affectedArea.addPlaque(x2,y2,s2,ARM_REGION);
	       affectedArea.addPlaque(x3,y3,s3,HEAD_REGION);
	       affectedArea.addPlaque(x4,y4,s4,HEAD_REGION);
	       affectedArea.addPlaque(x5,y5,s5,TRUNK_REGION);
	       affectedArea.addPlaque(x6,y6,s6,HEAD_REGION);
	       affectedArea.addPlaque(x7,y7,s7,ARM_REGION);
	       var coveragedata = affectedArea.getCoverageData();
	      
	       //head should be updated
	       expect(coveragedata.head.plaqueCount).toEqual(3);	   
	       expect(coveragedata.head.severities).toEqual([s3, s4, s6]);	   	   	   
	    });
	    
        
	    it("getCoverageData should return the correct data for trunk when a plaque is added to the multiple parts of the body", function() {
           var x1 = 1; var y1 = 2;var s1 = 2; 
           var x2 = 12;var y2 = 2;var s2 = 1; 
           var x3 = 23;var y3 = 41;var s3 = 3; 
           var x4 = 15;var y4 = 21;var s4 = 2; 
           var x5 = 11;var y5 = 22;var s5 = 3; 
           var x6 = 51;var y6 = 6;var s6 = 3; 
           var x7 = 33;var y7 = 62;var s7 = 4; 
	       	   	   	  
	       var updatedSeverity = 2;	
	       affectedArea.addPlaque(x1,y1,s1,LEG_REGION);
	       affectedArea.addPlaque(x2,y2,s2,ARM_REGION);
	       affectedArea.addPlaque(x3,y3,s3,HEAD_REGION);
	       affectedArea.addPlaque(x4,y4,s4,HEAD_REGION);
	       affectedArea.addPlaque(x5,y5,s5,TRUNK_REGION);
	       affectedArea.addPlaque(x6,y6,s6,HEAD_REGION);
	       affectedArea.addPlaque(x7,y7,s7,ARM_REGION);
	       var coveragedata = affectedArea.getCoverageData();
	       
	       //trunk should be updated
	       expect(coveragedata.trunk.plaqueCount).toEqual(1);	   
	       expect(coveragedata.trunk.severities).toEqual([s5]);	    
	    });
	});
	
	describe("increasePlaqueAt method", function(){
	    it("should add a new plaque to the affected area when increase is calls at a position that is not already in the affected area", function(){
	           var x1 = 1; var y1 = 2;var s1 = 2; 	     
	           
	           affectedArea.increasePlaqueAt(x1, y1, LEG_REGION);
	           addedPlaque = affectedArea.at(0);
	           expect(addedPlaque.get("x")).toEqual(x1);
	           expect(addedPlaque.get("y")).toEqual(y1);
	           expect(addedPlaque.get("severity")).toEqual(1);
	           expect(addedPlaque.get("bodyLocation")).toEqual(LEG_REGION);	       
	    });
	    
	    it("should increase the severity of a plaque when increase is applied", function(){
	           var x1 = 1; var y1 = 2;var s1 = 1; 
	           var x2 = 12;var y2 = 2;var s2 = 2; 
	           var x3 = 23;var y3 = 41;var s3 = 3; 
	           var x4 = 15;var y4 = 21;var s4 = 4; 
	           var x5 = 11;var y5 = 22;var s5 = 5; 
	           var x6 = 51;var y6 = 6;var s6 = 3; 
	           var x7 = 33;var y7 = 62;var s7 = 4;
	           
        
	    	   plaque1 = affectedArea.addPlaque(x1,y1,s1,LEG_REGION);
	    	   plaque2 = affectedArea.addPlaque(x2,y2,s2,ARM_REGION);
	    	   plaque3 = affectedArea.addPlaque(x3,y3,s3,HEAD_REGION);
	    	   plaque4 = affectedArea.addPlaque(x4,y4,s4,HEAD_REGION);
	    	   plaque5 = affectedArea.addPlaque(x5,y5,s5,TRUNK_REGION);
	    	   plaque6 = affectedArea.addPlaque(x6,y6,s6,HEAD_REGION);		   
	    	   
	           affectedArea.increasePlaqueAt(x1, y1, LEG_REGION);
	    	   affectedArea.increasePlaqueAt(x2,y2,s2,ARM_REGION);
	    	   affectedArea.increasePlaqueAt(x3,y3,s3,HEAD_REGION);
	    	   affectedArea.increasePlaqueAt(x4,y4,s4,HEAD_REGION);
	    	   affectedArea.increasePlaqueAt(x5,y5,s5,TRUNK_REGION);
	    	   affectedArea.increasePlaqueAt(x6,y6,s6,LEG_REGION);	//region is different	   
	    	   
	    	   //sev 1 case
	           expect(plaque1.get("x")).toEqual(x1);
	           expect(plaque1.get("y")).toEqual(y1);
	           expect(plaque1.get("severity")).toEqual(s1 + 1);
	           expect(plaque1.get("bodyLocation")).toEqual(LEG_REGION);	     
	           	       
	    	   //sev 2 case
	           expect(plaque2.get("x")).toEqual(x2);
	           expect(plaque2.get("y")).toEqual(y2);
	           expect(plaque2.get("severity")).toEqual(s2 + 1);
	           expect(plaque2.get("bodyLocation")).toEqual(ARM_REGION);	  
	           	      
	    	   //sev 3 case
	           expect(plaque3.get("x")).toEqual(x3);
	           expect(plaque3.get("y")).toEqual(y3);
	           expect(plaque3.get("severity")).toEqual(s3 + 1);
	           expect(plaque3.get("bodyLocation")).toEqual(HEAD_REGION);
	           	      
	    	   //sev 4 case
	           expect(plaque4.get("x")).toEqual(x4);
	           expect(plaque4.get("y")).toEqual(y4);
	           expect(plaque4.get("severity")).toEqual(s4 + 1);
	           expect(plaque4.get("bodyLocation")).toEqual(HEAD_REGION);
	           	 
        	   //sev 5 case	       
	           expect(plaque5.get("x")).toEqual(x5);
	           expect(plaque5.get("y")).toEqual(y5);
	           expect(plaque5.get("severity")).toEqual(s5 + 1);
	           expect(plaque5.get("bodyLocation")).toEqual(TRUNK_REGION);
	           
	         //original region remains despite a different region being passed in increase. the region is used only for new plaques
	           expect(plaque6.get("x")).toEqual(x6);
	           expect(plaque6.get("y")).toEqual(y6);
	           expect(plaque6.get("severity")).toEqual(s6 + 1);
	           expect(plaque6.get("bodyLocation")).toEqual(HEAD_REGION);	      
	    });
	    
	    it("should do nothing when increase is applied to an plaque with severity 6", function(){ 		
           var x1 = 12;var y1 = 2;var s1 = 6; 
        
	       plaque1 = affectedArea.addPlaque(x1,y1,s1,LEG_REGION); 
	       
           affectedArea.increasePlaqueAt(x1, y1, LEG_REGION);
	         	   
	       //sev 6 case
           expect(plaque1.get("x")).toEqual(x1);
           expect(plaque1.get("y")).toEqual(y1);
           expect(plaque1.get("severity")).toEqual(s1);
           expect(plaque1.get("severity")).toEqual(6);
           expect(plaque1.get("bodyLocation")).toEqual(LEG_REGION);	 
	    	
	    });
	    
	    it("increase should be applied once provided that the flag is not cleared", function(){ 	
	           var x1 = 12;var y1 = 2;var s1 = 2; 
	           
	    	   plaque1 = affectedArea.addPlaque(x1,y1,s1,LEG_REGION); 
	    	   
	    	   //increase applied 5 times
	           affectedArea.increasePlaqueAt(x1, y1, LEG_REGION);		     	   		   	       
	           affectedArea.increasePlaqueAt(x1, y1, LEG_REGION);
	           affectedArea.increasePlaqueAt(x1, y1, LEG_REGION);		     	   
	           affectedArea.increasePlaqueAt(x1, y1, LEG_REGION);		     	   
	           affectedArea.increasePlaqueAt(x1, y1, LEG_REGION);		     	   		     	   
	           
	           expect(plaque1.get("x")).toEqual(x1);
	           expect(plaque1.get("y")).toEqual(y1);
	           
	           //expect and increase of only one
	           expect(plaque1.get("severity")).toEqual(s1 + 1);	       
	           expect(plaque1.get("bodyLocation")).toEqual(LEG_REGION);	 
	      
	    });
        
	    it("increase should be applied again if the flag has been cleared", function(){ 		
	           var x1 = 12;var y1 = 2;var s1 = 2; 
	           
	    	   plaque1 = affectedArea.addPlaque(x1,y1,s1,LEG_REGION); 
	    	   
	    	   //increase applied 3 times before flag is cleared
	           affectedArea.increasePlaqueAt(x1, y1, LEG_REGION);		     	   		   	       
	           affectedArea.increasePlaqueAt(x1, y1, LEG_REGION);
	           affectedArea.increasePlaqueAt(x1, y1, LEG_REGION);	
	           
	           plaque1.clearFlag(); //flag is cleared
	           
	           //increase applied 2 times
	           affectedArea.increasePlaqueAt(x1, y1, LEG_REGION);		     	   
	           affectedArea.increasePlaqueAt(x1, y1, LEG_REGION);		     	   		     	   
	           
	           expect(plaque1.get("x")).toEqual(x1);
	           expect(plaque1.get("y")).toEqual(y1);
	           
	           //expect and increase of only one
	           expect(plaque1.get("severity")).toEqual(s1 + 2);//should increase only two times	       
	           expect(plaque1.get("bodyLocation")).toEqual(LEG_REGION);	 
	    	
	    });
	});	
	
	describe("removePlaqueAt method", function(){
	    it("remove should remove plaque from the affectedArea", function(){ 	
	           var x1 = 1; var y1 = 2;var s1 = 1; 
	           var x2 = 12;var y2 = 2;var s2 = 2; 
	           var x3 = 23;var y3 = 41;var s3 = 3; 
	           var x4 = 15;var y4 = 21;var s4 = 4; 
	           var x5 = 11;var y5 = 22;var s5 = 5; 
	           var x6 = 51;var y6 = 6;var s6 = 3; 
	           var x7 = 33;var y7 = 62;var s7 = 4;
	           
               //add 6 plaques
	    	   plaque1 = affectedArea.addPlaque(x1,y1,s1,LEG_REGION);
	    	   plaque2 = affectedArea.addPlaque(x2,y2,s2,ARM_REGION);
	    	   plaque3 = affectedArea.addPlaque(x3,y3,s3,HEAD_REGION);
	    	   plaque4 = affectedArea.addPlaque(x4,y4,s4,HEAD_REGION);
	    	   plaque5 = affectedArea.addPlaque(x5,y5,s5,TRUNK_REGION);
	    	   plaque6 = affectedArea.addPlaque(x6,y6,s6,HEAD_REGION);				   
	    	   var stateAfterAllPlaquesAdded = affectedArea.length;		
	    	   
	    	   //remove each plaque and check the state after each remove
	           affectedArea.removePlaqueAt(x1, y1);
	           var stateAfter1stPlaqueRemoved = affectedArea.length;
	           
	    	   affectedArea.removePlaqueAt(x2,y2,s2);
	    	   var stateAfter2ndPlaqueRemoved = affectedArea.length;
	    	   
	    	   affectedArea.removePlaqueAt(x3,y3,s3);
	    	   var stateAfter3rdPlaqueRemoved = affectedArea.length;
	    	   
	    	   affectedArea.removePlaqueAt(x4,y4,s4);
	    	   var stateAfter4thPlaqueRemoved = affectedArea.length;
	    	   
	    	   affectedArea.removePlaqueAt(x5,y5,s5);
	    	   var stateAfter5thPlaqueRemoved = affectedArea.length;
	    	   
	    	   affectedArea.removePlaqueAt(x6,y6,s6);
	    	   var stateAfter6thPlaqueRemoved = affectedArea.length;
	    	   
	    	   //check that the states are all expected.
	    	   expect(stateAfterAllPlaquesAdded).toEqual(6);
	    	   expect(stateAfter1stPlaqueRemoved).toEqual(5);
	    	   expect(stateAfter2ndPlaqueRemoved).toEqual(4);
	    	   expect(stateAfter3rdPlaqueRemoved).toEqual(3);
	    	   expect(stateAfter4thPlaqueRemoved).toEqual(2);
	    	   expect(stateAfter5thPlaqueRemoved).toEqual(1);
	    	   expect(stateAfter6thPlaqueRemoved).toEqual(0);
	    });
	    

	    it("remove should only remove the plaque if it exists", function(){ 	
	           var x1 = 1; var y1 = 2;var s1 = 1; 
	           var x2 = 12;var y2 = 2;var s2 = 2; 
	           var x3 = 23;var y3 = 41;var s3 = 3; 
	           var x4 = 15;var y4 = 21;var s4 = 4; 
	           var x5 = 11;var y5 = 22;var s5 = 5; 
	           var x6 = 51;var y6 = 6;var s6 = 3; 
	           var x7 = 33;var y7 = 62;var s7 = 4;
	           
        
	    	   plaque1 = affectedArea.addPlaque(x1,y1,s1,LEG_REGION);
	    	   plaque2 = affectedArea.addPlaque(x2,y2,s2,ARM_REGION);
	    	   plaque3 = affectedArea.addPlaque(x3,y3,s3,HEAD_REGION);	    	   
	    	   plaque5 = affectedArea.addPlaque(x5,y5,s5,TRUNK_REGION);
	    	   plaque6 = affectedArea.addPlaque(x6,y6,s6,HEAD_REGION);	
			   
			   expect(affectedArea.length).toEqual(5);
	           affectedArea.removePlaqueAt(x1, y1);
	           expect(affectedArea.length).toEqual(4);
	    	   affectedArea.removePlaqueAt(x2,y2);
	    	   expect(affectedArea.length).toEqual(3);
	    	   
	    	   //attempt to remove a plaque that already has been removed
	    	   affectedArea.removePlaqueAt(x2,y2);
	    	   expect(affectedArea.length).toEqual(3);
	    	   
	    	   //attempt to remove a plaque that was never added
	    	   affectedArea.removePlaqueAt(x4,y4);
	    	   expect(affectedArea.length).toEqual(3);
	    	   
	    	   affectedArea.removePlaqueAt(x5,y5);
	    	   expect(affectedArea.length).toEqual(2);
	    	   affectedArea.removePlaqueAt(x6,y6);	
	    	   expect(affectedArea.length).toEqual(1);
	    });	   	   
	});	

	describe("reducePlaqueAt method", function(){
	    it("should remove plaque from the affected area when reduce is called at a position that has a severity of 1", function(){
	           var x1 = 1; var y1 = 2;var s1 = 1; 	     
	           
	           plaque1 = affectedArea.addPlaque(x1,y1,s1,LEG_REGION);
	           expect(affectedArea.length).toEqual(1);
	           affectedArea.reducePlaqueAt(x1, y1);
	           expect(affectedArea.length).toEqual(0);	       
	    });
	    
	    it("should reduce the severity of a plaque when reduce is applied", function(){
	           var x1 = 1; var y1 = 2;var s1 = 2; 
	           var x2 = 12;var y2 = 2;var s2 = 3; 
	           var x3 = 23;var y3 = 41;var s3 = 4; 
	           var x4 = 15;var y4 = 21;var s4 = 5; 
	           var x5 = 11;var y5 = 22;var s5 = 6; 
	           var x6 = 51;var y6 = 6;var s6 = 3; 
	           var x7 = 33;var y7 = 62;var s7 = 4;
	           
     
	    	   plaque1 = affectedArea.addPlaque(x1,y1,s1,LEG_REGION);
	    	   plaque2 = affectedArea.addPlaque(x2,y2,s2,ARM_REGION);
	    	   plaque3 = affectedArea.addPlaque(x3,y3,s3,HEAD_REGION);
	    	   plaque4 = affectedArea.addPlaque(x4,y4,s4,HEAD_REGION);
	    	   plaque5 = affectedArea.addPlaque(x5,y5,s5,TRUNK_REGION);
	    	   plaque6 = affectedArea.addPlaque(x6,y6,s6,HEAD_REGION);		   

	           affectedArea.reducePlaqueAt(x1,y1);
	    	   affectedArea.reducePlaqueAt(x2,y2);
	    	   affectedArea.reducePlaqueAt(x3,y3);
	    	   affectedArea.reducePlaqueAt(x4,y4);
	    	   affectedArea.reducePlaqueAt(x5,y5);
	    	   affectedArea.reducePlaqueAt(x6,y6);   
	    	   
	    	   //sev 2 case
	           expect(plaque1.get("x")).toEqual(x1);
	           expect(plaque1.get("y")).toEqual(y1);
	           expect(plaque1.get("severity")).toEqual(s1 - 1);
	           expect(plaque1.get("bodyLocation")).toEqual(LEG_REGION);	     
	           	       
	    	   //sev 3 case
	           expect(plaque2.get("x")).toEqual(x2);
	           expect(plaque2.get("y")).toEqual(y2);
	           expect(plaque2.get("severity")).toEqual(s2 - 1);
	           expect(plaque2.get("bodyLocation")).toEqual(ARM_REGION);	  
	           	      
	    	   //sev 4 case
	           expect(plaque3.get("x")).toEqual(x3);
	           expect(plaque3.get("y")).toEqual(y3);
	           expect(plaque3.get("severity")).toEqual(s3 - 1);
	           expect(plaque3.get("bodyLocation")).toEqual(HEAD_REGION);
	           	      
	    	   //sev 5 case
	           expect(plaque4.get("x")).toEqual(x4);
	           expect(plaque4.get("y")).toEqual(y4);
	           expect(plaque4.get("severity")).toEqual(s4 - 1);
	           expect(plaque4.get("bodyLocation")).toEqual(HEAD_REGION);
	           	 
     	   //sev 6 case	       
	           expect(plaque5.get("x")).toEqual(x5);
	           expect(plaque5.get("y")).toEqual(y5);
	           expect(plaque5.get("severity")).toEqual(s5 - 1);
	           expect(plaque5.get("bodyLocation")).toEqual(TRUNK_REGION);	                
	    });	    
	    
	    it("reduce should be applied once provided that the flag is not cleared", function(){ 	
	           var x1 = 12;var y1 = 2;var s1 = 4; 
	           
	    	   plaque1 = affectedArea.addPlaque(x1,y1,s1,LEG_REGION); 

	    	   //reduce applied 5 times
	           affectedArea.reducePlaqueAt(x1, y1);		     	   		   	       
	           affectedArea.reducePlaqueAt(x1, y1);
	           affectedArea.reducePlaqueAt(x1, y1);		     	   
	           affectedArea.reducePlaqueAt(x1, y1);		     	   
	           affectedArea.reducePlaqueAt(x1, y1);		     	   		     	   
	           
	           expect(plaque1.get("x")).toEqual(x1);
	           expect(plaque1.get("y")).toEqual(y1);
	           
	           //expect a reduction of only one
	           expect(plaque1.get("severity")).toEqual(s1 - 1);	       
	           expect(plaque1.get("bodyLocation")).toEqual(LEG_REGION);	 
	      
	    });
     
	    it("reduce should be applied again if the flag has been cleared", function(){ 		
	           var x1 = 12;var y1 = 2;var s1 = 4; 
	           
	    	   plaque1 = affectedArea.addPlaque(x1,y1,s1,LEG_REGION); 

	    	   //reduce applied 3 times before flag is cleared
	           affectedArea.reducePlaqueAt(x1, y1);		     	   		   	       
	           affectedArea.reducePlaqueAt(x1, y1);
	           affectedArea.reducePlaqueAt(x1, y1);	
	           
	           plaque1.clearFlag(); //flag is cleared
	           
	           //reduce applied 2 times
	           affectedArea.reducePlaqueAt(x1, y1);		     	   
	           affectedArea.reducePlaqueAt(x1, y1);		   		     	   
	           
	           expect(plaque1.get("x")).toEqual(x1);
	           expect(plaque1.get("y")).toEqual(y1);
	           
	           //expect and increase of only one
	           expect(plaque1.get("severity")).toEqual(s1 - 2);//should reduce only two times	       
	           expect(plaque1.get("bodyLocation")).toEqual(LEG_REGION);	 
	    	
	    });
	});
	
    
    describe("clearAllPlaques", function(){
	    it("should remove plaques from the affectedAreas", function(){ 	
	           var x1 = 1; var y1 = 2;var s1 = 1; 
	           var x2 = 12;var y2 = 2;var s2 = 2; 
	           var x3 = 23;var y3 = 41;var s3 = 3; 
	           var x4 = 15;var y4 = 21;var s4 = 4; 
	           var x5 = 11;var y5 = 22;var s5 = 5; 
	           var x6 = 51;var y6 = 6;var s6 = 3; 
	           var x7 = 33;var y7 = 62;var s7 = 4;
	           
               //add 6 plaques
	    	   affectedArea.addPlaque(x1,y1,s1,LEG_REGION);
	    	   affectedArea.addPlaque(x2,y2,s2,ARM_REGION);
	    	   affectedArea.addPlaque(x3,y3,s3,HEAD_REGION);
	    	   affectedArea.addPlaque(x4,y4,s4,HEAD_REGION);
	    	   affectedArea.addPlaque(x5,y5,s5,TRUNK_REGION);
	    	   affectedArea.addPlaque(x6,y6,s6,HEAD_REGION);				   
	    	   
	    	   var stateAfterAllPlaquesAdded = affectedArea.length;		
	    	   
	    	   //remove all plaques and check the state after removing
	    	   
	    	   affectedArea.clearAllPlaques();	    	  	    	  
	    	   var stateAfterPlaquesRemoved = affectedArea.length;
	    	   
	    	   //check that the states are all expected.
	    	   expect(stateAfterAllPlaquesAdded).toEqual(6);
	    	   expect(stateAfterPlaquesRemoved).toEqual(0);
	    });
    });
		
});

