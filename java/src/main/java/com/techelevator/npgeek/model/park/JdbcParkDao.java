package com.techelevator.npgeek.model.park;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

@Component
public class JdbcParkDao implements ParkDao {

	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public JdbcParkDao(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public Park getParkByParkcode(String parkcode) {
		Park thePark = new Park();
		String sqlSelectAllParks = "SELECT * FROM park WHERE parkcode ILIKE ?";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlSelectAllParks, parkcode);
		if (results.next()) {
			thePark = mapRowToPark(results);
		}
		return thePark;
	}

	@Override
	public List<Park> getAllParks() {
		List<Park> allParks = new ArrayList<>();
		String sqlSelectAllParks = "SELECT * FROM park ORDER BY parkname";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlSelectAllParks);
		while (results.next()) {
			allParks.add(mapRowToPark(results));
		}
		return allParks;
	}

	private Park mapRowToPark(SqlRowSet row) {
		Park Park = new Park();
		Park.setParkcode(row.getString("parkcode"));
		Park.setParkname(row.getString("parkname"));
		Park.setState(row.getString("state"));
		Park.setAcreage(row.getInt("acreage"));
		Park.setElevationinfeet(row.getInt("elevationinfeet"));
		Park.setMilesoftrail(row.getDouble("milesoftrail"));
		Park.setNumberofcampsites(row.getInt("numberofcampsites"));
		Park.setClimate(row.getString("climate"));
		Park.setYearfounded(row.getInt("yearfounded"));
		Park.setAnnualvisitorcount(row.getInt("annualvisitorcount"));
		Park.setInspirationalquote(row.getString("inspirationalquote"));
		Park.setInspirationalquotesource(row.getString("inspirationalquotesource"));
		Park.setParkdescription(row.getString("parkdescription"));
		Park.setEntryfee(row.getInt("entryfee"));
		Park.setNumberofanimalspecies(row.getInt("numberofanimalspecies"));
		return Park;
	}

}
