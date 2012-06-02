describe("HTSLibrary", function() {	
	var htsObj
	var clinicalTrialsObject
	htsObj = new HTSObject();
	clinicalTrialsObject = new htsObj.clinicalTrialsAPI();

	describe('ClinicalTrial',function(){
		it("getTrialsByNCTId should make an AJAX request to the correct URL", function() {			
			htsObj.setBaseURL("http://xlab310:8080/hhs-directory-api")			
		    spyOn($, "ajax");
			clinicalTrialsObject.getTrialsByNCTId('NCT00835224', {})					   
		    expect($.ajax.mostRecentCall.args[0]["url"]).toEqual("http://xlab310:8080/hhs-directory-api/clinicaltrials/NCT00835224");
		});

		it("Search should make an AJAX request to the correct URL", function() {			
			htsObj.setBaseURL("http://xlab310:8080/hhs-directory-api")			
		    spyOn($, "ajax");
			
			clinicalTrialsObject.search({drugname:"codeine", status:"open", page:1, condition:"Depression",state1:"AL", state2:"IA", state3:"MD", country1:"NA:US", country2:"EU:AL", country3: "CA:BB", firstreceivedfrom: "1/13/2006", firstreceivedto:"1/13/2009", lastupdatedfrom: "1/13/2006", lastupdatedto:"1/13/2009"}, {})			
		    expect($.ajax.mostRecentCall.args[0]["url"]).toEqual("http://xlab310:8080/hhs-directory-api/clinicaltrials/search?");
			expect($.ajax.mostRecentCall.args[0].data["drugname"]).toEqual("codeine");
			expect($.ajax.mostRecentCall.args[0].data["status"]).toEqual("open");
			expect($.ajax.mostRecentCall.args[0].data["condition"]).toEqual("Depression");
			expect($.ajax.mostRecentCall.args[0].data["state1"]).toEqual("NA:US:AL");
			expect($.ajax.mostRecentCall.args[0].data["state2"]).toEqual("NA:US:IA");
			expect($.ajax.mostRecentCall.args[0].data["state3"]).toEqual("NA:US:MD");
			expect($.ajax.mostRecentCall.args[0].data["country1"]).toEqual("NA:US");
			expect($.ajax.mostRecentCall.args[0].data["country2"]).toEqual("EU:AL");
			expect($.ajax.mostRecentCall.args[0].data["country3"]).toEqual("CA:BB");
			expect($.ajax.mostRecentCall.args[0].data["firstreceivedfrom"]).toEqual("1/13/2006");
			expect($.ajax.mostRecentCall.args[0].data["firstreceivedto"]).toEqual("1/13/2009");
			expect($.ajax.mostRecentCall.args[0].data["lastupdatedfrom"]).toEqual("1/13/2006");
			expect($.ajax.mostRecentCall.args[0].data["lastupdatedto"]).toEqual("1/13/2009");
		});
	});

});
