package com.sacrum.users.config;

import org.springframework.beans.factory.ObjectFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.ConversionService;
import org.springframework.data.rest.webmvc.config.RepositoryRestMvcConfiguration;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.sacrum.users") /* riferisce al Dispatcher Servlet dove cercare le classi controller! */
public class WebApplicationContextConfig extends RepositoryRestMvcConfiguration{

	public WebApplicationContextConfig(ApplicationContext context, ObjectFactory<ConversionService> conversionService) {
		super(context, conversionService);
	}
	
	public void configurerDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
		configurer.enable("/Hell/**");
	}
}

/*
 * notes - code examples
 * *********************************************************************************************
 */

//public void configurerDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
//configurer.enable("/Hell/**");
//}
//
//public void addResourceHandler(ResourceHandlerRegistry registry) {
//registry.addResourceHandler("/assets/**").addResourceLocations("controller");
//}