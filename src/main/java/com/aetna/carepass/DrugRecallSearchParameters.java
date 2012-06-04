/**
 * 
 */
package com.aetna.carepass;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author rnorris
 *
 */
public class DrugRecallSearchParameters extends QueryParameters {

	private static final String PASTDAYS = "pastdays";
	private static final String DATE = "date";
	private static final String PRODUCT = "product";
	private static final String DRUG_RECALL_DATE_FORMAT = "yyyy-MM-dd";

	/**
	 * @return the product
	 */
	public String getProduct() {
		return get(PRODUCT);
	}
	/**
	 * @param product the product to set
	 */
	public void setProduct(String product) {
		put(PRODUCT, product);
	}
	/**
	 * @return the date
	 * @throws ParseException 
	 */
	public Date getDate() throws ParseException {
		return parseDate(get(DATE));
	}
	/**
	 * @param date the date to set
	 */
	public void setDate(Date date) {
		put(DATE, dateAsString(date));
	}
	/**
	 * @return the pastDays
	 */
	public String getPastDays() {
		return get(PASTDAYS);
	}
	/**
	 * @param pastDays the pastDays to set
	 */
	public void setPastDays(String pastDays) {
		put(PASTDAYS, pastDays);
	}
	

	/**
	 * @param inputDate
	 * @return
	 */
	private String dateAsString(Date inputDate) {
		String format = DRUG_RECALL_DATE_FORMAT;
		SimpleDateFormat formatter = new SimpleDateFormat(format);
		String dateAsString = formatter.format(inputDate);
		return dateAsString;
	}

	/**
	 * @param dateString
	 *            TODO
	 * @return
	 * @throws ParseException
	 */
	private Date parseDate(String dateString) throws ParseException {
		String format = DRUG_RECALL_DATE_FORMAT;
		SimpleDateFormat formatter = new SimpleDateFormat(format);

		Date parsed = formatter.parse(dateString);
		return parsed;
	}
	
}
