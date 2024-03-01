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

	<aside id="sidebar" class="sidebar">
		<ul class="sidebar-nav" id="sidebar-nav">
			<%@include file="commons/common-sidebar.jsp"%>
		</ul>
	</aside>
	<!-- End Sidebar-->
	<main id="main" class="main">

		<div class="pagetitle">
			<h1>Account</h1>
			<nav>
				<ol class="breadcrumb">
					<li class="breadcrumb-item"><a
						href="${pageContext.request.contextPath }/profile">Account</a></li>
					<li class="breadcrumb-item active">Sign In</li>
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
									<strong> <span class="fs-2 text-danger">L</span>ets <span
										class="fs-2 text-danger">G</span>et <span
										class="fs-2 text-danger">S</span>tart <span
										class="fs-2 text-danger">I</span>t
									</strong>
								</h5>
							</div>
							<form id="form-1">
								<div class="row">
									<div
										class="d-flex flex-column align-items-center justify-content-center">
										<div class="col-sm-6 col-md-6 col-lg-6">
											<label for="usermobile">Mobile : <span
												class="text-danger fs-5">*</span></label> <input type="text"
												class="form-control border-dark border-2 mb-4"
												id="usermobile" name="usermobile" /> <label for="useremail">Email:
												<span class="text-danger fs-5">*</span>
											</label> <input type="email"
												class="form-control border-dark border-2 mb-4"
												id="useremail" name="useremail" /> <label
												for="userpassword">Password: <span
												class="text-danger fs-5">*</span></label> <input type="password"
												class="form-control border-dark border-2 mb-4"
												id="userpassword" name="userpassword" />
										</div>
									</div>

								</div>
								<div class="text-center">
									<button class="btn btn-outline-dark mb-2" type="button"
										id="signin-btn">Sign In</button>
									<p>
										Don't have an account <a
											href="${pageContext.request.contextPath }/signup">Sign Up</a>
										| Go Home <a href="${pageContext.request.contextPath }/">Home</a>
									</p>
								</div>
							</form>
						</div>
					</div>
				</div>
			</div>
		</section>

	</main>
	<!-- End #main -->
	<script src="<c:out value="resources/assets/js/login.js"/>"></script>

	<!-- ======= Footer ======= -->
	<%@include file="commons/footer.jsp"%>
	<%@include file="commons/alljs.jsp"%>

</body>

</html>