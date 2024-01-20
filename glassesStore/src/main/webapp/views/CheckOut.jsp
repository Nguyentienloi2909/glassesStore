<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.Products"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link href="../assets/css/bootstrap.min.css" rel="stylesheet">
<link
	href="https://maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css"
	rel="stylesheet">
<link href="../assets/css/tiny-slider.css" rel="stylesheet">
<link href="../assets/css/style.css" rel="stylesheet">
<style type="text/css">
body {
	background: #eee;
}

.card {
	box-shadow: 0 20px 27px 0 rgb(0 0 0/ 5%);
}

.card {
	position: relative;
	display: flex;
	flex-direction: column;
	min-width: 0;
	word-wrap: break-word;
	background-color: #fff;
	background-clip: border-box;
	border: 0 solid rgba(0, 0, 0, .125);
	border-radius: 1rem;
}

.card-body {
	-webkit-box-flex: 1;
	-ms-flex: 1 1 auto;
	flex: 1 1 auto;
	padding: 1.5rem 1.5rem;
}
</style>
</head>
<body>
<form action="checkout" method="post">
	<div class="container mt-5">
		<a href="/glassesStore/cart"><i class="fa fa-arrow-left"
			aria-hidden="true"></i></a>
		<div class="row mt-5">
			
				<!-- Left -->
				<div class="col-lg-9">
					<div class="accordion" id="accordionPayment">
						<!-- Credit card -->
						<div class="accordion-item mb-3">
							<h2
								class="h5 px-4 py-3 accordion-header d-flex justify-content-between align-items-center">
								<div class="form-check w-100 collapsed">
									<label class="form-check-label pt-1" for="payment1">
										Đặt Hàng</label>
								</div>

							</h2>
							<div id="collapseCC" class="accordion-collapse collapse show"
								data-bs-parent="#accordionPayment" style="">
								<div class="accordion-body">

									<div class="row">
										<div class="col-lg-6">
											<div class="mb-3">
												<label class="form-label">địa chỉ</label> <input type="text"
													class="form-control" placeholder="address" name="diachi"
													required="required">
											</div>
										</div>
										<div class="col-lg-6">
											<div class="mb-3">
												<label class="form-label">số điện thoại</label> <input
													type="text" class="form-control" placeholder="number phone" name="sdt"
													required="required">
											</div>
										</div>
										<div class="mb-3">
											<label class="form-label">ghi chú</label> <input type="text"
												class="form-control" placeholder="note" name="ghichu">
										</div>
									</div>
								</div>
							</div>
						</div>
						<!-- PayPal -->
						<div class="accordion-item mb-3 border">
							<h2 class="h5 px-4 py-3 accordion-header d-flex justify-content-between align-items-center">
								<div>
									<input class="form-check-input" type="radio" name="payment"
										id="payment2"> <label class="form-check-label pt-1"
										for="payment2"> PayPal </label>
								</div>
							</h2>
						</div>
					</div>
				</div>
				<!-- Right -->
				<div class="col-lg-3">
					<div class="card position-sticky top-0">
						<div class="p-3 bg-light bg-opacity-10">

							<h6 class="card-title mb-3">Order Summary</h6>
							<div class="d-flex justify-content-between mb-1 small">
								<span>Subtotal</span> <span>$${tong}</span>
							</div>

							<hr>
							<div class="d-flex justify-content-between mb-4 small">
								<span>TOTAL</span> <strong class="text-dark">$${tong}</strong>
							</div>
							<div class="form-check mb-1 small">
								<input class="form-check-input" type="checkbox" value=""
									required="required" id="tnc"> <label
									class="form-check-label" for="tnc"> I agree to the <a
									href="#">terms and conditions</a>
								</label>
							</div>
							<div class="form-check mb-3 small">
								<input class="form-check-input" type="checkbox" value=""
									required="required" id="subscribe"> <label
									class="form-check-label" for="subscribe"> Get emails
									about product updates and events. If you change your mind, you
									can unsubscribe at any time. <a href="#">Privacy Policy</a>
								</label>
							</div>
								
							<button type="submit" aria-hidden="true" class="btn btn-primary w-100 mt-2" >
							 	Place order
							</button>
							
					
						</div>
					</div>
				</div>
			</div>
		</div>
	</form>
				
			
	<script src="../assets/js/bootstrap.bundle.min.js"></script>
	<script src="../assets/js/tiny-slider.js"></script>
	<script src="../assets/js/custom.js"></script>
</body>
</html>