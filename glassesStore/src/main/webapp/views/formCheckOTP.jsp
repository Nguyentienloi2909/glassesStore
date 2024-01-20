<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link href="../assets/css/bootstrap.min.css" rel="stylesheet">
<link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css" rel="stylesheet">
<link href="../assets/css/tiny-slider.css" rel="stylesheet">
<link href="../assets/css/style.css" rel="stylesheet">
<style type="text/css">
body{margin-top:20px;}
.container{
width:80%;
}

</style>
</head>
<body>
	<div class="row d-flex justify-content-center align-items-center ">	
	
	<form style="width: 30%; height:30%" action="checkEmail" method="post">
		<div class="mb-3">
		    <input type="hidden" class="form-control"   name="userName"  value="${userName}">
		  </div>
		  <div class="mb-3">
		    <input type="hidden" class="form-control"   name="fullName" value="${fullName}">
		  </div>
		  <div class="mb-3">
		    <input type="hidden" class="form-control"   name="email" value="${email}">
		  </div>
		  <div class="mb-3">
		    <input type="hidden" class="form-control"   name="password" value="${password}">
		  </div>
		  
		  <div class="mb-3">
		    <input type="hidden" class="form-control"   name="chuoiTest" value="${chuoiTest}">
		  </div>
		  
		  <div class="mb-3">
		    <label for="exampleInputPassword1" class="form-label">Nhập mã OTP</label>
		    <input type="text" class="form-control"  placeholder="Nhập OTP" name="maOTP" id="exampleInputPassword1">
		  </div>
		  <button type="submit" class="btn btn-primary">Submit</button>
	</form>
</div>
</body>
</html>