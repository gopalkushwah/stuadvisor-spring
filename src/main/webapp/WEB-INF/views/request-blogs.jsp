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
	<%@include file="commons/blogs-sidebar.jsp"%>

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
				<c:forEach items="${requestBlogDataList }" var="requestBlogData">
					<div class="card">
						<div class="card-body pt-3">
							<div class="row">
								<div class="col-sm-2 col-md-2 col-lg-2 d-flex align-items-center justify-content-center">
									<img id="image-1" class="w-75 rounded-circle" alt="" src="<c:out value="resources/assets/useruploads/${requestBlogData.userImg }"/>"/>
								</div>
								<div class="col-sm-10 col-md-10 col-lg-10 border-start border-3" >
									<h3>${requestBlogData.title }</h3>
									<p>Request By : ${requestBlogData.userName }</p>
									<p>Request at : ${requestBlogData.creationDate.toLocaleString() }</p>
								</div>
							</div>
						</div>
					</div>
					</c:forEach>
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