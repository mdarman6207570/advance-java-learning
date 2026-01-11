package com.task.servlet;

import jakarta.servlet.annotation.WebListener;
import jakarta.servlet.http.HttpSessionAttributeListener;
import jakarta.servlet.http.HttpSessionBindingEvent;
import jakarta.servlet.http.HttpSessionEvent;
import jakarta.servlet.http.HttpSessionListener;

@WebListener
public class SessionListener implements HttpSessionListener,HttpSessionAttributeListener
{
	@Override
	public void sessionCreated(HttpSessionEvent se) 
	{
		System.out.println("Session Object created");
	}
	
	@Override
	public void sessionDestroyed(HttpSessionEvent se) 
	{
		System.out.println("Session Object destroyed");
	}
	
	@Override
	public void attributeAdded(HttpSessionBindingEvent hsbe) 
	{
		System.out.println("Attribute added to the session : "+hsbe.getName());
	}
	
	@Override
	public void attributeRemoved(HttpSessionBindingEvent hsbe) 
	{
		System.out.println("Attribute removed from the session");
	}
}
