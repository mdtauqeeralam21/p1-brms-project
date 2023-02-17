<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Admin Dashboard</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
</head>
<body>
	<div class = "container">
		<div class="float-right">
			<a href="${pageContext.request.contextPath}/logout.jsp"><button type="button" class="btn btn-danger">Logout</button></a>
		</div>
		<h1>Add New Bus</h1>
		<hr/>
		
		<div class = "d-flex justify-content-center">
			<div class = "col-md-4">
				<form action = "${pageContext.request.contextPath}/BusController" method="POST">
				
					<div class = "form-group">
					<input type = "text" class = "form-control" name = "busrno" placeholder = "Enter Reg No" pattern="[A-Z]{2}-[0-9]{4}"/>
					</div>
				
					<div class = "form-group">
					<input type = "text" class = "form-control" name = "bType" placeholder= "Enter Bus Type (AC/NAC)" />
					</div>
				
					<div class="form-group">
					<input type = "text" class = "form-control" name = "seats" placeholder = "Enter No of Seats" />
					</div>
					<div class="form-group">
					<input type = "text" class = "form-control" name = "berths" placeholder = "Enter Total Berths" />
					</div>
				
					<input type = "hidden" name = "id" value = "${bus.getBusRegNo()}"/>
				
					<button type = "submit" class = "btn btn-primary">Save</button>
				</form>
			</div>
		</div>
		<a href = "${pageContext.request.contextPath}/BusController?action=LIST"><button type="button" class="btn btn-secondary">Back to List</button></a>
	</div>
	

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
</body>
</html>