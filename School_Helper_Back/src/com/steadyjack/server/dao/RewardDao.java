package com.steadyjack.server.dao;

import java.util.List;

import com.steadyjack.server.model.Reward;


public interface RewardDao {
	
	public void setReward(Reward reward);
	
	public List<Reward> selectBoardReward();
	
	public List<Reward> MyPublish(int posterId);
	
	public List<Reward> MyPublishone(int rewardId);
	
	public int reviseState(Reward reward);
	
	public List<Reward> getAllReward();
	
}
