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
					<li class="breadcrumb-item active">Post Blogs</li>
				</ol>
			</nav>
		</div>
		<!-- End Page Title -->

		<section class="section dashboard">
			<div class="row">
				<div class="col-sm-12 col-md-12 col-lg-12 ">
					<div class="card">
						<div class="card-body">
							<h3 class=" mt-3 text-center">
								<strong><span class="fs-1 text-danger">P</span>ost <span
									class="fs-1	 text-danger">B</span>logs</strong>
							</h3>
							<form>
								<div class="mb-3">
									<label for="title" class="fs-4"><strong>Blog Title:</strong></label> 
									<input id="title" class="form-control border-dark"
										placeholder="Write Blog Title Here..." type="text" />
								</div>
								<div class="mb-3">
									<label  class="fs-4"><strong>Select Blog Category:</strong></label> 
									<select class="form-control border-dark" id="category">
										<option value="select">Select any Category</option>
										<option value="education">Education</option>
										<option value="sports">Sports</option>
										<option value="technology">Technology</option>
										<option value="travel">Travel</option>
										<option value="health and wellness">Health and Wellness</option>
										<option value="food and cooking">Food and Cooking</option>
										<option value="fashion and beauty">Fashion and Beauty</option>
										<option value="lifestyle">Lifestyle</option>
										<option value="finance and money">Finance and Money</option>
										<option value="entertainment">Entertainment</option>
										<option value="diy and crafts">DIY and Crafts</option>
										<option value="parenting">Parenting</option>
										<option value="science">Science</option>
										<option value="business and entrepreneurship">Business and Entrepreneurship</option>
										<option value="home decor">Home Decor</option>
										<option value="fitness and exercise">Fitness and Exercise</option>
										<option value="photography">Photography</option>
										<option value="gaming">Gaming</option>
										<option value="music">Music</option>
										<option value="news and current events">News and Current Events</option>
									</select>
								</div>
								<input id="username" hidden="true" type="text" value="${userCookie.name }" /> 
								<input id="userid" hidden="true" type="text" value="${userCookie.msId }"/> 
								<input id="userImg"	hidden="true" type="text" value="${userCookie.profileImage }"/>

							
							
							</form>
							<!-- Quill Editor Default -->
							<label for="description" class="fs-4"><strong>Blog Description:</strong></label> 
							<div class="quill-editor-default"></div>
							<!-- End Quill Editor Default -->
							<div class="text-center mt-3">
								<button class="btn btn-outline-success pe-4 ps-4" type="button" id="blogs-btn">
									Post Blog
								</button>
							</div>
						</div>
					</div>
				</div>
			</div>
		</section>

	</main>
	<!-- End #main -->
<script type="text/javascript" src="<c:url value="/resources/assets/js/post-blogs.js"/>"></script>

	<!-- ======= Footer ======= -->
	<%@include file="commons/footer.jsp"%>
	<%@include file="commons/alljs.jsp"%>

</body>

</html>