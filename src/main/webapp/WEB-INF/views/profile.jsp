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
					<li class="breadcrumb-item active">Home</li>
				</ol>
			</nav>
		</div>
		<!-- End Page Title -->

		<section class="section dashboard">
			<div class="row">
				<div class="col-xs-12 col-sm-12 col-md-12 col-lg-6 ">
					<div class="card">
						<div
							class="card-body profile-card pt-4 d-flex flex-column align-items-center">
							<h4 class="text-center">
								Hello Dear <span class="fs-2 text-danger">${singleUserByMsId.name }</span>
								,Nice to See You
							</h4>
							<div class="text-center mt-5 mb-3">
								<img
									src='<c:out value="resources/assets/useruploads/${singleUserByMsId.profileImage }"/>'
									alt="Profile" class="rounded-circle w-25">
							</div>
							<h2>${singleUserByMsId.name }</h2>
							<div class="social-links mt-5 mb-5">
								<a href="#" class="twitter p-3 border border-3 rounded-5"><i
									class="bi bi-twitter fs-5"></i></a> <a href="#"
									class="facebook p-3 border border-3 rounded-5"><i
									class="bi bi-facebook fs-5"></i></a> <a href="#"
									class="instagram p-3 border border-3 rounded-5"><i
									class="bi bi-instagram fs-5"></i></a> <a href="#"
									class="linkedin p-3 border border-3 rounded-5"><i
									class="bi bi-linkedin fs-5"></i></a>
							</div>
						</div>
					</div>
				</div>
				<div class="col-xs-12col-sm-12 col-md-12 col-lg-6 ">
					<div class="card">
						<div
							class="card-body profile-card pt-4">
							<h5 class="card-title">Profile Details</h5>

							<div class="row">
								<div class="col-lg-3 col-md-4 label ">Full Name</div>
								<div class="col-lg-9 col-md-8 fs-5">${singleUserByMsId.name }</div>
							</div>
							<hr class="border border-1 border-dark">
							<div class="row">
								<div class="col-lg-3 col-md-4 label">User Id</div>
								<div class="col-lg-9 col-md-8 fs-5">${singleUserByMsId.msId }</div>
							</div>
							<hr class="border border-1 border-dark">

							<div class="row">
								<div class="col-lg-3 col-md-4 label">Mobile</div>
								<div class="col-lg-9 col-md-8 fs-5">${singleUserByMsId.mobile }</div>
							</div>
							<hr class="border border-1 border-dark">

							<div class="row">
								<div class="col-lg-3 col-md-4 label">Email</div>
								<div class="col-lg-9 col-md-8 fs-5">${singleUserByMsId.email }</div>
							</div>
							<hr class="border border-1 border-dark">

							<div class="row">
								<div class="col-lg-3 col-md-4 label">Address</div>
								<div class="col-lg-9 col-md-8 fs-5">${singleUserByMsId.address }</div>
							</div>
							<hr class="border border-1 border-dark">
							
							<div class="row">
								<div class="col-lg-3 col-md-4 label">Sing Up Date</div>
								<div class="col-lg-9 col-md-8 fs-5">${singleUserByMsId.signupDate.toLocaleString() }</div>
							</div>

						</div>
					</div>
				</div>
		</section>

	</main>
	<!-- End #main -->

	<!-- ======= Footer ======= -->
	<%@include file="commons/footer.jsp"%>
	<%@include file="commons/alljs.jsp"%>

</body>

</html>