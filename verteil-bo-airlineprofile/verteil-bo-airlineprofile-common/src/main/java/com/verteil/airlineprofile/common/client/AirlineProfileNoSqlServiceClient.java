package com.verteil.airlineprofile.common.client;

import java.util.List;

import com.verteil.airlineprofile.common.dto.AirlineProfileCriteriaDto;
import com.verteil.airlineprofile.common.dto.AirlineProfilesDto;
import com.verteil.commons.support.BaseService;
import com.verteil.commons.support.dto.RequestWrapperDto;
import com.verteil.schemas.ndc16_1.AirlineProfileRS;

public interface AirlineProfileNoSqlServiceClient extends BaseService  {
	String AIRLINEID_POST_URL = "airlineprofile.airlineId.url";
	String AIRLINEPROFILE_URL = "airlineprofile.airlineprofile.url";
	String AIRLINEPROFILE_THIRDPARTYIDS_URL = "airlineprofile.thirdpartyIds.url";
	String AIRLINEPROFILE_ALL_BLOCKED_AGENTS_URL = "airlineprofile.all.blocked.agents.url";
	String AIRLINEPROFILE_ALL_BLOCKED_AIRLINES_URL = "airlineprofile.all.blocked.airlines.url";
	String AIRLINEPROFILE_IS_AGENT_BLOCKED_BY_AIRLINE_URL = "airlineprofile.is.agent.blocked.by.airline.url";
	String KEY_AIRLINE_ID = "AIRLINE_ID";
	String AIRLINEPROFILE_GET_SECTOR_URL="airlineprofile.sector.airlineId.url";

	public Object putAirlineProfileRQ(RequestWrapperDto requestWrapper);

	public List<AirlineProfileRS> fetchAirlineProfile(RequestWrapperDto requestWrapper);

	public List<String> fetchProfileOwners(AirlineProfileCriteriaDto airProfileCriteria, List<String> thirdPartyIds);

	public List<String> fetchBlockedAgents(String airlineId);
	
	public List<String> fetchBlockedAirlines(String iataCode);
	
	public boolean isAgentBlockedByAirline(String airlineId, String iataCode);
	
	public List<AirlineProfilesDto> fetchAirlineSectors(String airlineCode);

}
