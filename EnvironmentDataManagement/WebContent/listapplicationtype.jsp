<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>List Application Type</title>
</head>
<body>
<h4>Please fill Application Type Id column by taking the help from this table</h4>  
<table border=1>
<thead>
<tr>
<th>Application Type Id</th>
<th>Application Type</th>
</tr>
</thead>
<tbody>
<c:forEach items="${applicationtypelist }" var="apptype">
<tr>
<td><c:out value="${apptype.id }"/></td>
<td><c:out value="${apptype.applicationType }"/></td>
</tr>
</c:forEach>
</tbody>
</table>
</body>
</html>