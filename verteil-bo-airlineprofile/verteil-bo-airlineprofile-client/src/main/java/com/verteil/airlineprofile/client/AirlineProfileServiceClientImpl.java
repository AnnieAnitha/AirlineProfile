/**
 * Copyright © 2016 Verteil Technologies Pvt. Ltd.
 *
 * @author  Franklin Joshua
 * @version 1.0
 * @since   2016-01-15 
 */
package com.verteil.airlineprofile.client;

import java.util.List;

import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation.Builder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;

import com.verteil.airlineprofile.common.client.AbstractAirlineProfileServiceClient;
import com.verteil.airlineprofile.common.dto.AirlineServiceDto;
import com.verteil.commons.support.dto.RequestWrapperDto;

public class AirlineProfileServiceClientImpl extends AbstractAirlineProfileServiceClient {

	@Override
	public Object process(RequestWrapperDto arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object doRemoteCall(RequestWrapperDto arg0) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public List<String> fetchAirlineService(AirlineServiceDto airlineServiceDto) {
        WebTarget target = createWebTarget(AIRLINEPROFILE_GET_SERVICE_URL, false);
        Builder request = target.request(); 
        List <String> airlineService =request.post(Entity.entity(airlineServiceDto, MediaType.APPLICATION_JSON), new GenericType<List<String>>() {});  
        return airlineService;
    }
}
