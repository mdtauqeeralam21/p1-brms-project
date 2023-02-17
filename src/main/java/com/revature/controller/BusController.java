package com.revature.controller;

import java.io.IOException;
import java.util.List;

import com.revature.dao.BusDAO;
import com.revature.dao.BusDAOImpl;
import com.revature.model.Bus;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/BusController")
public class BusController extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	RequestDispatcher dispatcher = null;
	BusDAO busDAO = null;
	
	public BusController() {
		busDAO = new BusDAOImpl();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String action = request.getParameter("action");
		
		if(action == null) {
			action = "LIST";
		}
		
		switch(action) {
			
			case "LIST":
				listBus(request, response);
				break;
				
			case "EDIT":
				getSingleBus(request, response);
				break;
				
			case "DELETE":
				deleteBus(request, response);
				break;
				
			default:
				listBus(request, response);
				break;
				
		}
		
	}

	private void deleteBus(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String bid = request.getParameter("id");
	
		if(busDAO.delete(bid)) {
			request.setAttribute("NOTIFICATION", "Bus Deleted Successfully!");
		}
		
		listBus(request, response);
	}

	private void getSingleBus(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		
		String id = request.getParameter("id");
		
		Bus thebus = busDAO.get(id);
		
		request.setAttribute("bus", thebus);
		
		dispatcher = request.getRequestDispatcher("/EditBusServlet");
		
		dispatcher.forward(request, response);
	}

	private void listBus(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<Bus> theList = busDAO.get();
		
		request.setAttribute("list", theList);
		
		dispatcher = request.getRequestDispatcher("/views/bus-list.jsp");
		
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String id = request.getParameter("id");
		
		Bus b = new Bus();
		b.setBusRegNo(request.getParameter("busrno"));
		b.setBusType(request.getParameter("bType"));
		b.setTotalSeats(Integer.parseInt(request.getParameter("seats")));
		b.setTotalBerths(request.getParameter("berths"));
		
		if(id.isEmpty() || id == null) {
			
			if(busDAO.save(b)) {
				request.setAttribute("NOTIFICATION", "Bus Saved Successfully!");
			}
		
		}else {
			
			b.setBusRegNo(id);
			if(busDAO.update(b)) {
				request.setAttribute("NOTIFICATION", "Bus Updated Successfully!");
			}
			
		}
		
		listBus(request, response);
	}

}
