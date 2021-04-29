package com.sacrum.users.config;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 
 * @author Yusdel Morales Guevara
 *
 */

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.sacrum.users") /* riferisce al Dispatcher Servlet dove cercare le classi controller! */
public class WebApplicationContextConfig  implements WebMvcConfigurer{
	
	public void configurerDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
		configurer.enable();
	}
	
	/**
	 * Required for internationalization and some custom exception messages.
	 * @return
	 */
	@Bean
	public MessageSource messageSource()
	{
		ResourceBundleMessageSource resource = new ResourceBundleMessageSource();
		resource.setBasename("messages");

		return resource;
	}
	
	@Override
	public void addCorsMappings(CorsRegistry registry) {
		registry
			.addMapping("/**")
			.allowedOrigins("*") // able Client ( * = all )
			.allowedMethods("PUT", "DELETE", "GET", "POST")
			.allowedHeaders("*") // able headers ( * = all )
			.exposedHeaders("header1", "header2")
			.allowCredentials(false) // to be enable for example when sending credentials through the use of cookies
			.maxAge(3600); // duration in seconds
	}

}