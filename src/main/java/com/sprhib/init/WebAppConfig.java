/**
 * 
 */
package com.sprhib.init;

import java.util.Properties;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.JstlView;
import org.springframework.web.servlet.view.UrlBasedViewResolver;

// TODO: Auto-generated Javadoc
/**
 * The Class WebAppConfig.
 *
 * @author Eedanna
 */
@Configuration
@ComponentScan("com.sprhib")
@EnableWebMvc
@EnableTransactionManagement
@PropertySource("classpath:application.properties")
public class WebAppConfig {

	/**
	 * The Constructor.
	 */
	public WebAppConfig() {
		// TODO Auto-generated constructor stub
	}

	/** The Constant PROPERTY_NAME_DATABASE_DRIVER. */
	private static final String PROPERTY_NAME_DATABASE_DRIVER = "db.driver";

	/** The Constant PROPERTY_NAME_DATABASE_PASSWORD. */
	private static final String PROPERTY_NAME_DATABASE_PASSWORD = "db.password";

	/** The Constant PROPERTY_NAME_DATABASE_URL. */
	private static final String PROPERTY_NAME_DATABASE_URL = "db.url";

	/** The Constant PROPERTY_NAME_DATABASE_USERNAME. */
	private static final String PROPERTY_NAME_DATABASE_USERNAME = "db.username";

	/** The Constant PROPERTY_NAME_HIBERNATE_DIALECT. */
	private static final String PROPERTY_NAME_HIBERNATE_DIALECT = "hibernate.dialect";

	/** The Constant PROPERTY_NAME_HIBERNATE_SHOW_SQL. */
	private static final String PROPERTY_NAME_HIBERNATE_SHOW_SQL = "hibernate.show_sql";

	/** The Constant PROPERTY_NAME_ENTITYMANAGER_PACKAGES_TO_SCAN. */
	private static final String PROPERTY_NAME_ENTITYMANAGER_PACKAGES_TO_SCAN = "entitymanager.packages.to.scan";

	/** The env. */
	@Resource
	private Environment env;

	/**
	 * Data source.
	 *
	 * @return the data source
	 */
	@Bean
	public DataSource dataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();

		dataSource.setDriverClassName(env
				.getRequiredProperty(PROPERTY_NAME_DATABASE_DRIVER));
		dataSource.setUrl(env.getRequiredProperty(PROPERTY_NAME_DATABASE_URL));
		dataSource.setUsername(env
				.getRequiredProperty(PROPERTY_NAME_DATABASE_USERNAME));
		dataSource.setPassword(env
				.getRequiredProperty(PROPERTY_NAME_DATABASE_PASSWORD));

		return dataSource;
	}

	/**
	 * Session factory.
	 *
	 * @return the local session factory bean
	 */
	@Bean
	public LocalSessionFactoryBean sessionFactory() {
		LocalSessionFactoryBean sessionFactoryBean = new LocalSessionFactoryBean();
		sessionFactoryBean.setDataSource(dataSource());
		sessionFactoryBean
				.setPackagesToScan(env
						.getRequiredProperty(PROPERTY_NAME_ENTITYMANAGER_PACKAGES_TO_SCAN));
		sessionFactoryBean.setHibernateProperties(hibProperties());
		return sessionFactoryBean;
	}

	/**
	 * Hib properties.
	 *
	 * @return the properties
	 */
	private Properties hibProperties() {
		Properties properties = new Properties();
		properties.put(PROPERTY_NAME_HIBERNATE_DIALECT,
				env.getRequiredProperty(PROPERTY_NAME_HIBERNATE_DIALECT));
		properties.put(PROPERTY_NAME_HIBERNATE_SHOW_SQL,
				env.getRequiredProperty(PROPERTY_NAME_HIBERNATE_SHOW_SQL));
		return properties;
	}

	/**
	 * Transaction manager.
	 *
	 * @return the hibernate transaction manager
	 */
	@Bean
	public HibernateTransactionManager transactionManager() {
		HibernateTransactionManager transactionManager = new HibernateTransactionManager();
		transactionManager.setSessionFactory(sessionFactory().getObject());
		return transactionManager;
	}

	/**
	 * Setup view resolver.
	 *
	 * @return the url based view resolver
	 */
	@Bean
	public UrlBasedViewResolver setupViewResolver() {
		UrlBasedViewResolver resolver = new UrlBasedViewResolver();
		resolver.setPrefix("/WEB-INF/pages/");
		resolver.setSuffix(".jsp");
		resolver.setViewClass(JstlView.class);
		return resolver;
	}

}