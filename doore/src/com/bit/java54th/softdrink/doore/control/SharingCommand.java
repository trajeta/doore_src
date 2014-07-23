package com.bit.java54th.softdrink.doore.control;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bit.java54th.softdrink.doore.dao.CustomerVO;
import com.bit.java54th.softdrink.doore.dao.DAOFactory;
import com.bit.java54th.softdrink.doore.dao.ProductDAO;
import com.bit.java54th.softdrink.doore.dao.ProductVO;
import com.bit.java54th.softdrink.doore.dao.SharingDAO;
import com.bit.java54th.softdrink.doore.dao.SharingVO;

public class SharingCommand implements Command {

	public CommandResult execute(HttpServletRequest request,
			HttpServletResponse response)
			throws javax.servlet.ServletException, java.io.IOException {
		CommandResult commandResult = null;
		String productID = request.getParameter("productid");
		HttpSession session = request.getSession(true);
		CustomerVO customer = (CustomerVO) session.getAttribute("login");
		int idInt = Integer.parseInt(productID);
		System.out.println("productID = " + idInt);
		ProductVO product = findProductByID(idInt);
		request.setAttribute("product", product);
		List<SharingVO> sharings = findSharingByProductID(idInt);
		request.setAttribute("sharings", sharings);
		// 디버깅용
		System.out.println("****************");
		System.out.println("customerName: " + customer.getCustomerName());
		System.out.println("productName : " + product.getProduct_name());
		System.out.println("****************");
		SharingVO search = findSharingImpossible(idInt);
		if (search == null) {
			commandResult = new CommandResult(
					"/WEB-INF/view/sharingapplication.jsp");
		} else {
			commandResult = new CommandResult(
					"/WEB-INF/view/sharingreservation.jsp");
		}
		return commandResult;
	}

	public ProductVO findProductByID(int productid) {
		DAOFactory mysqlFactory = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
		ProductDAO productDAO = mysqlFactory.getProductDAO();

		return productDAO.findProductByID(productid);
	}

	public List<SharingVO> findSharingByProductID(int productID) {
		DAOFactory mysqlFactory = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
		SharingDAO sharingDAO = mysqlFactory.getSharingDAO();
		return sharingDAO.findSharingByProductID(productID);
	}

	public SharingVO findSharingImpossible(int productID) {
		DAOFactory mysqlFactory = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
		SharingDAO sharingDAO = mysqlFactory.getSharingDAO();
		return sharingDAO.findSharingImpossible(productID);

	}

}
