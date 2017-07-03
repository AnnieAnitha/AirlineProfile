package com.verteil.airlineprofile.common.biz;

import java.util.List;

public interface BlockedAgentsService {

	public List<String> loadBloclkedAgentsForAirline(String airlineId);

	public List<String> loadBlockedAirlinesForAgents(String iataCode);
	
	public boolean isBlocked(String airlineId, String iataCode);

}
