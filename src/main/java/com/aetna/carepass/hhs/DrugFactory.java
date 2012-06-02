package com.aetna.carepass.hhs;

public class DrugFactory {
	
	public static HHSAPI getHHSApi(String apiKey){
		return new HHSAPI(apiKey);
	}

}
