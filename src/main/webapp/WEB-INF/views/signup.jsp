<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page isELIgnored="false"%>
<!DOCTYPE html>
<html lang="en">

<head>
<%@include file="commons/head.jsp"%>
<style>
.modal {
	--bs-modal-width: 850px !important;
}
</style>
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
	<main id="main" class="main">

		<div class="pagetitle">
			<h1>Account</h1>
			<nav>
				<ol class="breadcrumb">
					<li class="breadcrumb-item"><a
						href="${pageContext.request.contextPath }/profile">Account</a></li>
					<li class="breadcrumb-item active">Sign Up</li>
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
									<strong> <span class="fs-2 text-danger">B</span>ecome
										<span class="fs-2 text-danger">t</span>he <span
										class="fs-2 text-danger">P</span>art <span
										class="fs-2 text-danger">o</span>f <span
										class="fs-2 text-danger">O</span>ur <span
										class="fs-2 text-danger">C</span>ommunity
									</strong>
								</h5>
							</div>
							<form id="form-1">
								<div class="row">
									<div class="col-sm-6 col-md-6 col-lg-6">
										<label for="username">Full Name: <span
											class="text-danger fs-5">*</span></label> <input type="text"
											class="form-control border-dark border-2 mb-4" id="username"
											name="name" /> <label for="usermobile">Mobile: <span
											class="text-danger fs-5">*</span></label> <input type="text"
											class="form-control border-dark border-2 mb-4"
											id="usermobile" name="mobile" /> <label for="useremail">Email:
											<span class="text-danger fs-5">*</span>
										</label> <input type="email"
											class="form-control border-dark border-2 mb-4" id="useremail"
											name="email" />
									</div>
									<div class="col-sm-6 col-md-6 col-lg-6">
										<label for="useraddress">Address: <span
											class="text-danger fs-5">*</span></label> <input type="text"
											class="form-control border-dark border-2 mb-4"
											id="useraddress" name="useraddress" /> <label
											for="userpassword">Password: <span
											class="text-danger fs-5">*</span></label> <input type="password"
											class="form-control border-dark border-2 mb-4"
											id="userpassword" name="userpassword" /> <label
											for="userconfpassword">Confirm Password: <span
											class="text-danger fs-5">*</span></label> <input type="password"
											class="form-control border-dark border-2 mb-4"
											id="userconfpassword" name="userconfpassword" />
									</div>
								</div>
								<div class="row">
									<div class="col-12">
										<h5>
											<strong> <span class="text-danger">Please
													Select Gender</span></strong>
										</h5>
										<div id="gender-container">

											<label for="male">Male : <span
												class="text-danger fs-5">*</span></label> <input type="radio"
												class="border-dark border-2 me-4" id="male" name="gender" value="male" />

											<label for="female">Female : <span
												class="text-danger fs-5">*</span></label> <input type="radio"
												class="border-dark border-2 me-4" id="female" name="gender"  value="female"/>

											<label for="other">Others : <span
												class="text-danger fs-5">*</span></label> <input type="radio"
												class="border-dark border-2 me-4" id="other" name="gender" value="other" />
										</div>
									</div>
								</div>
								<div class="row mt-3">
									<div class="col-12">
										<h5>
											<strong> <a class="text-primary fs-6"
												style="cursor: pointer;" data-bs-toggle="modal"
												data-bs-target="#staticBackdrop">Terms and Conditions of
													Use for StuAdvisor</a>

											</strong>
										</h5>
										<div class="form-check form-switch mt-3">
											<label class="form-check-label" for="flexSwitchCheckChecked">Accept
											</label> <input class="form-check-input" type="checkbox"
												id="flexSwitchCheckChecked" checked="">
										</div>
									</div>
								</div>
								<div class="text-center">
									<button class="btn btn-outline-dark mb-2" type="button"
										id="signup-btn">Sign Up</button>
									<p>
										Already a User <a href="login">Sign In</a> | Go Home <a
											href="${pageContext.request.contextPath }/">Home</a>
									</p>
								</div>
							</form>

							<div class="modal fade" id="staticBackdrop"
								data-bs-backdrop="static" data-bs-keyboard="false" tabindex="-1"
								aria-labelledby="staticBackdropLabel" aria-hidden="true">
								<div class="modal-dialog modal-dialog-scrollable">
									<div class="modal-content">
										<div class="modal-header">
											<h1 class="modal-title fs-5" id="staticBackdropLabel">Terms
												and Conditions of Use for StuAdvisor</h1>
											<button type="button" class="btn-close"
												data-bs-dismiss="modal" aria-label="Close"></button>
										</div>
										<div class="modal-body">
											<p>Last Updated: [Date]</p>
											<h4>1. Acceptance of Terms</h4>
											<p>1.1 By accessing or using the StuAdvisor website (the
												"Website"), you agree to comply with and be bound by these
												Terms and Conditions of Use ("Terms"). If you do not agree
												with these Terms, please do not use the Website.</p>
											<h4>2. Use of the Website</h4>
											<p>2.1 StuAdvisor provides an online platform for
												educational guidance and information purposes only. The
												information on this Website is subject to change without
												notice.</p>
											<p>2.3 You are responsible for maintaining the
												confidentiality of your account credentials and are liable
												for any activities that occur under your account.</p>
											<h4>3. User Content</h4>
											<p>3.1 Users may submit content, including text, images,
												and other materials, to the Website ("User Content").</p>
											<p>3.2 By submitting User Content to StuAdvisor, you
												grant us a non-exclusive, worldwide, royalty-free, and
												transferable license to use, reproduce, distribute, and
												display your User Content on the Website.</p>
											<p>3.3 You are solely responsible for your User Content,
												and it must not violate any third-party rights, including
												copyright, trademark, privacy, or other proprietary rights.</p>
											<h4>4. Intellectual Property</h4>
											<p>4.1 All content on the Website, including text,
												graphics, logos, images, and software, is the property of
												StuAdvisor or its licensors and is protected by copyright
												and other intellectual property laws.</p>
											<p>4.2 You may not reproduce, modify, distribute, or
												republish any content from this Website without our prior
												written consent.</p>
											<h4>5. Privacy</h4>
											<p>5.1 Your use of the Website is subject to our Privacy
												Policy, which can be found at [Link to Privacy Policy].</p>
											<h4>6. Disclaimers</h4>
											<p>6.1 StuAdvisor provides information and guidance but
												does not guarantee the accuracy, completeness, or
												suitability of the information provided on the Website.</p>
											<p>6.2 StuAdvisor does not endorse or recommend any
												specific institutions, courses, or services mentioned on the
												Website.</p>
											<h4>7. Limitation of Liability</h4>
											<p>7.1 To the fullest extent permitted by law, StuAdvisor
												and its officers, directors, employees, and agents are not
												liable for any direct, indirect, incidental, special, or
												consequential damages resulting from your use or inability
												to use the Website.</p>
											<h4>8. Termination</h4>
											<p>8.1 StuAdvisor reserves the right to terminate or
												suspend your access to the Website, with or without notice,
												for any reason, including but not limited to a breach of
												these Terms</p>
											<h4>9. Governing Law</h4>
											<p>9.1 These Terms are governed by and construed in
												accordance with the laws of [Your Jurisdiction], without
												regard to its conflict of law principles.</p>
											<h4>10. Contact Information</h4>
											<p>10.1 For questions or concerns regarding these Terms
												and Conditions of Use, please contact us at [Contact Email].</p>
											<h4>11. Changes to Terms</h4>
											<p>11.1 StuAdvisor reserves the right to update or modify
												these Terms at any time. We will notify users of any changes
												by posting the revised Terms on the Website with the "Last
												Updated" date.</p>
										</div>

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
	<script src="<c:out value="resources/assets/js/signup.js"/>"></script>
	<!-- ======= Footer ======= -->
	<%@include file="commons/footer.jsp"%>
	<%@include file="commons/alljs.jsp"%>

</body>

</html>