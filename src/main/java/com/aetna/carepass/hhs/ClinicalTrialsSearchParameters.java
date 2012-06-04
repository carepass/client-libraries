/**
 * 
 */
package com.aetna.carepass.hhs;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.aetna.carepass.QueryParameters;

/**
 * @author rnorris
 * 
 */
public class ClinicalTrialsSearchParameters extends QueryParameters {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1075356972719774072L;
	
	private static final String LASTUPDATEDTO = "lastupdatedto";
	private static final String LASTUPDATEDFROM = "lastupdatedfrom";
	private static final String FIRSTRECEIVEDTO = "firstreceivedto";
	private static final String FIRSTRECEIVEDFROM = "firstreceivedfrom";
	private static final String COUNTRY3 = "country3";
	private static final String COUNTRY2 = "country2";
	private static final String COUNTRY1 = "country1";
	private static final String STATE3 = "state3";
	private static final String STATE2 = "state2";
	private static final String STATE1 = "state1";
	private static final String CONDITION = "condition";
	private static final String PAGE = "page";
	private static final String DRUG_STATUS = "drugStatus";
	private static final String DRUG_NAME = "drugName";
	private static final String CLINICAL_TRIALS_DATE_FORMAT = "MM/dd/yyyy";

	/**
	 * 
	 * @author rnorris
	 * 
	 */
	public enum DrugStatus {
		OPEN("open"), CLOSED("closed");

		private String status;

		private DrugStatus(String status) {
			this.status = status;
		}

		public String getStatus() {
			return status;
		}

		public static final DrugStatus fromString(String status) {
			if (status.equals(OPEN.toString().toLowerCase())) {
				return OPEN;
			} else {
				return CLOSED;
			}
		}
	}

	/**
	 * @return the drugName
	 */
	public String getDrugName() {
		return get(DRUG_NAME);
	}

	/**
	 * @param drugName
	 *            the drugName to set
	 */
	public void setDrugName(String drugName) {
		put(DRUG_NAME, drugName);
	}

	/**
	 * @return the drugStatus
	 */
	public DrugStatus getDrugStatus() {
		return DrugStatus.fromString(get(DRUG_STATUS));
	}

	/**
	 * @param drugStatus
	 *            the drugStatus to set
	 */
	public void setDrugStatus(DrugStatus drugStatus) {
		put(DRUG_STATUS, drugStatus.getStatus());
	}

	/**
	 * @return the page
	 */
	public String getPage() {
		return get(PAGE);
	}

	/**
	 * @param page
	 *            the page to set
	 */
	public void setPage(String page) {
		put(PAGE, page);
	}

	/**
	 * @return the condition
	 */
	public String getCondition() {
		return get(CONDITION);
	}

	/**
	 * @param condition
	 *            the condition to set
	 */
	public void setCondition(String condition) {
		put(CONDITION, condition);
	}

	/**
	 * @return the state1
	 */
	public String getState1() {
		return get(STATE1);
	}

	/**
	 * @param state1
	 *            the state1 to set
	 */
	public void setState1(String state1) {
		put(STATE1, state1);
	}

	/**
	 * @return the state2
	 */
	public String getState2() {
		return get(STATE2);
	}

	/**
	 * @param state2
	 *            the state2 to set
	 */
	public void setState2(String state2) {
		put(STATE2, state2);
	}

	/**
	 * @return the state3
	 */
	public String getState3() {
		return get(STATE3);
	}

	/**
	 * @param state3
	 *            the state3 to set
	 */
	public void setState3(String state3) {
		put(STATE3, state3);
	}

	/**
	 * @return the country1
	 */
	public String getCountry1() {
		return get(COUNTRY1);
	}

	/**
	 * @param country1
	 *            the country1 to set
	 */
	public void setCountry1(String country1) {
		put(COUNTRY1, country1);
	}

	/**
	 * @return the country2
	 */
	public String getCountry2() {
		return get(COUNTRY2);
	}

	/**
	 * @param country2
	 *            the country2 to set
	 */
	public void setCountry2(String country2) {
		put(COUNTRY2, country2);
	}

	/**
	 * @return the country3
	 */
	public String getCountry3() {
		return get(COUNTRY3);
	}

	/**
	 * @param country3
	 *            the country3 to set
	 */
	public void setCountry3(String country3) {
		put(COUNTRY3, country3);
	}

	/**
	 * @return the firstReceivedFrom
	 * @throws ParseException 
	 */
	public Date getFirstReceivedFrom() throws ParseException {
		return parseDate(get(FIRSTRECEIVEDFROM));
	}

	/**
	 * @param firstReceivedFrom
	 *            the firstReceivedFrom to set
	 */
	public void setFirstReceivedFrom(Date firstReceivedFrom) {
		put(FIRSTRECEIVEDFROM, dateAsString(firstReceivedFrom));
	}

	/**
	 * @return the firstReceivedTo
	 * @throws ParseException 
	 */
	public Date getFirstReceivedTo() throws ParseException {
		return parseDate(get(FIRSTRECEIVEDTO));
	}

	/**
	 * @param firstReceivedTo
	 *            the firstReceivedTo to set
	 */
	public void setFirstReceivedTo(Date firstReceivedTo) {
		put(FIRSTRECEIVEDTO, dateAsString(firstReceivedTo));
	}

	/**
	 * @return the lastUpdatedFrom
	 * @throws ParseException 
	 */
	public Date getLastUpdatedFrom() throws ParseException {
		return parseDate(get(LASTUPDATEDFROM));
	}

	/**
	 * @param lastUpdatedFrom
	 *            the lastUpdatedFrom to set
	 */
	public void setLastUpdatedFrom(Date lastUpdatedFrom) {
		put(LASTUPDATEDFROM, dateAsString(lastUpdatedFrom));
	}

	/**
	 * @return the lastUpdatedTo
	 * @throws ParseException 
	 */
	public Date getLastUpdatedTo() throws ParseException {
		return parseDate(get(LASTUPDATEDTO));
	}

	/**
	 * @param lastUpdatedTo
	 *            the lastUpdatedTo to set
	 */
	public void setLastUpdatedTo(Date lastUpdatedTo) {
		put(LASTUPDATEDTO, dateAsString(lastUpdatedTo));
	}

	/**
	 * @param inputDate
	 * @return
	 */
	private String dateAsString(Date inputDate) {
		String format = CLINICAL_TRIALS_DATE_FORMAT;
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
		String format = CLINICAL_TRIALS_DATE_FORMAT;
		SimpleDateFormat formatter = new SimpleDateFormat(format);

		Date parsed = formatter.parse(dateString);
		return parsed;
	}

}
