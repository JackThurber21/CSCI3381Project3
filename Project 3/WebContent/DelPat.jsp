<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Deleter</title>
</head>
<body>
<form action="http://localhost:8080/Project_3/MainServlet" method="get">
	<%String patString = (String) request.getAttribute("myPatients"); %>
	My Patients: <br><%=patString %><br>
	<% String patients=(String)request.getAttribute("select"); %> 
	<input type= "submit" value= "Delete" onclick= "alert('Deleted Patient returning to Patient View')" name= "delButton">
	<input type= "submit" value= "Go Back" name= "backButton">
</form>
</body>
</html>