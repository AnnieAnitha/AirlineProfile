/**
 * Copyright © 2016 Verteil Technologies Pvt. Ltd.
 *
 * @author  Franklin Joshua
 * @version 1.0
 * @since   2016-01-15 
 */
package com.verteil.airlineprofile.common.client;

import java.util.List;

import com.verteil.airlineprofile.common.dto.AirlineServiceDto;
import com.verteil.commons.support.BaseService;

public interface AirlineProfileServiceClient extends BaseService {
	
	String AIRLINEPROFILE_GET_SERVICE_URL="airlineprofile.service.dept_airportcode.arrv_airportcode.url";
		
	public List<String> fetchAirlineService(AirlineServiceDto airlineServiceDto);
}