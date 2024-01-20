<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.Products"%>
<%@page import="model.Voucher"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link href="./assets/css/bootstrap.min.css" rel="stylesheet">
<link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css" rel="stylesheet"> 
<link href="./assets/css/tiny-slider.css" rel="stylesheet">
<link href="./assets/css/style.css" rel="stylesheet">
<style type="text/css">
	body{margin-top:20px;}
	select.form-control:not([size]):not([multiple]) {
	    height: 44px;
	}
	select.form-control {
	    padding-right: 38px;
	    background-position: center right 17px;
	    background-image: url(data:image/svg+xml;utf8;base64,PD94bWwgdmVyc2lvbj0iMS4wIiBlbmNvZGluZz0iaXNv…9nPgo8Zz4KPC9nPgo8Zz4KPC9nPgo8Zz4KPC9nPgo8Zz4KPC9nPgo8Zz4KPC9nPgo8L3N2Zz4K);
	    background-repeat: no-repeat;
	    background-size: 9px 9px;
	}
	.form-control:not(textarea) {
	    height: 44px;
	}
	.form-control {
	    padding: 0 18px 3px;
	    border: 1px solid #dbe2e8;
	    border-radius: 22px;
	    background-color: #fff;
	    color: #606975;
	    font-family: "Maven Pro",Helvetica,Arial,sans-serif;
	    font-size: 14px;
	    -webkit-appearance: none;
	    -moz-appearance: none;
	    appearance: none;
	}
	
	.shopping-cart,
	.wishlist-table,
	.order-table {
	    margin-bottom: 20px
	}
	
	.shopping-cart .table,
	.wishlist-table .table,
	.order-table .table {
	    margin-bottom: 0
	}
	
	.shopping-cart .btn,
	.wishlist-table .btn,
	.order-table .btn {
	    margin: 0
	}
	
	.shopping-cart>table>thead>tr>th,
	.shopping-cart>table>thead>tr>td,
	.shopping-cart>table>tbody>tr>th,
	.shopping-cart>table>tbody>tr>td,
	.wishlist-table>table>thead>tr>th,
	.wishlist-table>table>thead>tr>td,
	.wishlist-table>table>tbody>tr>th,
	.wishlist-table>table>tbody>tr>td,
	.order-table>table>thead>tr>th,
	.order-table>table>thead>tr>td,
	.order-table>table>tbody>tr>th,
	.order-table>table>tbody>tr>td {
	    vertical-align: middle !important
	}
	
	.shopping-cart>table thead th,
	.wishlist-table>table thead th,
	.order-table>table thead th {
	    padding-top: 17px;
	    padding-bottom: 17px;
	    border-width: 1px
	}
	
	.shopping-cart .remove-from-cart,
	.wishlist-table .remove-from-cart,
	.order-table .remove-from-cart {
	    display: inline-block;
	    color: #ff5252;
	    font-size: 18px;
	    line-height: 1;
	    text-decoration: none
	}
	
	.shopping-cart .count-input,
	.wishlist-table .count-input,
	.order-table .count-input {
	    display: inline-block;
	    width: 100%;
	    width: 86px
	}
	
	.shopping-cart .product-item,
	.wishlist-table .product-item,
	.order-table .product-item {
	    display: table;
	    width: 100%;
	    min-width: 150px;
	    margin-top: 5px;
	    margin-bottom: 3px
	}
	
	.shopping-cart .product-item .product-thumb,
	.shopping-cart .product-item .product-info,
	.wishlist-table .product-item .product-thumb,
	.wishlist-table .product-item .product-info,
	.order-table .product-item .product-thumb,
	.order-table .product-item .product-info {
	    display: table-cell;
	    vertical-align: top
	}
	
	.shopping-cart .product-item .product-thumb,
	.wishlist-table .product-item .product-thumb,
	.order-table .product-item .product-thumb {
	    width: 130px;
	    padding-right: 20px
	}
	
	.shopping-cart .product-item .product-thumb>img,
	.wishlist-table .product-item .product-thumb>img,
	.order-table .product-item .product-thumb>img {
	    display: block;
	    width: 100%
	}
	
	@media screen and (max-width: 860px) {
	    .shopping-cart .product-item .product-thumb,
	    .wishlist-table .product-item .product-thumb,
	    .order-table .product-item .product-thumb {
	        display: none
	    }
	}
	
	.shopping-cart .product-item .product-info span,
	.wishlist-table .product-item .product-info span,
	.order-table .product-item .product-info span {
	    display: block;
	    font-size: 13px
	}
	
	.shopping-cart .product-item .product-info span>em,
	.wishlist-table .product-item .product-info span>em,
	.order-table .product-item .product-info span>em {
	    font-weight: 500;
	    font-style: normal
	}
	
	.shopping-cart .product-item .product-title,
	.wishlist-table .product-item .product-title,
	.order-table .product-item .product-title {
	    margin-bottom: 6px;
	    padding-top: 5px;
	    font-size: 16px;
	    font-weight: 500
	}
	
	.shopping-cart .product-item .product-title>a,
	.wishlist-table .product-item .product-title>a,
	.order-table .product-item .product-title>a {
	    transition: color .3s;
	    color: #374250;
	    line-height: 1.5;
	    text-decoration: none
	}
	
	.shopping-cart .product-item .product-title>a:hover,
	.wishlist-table .product-item .product-title>a:hover,
	.order-table .product-item .product-title>a:hover {
	    color: #0da9ef
	}
	
	.shopping-cart .product-item .product-title small,
	.wishlist-table .product-item .product-title small,
	.order-table .product-item .product-title small {
	    display: inline;
	    margin-left: 6px;
	    font-weight: 500
	}
	
	.wishlist-table .product-item .product-thumb {
	    display: table-cell !important
	}
	
	@media screen and (max-width: 576px) {
	    .wishlist-table .product-item .product-thumb {
	        display: none !important
	    }
	}
	
	.shopping-cart-footer {
	    display: table;
	    width: 100%;
	    padding: 10px 0;
	    border-top: 1px solid #e1e7ec
	}
	
	.shopping-cart-footer>.column {
	    display: table-cell;
	    padding: 5px 0;
	    vertical-align: middle
	}
	
	.shopping-cart-footer>.column:last-child {
	    text-align: right
	}
	
	.shopping-cart-footer>.column:last-child .btn {
	    margin-right: 0;
	    margin-left: 15px
	}
	
	@media (max-width: 768px) {
	    .shopping-cart-footer>.column {
	        display: block;
	        width: 100%
	    }
	    .shopping-cart-footer>.column:last-child {
	        text-align: center
	    }
	    .shopping-cart-footer>.column .btn {
	        width: 100%;
	        margin: 12px 0 !important
	    }
	}
	
	.coupon-form .form-control {
	    display: inline-block;
	    width: 100%;
	    max-width: 235px;
	    margin-right: 12px;
	}
	
	.form-control-sm:not(textarea) {
	    height: 36px;
	}
</style>
</head>
<body>
	

	<div class="container padding-bottom-3x mb-1">
		<!-- Alert-->
		<div class="alert alert-info alert-dismissible fade show text-center"
			style="margin-bottom: 30px;">
			<span class="alert-close" data-dismiss="alert"></span><img
				class="d-inline align-center"
				src="data:image/svg+xml;utf8;base64,PD94bWwgdmVyc2lvbj0iMS4wIiBlbmNvZGluZz0iaXNvLTg4NTktMSI/Pgo8IS0tIEdlbmVyYXRvcjogQWRvYmUgSWxsdXN0cmF0b3IgMTkuMC4wLCBTVkcgRXhwb3J0IFBsdWctSW4gLiBTVkcgVmVyc2lvbjogNi4wMCBCdWlsZCAwKSAgLS0+CjxzdmcgeG1sbnM9Imh0dHA6Ly93d3cudzMub3JnLzIwMDAvc3ZnIiB4bWxuczp4bGluaz0iaHR0cDovL3d3dy53My5vcmcvMTk5OS94bGluayIgdmVyc2lvbj0iMS4xIiBpZD0iTGF5ZXJfMSIgeD0iMHB4IiB5PSIwcHgiIHZpZXdCb3g9IjAgMCA1MTIuMDAzIDUxMi4wMDMiIHN0eWxlPSJlbmFibGUtYmFja2dyb3VuZDpuZXcgMCAwIDUxMi4wMDMgNTEyLjAwMzsiIHhtbDpzcGFjZT0icHJlc2VydmUiIHdpZHRoPSIxNnB4IiBoZWlnaHQ9IjE2cHgiPgo8Zz4KCTxnPgoJCTxnPgoJCQk8cGF0aCBkPSJNMjU2LjAwMSw2NGMtNzAuNTkyLDAtMTI4LDU3LjQwOC0xMjgsMTI4czU3LjQwOCwxMjgsMTI4LDEyOHMxMjgtNTcuNDA4LDEyOC0xMjhTMzI2LjU5Myw2NCwyNTYuMDAxLDY0eiAgICAgIE0yNTYuMDAxLDI5OC42NjdjLTU4LjgxNiwwLTEwNi42NjctNDcuODUxLTEwNi42NjctMTA2LjY2N1MxOTcuMTg1LDg1LjMzMywyNTYuMDAxLDg1LjMzM1MzNjIuNjY4LDEzMy4xODQsMzYyLjY2OCwxOTIgICAgIFMzMTQuODE3LDI5OC42NjcsMjU2LjAwMSwyOTguNjY3eiIgZmlsbD0iIzUwYzZlOSIvPgoJCQk8cGF0aCBkPSJNMzg1LjY0NCwzMzMuMjA1YzM4LjIyOS0zNS4xMzYsNjIuMzU3LTg1LjMzMyw2Mi4zNTctMTQxLjIwNWMwLTEwNS44NTYtODYuMTIzLTE5Mi0xOTItMTkycy0xOTIsODYuMTQ0LTE5MiwxOTIgICAgIGMwLDU1Ljg1MSwyNC4xMjgsMTA2LjA2OSw2Mi4zMzYsMTQxLjE4NEw2NC42ODQsNDk3LjZjLTEuNTM2LDQuMTE3LTAuNDA1LDguNzI1LDIuODM3LDExLjY2OSAgICAgYzIuMDI3LDEuNzkyLDQuNTY1LDIuNzMxLDcuMTQ3LDIuNzMxYzEuNjIxLDAsMy4yNDMtMC4zNjMsNC43NzktMS4xMDlsNzkuNzg3LTM5Ljg5M2w1OC44NTksMzkuMjMyICAgICBjMi42ODgsMS43OTIsNi4xMDEsMi4yNCw5LjE5NSwxLjI4YzMuMDkzLTEuMDAzLDUuNTY4LTMuMzQ5LDYuNjk5LTYuNGwyMy4yOTYtNjIuMTQ0bDIwLjU4Nyw2MS43MzkgICAgIGMxLjA2NywzLjE1NywzLjU0MSw1LjYzMiw2LjY3Nyw2LjcyYzMuMTM2LDEuMDY3LDYuNTkyLDAuNjQsOS4zNjUtMS4yMTZsNTguODU5LTM5LjIzMmw3OS43ODcsMzkuODkzICAgICBjMS41MzYsMC43NjgsMy4xNTcsMS4xMzEsNC43NzksMS4xMzFjMi41ODEsMCw1LjEyLTAuOTM5LDcuMTI1LTIuNzUyYzMuMjY0LTIuOTIzLDQuMzczLTcuNTUyLDIuODM3LTExLjY2OUwzODUuNjQ0LDMzMy4yMDV6ICAgICAgTTI0Ni4wMTcsNDEyLjI2N2wtMjcuMjg1LDcyLjc0N2wtNTIuODIxLTM1LjJjLTMuMi0yLjExMi03LjMxNy0yLjM4OS0xMC42ODgtMC42NjFMOTQuMTg4LDQ3OS42OGw0OS41NzktMTMyLjIyNCAgICAgYzI2Ljg1OSwxOS40MzUsNTguNzk1LDMyLjIxMyw5My41NDcsMzUuNjA1TDI0Ni43LDQxMS4yQzI0Ni40ODcsNDExLjU2MywyNDYuMTY3LDQxMS44NCwyNDYuMDE3LDQxMi4yNjd6IE0yNTYuMDAxLDM2Mi42NjcgICAgIEMxNjEuOSwzNjIuNjY3LDg1LjMzNSwyODYuMTAxLDg1LjMzNSwxOTJTMTYxLjksMjEuMzMzLDI1Ni4wMDEsMjEuMzMzUzQyNi42NjgsOTcuODk5LDQyNi42NjgsMTkyICAgICBTMzUwLjEwMywzNjIuNjY3LDI1Ni4wMDEsMzYyLjY2N3ogTTM1Ni43NTksNDQ5LjEzMWMtMy40MTMtMS43MjgtNy41MDktMS40NzItMTAuNjg4LDAuNjYxbC01Mi4zNzMsMzQuOTIzbC0zMy42NDMtMTAwLjkyOCAgICAgYzQwLjM0MS0wLjg1Myw3Ny41ODktMTQuMTg3LDEwOC4xNi0zNi4zMzFsNDkuNTc5LDEzMi4yMDNMMzU2Ljc1OSw0NDkuMTMxeiIgZmlsbD0iIzUwYzZlOSIvPgoJCTwvZz4KCTwvZz4KPC9nPgo8Zz4KPC9nPgo8Zz4KPC9nPgo8Zz4KPC9nPgo8Zz4KPC9nPgo8Zz4KPC9nPgo8Zz4KPC9nPgo8Zz4KPC9nPgo8Zz4KPC9nPgo8Zz4KPC9nPgo8Zz4KPC9nPgo8Zz4KPC9nPgo8Zz4KPC9nPgo8Zz4KPC9nPgo8Zz4KPC9nPgo8Zz4KPC9nPgo8L3N2Zz4K"
				width="18" height="18" alt="Medal icon">&nbsp;&nbsp;
				<strong>shoping cart</strong> 
		</div>
		<!-- Shopping Cart-->
		<div class="table-responsive shopping-cart">
			<table class="table">
				<thead>
					<tr>
						<th>Sản Phẩm</th>
						<th class="text-center">Giảm Giá</th>
						<th class="text-center">Giá Tiền</th>
						<th class="text-center">Số Lượng</th>
						<th class="text-center">update/delete</th>
					</tr>
				</thead>
				<tbody>
					<c:if test="${listCart!=null}">
						<c:forEach items ="${listCart}" var="product"> 
						
						<tr>
							
								<td>
									<div class="product-item">
										<a class="product-thumb" href="#"><img
											src="./assets/image/${product.anhChinh}"
											alt="Product"></a>
										<div class="product-info">
											<h4 class="product-title">
												<a href="#">${product.tenSanPham}</a>
											</h4>
											<span><em>khuyến mãi:</em>${product.khuyenMai}</span>
										</div>
									</div>
								</td>
								<td class="text-center text-lg text-medium">${product.giaGoc* product.khuyenMai/100}$</td>
								<td class="text-center text-lg text-medium">${product.giaGoc}$</td>
							
								
								<td class="text-center">
									
										<div class="count-input col-md-2">
												<input type= "hidden" name="id_product" value="${product.id}">
												<input class="form-control" type="number" name="quantity" value="${product.soLuong}" min=0>
										</div>
								</td>
								<td class="text-center">
									
										 
										<a type="button" href="deleteCart?id=${product.id}" >
											    <img src="./assets/icon/delete.png" width="20" height="20" >
										</a>
								</td>
								
							</tr>
						
					</c:forEach>
					
					
					</c:if>
					
		
				</tbody>
			</table>
		</div>
		<div class="shopping-cart-footer">
			<div class="column">
				<p class="text-danger">${messVcher}</p>
				<form action="CheckVoucher" method="post">
					<input class="form-control form-control-xm" type="text" placeholder="voucher" name="voucher">
					<button class="btn btn-outline-primary btn-sm bg-info mt-3" type="submit">Apply</button>
				</form>
			</div>
			
		
			
			<div class="column text-left">
				<%
					long tongTienHang = 0;
					long thueVanChuyen = 3000;
					long Vat = 0;
					long giamGia = 0;
					long tongThanhToan = 0;
					long tienVoucher = 0;
					ArrayList<Products> lstPr = (ArrayList<Products>) request.getAttribute("listCart");
					Voucher vouch = (Voucher)request.getAttribute("vcher");
					
					if (vouch != null){
						tienVoucher = vouch.getKhuyenmai();
					}
					
					if(lstPr != null){
						for (Products pr : lstPr){
							giamGia+=pr.getKhuyenMai()*pr.getGiaGoc()*pr.getSoLuong()/100;
							tongTienHang+= pr.getGiaGoc()*pr.getSoLuong();
						}
						Vat = tongTienHang*2/100;
						tongThanhToan = tongTienHang + thueVanChuyen + Vat - giamGia - tienVoucher;
					}
					
					
				%>
				<span class="text-md fw-bold">Tổng Tiền Hàng: <%= tongTienHang%>$</span><br>
				<span class="text-md fw-bold">Thuế Vận Chuyển: <%= thueVanChuyen%>$</span><br>
				<span class="text-md fw-bold">Thuế VAT(2%): <%= Vat%>$</span><br>
				<span class="text-md fw-bold">Tổng Tiền Giảm Giá:<%= giamGia%>$</span><br>
				<span class="text-md fw-bold">Voucher:<%= tienVoucher%>$</span><br><br>
				<span class="fs-5 fw-bold">Tổng Tiền Thanh Toán:<%= tongThanhToan%>$</span>
			</div>
		</div>
		<div class="shopping-cart-footer">
			<div class="column">
				<a class="btn btn-outline-secondary bg-secondary" href="/glassesStore/home"><i
					class="icon-arrow-left"></i>&nbsp;Back to Shopping</a>
			</div>
			<div class="column">
					<a class="btn btn-success bg-success" href="checkout?tong=<%= tongThanhToan%>">Checkout</a>
			</div>
		</div>
	</div>
	<script src="./assets/js/bootstrap.bundle.min.js"></script>
	<script src="./assets/js/tiny-slider.js"></script>
	<script src="./assets/js/custom.js"></script>

</body>
</html>