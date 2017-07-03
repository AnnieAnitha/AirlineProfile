/**
 * Copyright © 2016 Verteil Technologies Pvt. Ltd.
 *
 * @author  Franklin Joshua
 * @version 1.0
 * @since   2016-01-15 
 */
package com.verteil.airlineprofile.core.dao.impl;

import static org.springframework.data.mongodb.core.aggregation.Aggregation.group;
import static org.springframework.data.mongodb.core.aggregation.Aggregation.match;
import static org.springframework.data.mongodb.core.aggregation.Aggregation.newAggregation;
import static org.springframework.data.mongodb.core.aggregation.Aggregation.project;
import static org.springframework.data.mongodb.core.aggregation.Aggregation.unwind;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.AggregationResults;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import com.verteil.airlineprofile.common.dao.AbstractAirlineProfileNoSqlDao;
import com.verteil.airlineprofile.common.dto.AirlineProfileCriteriaDto;
import com.verteil.schemas.ndc16_1.AirlineProfileRS;

public class AirlineProfileNoSqlDaoImpl extends AbstractAirlineProfileNoSqlDao {
	
	@Override
	public List<AirlineProfileRS> readAirlineProfiles(String flightId) {
		Query searchQuery = new Query(Criteria.where("profiles.profile.profileOwner.value").is(flightId));
		List<AirlineProfileRS> airlineProfileRS = mongoTemplate.find(searchQuery, AirlineProfileRS.class, COLLECTION_NAME);
		return airlineProfileRS;
	}

	@Override
	public AirlineProfileRS writeAirlineProfile(AirlineProfileRS airProfile) {
		mongoTemplate.save(airProfile, COLLECTION_NAME);
		return airProfile;
	}

	@Override
	public List<String> getAirlineIdsForSegment(AirlineProfileCriteriaDto airProfileCriteriaDto) {
		
		Criteria criteria = Criteria.where("profile.sourceFiles.sourceFile")
				.elemMatch(Criteria.where("dataItems.offeredService.value").is(AirlineProfileCriteriaDto.TRANSPORTATION)
					.and("dataItems.offerGeoSpecification.directionalIndicator").in(airProfileCriteriaDto.getDirection().value())
					.and("dataItems.offerGeoSpecification").elemMatch(Criteria.where("offerOriginPoint.geoSpecCode")
						.elemMatch(Criteria.where("value").is(airProfileCriteriaDto.getOrigin())
							.and("geoSpecCodeType").is(airProfileCriteriaDto.getOriginType().value()))
							.and("offerDestinationPoint.geoSpecCode").elemMatch(Criteria.where("value").is(airProfileCriteriaDto.getDestination())
									.and("geoSpecCodeType").is(airProfileCriteriaDto.getDestinationType().value()))));

		Aggregation aggregation = newAggregation(AirlineProfileRS.class, unwind("$profiles.profile"),
				group("$profiles.profile.profileOwner.value").push("$profiles.profile").as("profile"),
				match(criteria), project().and("$_id").as("_id"));

		AggregationResults<ResultString> results = mongoTemplate.aggregate(aggregation, COLLECTION_NAME, ResultString.class);
		List<ResultString> ids = results.getMappedResults();
		ArrayList<String> thirdPartyIds = null;
		for (ResultString a : ids) {
			if (thirdPartyIds == null) {
				thirdPartyIds = new ArrayList<>();
			}
			thirdPartyIds.add(a.get_id());
		}
		return thirdPartyIds;
	}
}
