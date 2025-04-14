<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>View Income</title>
<jsp:include page="UserCss.jsp"></jsp:include>
<link  href="https://cdn.datatables.net/2.2.2/css/dataTables.bootstrap5.min.css" rel="stylesheet"/>

</head>
<body>
<h2>View Income</h2>
<jsp:include page="UserHeader.jsp"></jsp:include>
<jsp:include page="UserSidebar.jsp"></jsp:include>


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
		<th>Status</th>
		<th>Amount</th>
		<th>TranscationDate</th>
		<th>Description</th>
		<th>FirstName</th>
		<th>LastName</th>
		<th>Email</th>
		<th>ContactNum</th>
		</tr>
		
		<c:forEach items="${income}" var="i">
		
		<tr>
		<td>${i[5]}</td>
		<td>${i[4]}</td>
		<td>${i[2]}</td>
		<td>${i[6]}</td>
		<td>${i[3]}</td>
		<td>${i[8]}</td>
		<td>${i[9]}</td>
		<td>${i[10]}</td>
		<td>${i[11]}</td>
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
<jsp:include page="UserFooter.jsp"></jsp:include>

	<jsp:include page="UserJs.jsp"></jsp:include>
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