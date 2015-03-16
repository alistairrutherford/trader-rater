package com.netthreads.test.system;

import java.util.Properties;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.core.io.ClassPathResource;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.jdbc.datasource.init.DataSourceInitializer;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;
import org.springframework.orm.jpa.JpaDialect;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.EclipseLinkJpaDialect;
import org.springframework.orm.jpa.vendor.EclipseLinkJpaVendorAdapter;
import org.springframework.orm.jpa.vendor.HibernateJpaDialect;

@Configuration
@EnableAspectJAutoProxy(proxyTargetClass = false)
@EnableJpaRepositories(basePackages =
{
	"com.netthreads.trader.dao"
})
@ComponentScan(value =
{
	"com.netthreads"
})
@PropertySource("classpath:/database.properties")
public class PersistenceConfiguration
{
	private static final String PROPERTY_NAME_DATABASE_DRIVER = "javax.persistence.jdbc.driverorg.h2.Driver";
	private static final String PROPERTY_NAME_DATABASE_USERNAME = "javax.persistence.jdbc.user";
	private static final String PROPERTY_NAME_DATABASE_PASSWORD = "javax.persistence.jdbc.password";
	private static final String PROPERTY_NAME_DATABASE_URL = "javax.persistence.jdbc.url";

	private static final String PROPERTY_NAME_DATABASE_ACTION = "javax.persistence.schema-generation.database.action";
	private static final String PROPERTY_NAME_DATABASE_LOAD_SCRIPT_SOURCE = "javax.persistence.sql-load-script-source";
	private static final String PROPERTY_NAME_DATABASE_LOGGING_LEVEL = "eclipselink.logging.level";
	private static final String PROPERTY_NAME_DATABASE_WEAVING = "eclipselink.weaving";

	private static final String DOMAIN_PACKAGES[] =
	{
		"com.netthreads.trader.domain"
	};

	@Resource
	private Environment env;

	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory()
	{
		EclipseLinkJpaVendorAdapter vendorAdapter = new EclipseLinkJpaVendorAdapter();
		vendorAdapter.setGenerateDdl(true);
		vendorAdapter.setShowSql(true);

		LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
		factory.setJpaVendorAdapter(vendorAdapter);
		factory.setJpaDialect(jpaVendorDialect());
		factory.setPackagesToScan(DOMAIN_PACKAGES);
		factory.setDataSource(dataSource());
		factory.setJpaProperties(jpaProperties());

		return factory;
	}

	@Bean
	public PersistenceExceptionTranslationPostProcessor persistenceExceptionTranslationPostProcessor()
	{
		return new PersistenceExceptionTranslationPostProcessor();
	}

	/**
	 * JPA properties.
	 * 
	 * @return The properties.
	 */
	private Properties jpaProperties()
	{
		Properties properties = new Properties();
		properties.put(PROPERTY_NAME_DATABASE_DRIVER, env.getRequiredProperty(PROPERTY_NAME_DATABASE_DRIVER));
		properties.put(PROPERTY_NAME_DATABASE_USERNAME, env.getRequiredProperty(PROPERTY_NAME_DATABASE_USERNAME));
		properties.put(PROPERTY_NAME_DATABASE_PASSWORD, env.getRequiredProperty(PROPERTY_NAME_DATABASE_PASSWORD));
		properties.put(PROPERTY_NAME_DATABASE_URL, env.getRequiredProperty(PROPERTY_NAME_DATABASE_URL));

		properties.put(PROPERTY_NAME_DATABASE_ACTION, env.getRequiredProperty(PROPERTY_NAME_DATABASE_ACTION));
		properties.put(PROPERTY_NAME_DATABASE_LOGGING_LEVEL, env.getRequiredProperty(PROPERTY_NAME_DATABASE_LOGGING_LEVEL));
		properties.put(PROPERTY_NAME_DATABASE_WEAVING, env.getRequiredProperty(PROPERTY_NAME_DATABASE_WEAVING));

		return properties;
	}

	/**
	 * Create transaction manager.
	 * 
	 * @return The transaction manager.
	 */
	@Bean
	public JpaTransactionManager transactionManager()
	{
		JpaTransactionManager txManager = new JpaTransactionManager();
		txManager.setEntityManagerFactory(entityManagerFactory().getObject());
		return txManager;
	}

	/**
	 * Create data source.
	 * 
	 * @return The data source.
	 */
	@Bean
	public DataSource dataSource()
	{
		DataSource dataSource = new EmbeddedDatabaseBuilder().setType(EmbeddedDatabaseType.H2).build();

		return dataSource;
	}

	public static final String ECLIPSELINK_ENTITY_MANAGER_CLASS = "org.eclipse.persistence.jpa.JpaEntityManager";

	private JpaDialect jpaVendorDialect()
	{
		JpaDialect jpaDialect = null;
		try
		{
			Class.forName(ECLIPSELINK_ENTITY_MANAGER_CLASS);
			jpaDialect = new EclipseLinkJpaDialect();
		}
		catch (ClassNotFoundException e)
		{
			jpaDialect = new HibernateJpaDialect();
		}
		return jpaDialect;
	}

	/**
	 * Define this to load in script to populate after setup.
	 * 
	 * @param dataSource
	 * 
	 * @return the initialiser.
	 */
	@Bean
	public DataSourceInitializer dataSourceInitializer(DataSource dataSource)
	{
		String script = env.getRequiredProperty(PROPERTY_NAME_DATABASE_LOAD_SCRIPT_SOURCE);

		DataSourceInitializer dataSourceInitializer = new DataSourceInitializer();
		dataSourceInitializer.setDataSource(dataSource);
		ResourceDatabasePopulator databasePopulator = new ResourceDatabasePopulator();
		databasePopulator.addScript(new ClassPathResource(script));
		dataSourceInitializer.setDatabasePopulator(databasePopulator);
		dataSourceInitializer.setEnabled(true);
		return dataSourceInitializer;
	}

}
