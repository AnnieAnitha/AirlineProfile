package com.verteil.airlineprofile.core.dao.impl;

import java.util.List;

import com.verteil.airlineprofile.common.dao.AbstractBlockedAgentsDao;

public class BlockedAgentsDaoImpl extends AbstractBlockedAgentsDao {

	@Override
	public List<String> readBlockedAgents(String airlineId) {
		StringBuilder whereClause = buildWhereClause(null, COLUMN_NAME_AIRLINE_CODE, airlineId, null, true);
		String sql = new StringBuilder(SQL_SELECT_IATA_CODE).append(TABLE_NAME_BLOCKED_AGENTS).append(whereClause).toString();
		List<String> blockedAgentsDto = executeQuery(sql, createResultSetExtractorForList(COLUMN_NAME_IATA_CODE));
		return blockedAgentsDto;
	}

	@Override
	public List<String> readAirlinesOfBlockedAgent(String iataCode) {
		StringBuilder whereClause = buildWhereClause(null, COLUMN_NAME_IATA_CODE, iataCode, null, true);
		String sql = new StringBuilder(SQL_SELECT_AIRLINE_CODE).append(TABLE_NAME_BLOCKED_AGENTS).append(whereClause).toString();
		List<String> blockedAgentsDto = executeQuery(sql, createResultSetExtractorForList(COLUMN_NAME_AIRLINE_CODE));
		return blockedAgentsDto;
	}

	@Override
	public boolean readStatusIsBlocked(String airlineId, String iataCode) {
		StringBuilder whereClause = buildWhereClause(null, COLUMN_NAME_AIRLINE_CODE, airlineId, null, false);
		whereClause = buildWhereClause(whereClause, COLUMN_NAME_IATA_CODE, airlineId, AND_OR.AND, false);
		String sql = new StringBuilder(SQL_SELECT_FROM).append(TABLE_NAME_BLOCKED_AGENTS)
				.append(whereClause).toString();
		boolean isBlockedDetails = executeQuery(sql, createIsExistsResultSetExtractor());
		return isBlockedDetails;
	}

}
