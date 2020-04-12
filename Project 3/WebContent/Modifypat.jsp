<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Modify Patient</title>
</head>
<body>
<form action="http://localhost:8080/Project_3/MainServlet" method="get">
Set a result!<br>
<input type= "radio" id = "CR" name= "pred" value= "CR">
<label for="CR" >CR</label><br>
<input type= "radio" id = "DP" name= "pred" value= "DP">
<label for="DP" >DP</label><br>
<input type= "submit" value= "Add Modification" onclick= "alert('Added Modification returning to Patient View')" name= "modButton">
<input type= "submit" value= "Go Back" name= "backButton">

</form>

</body>
</html>