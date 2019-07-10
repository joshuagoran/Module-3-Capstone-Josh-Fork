package com.techelevator.npgeek.model.weather;

public class Weather {

	private String parkcode = "";
	private int fivedayforecastvalue = 0;
	private int low = 0;
	private int high = 0;
	private String forecast = "";

	public String getParkcode() {
		return parkcode;
	}

	public void setParkcode(String parkcode) {
		this.parkcode = parkcode;
	}

	public int getFivedayforecastvalue() {
		return fivedayforecastvalue;
	}

	public void setFivedayforecastvalue(int fivedayforecastvalue) {
		this.fivedayforecastvalue = fivedayforecastvalue;
	}

	public int getLow() {
		return low;
	}

	public void setLow(int low) {
		this.low = low;
	}

	public int getHigh() {
		return high;
	}

	public void setHigh(int high) {
		this.high = high;
	}

	public String getForecast() {
		return forecast;
	}

	public void setForecast(String forecast) {
		this.forecast = forecast;
	}
	
}
