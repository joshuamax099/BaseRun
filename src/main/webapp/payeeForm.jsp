<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="addpayee1" method="post">
<table>
<tr>
<td>
Payee Name:
</td>
<td>
<input type="text" name="ga_payee_name">
</td>
</tr>
<tr>
<td>
Payee Bank IFSC Code:
</td>
<td>
<input type="text" name="ga_payee_acc_ifsc">
</td>
</tr>
<tr>
<td>
Payee Bank Account No:
</td>
<td>
<input type="text" name="ga_payee_accno">
</td>
</tr>
<tr>
<td>
<input type="submit" value="Submit">
</td>
<td>
<input type="reset" value="Reset">
</td>
</tr>
</table>
</form>

</body>
</html>