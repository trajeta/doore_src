package com.bit.java54th.softdrink.doore.control;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bit.java54th.softdrink.doore.dao.CustomerDAO;
import com.bit.java54th.softdrink.doore.dao.CustomerVO;
import com.bit.java54th.softdrink.doore.dao.DAOFactory;

public class CustomerCommand implements Command {
	public CommandResult execute(HttpServletRequest request, HttpServletResponse response) throws javax.servlet.ServletException, java.io.IOException {
		CommandResult commandResult = null;

		String todo = request.getParameter("todo");
		
		if ( todo.equals("add")) 
			commandResult = doAdd(request, response);
		if ( todo.equals("find"))
			commandResult = doFind(request, response);
		if ( todo.equals("update")) 
			commandResult = doUpdate(request, response);
		if ( todo.equals("remove"))
			commandResult = doRemove(request, response);
		
		return commandResult;
	}
	
	public CommandResult doAdd(HttpServletRequest request, HttpServletResponse response) throws javax.servlet.ServletException, java.io.IOException {
		CommandResult commandResult = null;
		
		String customerName = request.getParameter("customerName");
		String customerPassword = request.getParameter("customerPassword");
		String customerEmail = request.getParameter("customerEmail");
		int customerConnection = Integer.parseInt(request.getParameter("customerConnection"));
		int customerAutoLogin = 0;
		String customerRegistry ="now()"; 
		
		// test data input
//		String customerName = "안녕";
//		String customerPassword = "1234ㅇㅇ";
//		String customerEmail = "sand1243@hanmail.net";
//		int customerConnection = 1;
//		int customerAutoLogin = 0;
//		String customerRegistry ="2014-01-21"; 
		//

		int result = addCustomer (customerName, customerConnection,  customerEmail, customerPassword, customerAutoLogin, customerRegistry) ;
		request.setAttribute("customer", result);
		
		if (result == 0) { 
		commandResult = new CommandResult("/WEB-INF/view/main.jsp");
		} else {
			commandResult = new CommandResult("/index.html");
		}
		
	
		return commandResult;
	}
	
	public CommandResult doFind(HttpServletRequest request, HttpServletResponse response) throws javax.servlet.ServletException, java.io.IOException {
		CommandResult commandResult = null;
//		int customerId = Integer.parseInt(request.getParameter("customerId"));
		int customerId = 13;
		CustomerVO result = findCustomerById(customerId);
		System.out.println(result);
		request.setAttribute("customer", result);
		
		commandResult = new CommandResult("/WEB-INF/view/success.jsp");
		return commandResult;
	}
	
	
	
	public CommandResult doUpdate(HttpServletRequest request, HttpServletResponse response) throws javax.servlet.ServletException, java.io.IOException {
		CommandResult commandResult = null;
		HttpSession session = request.getSession(true);
		CustomerVO customerVO = (CustomerVO) session.getAttribute("customerVO");
		String customerName = request.getParameter("customerName");
		
//		int customerId = 14;
//		String customerName = "김말순";
		
		int result = updateCustomer(customerVO.getCustomerId(), customerName);
		request.setAttribute("update", result);
		if (result == 0) {
			commandResult = new CommandResult("/WEB-INF/view/main.jsp");
		} else {
			commandResult = new CommandResult("/WEB-INF/view/main.jsp");	
		}

		return commandResult;
	}
	

	public CommandResult doRemove(HttpServletRequest request, HttpServletResponse response) throws javax.servlet.ServletException, java.io.IOException {
		CommandResult commandResult;	
		HttpSession session = request.getSession(true);
		CustomerVO customerVO = (CustomerVO) session.getAttribute("customerVO");
		
		String customerPassword = request.getParameter("customerPassword");
		String customerEmail = request.getParameter("customerEmail");
		System.out.println(customerPassword);
		System.out.println(customerEmail);
		String email = customerVO.getCustomerEmail();
		String password = customerVO.getCustomerPassword();
		System.out.println(email);
		System.out.println(password);
		
		if(customerPassword == password && customerEmail == email) {
			int result = removeCustomer(customerVO.getCustomerId());
			request.setAttribute("remove", result);
				
			if (result == 0) {
				commandResult = new CommandResult("/WEB-INF/view/success.jsp");
			} else {
				commandResult = new CommandResult("/WEB-INF/view/success.jsp");	
			}
		} else { 
			commandResult = new CommandResult("/index.html");
		}
		
		
		
		return commandResult;		
	}
	
	
	
	public int addCustomer(String customerName, int customerConnection, String customerEmail, String customerPassword, int customerAutoLogin, String customerRegistry) {
		DAOFactory mysqlFactory = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
		CustomerDAO customerDAO = mysqlFactory.getCustomerDAO();
		
		return customerDAO.createCustomer(customerName, customerConnection, customerEmail, customerPassword, customerAutoLogin, customerRegistry);
	}
	
	public int updateCustomer(int customerId, String customerName) {
		DAOFactory mysqlFactory = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
		CustomerDAO customerDAO = mysqlFactory.getCustomerDAO();
		
		return customerDAO.updateCustomer(customerId, customerName);
	}
	
	public int removeCustomer(int customerId) {
		DAOFactory mysqlFactory = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
		CustomerDAO customerDAO = mysqlFactory.getCustomerDAO();
		
		return customerDAO.deleteCustomer(customerId);
	}

	
	public CustomerVO findCustomerById(int customerId) {
		DAOFactory mysqlFactory = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
		CustomerDAO customerDAO = mysqlFactory.getCustomerDAO();
		
		return customerDAO.findCustomerById(customerId);
	}

}
