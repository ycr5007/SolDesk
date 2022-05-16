package com.study.config;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

@Configuration // root-context.xml
@ComponentScan(basePackages = {"com.study.service", "com.study.task", "com.study.handler"}) // context:component-scan
@MapperScan(basePackages = {"com.study.mapper"}) // mybatis-spring:scan
@EnableScheduling // <task:annotation-driven/>
@EnableTransactionManagement // <tx:annotation-driven/>
public class RootConfig {
	
	/*
		<bean id="hikariConfig" class="com.zaxxer.hikari.HikariConfig">
			<property name="driverClassName" value="oracle.jdbc.OracleDriver" />
			<property name="jdbcUrl" value="jdbc:oracle:thin:@localhost:1521:xe" />
			<property name="username" value="javadb" />
			<property name="password" value="12345" />
		</bean>
		
		<bean id="ds" class="com.zaxxer.hikari.HikariDataSource">
			<constructor-arg ref="hikariConfig" />
		</bean>
	*/
	@Bean // Bean 선언
	public DataSource dataSource() {
		HikariConfig hikariConfig = new HikariConfig();
		hikariConfig.setDriverClassName("oracle.jdbc.OracleDriver");
		hikariConfig.setJdbcUrl("jdbc:oracle:thin:@localhost:1521:xe");
		hikariConfig.setUsername("javadb");
		hikariConfig.setPassword("12345");
		
		HikariDataSource datasource = new HikariDataSource(hikariConfig);
		return datasource;
	}
	
	/*
		<bean id="sqlSessionFactory" class="org.mybatis.spring.SqlSessionFactoryBean">
			<property name="dataSource" ref="ds" />
		</bean>
	*/
	@Bean
	public SqlSessionFactory sqlSessionFactory() throws Exception {
		SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
		sqlSessionFactoryBean.setDataSource(dataSource());
		return sqlSessionFactoryBean.getObject();
	}
	
	/*
		<bean id="sqlSessionFactory" class="org.mybatis.spring.SqlSessionFactoryBean">
			<property name="dataSource" ref="ds" />
		</bean>
	*/
	@Bean
	public DataSourceTransactionManager transactionManager() {
		return new DataSourceTransactionManager(dataSource());
	}
}
