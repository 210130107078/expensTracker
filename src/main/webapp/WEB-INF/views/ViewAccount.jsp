<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
      <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>View Expense</title>
</head>
<body>
<h2>View Expense</h2>


		<c:forEach items="${account}" var="a">
		Title : ${a[1] }<br>
		Amount : ${a[2] }<br>
		Description : ${a[3] }<br>
		firstName: ${a[5]} <br>
		lastName: ${a[6]} 
		</c:forEach>
				
</body>
</html>