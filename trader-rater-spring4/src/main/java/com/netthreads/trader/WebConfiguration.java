package com.netthreads.trader;


import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Description;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.format.FormatterRegistry;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.thymeleaf.spring4.SpringTemplateEngine;
import org.thymeleaf.spring4.view.ThymeleafViewResolver;
import org.thymeleaf.templateresolver.ServletContextTemplateResolver;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.netthreads.trader.convertor.SolutionTaskJobTypeConvertor;
import com.netthreads.trader.convertor.SolutionTaskTypeConvertor;
import com.netthreads.trader.convertor.SolutionTypeConvertor;

/**
 * Web configuration.
 *
 */
// Marks this class as configuration
@Configuration
// Specifies which package to scan
@ComponentScan("com.netthreads.trader")
// Enables Spring's annotations
@EnableWebMvc
public class WebConfiguration extends WebMvcConfigurerAdapter
{
	public static final String DEFAULT_PREFIX = "/WEB-INF/templates/";
	public static final String DEFAULT_SUFFIX = ".html";
	public static final String DEFAULT_MODE = "HTML5";
	public static final String[] DEFAULT_VIEW_NAMES =
	{
		"*"
	};

	// Hot re-load, false=will reload changes.
	public static final boolean DEFAULT_CACHE = false;

	@Bean
	public ServletContextTemplateResolver templateResolver()
	{
		ServletContextTemplateResolver resolver = new ServletContextTemplateResolver();
		resolver.setPrefix(DEFAULT_PREFIX);
		resolver.setSuffix(DEFAULT_SUFFIX);
		resolver.setTemplateMode(DEFAULT_MODE);

		return resolver;
	}

	@Bean
	public SpringTemplateEngine templateEngine()
	{
		SpringTemplateEngine engine = new SpringTemplateEngine();
		engine.setTemplateResolver(templateResolver());

		// Need this for hot re-load
		if (!DEFAULT_CACHE)
		{
			engine.setCacheManager(null);
		}

		return engine;
	}

	@Bean
	public ViewResolver viewResolver()
	{
		ThymeleafViewResolver viewResolver = new ThymeleafViewResolver();
		viewResolver.setTemplateEngine(templateEngine());
		viewResolver.setOrder(1);
		viewResolver.setCache(DEFAULT_CACHE);
		viewResolver.setViewNames(DEFAULT_VIEW_NAMES);

		return viewResolver;
	}

	@Bean
	@Description("Spring message resolver")
	public ResourceBundleMessageSource messageSource()
	{
		ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
		messageSource.setBasename("messages");

		return messageSource;
	}

	/**
	 * Add our static resources folder mapping.
	 * 
	 */
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry)
	{
		registry.addResourceHandler("/static/**").addResourceLocations("/static/");
	}

	/**
	 * Register formatters.
	 * 
	 */
	@Override
	public void addFormatters(FormatterRegistry registry)
	{
		registry.addConverter(new SolutionTypeConvertor());
		registry.addConverter(new SolutionTaskTypeConvertor());
		registry.addConverter(new SolutionTaskJobTypeConvertor());
	}
	
	/**
	 * Need this to return JSON in data request.
	 *
	 * http://stackoverflow.com/questions/4823358/spring-configure-responsebody-json-format
	 */
	@Override
	public void configureMessageConverters(List<HttpMessageConverter<?>> converters)
	{
		final MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
		final ObjectMapper objectMapper = new ObjectMapper();
		objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
		converter.setObjectMapper(objectMapper);
		converters.add(converter);
		super.configureMessageConverters(converters);
	}
}
