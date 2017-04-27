package com.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ivan.entity.User;
import com.service.inteface.UserService;

/**
 * @author ivan
 *
 */
@Controller
@RequestMapping("/user")
public class UserController {
	
	@SuppressWarnings("unused")
	private static final Logger logger = LoggerFactory.getLogger(UserController.class);
	
	 @Autowired
	private UserService userService;
	/**
	 * 主页面跳转
	 * @return index.jsp
	 */
	@RequestMapping("/")
	public String goIndex(){
		return "index";
	}
	/**
	 * 新增user
	 */
	@RequestMapping("/insert")
	@ResponseBody
	public List<User> insert(){
		User user = new User(3,"jack",18);
		if(userService==null){
			System.out.println("null");
		}
		userService.insert(user);
		return getUsers();
	}
	/**
	 * 按条件新增user
	 */
	@RequestMapping("/insertSelective")
	@ResponseBody
    public List<User> insertSelective(){
    	User user = new User(2,"ivan",25);
        userService.insertSelective(user);
        return getUsers();
    }
	
	/**
	 * 查询所有用户
	 */
	@RequestMapping("/list")
	@ResponseBody
	public List<User> getUsers(){
		return userService.getUsers();
	}
	
	/**
	 *根据id获取user
	 *@param 用户id
	 */
	@RequestMapping("/one")
	@ResponseBody
	public User getUserById(String id){
		return userService.selectByPrimaryKey(Integer.valueOf(id));
	}
	
	/**
	 *根据id删除user
	 *@param 用户id
	 */
	@RequestMapping("/delete")
	@ResponseBody
	public List<User> deleteUserById(String id){
		userService.deleteByPrimaryKey(Integer.valueOf(id));
		return getUsers();
	}
	
	/**
	 *根据id更新user
	 *@param 用户id
	 */
	@RequestMapping("/updateById")
	@ResponseBody
	public User updateUserById(String id){
		User user = new User(Integer.valueOf(id),"ivan",30);
		userService.updateByPrimaryKey(user);
		return userService.selectByPrimaryKey(Integer.valueOf(id));
	}
}

