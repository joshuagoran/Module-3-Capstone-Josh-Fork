package com.techelevator.npgeek.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.techelevator.npgeek.model.park.Park;
import com.techelevator.npgeek.model.park.ParkDao;
import com.techelevator.npgeek.model.weather.Weather;
import com.techelevator.npgeek.model.weather.WeatherDao;

@Controller
public class HomeController {

	@Autowired
	private ParkDao parkDao;

	@Autowired
	private WeatherDao weatherDao;

	@RequestMapping(path = { "/", "/home" })
	public String showHomePage(ModelMap modelMap) {
		List<Park> allParks = parkDao.getAllParks();
		modelMap.addAttribute("parks", allParks);
		return "homePage";
	}

	@RequestMapping("/parkDetail")
	public String showParkDetailPage(@RequestParam String parkcode, ModelMap model, HttpSession session) {
		if (session.getAttribute("tempUnit") == null) {
			session.setAttribute("tempUnit", "F");
		}

		Park aName = parkDao.getParkByParkcode(parkcode);
		model.addAttribute("park", aName);

		List<Weather> weatherForecast = weatherDao.getForecastsByParkcode(parkcode);
		model.addAttribute("weatherList", weatherForecast);

		String tempUnit = (String) session.getAttribute("tempUnit");

		model.addAttribute("tempUnit", tempUnit);

		model.addAttribute("parkcode", parkcode);
		return "parkDetailPage";
	}

	@RequestMapping("/changeTemp")
	public String changeTempUnits(@RequestParam String tempUnit, @RequestParam String parkcode, ModelMap model, HttpSession session) {
		session.setAttribute("tempUnit", tempUnit);
		return "redirect:/parkDetail?parkcode=" + parkcode;
	}

}