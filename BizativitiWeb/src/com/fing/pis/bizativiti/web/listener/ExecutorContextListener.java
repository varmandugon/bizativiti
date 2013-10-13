package com.fing.pis.bizativiti.web.listener;

import java.util.concurrent.ExecutorService;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class ExecutorContextListener implements ServletContextListener {
	private ExecutorService executor;

	@Override
	public void contextDestroyed(ServletContextEvent servletContextEvent) {
		ServletContext context = servletContextEvent.getServletContext();
		executor.shutdown();
		

	}

	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		// TODO Auto-generated method stub

	}

}
