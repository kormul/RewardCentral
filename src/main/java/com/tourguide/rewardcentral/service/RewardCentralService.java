package com.tourguide.rewardcentral.service;

import java.util.UUID;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import rewardCentral.RewardCentral;

@Service
public class RewardCentralService {

	private Logger logger = LogManager.getLogger();

	private RewardCentral rewardCentral = new RewardCentral();
	
    public int getRewardPoints(UUID attractionId, UUID userId) {

    	logger.debug("Get Reward Points");
        return rewardCentral.getAttractionRewardPoints(attractionId, userId);
    }
	
}
