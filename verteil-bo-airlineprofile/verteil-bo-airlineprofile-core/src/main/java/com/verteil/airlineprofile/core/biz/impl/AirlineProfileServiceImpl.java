package com.verteil.airlineprofile.core.biz.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ws.rs.core.MediaType;

import org.json.JSONArray;
import org.json.JSONObject;

import com.verteil.airlineprofile.common.biz.AbstractAirlineProfileService;
import com.verteil.airlineprofile.common.dto.AirlineProfilesDto;
import com.verteil.airlineprofile.common.dto.AirlineServiceDto;
import com.verteil.airlineprofile.common.exception.AirlineProfileException;
import com.verteil.commons.support.dto.RequestWrapperDto;
import com.verteil.opendata.common.dto.CitiesDto;
import com.verteil.opendata.common.dto.OpendataServiceDto;

public class AirlineProfileServiceImpl extends AbstractAirlineProfileService {
	@Override
	public List<AirlineProfilesDto> loadSectorsForAirline(String airlineCode) {
		return airlineProfileDao.readAirlineSectors(airlineCode);
	}

	@Override
	public Object process(RequestWrapperDto arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<String> loadAirlineIds(AirlineServiceDto airlineServiceDto) {
		String errMsg = validate(airlineServiceDto);
		if (errMsg != null) {
			throw new AirlineProfileException(0, errMsg);
		}
		String deptCountryCode = getCountryCodeOfAirport(airlineServiceDto.getDeptAirportCode());
		String arrvCountryCode = getCountryCodeOfAirport(airlineServiceDto.getArrvAirportCode());
		List<String> airlines = airlineProfileDao.readAirlineIds(
				airlineServiceDto.getDeptAirportCode(), deptCountryCode,
				airlineServiceDto.getArrvAirportCode(), arrvCountryCode);
		return airlines;
	} 
		
	

	private String validate(AirlineServiceDto airlineServiceDto) {
		String errorMessage = null;
		if (airlineServiceDto.getDeptAirportCode() == null
				|| airlineServiceDto.getArrvAirportCode() == null) {
			errorMessage = "Departure/Arrival airport codes cannot be null";
		} else {
			if (airlineServiceDto.getDeptAirportCode().isEmpty()) {
				errorMessage = "Departure airport codes cannot be Empty";
			}
			if (airlineServiceDto.getArrvAirportCode().isEmpty()) {
				errorMessage = "Arrival airport codes cannot be Empty";
			}
		}
		return errorMessage;
	}

	private String getCountryCodeOfAirport(String airportCode) {
		String countryCode = null;
		try{
			OpendataServiceDto opendataServiceDto = new OpendataServiceDto();
			opendataServiceDto.setEntitiesKeyName(TABLE_NAME_CITIES);
			Map<String, List<String>> isoCodeMap = new HashMap<String, List<String>>();
			List<String> lstCountryCode = new ArrayList<String>();
			List<String> lstIsoCode = new ArrayList<String>();
			lstCountryCode.add(COLUMN_NAME_COUNTRY_CODE);
			lstIsoCode.add(airportCode);
			isoCodeMap.put(COLUMN_NAME_ISO_CODE, lstIsoCode);
			opendataServiceDto.setFields(lstCountryCode);
			opendataServiceDto.setCriteria(isoCodeMap);
			RequestWrapperDto requestWrapperDto = new RequestWrapperDto();
			requestWrapperDto.setRequest(opendataServiceDto);
			requestWrapperDto.setContentType(MediaType.APPLICATION_JSON);
			Object countryCodes = openDataServiceClientImpl.doRemoteCall(requestWrapperDto);
			List<CitiesDto> citiesDtos = (List<CitiesDto>) countryCodes;
			if (citiesDtos !=null && !citiesDtos.isEmpty()) {
				countryCode = citiesDtos.get(0).getCountry_code();
			}
		}catch (Exception e)
		{
			String errMsg = "Invalid Request";
			throw new AirlineProfileException(0, errMsg);
		}
		
		return countryCode;
	}
}
