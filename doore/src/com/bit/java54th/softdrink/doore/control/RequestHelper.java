package com.bit.java54th.softdrink.doore.control;

import javax.servlet.http.HttpServletRequest;

public class RequestHelper {
	HttpServletRequest request;
	CommandFactory commandFactory;
	
	public RequestHelper(HttpServletRequest request) {
		this.request = request;		
		commandFactory = new CommandFactory();
	}
	
	public Command getCommand() {
		Command target = null;
		
		/*
		 * URL Mapping
		 * 1. /product : 물품 
		 * 2. /customer : 회원 
		 * 3. /village : 마을
		 * 4. /sharing : 공유
		 */
		System.out.println("Servlet Path : " + request.getServletPath());
		System.out.println("Path Info : " + request.getPathInfo());
		System.out.println("Request URI : " + request.getRequestURI());
		
		target = CommandFactory.createCommand(request.getPathInfo());
		
		return target;		
	}

}
