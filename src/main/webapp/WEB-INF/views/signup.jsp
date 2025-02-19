<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Signup</title>
</head>
<body>
	<h2>Signup</h2>

	<form action="saveuser" method="post">
		FirstName: <input type="text" name="firstName"  /><br><br> 
		LastName: <input type="text" name="lastName"  /><br><br> 
		
		Gender: Male<input type="radio" name="gender" value="male">
				FeMale<input type="radio" name="gender" value="female"><br><br> 
		
		ContactNum: <input type="text" name="contactNum"/><br><br> 
		
		City: <input type="text" name="city"/><br></br>
		
		Email: <input type="text" name="email"/><br><br> 
		
		
		Password: <input type="password" name="password"/><br><br> 
		
		BornYear  : <input type="text" name="bornYear"/><br><Br> 
	
		<input type="submit" value="Signup"/>
	
	</form>


<br><br> 
	<a href="login">Login</a>

</body>
</html>