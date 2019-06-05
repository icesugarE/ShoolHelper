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

import com.steadyjack.server.model.Connection;
import com.steadyjack.server.model.Reward;
import com.steadyjack.server.model.User;
import com.steadyjack.server.service.ConnectionService;
import com.steadyjack.server.service.RewardService;
import com.steadyjack.server.service.UserService;


@Controller
public class RewardController {

	@Autowired
	private RewardService rewardservice;
	private UserService userservice;
	private ConnectionService connectionservice;
	
	
	@RequestMapping("/boraditem")
	@ResponseBody
	public void boardItem(ModelMap map,HttpServletRequest request,HttpServletResponse response) throws Exception{
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		PrintWriter writer = response.getWriter();
		List<Reward> rewardList = rewardservice.selectBoardReward();
		JSONArray array = new JSONArray();
		for(Reward reward:rewardList) {
			JSONObject object = new JSONObject();
			object.put("userId", reward.getPoster());
			object.put("rewardId", reward.getRewardId());
			object.put("name", getName(reward));
			object.put("sex", getSex(reward));
			object.put("title", reward.getRewardTitle());
			object.put("content", reward.getRewardContent());
			object.put("rewardTime", reward.getRewardTime());
			object.put("endTime", reward.getRewardDeadline());
			object.put("money", reward.getRewardMoney());
			array.put(object);
		}
		writer.println(array.toString());
		writer.flush();
		writer.close();
	}
	
	@RequestMapping("/myfinish")
	@ResponseBody
	public void myFinish(ModelMap map,HttpServletRequest request,HttpServletResponse response) throws Exception{
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		PrintWriter writer = response.getWriter();
		int userId=Integer.parseInt(request.getParameter("userId"));
		JSONArray array=new JSONArray();
		List<Reward> rewardList=rewardservice.MyPublish(userId);
		for(Reward reward:rewardList) {
			if(reward.getRewardState().equals("4")) {
			JSONObject json14=new JSONObject();
			json14.put("userId", reward.getPoster());
			json14.put("rewardId", reward.getRewardId());
			json14.put("name", getName(reward));
			json14.put("sex", getSex(reward));
			json14.put("title", reward.getRewardTitle());
			json14.put("content", reward.getRewardContent());
			json14.put("rewardTime", reward.getRewardTime());
			json14.put("endTime", reward.getRewardDeadline());
			json14.put("money", reward.getRewardMoney());
			json14.put("state", reward.getRewardState());
			array.put(json14);
			System.err.println(json14);
			}
		}
		writer.println(array.toString());
		writer.flush();
		writer.close();
	}
	
	@RequestMapping("/mypublish")
	@ResponseBody
	public void myPublish(ModelMap map,HttpServletRequest request,HttpServletResponse response) throws Exception{
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		PrintWriter writer = response.getWriter();
		int userId=Integer.parseInt(request.getParameter("userId"));
		JSONArray array=new JSONArray();
		List<Reward> rewardList = rewardservice.MyPublish(userId);
		for(Reward reward:rewardList) {
			JSONObject json12=new JSONObject();
			json12.put("userId", reward.getPoster());
			json12.put("rewardId", reward.getRewardId());
			json12.put("name", getName(reward));
			json12.put("sex", getSex(reward));
			json12.put("title", reward.getRewardTitle());
			json12.put("content", reward.getRewardContent());
			json12.put("rewardTime", reward.getRewardTime());
			json12.put("endTime", reward.getRewardDeadline());
			json12.put("money", reward.getRewardMoney());
			json12.put("state", reward.getRewardState());
			array.put(json12);
			System.err.println(json12);
		}
		writer.println(array.toString());
		writer.flush();
		writer.close();
	}
	
	
	@RequestMapping("/publishreward")
	@ResponseBody
	public void publishReward(ModelMap map,HttpServletRequest request,HttpServletResponse response) throws Exception{
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		PrintWriter writer = response.getWriter();
		JSONArray array=new JSONArray();
		int posterId = Integer.parseInt(request.getParameter("posterId"));
		String rewardTitle = request.getParameter("rewardTitle");
		String rewardContent = request.getParameter("rewardContent");
		String rewardImage = request.getParameter("imgUrl");
		String rewardTime = request.getParameter("publishTime");
		String rewardDeadline = request.getParameter("deadline");
		double rewardMoney = Double.parseDouble(request.getParameter("rewardMoney"));
		//此为创建赏金，状态默认为“1”
		String rewardState = "1";
		User user=getUser(posterId);
		Reward reward =new Reward(user,rewardContent,rewardTitle,rewardMoney,rewardTime,rewardDeadline,rewardState,rewardImage);
		rewardservice.setReward(reward);
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("response", "success");
		array.put(jsonObject);
		writer.println(array.toString());
		writer.flush();
		writer.close();
	}
	
	@RequestMapping("/task")
	@ResponseBody
	public void task(ModelMap map,HttpServletRequest request,HttpServletResponse response) throws Exception{
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		PrintWriter writer = response.getWriter();
		JSONArray array=new JSONArray();
		int userId=Integer.parseInt(request.getParameter("userId"));
		//发布任务的被接受然后接收者点击已完成在发布人那里显示待确认
		List<Connection> connectionListone = connectionservice.selectConnectionone(userId);
		for(Connection con:connectionListone) {
			List<Reward> rewardListtwo = rewardservice.MyPublishone(con.getRewardId());
			for(Reward rewardone:rewardListtwo) {
				if(rewardone.getRewardState().equals("3")) {
				JSONObject json15 = new JSONObject();
				json15.put("userId", rewardone.getPoster());
				json15.put("rewardId", rewardone.getRewardId());
				json15.put("name", getName(rewardone));
				json15.put("sex", getSex(rewardone));
				json15.put("title", rewardone.getRewardTitle());
				json15.put("content", rewardone.getRewardContent());
				json15.put("rewardTime", rewardone.getRewardTime());
				json15.put("endTime", rewardone.getRewardDeadline());
				json15.put("money", rewardone.getRewardMoney());
				json15.put("state", rewardone.getRewardState());
				array.put(json15);
				System.err.println(json15);
//				rewardList=null;
				}
			}
		}
		
		//接受发布人的任务在接受人那里显示待完成
		List<Connection> connectionList =connectionservice.selectConnection(userId);
		for(Connection con:connectionList) {
			List<Reward> rewardListone = rewardservice.MyPublishone(con.getRewardId());
			for(Reward reward:rewardListone) {
				if(reward.getRewardState().equals("2")) {
				JSONObject json16 = new JSONObject();
				json16.put("userId", reward.getPoster());
				json16.put("rewardId", reward.getRewardId());
				json16.put("name", getName(con));
				json16.put("sex", getSex(con));
				json16.put("title", reward.getRewardTitle());
				json16.put("content", reward.getRewardContent());
				json16.put("rewardTime", reward.getRewardTime());
				json16.put("endTime", reward.getRewardDeadline());
				json16.put("money", reward.getRewardMoney());
				json16.put("state", reward.getRewardState());
				array.put(json16);
				System.err.println(json16);
//				rewardList=null;
				}
			}
		}
		writer.println(array.toString());
		writer.flush();
		writer.close();
	}
	
	private User getUser(int id) {
		User user=userservice.checkUser(id);
		return user;
	}
	
	private String getName(Connection con) {
		User user=userservice.checkUser(con.getPosterId());
		String name=user.getUserName();
		return name;
	}
	private String getSex(Connection con) {
		User user = userservice.checkUser(con.getPosterId());
		String sex = user.getUserSex();
		return sex;
	}
	
	
	private String getName(Reward reward) {
		User user = userservice.checkUser(reward.getPoster());
		String name = user.getUserName();
		return name;
	}
	private String getSex(Reward reward) {
		User user = userservice.checkUser(reward.getPoster());
		String sex = user.getUserSex();
		return sex;
	}
}
