<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Viewing All Data</title>
</head>
<body>
<table border="1">
<thead>
<tr>
<th>Id</th>
<th>Name</th>
<th>Deployment Location</th>
<th>Log Type</th>
<th>Application Type</th>
</tr>
</thead>
<tbody>
<c:forEach items="${commonlist }" var="commlst">
<tr>
<td><c:out value="${commlst.id }"></c:out></td>
<td><c:out value="${commlst.name }"></c:out> </td>
<td><c:out value="${commlst.deploymentLocation }"></c:out> </td>
<td><c:out value="${commlst.logType }"></c:out></td>
<td><c:out value="${commlst.applicationType }"></c:out></td>
</tr>
</c:forEach>
</tbody>
</table>
</body>
</html>