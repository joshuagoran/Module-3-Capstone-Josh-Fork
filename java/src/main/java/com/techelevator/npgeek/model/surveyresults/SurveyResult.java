package com.techelevator.npgeek.model.surveyresults;

public class SurveyResult {

	private String parkname = "";
	private String parkcode = "";
	private int count = 0;
	// add Park object to pass to survey result view
	
	public String getParkname() {
		return parkname;
	}
	public void setParkname(String parkname) {
		this.parkname = parkname;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public String getParkcode() {
		return parkcode;
	}
	public void setParkcode(String parkcode) {
		this.parkcode = parkcode;
	}
	
}