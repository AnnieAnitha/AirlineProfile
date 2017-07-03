/**
* Copyright © 2016 Verteil Technologies Pvt. Ltd.
*
* @author  Franklin Joshua
* @version 1.0
* @since   2016-01-15 
*/
package com.verteil.airlineprofile.core.biz.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.verteil.airlineprofile.common.biz.AirlineProfileNotifService;
import com.verteil.commons.support.dto.RequestWrapperDto;
import com.verteil.schemas.ndc15_2.Acknowledgement;
import com.verteil.schemas.ndc16_1.AirlineProfileNotif;

public class AirlineProfileNotifServiceImpl  implements AirlineProfileNotifService {

	private static final Logger LOGGER = LoggerFactory.getLogger(AirlineProfileNotifServiceImpl.class);
	
	@Override
	public Acknowledgement processAirlineProfileNotif(AirlineProfileNotif airProfileNotif) {
		//TODO - add business logic 
		return null;
	}
	@Override
	public Object process(RequestWrapperDto requestWrapper) {
		// TODO Auto-generated method stub
		return null;
	}

}
