package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.pojo.User;
import com.service.UserService;

@Controller
public class Activation {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping("/activaion/{id}/{password}")
	public String activation(@PathVariable String id,@PathVariable String password){
		User user=new User();
		user.setId(id);
		user.setPassword(password);
		userService.activation(user);
		return "activationSuccess";
	}
}
