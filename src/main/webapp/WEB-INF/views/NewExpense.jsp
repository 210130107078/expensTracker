<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>New Expense</title>
    <jsp:include page="UserCss.jsp"></jsp:include>
</head>
<body>
    <h2>New Expense</h2>
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

        <!-- Dashboard Section -->
        <section class="section dashboard">
            <div class="row" style="min-height: 500px;">
                <div class="col-lg-12">
                    <div class="row">
                        <!-- Reports Card -->
                        <div class="col-12">
                            <div class="card">
                                <div class="card-body">
                                    <h5 class="card-title">
                                        Reports <span>/ Today</span>
                                    </h5>

                                    <!-- Expense Form -->
                                    <form action="saveexpense" method="post">
                                        <div class="mb-3">
                                            <label for="title" class="form-label">Title</label>
                                            <input type="text" name="title" id="title" class="form-control" required>
                                        </div>

                                        <div class="mb-3">
                                            <label for="status" class="form-label">Status</label>
                                            <select class="form-select" name="status" id="status" required>
                                                <option value="" disabled selected>Select Status</option>
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

                                        <div class="mb-3">
                                            <label for="accountId" class="form-label">Select Account</label>
                                            <select name="accountId" id="accountId" class="form-select" required>
                                                <option value="" disabled selected>Select an account</option>
                                                <c:forEach items="${allAccount}" var="a">
                                                    <option value="${a.accountId}">${a.amount}</option>
                                                </c:forEach>
                                            </select>
                                        </div>

                                        <div class="mb-3">
                                            <label for="vendorId" class="form-label">Select Vendor</label>
                                            <select name="vendorId" id="vendorId" class="form-select" required>
                                                <option value="" disabled selected>Select a vendor</option>
                                                <c:forEach items="${allVendor}" var="v">
                                                    <option value="${v.vendorId}">${v.title}</option>
                                                </c:forEach>
                                            </select>
                                        </div>

                                        <div class="mb-3">
                                            <label for="categoryId" class="form-label">Select Category</label>
                                            <select name="categoryId" id="categoryId" class="form-select" required>
                                                <option value="" disabled selected>Select a category</option>
                                                <c:forEach items="${allcategory}" var="c">
                                                    <option value="${c.categoryId}">${c.title}</option>
                                                </c:forEach>
                                            </select>
                                        </div>

                                        <div class="mb-3">
                                            <label for="subcategoryId" class="form-label">Select Subcategory</label>
                                            <select name="subcategoryId" id="subcategoryId" class="form-select" required>
                                                <option value="" disabled selected>Select a subcategory</option>
                                                <c:forEach items="${allsubcategory}" var="s">
                                                    <option value="${s.subcategoryId}">${s.subtitle}</option>
                                                </c:forEach>
                                            </select>
                                        </div>

                                        <button type="submit" class="btn btn-primary w-100">Save Expense</button>
                                    </form>

                                    <br><br><br><br>

                                </div>
                            </div>
                        </div>
                        <!-- End Reports -->
                    </div>
                </div>
            </div>
        </section>
    </main>

    <jsp:include page="UserFooter.jsp"></jsp:include>
    <jsp:include page="UserJs.jsp"></jsp:include>

</body>
</html>
