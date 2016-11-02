package com.isidis.prototype.config;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;
import org.jboss.resteasy.plugins.server.servlet.ResteasyBootstrap;
import org.jboss.resteasy.plugins.server.servlet.HttpServletDispatcher;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public class CustomWebApplicationInitializer implements WebApplicationInitializer {
	
	private static final String REST_API_PREFIX = "/";

	@Override
	public void onStartup(ServletContext container) throws ServletException {
		// Create the 'root' Spring application context
		AnnotationConfigWebApplicationContext rootContext = new AnnotationConfigWebApplicationContext();
		rootContext.register(ApplicationConfiguration.class);
		
		registerServlets(container, rootContext);
		registerParams(container);
		registeListeners(container, rootContext);
		
		/*
		// Manage the lifecycle of the root application context
		//container.addListener(new ContextLoaderListener(rootContext));
		// Create the dispatcher servlet's Spring application context
		AnnotationConfigWebApplicationContext dispatcherContext = new AnnotationConfigWebApplicationContext();
		dispatcherContext.register(DispatcherServletConfiguration.class);
		// Register and map the dispatcher servlet
		ServletRegistration.Dynamic dispatcher = container.addServlet("dispatcher",
				new DispatcherServlet(dispatcherContext));
		dispatcher.setLoadOnStartup(1);
		dispatcher.addMapping("/"); 
		*/
	}
	
	private void registeListeners(ServletContext servletContext,
			AnnotationConfigWebApplicationContext rootContext) {
		servletContext.addListener(new ResteasyBootstrap());
		servletContext.addListener(new RestEasyAnnotatedContextLoader(
				rootContext));
	}

	private void registerServlets(ServletContext servletContext,
			AnnotationConfigWebApplicationContext rootContext) {
		/*
		AnnotationConfigWebApplicationContext dispatcherContext = new AnnotationConfigWebApplicationContext();
		dispatcherContext.register(DispatcherServletConfiguration.class);
		ServletRegistration.Dynamic springDispatcher = servletContext
				.addServlet("SpringDispatcherServlet", new DispatcherServlet(
						dispatcherContext));
		springDispatcher.setLoadOnStartup(1);
		springDispatcher.addMapping("/");
		*/
		
		ServletRegistration.Dynamic restEasyDispatcher = servletContext
				.addServlet("RestEasyHttpServletDispatcher",
						new HttpServletDispatcher());
		restEasyDispatcher.setLoadOnStartup(1);
		restEasyDispatcher.addMapping(REST_API_PREFIX + "*");
	}

	private void registerParams(ServletContext servletContext) {
		servletContext.setInitParameter("resteasy.media.type.mappings",
				"json : application/json, xml : application/xml");
		servletContext.setInitParameter("resteasy.servlet.mapping.prefix",
				REST_API_PREFIX);
	}
}