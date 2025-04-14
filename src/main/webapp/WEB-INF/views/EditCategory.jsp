<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit Category</title>
</head>
<body>

<form action="updatecategory" method="post">
 		Title : <input type="text" name="title" value="${category.title}" /><br> <br>
 		
 		<input type="hidden" name="categoryId"  value="${category.categoryId}"/>
 		
 		<input type="submit" value="Update Category" />
 	</form>

</body>
</html>