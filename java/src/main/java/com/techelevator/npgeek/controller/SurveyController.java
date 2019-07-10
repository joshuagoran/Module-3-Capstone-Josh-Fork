package com.techelevator.npgeek.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.techelevator.npgeek.model.survey.Survey;
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
	public String submitSurvey(@ModelAttribute Survey newSurvey) {
		surveyDao.save(newSurvey);
		
		return "redirect:/favoriteParks";
	}
	
	@RequestMapping("/favoriteParks")
	public String showFavoriteParks(ModelMap modelMap) {
		modelMap.addAttribute("surveys", surveyDao.getSurveys());
		return "favoriteParkPage";
	}
}
