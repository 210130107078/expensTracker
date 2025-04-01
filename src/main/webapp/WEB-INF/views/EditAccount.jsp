<%@ page language="java" contentType="text/html; charset=UTF-8"
 	pageEncoding="UTF-8"%>
 <!DOCTYPE html>
 <html>
 <head>
 <meta charset="UTF-8">
 <title>Edit Account</title>
 </head>
 <body>
 	<form action="updateaccount" method="post">
 		Title : <input type="text" name="title" value="${account.title}" /><br> <br>
 		Amount : <input type="text" name="amount" value="${account.amount}" /><br> <br>
 		Description: <input type="text" name="description" value="${account.description}" /><br> <br>
 			
 		<input type="hidden" name="accountId"  value="${account.accountId}"/>
 		
 		<input type="submit" value="Update Account" />
 	</form>
 
 </body>
 </html>