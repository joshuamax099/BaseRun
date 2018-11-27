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
Payee Details:
</td>
<td>
<form action="payeeDash" method="post">
<input type="submit" value="Payee Details">
</form>
</td>
</tr>
<tr>
<td>
Money Transfer:
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