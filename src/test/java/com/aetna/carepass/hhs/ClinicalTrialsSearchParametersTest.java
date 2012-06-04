package com.aetna.carepass.hhs;

import static org.junit.Assert.assertEquals;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.junit.Test;

public class ClinicalTrialsSearchParametersTest extends
		ClinicalTrialsSearchParameters {

	@Test
	public void testReversingDrugStatus() {
		DrugStatus status = DrugStatus.OPEN;
		ClinicalTrialsSearchParameters params = new ClinicalTrialsSearchParameters();
		params.setDrugStatus(DrugStatus.OPEN);

		assertEquals(DrugStatus.OPEN, params.getDrugStatus());
	}

	@Test
	public void testDateParsing() throws ParseException {
		// arrange
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.MONTH, 11);
		cal.set(Calendar.DAY_OF_MONTH, 24);
		cal.set(Calendar.YEAR, 1979);
		cal.set(Calendar.HOUR, 12);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MILLISECOND, 0);

		Date expected = cal.getTime();
		
		// act
		ClinicalTrialsSearchParameters params = new ClinicalTrialsSearchParameters();
		params.setFirstReceivedTo(expected);
		// assert

		assertEquals(expected, params.getFirstReceivedTo());
	}

}
