<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Application Edit Page</title>
</head>
<body>
<form method="post" action='EDMController' name="frmAddApplication">
<c:forEach items="${applicationlist }" var="app">
Id:<input  type="text" readonly="readonly" name="id" value="<c:out value="${app.id }"/>"/><br/>
Name:<input type="text" name="name" value="<c:out value="${app.name}"/>"/><br/>
Deployment Location:<input type="text" name="deploc" value="<c:out value="${app.deploymentLocation }"/>"/><br/>
Log Type:<input type="text" name="logtype" value="<c:out value="${app.logType }"/>"/><br/>
</c:forEach>
<input type="hidden" name="action" value="updateapplication"/>
<input type="submit" value="submit"> 
</form>
</body>
</html>