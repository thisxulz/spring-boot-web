package com.zcool.web.controller;

import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({"com.zcool.web"})
@MapperScan("com.zcool.web.dao.persistence")
public class TomcatApplication extends SpringBootServletInitializer{
	private static final Logger logger = LoggerFactory.getLogger(TomcatApplication.class);

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(TomcatApplication.class);
	}

	public static void main(String[] args) {
		logger.debug("服务启动");
		SpringApplication.run(TomcatApplication.class, args);
	}
}
