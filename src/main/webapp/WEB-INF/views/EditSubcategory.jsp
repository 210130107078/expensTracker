<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit Subcategory</title>
</head>
<body>

<form action="updatesubcategory" method="post">
 		Subcategory Title : <input type="text" name="subtitle" value="${subtitle.title}" /><br> <br>
 		
 		<input type="hidden" name="subcategoryId"  value="${subcategory.subcategoryId}"/>
 		
 		<input type="submit" value="Update Subcategory" />
 	</form>

</body>
</html>