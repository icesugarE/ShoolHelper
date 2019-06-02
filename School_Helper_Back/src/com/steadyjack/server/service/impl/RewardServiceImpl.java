package com.steadyjack.server.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.steadyjack.server.dao.RewardDao;
import com.steadyjack.server.model.Reward;
import com.steadyjack.server.service.RewardService;

@Service
public class RewardServiceImpl implements RewardService{
	@Autowired
	private RewardDao rewardDao;
	
	public void setReward(Reward reward) {
		rewardDao.setReward(reward);
	}
	
	public List<Reward> selectBoardReward(){
		return rewardDao.selectBoardReward();
	}
	
	public List<Reward> MyPublish(int posterId){
		return rewardDao.MyPublish(posterId);
	}
	
	public List<Reward> MyPublishone(int rewardId){
		return rewardDao.MyPublishone(rewardId);
	}
	
	public int reviseState(Reward reward) {
		return rewardDao.reviseState(reward);
	}
	
	public List<Reward> getAllReward(){
		return rewardDao.getAllReward();
	}
}
