package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mapper.UserMapper;
import com.pojo.User;
import com.pojo.UserExample;
import com.pojo.UserExample.Criteria;

@Service
public class UserService {
	@Autowired
	private UserMapper userMapper;
	
	public User getUser(){
		User u= userMapper.selectByPrimaryKey("1");
		return u;
	}

	public int register(User user) {
		User u = userMapper.selectByPrimaryKey(user.getId());
		if(u != null)
			return -1;
		int i = userMapper.insert(user);
		return i;
	}

	public int login(User user) {
		// TODO Auto-generated method stub
		UserExample u=new UserExample();
		Criteria criteria = u.createCriteria();
		criteria.andIdEqualTo(user.getId());
		criteria.andPasswordEqualTo(user.getPassword());
		List<User> list = userMapper.selectByExample(u);
		if(list == null)
			return -2;
		if(list.get(0).getStatus()==0)
			return -1;
		return 0;
	}

	public void activation(User user) {
		user.setStatus(1);
		userMapper.updateByPrimaryKey(user);
	}
	
	
}
