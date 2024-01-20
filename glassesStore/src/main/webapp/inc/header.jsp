<%@page import="model.Users"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>header glasses</title>
<link href="./assets/css/bootstrap.min.css" rel="stylesheet">
<!-- <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css" rel="stylesheet"> -->
<!-- <link href="./assets/css/tiny-slider.css" rel="stylesheet"> -->
<!-- <link href="./assets/css/style.css" rel="stylesheet"> -->
<script src="./assets/js/bootstrap.bundle.min.js"></script>
</head>
<body>

		<!-- Start Header/Navigation -->
		<nav class="custom-navbar navbar navbar navbar-expand-md" arial-label="Furni navigation bar">

			<div class="container">
				<a class="navbar-brand" href="index.html"><img alt="" src="./assets/icon/logo1.png"></a>

				<button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarsFurni" aria-controls="navbarsFurni" aria-expanded="false" aria-label="Toggle navigation">
					<span class="navbar-toggler-icon"></span>
				</button>

				<div class="collapse navbar-collapse" id="navbarsFurni">
					
					<ul class="custom-navbar-nav navbar-nav ms-auto mb-2 mb-md-0">
						<li class="nav-item active">
							<a class="nav-link" href="home">Trang Chủ</a>
						</li>
						<li class="nav-item dropdown">
							<a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">Sản Phẩm</a>
							
							<ul class="dropdown-menu bg-dark" >
								<c:forEach items="${lstCategory}" var="category">
									<li><a class="dropdown-item" href="sanpham?id_category=${category.id}">
										${category.tenLoaiSanPham}
									</a></li>
								</c:forEach>
								
							
							</ul>
						</li>
						<li><a class="nav-link" href="services.html">Giới Thiệu</a></li>
						<li><a class="nav-link" href="blog.html">Liên Hệ</a></li>
					</ul>

					<ul class="custom-navbar-cta navbar-nav mb-3 mb-md-0 ms-5 ">
						<li  class="nav-item dropdown">
							<a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false"><img src="./assets/icon/user.svg"></a>
							<ul class="dropdown-menu " >
								<c:choose>
								    <c:when test="${empty sessionScope.user}">
								        <li><a class="dropdown-item" href="./views/DangNhap.jsp">Đăng nhập </a></li>
								    </c:when>
								    <c:otherwise>
								        <li><a class="dropdown-item"><c:out value="${sessionScope.user.tenHienThi}" /></a></li>
								        <li><a class="dropdown-item" href="logout">Đăng Xuất </a></li>
								    </c:otherwise>
								</c:choose>
								
								
								
								
							</ul>
						</li>
						
						<li><a class="nav-link" href="cart"><img src="./assets/icon/cart.svg"><i class="text-dark">${listCart.size()}</i></a></li>
					</ul>
				</div>
			</div>
				
		</nav>
		<!-- End Header/Navigation -->

		<!-- Start Hero Section -->
		<div class="hero">
			<div class="container">
				<div class="row justify-content-between">
					<div class="col-lg-5">
						<div class="intro-excerpt">
							<h1>Modern Interior <span clsas="d-block">Design Studio</span></h1>
							<p class="mb-4">Donec vitae odio quis nisl dapibus malesuada. Nullam ac aliquet velit. Aliquam vulputate velit imperdiet dolor tempor tristique.</p>
							<p><a href="" class="btn btn-secondary me-2">Shop Now</a><a href="#" class="btn btn-white-outline">Explore</a></p>
						</div>
					</div>
					<div class="col-lg-7">
						<div class="hero-img-wrap">
							<img src="./assets/icon/snapedit_1703342709594.png" class="img-fluid">
						</div>
					</div>
				</div>
			</div>
		</div>
		<!-- End Hero Section -->
<script src="./assets/js/bootstrap.bundle.min.js"></script>

</body>
</html>