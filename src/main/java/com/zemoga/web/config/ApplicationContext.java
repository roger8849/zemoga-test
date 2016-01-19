package com.zemoga.web.config;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.zemoga.web.util.ApplicationConstants;
import com.zemoga.web.util.PropertiesUtil;

@Configuration
public class ApplicationContext {
	@Bean(name = "dataSource")
	public BasicDataSource getDataSource() {
		BasicDataSource dataSource = new BasicDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl(new StringBuilder("jdbc:mysql://")
				.append(PropertiesUtil.getString(ApplicationConstants.DATABASE_URL_KEY)).toString());
		dataSource.setUsername(PropertiesUtil.getString(ApplicationConstants.DATABASE_USER_KEY));
		dataSource.setPassword(PropertiesUtil.getString(ApplicationConstants.DATABASE_PASSWORD_KEY));
		return dataSource;
	}
}
