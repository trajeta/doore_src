package com.bit.java54th.softdrink.doore.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bit.java54th.softdrink.doore.dao.CustomerDAO;
import com.bit.java54th.softdrink.doore.dao.CustomerVO;
import com.bit.java54th.softdrink.doore.dao.DAOFactory;
import com.bit.java54th.softdrink.doore.dao.ProductDAO;

public class StartCommand implements Command {

	public CommandResult execute(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		CommandResult commandResult = null;
		HttpSession session = request.getSession(true);
		session.setAttribute("login", findCustomerById(1));
		System.out.println("고객이름: " + findCustomerById(1).getCustomerName());
		commandResult = new CommandResult("/WEB-INF/index.jsp");
		return commandResult;
	}

	public CustomerVO findCustomerById(int customerId) {
		DAOFactory mysqlFactory = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
		CustomerDAO customerDAO = mysqlFactory.getCustomerDAO();
		return customerDAO.findCustomerById(customerId);
	}

}