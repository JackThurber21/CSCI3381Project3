
<head>
<title> Patient View</title>
</head>
<body> 
<form action="http://localhost:8080/Project_3/MainServlet" method="get"> 
	<%String name = (String)request.getAttribute("username"); %>
	Welcome!<br><br>
	<%String patString = (String) request.getAttribute("myPatients"); %>
	My Patients: <br><%=patString %><br>
	<% String patients=(String)request.getAttribute("select"); %> 
	<input type ="submit" value="Modify Patients" name= "Modpat"><br>
	<input type ="submit" value="Delete Patients" name= "DelPat"><br>
 	<input type="submit" value="Logout" name="doLogout">  
 	<input type ="hidden" name = "username"value = <%=name%>>;
 </form> 
</body> 
