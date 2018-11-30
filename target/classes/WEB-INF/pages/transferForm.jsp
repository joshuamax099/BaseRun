<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="transferAmount" method="post">
<table>
<tr>
<td>
Select Payee(id kk):
</td>
<td> 
<select name="ga_receiver_accno">
    <c:forEach items="${list}" var="list">
        <option value="${list.ga_payee_accno}">${list.ga_payee_name}</option>
    </c:forEach>
</select>
</td>
</tr>
<tr>
<td>
Enter Amount for transfer:
</td>
<td>
<input type="text" name="ga_transfer_amount">
</td>
</tr>
<tr>
<td>
Transfer Mode:
</td>
<td>
<select name="ga_transfer_mode">
<option value="neft">Neft Transfer</option>
<option value="rtgs">RTGS Transfer</option>
<option value="imps">IMPS Transfer</option>
</select>
</td>
</tr>
<tr>
<td>
Enter Remarks:
</td>
<td>
<input type="textarea" name="ga_payee_remarks">
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