<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link href="/assets/css/bootstrap.min.css" rel="stylesheet">
<link
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css"
	rel="stylesheet">
	<script src="/assets/js/bootstrap.bundle.min.js"></script>
<style type="text/css">
.gradient-custom-3 {
/* fallback for old browsers */
background: #84fab0;

/* Chrome 10-25, Safari 5.1-6 */
background: -webkit-linear-gradient(to right, rgba(132, 250, 176, 0.5), rgba(143, 211, 244, 0.5));

/* W3C, IE 10+/ Edge, Firefox 16+, Chrome 26+, Opera 12+, Safari 7+ */
background: linear-gradient(to right, rgba(132, 250, 176, 0.5), rgba(143, 211, 244, 0.5))
}
.gradient-custom-4 {
/* fallback for old browsers */
background: #84fab0;

/* Chrome 10-25, Safari 5.1-6 */
background: -webkit-linear-gradient(to right, rgba(132, 250, 176, 1), rgba(143, 211, 244, 1));

/* W3C, IE 10+/ Edge, Firefox 16+, Chrome 26+, Opera 12+, Safari 7+ */
background: linear-gradient(to right, rgba(132, 250, 176, 1), rgba(143, 211, 244, 1))
}
</style>
</head>
<body>

	<section class="">
		<div class="mask d-flex align-items-center h-100 gradient-custom-3">
			<div class="container h-100">
				<div
					class="row d-flex justify-content-center align-items-center h-100">
					<div class="col-12 col-md-9 col-lg-7 col-xl-6">
						<div class="card" style="border-radius: 15px;">
							<div class="card-body p-5">
								<a href="/glassesStore/adminproduct"><i
									class="fa fa-arrow-left" aria-hidden="true"></i></a>
								<h2 class="text-uppercase text-center mb-5">Create an
									Products</h2>

								<form action="/glassesStore/AdminAddProduct" method="post">

									<div class="form-outline">
										<input type="text" id="form3Example1cg" name="tensanpham"
											required="required" class="form-control form-control-lg" />
										<label class="form-label" for="form3Example1cg">tên
											sản phẩm</label>
									</div>

									<div class="form-outline">
										<input type="text" id="form3Example3cg" name="mota"
											class="form-control form-control-lg" /> <label
											class="form-label" for="form3Example3cg">mô tả</label>
									</div>

									<div class="form-outline">
										<input type="number" id="form3Example4cg" name="giagoc"
											required="required" class="form-control form-control-lg" />
										<label class="form-label" for="form3Example4cg">giá
											gốc</label>
									</div>

									<div class="form-outline">
										<input type="number" id="form3Example4cg" name="khuyenmai"
											class="form-control form-control-lg" /> <label
											class="form-label" for="form3Example4cg">khuyến mãi</label>
									</div>

									<div class="form-outline">
										<input type="text" id="form3Example4cg" name="anhchinh"
											required="required" class="form-control form-control-lg" />
										<label class="form-label" for="form3Example4cg">tên
											ảnh</label>
									</div>
									<div class="form-outline">
										<input type="number" id="form3Example4cg" name="soluong"
											required="required" class="form-control form-control-lg" />
										<label class="form-label" for="form3Example4cg">số
											lượng</label>
									</div>
									<div class="form-outline">
										<select class="form-select"
											aria-label="Default select example" name="id_loaisp">
											<option selected value="1">amo</option>
											<option value="2">bolon</option>
											<option value="3">gucci</option>
											<option value="4">molsion</option>
										</select> <label class="form-label" for="form3Example4cg">loại
											sản phẩm</label>
									</div>

									<div class="d-flex justify-content-center">
										<button type="submit"
											class="btn btn-success btn-block btn-lg gradient-custom-4 text-body">save</button>
									</div>
								</form>

							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</section>
	<script src="/assets/js/bootstrap.bundle.min.js"></script>
	<script src="/assets/js/tiny-slider.js"></script>
	<script src="/assets/js/custom.js"></script>
</body>
</html>