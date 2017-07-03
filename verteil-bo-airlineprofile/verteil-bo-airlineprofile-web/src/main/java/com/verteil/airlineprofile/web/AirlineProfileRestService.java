package com.verteil.airlineprofile.web;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RestController;

import com.verteil.airlineprofile.common.biz.AirlineProfileService;
import com.verteil.airlineprofile.common.dto.AirlineProfilesDto;
import com.verteil.airlineprofile.common.dto.AirlineServiceDto;
import com.verteil.airlineprofile.common.exception.AirlineProfileException;
import com.verteil.commons.support.dto.RequestWrapperDto;
import com.verteil.commons.support.web.rest.AbstractRestService;

@RestController
@Path(value = "/")
public class AirlineProfileRestService extends AbstractRestService{

	private static final Logger LOGGER = LoggerFactory.getLogger(AirlineProfileRestService.class);
	
	private AirlineProfileService airlineProfileService = null;
	public AirlineProfileService getAirlineProfileService() {
		return airlineProfileService;
	}

	public void setAirlineProfileService(AirlineProfileService airlineProfileService) {
		this.airlineProfileService = airlineProfileService;
	}

	@Path(value = "airlineSectors")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public List<AirlineProfilesDto> getSectorsForAirline(@QueryParam("airlineCode") String airlineCode){
		List<AirlineProfilesDto> airlineSectors = airlineProfileService.loadSectorsForAirline(airlineCode);
		return airlineSectors;
	}
	
	@Path(value = "airlineServices")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public List<String> getServiceForAirline (AirlineServiceDto airlineServiceDto) {
		if(airlineServiceDto == null) {
			throw new AirlineProfileException(0,"Invalid Request");
		}
		List<String> airlineIds = airlineProfileService.loadAirlineIds(airlineServiceDto);
		return airlineIds;
	}
	
	@Override
	public Object process(RequestWrapperDto arg0) {
		// TODO Auto-generated method stub
		return null;
	}

}
