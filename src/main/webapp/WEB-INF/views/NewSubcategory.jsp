<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>New Subcategory</title>
    <jsp:include page="AdminCss.jsp"></jsp:include>
</head>
<body>
    <h2>New Subcategory</h2>
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

        <!-- Section -->
        <section class="section dashboard">
            <div class="row" style="min-height: 500px;">
                <div class="col-lg-12">
                    <div class="row">
                        <!-- Card -->
                        <div class="col-12">
                            <div class="card">
                                <div class="card-body">
                                    <h5 class="card-title">Reports <span>/ Today</span></h5>

                                    <!-- Subcategory Form -->
                                    <form action="savesubcategory" method="post" class="p-3">
                                        <div class="mb-3">
                                            <label for="subtitle" class="form-label">Subcategory Title</label>
                                            <input type="text" name="subtitle" id="subtitle" class="form-control" required>
                                        </div>

                                        <div class="mb-3">
                                            <label for="categoryId" class="form-label">Select Category</label>
                                            <select name="categoryId" id="categoryId" class="form-select" required>
                                                <option value="" disabled selected>Select Category</option>
                                                <c:forEach items="${allCategory}" var="c">
                                                    <option value="${c.categoryId}">${c.title}</option>
                                                </c:forEach>
                                            </select>
                                        </div>

                                        <button type="submit" class="btn btn-primary w-100">Save Subcategory</button>
                                    </form>

                                    <br><br><br><br>
                                </div>
                            </div>
                        </div>
                        <!-- End Card -->
                    </div>
                </div>
            </div>
        </section>
    </main>

    <jsp:include page="AdminFooter.jsp"></jsp:include>
    <jsp:include page="AdminJs.jsp"></jsp:include>
</body>
</html>
