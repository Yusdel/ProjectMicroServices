package com.sacrum.users.config;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
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

}