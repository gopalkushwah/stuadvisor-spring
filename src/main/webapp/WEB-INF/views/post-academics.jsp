<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page isELIgnored="false"%>
<!DOCTYPE html>
<html lang="en">

<head>
<%@include file="commons/head.jsp"%>
</head>
<c:set var="userCookie" value="${userCookie }"/>
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
					<li class="breadcrumb-item active">Post Academics</li>
				</ol>
			</nav>
		</div>
		<!-- End Page Title -->

		<section class="section dashboard">
			<div class="row">
				<div
					class="col-sm-12 col-md-12 col-lg-12 d-flex align-items-center justify-content-center card">
					<div class="mb-3">
							<h3 class="text-center"><strong><span class="text-danger fs-2">P</span>ost <span class="text-danger fs-2">S</span>tudy <span class="text-danger fs-2">M</span>aterial</strong></h3>
						<form class="border border-1" id="post-academics" enctype="multipart/form-data">
							<div class="row   p-4">
								<div class="col-sm-12 mt-3 ">
									<label for="title" class="fs-5"><strong>Title :</strong></label>
									<input class="form-control border-dark" id="title" name="title" placeholder="Enter Title" type="text"/>
								</div>
								<div class="col-12 mt-3">
									<label for="description" class="fs-5"><strong>Description :</strong></label>
									<input class="form-control border-dark" id="description" name="description" placeholder="Enter Description" type="text"/>
								</div>
								<div class="col-12 mt-3" hidden="true">
									<input class="form-control border-dark" id="creater-id" name="createrId" type="text" value ="${userCookie.msId }"/>
								</div>
								<div class="col-12 mt-3" hidden="true">
									<input class="form-control border-dark" id="creater-image" name="createrImage" type="text" value ="${userCookie.profileImage }"/>
								</div>
								<div class="col-12 mt-3" hidden="true" >
									<input class="form-control border-dark" id="creater-name" name="createrName" type="text" value ="${userCookie.name }"/>
								</div>
								<div class="col-12 mt-3">
									<label for="title" class="fs-5"><strong>Select Any Study Related File</strong></label>
									<input class="form-control border-dark" id="study-material-image" name="title" placeholder="Select any file" type="file" accept=".pdf , .doc , .docx , .jpg , .jpeg , .png , .txt , .csv , .ppt , .pptx "/>
								</div>
								<div class="col-12 mt-3 text-center">
									<input class="btn btn-outline-dark pe-5 ps-5" type="submit" value="Post"/>
								</div>
							</div>
						</form>
					</div>
				</div>
			</div>
		</section>

	</main>
	<!-- End #main -->
<script type="text/javascript" src="<c:url value="/resources/assets/js/post-academics.js"/>"></script>

	<!-- ======= Footer ======= -->
	<%@include file="commons/footer.jsp"%>
	<%@include file="commons/alljs.jsp"%>

</body>

</html>