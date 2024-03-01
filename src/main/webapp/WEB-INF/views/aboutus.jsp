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
					<li class="breadcrumb-item active">About</li>
				</ol>
			</nav>
		</div>
		<!-- End Page Title -->

		<section class="section dashboard">
			<div class="row">
				<div class="card">
					<div class="card-body p-3">
						<div class="row mt-2">
							<div class="col-sm-6 col-md-6 col-lg-6">
								<h3>
									About <span class="text-danger fs-1">Us</span>
								</h3>
								<h3>
									<span class="text-danger fs-1">S</span>tu<span
										class="text-danger fs-1">A</span>dvisor
								</h3>
								<p>Welcome to StuAdvisor, your trusted companion on the road
									to academic and career success. At StuAdvisor, we understand
									that every student's educational journey is unique, and we're
									here to provide you with the guidance, resources, and support
									you need to thrive.</p>
								<p>At StuAdvisor, we're committed to your success. We
									believe in the power of education to transform lives and open
									doors to a world of opportunities. Our commitment is reflected
									in our dedication to providing accurate, up-to-date, and
									trustworthy information to help you make informed decisions at
									every stage of your educational journey.</p>
							</div>
							<div class="col-sm-6 col-md-6 col-lg-6">
								<video loop class="w-100" autoplay>
									<source
										src="<c:url value="/resources/assets/videos/animation.mp4"/>"
										type="video/mp4">
								</video>
							</div>
						</div>

						<hr class="border border-bottom border-dark">

						<h1 class="text-danger text-center mb-3">Why Choose Us</h1>
						<div class="row">
							<div class="col-sm-6 col-md-6 col-lg-6">
								<div class="card">
									<div class="card-body ">
										<div class="text-danger fs-5 ">
											<i
												class="ri-home-3-line  border border-2 p-4 bg-white rounded-5 "></i>
										</div>
										<h3 class="text-primary mt-4">Learn at home</h3>
										<p>We provide all the Necessary Content Online so You can
											learn at home</p>
									</div>
								</div>
							</div>

							<div class="col-sm-6 col-md-6 col-lg-6">
								<div class="card">
									<div class="card-body">
										<div class="text-danger fs-5 ">
											<i
												class="ri-search-2-line  border border-2 p-4 bg-white rounded-5 "></i>
										</div>
										<h3 class="text-primary  mt-4">Search best colleges</h3>
										<p>We provide all the Necessary Content Online so You can
											learn at home</p>
									</div>
								</div>
							</div>

							<div class="col-sm-6 col-md-6 col-lg-6">
								<div class="card">
									<div class="card-body">
										<div class="text-danger fs-5 justify-content-center">
											<i
												class="ri-search-2-line  border border-2 p-4 bg-white rounded-5 "></i>
										</div>
										<h3 class="text-primary  mt-4">Search best colleges</h3>
										<p>We provide all the Necessary Content Online so You can
											learn at home</p>
									</div>
								</div>
							</div>

							<div class="col-sm-6 col-md-6 col-lg-6">
								<div class="card">
									<div class="card-body">
										<div class="text-danger fs-5 ">
											<i
												class="ri-graduation-cap-line  border border-2 p-4 bg-white rounded-5 "></i>
										</div>
										<h3 class="text-primary  mt-4">Educational news</h3>
										<p>We provide all the Necessary Content Online so You can
											learn at home</p>
									</div>
								</div>
							</div>

							<div class="col-sm-6 col-md-6 col-lg-6">
								<div class="card">
									<div class="card-body">
										<div class="text-danger fs-5 ">
											<i
												class="ri-school-line  border border-2 p-4 bg-white rounded-5 "></i>
										</div>
										<h3 class="text-primary  mt-4">Academics support</h3>
										<p>We provide all the Necessary Content Online so You can
											learn at home</p>
									</div>
								</div>
							</div>

							<div class="col-sm-6 col-md-6 col-lg-6">
								<div class="card">
									<div class="card-body">
										<div class="text-danger fs-5 ">
											<i
												class="ri-pages-line  border border-2 p-4 bg-white rounded-5 "></i>
										</div>
										<h3 class="text-primary  mt-4">Educational blogs</h3>
										<p>We provide all the Necessary Content Online so You can
											learn at home</p>
									</div>
								</div>
							</div>
						</div>

						<hr class="border border-bottom border-dark">

						<h1 class="text-danger text-center">Our Focus</h1>
						<div class="row">
							<div class="col-sm-6 col-md-6 col-lg-6">
								<h3 class="card-title">Our Focus</h3>
								<p>At StuAdvisor, our unwavering commitment centers around
									one core focus: your educational success. We understand that
									your academic journey is a transformative experience, and we
									are here to ensure that you navigate it with confidence,
									knowledge, and the support you need to excel. Our dedicated
									team, comprehensive resources, and personalized guidance all
									revolve around this central principle.</p>
								<video loop autoplay class="img-fluid w-100">
									<source
										src="<c:url value="/resources/assets/videos/animation2.mp4"/>"></source>
								</video>
							</div>
							<div class="col-sm-6 col-md-6 col-lg-6">

								<h5 class="card-title">Help to find best Colleges</h5>
								<!-- Default Progress Bars-->
								<div class="progress">
									<div class="progress-bar" role="progressbar" style="width: 75%"
										aria-valuenow="25" aria-valuemin="0" aria-valuemax="100"></div>
								</div>
								<h5 class="card-title">Mock Test</h5>

								<div class="progress mt-3">
									<div class="progress-bar" role="progressbar" style="width: 85%"
										aria-valuenow="50" aria-valuemin="0" aria-valuemax="100"></div>
								</div>
								<h5 class="card-title">Free Content</h5>

								<div class="progress mt-3">
									<div class="progress-bar" role="progressbar"
										style="width: 100%" aria-valuenow="75" aria-valuemin="0"
										aria-valuemax="100"></div>
								</div>
								<h5 class="card-title">College Preparation</h5>
								<div class="progress mt-3">
									<div class="progress-bar" role="progressbar" style="width: 90%"
										aria-valuenow="100" aria-valuemin="0" aria-valuemax="100"></div>
								</div>
								<!-- End Default Progress Bars-->

							</div>
						</div>
						<hr class="border border-bottom border-dark">
						<div class="row">
							<div class="col-sm-6 col-md-3 col-lg-3 text-center">
								<div class="card">
									<div class="card-body p-4">
										<h2 class="border-bottom border-danger">5000+</h2>
										<p class="text-success fs-4">College Data</p>
									</div>
								</div>
							</div>
							<div class="col-sm-6 col-md-3 col-lg-3 text-center">
								<div class="card">
									<div class="card-body p-4">
										<h2 class="border-bottom border-danger">10,000+</h2>
										<p class="text-success fs-4">Educational Blogs</p>
									</div>
								</div>
							</div>
							<div class="col-sm-6 col-md-3 col-lg-3 text-center">
								<div class="card">
									<div class="card-body p-4">
										<h2 class="border-bottom border-danger">8000+</h2>
										<p class="text-success fs-4">Study Material</p>
									</div>
								</div>
							</div>
							<div class="col-sm-6 col-md-3 col-lg-3 text-center">
								<div class="card">
									<div class="card-body p-4">
										<h2 class="border-bottom border-danger">2023</h2>
										<p class="text-success fs-4">Supporting Since</p>
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