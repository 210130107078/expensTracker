<%@ page language="java" contentType="text/html; charset=UTF-8"
 	pageEncoding="UTF-8"%>
 <!DOCTYPE html>
 <html>
 <head>
 <meta charset="UTF-8">
 <title>Edit Income</title>
 </head>
 <body>
 	<form action="updateincome" method="post">
 		Title : <input type="text" name="title" value="${income.title}" /><br> <br>
 		Amount : <input type="text" name="amount" value="${income.amount}" /><br> <br>
 		Status : <input type="text" name="status" value="${income.status}" /><br> <br>
 		Description: <input type="text" name="description" value="${income.description}" /><br> <br>
 			
 		<input type="hidden" name="incomeId"  value="${income.incomeId}"/>
 		
 		<input type="submit" value="Update Income" />
 	</form>
 
 </body>
 </html>