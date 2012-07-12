/**
 * 
 */
package com.aetna.carepass.hhs.hhsapi.types;

import java.util.List;

/**
 * @author n309169
 *
 */
public class Nda {

	private String nda;
	private List<DrugResource> drugResources;
	private List<Alternative> alternatives;
	private List<Document> documents;
	
	public List<DrugResource> getDrugResources() {
		return drugResources;
	}
	public void setDrugResources(List<DrugResource> drugResources) {
		this.drugResources = drugResources;
	}
	public List<Alternative> getAlternatives() {
		return alternatives;
	}
	public void setAlternatives(List<Alternative> alternatives) {
		this.alternatives = alternatives;
	}
	public List<Document> getDocuments() {
		return documents;
	}
	public void setDocuments(List<Document> documents) {
		this.documents = documents;
	}
	
	
	/**
	 * @return the nda
	 */
	public String getNda() {
		return nda;
	}
	/**
	 * @param nda the nda to set
	 */
	public void setNda(String nda) {
		this.nda = nda;
	}

	
}
