<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>List Account</title>
</head>
<body>
		<h2>List Account</h2>
		
		<table border="1">
		
		<tr>
		<th>Title</th>
		<th>Amount</th>
		<th>Description</th>
		</tr>
		
		<c:forEach items="${accountList}" var="a">
		
		<tr>
		<td>${a.title}</td>
		<td>${a.amount}</td>
		<td>${a.description}</td>
		</tr>
		
		</c:forEach>
		
		</table>



</body>
</html>