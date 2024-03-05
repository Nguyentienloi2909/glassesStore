<%@page import="java.util.List"%>
<%@page import="model.SanPham"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="./assets/css/bootstrap.min.css" rel="stylesheet">
<!-- <script src="./assets/js/bootstrap.bundle.min.js"></script> -->
<!-- <link href="./assets/css/style.css" rel="stylesheet"> -->
</head>
<body>
	<div class="container">
	
		<div class="container text-center mt-4">
		    <h2 class="mb-0">
		        Sản Phẩm Giảm Giá <i class="fas fa-shopping-cart"></i>
		    </h2>
		</div>

		<div class="row">
			<c:if test="${lstProducts != null}">
				<c:forEach items="${lstProducts}" var="product">
					<c:if test="${product.khuyenMai > 0}">
						<div class="col-12 col-md-3 mt-5">
							<div class="card shadow">
								<img src="./assets/image/${product.anhChinh}" alt="watch large">
								<div
									class="card-footer bg-gray-200 border-top border-gray-300 p-4">
									<a href="#" style="text-decoration: none;" class="h5">${product.tenSanPham}</a>
									<div class="d-flex mt-2">
										<span class="badge bg-primary me-2">Giảm:
											${product.khuyenMai}%</span> Giá Gốc<span
											class="text-decoration-line-through">:
											${product.giaGoc}$</span>
									</div>
									<div
										class="d-flex justify-content-between align-items-center mt-3">
										<span class="h6 mb-0 text-gray">${product.giaGoc - product.giaGoc*product.khuyenMai/100}$</span>
										<a class=""
											href="
					                    <c:if test = "${user==null}">
											./views/DangNhap.jsp
										</c:if>
										
										<c:if test = "${user!=null}">
											home?id_product=${product.id}
										</c:if>">												
											<button class = "rounded-pill bg-success" name="button" type="button">Add to cart</button>
										</a>
									</div>
								</div>
							</div>
						</div>
					</c:if>

				</c:forEach>
			</c:if>
		</div>

		<div class="container text-center mt-4">
			<h2 class="mb-0">
				Dành mục sản phẩm <i class="fas fa-shopping-cart"></i>
			</h2>
		</div>

		<div class="row">
			<c:if test="${lstProducts != null}">
				<c:forEach items="${lstProducts}" var="product">
					<div class="col-12 col-md-3 mt-5">
						<div class="card shadow">
							<img src="./assets/image/${product.anhChinh}" alt="watch large">
							<div
								class="card-footer bg-gray-200 border-top border-gray-300 p-4">
								<a href="#" style="text-decoration: none;" class="h5">${product.tenSanPham}</a>
								<div class="d-flex mt-2">
									<span class="badge bg-primary me-2">Giảm:
										${product.khuyenMai}%</span> Giá Gốc<span
										class="text-decoration-line-through">:
										${product.giaGoc}$</span>
								</div>
								<div
									class="d-flex justify-content-between align-items-center mt-3">
									<span class="h6 mb-0 text-gray">${product.giaGoc}$</span> <a
										class=""
										href="
									<c:if test = "${user==null}">
										./views/DangNhap.jsp
									</c:if>
									
									<c:if test = "${user!=null}">
										home?id_product=${product.id}
									</c:if>
			                    ">
										<button class = "rounded-pill bg-success" name="button" type="button">Add to cart</button>
									</a>
								</div>
							</div>
						</div>
					</div>
				</c:forEach>
			</c:if>
		</div>
	</div>
</body>
</html>