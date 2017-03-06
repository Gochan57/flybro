package com.hms.pro.config;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration
@PropertySource({ "classpath:globels.properties" })
@EnableJpaRepositories(basePackages = "com.hms.pro.dao")
public class JpaConfig {

	private static Logger logger = Logger.getLogger(JpaConfig.class);

	@Autowired
	Environment environment;

	@Bean
	public DriverManagerDataSource dataSource() {
		// You can use C3po connection pool here for better performance to the
		// application
		System.out.println("JDBC USERNAME :" + environment.getProperty("jdbc.username") + " password :"
				+ environment.getProperty("jdbc.password"));
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName(environment.getProperty("jdbc.driverClassName").trim());
		dataSource.setUrl(environment.getProperty("jdbc.url").trim());
		dataSource.setUsername(environment.getProperty("jdbc.username").trim());
		dataSource.setPassword(environment.getProperty("jdbc.password").trim());
		return dataSource;
	}

	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
		LocalContainerEntityManagerFactoryBean emf = new LocalContainerEntityManagerFactoryBean();
		emf.setDataSource(dataSource());
		emf.setJpaVendorAdapter(this.jpaAdapter());
		emf.setPersistenceUnitName("user-db");
		return emf;
	}

	@Bean
	public JpaVendorAdapter jpaAdapter() {
		HibernateJpaVendorAdapter hibernateJpaVendorAdapter = new HibernateJpaVendorAdapter();
		hibernateJpaVendorAdapter.setShowSql(true);
		hibernateJpaVendorAdapter.setDatabase(Database.MYSQL);
		return hibernateJpaVendorAdapter;
	}

	@Bean
	public PlatformTransactionManager transactionManager() {
		return new JpaTransactionManager(entityManagerFactory().getObject());
	}

}
