/**
 * 
 */
package com.verteil.airlineprofile.common.dto;

/**
 * @author vt02user
 *
 */
public class BlockedAgentsDto {
	private String blockedAgentsIataCode;

	private String AirlinesId;

	public String getBlockedAgentsIataCode() {
		return blockedAgentsIataCode;
	}

	public void setBlockedAgentsIataCode(String blockedAgentsIataCode) {
		this.blockedAgentsIataCode = blockedAgentsIataCode;
	}

	public String getAirlinesId() {
		return AirlinesId;
	}

	public void setAirlinesId(String airlinesId) {
		AirlinesId = airlinesId;
	}

}
