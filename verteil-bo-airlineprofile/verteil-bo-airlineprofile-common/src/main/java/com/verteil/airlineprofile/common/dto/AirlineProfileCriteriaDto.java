/**
* Copyright © 2016 Verteil Technologies Pvt. Ltd.
*
* @author  Franklin Joshua
* @version 1.0
* @since   2016-01-15 
*/
package com.verteil.airlineprofile.common.dto;

import java.util.Objects;

public class AirlineProfileCriteriaDto implements AirlineProfileCriteria {
	
	private Direction direction;
	private String origin;
	private String destination;
	private GeoSpecCodeType originType;
	private GeoSpecCodeType destinationType;

	/**
	 * Gets the origin.
	 *
	 * @return the origin
	 */
	public String getOrigin() {
		return origin;
	}

	/**
	 * Sets the origin.
	 *
	 * @param origin the new origin
	 */
	public void setOrigin(String origin) {
		this.origin = origin;
	}

	/**
	 * Gets the destination.
	 *
	 * @return the destination
	 */
	public String getDestination() {
		return destination;
	}

	/**
	 * Sets the destination.
	 *
	 * @param destination the new destination
	 */
	public void setDestination(String destination) {
		this.destination = destination;
	}

	/**
	 * Gets the origin type.
	 *
	 * @return the origin type
	 */
	public GeoSpecCodeType getOriginType() {
		return originType;
	}

	/**
	 * Sets the origin type.
	 *
	 * @param originType the new origin type
	 */
	public void setOriginType(GeoSpecCodeType originType) {
		this.originType = originType;
	}

	/**
	 * Gets the destination type.
	 *
	 * @return the destination type
	 */
	public GeoSpecCodeType getDestinationType() {
		return destinationType;
	}

	/**
	 * Sets the destination type.
	 *
	 * @param destinationType the new destination type
	 */
	public void setDestinationType(GeoSpecCodeType destinationType) {
		this.destinationType = destinationType;
	}

	/**
	 * Gets the direction.
	 *
	 * @return the direction
	 */
	public Direction getDirection() {
		return direction;
	}

	/**
	 * Sets the direction.
	 *
	 * @param direction the new direction
	 */
	public void setDirection(Direction direction) {
		this.direction = direction;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (obj == this)
			return true;
		if (!(obj instanceof AirlineProfileCriteriaDto)) {
			return false;
		}
		AirlineProfileCriteriaDto dto = (AirlineProfileCriteriaDto) obj;
		return Objects.equals(direction, dto.direction)
				&& Objects.equals(origin, dto.origin)
				&& Objects.equals(destination, dto.destination)
				&& Objects.equals(originType, dto.originType)
				&& Objects.equals(destinationType, dto.destinationType);
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		return Objects.hash(direction, origin, destination, originType,
				destinationType);
	}
}
