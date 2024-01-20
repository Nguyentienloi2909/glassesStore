<%@page import="model.Category"%>
<%@page import="model.Products"%>
<%@page import="java.util.List"%>
<%@ page import="java.text.DecimalFormat"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link href="./assets/css/bootstrap.min.css" rel="stylesheet">
<link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css" rel="stylesheet">
<link href="./assets/css/tiny-slider.css" rel="stylesheet">
<link href="./assets/css/style.css" rel="stylesheet">
</head>
<body>

	<%@include file="../inc/header.jsp" %>
	<div class="container mt-5">
	    <div class="row">
	        <div class="col-sm-3">
	            <div class="card bg-light mb-3">
	                <div class="card-header bg-primary text-white text-uppercase"><i class="fa fa-list"></i> Categories</div>
	                <ul class="list-group category_block">
	                    <c:forEach items="${lstCategory}" var="category">
	                        <li class="list-group-item">${category.tenLoaiSanPham}</li>
	                    </c:forEach>
	                </ul>
	            </div>
	            <div class="card bg-light mb-3">
	                <div class="card-header bg-success text-white text-uppercase">Last product</div>
	                <div class="card-body">
	                    <img class="img-fluid" src="./assets/image/Kính Mát Nam GUCCI GG1301S 002.png" alt="Last Product Image">
	                    
	                </div>
	            </div>
	        </div>
	
	        <div class="col-sm-9">
	        
				<form action="search" method="get">
					<div class="input-group">
					  <input type="search" class="form-control rounded " name  ="search" placeholder="search" aria-label="Search" aria-describedby="search-addon" />
					  <button type="submit" class="btn btn-outline-primary" data-mdb-ripple-init>search</button>
					</div>
				</form>
				
	            <div class="row">
		            <c:if test="${lstProducts != null}">
		            	<c:forEach items="${lstProducts}" var="product">
		                    <div class="col-12 col-md-6 col-lg-4 mt-5">
		                        <div class="card shadow">
						            <img src="./assets/image/${product.anhChinh}" alt="watch large"> 
						            <div class="card-footer bg-gray-200 border-top border-gray-300 p-4">
						                <a href="#"   style="text-decoration: none;"class="h5">${product.tenSanPham}</a>
						           		<div class="d-flex mt-2">
							                    <span class="badge bg-primary me-2">Giảm: ${product.khuyenMai}%</span>
							           			Giá Gốc<span class="text-decoration-line-through">: ${product.giaGoc}$</span>
							             </div>
						                <div class="d-flex justify-content-between align-items-center mt-3">
						                    <span class="h6 mb-0 text-gray">${product.giaGoc}$</span> 
						                    <a class="" href="
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
	    </div>
	</div>

	
	<%@include file="../inc/footer.jsp" %>
	
	<script src="./assets/js/bootstrap.bundle.min.js"></script>
	<script src="./assets/js/tiny-slider.js"></script>
	<script src="./assets/js/custom.js"></script>

</body>
</html>