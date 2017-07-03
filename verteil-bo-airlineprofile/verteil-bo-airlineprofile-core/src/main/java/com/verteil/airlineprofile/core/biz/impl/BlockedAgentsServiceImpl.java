package com.verteil.airlineprofile.core.biz.impl;

import java.util.List;

import com.verteil.airlineprofile.common.biz.AbstractBlockedAgentsService;
import com.verteil.commons.support.dto.RequestWrapperDto;

public class BlockedAgentsServiceImpl extends AbstractBlockedAgentsService {

	@Override
	public List<String> loadBloclkedAgentsForAirline(String airlineId) {
		return blockedAgentsDao.readBlockedAgents(airlineId);
	}

	@Override
	public List<String> loadBlockedAirlinesForAgents(String iataCode) {
		return blockedAgentsDao.readAirlinesOfBlockedAgent(iataCode);
	}

	@Override
	public boolean isBlocked(String airlineId, String iataCode) {
		return blockedAgentsDao.readStatusIsBlocked(airlineId, iataCode);
	}

	@Override
	public Object process(RequestWrapperDto requestWrapper) {
		return null;
	}

}
