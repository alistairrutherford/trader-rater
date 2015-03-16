package com.netthreads.trader;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration.Dynamic;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

/**
 * Web startup
 * 
 * Create application context and register configuration object.
 *
 * Implementations of this SPI will be detected automatically by
 * SpringServletContainerInitializer, which itself is bootstrapped automatically
 * by any Servlet 3.0 container. See its Javadoc for details on this
 * bootstrapping mechanism.
 */
public class WebInitializer implements WebApplicationInitializer
{
	
	public void onStartup(ServletContext servletContext) throws ServletException
	{
		
		AnnotationConfigWebApplicationContext ctx = new AnnotationConfigWebApplicationContext();
		ctx.register(WebConfiguration.class);
		ctx.setServletContext(servletContext);
		
		Dynamic servlet = servletContext.addServlet("dispatcher", new DispatcherServlet(ctx));
		servlet.addMapping("/");
		servlet.setLoadOnStartup(1);
		
	}

}
