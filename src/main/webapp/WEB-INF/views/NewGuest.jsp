<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>New Guest</title>
<jsp:include page="AdminCss.jsp"></jsp:include>
</head>
<body>
	<h2>New Guest</h2>
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
	<form action="saveguest" method="post">
		FullName : <input type="text" name="fullName"/> <br><Br> 
		ContactNum: <input type="text" name="contactNum"/> <br><br> 
		HouseNum :  <input type="text" name="houseNum"/><br><br> 
		DateTime :  <input type="text" name="dateTime"/><bR><br> 
		Purpose :  <input type="text" name="purpose"/><br><br> 
		Pic :  <input type="file" name="pic"/><br><Br> 
		VehicleRegNo :  <input type="text" name="vechicleRegNo"/><br><br> 
		NumberOfVisitors : <input type="text" name="NumberOfVisitors"/> <br><br> 
		
		<input type="submit" value="Save Guest"/>
	
	
	</form>
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

	

</body>
</html>