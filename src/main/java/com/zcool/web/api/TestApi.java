package com.zcool.web.api;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.zcool.web.dao.model.UserInfo;
import com.zcool.web.service.TestService;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value="/api")
public class TestApi {
	private static final Logger logger = LoggerFactory.getLogger(TestApi.class);
	
	@Autowired
	private TestService testService;

	@RequestMapping(value = "/getUserRest/{id}", method = RequestMethod.GET)
	@ApiOperation(value = "获取用户数据",notes = "接口具体的描述")
	@ApiImplicitParams({//请求参数描述
        @ApiImplicitParam(name = "id", value = "用户的ID", required = true, dataTypeClass = Long.class),
	})
	public UserInfo getUserRest(@PathVariable("id") Long id) {
		logger.info("getUser , id = " + id);
		UserInfo user = testService.getUser(Long.valueOf(id));
		return user;
	}
	
	@RequestMapping(value = "/getUser", method = RequestMethod.GET)
	@ApiOperation(value = "获取用户数据",notes = "接口具体的描述")
	@ApiImplicitParams({//请求参数描述
        @ApiImplicitParam(name = "id", value = "用户的ID", required = true, dataTypeClass = Long.class),
	})
	public UserInfo getUser(HttpServletRequest request, HttpServletResponse response) {
		String id = request.getParameter("id");
		logger.info("getJson , id = " + id);
		UserInfo user = testService.getUser(Long.valueOf(id));
		return user;
	}
}
