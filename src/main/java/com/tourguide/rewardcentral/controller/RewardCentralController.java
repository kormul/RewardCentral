package com.tourguide.rewardcentral.controller;

import java.util.UUID;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tourguide.rewardcentral.exception.ConversionException;
import com.tourguide.rewardcentral.service.RewardCentralService;

@RestController
public class RewardCentralController {
	
	private Logger logger = LogManager.getLogger();

	@Autowired
	RewardCentralService rewardCentralService;
	
    @GetMapping("/getRewardPoints")
    public int getRewardPointsServer(@RequestParam String attractionId, String userId) throws ConversionException {
        UUID attractionUUID = null;
        UUID userUUID = null;
        try {
            logger.debug("Get Request Reward Point");
            attractionUUID = UUID.fromString(attractionId);
            userUUID = UUID.fromString(userId);
        } catch (IllegalArgumentException e) {
            throw new ConversionException(attractionId, userId);
        }
        return rewardCentralService.getRewardPoints(attractionUUID, userUUID);
    }
	
	
}
