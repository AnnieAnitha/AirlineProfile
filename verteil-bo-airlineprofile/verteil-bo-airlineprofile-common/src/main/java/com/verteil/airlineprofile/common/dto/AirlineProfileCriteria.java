/**
 * Copyright © 2016 Verteil Technologies Pvt. Ltd.
 *
 * @author  Franklin Joshua
 * @version 1.0
 * @since   2016-01-15 
 */
package com.verteil.airlineprofile.common.dto;

public interface AirlineProfileCriteria {

	String TRANSPORTATION = "1";
	String BAGGAGE = "2";
	String SEATS = "3";
	String OTHER = "4";
		
	public enum GeoSpecCodeType {
		AIRPORT("A"), CITY("C"), STATE("Z"), COUNTRY("C"), SUBAREA("P"), AREA("N");
		
		private final String value;

		/**
		 * Instantiates a new code.
		 *
		 * @param text
		 *            the text
		 */
		private GeoSpecCodeType(final String value) {
			this.value = value;
		}

		/**
		 * Text.
		 *
		 * @return the string
		 */
		public String value() {
			return value;
		}
	}

	public enum Direction {
		ONWARD("1"), // From LOC1 to LOC2
		RETURN("2"), //To LOC1 from LOC2
		ROUND_TRIP("3"); //Both
		
		private final String value;

		/**
		 * Instantiates a new direction.
		 *
		 * @param value
		 *            the value
		 */
		private Direction(final String value) {
			this.value = value;
		}

		/**
		 * Value.
		 *
		 * @return the string
		 */
		public String value() {
			return value;
		}
	}
}
