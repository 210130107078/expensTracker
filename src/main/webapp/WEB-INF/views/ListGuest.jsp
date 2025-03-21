<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>List Guest</title>
<jsp:include page="AdminCss.jsp"></jsp:include>
<link  href="https://cdn.datatables.net/2.2.2/css/dataTables.bootstrap5.min.css" rel="stylesheet"/>

</head>
<body>
<h2>List Guest</h2>
<jsp:include page="AdminHeader.jsp"></jsp:include>
<jsp:include page="AdminSidebar.jsp"></jsp:include>


<main id="main" class="main">

		<div class="pagetitle">
			<h1>Dashboard</h1>
			<nav>
				<ol class="breadcrumb">
					<li class="breadcrumb-item"><a href="index.html">Home</a></li>
					<li class="breadcrumb-item active">Dashboard</li>
				</ol>
			</nav>
		</div>
		<!-- End Page Title -->

		<section class="section dashboard">
			<div class="row" style="min-height: 500px;">

				<!-- Left side columns -->
				<div class="col-lg-12">
					<div class="row" >
						<!-- Reports -->
						<div class="col-12">
							<div class="card">

							 
								<div class="card-body">
									<h5 class="card-title">
										Reports <span>/Today</span>
									</h5>


<table class="table datatable datatable-table table-hover" >

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
	
	<br><br>
					<br><br>
					

								</div>

							</div>
						</div>
						<!-- End Reports -->

					</div>
				</div>
				<!-- End Left side columns -->

				<!-- Right side columns -->
				<!-- End Right side columns -->

			</div>
		</section>

	</main>
<jsp:include page="AdminFooter.jsp"></jsp:include>

	<jsp:include page="AdminJs.jsp"></jsp:include>
	
	<script src="https://code.jquery.com/jquery-3.7.1.min.js" integrity="sha256-/JqT3SQfawRcv/BIHPThkBvs0OEvtFFmqPF/lYI/Cxo=" crossorigin="anonymous"></script>

 	<script src="https://cdn.datatables.net/2.2.2/js/dataTables.min.js"></script>
	<script src="https://cdn.datatables.net/2.2.2/js/dataTables.bootstrap5.min.js"></script>
  
 
 

	<script type="text/javascript">

	$( document ).ready(function() {
		let table = new DataTable('#myTable',{
			 
		});
	});
	</script>

</body>
</html>