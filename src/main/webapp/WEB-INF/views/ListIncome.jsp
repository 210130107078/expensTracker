<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>List Income</title>
</head>
<body>
<h2>List Income</h2>

	<table border="1">
		
		<tr>
		<th>Title</th>
		<th>Status</th>
		<th>Amount</th>
		<th>TranscationDate</th>
		<th>Description</th>
		</tr>
		
		<c:forEach items="${incomeList}" var="i">
		
		<tr>
		<td>${i.title}</td>
		<td>${i.status}</td>
		<td>${i.amount}</td>
		<td>${i.transcationDate}</td>
		<td>${i.description}</td>
		</tr>
		
		</c:forEach>
		
		</table>

</body>
</html>