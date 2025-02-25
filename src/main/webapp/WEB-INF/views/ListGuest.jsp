<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>List Guest</title>
</head>
<body>
<h2>List Guest</h2>


<table border="1">

		<tr>
			    <th>Full Name</th>
			    <th>ContactNum</th>
				<th>HouseNum</th>
				<th>DateTime</th>
				<th>Purpose</th>
				<th>Pic</th>
				<th>VehicleRegNo</th>
				<th>NumberOfVisitors</th>	
				<th>Action</th>
		</tr>
		<c:forEach items="${guestList}" var="g">

			<tr>
				<td>${g.fullName}</td>
				<td>${g.contactNum}</td>
				<td>${g.houseNum}</td>
				<td>${g.dateTime}</td>
				<td>${g.purpose}</td>
				<td>${g.pic}</td>
				<td>${g.vehicleRegNo}</td>
				<td>${g.numberOfVisitors}</td>	
				<td><a href="viewguest?guestId=${g.guestId}">View</a>  |  <a href="deleteguest?guestId=${g.guestId}">Delete</a>  |  Edit </td>
				
			</tr>
		</c:forEach>
	</table>
	

</body>
</html>