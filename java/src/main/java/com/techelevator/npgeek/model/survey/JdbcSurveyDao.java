package com.techelevator.npgeek.model.survey;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class JdbcSurveyDao implements SurveyDao {

	private JdbcTemplate jdbcTemplate;
	
	@Override
	public void save(Survey newSurvey) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Survey> getAllSurveys() {
		// TODO Auto-generated method stub
		return null;
	}

}
