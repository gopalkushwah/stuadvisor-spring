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
					<li class="breadcrumb-item active">Contact</li>
				</ol>
			</nav>
		</div>
		<!-- End Page Title -->

		<section class="section dashboard">
			<div class="row">
				<div class="card">
					<div class="card-body p-5">
						<h3>
							<span class="fs-1 text-danger">Get</span> in touch
						</h3>
						<hr class="border border-bottom border-danger opacity-100">
						<div class="row p-4">
							<div class="col-sm-6 col-md-4 col-lg-4">
								<h3>
									<i class="bx bx-mail-send"></i> Email
								</h3>
								<p>help.stuadvisor@gmail.com</p>
							</div>
							<div class="col-sm-6 col-md-4 col-lg-4">
								<h3>
									<i class="bx bx-phone-call"></i> Phone
								</h3>
								<p>+91 1400 800 530</p>
							</div>
							<div class="col-sm-6 col-md-4 col-lg-4">
								<h3>
									<i class="bx bxs-edit-location"></i> Address
								</h3>
								<p>Sector A , Indrapuri , Bhopal , Madhya Pradesh</p>
							</div>
						</div>
						<div class="text-center">
							<a
							class="border border-2 rounded-5 p-2 fs-2 icon-link icon-link-hover"
							href="https://www.instagram.com/mr.gopal_kushwah/"><i class=" bx bxl-instagram"></i></a> 
							<a
							class="border border-2 rounded-5 p-2 fs-2 icon-link icon-link-hover"
							href="https://twitter.com/gopalKushwah07"><i class=" bx bxl-twitter"></i></a> 
							<a
							class="border border-2 rounded-5 p-2 fs-2 icon-link icon-link-hover"
							href="https://www.linkedin.com/in/gopalkushwah/"><i class=" bx bxl-linkedin"></i></a> 
							<a
							class="border border-2 rounded-5 p-2 fs-2 icon-link icon-link-hover"
							href="https://github.com/gopalkushwah"><i class=" bx bxl-github"></i></a>

						</div>
					</div>
				</div>
				<div class="card">
					<div class="card-body p-5">
						<h3>
							<span class="fs-1 text-danger">Send</span> us Message
						</h3>
						<hr class="border border-bottom border-danger opacity-100">
						<form class="row g-3">
							<div class="col-md-6">
								<div class="form-floating">
									<input type="text" class="form-control" id="floatingName"
										placeholder="Your Name" value="${userCookie.name }"> 
										<label for="floatingName">Your
										Name</label>
								</div>
							</div>
							<div class="col-md-6">
								<div class="form-floating">
									<input type="email" class="form-control" id="floatingEmail"
										placeholder="Your Email" value="${userCookie.email }"> <label for="floatingEmail">Your
										Email</label>
								</div>
							</div>

							<div class="col-12">
								<div class="form-floating">
									<textarea class="form-control" placeholder="Message"
										id="floatingTextarea" style="height: 100px;"></textarea>
									<label for="floatingTextarea">Message</label>
								</div>
							</div>

							<div class="text-center">
								<button type="button" id="send-message" class="btn btn-outline-success">Send
									Message</button>
								<button type="reset" class="btn btn-secondary">Reset</button>
							</div>
						</form>

					</div>
				</div>
				<div class="card" style="height: 50vh;" >
					<div class="card-body p-4" >
						<iframe
							src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d14662.500615116098!2d77.4531487770454!3d23.25672375735795!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x397c4206867f624f%3A0xe7a20a45699fb32c!2sIndrapuri%2C%20Bhopal%2C%20Madhya%20Pradesh%20462022!5e0!3m2!1sen!2sin!4v1676395806094!5m2!1sen!2sin"
							allowfullscreen="" title="stuadvisor location" loading="lazy"
							referrerpolicy="no-referrer-when-downgrade" class="w-100 h-100" ></iframe>
					</div>
				</div>
			</div>
		</section>

	</main>
	<!-- End #main -->
<script type="text/javascript" src="<c:url value="/resources/assets/js/contact-us.js"/>"></script>

	<!-- ======= Footer ======= -->
	<%@include file="commons/footer.jsp"%>
	<%@include file="commons/alljs.jsp"%>

</body>

</html>