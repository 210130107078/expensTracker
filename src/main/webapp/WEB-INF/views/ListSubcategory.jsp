<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>List Subcategory</title>
</head>
<body>
<h2>List Subcategory</h2>

	<table border="1">
		
		<tr>
		<th>Title</th>
	    <th>SubTitle</th>
		<th>Action</th>
		</tr>
		
		<c:forEach items="${subcategoryList}" var="s">
		
		<tr>
		<td>${s.title}</td>
		<td>${s.subTitle }</td>
		<td><a href="viewsubcategory?subcategoryId=${s.subcategoryId}">View</a>  |  <a href="deletesubcategory?subcategoryId=${s.subcategoryId}">Delete</a>  |  Edit </td>
		</tr>
		
		</c:forEach>
		
		</table>
	


</body>
</html>