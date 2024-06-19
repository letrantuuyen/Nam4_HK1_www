package com.sv.iuh.config;

import java.beans.PropertyVetoException;
import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.mchange.v2.c3p0.ComboPooledDataSource;

@Configuration
@EnableWebMvc
@EnableTransactionManagement
@ComponentScan("com.sv.iuh")
@PropertySource({"classpath:persistence.properties"})
public class AppConfig implements WebMvcConfigurer{
	@Autowired
	private Environment env;
	
	@Bean
	public DataSource myDataSource() {
		ComboPooledDataSource myDataSource= new ComboPooledDataSource();
		try {
			myDataSource.setDriverClass(env.getProperty("jdbc.driver"));
			
		} catch (PropertyVetoException e) {
			throw new RuntimeException(e);
		}
		
		myDataSource.setJdbcUrl(env.getProperty("jdbc.url"));
		myDataSource.setUser(env.getProperty("jdbc.user"));
		myDataSource.setPassword(env.getProperty("jdbc.password"));
		
		myDataSource.setInitialPoolSize(getIntproperty("connection.pool.initialPoolSize"));
		myDataSource.setMinPoolSize(getIntproperty("connection.pool.minPoolSize"));
		myDataSource.setMaxPoolSize(getIntproperty("connection.pool.maxPoolSize"));
		myDataSource.setMaxIdleTime(getIntproperty("connection.pool.maxIdleTime"));
		return myDataSource;
		
	}
	private int getIntproperty(String propName) {
		String popVal=env.getProperty(propName);
		int intPropVal=Integer.parseInt(popVal);
		return intPropVal;
	}
	private Properties getHibernateProperties() {
		Properties properties= new Properties();
		properties.setProperty("hibernate.dialect",env.getProperty("hibernate.dialect"));
		properties.setProperty("hibernate.show_sql",env.getProperty("hibernate.show_sql"));
		return properties;
	}
	@Bean
	public LocalSessionFactoryBean sessionFactoryBean() {
		LocalSessionFactoryBean sessionFactoryBean= new LocalSessionFactoryBean();
		sessionFactoryBean.setDataSource(myDataSource());
		sessionFactoryBean.setPackagesToScan(env.getProperty("hibernate.packagesToScan"));
		return sessionFactoryBean;
	}
	@Bean
	@Autowired
	public HibernateTransactionManager transactionManager(SessionFactory sessionFactory) {
		HibernateTransactionManager txManager= new HibernateTransactionManager();
		txManager.setSessionFactory(sessionFactory);
		return txManager;
	}
}
