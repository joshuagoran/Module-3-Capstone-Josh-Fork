package com.techelevator.npgeek.model.weather;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

@Component
public class JdbcWeatherDao implements WeatherDao {

	private JdbcTemplate jdbcTemplate;

	@Autowired
	public JdbcWeatherDao(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public List<Weather> getForecastsByParkcode(String parkcode) {
		List<Weather> fiveDayForecast = new ArrayList<>();
		String sqlSelectWeatherByParkcode = "SELECT * " + "FROM weather " + "WHERE parkcode = ? " + "LIMIT 5";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlSelectWeatherByParkcode, parkcode);
		while (results.next()) {
			fiveDayForecast.add(mapRowToWeather(results));
		}
		return fiveDayForecast;
	}

	private Weather mapRowToWeather(SqlRowSet row) {
		Weather weather = new Weather();
		weather.setParkcode(row.getString("parkcode"));
		weather.setFivedayforecastvalue(row.getInt("fivedayforecastvalue"));
		weather.setLow(row.getInt("low"));
		weather.setHigh(row.getInt("high"));
		weather.setForecast(row.getString("forecast"));

		return weather;
	}
}
