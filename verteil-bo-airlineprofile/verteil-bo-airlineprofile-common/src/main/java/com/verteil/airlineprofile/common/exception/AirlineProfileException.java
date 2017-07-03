/**
* Copyright © 2016 Verteil Technologies Pvt. Ltd.
*
* @author  Franklin Joshua
* @version 1.0
* @since   2016-01-15 
*/
package com.verteil.airlineprofile.common.exception;

import com.verteil.commons.support.exception.SupportException;

public class AirlineProfileException extends SupportException {

	/**
	 * Instantiates a new airline profile exception.
	 *
	 * @param errorCode the error code
	 */
	public AirlineProfileException(int errorCode) {
		super(errorCode);
	}

	/**
	 * Instantiates a new airline profile exception.
	 *
	 * @param errorCode the error code
	 * @param msg the msg
	 */
	public AirlineProfileException(int errorCode, String msg) {
		super(errorCode, msg);
	}

	/**
	 * Instantiates a new airline profile exception.
	 *
	 * @param cause the cause
	 */
	public AirlineProfileException(Throwable cause) {
		super(cause);
	}
	
	/**
	 * Instantiates a new airline profile exception.
	 *
	 * @param errorCode the error code
	 * @param cause the cause
	 */
	public AirlineProfileException(int errorCode, Throwable cause) {
		super(errorCode, cause);
		this.errorCode = errorCode;
	}
	
	/**
	 * Instantiates a new airline profile exception.
	 *
	 * @param errorCode the error code
	 * @param msg the msg
	 * @param cause the cause
	 */
	public AirlineProfileException(int errorCode, String msg, Throwable cause) {
		super(errorCode, msg, cause);
		this.errorCode = errorCode;
	}

}
