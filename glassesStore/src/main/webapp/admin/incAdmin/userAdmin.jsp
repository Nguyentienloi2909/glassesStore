<%@page import="model.Category"%>
<%@page import="model.Products"%>
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
							<h3 class="fw-normal mb-0 text-black">Người Dùng</h3>
	
						</div>
					<c:if test="${listUser!=null}">
						<c:forEach items="${listUser}" var="user">
							<div class="card rounded-3 mb-4">



								<div class="card-body p-4 mt-2">

									<div
										class="row d-flex justify-content-between align-items-center">
										<div class="col-md-2 col-lg-2 col-xl-2">
											<img src="./assets/icon/avatar.jpg" class="img-fluid"
												width="100" height="100" alt="Cotton T-shirt">
										</div>
										<div class="col-md-3 col-lg-3 col-xl-3">
											<p class="lead fw-normal mb-2">${user.tenHienThi }</p>
											<p>
												<span class="text-muted">phân quyền: </span>${user.phanQuyen }
												<br> <span class="text-muted">email: </span>${user.email}
											</p>
										</div>
										<div class="col-md-3 col-lg-3 col-xl-3 d-flex">
											<p class="lead fw-normal mb-2">userName:
												${user.tenTaiKhoan }</p>
										</div>
										<div class="col-md-3 col-lg-2 col-xl-2 offset-lg-1">
											<a href="AdminPhanQuyen?id=${user.id}"> <i
												class="fas fa-cog fa-lg"></i>
											</a>
										</div>
										<div class="col-md-1 col-lg-2 col-xl-1 text-end">
											<a href="AdminDeleteUser?id=${user.id}" class="text-danger"><i
												class="fas fa-trash fa-lg"></i></a>
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