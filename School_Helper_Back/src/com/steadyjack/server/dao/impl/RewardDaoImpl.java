package com.steadyjack.server.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;
import com.steadyjack.server.dao.RewardDao;
import com.steadyjack.server.model.Reward;

@Repository
public class RewardDaoImpl extends BaseDaoImpl implements RewardDao{
	
	public void setReward(Reward reward) {
		getSession().save(reward);
	}
	
	@SuppressWarnings("unchecked")
	public List<Reward> selectBoardReward(){
		//开始查询
		String hql = "from Reward where rewardState = '1'";
		Query query = getSession().createQuery(hql);
		List<Reward> rewards = query.list();
		//返回查询值
		return rewards;
	}
	
	@SuppressWarnings("unchecked")
	public List<Reward> MyPublish(int posterId){
		//开始查询
		String hql = "from Reward where poster.userId = ?";
		Query query = getSession().createQuery(hql);
		query.setParameter(0,posterId);
		List<Reward> rewards = query.list();
		//返回查询值
		return rewards;
	}
	
	@SuppressWarnings("unchecked")
	public List<Reward> MyPublishone(int rewardId){
		//开始查询
		String hql = "from Reward where receiver.userId = ?";
		Query query = getSession().createQuery(hql);
		query.setParameter(0,rewardId);
		List<Reward> rewards = query.list();
		//返回查询值
		return rewards;
	}
	
	public int reviseState(Reward reward) {
		//开始更新
		Transaction tx = getSession().beginTransaction();
		String hql = "update Reward set rewardState = ? where rewardId = ?";
		Query query = getSession().createQuery(hql);
		query.setParameter(0,reward.getRewardState());
		query.setParameter(1,reward.getRewardId());
		int ret = query.executeUpdate();
		tx.commit();
		return ret;
	}
	
	@SuppressWarnings("unchecked")
	public List<Reward> getAllReward(){
		//开始查询
		String hql = "from Reward";
		Query query = getSession().createQuery(hql);
		List<Reward> rewards = query.list();
		//返回查询值
		return rewards;
	}
}
