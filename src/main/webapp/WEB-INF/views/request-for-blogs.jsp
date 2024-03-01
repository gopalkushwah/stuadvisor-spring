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
					<li class="breadcrumb-item active">Request For Blog</li>
				</ol>
			</nav>
		</div>
		<!-- End Page Title -->

		<section class="section dashboard">
			<div class="row">
				<div
					class="col-sm-12 col-md-12 col-lg-12">
						<div class="card">
						<h3 class="text-center mt-2"><strong><span class="text-danger fs-2">S</span>end <span class="text-danger fs-2">R</span>equest <span class="text-danger fs-2">F</span>or <span class="text-danger fs-2">B</span>log</strong></h3>
						<form class="me-5 ms-5 mb-5 mt-2">
						
								<div class="col-sm-12 mt-3 ">
									<label for="title" class="fs-5"><strong>Title :</strong></label>
									<input class="form-control border-dark" id="title" name="title" placeholder="Enter Title" type="text"/>
								</div>
								<div hidden="true">
									<input id="creater-id" name="createrId" type="text" value ="${userCookie.msId }"/>
								</div>
								<div hidden="true">
									<input id="creater-image" name="createrImage" type="text" value ="${userCookie.profileImage }"/>
								</div>
								<div  hidden="true" >
									<input  id="creater-name" name="createrName" type="text" value ="${userCookie.name }"/>
								</div>
								<div class="col-12 mt-3 text-center">
									<button class="btn btn-outline-dark pe-5 ps-5" type="button" id="send-blog-request">Send Request</button>
								</div>
						</form>
						</div>
					</div>
			</div>
		</section>

	</main>
	<!-- End #main -->
<script type="text/javascript" src="<c:url value="/resources/assets/js/request-for-blog.js"/>"></script>

	<!-- ======= Footer ======= -->
	<%@include file="commons/footer.jsp"%>
	<%@include file="commons/alljs.jsp"%>

</body>

</html>