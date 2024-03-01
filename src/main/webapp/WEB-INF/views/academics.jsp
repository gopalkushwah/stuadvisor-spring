<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
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
					<li class="breadcrumb-item active">Home</li>
				</ol>
			</nav>
		</div>
		<!-- End Page Title -->

		<section class="section dashboard">
			<div class="row">
				<div class="card">
					<div class="card-body text-center p-4">
						
						<h2 class="">
							<span class="text-danger fs-1">S</span>earch <span
								class="text-danger fs-1">F</span>or <span
								class="text-danger fs-1">N</span>otes...
						</h2>
						<div class="d-flex justify-content-center mt-3">
							<div class="border border-2 rounded-3 w-50 p-2">
								<img class="w-75"
									src="<c:url value="/resources/assets/img/stuadvisor1.png"/>" />
							</div>
						</div>

						<div class="d-flex justify-content-center mt-3">

							<form class="d-flex justify-content-center w-75">
								<select
									class="form-control rounded-start-pill me-1 ps-3 border  border-dark"
									id="course">
									<option value="none">Select any course....</option>
									<c:forEach var="cookies" items="${cookie}">
										<c:if test="${cookies.key.equals('courseName')}">
											<c:set var="courseNameCookie" value="${fn:split(cookies.value.value,',')}"/>
											<c:forEach var="courseNameItem" items="${courseNameCookie}">
												<option value="${courseNameItem}">${courseNameItem}</option>
											</c:forEach>
											
										</c:if>
									</c:forEach>
									<c:forEach items="${courseName}" var="course">
										<option value="${course}">${course}</option>
									</c:forEach>
										
								</select>
								<button class="btn btn-outline-dark rounded-end-pill pe-2"
									type="button" id="branch-btn">
									<i class="ri-search-line fs-5"></i>
								</button>

							</form>
						</div>
						<div class="row mt-3">
							<div class="col-sm-12 col-md-12 col-lg-12"
								id="getInnerTextContainer">
								<span class="btn btn-outline-dark rounded-5">B.tech</span> <span
									class="btn btn-outline-dark rounded-5">M.tech</span> <span
									class="btn btn-outline-dark rounded-5">Bsc</span> <span
									class="btn btn-outline-dark rounded-5">B.com</span> <span
									class="btn btn-outline-dark rounded-5">B.Farma</span> <span
									class="btn btn-outline-dark rounded-5">MBA</span>
							</div>
						</div>

					</div>
				</div>

				<div class="card" hidden="true" id="branch-container">
					<div class="card-body">
						<div class="d-flex justify-content-center mt-3">
							<form class="d-flex justify-content-center w-75">
								<input type="text" hidden="true" id="branch-input">
								<div class="row">
									<div
										class="d-flex justify-content-center align-item-center flex-wrap"
										id="set-span"></div>
								</div>
							</form>
						</div>
					</div>
				</div>
				<div class="card" hidden="true" id="sem-container">
					<div class="card-body">
						<div class="d-flex justify-content-center mt-3">
							<form class="d-flex justify-content-center w-75">
								<div class="row">
									<div
										class="d-flex justify-content-center align-item-center flex-wrap"
										id="set-sem-span"></div>
								</div>
							</form>
						</div>
					</div>
				</div>

				<div class="card" hidden="true" id="subject-container">
					<div class="card-body">
						<div class="d-flex justify-content-center mt-3">
							<form class="d-flex justify-content-center w-75">
								<div class="row">
									<div
										class="d-flex justify-content-center align-item-center flex-wrap"
										id="set-sub-span"></div>
								</div>
							</form>
						</div>
					</div>
				</div>
				<div class="row"></div>
			</div>
		</section>

	</main>
	<!-- End #main -->
	<script type="text/javascript"
		src="<c:url value="/resources/assets/js/course-data.js"/>"></script>

	<!-- ======= Footer ======= -->
	<%@include file="commons/footer.jsp"%>
	<%@include file="commons/alljs.jsp"%>

</body>

</html>