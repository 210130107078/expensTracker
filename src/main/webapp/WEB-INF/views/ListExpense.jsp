<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>List Expense</title>
</head>
<body>
<h2>List Expense</h2>

	<table border="1">
		
		<tr>
		<th>Title</th>
		<th>Status</th>
		<th>Amount</th>
		<th>TranscationDate</th>
		<th>Description</th>
		<th>Action</th>
		</tr>
		
		<c:forEach items="${expenseList}" var="e">
		
		<tr>
		<td>${e.title}</td>
		<td>${e.status}</td>
		<td>${e.amount}</td>
		<td>${e.transcationDate}</td>
		<td>${e.description}</td>
		<td><a href="viewexpense?expenseId=${e.expenseId}">View</a>  |  <a href="deleteexpense?expenseId=${e.expenseId}">Delete</a>  |  Edit </td>
		</tr>
		
		</c:forEach>
		
		</table>

</body>
</html>