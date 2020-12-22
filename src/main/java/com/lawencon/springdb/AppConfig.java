package com.lawencon.springdb;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author lawencon05
 */
@Configuration
@ComponentScan(basePackages = "com.lawencon.springdb")
@EnableTransactionManagement
public class AppConfig {

	@Autowired
	private SessionFactory sessionFactory;

	@Bean
	public DataSource getDataSource() {
		DriverManagerDataSource dm = new DriverManagerDataSource();
		dm.setDriverClassName("org.postgresql.Driver");
		dm.setUrl("jdbc:postgresql://localhost:5432/dummy");
		dm.setUsername("postgres");
		dm.setPassword("postgres");

		return dm;
	}

	@Bean
	public LocalSessionFactoryBean getSessionFactory() {
		LocalSessionFactoryBean ls = new LocalSessionFactoryBean();
		ls.setDataSource(getDataSource());

		Properties p = new Properties();
		p.setProperty("hibernate.dialect", "org.hibernate.dialect.PostgreSQL82Dialect");
		p.setProperty("hibernate.show_sql", "true");
		p.setProperty("hibernate.hbm2ddl.auto", "update");
		ls.setHibernateProperties(p);

		ls.setPackagesToScan("com.lawencon.springdb.model");

		return (LocalSessionFactoryBean) ls;
	}

	@Bean
	public HibernateTransactionManager getTransManager() {
		return new HibernateTransactionManager(sessionFactory);
	}

}
