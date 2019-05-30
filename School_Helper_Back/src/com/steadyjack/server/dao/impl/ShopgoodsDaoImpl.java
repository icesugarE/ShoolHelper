package com.steadyjack.server.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;
import com.steadyjack.server.dao.ShopgoodsDao;
import com.steadyjack.server.model.Shopgoods;

@Repository
public class ShopgoodsDaoImpl extends BaseDaoImpl implements ShopgoodsDao{
	
	@SuppressWarnings("unchecked")
	public List<Shopgoods> getAllShopgoods(){
		//开始查询
		String hql = "from Shopgoods";
		Query query = getSession().createQuery(hql);
		List<Shopgoods> shopgoods = query.list();
		//返回查询值
		return shopgoods;
	}
}
