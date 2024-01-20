<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<link href="../assets/css/bootstrap.min.css" rel="stylesheet">
<link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css" rel="stylesheet">
<link href="../assets/css/tiny-slider.css" rel="stylesheet">
<link href="../assets/css/style.css" rel="stylesheet">
<body>
	<div class="container mt-5">
		<a href="/glassesStore/home"><i class="fa fa-arrow-left" aria-hidden="true"></i></a>
		<section class="vh-100">
		  <div class="container-fluid h-custom">
		    <div class="row d-flex justify-content-center align-items-center h-100">
		      <div class="col-md-9 col-lg-6 col-xl-5">
		        <img src="https://mdbcdn.b-cdn.net/img/Photos/new-templates/bootstrap-login-form/draw2.webp"
		          class="img-fluid" alt="Sample image">
		      </div>
		      <div class="col-md-8 col-lg-6 col-xl-4 offset-xl-1">
		        <form action="/glassesStore/login" method="post">
		          <div class="d-flex flex-row align-items-center justify-content-center justify-content-lg-start">
		            <p class="lead fw-normal mb-0 me-3">Sign in with</p>
		            <button type="button" class="btn btn-primary btn-floating mx-1">
		              <i class="fab fa-facebook-f"></i>
		            </button>
		
		            <button type="button" class="btn btn-primary btn-floating mx-1">
		              <i class="fab fa-twitter"></i>
		            </button>
		
		            <button type="button" class="btn btn-primary btn-floating mx-1">
		              <i class="fab fa-linkedin-in"></i>
		            </button>
		          </div>
		
		          <div class="divider d-flex align-items-center my-4">
		            <p class="text-center fw-bold mx-3 mb-0">Or</p>
		          </div>
					
					<p class="text-danger">${mess}</p>
		          <!-- Email input -->
		          <div class="form-outline mb-4">
		            <input type="text" id="user-name" class="form-control form-control-lg"
		              placeholder="Nhập user-name hoặc email" name="user-name" />
		            <label class="form-label" for="form3Example3">user-name</label>
		          </div>
		
		          <!-- Password input -->
		          <div class="form-outline mb-3">
		            <input type="password" id="user-password" class="form-control form-control-lg"
		              placeholder="Enter password" name="user-password" />
		            <label class="form-label" for="form3Example4">Password</label>
		          </div>
		
		          <div class="d-flex justify-content-between align-items-center">
		            <!-- Checkbox -->
		            <div class="form-check mb-0">
		              <input class="form-check-input me-2" type="checkbox" value="" id="form2Example3" />
		              <label class="form-check-label" for="form2Example3">
		                Remember me
		              </label>
		            </div>
		            <a href="#!" class="text-body">Forgot password?</a>
		          </div>
		
		          <div class="text-center text-lg-start mt-4 pt-2">
		            <button type="submit" class="btn btn-primary btn-lg"
		              style="padding-left: 2.5rem; padding-right: 2.5rem;">Login</button>
		            <p class="small fw-bold mt-2 pt-1 mb-0">Don't have an account? <a href="/glassesStore/views/DangKy.jsp"
		                class="link-danger">Register</a></p>
		          </div>
		
		        </form>
		      </div>
		    </div>
		  </div>
		  <div
		    class="d-flex flex-column flex-md-row text-center text-md-start justify-content-between py-4 px-4 px-xl-5 bg-primary">
		    <!-- Copyright -->
		    <div class="text-white mb-3 mb-md-0">
		      Copyright © 2020. All rights reserved.
		    </div>
		    <!-- Copyright -->
		
		    <!-- Right -->
		    <div>
		      <a href="#!" class="text-white me-4">
		        <i class="fab fa-facebook-f"></i>
		      </a>
		      <a href="#!" class="text-white me-4">
		        <i class="fab fa-twitter"></i>
		      </a>
		      <a href="#!" class="text-white me-4">
		        <i class="fab fa-google"></i>
		      </a>
		      <a href="#!" class="text-white">
		        <i class="fab fa-linkedin-in"></i>
		      </a>
		    </div>
		    <!-- Right -->
		  </div>
		
		</section> 
	</div>
	<script src="../assets/js/bootstrap.bundle.min.js"></script>
	<script src="../assets/js/tiny-slider.js"></script>
	<script src="../assets/js/custom.js"></script>
</body>
</html>