<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<table border=1>
<thead>
<tr>
<th>Id</th>
<th>Name</th>
<th>Deployment Location</th>
<th>Log Type</th>
<th>Application Type</th>
<th colspan=2>Action</th>
</tr>
</thead>
<tbody>
<c:forEach items="${applicationlist}" var="app">
<tr>
<td><c:out value="${ app.id}"/> </td>
<td><c:out value="${ app.name}"/></td>
<td><c:out value="${ app.deploymentLocation}"></c:out></td>
<td><c:out value="${ app.logType}"></c:out></td>
<td><c:out value="${app.applicationType}"></c:out></td>
<td><a href="EDMController?action=editapplication&ApplicationId=<c:out value="${app.id}"/>">Edit</a></td>
<td><a href="EDMController?action=deleteapplication&ApplicationId=<c:out value="${app.id}"/>">Delete</a></td>
</tr>
</c:forEach>
</tbody>
</table>
<p><a href="EDMController?action=addapplication">Add Application</a></p>
</body>
</html>