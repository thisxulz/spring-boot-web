package com.zcool.web;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.alibaba.fastjson.JSON;
import com.zcool.web.controller.TomcatApplication;
import com.zcool.web.dao.model.UserInfo;
import com.zcool.web.service.TestService;

/**
 * @title 单元测试类
 * @author xulz
 * @date 2018年4月16日下午4:27:37
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = TomcatApplication.class)
public class ServiceTest {
	
	@Autowired
	private TestService testService;

	@Test
	public void testExample() {
		try {
			UserInfo user = testService.getUser(13128901l);
			System.out.println("======" + JSON.toJSONString(user));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
