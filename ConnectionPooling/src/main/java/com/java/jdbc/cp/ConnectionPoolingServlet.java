package com.java.jdbc.cp;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

/**
 * Servlet implementation class ConnectionPoolingServlet
 */
@WebServlet("/ConnectionPoolingServlet")
public class ConnectionPoolingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
		
		try {
			Context context = new InitialContext();
			
			DataSource ds = (DataSource) context.lookup("java:comp/env/myds");
			Connection connection = ds.getConnection();
			Connection connection2 = ds.getConnection();

			System.out.println(connection);
			System.out.println(connection2);

			
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


}
