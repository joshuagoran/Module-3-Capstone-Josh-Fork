package com.techelevator.npgeek.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.techelevator.npgeek.model.park.ParkDao;
import com.techelevator.npgeek.model.survey.Survey;
import com.techelevator.npgeek.model.survey.SurveyDao;
import com.techelevator.npgeek.model.surveyresults.SurveyResultDao;

@Controller
public class SurveyController {

	@Autowired
	private ParkDao parkDao;

	@Autowired
	private SurveyDao surveyDao;

	@Autowired
	private SurveyResultDao surveyResultDao;

	@RequestMapping("/survey")
	public String showSurveyPage(ModelMap model) {
		model.addAttribute("parks", parkDao.getAllParks());
		
		if( ! model.containsAttribute("Survey")) {        // If the modelHolder ModelMap does not have a "SignUp" entry
			model.addAttribute("Survey", new Survey());   //    add one
		}
		return "surveyPage";
	}

	@RequestMapping(path = "/submitSurvey", method = RequestMethod.POST)
	public String submitSurvey(
			@Valid @ModelAttribute("Survey") Survey newSurvey, 
			BindingResult result,
			RedirectAttributes flashData) {

		if (result.hasErrors()) {
			flashData.addFlashAttribute(BindingResult.MODEL_KEY_PREFIX + "Survey", result);
			
			flashData.addFlashAttribute("Survey", newSurvey);
			return "redirect:/survey";
		}

		flashData.addFlashAttribute("message", "Thank you for your submission!");

		surveyDao.save(newSurvey);

		return "redirect:/favoriteParks";
	}

	@RequestMapping("/favoriteParks")
	public String showFavoriteParks(ModelMap modelMap) {
		modelMap.addAttribute("surveyResults", surveyResultDao.getSurveyResults());

		return "favoriteParkPage";
	}
}
