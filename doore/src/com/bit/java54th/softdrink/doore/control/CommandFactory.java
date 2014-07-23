package com.bit.java54th.softdrink.doore.control;

public class CommandFactory {
	public static Command createCommand(String pathName) {
		Command target = null;

		switch (pathName) {
		
		case "/product":
			target = new ProductCommand();
			break;
		case "/customer":
			target = new CustomerCommand();
			break;
		case "/village":
			target = new VillageCommand();
			break;
		case "/sharing":
			target = new SharingCommand();
			break;
		case "/main":
			target = new MainCommand();
			break;
		case "/login":
			target = new LoginCommand();
			break;
		case "/start":
			target = new StartCommand();
			break;			
		case "/signup":
			target = new SignupCommand();
			break;			
//		default:
//			target = new StartCommand();
//			break;
		}

		return target;
	}
}
