package com.tourguide.rewardcentral.service;

import java.util.UUID;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import rewardCentral.RewardCentral;

@Service
public class RewardCentralServiceImpl implements RewardCentralService{

	private Logger logger = LogManager.getLogger();

	private RewardCentral rewardCentral = new RewardCentral();
	
	private ExecutorService executorService = Executors.newFixedThreadPool(32000);
	
    public int getRewardPoints(UUID attractionId, UUID userId) {

    	logger.debug("Get Reward Points");
    	
		
		try {
			return CompletableFuture.supplyAsync(()-> {	
		        return rewardCentral.getAttractionRewardPoints(attractionId, userId);
			}, executorService ).get();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		}
		return 0;
    }
	
}
