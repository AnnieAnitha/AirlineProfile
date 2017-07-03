/**
 * @author vt02user
 *
 */
package com.verteil.airlineprofile.common.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.verteil.airlineprofile.common.exception.AirlineProfileException;
import com.verteil.commons.genericdao.dao.AbstractDaoImpl;

public abstract class AbstractBlockedAgentsDao extends AbstractDaoImpl implements BlockedAgentsDao {

	private static final Logger LOGGER = LoggerFactory.getLogger(AirlineProfileNoSqlDao.class);
	protected ResultSetExtractor<List<String>> createResultSetExtractorForList(String columnName) {
		return new ResultSetExtractor<List<String>>() {

			@Override
			public List<String> extractData(ResultSet rs) throws SQLException, DataAccessException {
				List<String> blockedAgents = null;
				try {
					while (rs.next()) {
						if (blockedAgents == null) {
							blockedAgents = new ArrayList<String>();
						}
						blockedAgents.add(rs.getString(columnName));
					}

				} catch (SQLException e) {
					throw new AirlineProfileException(e);
				}
				return blockedAgents;
			}
		};
	}
}
