<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>List Account</title>
<jsp:include page="AdminCss.jsp"></jsp:include>
<link  href="https://cdn.datatables.net/2.2.2/css/dataTables.bootstrap5.min.css" rel="stylesheet"/>

</head>
<body>
		<h2>List Account</h2>
		<jsp:include page="AdminHeader.jsp"></jsp:include>
		<jsp:include page="AdminSidebar.jsp"></jsp:include>


<main id="main" class="main">

		<div class="pagetitle">
			<h1>Dashboard</h1>
			<nav>
				<ol class="breadcrumb">
					<li class="breadcrumb-item"><a href="home">Home</a></li>
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
		<th>Title</th>
		<th>Amount</th>
		<th>Description</th>
		<th>FirstName</th>
		<th>LastName</th>
		<th>Email</th>
		<th>ContactNum</th>
		<th>Action</th>
		</tr>
		
		<c:forEach items="${allAccount}" var="a">
		
		<tr>
			<td>${a[3]}</td>
			<td>${a[1]}</td>
			<td>${a[2]}</td>
			<td>${a[5]}</td>
			<td>${a[6]}</td>
			<td>${a[7]}</td>
			<td>${a[8]}</td>
			
			<td><a href="viewaccount?accountId=${a[0]}">View</a>  |  <a href="deleteaccount?accountId=${a[0]}">Delete</a>  |  <a href="editaccount?accountId=${a[0]}">Edit</a> </td>			
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