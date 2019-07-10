package com.techelevator.npgeek.model.survey;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import com.techelevator.npgeek.model.park.Park;

@Component
public class JdbcSurveyDao implements SurveyDao {

	private JdbcTemplate jdbcTemplate;

	@Autowired
	public JdbcSurveyDao(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public void save(Survey newSurvey) {
		String sqlInsertPost = "INSERT INTO survey_result(parkcode, emailaddress, state, activitylevel) VALUES (?,?,?,?)";
		jdbcTemplate.update(sqlInsertPost, newSurvey.getParkcode(), newSurvey.getEmailaddress(), newSurvey.getState(),
				newSurvey.getActivitylevel());
	}

	@Override
	public List<Survey> getSurveys() {
		List<Survey> SurveysByCount = new ArrayList<>();
		String sqlGetSurveys = "SELECT parkcode, COUNT(parkcode) FROM survey_result GROUP BY parkcode ORDER BY COUNT DESC";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlGetSurveys);
		while (results.next()) {
			SurveysByCount.add(mapRowToSurvey(results));
		}
		return SurveysByCount;
	}

	private Survey mapRowToSurvey(SqlRowSet row) {
		Survey Survey = new Survey();
		Survey.setParkcode(row.getString("parkcode"));
		Survey.setEmailaddress(row.getString("emailaddress"));
		Survey.setState(row.getString("state"));
		Survey.setActivitylevel(row.getString("activitylevel"));

		return Survey;
	}

}
