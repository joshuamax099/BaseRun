<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div align="center">
		<h1>Employee List</h1>

		<table border="1">
			<tr>
				<th>Account Number</th>
				<th>Name</th>
				<th>IFSC Code</th>
				<th colspan="2">Action</th>
			</tr>
			<c:forEach var="employee" items="${list}">
				<tr>
					<td>${employee.ga_payee_accno}</td>
					<td>${employee.ga_payee_name}</td>
					<td>${employee.ga_payee_acc_ifsc}</td>
					<td><a href="editPayee/${employee.ga_payee_accno}">Edit Payee</a></td>
					<td><a href="deletePayee/${employee.ga_payee_accno}">Delete Payee</a></td>
				</tr>
			</c:forEach>
		</table>
		<h4>
			New Employee Register <a href="newEmployee">here</a>
		</h4>
	</div>

</body>
</html>