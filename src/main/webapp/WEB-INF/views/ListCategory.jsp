<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>List Category</title>
</head>
<body>

<h2>List Category</h2>

	<table border="1">
		
		<tr>
		<th>Title</th>
		<th>Action</th>
		</tr>
		
		<c:forEach items="${categoryList}" var="c">
		
		<tr>
		<td>${c.title}</td>
		<td><a href="viewcategory?categoryId=${c.categoryId}">View</a>  |  <a href="deletecategory?categoryId=${c.categoryId}">Delete</a>  |  Edit </td>
		</tr>
		
		</c:forEach>
		
		</table>
	

</body>
</html>