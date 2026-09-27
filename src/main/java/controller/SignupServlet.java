package controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/signup")
public class SignupServlet extends HttpServlet{
       @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	
       int id = Integer.parseInt( req.getParameter("idkey"));
       String name = req.getParameter("namekey");
       String email = req.getParameter("emailkey");
       long phone = Long.parseLong( req.getParameter("numberkey"));
       String password = req.getParameter("passkey");
       
//       resp.getWriter().println(name);
       
       try {
    	   Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con =DriverManager.getConnection("jdbc:mysql://localhost:3306/studentdb?user=root & password=tiger");
			Statement stmt =con.createStatement();
			
			String irgy ="insert into student values('"+id+"','"+name+"','"+email+"','"+phone+"','"+password+"')";
			int b=stmt.executeUpdate(irgy);
			if(b>0) {
				resp.getWriter().println("Data stored successfully");
			}
			else {
				resp.getWriter().println("failed to store data");
			}
			
				} catch (ClassNotFoundException | SQLException e) {
		
		e.printStackTrace();
	}
    }
}
