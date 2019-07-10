package com.techelevator.npgeek.model.surveyresults;

import java.util.List;

public interface SurveyResultDao {

	public void save(SurveyResult newSurveyResult);
	
	public List<SurveyResult> getSurveyResults();
	
}
