<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="com.revature.*" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Bus Directory</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/v/bs4/dt-1.10.20/datatables.min.css"/>
</head>
<body>
	<%
        String email=(String)session.getAttribute("email");
        
        //redirect user to login page if not logged in
        if(email==null){
        	response.sendRedirect("index.jsp");
        }
    %>
	<div class = "container">
		<div class="float-right">
			<a href="${pageContext.request.contextPath}/logout.jsp"><button type="button" class="btn btn-danger">Logout</button></a>
		</div>
		<h1>Bus Directory</h1>
		<hr/>
		
		<p>${NOTIFICATION}</p>
		
		<p>
			<button class = "btn btn-primary" onclick="window.location.href = 'views/bus-form.jsp'">Add Bus</button>
		</p>
	
		<table class = "table table-striped table-bordered" id="datatable">
			<thead>
				<tr class = "thead-dark">
					<th>Bus Registration No</th>
					<th>Type</th>
					<th>Total Seats</th>
					<th>Berths</th>
					<th>Actions</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${list}" var="bus">
	            <tr>
						<td>${bus.getBusRegNo()}</td>
						<td>${bus.getBusType()}</td>
						<td>${bus.getTotalSeats()}</td>
						<td>${bus.getTotalBerths()}</td>
					
						<td> 
							<a href = "${pageContext.request.contextPath}/editBus?id=${bus.getBusRegNo()}"><button type="button" class="btn btn-warning">Edit &nbsp;&nbsp;</button></a>
							&nbsp; &nbsp;  
							<a href = "${pageContext.request.contextPath}/BusController?action=DELETE&id=${bus.getBusRegNo()}"><button type="button" class="btn btn-danger">Delete</button></a> 
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
<script type="text/javascript" src="https://cdn.datatables.net/v/bs4/dt-1.10.20/datatables.min.js"></script>
<script>
	$(document).ready(function(){
		$("#datatable").DataTable();
	})
</script>
</body>
</html>