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
	<%@include file="commons/sidebar.jsp"%>

	<main id="main" class="main">

		<div class="pagetitle">
			<h1>Home</h1>
			<nav>
				<ol class="breadcrumb">
					<li class="breadcrumb-item"><a href="index.html">Home</a></li>
					<li class="breadcrumb-item active">Reviews</li>
				</ol>
			</nav>
		</div>
		<!-- End Page Title -->

		<section class="section dashboard">
			<div class="row">
				<div class="col-12">
					<div class="card">
						<div class="card-body">
							<div class="row">
								<div class="col-12 text-center">
									<h4 class="lh-lg ">
										What <span class="fs-2 text-danger ">People</span> Say About
										Us
									</h4>
									<p class="fs-5">
										Your <span class="fs-4 text-danger">Reviews</span> are
										important to develop our community more strong. Reviews help
										people to know more about us
									</p>
								</div>
								<hr class="border border-primary border-1 opacity-50">
							</div>
							<div class="row">
								<div class="col-12 text-center">

									<h3 class="lh-lg">
										Top <span class="text-danger">Reviews</span>
									</h3>
									<div class="row d-flex">

									<div class="d-flex  overflow-x-auto">
										<c:forEach items="${topReviews }" var="topReview">
											<div class="col-12 col-sm-12 col-md-6 col-lg-8 me-5">
												<div class="card  border border-1">
													<div class="card-body p-4">
														<div class="">
														<img
															src="<c:url value="/resources/assets/useruploads/${topReview.userProfileImage }"/>"
															class="rounded-circle border border-2 border-dark mb-3"
															alt="..." style="width: 80px">
															</div>
														<h5>⭐⭐⭐⭐⭐</h5>
														<h5>${topReview.postBy }</h5>
														<p>${topReview.review }</p>
													</div>
												</div>
											</div>
										</c:forEach>
									</div>
									</div>

								</div>
							</div>
							<div class="row">
								<div class="col-12 text-center">

									<h3 class="lh-lg">
										More <span class="text-danger">Reviews</span>
									</h3>

									<div class="row">
										<c:forEach items="${allReviews }" var="allReview">
											<div class="col-sm-12 col-md-12 col-lg-12">
												<div class="card  border border-1">
													<div class="card-body p-4">
														<img
															src="<c:url value="/resources/assets/useruploads/${allReview.userProfileImage}"/>"
															class="rounded-circle border border-2 border-dark mb-3"
															alt="..." style="width: 80px">
														<c:choose>
															<c:when test="${allReview.stars eq '5 stars'}">
																<h5>⭐⭐⭐⭐⭐</h5>
															</c:when>
															<c:when test="${allReview.stars eq '4 stars'}">
																<h5>⭐⭐⭐⭐</h5>
															</c:when>
															<c:when test="${allReview.stars eq '3 stars'}">
																<h5>⭐⭐⭐</h5>
															</c:when>
															<c:when test="${allReview.stars eq '2 stars'}">
																<h5>⭐⭐</h5>
															</c:when>
															<c:otherwise>
																<h5>⭐</h5>
															</c:otherwise>
														</c:choose>
														<h5>${allReview.postBy}</h5>
														<p>${allReview.review}</p>
													</div>
												</div>
											</div>
										</c:forEach>
									</div>
								</div>
							</div>
						</div>
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