package com.revature.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.util.DataBaseConnection;

@SuppressWarnings("serial")
@WebServlet("/edit")
public class EditBusServlet extends HttpServlet {
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	PrintWriter out=response.getWriter();
	response.setContentType("text/html");
	
	out.println("<link rel=\'stylesheet\' href=\'https://cdn.jsdelivr.net/npm/bootstrap@4.4.1/dist/css/bootstrap.min.css\' integrity=\'sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh\' crossorigin=\'anonymous\'></link>");

	String bid=request.getParameter("bid");
	String btype=request.getParameter("btype");
	int seats= Integer.parseInt(request.getParameter("seats"));
	String berths = request.getParameter("berths");
	
	try {
	Connection con = DataBaseConnection.getConnection();
	PreparedStatement ps2 = con.prepareStatement("update bus set Bus_Type=?,TotalSeats=?,No_of_Births=? where Bus_Reg_No=?");
	ps2.setString(1, btype);
	ps2.setInt(2, seats);
	ps2.setString(3, berths);
	ps2.setString(4, bid);
	
	int k=ps2.executeUpdate();
	out.println("<div style='margin:auto; width:800; margin-top:50px;'>");
	if(k>0) {
		out.println("<h2 class='bg-success text-light text-cenetr'>Bus Updated Successfully</h2>");
	}else {
		out.println("<h2 class='bg-danger text-light text-cenetr'>Bus Not Updated</h2>");
	}
	

} catch (SQLException e) {
	out.println("<h2 class='bg-danger text-light text-cenetr'>'"+e.getMessage()+"'<h2>");
	e.printStackTrace();
}
	out.println("<a href='BusController'><button class='btn btn-outline-success d-block> Home</button></a>");
	out.println("</div>");
}   
}
