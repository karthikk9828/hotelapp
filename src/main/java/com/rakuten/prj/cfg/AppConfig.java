package com.rakuten.prj.cfg;

import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
public class AppConfig {
	// configure datasource
	@Bean
	public DriverManagerDataSource dataSource() {
		DriverManagerDataSource ds = new DriverManagerDataSource();
		ds.setDriverClassName("com.mysql.jdbc.Driver"); // driver of the backend provider
		ds.setUrl("jdbc:mysql://localhost:3306/hotel_db?createDatabaseIfNotExist=true");
		// rakuten_2020_db is the name of the database
		// 3306 is the default port number for MySQL and create database if the database
		// is not in existence
		ds.setUsername("root"); // Default user
		ds.setPassword("john&9828"); // MySQL server password
		return ds;
	}

	// configure EntityManagerFactory
	@Bean
	public LocalContainerEntityManagerFactoryBean emf(DataSource ds) {
		LocalContainerEntityManagerFactoryBean emf = new LocalContainerEntityManagerFactoryBean();
		emf.setDataSource(ds);
		emf.setJpaVendorAdapter(new HibernateJpaVendorAdapter()); // The provider of ORM framework
		emf.setPackagesToScan("com.rakuten.prj.entity"); // Entities separated by ,
		Properties props = new Properties();
		props.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL5Dialect");
		// ORM generates SQL compatible with MySQL5
		props.setProperty("hibernate.hbm2ddl.auto", "update"); // if table exists use table or else create table
		// ddl --> data definition language --> create, alter, drop
		// dml --> data manipulation language
		emf.setJpaProperties(props);
		return emf;
	}

	@Bean
	public PlatformTransactionManager transactionManager() {
		return new JpaTransactionManager();
	}
}
