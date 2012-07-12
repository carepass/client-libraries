package com.aetna.carepass.oauth.connector.api.lifestyle;

import java.util.ArrayList;
import java.util.List;

public class Lifestyle {

	private List<LifestyleAttribute> lifestyleAttributes = new ArrayList<LifestyleAttribute>();

	public List<LifestyleAttribute> getLifestyleAttributes() {
		return lifestyleAttributes;
	}

	public void setLifestyleAttributes(List<LifestyleAttribute> lifestyleAttributes) {
		this.lifestyleAttributes = lifestyleAttributes;
	}
	
}
