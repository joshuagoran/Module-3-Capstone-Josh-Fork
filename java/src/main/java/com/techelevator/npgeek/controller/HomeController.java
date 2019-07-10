package com.techelevator.npgeek.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.techelevator.npgeek.model.park.ParkDao;
import com.techelevator.npgeek.model.weather.WeatherDao;

@Controller
public class HomeController {

	@Autowired
	private ParkDao parkDao;

	@Autowired
	private WeatherDao weatherDao;

	@RequestMapping(path = { "/", "/home" })
	public String showHomePage() {
		return "homePage";
	}

	@RequestMapping("/parkDetail")
	public String showParkDetailPage(@RequestParam String parkcode, HttpSession sessionMap) {
		return "parkDetailPage";
	}
	
	@RequestMapping("/changeTemp")
	public String changeTempUnits(@RequestParam char tempUnit, HttpSession sessionMap) {
		return "redirect:/parkDetail";
	}

}