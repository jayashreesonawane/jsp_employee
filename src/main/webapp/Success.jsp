
<%@page import="jsp_employee.Employee"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<style type="text/css">
table, th, td {
	border: 1.5px solid black;
	border-collapse: collapse;
}
</style>
<title>Login Success Page</title>
</head>
<body>
	<%
	String name = (String) request.getAttribute("cookie");
	if (name != null) {
	%>
	<h2>
		Changed by
		<%=name%></h2>
	<%
	}
	%>
	<%
	List<Employee> list = (List) request.getAttribute("list");
	%>
	<table>
		<tr>
			<th>Id</th>
			<th>Name</th>
			<th>Phone</th>
			<th>Address</th>
			<th>Email</th>
			<th>Password</th>
		</tr>

		<%
		for (Employee employee : list) {
		%>
		<tr>
			<td><%=employee.getId()%></td>
			<td><%=employee.getName()%></td>
			<td><%=employee.getPhone()%></td>
			<td><%=employee.getAddress()%></td>
			<td><%=employee.getEmail()%></td>
			<td><%=employee.getPassword()%></td>
			<td><a href="delete?id=<%=employee.getId()%>"><button>Delete</button></a></td>
			<td><a href="update?id=<%=employee.getId()%>"><button>Update</button></a></td>
		</tr>

		<%
		}
		%>


	</table>
	<button>Logout</button>
</body>
</html>