package com.verteil.airlineprofile.core.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.verteil.airlineprofile.common.dao.AbstractAirlineProfileDao;
import com.verteil.airlineprofile.common.dto.AirlineProfilesDto;


public class AirlineProfileDaoImpl extends AbstractAirlineProfileDao{

	private static final Logger LOGGER = LoggerFactory.getLogger(AirlineProfileDaoImpl.class);

	@Override
	public List<AirlineProfilesDto> readAirlineSectors(String airlineCode) {
		StringBuilder whereClause = buildWhereClause(null, COLUMN_NAME_AIRLINE_CODE, airlineCode, null, true);
		String sql = new StringBuilder(SQL_SELECT_SECTORS).append(TABLE_NAME_SECTORS).append(whereClause).toString();
		List<AirlineProfilesDto> sectors = executeQuery(sql, createResultSetExtractor()); 
		return sectors;
	}

	@Override
	public List<String> readAirlineIds(String deptAirportCode, String deptCountryCode, String arrvAirportCode, String arrvCountryCode) {
		List <String> lstValues = new ArrayList<>();
		lstValues.add(deptAirportCode);
		lstValues.add("*");
		String inClauseForDept = buildInClause(lstValues);
		lstValues.clear();
		lstValues.add(arrvAirportCode);
		lstValues.add("*");
		String inClauseForArrv = buildInClause(lstValues);
		String sql = new StringBuilder(SQL_SELECT_SERVICE).append(TABLE_NAME_SECTORS)
				.append(" where ").append(COLUMN_NAME_DEPT_AIRPORT_CODE).append(inClauseForDept)
				.append(" and ").append(COLUMN_NAME_DEPT_COUNTRY_CODE).append(" = '").append(deptCountryCode).append("'")
				.append(" and ").append(COLUMN_NAME_ARRV_AIRPORT_CODE).append(inClauseForArrv)
				.append(" and ").append(COLUMN_NAME_ARRV_COUNTRY_CODE).append(" = '").append(arrvCountryCode).append("'").toString();
		List<String> airlineIds = executeQuery(sql,createResultSet()); 
			return airlineIds;
	}
}

