package com.bit.java54th.softdrink.doore.control;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bit.java54th.softdrink.doore.dao.CustomerDAO;
import com.bit.java54th.softdrink.doore.dao.CustomerVO;
import com.bit.java54th.softdrink.doore.dao.DAOFactory;

public class FindPasswordCommand implements Command {
	public CommandResult execute(HttpServletRequest request, HttpServletResponse response) throws javax.servlet.ServletException, java.io.IOException {
		CommandResult commandResult = null;
		//		String customerEmail = request.getParameter("customerEmail");

		String customerEmail = "sand1243@hanmail.net";

		CustomerVO result = findCustomerByEmail(customerEmail);

		if (result == null)
			commandResult = new CommandResult("/WEB-INF/view/success.jsp");
		
		request.setAttribute("findPassword", result);

		if (result.getCustomerEmail() == customerEmail) {
			//				commandResult = new CommandResult(result.getCustomerPassword()); // 동일한 이메일을 찾아서 패스워드를 해당 객체안의 패스워드를 호출
			commandResult = new CommandResult("/WEB-INF/view/success.jsp"); // test용
		} else {
			commandResult = new CommandResult("/WEB-INF/view/success.jsp"); // 동일한 이메일이 없을 경우 
		}
	return commandResult;
}
public CustomerVO findCustomerByEmail(String customerEmail) {
	DAOFactory mysqlFactory = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
	CustomerDAO customerDAO = mysqlFactory.getCustomerDAO();

	return customerDAO.findCustomerByEmail(customerEmail);
}
}

