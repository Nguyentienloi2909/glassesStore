<%@page import="model.LoaiSanPham"%>
<%@page import="model.SanPham"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link href="../assets/css/bootstrap.min.css" rel="stylesheet">
<link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css" rel="stylesheet">
<link href="../assets/css/tiny-slider.css" rel="stylesheet">
<link href="../assets/css/style.css" rel="stylesheet">
</head>

<body>
	<div class="col-sm-10 float-end me-2">

		
			<div class="h-100 py-5">
				<div
					class="row d-flex justify-content-center align-items-center h-100 ">
					<div class="col-12 ">

						<div
							class="d-flex justify-content-between align-items-center mb-4">
							<h3 class="fw-normal mb-0 text-black">Sản Phẩm</h3>
							<form action="search" method="get">
								<div class="input-group  me-5">
									<input type="search" class="form-control rounded "
										name="search" placeholder="search" aria-label="Search"
										aria-describedby="search-addon" />
									<button type="submit" class="btn btn-outline-primary"
										data-mdb-ripple-init>search</button>
								</div>
							</form>
							<a type="button" href="/glassesStore/AdminAddProduct" class="btn btn-outline-primary bg-success text-light" 
										data-mdb-ripple-init>+Thêm</a>
						</div>
					<c:if test="${listProducts != null}">
						<c:forEach items="${listProducts}" var="product">
							<div class="card rounded-3 mb-4">
								<div class="card-body p-4 mt-2">
									<div
										class="row d-flex justify-content-between align-items-center">
										<div class="col-md-2 col-lg-2 col-xl-2">
											<img src="./assets/image/${product.anhChinh}"
												class="img-fluid rounded-3" alt="Cotton T-shirt">
										</div>
										<div class="col-md-3 col-lg-3 col-xl-3">
											<p class="lead fw-normal mb-2">${product.tenSanPham }</p>
											<p>
												<span class="text-muted">Số Lượng: </span>${product.soLuong}
												<br> <span class="text-muted">khuyến mãi: </span>${product.khuyenMai}%
											</p>
										</div>
										<div class="col-md-3 col-lg-3 col-xl-2 d-flex">
											<h5 class="mb-0">${product.giaGoc}</h5>
										</div>

										<div class="col-md-3 col-lg-2 col-xl-2 offset-lg-1">
											<a href="/glassesStore/AdminAddProduct?id=${product.id}"> <i
												class="fas fa-cog fa-lg"></i>
											</a>

										</div>
										<div class="col-md-1 col-lg-2 col-xl-1 text-end">
											<a href="AdminDeleteProduct?id=${product.id}"
												class="text-danger"><i class="fas fa-trash fa-lg"></i></a>
										</div>
									</div>


								</div>
							</div>

						</c:forEach>


					</c:if>


				</div>
				</div>
			</div>
		</div>
	

</body>
</html>