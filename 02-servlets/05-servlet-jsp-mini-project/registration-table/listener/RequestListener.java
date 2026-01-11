package com.pack1;

import jakarta.servlet.ServletRequestAttributeEvent;
import jakarta.servlet.ServletRequestAttributeListener;
import jakarta.servlet.ServletRequestEvent;
import jakarta.servlet.ServletRequestListener;
import jakarta.servlet.annotation.WebListener;

@WebListener
public class RequestListener implements ServletRequestListener,ServletRequestAttributeListener
{
	@Override
	public void requestInitialized(ServletRequestEvent sre) 
	{
		System.out.println("Request Object Created");
	}
	
	@Override
	public void requestDestroyed(ServletRequestEvent sre) 
	{
		System.out.println("Request Object Destroiyed");
	}
	
	@Override
	public void attributeAdded(ServletRequestAttributeEvent srae) 
	{
		System.out.println("attribute added :"+srae.getName());
	}
	
	@Override
	public void attributeRemoved(ServletRequestAttributeEvent srae) 
	{
		System.out.println("attribute removed :");
	}
}
