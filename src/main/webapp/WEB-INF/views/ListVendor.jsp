<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>List Vendor</title>
</head>
<body>
<h2>List Vendor</h2>
<table border="1">
		
		<tr>
		<th>Title</th>
		<th>Action</th>

		</tr>
		
		<c:forEach items="${vendorList}" var="v">
		
		<tr>
		<td>${v.title}</td>
		<td><a href="viewvendor?vendorId=${v.vendorId}">View</a>  |  <a href="deletevendor?vendorId=${v.vendorId}">Delete</a>  |  Edit </td>
		</tr>
		
		</c:forEach>
		
		</table>

</body>
</html>
