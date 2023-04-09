package com.srijansil.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class AdditionServlet extends GenericServlet {

	private static final long serialVersionUID = 1L;

	@Override
	public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
	
		if(request.getParameter("number1") != null && request.getParameter("number2")!= null)
				{
			long num1 =  Long.parseLong(request.getParameter("number1")) ;
			long num2 =  Long.parseLong(request.getParameter("number2")) ;
			
              PrintWriter out = response.getWriter();
              out.println("The result is: "+ (num1+num2));

				}
				 

		

	}

}
