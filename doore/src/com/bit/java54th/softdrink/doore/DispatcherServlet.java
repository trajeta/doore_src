package com.bit.java54th.softdrink.doore;

import java.io.IOException;

import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bit.java54th.softdrink.doore.control.Command;
import com.bit.java54th.softdrink.doore.control.CommandResult;
import com.bit.java54th.softdrink.doore.control.RequestHelper;

public class DispatcherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	public void init(ServletConfig conf) throws ServletException {
		super.init(conf);
	}
	
	protected void processRequest(HttpServletRequest request,
			HttpServletResponse response) throws ServletException,
			java.io.IOException {

		CommandResult commandResult;
		
		try {
			RequestHelper helper = new RequestHelper(request);

			Command command = helper.getCommand();
			// delegate request to a command object helper
			commandResult = command.execute(request, response);
			
			if (commandResult.hasView())
				dispatch(request, response, commandResult.getViewURL());
			else
				sendContent(request, response, commandResult);
			
		} catch (Exception e) {
			/*
			 * "/WEB-INF/view/error.jsp"의 호출을 고민해볼 것
			 */
		}		
			
	}
	
	protected void sendContent(HttpServletRequest request,
			HttpServletResponse response, CommandResult commandResult)
			throws javax.servlet.ServletException, java.io.IOException {
		response.setContentType(commandResult.getContentType());
						
		PrintWriter out = response.getWriter();
		
		out.println(commandResult.getContent());
		out.close();
	}
	
	
	/** dispatcher method */
	protected void dispatch(HttpServletRequest request,
			HttpServletResponse response, String page)
			throws javax.servlet.ServletException, java.io.IOException {
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(page);
		dispatcher.forward(request, response);
	}

	@Override
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response); 
	}

	@Override
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		processRequest(request, response); 
	}

}
