package com.zcool.web.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zcool.web.dao.model.UserInfo;
import com.zcool.web.dao.persistence.UserInfoMapper;
import com.zcool.web.service.TestService;

@Service
public class TestServiceImpl implements TestService{

	@Autowired
	private UserInfoMapper userInfoMapper;
	
	@Override
	public UserInfo getUser(long userId) {
		return userInfoMapper.selectByPrimaryKey(userId);
	}

	
}
