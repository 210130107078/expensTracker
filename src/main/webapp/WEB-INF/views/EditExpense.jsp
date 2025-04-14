<%@ page language="java" contentType="text/html; charset=UTF-8"
 	pageEncoding="UTF-8"%>
 <!DOCTYPE html>
 <html>
 <head>
 <meta charset="UTF-8">
 <title>Edit Expense</title>
 </head>
 <body>
 	<form action="updateexpense" method="post">
 		Title : <input type="text" name="title" value="${expense.title}" /><br> <br>
 		Amount : <input type="text" name="amount" value="${expense.amount}" /><br> <br>
 		Status : <input type="text" name="status" value="${expense.status}" /><br> <br>
 		Description: <input type="text" name="description" value="${expense.description}" /><br> <br>
 			
 		<input type="hidden" name="expenseId"  value="${expense.expenseId}"/>
 		
 		<input type="submit" value="Update Expense" />
 	</form>
 
 </body>
 </html>