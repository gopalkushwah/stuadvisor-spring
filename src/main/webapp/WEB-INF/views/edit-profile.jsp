<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page isELIgnored="false"%>
<!DOCTYPE html>
<html lang="en">

<head>
<%@include file="commons/head.jsp"%>

</head>

<body>

	<!-- ======= Header ======= -->
	<%@include file="commons/header.jsp"%>
	<!-- ======= Sidebar ======= -->
	<%@include file="commons/profile-sidebar.jsp"%>
	<main id="main" class="main">

		<div class="pagetitle">
			<h1>Profile</h1>
			<nav>
				<ol class="breadcrumb">
					<li class="breadcrumb-item"><a href="index.html">Profile</a></li>
					<li class="breadcrumb-item active">Edit Profile</li>
				</ol>
			</nav>
		</div>
		<!-- End Page Title -->

		<section class="section dashboard">
			<div class="row">
				<div class="col-sm-12 col-md-12 col-lg-12 ">
					<!-- Change User Info -->
					<div class="card p-4">
						<div class="text-center">
							<h5>
								<strong> <span class="fs-2 text-danger">E</span>dit <span
									class="fs-2 text-danger">Y</span>our <span
									class="fs-2 text-danger">I</span>nformation
								</strong>
							</h5>
						</div>
						<form id="form-1">
							<div class="row">
								<div class="col-9 col-sm-9 col-md-10 col-lg-11">
									<input type="text"
										class="form-control border-dark border-2 mb-4" id="username"
										name="name" value="${singleUserByMsId.name }" /> 
									<input
										type="text" hidden="true" id="msid" name="msid"
										value="${singleUserByMsId.msId }" />
								</div>
								<div class="col-3 col-sm-3 col-md-2 col-lg-1">
									<button class="btn btn-outline-danger mb-2  pe-4 ps-4"
										type="button" id="edit-name">
										<i class="ri ri-ball-pen-line"></i>
									</button>
								</div>
							</div>
							<div class="row">
								<div class="col-9 col-sm-9 col-md-10 col-lg-11">
									<input type="text"
										class="form-control border-dark border-2 mb-4" id="usermobile"
										name="mobile" value="${singleUserByMsId.mobile }" />
								</div>
								<div class="col-3 col-sm-3 col-md-2 col-lg-1">
									<button class="btn btn-outline-danger mb-2  pe-4 ps-4"
										type="button" id="edit-mobile">
										<i class="ri ri-ball-pen-line"></i>
									</button>
								</div>
							</div>
							<div class="row">
								<div class="col-9 col-sm-9 col-md-10 col-lg-11">
									<input type="email"
										class="form-control border-dark border-2 mb-4" id="useremail"
										name="email" value="${singleUserByMsId.email }" />
								</div>
								<div class="col-3 col-sm-3 col-md-2 col-lg-1">
									<button class="btn btn-outline-danger mb-2  pe-4 ps-4"
										type="button" id="edit-email">
										<i class="ri ri-ball-pen-line"></i>
									</button>
								</div>
							</div>
							<div class="row">
								<div class="col-9 col-sm-9 col-md-10 col-lg-11">
									<input type="text"
										class="form-control border-dark border-2 mb-4"
										id="useraddress" name="useraddress"
										value="${singleUserByMsId.address }" />

								</div>
								<div class="col-3 col-sm-3 col-md-2 col-lg-1">
									<button class="btn btn-outline-danger mb-2  pe-4 ps-4"
										type="button" id="edit-address">
										<i class="ri ri-ball-pen-line"></i>
									</button>
								</div>
							</div>
							<div class="row">
								<div class="col-9 col-sm-9 col-md-10 col-lg-11">
									<h5>
										<strong> <span class="text-danger">Please
												Select Gender</span></strong>
									</h5>
									<div id="gender-container">
										<label for="male">Male : <span
											class="text-danger fs-5">*</span></label> <input type="radio"
											class="border-dark border-2 me-4" id="male" name="gender"
											value="male"
											${singleUserByMsId.gender == "male" ? "checked = 'true'" : ""  } />

										<label for="female">Female : <span
											class="text-danger fs-5">*</span></label> <input type="radio"
											class="border-dark border-2 me-4" id="female" name="gender"
											value="female"
											${singleUserByMsId.gender == "female" ? "checked = 'true'" : ""  } />

										<label for="other">Others : <span
											class="text-danger fs-5">*</span></label> <input type="radio"
											class="border-dark border-2 me-4" id="other" name="gender"
											value="other"
											${singleUserByMsId.gender == "other" ? "checked = 'true'" : "" } />
									</div>
								</div>
								<div class="col-3 col-sm-3 col-md-2 col-lg-1">
									<button class="btn btn-outline-danger mb-2  pe-4 ps-4"
										type="button" id="edit-gender">
										<i class="ri ri-ball-pen-line"></i>
									</button>
								</div>
							</div>
						</form>
					</div>

					<!-- Change Password  -->
					<div class="card p-4">
						<div class="text-center">
							<h5>
								<strong> <span class="fs-2 text-danger">C</span>hange <span
									class="fs-2 text-danger">Y</span>our <span
									class="fs-2 text-danger">P</span>assword
								</strong>
							</h5>
						</div>
						<form id="form-1">
							<div class="row">
								<div class="col-sm-6 col-md-6 col-lg-6">
									<label for="newpassword">New Password : <span
										class="text-danger fs-5">*</span></label> <input type="text"
										class="form-control border-dark border-2 mb-4"
										id="newpassword" name="newpassword" /> <input type="text"
										hidden="true" id="msid1" name="msid1"
										value="${singleUserByMsId.msId }" />
								</div>
								<div class="col-sm-6 col-md-6 col-lg-6">
									<label for="confirmpassword">Confirm Password : <span
										class="text-danger fs-5">*</span></label> <input type="text"
										class="form-control border-dark border-2 mb-4"
										id="confirmpassword" name="confirmpassword" />
								</div>
							</div>
							<div class="text-center">
								<button class="btn btn-outline-danger mb-2  pe-4 ps-4"
									type="button" id="change-password">Change Password</button>
							</div>
						</form>
						
					</div>

					<!-- Change User Profile Image  -->
					<div class="card p-4">
						<div class="text-center">
							<h5>
								<strong> <span class="fs-2 text-danger">C</span>hange <span
									class="fs-2 text-danger">Y</span>our <span
									class="fs-2 text-danger">P</span>assword
								</strong>
							</h5>
						</div>
						<form id="change-profile-image" enctype="multipart/form-data" >
							<div class="row">
								<div class="col-12 col-sm-12 col-md-12 col-lg-12">
									<label for="newpassword">Select Any File : <span
										class="text-danger fs-5">*</span></label> <input type="file"
										class="form-control border-dark border-2 mb-4"
										id="profile-image" name="profile-image" /> 
										<input type="text"
										hidden="true" id="msid1" name="msid1"
										value="${singleUserByMsId.msId }" />
								</div>
							</div>
							<div class="text-center">
								<button class="btn btn-outline-danger mb-2  pe-4 ps-4"
									type="submit" id="profile-image-btn">Change Image</button>
							</div>
						</form>
						
					</div>
				</div>
			</div>
		</section>

	</main>
	<!-- End #main -->
	<!-- <script src="<c:out value="resources/assets/js/isPasswordTrue.js"/>"></script> -->
	<script src="<c:out value="resources/assets/js/edit-profile-info.js"/>"></script>

	<!-- ======= Footer ======= -->
	<%@include file="commons/footer.jsp"%>
	<%@include file="commons/alljs.jsp"%>

</body>

</html>