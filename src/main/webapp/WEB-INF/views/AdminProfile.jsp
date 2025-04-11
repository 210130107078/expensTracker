\<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="utf-8">
  <title>My Profile</title>
  <meta content="width=device-width, initial-scale=1.0" name="viewport">

  <!-- CSS Files -->
  <link href="assets/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
  <link href="assets/vendor/bootstrap-icons/bootstrap-icons.css" rel="stylesheet">
  <link href="assets/vendor/boxicons/css/boxicons.min.css" rel="stylesheet">
  <link href="assets/css/style.css" rel="stylesheet">
</head>

<body>
<jsp:include page="AdminHeader.jsp"/>
<jsp:include page="AdminSidebar.jsp"/>

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
      <!-- Profile Image Card -->
      <div class="col-xl-4">
        <div class="card">
          <div class="card-body profile-card pt-4 d-flex flex-column align-items-center">
            <img src="${user.profilePicPath}" alt="Profile" class="rounded-circle" style="width: 150px; height: 150px;">
            <h2>${user.firstName} ${user.lastName}</h2>
            <h3>${user.email}</h3>
          </div>
        </div>
      </div>

      <!-- Tabs: Overview / Edit -->
      <div class="col-xl-8">
        <div class="card">
          <div class="card-body pt-3">
            <ul class="nav nav-tabs nav-tabs-bordered">
              <li class="nav-item">
                <button class="nav-link active" data-bs-toggle="tab" data-bs-target="#profile-overview">Overview</button>
              </li>
              <li class="nav-item">
                <button class="nav-link" data-bs-toggle="tab" data-bs-target="#profile-edit">Edit Profile</button>
              </li>
            </ul>

            <div class="tab-content pt-2">
              <!-- Overview Tab -->
              <div class="tab-pane fade show active profile-overview" id="profile-overview">
                <h5 class="card-title">Profile Details</h5>

                <div class="row">
                  <div class="col-lg-3 col-md-4 label">Full Name</div>
                  <div class="col-lg-9 col-md-8">${user.firstName} ${user.lastName}</div>
                </div>

                <div class="row">
                  <div class="col-lg-3 col-md-4 label">Email</div>
                  <div class="col-lg-9 col-md-8">${user.email}</div>
                </div>

                <div class="row">
                  <div class="col-lg-3 col-md-4 label">Mobile</div>
                  <div class="col-lg-9 col-md-8">${user.contactNum}</div>
                </div>

                <div class="row">
                  <div class="col-lg-3 col-md-4 label">City</div>
                  <div class="col-lg-9 col-md-8">${user.city}</div>
                </div>

                <div class="row">
                  <div class="col-lg-3 col-md-4 label">Gender</div>
                  <div class="col-lg-9 col-md-8">${user.gender}</div>
                </div>

                <div class="row">
                  <div class="col-lg-3 col-md-4 label">Born Year</div>
                  <div class="col-lg-9 col-md-8">${user.bornYear}</div>
                </div>
              </div>

              <!-- Edit Tab -->
              <div class="tab-pane fade profile-edit pt-3" id="profile-edit">
                <form action="updateprofile" method="post" enctype="multipart/form-data">
                
                <input type="hidden" name="userId" value="${user.userId }">

                  <div class="row mb-3">
                    <label class="col-md-4 col-lg-3 col-form-label">Profile Image</label>
                    <div class="col-md-8 col-lg-9">
                      <input class="form-control" type="file" name="profilePic">
                    </div>
                  </div>

                  <div class="row mb-3">
                    <label class="col-md-4 col-lg-3 col-form-label">First Name</label>
                    <div class="col-md-8 col-lg-9">
                      <input name="firstName" type="text" class="form-control" value="${user.firstName}">
                    </div>
                  </div>

                  <div class="row mb-3">
                    <label class="col-md-4 col-lg-3 col-form-label">Last Name</label>
                    <div class="col-md-8 col-lg-9">
                      <input name="lastName" type="text" class="form-control" value="${user.lastName}">
                    </div>
                  </div>

                  <div class="row mb-3">
                    <label class="col-md-4 col-lg-3 col-form-label">Email</label>
                    <div class="col-md-8 col-lg-9">
                      <input name="email" type="email" class="form-control" value="${user.email}">
                    </div>
                  </div>

                  <div class="row mb-3">
                    <label class="col-md-4 col-lg-3 col-form-label">Mobile</label>
                    <div class="col-md-8 col-lg-9">
                      <input name="contactNum" type="text" class="form-control" value="${user.contactNum}">
                    </div>
                  </div>

                  <div class="row mb-3">
                    <label class="col-md-4 col-lg-3 col-form-label">City</label>
                    <div class="col-md-8 col-lg-9">
                      <input name="city" type="text" class="form-control" value="${user.city}">
                    </div>
                  </div>

                  <div class="row mb-3">
                    <label class="col-md-4 col-lg-3 col-form-label">Gender</label>
                    <div class="col-md-8 col-lg-9">
                      <select name="gender" class="form-control">
                        <option value="male" ${user.gender == 'male' ? 'selected' : ''}>Male</option>
                        <option value="female" ${user.gender == 'female' ? 'selected' : ''}>Female</option>
                      </select>
                    </div>
                  </div>

                  <div class="row mb-3">
                    <label class="col-md-4 col-lg-3 col-form-label">Born Year</label>
                    <div class="col-md-8 col-lg-9">
                      <input name="bornYear" type="text" class="form-control" value="${user.bornYear}">
                    </div>
                  </div>

                  <div class="text-center">
                    <button type="submit" class="btn btn-primary" method="post">Update Profile</button>
                  </div>
                </form>
              </div>
            </div>

          </div>
        </div>
      </div>
    </div>
  </section>
</main>

<jsp:include page="AdminFooter.jsp"/>

<!-- JS Files -->
<script src="assets/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
<script src="assets/js/main.js"></script>

</body>
</html>
