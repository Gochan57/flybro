package com.volgadev.springtemplate.config;

import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
public class HibernateConfig {
	static final Logger LOGGER = LoggerFactory.getLogger(HibernateConfig.class);
	@Autowired
	Environment env;
	@Autowired
	private DriverManagerDataSource dataSource;

	@Bean
	public LocalSessionFactoryBean sessionFactory() {
		System.out.println("Creating entity Manager");
		LOGGER.info("DATASOURCE :" + dataSource);
		LocalSessionFactoryBean factoryBean = new LocalSessionFactoryBean();
		factoryBean.setDataSource(dataSource);
		factoryBean.setPackagesToScan("com.volgadev.springtemplate.model");
		factoryBean.setHibernateProperties(additionalProperties());
		return factoryBean;
	}

	private Properties additionalProperties() {
		Properties properties = new Properties();
		properties.put("hibernate.dialect", org.hibernate.dialect.PostgreSQLDialect.class);
		properties.put("hibernate.show_sql", Boolean.TRUE);
		properties.put("hibernate.format_sql", Boolean.TRUE);
		properties.put("use_sql_comments", Boolean.TRUE);
		properties.put("default_batch_fetch_size", 10);
		properties.put("hibernate.hbm2ddl.auto", "update");
		// properties.put("hibernate.cache.use_second_level_cache",
		// Boolean.TRUE);
		// properties.put("hibernate.cache.use_query_cache", Boolean.TRUE);
		// properties.put("hibernate.cache.region.factory_class",EhCacheRegionFactory.class);
		return properties;
	}

	@Bean
	public HibernateTransactionManager transactionManager() {

		HibernateTransactionManager txManager = new HibernateTransactionManager();
		LOGGER.info("Obj :" + sessionFactory());
		txManager.setSessionFactory(sessionFactory().getObject());
		return txManager;
	}

}
