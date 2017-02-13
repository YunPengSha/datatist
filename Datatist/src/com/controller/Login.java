package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.pojo.User;
import com.service.UserService;
import com.util.EmailUtil;
import com.util.MD5Util;
/*
 * 代码中有很多小细节没优化。比如验用正则验证邮箱账号，还有一些异常的处理等
 * jdk1.7 mysql5.5
 * 项目只涉及到一张表 user表
 * 里面有id(用户名),password(密码),status(邮箱状态)
 */
@Controller
public class Login {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping("/loginpage")
	public String loginPage(){
		return "login";
	}
	
	@RequestMapping("/login")
	public String login(String username,String password){
		ModelAndView a=new ModelAndView();
		User user=new User();
		user.setId(username);
		user.setPassword(MD5Util.MD5(password));
		user.setStatus(0);
		int i = userService.login(user);
		if(i == -2){
			a.getModel().put("msg","璐﹀彿瀵嗙爜鍑洪敊");
			a.setViewName("error");
		}
		if(i == -1){
			a.getModel().put("msg","璐﹀彿鏈縺娲伙紝璇峰厛鍘婚偖绠辨縺娲�");
			a.setViewName("error");
		}
		return "success";
	}
	@RequestMapping("/registerPage")
	public String registerPage(){
		return "register";
	}
	
	@RequestMapping("/register")
	public ModelAndView Register(String username,String password){
		ModelAndView a=new ModelAndView();
		if(username==null){
			a.getModel().put("msg","鐢ㄦ埛鍚嶄笉鑳戒负绌�");
			a.setViewName("error");
			return a;
		}
		if(password==null){
			a.getModel().put("msg","瀵嗙爜涓嶈兘涓虹┖");
			a.setViewName("error");
			return a;
		}
		User user=new User();
		user.setId(username);
		user.setPassword(MD5Util.MD5(password));
		user.setStatus(0);
		int i = userService.register(user);
		if(i == -1){
			a.getModel().put("msg","璇ョ敤鎴峰凡缁忔敞鍐岋紝璇锋崲鍏朵粬鐢ㄦ埛");
			a.setViewName("error");
			return a;
		}
		a.setViewName("registerSuccess");
		EmailUtil.sendEmail(user);
		return a;
	}
}
