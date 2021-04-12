package com.morales.reserved.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class DispatcherServletInitializer extends AbstractAnnotationConfigDispatcherServletInitializer{
	@Override
	protected Class<?>[] getRootConfigClasses() {
		// TODO Auto-generated method stub
		return null;
	}
	
	/* Set general configuration class */
	@Override
	protected Class<?>[] getServletConfigClasses() {
		/* Here we specify the most important class of our application, 
		 * that is the general configuration class our application will refer to.
		 */
		return new Class[] { WebApplicationContextConfig.class };
	}
	
	/* Set base Url that our application / server will manage */
	@Override
	protected String[] getServletMappings() {
		/*
		 * Indicates that any calls to the server, which have as their base url "/",
		 * must be handled by our Dispatcher Servlet. 
		 * You can change the url to indicate different calls to handle,
		 * example of microservices management
		 */
		return new String[] { "/" };
	}

}
