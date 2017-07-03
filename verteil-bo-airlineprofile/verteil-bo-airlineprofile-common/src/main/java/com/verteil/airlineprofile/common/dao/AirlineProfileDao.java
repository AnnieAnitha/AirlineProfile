package com.verteil.airlineprofile.common.dao;

import java.util.List;

import com.verteil.airlineprofile.common.dto.AirlineProfilesDto;

public interface AirlineProfileDao {

	String TABLE_NAME_AIRLINE 			 = "airline";
	String TABLE_NAME_SECTORS 			 = "sectors";
	String COLUMN_NAME_CODE 			 = "code";
	String COLUMN_NAME_AIRLINE_CODE 	 = "airline_code";
	String COLUMN_NAME_DEPT_AIRPORT_CODE = "dept_airportcode";
	String COLUMN_NAME_DEPT_COUNTRY_CODE = "dept_countrycode";
	String COLUMN_NAME_ARRV_AIRPORT_CODE = "arrv_airportcode";
	String COLUMN_NAME_ARRV_COUNTRY_CODE = "arrv_countrycode";
	
	String SQL_SELECT_SECTORS  		= "select dept_airportcode,dept_countrycode,arrv_airportcode,arrv_countrycode from ";
	String SQL_SELECT_SERVICE		= "select distinct airline_code from ";
	
	public List<AirlineProfilesDto> readAirlineSectors(String airlineCode);
	
	public List<String> readAirlineIds(String deptAirportCode, String deptCountryCode, String arrvAirportCode, String arrvCountryCode);
}
