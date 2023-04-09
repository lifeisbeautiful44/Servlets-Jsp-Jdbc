package com.java.interservletcommunication;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String userName = request.getParameter("userName");
		String password = request.getParameter("password");

		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost/mydb", "root","mysql123");

			Statement statement = con.createStatement();
			ResultSet resultSet = statement
					.executeQuery("select * from user where email = '" + userName + "' "
							+ "and password = '" + password+"'");

			RequestDispatcher requestDispatcher = request.getRequestDispatcher("homeServlet");

			/*
			 * If the resultSet has any value , then we will be sending the request and
			 * response to the to homeServlet. by using forward method.
			 */

			if (resultSet.next()) {
				request.setAttribute("message", "Welcome to the InterServlet Communication " + userName);
				requestDispatcher.forward(request, response);

			} else {

				requestDispatcher = request.getRequestDispatcher("login.html");
				requestDispatcher.include(request, response);

			}

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

	}

}
