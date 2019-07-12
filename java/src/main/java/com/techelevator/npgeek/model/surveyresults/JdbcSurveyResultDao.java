package com.techelevator.npgeek.model.surveyresults;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import com.techelevator.npgeek.model.park.Park;

@Component
public class JdbcSurveyResultDao implements SurveyResultDao {

	private JdbcTemplate jdbcTemplate;

	@Autowired
	public JdbcSurveyResultDao(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public List<SurveyResult> getSurveyResults() {
		List<SurveyResult> surveyResultsByCount = new ArrayList<>();
		String sqlGetSurveyResults = 
				"SELECT park.parkname, survey_result.parkcode, COUNT(survey_result.parkcode) \n" + 
				"FROM survey_result \n" + 
				"JOIN park ON survey_result.parkcode = park.parkcode\n" + 
				"GROUP BY park.parkname, survey_result.parkcode " + 
				"ORDER BY COUNT DESC";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlGetSurveyResults);
		while (results.next()) {
			surveyResultsByCount.add(mapRowToSurveyResult(results));
		}
		return surveyResultsByCount;
	}

	private SurveyResult mapRowToSurveyResult(SqlRowSet row) {
		SurveyResult surveyResult = new SurveyResult();
		surveyResult.setParkname(row.getString("parkname"));
		surveyResult.setParkcode(row.getString("parkcode"));
		surveyResult.setCount(row.getInt("count"));

		return surveyResult;
	}

}
