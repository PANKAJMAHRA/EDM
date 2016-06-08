<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Application</title>
</head>
<body>
<form method="post" action="EDMController">
<%--Id:<input type="text" name="id"/><br>--%>
Name:<input type="text" name="name"/><br>
Deployment Location:<input type="text" name="deploymentlocation"/><br>
Log Type:<input type="text" name="logtype"/><br>
<input type="hidden" name="action" value="addapplication1"/>
Application Type:<input type="text" name="apptype">
<input type="hidden" name="action" value="addapplicationtype">
<input type="submit" value="submit"/>
</form>
</body>
</html>