package com.aetna.carepass;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class SearchParametersTest {

	
	@SuppressWarnings("serial")
	@Test
	public void testQueryStringification() {
		
		@SuppressWarnings("serial")
		QueryParameters params = new QueryParameters() {	};
		
		params.put("foo", "bar");
		params.put("zoo", "car");
		String queryString = params.toQueryString();
		
		assertTrue(queryString.indexOf("foo=bar") > -1);
		assertTrue(queryString.indexOf("zoo=car") > -1);
	}

}
