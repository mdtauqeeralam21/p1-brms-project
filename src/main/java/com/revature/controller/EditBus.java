package com.revature.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.util.DataBaseConnection;

@SuppressWarnings("serial")
@WebServlet("/editBus")
public class EditBus extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		response.setContentType("text/html");
		out.println("<link rel=\'stylesheet\' href=\'https://cdn.jsdelivr.net/npm/bootstrap@4.4.1/dist/css/bootstrap.min.css\' integrity=\'sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh\' crossorigin=\'anonymous\'></link>");
		String bid=request.getParameter("id");

		out.println("<nav class='navbar navbar-dark bg-dark text-light'>Admin Dashboard </nav>");
		Connection con = DataBaseConnection.getConnection();
		try {
			PreparedStatement ps1=con.prepareStatement("select * from bus where Bus_Reg_No=?");
			ps1.setString(1,bid);
			ResultSet rs= ps1.executeQuery();
			rs.next();
			out.println("<div style='margin:auto; width:500; margin-top:10px;padding-top:10px;'>");
			out.println("<form action='edit?id="+bid+"' method='GET'>");

			out.println("<table class='table  table-hover table-bordered'>");
			//out.println("<capion>Please New Values</caption>");
			out.println("<tr class='table-secondary'>");
			out.println("<td>Bus Registration No</td>");
			out.println("<td><input type='text' name='bid' value='"+rs.getString(1)+"' ></td>");
			out.println("</tr><br>");
			
			out.println("<tr class='table-success'>");
			out.println("<td>Bus type</td>");
			out.println("<td><input type='text' name='btype' value='"+rs.getString(2)+"'></td>");
			out.println("</tr><br>");
			
			out.println("<tr class='table-danger'>");
			out.println("<td>TotalSeats</td>");
			out.println("<td><input type='number' name='seats' value='"+rs.getInt(3)+"' min='5' max='50'></td>");
			out.println("</tr><br>");
			
			out.println("<tr class='table-info'>");
			out.println("<td>Total Berths</td>");
			out.println("<td><input type='text' name='berths' value='"+rs.getString(4)+"'></td>");
			out.println("</tr><br>");
			
//			out.println("<tr class='table-warning'>");
//			out.println("<td><button type='submit' class='btn btn-success'>Update</button> </td>");
//			out.println("</tr><br>");
			
			out.println("</table>");
			out.println("<button type='submit' class='btn btn-success'>Update</button></a>");
			out.println("<button type='reset' class='btn btn-danger'>Cancel</button>");
			out.println("</form>");		
			
		} catch (SQLException e) {
			out.println("<h2 class='bg-danger text-light text-cenetr'>'"+e.getMessage()+"'<h2>");
			e.printStackTrace();
		}
		out.println("</div>");
	}
	//out.println("<button type='submit' class='btn btn-success'>Update</button>");

}
