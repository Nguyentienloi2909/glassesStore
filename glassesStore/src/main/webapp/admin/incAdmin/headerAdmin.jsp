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
background-color
:
 
#fbfbfb
;

  
}
@media ( min-width : 991.98px) {
	main {
		padding-left: 240px;
	}
}

/* Sidebar */
.sidebar {
	position: fixed;
	top: 0;
	bottom: 0;
	left: 0;
	padding: 58px 0 0;
	/* Height of navbar */
	box-shadow: 0 2px 5px 0 rgb(0 0 0/ 5%), 0 2px 10px 0 rgb(0 0 0/ 5%);
	width: 240px;
	z-index: 600;
}

@media ( max-width : 991.98px) {
	.sidebar {
		width: 100%;
	}
}

.sidebar .active {
	border-radius: 5px;
	box-shadow: 0 2px 5px 0 rgb(0 0 0/ 16%), 0 2px 10px 0 rgb(0 0 0/ 12%);
}

.sidebar-sticky {
	position: relative;
	top: 0;
	height: calc(100vh - 48px);
	padding-top: 0.5rem;
	overflow-x: hidden;
	overflow-y: auto;
	/* Scrollable contents if viewport is shorter than content. */
}
</style>
</head>
<body>
	<div class="col-sm-2">
		<nav id="sidebarMenu"
			class="collapse d-lg-block sidebar collapse bg-white">
			<div class="position-sticky">
				<div class="list-group list-group-flush mx-3 mt-4">

					<a href="adminproduct"
						class="list-group-item list-group-item-action py-2 ripple"> <i
						class="fas fa-calendar fa-fw me-3"></i><span>Product</span></a> <a
						href="adminUser"
						class="list-group-item list-group-item-action py-2 ripple"> <i
						class="fas fa-users fa-fw me-3"></i><span>Users</span></a>
					<div class="dropdown">
						<button
							class="btn btn-light dropdown-toggle list-group-item list-group-item-action"
							type="button" id="dropdownMenu2" data-bs-toggle="dropdown"
							aria-expanded="false">
							<i class="fas fa-user-shield fa-fw me-3"></i> <span>Admin</span>
						</button>
						<ul class="dropdown-menu" aria-labelledby="dropdownMenu2">
							<c:choose>
								<c:when test="${empty sessionScope.admin}">
									<li><a class="dropdown-item" href="./views/DangNhap.jsp">Đăng
											nhập </a></li>
								</c:when>
								<c:otherwise>
									<li><a class="dropdown-item"><c:out
												value="${sessionScope.admin.tenTaiKhoan}" /></a></li>
									<li><a class="dropdown-item" href="logout">Đăng Xuất </a></li>
								</c:otherwise>
							</c:choose>


						</ul>
					</div>

				</div>
			</div>
		</nav>
	</div>
	<script src="/assets/js/bootstrap.bundle.min.js"></script>
	<script src="/assets/js/tiny-slider.js"></script>
	<script src="/assets/js/custom.js"></script>
</body>
</html>