package com.verteil.airlineprofile.common.biz;

import java.util.List;

import com.verteil.airlineprofile.common.dto.AirlineProfilesDto;
import com.verteil.airlineprofile.common.dto.AirlineServiceDto;

public interface AirlineProfileService {
	
	public List<AirlineProfilesDto> loadSectorsForAirline(String airlineCode);
	public List<String> loadAirlineIds(AirlineServiceDto airlineServiceDto);

}
