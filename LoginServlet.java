package com.PTR;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.cj.protocol.Resultset;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		response.setContentType("text/html");
                PrintWriter out = response.getWriter();
	
		String username = request.getParameter("loginid");
	        String password = request.getParameter("pwd");
	        try {
	        Class.forName("com.mysql.jdbc.Driver");

	        Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/PetRegistration","root","root");  

	        String query = "select * from login WHERE userID='"+ username + "' and password='" + password + "'";
	        Statement st = conn.createStatement();
	        ResultSet rs = st.executeQuery(query);
	        if (rs.next()) {
	        	 RequestDispatcher rd1=request.getRequestDispatcher("/success.html");  
                         rd1.forward(request,response); 

	        } 
                else {
	        	RequestDispatcher rd2=request.getRequestDispatcher("/error.html");  
                        rd2.forward(request,response); 
	        }
	        rs.close();
	        st.close();
	      
	       } 
	       catch (Exception e) {
	        e.printStackTrace();
	      }

	}
		
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

	}
}
