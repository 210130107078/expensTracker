<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>New Account</title>
</head>
<body>
<h2>New Account</h2>

	<form action="saveaccount" method="Post">
	Title:<input type="text" name="title"/><br><Br> 
	Amount :<input type="text" name="amount"/><br><Br>
	Description :<input type="text" name="description"/><br><Br>
	<input type="submit" value="Save Account">
	</form>	
</body>

</html>