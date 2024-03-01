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
	<%@include file="commons/academics-sidebar.jsp"%>

	<main id="main" class="main">

		<div class="pagetitle">
			<h1>Academics</h1>
			<nav>
				<ol class="breadcrumb">
					<li class="breadcrumb-item"><a href="index.html">Academics</a></li>
					<li class="breadcrumb-item active">Study Material</li>
				</ol>
			</nav>
		</div>
		<!-- End Page Title -->

		<section class="section dashboard">
			<div class="row">
					<div class='col-sm-12 col-md-12 col-lg-12'>
				<div class="card p-4">
						<c:forEach items="${studyMaterialDatas}" var="studyMaterial">
							<div class='row mt-3 border border-2 p-4'>
							<div
								class='col-sm-2 col-md-2 col-lg-2 d-flex align-items-center justify-content-center'>
								<img class='w-75 border border-1 rounded-5' alt=''
									src="<c:out value="resources/assets/useruploads/${studyMaterial.createrImage }"/>" />
							</div>
							<div class='col-sm-8 col-md-8 col-lg-8'>
								<h5>
									<strong>${ studyMaterial.title}</strong>
								</h5>
								<p>${studyMaterial.description }</p>
								<p>${ studyMaterial.createrName }</p>
								<p>${studyMaterial.dateCreation.toLocaleString() }</p>
							</div>
							<div
								class='col-sm-1 col-md-1 col-lg-1  d-flex flex-column align-items-center justify-content-center'>
								<button class='btn btn-primary mt-2  pe-4 ps-4'>
									<a href="<c:out value="resources/assets/studymaterialuploads/${studyMaterial.studyMaterialImage }"/>" class='text-white' download="download">Download</a>
								</button>
							</div>
						</div>
						</c:forEach>
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