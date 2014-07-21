package com.bit.java54th.softdrink.doore.control;

import java.io.IOException;

import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bit.java54th.softdrink.doore.dao.*;

public class StartCommand implements Command {

	public CommandResult execute(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		CommandResult commandResult = null;
	
		int result = lendingPeriod(3);
		request.setAttribute("lendingperiod", result);
		result = getChangeSharingState(3, 1);
		request.setAttribute("returncheck", result);
		result = getReturnProduct(5);
		request.setAttribute("returnproduct", result);

		commandResult = new CommandResult("/WEB-INF/view/start.jsp");
		return commandResult;
	}
	
	public List<ProductVO> getAllProducts() {
		DAOFactory mysqlFactory = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
		ProductDAO productDAO = mysqlFactory.getProductDAO();
		
		return productDAO.findAllProducts();	
	}
	public ProductVO findProductByID(int productid) {
		DAOFactory mysqlFactory = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
		ProductDAO productDAO = mysqlFactory.getProductDAO();
		
		return productDAO.findProductByID(productid);
	}

	public int lendingPeriod(int sharingID) {
		DAOFactory mysqlFactory = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
		SharingDAO sharingDAO = mysqlFactory.getSharingDAO();
		return sharingDAO.getLendingPeriod(sharingID);
	}

	public int getChangeSharingState(int sharingID, int returnCheck) {
		DAOFactory mysqlFactory = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
		SharingDAO sharingDAO = mysqlFactory.getSharingDAO();
		return sharingDAO.changeSharingState(sharingID, returnCheck);
	}

	public int getReturnProduct(int sharingID) {
		DAOFactory mysqlFactory = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
		SharingDAO sharingDAO = mysqlFactory.getSharingDAO();
		return sharingDAO.returnProduct(sharingID);
	}

}
