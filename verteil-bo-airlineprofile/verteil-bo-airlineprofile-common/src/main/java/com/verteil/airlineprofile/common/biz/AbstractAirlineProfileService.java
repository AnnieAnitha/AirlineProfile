package com.verteil.airlineprofile.common.biz;

import com.verteil.airlineprofile.common.dao.AirlineProfileDao;
import com.verteil.commons.support.AbstractBaseService;
import com.verteil.opendata.client.impl.OpendataServiceClientImpl;
//import com.verteil.airlineprofile.common.client.*;

public abstract class AbstractAirlineProfileService extends AbstractBaseService implements AirlineProfileService {
	protected String TABLE_NAME_CITIES = "cities";
	protected String COLUMN_NAME_COUNTRY_CODE	= "country_code";
	protected String COLUMN_NAME_ISO_CODE	="code";

	protected AirlineProfileDao airlineProfileDao;
	protected OpendataServiceClientImpl openDataServiceClientImpl; 

	public OpendataServiceClientImpl getOpenDataServiceClientImpl() {
		return openDataServiceClientImpl;
	}

	public void setOpenDataServiceClientImpl(
			OpendataServiceClientImpl openDataServiceClientImpl) {
		this.openDataServiceClientImpl = openDataServiceClientImpl;
	}

	public AirlineProfileDao getAirlineProfileDao() {
		return airlineProfileDao;
	}

	public void setAirlineProfileDao(AirlineProfileDao airlineProfileDao) {
		this.airlineProfileDao = airlineProfileDao;
	}
}
