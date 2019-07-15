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
			BindingResult result,				// needs to come right after the form to be validated
												// binds the information that is to be validate, 
												// basically as an object of its own
			RedirectAttributes flashData) {		// flashData = the name given for the error msg to display 
												// stored at the survey.java pojo

		if (result.hasErrors()) {				// if the encapsulated data (form) we are validating has errors...
			flashData.addFlashAttribute(BindingResult.MODEL_KEY_PREFIX + "Survey", result);
												
			flashData.addFlashAttribute("Survey", newSurvey);		
			return "redirect:/survey";			// redirect (what we see is a refresh in this instance) to
												// the same url with the added flashData. 
			}

		flashData.addFlashAttribute("message", "Thank you for your submission!"); // if no errors.

		surveyDao.save(newSurvey);

		return "redirect:/favoriteParks";
	}

	@RequestMapping("/favoriteParks")
	public String showFavoriteParks(ModelMap modelMap) {
		modelMap.addAttribute("surveyResults", surveyResultDao.getSurveyResults());

		return "favoriteParkPage";
	}
}
