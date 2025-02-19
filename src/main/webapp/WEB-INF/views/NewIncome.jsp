<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>New Income</title>
</head>
<body>
<h2>New Income</h2>

<form action="saveexpense" method="post">

Title :<input type="text" name="title"/><br></br>
Status :<input type="text" name="status"/><br></br>
Amount :<input type="text" name="amount"/><br></br>
TranscationDate :<input type="text" name="transcationDate"/><br></br>
Description :<input type="text" name="description"/><br></br>
<input type="submit" value="Save Expense"/>

</form>

</body>
</html>