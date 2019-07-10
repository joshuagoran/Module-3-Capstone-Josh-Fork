package com.techelevator.npgeek.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.techelevator.npgeek.model.survey.SurveyDao;

@Controller
public class SurveyController {
	
	@Autowired
	private SurveyDao surveyDao;
	
	@RequestMapping("/survey" )
	public String showSurveyPage() {
		return "surveyPage";
	}
	
	@RequestMapping(path = { "/submitSurvey" }, method = RequestMethod.POST)
	public String submitSurvey() {
		return "redirect:/favoriteParks";
	}
	
	@RequestMapping("/favoriteParks")
	public String showFavoriteParks() {
		return "favoriteParkPage";
	}
}
