<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page isELIgnored="false"%>
<!DOCTYPE html>
<html lang="en">

<head>
<%@include file="commons/head.jsp"%>
<style>
@media screen and (max-width : 570px) {
	img.w-75{
		width : 150px !important;
	}
}
</style>
</head>

<body>

	<!-- ======= Header ======= -->
	<%@include file="commons/header.jsp"%>
	<!-- ======= Sidebar ======= -->
	<%@include file="commons/blogs-sidebar.jsp"%>

	<main id="main" class="main">

		<div class="pagetitle">
			<h1>Blogs</h1>
			<nav>
				<ol class="breadcrumb">
					<li class="breadcrumb-item"><a href="index.html">Blogs</a></li>
					<li class="breadcrumb-item active">Trending Blogs</li>
				</ol>
			</nav>
		</div>
		<!-- End Page Title -->

		<section class="section dashboard">
			<div class="row">
				<div class="col-sm-12 col-md-12 col-lg-12 ">
				<c:forEach items="${ allBlog }" var="blog">
					<div class="card">
						<div class="card-header">
							<div class="row">
								<div class="col-sm-2 col-md-2 col-lg-2 d-flex align-items-center  justify-content-center">
									<div class="border border-1  d-flex align-items-center justify-content-center">
										<img class="w-75" src="<c:out value='resources/assets/useruploads/${blog.userProfileImage}'/>" alt="user profile"/>
									</div>
								</div>
								<div class="col-sm-9 col-md-9 col-lg-9 d-flex align-items-start flex-column">
									 <a data-bs-toggle="collapse" href="#<c:out value='${blog.htmlId}'/>"
										aria-expanded="false" aria-controls="collapseExample" class="fs-5"><c:out value='${blog.title}'/></a>
									<p>Category : <c:out value='${blog.category}'/></p>
									<p>Posted by : <c:out value='${blog.postBy}'/></p>
									<p>Posted on : <c:out value='${blog.postCreation.toLocaleString() }'/></p>
								</div>
								<div class="col-sm-1 col-md-1 col-lg-1 d-flex align-items-center justify-content-center">
									<a data-bs-toggle="collapse" href="#<c:out value='${blog.htmlId}'/>" aria-expanded="false" aria-controls="collapseExample"><i class="ri-add-line fs-2"></i></a>
								</div>
							</div>
						</div>
						<div class="card-body">
							<div class="collapse" id="<c:out value='${blog.htmlId}'/>">
								<div >
									${blog.description}
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