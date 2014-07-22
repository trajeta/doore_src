package com.bit.java54th.softdrink.doore.control;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bit.java54th.softdrink.doore.dao.CustomerVO;
import com.bit.java54th.softdrink.doore.dao.DAOFactory;
import com.bit.java54th.softdrink.doore.dao.ProductVO;
import com.bit.java54th.softdrink.doore.dao.VillageDAO;
import com.bit.java54th.softdrink.doore.dao.VillageVO;

public class MainCommand implements Command {
	public CommandResult execute(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		CommandResult commandResult = null;
		
		HttpSession session = request.getSession();
		
		CustomerVO customerVO = (CustomerVO)session.getAttribute("customerVO");
						
		List<ProductVO> productList = findAllProductById(customerVO.getCustomerId());
						
		session = request.getSession(true);
					
			
		request.setAttribute("productList", productList);
		
		commandResult = new CommandResult("/WEB-INF/view/main.jsp");			
				
		return commandResult;
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
	