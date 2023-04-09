package com.java.sessionmanagement;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class TargetServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
		Cookie[] cookies = request.getCookies();

		for (int i = 0; i < cookies.length; i++) {
			System.out.println(cookies[i].getName());
			System.out.println(cookies[i].getValue());
		}
		
		Cookie cookie = new Cookie("securityToken", "1234");
		response.addCookie(cookie);

		HttpSession session = request.getSession();
		/*
		 * Retrieving the user name from the session we created from the source servlet.
		 */
		String user = (String) session.getAttribute("user");

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		out.print("<h1> The User name is: " + user + "</h1>");

	}

}
