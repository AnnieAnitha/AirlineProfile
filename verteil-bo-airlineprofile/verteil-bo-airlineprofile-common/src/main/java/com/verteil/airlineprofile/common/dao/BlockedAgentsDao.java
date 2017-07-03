package com.verteil.airlineprofile.common.dao;

import java.util.List;

public interface BlockedAgentsDao {

	String TABLE_NAME_BLOCKED_AGENTS = "blocked_agents";
	String COLUMN_NAME_AIRLINE_CODE = "airline_code";
	String COLUMN_NAME_IATA_CODE = "iata_code";

	String SQL_SELECT_IATA_CODE = "select iata_code from ";
	String SQL_SELECT_AIRLINE_CODE = "select airline_code from ";

	public List<String> readBlockedAgents(String airlineId);

	public List<String> readAirlinesOfBlockedAgent(String iataCode);

	public boolean readStatusIsBlocked(String airlineId, String iataCode);

}
