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
NEFT Payment:
</td>
<td>
<form action="neftTransfer" method="post">
<input type="submit" value="NEFT Transfer">
</form>
</td>
</tr>
<tr>
<td>
RTGS Payment:
</td>
<td>
<form action="rtgsTransfer" method="post">
<input type="submit" value="RTGS Transfer">
</form>
</td>
</tr>
<tr>
<td>
IMPS Payment:
</td>
<td>
<form action="impsTransfer" method="post">
<input type="submit" value="IMPS Transfer">
</form>
</td>
</tr>
</table>
</body>
</html>