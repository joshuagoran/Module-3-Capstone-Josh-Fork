package com.techelevator.npgeek.model.survey;

import java.util.List;

public interface SurveyDao {

	public void save(Survey newSurvey);
	
	public List<Survey> getSurveys();
	
}
