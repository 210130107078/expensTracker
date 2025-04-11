<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="utf-8">
  <meta content="width=device-width, initial-scale=1.0" name="viewport">
  <title>Home</title>

  <!-- Bootstrap and Icon Fonts -->
  <link href="assets/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
  <link href="assets/vendor/bootstrap-icons/bootstrap-icons.css" rel="stylesheet">
  <link href="assets/css/style.css" rel="stylesheet">

  <style>
    body {
      background-color: #f8f9fc;
      font-family: 'Poppins', sans-serif;
    }
    .hero {
      background: #0d6efd;
      color: #fff;
      padding: 80px 20px;
      text-align: center;
      border-radius: 0 0 40px 40px;
    }
    .hero h1 {
      font-size: 3rem;
      font-weight: bold;
    }
    .hero p {
      font-size: 1.2rem;
    }
    .section {
      padding: 60px 20px;
    }
    .card {
      border: none;
      box-shadow: 0 0 15px rgba(0, 0, 0, 0.05);
    }
  </style>
</head>

<body>

  <!-- Navbar -->
  <nav class="navbar navbar-expand-lg navbar-light bg-white shadow-sm">
    <div class="container">
      <a class="navbar-brand text-primary fw-bold" href="#">ExpenseTracker</a>
      <div class="d-flex">
        <a href="login" class="btn btn-outline-primary me-2">Login</a>
        <a href="signup" class="btn btn-primary">Register</a>
      </div>
    </div>
  </nav>

  <!-- Hero Section -->
  <div class="hero">
    <h1>Welcome to Expense Tracker</h1>
    <p>Track your income and expenses easily. Stay in control of your finances.</p>
    <a href="signup" class="btn btn-light btn-lg mt-3">Get Started</a>
  </div>

  <!-- Features Section -->
  <section class="section">
    <div class="container text-center">
      <h2 class="text-primary mb-4">Features</h2>
      <div class="row">
        <div class="col-md-4 mb-4">
          <div class="card p-4">
            <i class="bi bi-wallet2 fs-1 text-primary mb-3"></i>
            <h5>Track Expenses</h5>
            <p>Keep a record of all your daily expenses with ease and clarity.</p>
          </div>
        </div>
        <div class="col-md-4 mb-4">
          <div class="card p-4">
            <i class="bi bi-graph-up-arrow fs-1 text-primary mb-3"></i>
            <h5>Analyze Reports</h5>
            <p>Understand your spending patterns with detailed reports and charts.</p>
          </div>
        </div>
        <div class="col-md-4 mb-4">
          <div class="card p-4">
            <i class="bi bi-shield-check fs-1 text-primary mb-3"></i>
            <h5>Secure Data</h5>
            <p>Your financial data is encrypted and stored safely with full privacy.</p>
          </div>
        </div>
      </div>
    </div>
  </section>

  <!-- Footer -->
  <footer class="bg-white text-center py-4 shadow-sm mt-4">
    <p class="mb-0 text-muted">© 2025 ExpenseTracker. All Rights Reserved.</p>
  </footer>

  <!-- Bootstrap JS -->
  <script src="assets/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

</body>
</html>
