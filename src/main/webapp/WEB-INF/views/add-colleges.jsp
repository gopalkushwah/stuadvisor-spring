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
					<li class="breadcrumb-item active">Add College</li>
				</ol>
			</nav>
		</div>
		<!-- End Page Title -->

		<section class="section dashboard">
			<div class="row">
				<div class="col-sm-12 col-md-12 col-lg-12 ">
					<div class="card">
						<div class="card-body">
							<div class="text-center	p-4">
								<h5>
									<strong> <span class="fs-2 text-danger">A</span>dd
										<span class="fs-2 text-danger">C</span>ollege <span
										class="fs-2 text-danger">T</span>o <span
										class="fs-2 text-danger">H</span>elp<span
										class="fs-2 text-danger">O</span>thers 
									</strong>
								</h5>
							</div>
							<form>
								<div class="row">
									<div class="col-sm-6 col-md-6 col-lg-6">
										<label for="clg-name">College Name: <span
											class="text-danger fs-5">*</span></label> 
										<input type="text"
											class="form-control border-dark border-2 mb-4" id="clg-name"
											name="clg-name" placeholder="IIM Bangalore - Indian Institute of Management, Bangalore"/>
											
										<label for="logo">College Logo: <span
											class="text-danger fs-5">*</span></label> 
										<input type="text"
											class="form-control border-dark border-2 mb-4"
											id="logo" name="logo" placeholder="https://images.collegedunia.com/public/college_data/images/logos/col30730.png?h=80&w=80&mode=stretch"/> 
											
										<label for="clg-location">College Location :
											<span class="text-danger fs-5">*</span>
										</label> <input type="text"
											class="form-control border-dark border-2 mb-4" id="clg-location"
											name="clg-location" placeholder="Bangalore, Karnataka"/>
											
										<label for="clg-web-url">College Website Url: <span
											class="text-danger fs-5">*</span></label> 
										<input type="text"
											class="form-control border-dark border-2 mb-4"
											id="clg-web-url" name="clg-web-url" placeholder="https://www.iimb.ac.in/home"/>
											
										<label for="clg-city">College City: <span
											class="text-danger fs-5">*</span></label> 
										<input type="text"
											class="form-control border-dark border-2 mb-4"
											id="clg-city" name="clg-city" placeholder="bangalore"/>
											
											
										<label	for="clg-state">College State: <span
											class="text-danger fs-5">*</span></label> 
										<input type="text"
											class="form-control border-dark border-2 mb-4"
											id="clg-state" name="clg-state" placeholder="karnataka"/>
											
									</div>
									<div class="col-sm-6 col-md-6 col-lg-6">
										<label for="clg-review">College Reviews: <span
											class="text-danger fs-5">*</span></label> 
										<input type="text"
											class="form-control border-dark border-2 mb-4"
											id="clg-review" name="clg-review" placeholder="https://collegedunia.com/university/25602-iim-bangalore-indian-institute-of-management-bangalore/reviews"/>
											 
										<label
											for="clg-rating">College Rating: <span
											class="text-danger fs-5">*</span></label> 
										<input type="text"
											class="form-control border-dark border-2 mb-4"
											id="clg-rating" name="clg-rating" placeholder="9.1 / 10"/> 
										
										<label
											for="clg-fee">College Fee: <span
											class="text-danger fs-5">*</span></label> 
										<input type="text"
											class="form-control border-dark border-2 mb-4"
											id="clg-fee" name="clg-fee" placeholder="₹ 2,450,000"/>
											
										<label
											for="clg-course">College Course: <span
											class="text-danger fs-5">*</span></label> 
										<input type="text"
											class="form-control border-dark border-2 mb-4"
											id="clg-course" name="clg-course" placeholder="MBA/PGDM- Total Fees (OR) MBA/PGDM- First Year Fees"/>
											
										<label	for="clg-by-course">College By Course: <span
											class="text-danger fs-5">*</span></label> 
										<input type="text"
											class="form-control border-dark border-2 mb-4"
											id="clg-by-course" name="clg-by-course" placeholder="MBA"/>
										
										<input type="text" hidden="true" value="${userCookie.msId }"
											id="userId" name="userId" />
											
									</div>
								</div>
								<div class="text-center">
									<button class="btn btn-outline-success ps-5 pe-5" type="button" id="add-clg-btn">Add College</button>
								</div>
								
							</form>
						</div>
					</div>
				</div>
			</div>
		</section>

	</main>
	<!-- End #main -->
<script src="<c:out value="resources/assets/js/add-user-clg.js"/>"></script>
	
	<!-- ======= Footer ======= -->
	<%@include file="commons/footer.jsp"%>
	<%@include file="commons/alljs.jsp"%>

</body>

</html>