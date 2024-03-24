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
		<!-- <div class="mask d-flex align-items-center h-100 gradient-custom-3"> -->
			<div class="container mt-5">
				<div
					class="row justify-content-center align-items-center mt-5">
					<div class="col-lg-8">
						<div class="card" style="border-radius: 15px; box-shadow:  20px 20px 60px #a99494,-20px -20px 60px #e5c8c8;">
							<div class="card-body p-5">
								<a href="/glassesStore/adminproduct"><i
									class="fa fa-arrow-left" aria-hidden="true"></i></a>
								<h2 class="text-uppercase mb-4 mt-4">Thông Tin Sản Phẩm</h2>

								<form action="/glassesStore/AdminAddProduct" method="post" enctype="multipart/form-data"> 
									<div class="form-outline">
										<div class="row">
											<div class="col">
												<label class="form-label" for="form3Example1cg">tên
													sản phẩm</label> 
												<input type="text" id="form3Example1cg" name="tensanpham"
													 class="form-control form-control-lg" />
												<span style="color:red">${eTensp}</span>
											</div>
											
											<div class="col">
												<label class="form-label" for="form3Example4cg">Ảnh minh họa</label>
												<input type="file" id="form3Example4cg" name="file"  class="form-control form-control-lg" />
												<span style="color:red">${eTenAnh}</span>
											</div>
										</div>
									</div>
									

									<div class="form-outline  mt-4">
										<div class="row">
											<div class="col">
												<label class="form-label" for="form3Example4cg">giá gốc</label>
												<input type="text" id="form3Example4cg" name="giagoc"
													class="form-control form-control-lg" />
												<span style="color:red">${eGia}</span><br>
											</div>
											
											<div class="col">
												<label class="form-label" for="form3Example4cg">số lượng</label>
												<input type="text" id="form3Example4cg" name="soluong"
													 class="form-control form-control-lg" />
												<span style="color:red">${eSoLuong}</span>
											</div>
											
											
										</div>
										
										
									</div>

									<div class="form-outline">
										<div class="row">
											<div class="col">
												<label class="form-label" for="form3Example4cg">khuyến mãi (%)</label>
												<input type="number" id="form3Example4cg" name="khuyenmai"
												class="form-control form-control-lg" value="0"/> 
												<span style="color:red">${ekhuyenMai}</span>
											</div>
											
										</div>
										
									</div>
									<div class="form-outline  mt-4">
										<label class="form-label" for="form3Example4cg">loại sản phẩm</label>
										<select class="form-select" aria-label="Default select example" name="id_loaisp">
											<c:if test="${listLSP != null}">
												<option >--</option>
												<c:forEach items="${listLSP}" var="loaiSP">
													<option >${loaiSP.tenLoaiSanPham}</option>
												</c:forEach>
											</c:if>
										</select> 
										<span style="color:red">${eloaiSp}</span>
									</div>

									<div class="form-outline  mt-4">
										<label class="form-label" for="form3Example4cg">Nhà Cung Cấp </label>
										<select class="form-select" aria-label="Default select example" name="id_nhaCungCap">
											<c:if test="${listNCC != null}">
												<option >--</option>
												<c:forEach items="${listNCC}" var="NhaCungCap">
													<option>${NhaCungCap.tenNhaCungCap}</option>
												</c:forEach>
											</c:if>
										</select> 
										<span style="color:red">${eNhaCC}</span>
									</div>
											
									<div class="form-outline  mt-4">
										<label class="form-label" for="form3Example3cg">mô tả</label>
										<textarea id="content" name="mota" class="form-control form-control-lg"></textarea>
									    <span style="color:red">${eMoTa}</span>
									</div>
	


									<div class="d-flex  mt-5">
										<button type="submit"
											class="btn btn-lg btn-success px-5 font-bold">save</button>
									</div>
								</form>

							</div>
						</div>
					</div>
				</div>
			</div>
	<!-- 	</div> -->
	<script src="/assets/js/bootstrap.bundle.min.js"></script>
	<script src="/assets/js/tiny-slider.js"></script>
	<script src="/assets/js/custom.js"></script>
</body>
</html>