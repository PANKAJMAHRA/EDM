<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript" src="passwordcheck.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Registration Page</title>
</head>
<body>
	<form name="f1" method="post" action="RegistrationController" onsubmit="return matchpass()">
		<!--<input type="hidden" name="action" value="adduser" />-->
		<table>
			<tr>
				<th>First Name</th>
				<td><input type="text" name="fname" /></td>
			</tr>
			<tr>
				<th>Last Name</th>
				<td><input type="text" name="lname" /></td>
			</tr>
			<tr>
				<th>Email</th>
				<td><input type="text" name="useremail" /></td>
			</tr>
			<tr>
				<th>Password</th>
				<td><input type="password" name="userpassword" /></td>
			</tr>
			<tr>
				<th>Confirm Password</th>
				<td><input type="password" name="userpassword2" /></td>
			</tr>
			<tr>
				<td><input type="submit" value="Register">
				<input type="hidden" name="action" value="adduser" />
				</td>
				<td><input type="button" value="login" onclick="location.href='login.jsp';">
				</td>
			</tr>
		</table>
	</form>
</body>
</html>