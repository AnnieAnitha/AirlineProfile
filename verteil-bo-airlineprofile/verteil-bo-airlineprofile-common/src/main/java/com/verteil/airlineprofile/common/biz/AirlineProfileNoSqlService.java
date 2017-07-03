/**
* Copyright © 2016 Verteil Technologies Pvt. Ltd.
*
* @author  Franklin Joshua
* @version 1.0
* @since   2016-01-15 
*/
package com.verteil.airlineprofile.common.biz;

import java.util.List;

import com.verteil.airlineprofile.common.dto.AirlineProfileCriteriaDto;
import com.verteil.commons.support.BaseService;
import com.verteil.commons.support.dto.RequestWrapperDto;
import com.verteil.schemas.ndc16_1.AirlineProfileRQ;
import com.verteil.schemas.ndc16_1.AirlineProfileRS;

public interface AirlineProfileNoSqlService extends BaseService{

	/**
	 * Process airline profile RQ.
	 *
	 * @param airProfile the air profile
	 * @param requestWrapper the request wrapper
	 * @return the airline profile RS
	 */
	public AirlineProfileRS processAirlineProfileRQ(AirlineProfileRQ airProfile, RequestWrapperDto requestWrapper);
	
	/**
	 * Process airline profile.
	 *
	 * @param flightId the flight id
	 * @return the list
	 */
	public List<AirlineProfileRS> processAirlineProfile(String flightId);

	/**
	 * Process airline profile.
	 *
	 * @param airProfileCriteriaDto the air profile criteria dto
	 * @return the list
	 */
	public List<String> processAirlineProfile(
			AirlineProfileCriteriaDto airProfileCriteriaDto);

}