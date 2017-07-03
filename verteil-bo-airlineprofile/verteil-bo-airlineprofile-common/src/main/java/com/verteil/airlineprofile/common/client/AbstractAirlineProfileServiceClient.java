/**
* Copyright © 2016 Verteil Technologies Pvt. Ltd.
*
* @author  Franklin Joshua
* @version 1.0
* @since   2016-01-15 
*/
package com.verteil.airlineprofile.common.client;

import com.verteil.airlineprofile.common.biz.AirlineProfileNoSqlService;
import com.verteil.commons.support.web.client.AbstractRestClient;

public abstract class AbstractAirlineProfileServiceClient extends AbstractRestClient
		implements AirlineProfileServiceClient {	
	
	private AirlineProfileNoSqlService airlineProfileService;

	public AirlineProfileNoSqlService getAirlineProfileService() {
		return airlineProfileService;
	}

	public void setAirlineProfileService(
			AirlineProfileNoSqlService airlineProfileService) {
		this.airlineProfileService = airlineProfileService;
	}

}
