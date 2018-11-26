<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<table>
<tr>
<td>
Lets add a Payee:
</td>
<td>
<form action="addPayee" method="post">
<input type="submit" value="Add Payee">
</form>
</td>
</tr>
<tr>
<td>
Let make a Transfer:
</td>
<td>
<form action="makeTransfer" method="get">
<input type="submit" value="Make Transfer">
</form>
</td>
</tr>
</table>
</body>
</html>