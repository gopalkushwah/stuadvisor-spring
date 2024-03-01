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
					<!-- <li class="breadcrumb-item active">Dashboard</li> -->
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
									<img alt="" class="img-fluid"
										src="<c:url value="resources/assets/img/student1.jpg"/>">
								</div>
								<div class="col-12 text-center">
									<h3 class="text-danger lh-lg"><strong>Want to Get Help in Academics</strong></h3>
								</div>
								<div class="col-12">
									<p>Navigating the academic challenges of high school and college can be both exciting and daunting. Whether you're looking to excel in your coursework, improve your study skills, or seek guidance on educational planning, StuAdvisor is your trusted partner for academic success. We're here to connect you with the resources and support you need to thrive in your academic journey.</p>
								</div>
								<div class="col-12 text-center">
									<a  class="btn btn-outline-success pe-5 ps-5" href="academics">Start</a>
								</div>
							</div>
						</div>
					</div>
				</div>
				<div class="col-12">
					<div class="card">
						<div class="card-body">
							<div class="row">
								<div class="col-12 text-center">
									<img alt="" class="img-fluid"
										src="<c:url value="resources/assets/img/student2.jpg"/>">
								</div>
								<div class="col-12 text-center">
									<h3 class="text-danger lh-lg"><strong>Search For Your Dream College</strong></h3>
								</div>
								<div class="col-12">
									<p>Embarking on the journey to higher education is an exciting and pivotal moment in your life. The college you choose will shape your academic experience, personal growth, and future career opportunities. To ensure a successful and fulfilling college experience, it's crucial to embark on a well-informed search for your dream colleges. StuAdvisor is here to guide you through this transformative process, providing valuable insights and resources to help you make the right choice.</p>
								</div>
								<div class="col-12 text-center">
									<a  class="btn btn-outline-success pe-5 ps-5" href="search-colleges">Start</a>
								</div>
								
							</div>
						</div>
					</div>
				</div>
				<div class="col-12">
					<div class="card">
						<div class="card-body">
							<div class="row">
								<div class="col-12 text-center">
									<img alt="" class="img-fluid"
										src="<c:url value="resources/assets/img/student3.jpg"/>">
								</div>
								<div class="col-12 text-center">
									<h3 class="text-danger lh-lg"><strong>Read Blogs About Your Queries</strong></h3>
								</div>
								<div class="col-12">
									<p>In the ever-evolving world of education, staying informed and finding answers to your academic questions is crucial. Whether you're a high school student preparing for college, a college student navigating coursework, or someone seeking career advice, StuAdvisor's blog section is your go-to destination. Dive into a treasure trove of insightful articles and blogs curated to address your queries and help you achieve your educational and career goals.</p>
								</div>
								<div class="col-12 text-center">
									<a  class="btn btn-outline-success pe-5 ps-5" href="blogs">Start</a>
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