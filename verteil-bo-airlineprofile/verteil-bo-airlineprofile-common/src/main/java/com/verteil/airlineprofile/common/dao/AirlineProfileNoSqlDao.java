/**
* Copyright © 2016 Verteil Technologies Pvt. Ltd.
*
* @author  Franklin Joshua
* @version 1.0
* @since   2016-01-15 
*/
package com.verteil.airlineprofile.common.dao;

import java.util.List;

import com.verteil.airlineprofile.common.dto.AirlineProfileCriteriaDto;
import com.verteil.schemas.ndc16_1.AirlineProfileRS;

public interface AirlineProfileNoSqlDao {
	
	String COLLECTION_NAME = "airlineProfileRS";
	
	/**
	 * Write airline profile.
	 *
	 * @param airlineProfileRs the airline profile rs
	 * @return the airline profile RS
	 */
	public AirlineProfileRS writeAirlineProfile(AirlineProfileRS airlineProfileRs);

	/**
	 * Gets the third party ids.
	 *
	 * @param airProfileCriteriaDto the air profile criteria dto
	 * @return the third party ids
	 */
	public List<String> getAirlineIdsForSegment(
			AirlineProfileCriteriaDto airProfileCriteriaDto);

	/**
	 * Read airline profiles.
	 *
	 * @param airlineId the airline id
	 * @return the list
	 */
	List<AirlineProfileRS> readAirlineProfiles(String airlineId);
	
}
