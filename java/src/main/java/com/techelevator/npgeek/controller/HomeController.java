package com.techelevator.npgeek.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	
	@RequestMapping(path = {"/", "/home"})
	public String showHomePage() {
		return "homePage";
	}

	@RequestMapping(path = {"/survey"})
	public String showSurveyPage() {
		return "surveyPage";
	}
	
}
