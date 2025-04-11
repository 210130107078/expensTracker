<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit Vendor</title>
</head>
<body>

<form action="updatevendor" method="post">
 		Title : <input type="text" name="title" value="${vendor.title}" /><br> <br>
 		
 		<input type="hidden" name="vendorId"  value="${vendor.vendorId}"/>
 		
 		<input type="submit" value="Update Vendor" />
 	</form>

</body>
</html>