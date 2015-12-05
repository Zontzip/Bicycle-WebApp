package com.example.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.example.business.User;
import com.example.service.UserService;
import com.example.business.ShoppingCart;

public class LoginUserCommand implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse repsonse){
			
		UserService userService = new UserService();
		String forwardToJsp = "";		

		String username = request.getParameter("username");
		String password = request.getParameter("password");

		//Check we have a username and password...
		if (username != null && password != null){

			//Make call to the 'Model' using the UserServive class to login...
			User userLoggingIn = userService.login(username, password);
			
			ShoppingCart shoppingCart = new ShoppingCart(userLoggingIn);

			if (userLoggingIn != null){

				//If login successful, store the session id for this client...
				HttpSession session = request.getSession();
				String clientSessionId = session.getId();
				session.setAttribute("loggedSessionId", clientSessionId);

				session.setAttribute("user", userLoggingIn);
				
				// Give the user a shopping cart
				session.setAttribute("shoppingcart", shoppingCart);

				forwardToJsp = "/loginSuccess.jsp";				
			}
			else{
				forwardToJsp = "/loginFailure.jsp";	
			}
		}
		else {
			forwardToJsp = "/loginFailure.jsp";	
		}
		return forwardToJsp;
	}

}
