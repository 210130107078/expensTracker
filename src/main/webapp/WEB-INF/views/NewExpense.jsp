<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>New Expense</title>
<jsp:include page="AdminCss.jsp"></jsp:include>
</head>
<body>
<h2>New Expense</h2>
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



 <form action="saveexpense" method="post">
                <div class="mb-3">
                    <label for="title" class="form-label">Title</label>
                    <input type="text" name="title" id="title" class="form-control" required>
                </div>
                <div class="mb-3">
                    <label for="status" class="form-label">Status</label>
                    <select class="form-select" name="status" required>
                        <option value="">Select Status</option>
                        <option value="Paid">Paid</option>
                        <option value="Pending">Pending</option>
                        <option value="Overdue">Overdue</option>
                    </select>
                </div>
                <div class="mb-3">
                    <label for="amount" class="form-label">Amount</label>
                    <input type="number" name="amount" id="amount" class="form-control" required>
                </div>
                <div class="mb-3">
                    <label for="transactionDate" class="form-label">Transaction Date</label>
                    <input type="date" name="transcationDate" id="transactionDate" class="form-control" required>
                </div>
                <div class="mb-3">
                    <label for="description" class="form-label">Description</label>
                    <textarea name="description" id="description" class="form-control" rows="3" required></textarea>
                </div>
                <select name="accountId">
                	<c:forEach items="${allAccount}" var="a">
                		<option value="${a.accountId}">${a.amount }</option>
                		
                	</c:forEach>
                </select>
                
                 <select name="vendorId">
                	<c:forEach items="${allVendor}" var="v">
                		<option value="${v.vendorId}">${v.title }</option>
                		
                	</c:forEach>
                </select>
                  <select name="categoryId">
                	<c:forEach items="${allcategory}" var="c">
                		<option value="${c.categoryId}">${c.title }</option>
                		
                	</c:forEach>
                </select>
                
                 <select name="subcategoryId">
                	<c:forEach items="${allsubcategory}" var="s">
                		<option value="${s.subcategoryId}">${s.subtitle }</option>
                		
                	</c:forEach>
                </select>
                <button type="submit" class="btn btn-primary w-100">Save Expense</button>
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