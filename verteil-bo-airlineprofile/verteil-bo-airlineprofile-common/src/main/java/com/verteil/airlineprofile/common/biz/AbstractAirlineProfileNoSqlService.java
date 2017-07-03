/**
* Copyright © 2016 Verteil Technologies Pvt. Ltd.
*
* @author  Franklin Joshua
* @version 1.0
* @since   2016-01-15 
*/
package com.verteil.airlineprofile.common.biz;

import com.verteil.airlineprofile.common.dao.AirlineProfileNoSqlDao;
import com.verteil.commons.support.AbstractBaseService;

public abstract class AbstractAirlineProfileNoSqlService extends AbstractBaseService implements AirlineProfileNoSqlService{

;
	protected AirlineProfileNoSqlDao airlineProfileDao;

	public AirlineProfileNoSqlDao getAirlineProfileDao() {
		return airlineProfileDao;
	}

	public void setAirlineProfileDao(AirlineProfileNoSqlDao airlineProfileDao) {
		this.airlineProfileDao = airlineProfileDao;
	}
}

