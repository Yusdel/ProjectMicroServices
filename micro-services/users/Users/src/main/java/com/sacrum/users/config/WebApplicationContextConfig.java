package com.sacrum.users.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
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

}