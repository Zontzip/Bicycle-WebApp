package com.example.command;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.example.business.User;
import com.example.service.UserService;

public class ListUsersCommand implements Command{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse repsonse){
		UserService userService = new UserService();
		String forwardToJsp = "";
		
		List<User> users = new ArrayList<User>();
		
		users = userService.getAllUsers();
		
		if (users != null) {
			HttpSession session = request.getSession();
			session.setAttribute("users", users);
			
			forwardToJsp = "/listUsers.jsp";
		} else {
			forwardToJsp = "/errorPage.jsp";	
		}
		
		return forwardToJsp;
	}
}
