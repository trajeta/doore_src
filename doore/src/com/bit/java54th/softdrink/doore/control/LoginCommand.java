package com.bit.java54th.softdrink.doore.control;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bit.java54th.softdrink.doore.dao.CustomerDAO;
import com.bit.java54th.softdrink.doore.dao.CustomerVO;
import com.bit.java54th.softdrink.doore.dao.DAOFactory;
import com.bit.java54th.softdrink.doore.dao.ProductDAO;
import com.bit.java54th.softdrink.doore.dao.ProductVO;
import com.bit.java54th.softdrink.doore.dao.VillageDAO;
import com.bit.java54th.softdrink.doore.dao.VillageVO;

public class LoginCommand implements Command {
	public CommandResult execute(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		CommandResult commandResult = null;
		
//		String customerPassword = request.getParameter("customerPassword");
//		String customerEmail = request.getParameter("customerEmail");
//		int customerConnection = Integer.parseInt(request.getParameter("customerConnection"));
		
		String customerEmail = request.getParameter("customer_email");
		String customerPassword = request.getParameter("customer_password");
		
		CustomerVO result = findCustomerByLogin(customerEmail, customerPassword);
		
		if (result == null) {
			HttpSession session = request.getSession(true);
			session.invalidate();			
			commandResult = new CommandResult("/WEB-INF/view/againLogin.jsp");
		}
		else {
			List<VillageVO> villageList = findVillageByCustID(result.getCustomerId());
			System.out.println("확인1");
			List<ProductVO> productList = findAllProductById(result.getCustomerId());
			System.out.println(productList);
			System.out.println("확인2");
			HttpSession session = request.getSession(false);
			if (session != null) {
				session.invalidate();
			}
			session = request.getSession(true);
			synchronized (session) {
				session.setAttribute("customerVO", result);
				session.setAttribute("villageList", villageList);
				request.setAttribute("productList", productList);
			}
			System.out.println("확인3");
			commandResult = new CommandResult("/WEB-INF/view/main.jsp");
		}
		
		return commandResult;
	}

	public CustomerVO findCustomerByLogin(String customerEmail, String customerPassword) {
		DAOFactory mysqlFactory = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
		CustomerDAO customerDAO = mysqlFactory.getCustomerDAO();
		
		return customerDAO.findCustomerByLogin(customerEmail, customerPassword);
	}
	
	public List<VillageVO> findVillageByCustID(int customer_id) {
		DAOFactory mysqlFactory = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
		VillageDAO villageDAO = mysqlFactory.getVillageDAO();

		return villageDAO.getVillageByCustID(customer_id);
	}
	
	public List<ProductVO> findAllProductById(int customer_id) {
		DAOFactory mysqlFactory = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
		VillageDAO villageDAO = mysqlFactory.getVillageDAO();
		
		return villageDAO.findAllProductById(customer_id);
	}
}

	