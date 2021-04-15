package com.sacrum.users.config;

import org.springframework.context.annotation.PropertySource;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;


/**
 * https://www.baeldung.com/spring-controllers
 * @author Yusdel Morales Guevara
 * 
 * https://developpaper.com/spring-mvc-chapter-2-dispatcher-servlet-initialization/
 *
 */

public class DispatcherServletInitializer extends AbstractAnnotationConfigDispatcherServletInitializer{
	
	@Override
	protected Class<?>[] getRootConfigClasses() {
		return null;
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		
		/* Classi di riferimento per la configurazione del Dispatcher Servlet! */
		return new Class[] { WebApplicationContextConfig.class };
	}

	@Override
	protected String[] getServletMappings() {
		/* 
		 * "/" = qualsiasi chiamata in arrivo verrà gestita da questo Dispatcher Servlet 
		 * "/api/" = qualsiasi chiamata con base URL "/api/" 
		 */
		return new String[] { "/api" };
	}

}
