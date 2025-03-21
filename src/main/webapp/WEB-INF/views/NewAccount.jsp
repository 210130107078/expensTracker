<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>New Account</title>
<jsp:include page="AdminCss.jsp"></jsp:include>

</head>
<body>
<h2>New Account</h2>
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
	<form action="saveaccount" method="post" class="p-3">
    <label for="title">Title:</label>
    <input type="text" name="title" id="title" class="form-control mb-2" required>

    <label for="amount">Amount:</label>
    <input type="number" name="amount" id="amount" class="form-control mb-2" required>

    <label for="description">Description:</label>
    <textarea name="description" id="description" class="form-control mb-2" rows="3" required></textarea>

    <button type="submit" class="btn btn-primary">Save Account</button>
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