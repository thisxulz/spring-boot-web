package com.zcool.web.controller;

import java.util.Date;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zcool.web.dao.model.UserInfo;
import com.zcool.web.service.TestService;

/**
 * @title jsp页面 
 * @author xulz
 * @date 2018年4月16日下午2:55:27
 */
@Controller
public class TestController {
	private static final Logger logger = LoggerFactory.getLogger(TestController.class);
	
	@Autowired
	private TestService testService;

	@GetMapping("/")
	public String welcome(Map<String, Object> model) {
		model.put("time", new Date());
		model.put("message", "Hello, world!");
		return "welcome";
	}

	@RequestMapping(value = "/user")
	public String user(HttpServletRequest request, HttpServletResponse response) {
		String id = request.getParameter("id");
		logger.info("user , id = " + id);
		UserInfo user = testService.getUser(Long.valueOf(id));
		request.setAttribute("user", user);
		return "user";
	}
}
