package com.privatearea.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import springfox.documentation.swagger2.annotations.EnableSwagger2;


@Configuration
@EnableWebMvc
@EnableSwagger2
@ComponentScan(basePackages = "com.privatearea")
public class WebApplicationContextConfig implements WebMvcConfigurer{
	
	@Override
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }
    
    /* Resource Handlers */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
    	/* "/static/images/" => "/img/**" */
    	registry.addResourceHandler("/img/**").addResourceLocations("/static/images/");
    }
  
}
