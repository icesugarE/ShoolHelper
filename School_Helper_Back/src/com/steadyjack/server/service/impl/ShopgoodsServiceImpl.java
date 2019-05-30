package com.steadyjack.server.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.steadyjack.server.dao.ShopgoodsDao;
import com.steadyjack.server.model.Shopgoods;
import com.steadyjack.server.service.ShopgoodsService;

@Service
public class ShopgoodsServiceImpl implements ShopgoodsService{
	
	@Autowired
	private ShopgoodsDao shopgoodsdao;
	
	public List<Shopgoods> getAllShopgoods(){
		return shopgoodsdao.getAllShopgoods();
	}
}
