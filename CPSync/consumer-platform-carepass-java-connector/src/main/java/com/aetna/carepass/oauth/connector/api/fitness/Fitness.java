package com.aetna.carepass.oauth.connector.api.fitness;

import java.math.BigDecimal;

public class Fitness {

	private Long id;
	private String description;
	private String type;
	private String notes;
	private String typeExtra;
	private String date;
	private String startTime;
	private String endTime;
	private String startCity;
	private String endCity;
	private String startState;
	private String endState;
	private String startCountry;
	private String endCountry;
	private BigDecimal startLatitude;
	private BigDecimal endLatitude;
	private BigDecimal startLongitude;
	private BigDecimal endLongitude;
	private Float caloriesBurned;
	private BigDecimal distance;
	private String distanceUnit;
	private String duration;
	private String lastUpdated;

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getNotes() {
		return notes;
	}
	public void setNotes(String notes) {
		this.notes = notes;
	}
	public String getTypeExtra() {
		return typeExtra;
	}
	public void setTypeExtra(String typeExtra) {
		this.typeExtra = typeExtra;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getStartTime() {
		return startTime;
	}
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}
	public String getEndTime() {
		return endTime;
	}
	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}
	public String getStartCity() {
		return startCity;
	}
	public void setStartCity(String startCity) {
		this.startCity = startCity;
	}
	public String getEndCity() {
		return endCity;
	}
	public void setEndCity(String endCity) {
		this.endCity = endCity;
	}
	public String getStartState() {
		return startState;
	}
	public void setStartState(String startState) {
		this.startState = startState;
	}
	public String getEndState() {
		return endState;
	}
	public void setEndState(String endState) {
		this.endState = endState;
	}
	public String getStartCountry() {
		return startCountry;
	}
	public void setStartCountry(String startCountry) {
		this.startCountry = startCountry;
	}
	public String getEndCountry() {
		return endCountry;
	}
	public void setEndCountry(String endCountry) {
		this.endCountry = endCountry;
	}
	public BigDecimal getStartLatitude() {
		return startLatitude;
	}
	public void setStartLatitude(BigDecimal startLatitude) {
		this.startLatitude = startLatitude;
	}
	public BigDecimal getEndLatitude() {
		return endLatitude;
	}
	public void setEndLatitude(BigDecimal endLatitude) {
		this.endLatitude = endLatitude;
	}
	
	public BigDecimal getStartLongitude() {
		return startLongitude;
	}
	public void setStartLongitude(BigDecimal startLongitude) {
		this.startLongitude = startLongitude;
	}
	public BigDecimal getEndLongitude() {
		return endLongitude;
	}
	public void setEndLongitude(BigDecimal endLongitude) {
		this.endLongitude = endLongitude;
	}
	public Float getCaloriesBurned() {
		return caloriesBurned;
	}
	public void setCaloriesBurned(Float caloriesBurned) {
		this.caloriesBurned = caloriesBurned;
	}
	public BigDecimal getDistance() {
		return distance;
	}
	public void setDistance(BigDecimal distance) {
		this.distance = distance;
	}
	public String getDistanceUnit() {
		return distanceUnit;
	}
	public void setDistanceUnit(String distanceUnit) {
		this.distanceUnit = distanceUnit;
	}
	public String getDuration() {
		return duration;
	}
	public void setDuration(String duration) {
		this.duration = duration;
	}
	public String getLastUpdated() {
		return lastUpdated;
	}
	public void setLastUpdated(String lastUpdated) {
		this.lastUpdated = lastUpdated;
	}


}

