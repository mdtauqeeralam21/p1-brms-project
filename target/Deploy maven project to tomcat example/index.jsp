<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Login System</title>
    </head>
 	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
    <body style="color:white;">
        <%
        String email=(String)session.getAttribute("email");
        
        //redirect user to home page if already logged in
        if(email!=null){
            response.sendRedirect("BusController?action=LIST");
        }
 
        String status=request.getParameter("status");
        
        if(status!=null){
        	if(status.equals("false")){
        		   out.print("Incorrect login details!");	           		
        	}
        	else{
        		out.print("Some error occurred!");
        	}
        }
        %>
    
        <div class="mx-auto" style="width: 600px;margin:100px;">
        	<form action="loginprocess" method="post"> 
       		<div class="card">
	        	<div class="bg-primary bg-gradient card-header text-center font-weight-bold">
	        		Admin Login
	        	</div>
	        	<div class="card-body">
	                    <div class="form-group">
	                    	<input type="text" name="email" required class="form-control" placeholder="Enter Email"/>
	                    </div>
	                	<div class="form-group">
	                		<input type="password" name="password" required class="form-control" placeholder="Enter password"/>
	                	</div>
	        		
	        	</div>
	        	<div class="card-footer text-center">
	        		<input type="submit" value="Login" class="btn btn-primary"/>
	        	</div>
       		</div>
        	</form>
        </div>
    </body>
</html>