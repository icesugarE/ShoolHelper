package com.steadyjack.web.controller;


import java.io.PrintWriter;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.steadyjack.server.model.Shopgoods;
import com.steadyjack.server.service.ShopgoodsService;

@Controller
public class ShopgoodsController {

	@Autowired
	private ShopgoodsService shopgoodsService;
	
	@ResponseBody
	@RequestMapping("/index")
	public void getShopgoods(ModelMap map,HttpServletRequest request,HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		System.out.println("直接 PrintWriter输出json");
		PrintWriter writer = response.getWriter();
		List<Shopgoods> shopgoods = shopgoodsService.getAllShopgoods();
		JSONArray array = new JSONArray();
		for(Shopgoods shopgood:shopgoods) {
			JSONObject object = new JSONObject();
			object.put("shopName", shopgood.getShop_name());
			object.put("state", shopgood.getShopgoods_state());
			object.put("describe", shopgood.getShopgoods_describe());
			object.put("image", shopgood.getShopgoods_image());
			object.put("price", shopgood.getShopgodds_price());
			object.put("shopgoods_id", shopgood.getShopgoods_id());
			object.put("shop_id", shopgood.getShop_id());
			array.put(object);
		}
		writer.println(array.toString());
		writer.flush();
		writer.close();
		/*
		response.getWriter().append(array.toString()).append(request.getContextPath());
		System.out.println("测试3");
		ModelAndView view = new ModelAndView("index.jsp");
		view.addObject("error","成功");
		*/
	}
}
