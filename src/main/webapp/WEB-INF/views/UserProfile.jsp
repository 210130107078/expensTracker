<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="utf-8">
  <title>My Profile</title>
  <meta content="width=device-width, initial-scale=1.0" name="viewport">
  
  <!-- NiceAdmin CSS -->
  <link href="assets/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
  <link href="assets/vendor/bootstrap-icons/bootstrap-icons.css" rel="stylesheet">
  <link href="assets/vendor/boxicons/css/boxicons.min.css" rel="stylesheet">
  <link href="assets/css/style.css" rel="stylesheet">
</head>
<body>

<jsp:include page="UserHeader.jsp"/>
<jsp:include page="UserSidebar.jsp"/>

<main id="main" class="main">
  <div class="pagetitle">
    <h1>My Profile</h1>
    <nav>
      <ol class="breadcrumb">
        <li class="breadcrumb-item"><a href="home">Home</a></li>
        <li class="breadcrumb-item active">Profile</li>
      </ol>
    </nav>
  </div>

  <section class="section profile">
    <div class="row">
      <div class="col-xl-4">
        <div class="card">
          <div class="card-body profile-card pt-4 d-flex flex-column align-items-center">
            <img src="${user.profilePicPath}" alt="Profile" class="rounded-circle" style="width: 100px; height: 200px;">
            <h2>${user.firstName} ${user.lastName}</h2>
            <h3>${user.email}</h3>
          </div>
        </div>
      </div>

      <div class="col-xl-8">
        <div class="card">
          <div class="card-body pt-3">
            <h5 class="card-title">Profile Details</h5>

            <div class="row mb-3">
              <label class="col-md-4 col-lg-3 col-form-label">Full Name</label>
              <div class="col-md-8 col-lg-9">
                <input type="text" class="form-control" value="${user.firstName} ${user.lastName}" readonly>
              </div>
            </div>

            <div class="row mb-3">
              <label class="col-md-4 col-lg-3 col-form-label">Email</label>
              <div class="col-md-8 col-lg-9">
                <input type="email" class="form-control" value="${user.email}" readonly>
              </div>
            </div>

            <div class="row mb-3">
              <label class="col-md-4 col-lg-3 col-form-label">Mobile</label>
              <div class="col-md-8 col-lg-9">
                <input type="text" class="form-control" value="${user.contactNum}" readonly>
              </div>
            </div>

            <div class="row mb-3">
              <label class="col-md-4 col-lg-3 col-form-label">City</label>
              <div class="col-md-8 col-lg-9">
                <input type="text" class="form-control" value="${user.city}" readonly>
              </div>
            </div>

            <div class="row mb-3">
              <label class="col-md-4 col-lg-3 col-form-label">Gender</label>
              <div class="col-md-8 col-lg-9">
                <input type="text" class="form-control" value="${user.gender}" readonly>
              </div>
            </div>

            <div class="row mb-3">
              <label class="col-md-4 col-lg-3 col-form-label">Born Year</label>
              <div class="col-md-8 col-lg-9">
                <input type="text" class="form-control" value="${user.bornYear}" readonly>
              </div>
            </div>

          </div>
        </div>
      </div>
    </div>
  </section>
</main>

<jsp:include page="UserFooter.jsp"/>

<!-- Vendor JS -->
<script src="assets/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
<script src="assets/js/main.js"></script>

</body>
</html>
