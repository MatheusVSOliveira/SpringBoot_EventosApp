package com.eventoapp.data;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

@Configuration
public class DataConfiguration {

	@Bean
	public DataSource dataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/eventosapp");
		dataSource.setUsername("root");
		dataSource.setPassword("mv2014");
		return dataSource;
	}

	@Bean
	public JpaVendorAdapter jpaVendoAdapter() {
		HibernateJpaVendorAdapter adapter = new HibernateJpaVendorAdapter();
		adapter.setDatabase(Database.MYSQL);
		adapter.setShowSql(true);
		adapter.setGenerateDdl(true);
		adapter.setDatabasePlatform("org.hibernate.dialect.MySQL8Dialect");
		adapter.setPrepareConnection(true);
		return adapter;

		/*Configuração para criar as tabelas automaticamente no banco de dados postgre ao realizar o deploy.
		 * 
		 * public JpaVendorAdapter jpaVendorAdapter() { HibernateJpaVendorAdapter
		 * adapter = new HibernateJpaVendorAdapter();
		 * adapter.setDatabase(Database.POSTGRESQL); adapter.setShowSql(true);
		 * adapter.setGenerateDdl(true);
		 * adapter.setDatabasePlatform("org.hibernate.dialect.PostgreSQLDialect");
		 * adapter.setPrepareConnection(true); return adapter; }
		 */
	}
}
