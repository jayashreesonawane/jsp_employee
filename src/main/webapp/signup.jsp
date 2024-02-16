<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>SignUp Page</title>
</head>
<body>	
<% String message = (String)request.getAttribute("message"); 
	if(message!=null){%>
	<%=message%>
	<% } %>
<fieldset>
	<form action="signup" method="post">
	<h1>SignUp Page</h1>
		Id : <input type="number" name="id"><br><br>
		Name : <input type="text" name="name"><br><br>
		Phone : <input type="tel" name="phone"><br><br>
		Address : <input type="text" name="address"><br><br>
		Email : <input type="text" name="email"><br><br>
		Password : <input type="text" name="password"><br><br>
		<button>SignUp</button>
	</form>
	</fieldset>
</body>
</html>