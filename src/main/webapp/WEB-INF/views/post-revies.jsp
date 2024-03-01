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
					<li class="breadcrumb-item active">Post Reviews</li>
				</ol>
			</nav>
		</div>
		<!-- End Page Title -->

		<section class="section dashboard">
			<div class="row">
				<div class="col-sm-12 col-md-12 col-lg-12 ">
					<div class="card">
						<div class="text-center fs-3 fw-bold">
							<span class="fs-1 text-danger">S</span>end <span
								class="fs-1 text-danger">R</span>eviews
						</div>
						<div class="text-center fs-5">
							Your <span class="fs-3 text-danger  fw-bold">Reviews</span> are
							important to develop our community more strong. Reviews help
							people to know more about us..
						</div>
						<hr class="border border-bottom border-2" />
						<form id="reviews-form" class="me-3 ms-3">
							<div class="mb-3">
								<label for="name" class="fs-4 text-success fw-bolder">Enter
									Your Name :</label> <input id="name" class="form-control border-dark"
									placeholder="Enter your name" type="text" name="name"  value="${userCookie.name }"/>
							</div>
							<div class="mb-3" hidden="true">
								<input id="userid" disabled type="text" name="userid"  value="${userCookie.msId }"/>
							</div>
							<div class="mb-3" hidden="true">
								<input id="userimg" disabled type="text" name="userimg" value="${userCookie.profileImage }" />
							</div>
							<div class="mb-3">
								<label for="name" class="fs-4 text-success fw-bolder">Enter
									Your Review :</label>
								<textarea id="reviews-input" class="form-control border-dark"
									style="resize: vertical;" placeholder="Enter your review"
									type="text" name="name"></textarea>
							</div>
							<div class="d-flex flex-column flex-sm-column flex-md-row align-items-center fs-3 justify-content-center">
								<div class="d-flex flex-nowrap reviews-input ms-3">
									<input type="radio" name="stars"  id="1star" value="1 star" class="fs-3 form-check-input"><label
										for="1star">⭐</label>
								</div>
								<div class="d-flex flex-nowrap reviews-input ms-3">
									<input type="radio" name="stars"  id="2star" value="2 stars" class="fs-3 form-check-input"><label
										for="2star">⭐⭐</label>
								</div>
								<div class="d-flex flex-nowrap reviews-input ms-3">
									<input type="radio" name="stars"  id="3star" value="3 stars" class="fs-3 form-check-input"><label
										for="3star">⭐⭐⭐</label>
								</div>
								<div class="d-flex flex-nowrap reviews-input ms-3">
									<input type="radio" name="stars"  id="4star" value="4 stars" class="fs-3 form-check-input"><label
										for="4star">⭐⭐⭐⭐</label>
								</div>
								<div class="d-flex flex-nowrap reviews-input ms-3">
									<input type="radio" name="stars"  id="5star" value="5 stars" class="fs-3 form-check-input"><label
										for="5star">⭐⭐⭐⭐⭐</label>
								</div>
							</div>
							<div class="text-center mt-4 mb-2">
								<button class="btn btn-outline-success fw-bolder" id="send-reviews" type="button">Send Review</button>
							</div>
						</form>
					</div>
				</div>
			</div>
		</section>

	</main>
	<!-- End #main -->
<script type="text/javascript" src="<c:url value="/resources/assets/js/post-reviews.js"/>"></script>

	<!-- ======= Footer ======= -->
	<%@include file="commons/footer.jsp"%>
	<%@include file="commons/alljs.jsp"%>

</body>

</html>