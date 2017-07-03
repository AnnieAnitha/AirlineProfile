package com.verteil.airlineprofile.web;

/**
 * Copyright © 2016 Verteil Technologies Pvt. Ltd.
 *
 * @author  Franklin Joshua
 * @version 1.0
 * @since   2016-01-15 
 */

import static com.verteil.commons.support.exception.CommonsSupportErrorCodes.COMMON_ERR_INVALID_REQUEST_TYPE;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RestController;

import com.verteil.airlineprofile.common.biz.AirlineProfileNoSqlService;
import com.verteil.airlineprofile.common.biz.BlockedAgentsService;
import com.verteil.airlineprofile.common.dto.AirlineProfileCriteriaDto;
import com.verteil.airlineprofile.common.exception.AirlineProfileException;
import com.verteil.commons.support.dto.RequestWrapperDto;
import com.verteil.commons.support.web.rest.AbstractRestService;
import com.verteil.schemas.ndc16_1.AirlineProfileRS;

@RestController
@Path(value = "/")
public class AirlineProfileNoSqlRestService extends AbstractRestService {

	private static final Logger LOGGER = LoggerFactory.getLogger(AirlineProfileNoSqlRestService.class);

	private AirlineProfileNoSqlService airProfileService;
	private BlockedAgentsService blockedAgentsService;

	public AirlineProfileNoSqlService getAirProfileService() {
		return airProfileService;
	}

	public void setAirProfileService(AirlineProfileNoSqlService airProfileService) {
		this.airProfileService = airProfileService;
	}

	public BlockedAgentsService getBlockedAgentsService() {
		return blockedAgentsService;
	}

	public void setBlockedAgentsService(BlockedAgentsService blockedAgentsService) {
		this.blockedAgentsService = blockedAgentsService;
	}

	@Path(value = "airlineprofile")
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	public AirlineProfileRS putAirlineProfile(RequestWrapperDto requestWrapper) {
		String serviceId = requestWrapper.getServiceId();
		LOGGER.info("Received request for ServiceId - " + serviceId);
		if (requestWrapper.getRequest() == null) {
			throw new AirlineProfileException(COMMON_ERR_INVALID_REQUEST_TYPE, "Invalid request type! Received null.");
		}
		return (AirlineProfileRS) airProfileService.process(requestWrapper);
	}

	@Path(value = "airlineId")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public List<AirlineProfileRS> getAirlineProfile(RequestWrapperDto requestWrapper) {
		String serviceId = requestWrapper.getServiceId();
		LOGGER.info("Received request for ServiceId - " + serviceId);
		if (requestWrapper.getRequest() == null) {
			throw new AirlineProfileException(COMMON_ERR_INVALID_REQUEST_TYPE, "Invalid request type! Received null.");
		}
		return (List<AirlineProfileRS>) airProfileService.process(requestWrapper);
	}

	@Path(value = "thirdpartyIds")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public List<String> processJsonRequest(AirlineProfileCriteriaDto airProfileDto) {
		airProfileDto = (AirlineProfileCriteriaDto) convertJsonToPojo(airProfileDto, AirlineProfileCriteriaDto.class, false);
		List<String> thirpartyIds = airProfileService.processAirlineProfile(airProfileDto);
		return thirpartyIds;
	}

	@Path(value = "blockedAgents")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public List<String> getBlockedAirlinesForAgent(@QueryParam("airlineId") String airlineId) {
		List<String> blockedAgents = blockedAgentsService.loadBloclkedAgentsForAirline(airlineId);
		return blockedAgents;
	}

	@Path(value = "airlinesofBlockedAgents")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public List<String> getAirlinesForBlockedAgent(@QueryParam("iataCode") String iataCode) {
		List<String> blockedAirrlines = blockedAgentsService.loadBlockedAirlinesForAgents(iataCode);
		return blockedAirrlines;
	}

	@Path(value = "isBlocked")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public boolean isBlocked(@QueryParam("airlineId") String airlineId , @QueryParam("iataCode") String iataCode) {
		boolean isBlocked=blockedAgentsService.isBlocked(airlineId, iataCode);
		return isBlocked;

	}

	@Override
	public Object process(RequestWrapperDto requestWrapper) {
		return null;
	}

}
