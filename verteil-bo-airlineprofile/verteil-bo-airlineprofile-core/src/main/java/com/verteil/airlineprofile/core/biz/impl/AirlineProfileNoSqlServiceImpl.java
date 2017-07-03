/**
 * Copyright © 2016 Verteil Technologies Pvt. Ltd.
 *
 * @author  Franklin Joshua
 * @version 1.0
 * @since   2016-01-15 
 */
package com.verteil.airlineprofile.core.biz.impl;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.verteil.airlineprofile.common.biz.AbstractAirlineProfileNoSqlService;
import com.verteil.airlineprofile.common.dto.AirlineProfileCriteriaDto;
import com.verteil.airlineprofile.common.exception.AirlineProfileException;
import com.verteil.commons.support.dto.KeyValueDto;
import com.verteil.commons.support.dto.RequestWrapperDto;
import com.verteil.intgrgate.common.client.IntegrationGateServiceClient;
import com.verteil.schemas.ndc16_1.AirlineProfileRQ;
import com.verteil.schemas.ndc16_1.AirlineProfileRS;

public class AirlineProfileNoSqlServiceImpl extends AbstractAirlineProfileNoSqlService {

	private static final Logger LOGGER = LoggerFactory.getLogger(AirlineProfileNoSqlServiceImpl.class);
	IntegrationGateServiceClient integrationGateServiceClient;

	@Override
	public AirlineProfileRS processAirlineProfileRQ(AirlineProfileRQ airProfile, RequestWrapperDto requestWrapper) {
		List<AirlineProfileRQ.Query.ProfileOwner> profileOwners = airProfile.getQuery().getProfileOwner();
		List<String> thirdPartyIds = requestWrapper.getThirdPartyIds();
		if (thirdPartyIds == null) {
			thirdPartyIds = new ArrayList<>();
			requestWrapper.setThirdPartyIds(thirdPartyIds);
		}
		for (AirlineProfileRQ.Query.ProfileOwner prof : profileOwners) {
			thirdPartyIds.add(prof.getValue());
		}
		requestWrapper.setResponseType(AirlineProfileRS.class);
		requestWrapper.setRequest(airProfile);
		AirlineProfileRS airlineProfileRs = (AirlineProfileRS) integrationGateServiceClient.process(requestWrapper);
		airlineProfileDao.writeAirlineProfile(airlineProfileRs);
		return airlineProfileRs;
	}

	@Override
	public List<AirlineProfileRS> processAirlineProfile(String airlineId) {
		List<AirlineProfileRS> airlineProfileRs = airlineProfileDao.readAirlineProfiles(airlineId);
		return airlineProfileRs;
	}

	@Override
	public List<String> processAirlineProfile(AirlineProfileCriteriaDto airProfileCriteriaDto) {
		List<String> thirdPartyIds = airlineProfileDao.getAirlineIdsForSegment(airProfileCriteriaDto);
		return thirdPartyIds;
	}

	@Override
	public Object process(RequestWrapperDto requestWrapper) {
		if (requestWrapper.getRequest() == null) {
			throw new AirlineProfileException(0,"Request cannot be null.");
		}
		Object request = convertObject(requestWrapper);
		if (request instanceof AirlineProfileCriteriaDto) {
			return processAirlineProfile((AirlineProfileCriteriaDto) requestWrapper.getRequest());
		} else if (request instanceof AirlineProfileRQ) {
			return processAirlineProfileRQ((AirlineProfileRQ) requestWrapper.getRequest(),requestWrapper);
		} else if (request instanceof KeyValueDto) {
			return processAirlineProfile((String)((KeyValueDto) requestWrapper.getRequest()).getValue());
		} else {
			throw new AirlineProfileException(0, "Invalid params!");
		}
	}
}
