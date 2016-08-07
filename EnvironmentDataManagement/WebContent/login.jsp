<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form method="post" action='RegistrationController' name="login">
	<input type="hidden" name="action" value="login">
		<table>
			<tr>
				<th>User Email</th>
				<td><input type="text" name="txtuseremail" /></td>
			</tr>
			<tr>
				<th>Password</th>
				<td><input type="password" name="txtuserpassword" /></td>
			</tr>
			<tr>
				<td><button type="submit">login</button></td>

				<td><a href="RegistrationController?action=adduser1">Register</a></td>
			</tr>
		</table>
	</form>
</body>
</html>