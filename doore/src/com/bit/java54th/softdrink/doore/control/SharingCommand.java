package com.bit.java54th.softdrink.doore.control;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bit.java54th.softdrink.doore.dao.DAOFactory;
import com.bit.java54th.softdrink.doore.dao.SharingDAO;
import com.bit.java54th.softdrink.doore.dao.SharingVO;

public class SharingCommand implements Command {

	public CommandResult execute(HttpServletRequest request,
			HttpServletResponse response)
			throws javax.servlet.ServletException, java.io.IOException {
		CommandResult commandResult = null;

		String todo = request.getParameter("todo");

		if (todo.equals("add"))
			commandResult = doAdd(request, response);
		else if (todo.equals("remove"))
			commandResult = doRemove(request, response);
		else if (todo.equals("update"))
			commandResult = doUpdate(request, response);
		else if (todo.equals("find"))
			commandResult = doFind(request, response);
		return commandResult;
	}

	public CommandResult doAdd(HttpServletRequest request,
			HttpServletResponse response)
			throws javax.servlet.ServletException, java.io.IOException {
		CommandResult commandResult;
		int result = getCreateSharing(0, 1, "2010-01-01", "2010-01-16", 2);
		request.setAttribute("sharings", result);

		commandResult = new CommandResult("/WEB-INF/view/sharingadd.jsp");

		return commandResult;
	}

	public CommandResult doUpdate(HttpServletRequest request,
			HttpServletResponse response) {
		CommandResult commandResult;
		int result = getUpdateSharing(4, "2001-01-04", "2001-01-05");
		request.setAttribute("sharings", result);
		commandResult = new CommandResult("/WEB-INF/view/sharingupdate.jsp");

		return commandResult;
	}

	public CommandResult doRemove(HttpServletRequest request,
			HttpServletResponse response) {
		CommandResult commandResult;
		int result = getDeleteSharing(2);
		request.setAttribute("sharings", result);

		commandResult = new CommandResult("/WEB-INF/view/sharingremove.jsp");

		return commandResult;
	}

	public CommandResult doFind(HttpServletRequest request,
			HttpServletResponse response)
			throws javax.servlet.ServletException, java.io.IOException {
		CommandResult commandResult;
		List<SharingVO> sharings = getFindAllSharings();
		request.setAttribute("allsharings", sharings);
		SharingVO s = getFindSharingByID(4);
		request.setAttribute("sharingbyid", s);
		sharings = getFindSharingByApplicationID(1);
		request.setAttribute("byapplicationid", sharings);
		sharings = getFindSharingByProductID(2);
		request.setAttribute("byproductid", sharings);
	
		commandResult = new CommandResult("/WEB-INF/view/sharingfind.jsp");

		return commandResult;
	}

	public int getCreateSharing(int returnCheck, int applicationID,
			String startDay, String endDay, int productID) {
		DAOFactory mysqlFactory = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
		SharingDAO sharingDAO = mysqlFactory.getSharingDAO();

		return sharingDAO.createSharing(returnCheck, applicationID, startDay,
				endDay, productID);

	}

	public int getUpdateSharing(int sharingID, String startDay, String endDay) {
		DAOFactory mysqlFactory = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
		SharingDAO sharingDAO = mysqlFactory.getSharingDAO();
		return sharingDAO.updateSharing(sharingID, startDay, endDay);
	}

	public int getDeleteSharing(int sharingID) {
		DAOFactory mysqlFactory = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
		SharingDAO sharingDAO = mysqlFactory.getSharingDAO();
		return sharingDAO.deleteSharing(sharingID);

	}

	public List<SharingVO> getFindAllSharings() {
		DAOFactory mysqlFactory = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
		SharingDAO sharingDAO = mysqlFactory.getSharingDAO();
		return sharingDAO.findAllSharings();
	}

	public List<SharingVO> getFindSharingByApplicationID(int applicationID) {
		DAOFactory mysqlFactory = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
		SharingDAO sharingDAO = mysqlFactory.getSharingDAO();
		return sharingDAO.findSharingByApplicationID(applicationID);
	}

	public List<SharingVO> getFindSharingByProductID(int productID){
		DAOFactory mysqlFactory = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
		SharingDAO sharingDAO = mysqlFactory.getSharingDAO();
		return sharingDAO.findSharingByProductID(productID);
	}
	public SharingVO getFindSharingByID(int sharingID) {
		DAOFactory mysqlFactory = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
		SharingDAO sharingDAO = mysqlFactory.getSharingDAO();
		return sharingDAO.findSharingByID(sharingID);
	}

}
