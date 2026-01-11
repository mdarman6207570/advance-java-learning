package com.task.servlet;

import jakarta.servlet.ServletContextAttributeEvent;
import jakarta.servlet.ServletContextAttributeListener;
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;
@WebListener
public class ContextListenerr implements ServletContextListener,ServletContextAttributeListener
{
	@Override
	public void contextInitialized(ServletContextEvent sce) 
	{
		System.out.println("context object created");
		System.out.println("Application deplyed into :"+sce.getServletContext().getServerInfo());
	}
	
	@Override
	public void contextDestroyed(ServletContextEvent sce) 
	{
		System.out.println("Context Object destroyed");
	}
	
	@Override
	public void attributeAdded(ServletContextAttributeEvent scae) 
	{
		System.out.println("Attribute added to the context Object : ==> "+scae.getName());
	}
	
	@Override
	public void attributeRemoved(ServletContextAttributeEvent scae) 
	{
		System.out.println("Attribute removed from the Context Object");
	}
}
