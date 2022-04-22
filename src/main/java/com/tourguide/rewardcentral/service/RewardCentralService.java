package com.tourguide.rewardcentral.service;

import java.util.UUID;

public interface RewardCentralService {
	
	public int getRewardPoints(UUID attractionId, UUID userId);

}
