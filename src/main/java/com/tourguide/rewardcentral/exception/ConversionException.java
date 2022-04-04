package com.tourguide.rewardcentral.exception;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_ACCEPTABLE)
public class ConversionException extends Exception {

	private Logger logger = LogManager.getLogger();
	public ConversionException(String attractionId, String userId) {
		super("attractionId invald : " + attractionId + " userId invalid" + userId);
		logger.error("attractionId invald : " + attractionId + " userId invalid" + userId);
	}
}
