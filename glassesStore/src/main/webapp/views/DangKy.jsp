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
	  <div class="container ">
	  	
	    <div class="row d-flex justify-content-center align-items-center ">
	      <div class="col-lg-12 col-xl-11">

	        <div class="card text-black" style="border-radius: 25px;">
	          <div class="card-body p-md-5">
	          	 <a href="/glassesStore/home"><i class="fa fa-arrow-left" aria-hidden="true"></i></a>
	            <div class="row justify-content-center">
	              <div class="col-md-10 col-lg-6 col-xl-5 order-2 order-lg-1">
	
	                <p class="text-center h1 fw-bold mb-5 mx-1 mx-md-4">Sign up</p>
					<p class="text-danger">${alert}</p>
	                <form class="mx-1 mx-md-4" action="/glassesStore/register" method="post">
	                
						<p class="text-danger">${messUserName}</p>
		                  <div class="d-flex flex-row align-items-center ">
		                    <i class="fa-solid fa-user-tie me-3 fa-fw"></i>
		                    <div class="form-outline flex-fill mb-0">
		                    	
		                      <input type="text" id="form3Example1c" class="form-control" name="user-name" required="required" value="${userName}"/>
		                      <label class="form-label" for="form3Example1c">User Name</label>
		                    </div>
		                  </div>
		                  
						<div class="d-flex flex-row align-items-center">
		                    <i class="fas fa-user fa-lg me-3 fa-fw"></i>
		                    <div class="form-outline flex-fill mb-0">
		                      <input type="text" id="form3Example1c" class="form-control" name="tenHienThi" required="required" value="${fullName}"/>
		                      <label class="form-label" for="form3Example1c">Your Name</label>
		                    </div>
		                  </div>
		                  
		                  <p class="text-danger">${messEmail}</p>
		                  <div class="d-flex flex-row align-items-center ">
		                    <i class="fas fa-envelope fa-lg me-3 fa-fw"></i>
		                    <div class="form-outline flex-fill mb-0">	
		                      <input type="text" id="form3Example3c" class="form-control" name="user-email" required="required"  value="${email}"/>
		                      <label class="form-label" for="form3Example3c">Your Email</label>
		                    </div>
		                  </div>
		        
		                  
		                  <div class="d-flex flex-row align-items-center ">
		                    <i class="fas fa-lock fa-lg me-3 fa-fw"></i>
		                    <div class="form-outline flex-fill mb-0">
		                      <input type="password" id="form3Example4c" class="form-control" name="password" required="required"/>
		                      <label class="form-label" for="form3Example4c">Password</label>
		                    </div>
		                  </div>
		
		                  <div class="d-flex flex-row align-items-center">
		                    <i class="fas fa-key fa-lg me-3 fa-fw"></i>
		                    <div class="form-outline flex-fill mb-0">
		                      <input type="password" id="form3Example4cd" class="form-control" name="passwordRepeat"/>
		                      <label class="form-label" for="form3Example4cd">Repeat your password</label>
		                    </div>
		                  </div>
						<p class="text-danger">${messPasswordRepeat}</p>
					
					
	
	                    <button type="submit" id="submit"  class="btn btn-primary m-5" >
	                    	Register</button>
	                 
					</form>
	              </div>
	              <div class="col-md-10 col-lg-6 col-xl-7 d-flex align-items-center order-1 order-lg-2">
	
	                <img src="https://mdbcdn.b-cdn.net/img/Photos/new-templates/bootstrap-registration/draw1.webp"
	                  class="img-fluid" alt="Sample image">
	
	              </div>
	            </div>
	          </div>
	        </div>
	      </div>
	    </div>
	  </div>

	<script src="../assets/js/bootstrap.bundle.min.js"></script>
	<script src="../assets/js/tiny-slider.js"></script>
	<script src="../assets/js/custom.js"></script>
	
</body>
</html>