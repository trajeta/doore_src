package com.bit.java54th.softdrink.doore.control;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bit.java54th.softdrink.doore.dao.CustomerVO;
import com.bit.java54th.softdrink.doore.dao.DAOFactory;
import com.bit.java54th.softdrink.doore.dao.VillageDAO;
import com.bit.java54th.softdrink.doore.dao.VillageVO;

public class VillageCommand implements Command {

	public CommandResult execute(HttpServletRequest request,
			HttpServletResponse response)
			throws javax.servlet.ServletException, java.io.IOException {
		CommandResult commandResult = null;

		String todo = request.getParameter("todo");

		if (todo == null) {
			todo = "view";
		}

		/*
		 * search : 사용자의 마을 조회
		 * register : 마을 등록
		 * modify : 마을 수정 
		 * delete : 마을 삭제
		 * custsearch : 마을에 소속된 주민을 제외한 회원 검색 
		 * custinvite : 주민초대 
		 * custconfirm : 해당 마을의 주민보기 
		 * custdelete : 해당 마을에서 주민 삭제 
		 * leadertrust : 해당 마을의 이장 위임
		 */

		if (todo.equals("search"))
			commandResult = doSearch(request, response);
		else if (todo.equals("register"))
			commandResult = doRegister(request, response);
		else if (todo.equals("modify"))
			commandResult = doModify(request, response);
		else if (todo.equals("delete"))
			commandResult = doDelete(request, response);
		else if (todo.equals("custsearch"))
			commandResult = doCustsearch(request, response);
		else if (todo.equals("custinvite"))
			commandResult = doCustinvite(request, response);
		else if (todo.equals("custconfirm"))
			commandResult = doCustconfirm(request, response);
		else if (todo.equals("custdelete"))
			commandResult = doCustdelete(request, response);
		else if (todo.equals("leadertrust"))
			commandResult = doLeadertrust(request, response);
		else {
			commandResult = doView(request, response);
		}
		return commandResult;
	}

	// 사용자의 마을 조회
	public CommandResult doSearch(HttpServletRequest request,
			HttpServletResponse response)
			throws javax.servlet.ServletException, java.io.IOException {
		CommandResult commandResult;
		int customer_id = Integer.parseInt(request.getParameter("customer_id")); // 해당 사용자의 아이디
																					
																					
		List<VillageVO> villageList = findVillageByCustID(customer_id);

		request.setAttribute("villageList", villageList);

		commandResult = new CommandResult("/WEB-INF/view/search.jsp");

		return commandResult;

	}

	// 마을 등록
	public CommandResult doRegister(HttpServletRequest request,
			HttpServletResponse response)
			throws javax.servlet.ServletException, java.io.IOException {
		CommandResult commandResult;

		int customer_id = Integer.parseInt(request.getParameter("customet_id")); // 마을을 생성한 주민 아이디
																					
		String village_name = request.getParameter("village_name"); // 입력받은 개설할 마을 이름

		registerVillage(customer_id, village_name);

		commandResult = new CommandResult("/WEB-INF/view/register.jsp");

		return commandResult;
	}

	// 마을 수정
	public CommandResult doModify(HttpServletRequest request,
			HttpServletResponse response)
			throws javax.servlet.ServletException, java.io.IOException {
		CommandResult commandResult;

		int village_id = Integer.parseInt(request.getParameter("village_id")); // 해당 마을 아이디
																				
		String village_name = request.getParameter("village_name"); // 입력받은 변경할 마을 이름
																	
		modifyVillage(village_id, village_name);

		commandResult = new CommandResult("/WEB-INF/view/modify.jsp");

		return commandResult;
	}

	// 마을 삭제
	public CommandResult doDelete(HttpServletRequest request,
			HttpServletResponse response)
			throws javax.servlet.ServletException, java.io.IOException {
		CommandResult commandResult;

		int village_id = Integer.parseInt(request.getParameter("village_id")); // 삭제할 마을 아이디

		deleteVillage(village_id);

		commandResult = new CommandResult("/WEB-INF/view/delete.jsp");

		return commandResult;
	}

	// 마을에 소속된 주민을 제외한 회원 검색
	public CommandResult doCustsearch(HttpServletRequest request,
			HttpServletResponse response)
			throws javax.servlet.ServletException, java.io.IOException {
		CommandResult commandResult;

		String searchWord = request.getParameter("searchWord"); // 입력받은 검색어
		int village_id = Integer.parseInt(request.getParameter("village_id")); // 해당 마을 아이디
																				
		List<CustomerVO> searchList = searchCustomers(searchWord, village_id);

		request.setAttribute("searchList", searchList);

		commandResult = new CommandResult("/WEB-INF/view/custsearch.jsp");

		return commandResult;
	}

	// 주민초대
	public CommandResult doCustinvite(HttpServletRequest request,
			HttpServletResponse response)
			throws javax.servlet.ServletException, java.io.IOException {
		CommandResult commandResult;

		int customer_id = Integer.parseInt(request.getParameter("customer_id")); // 초대할 주민 아이디
																					
		int village_id = Integer.parseInt(request.getParameter("village_id")); // 초대할 마을 아이디
																				
		inviteCustTovillage(customer_id, village_id);

		commandResult = new CommandResult("/WEB-INF/view/custinvite.jsp");

		return commandResult;
	}

	// 해당 마을의 주민보기
	public CommandResult doCustconfirm(HttpServletRequest request,
			HttpServletResponse response)
			throws javax.servlet.ServletException, java.io.IOException {
		CommandResult commandResult;

		int village_id = Integer.parseInt(request.getParameter("village_id")); // 해당 마을 아이디
																				
		List<CustomerVO> villageCustList = confirmVCustomers(village_id);

		request.setAttribute("villageCustList", villageCustList);

		commandResult = new CommandResult("/WEB-INF/view/custconfirm.jsp");

		return commandResult;
	}

	// 해당 마을의 이장 위임
	public CommandResult doLeadertrust(HttpServletRequest request,
			HttpServletResponse response)
			throws javax.servlet.ServletException, java.io.IOException {
		CommandResult commandResult;

		int customer_id = Integer.parseInt(request.getParameter("customer_id")); // 위임할 주민 아이디
																					
		int village_id = Integer.parseInt(request.getParameter("village_id")); // 해당 마을 아이디
																				
		trustLeader(customer_id, village_id);

		commandResult = new CommandResult("/WEB-INF/view/leadertrust.jsp");

		return commandResult;
	}

	// 해당 마을에서 주민 삭제
	public CommandResult doCustdelete(HttpServletRequest request,
			HttpServletResponse response)
			throws javax.servlet.ServletException, java.io.IOException {
		CommandResult commandResult;

		int customer_id = Integer.parseInt(request.getParameter("customer_id")); // 삭제할 주민 아이디
																					
		int village_id = Integer.parseInt(request.getParameter("village_id")); // 해당 마을 아이디
																																								
		deleteCustomer(customer_id, village_id);

		commandResult = new CommandResult("/WEB-INF/view/custdelete.jsp");

		return commandResult;
	}

	public CommandResult doView(HttpServletRequest request,
			HttpServletResponse response)
			throws javax.servlet.ServletException, java.io.IOException {
		CommandResult commandResult;

		commandResult = new CommandResult("/WEB-INF/view/");

		return commandResult;
	}

	// ########################################################################################################

	// 사용자의 마을 조회
	public List<VillageVO> findVillageByCustID(int customer_id) {
		DAOFactory mysqlFactory = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
		VillageDAO villageDAO = mysqlFactory.getVillageDAO();

		return villageDAO.getVillageByCustID(customer_id);
	}

	// 마을 등록
	public void registerVillage(int customer_id, String village_name) {
		DAOFactory mysqlFactory = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
		VillageDAO villageDAO = mysqlFactory.getVillageDAO();

		villageDAO.createVillage(customer_id, village_name);
	}

	// 마을에 소속된 주민을 제외한 회원 검색
	public List<CustomerVO> searchCustomers(String searchWord, int village_id) {
		DAOFactory mysqlFactory = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
		VillageDAO villageDAO = mysqlFactory.getVillageDAO();

		return villageDAO.searchCustomer(searchWord, village_id);
	}

	// 마을 수정
	public void modifyVillage(int village_id, String village_name) {
		DAOFactory mysqlFactory = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
		VillageDAO villageDAO = mysqlFactory.getVillageDAO();

		villageDAO.modifyVillage(village_id, village_name);
	}

	// 마을 삭제
	public void deleteVillage(int village_id) {
		DAOFactory mysqlFactory = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
		VillageDAO villageDAO = mysqlFactory.getVillageDAO();

		villageDAO.deleteVillage(village_id);
	}

	// 해당 마을의 주민보기
	public List<CustomerVO> confirmVCustomers(int village_id) {
		DAOFactory mysqlFactory = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
		VillageDAO villageDAO = mysqlFactory.getVillageDAO();

		return villageDAO.viewVillageCust(village_id);
	}

	// 주민초대
	public void inviteCustTovillage(int customer_id, int village_id) {
		DAOFactory mysqlFactory = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
		VillageDAO villageDAO = mysqlFactory.getVillageDAO();

		villageDAO.inviteCustomer(customer_id, village_id);
	}

	// 해당 마을에서 주민 삭제
	public void deleteCustomer(int customer_id, int village_id) {
		DAOFactory mysqlFactory = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
		VillageDAO villageDAO = mysqlFactory.getVillageDAO();

		villageDAO.deleteCustomer(customer_id, village_id);
	}

	// 해당 마을의 이장 위임
	public void trustLeader(int customer_id, int village_id) {
		DAOFactory mysqlFactory = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
		VillageDAO villageDAO = mysqlFactory.getVillageDAO();

		villageDAO.trustLeader(customer_id, village_id);
	}
}
