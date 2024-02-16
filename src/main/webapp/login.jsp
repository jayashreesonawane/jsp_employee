<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login Page</title>
</head>
<body>
	<% String message = (String)request.getAttribute("message"); 
	if(message!=null){%>
	<%=message%>
	<% } %>
	<fieldset>
		<form action="login" method="post">
			<h1>Login Page</h1>
			Email : <input type="text" name="email"><br>
			<br> Password : <input type="text" name="password"><br>
			<br>
			<button>Login</button>
		</form>
	</fieldset>
</body>
</html>