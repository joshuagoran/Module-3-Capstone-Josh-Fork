package com.techelevator.npgeek.model.survey;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

public class Survey {

	private int surveyid = 0;
	private String parkcode = "";
	
	@NotBlank(message="Email address is required")				// redirectAttributes msg
	@Email(message="Email must be a valid email address") 		// both @'s are built in to spring MVC
	private String emailaddress = "";							// @email = "string has to be a well formed email address"
	
	private String state = "";
	private String activitylevel = "";

	public int getSurveyid() {
		return surveyid;
	}

	public void setSurveyid(int surveyid) {
		this.surveyid = surveyid;
	}

	public String getParkcode() {
		return parkcode;
	}

	public void setParkcode(String parkcode) {
		this.parkcode = parkcode;
	}

	public String getEmailaddress() {
		return emailaddress;
	}

	public void setEmailaddress(String emailaddress) {
		this.emailaddress = emailaddress;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getActivitylevel() {
		return activitylevel;
	}

	public void setActivitylevel(String activitylevel) {
		this.activitylevel = activitylevel;
	}
}
