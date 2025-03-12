<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>List Account</title>
<jsp:include page="AdminCss.jsp"></jsp:include>
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
		
		<table border="1">
		
		<tr>
		<th>Title</th>
		<th>Amount</th>
		<th>Description</th>
		<th>Action</th>
		</tr>
		
		<c:forEach items="${accountList}" var="a">
		
		<tr>
		<td>${a.title}</td>
		<td>${a.amount}</td>
		<td>${a.description}</td>
		<td><a href="viewaccount?accountId=${a.accountId}">View</a>  |  <a href="deleteaccount?accountId=${a.accountId}">Delete</a>  |  Edit </td>
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


</body>
</html>