/**
* Copyright © 2016 Verteil Technologies Pvt. Ltd.
*
* @author  Franklin Joshua
* @version 1.0
* @since   2016-01-15 
*/
package com.verteil.airlineprofile.common.biz;

import com.verteil.commons.support.BaseService;
import com.verteil.schemas.ndc15_2.Acknowledgement;
import com.verteil.schemas.ndc16_1.AirlineProfileNotif;

public interface AirlineProfileNotifService extends BaseService{

	public Acknowledgement processAirlineProfileNotif(AirlineProfileNotif airProfileNotif);
}
