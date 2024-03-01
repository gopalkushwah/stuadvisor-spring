<%@page import="com.stuadvisor.model.UserData"%>
<%@page import="com.stuadvisor.services.SetCookies"%>
<%
	UserData userData = SetCookies.getUserCookie("ehsk75jh5k5dfs5hjflsa75s4f5sd5f5", request);
%>
<c:set var="user" value="<%=userData %>"/>

<header id="header" class="header fixed-top d-flex align-items-center">

	<div class="d-flex align-items-center justify-content-between">
		<a href="index.html" class="logo d-flex align-items-center"> <%-- <img src="<c:url value="/resources/assets/img/logo.png"/>" alt=""> --%>
			<span class="d-none d-lg-block"><span class="text-danger fs-1">S</span>tu<span
				class="text-danger fs-1">A</span>dvisor</span>
		</a> <i class="bi bi-list toggle-sidebar-btn"></i>
	</div>
	<!-- End Logo -->
	
	<ul class="nav" id="head-custom-dropdown" hidden="true">
		<li class="nav-item dropdown"><a class="nav-link dropdown-toggle text-dark"
			data-bs-toggle="dropdown" href="#" role="button"
			aria-expanded="false"><i class="bx bx-link" style="font-size: 1.2rem"></i></a>
			
			<ul class="dropdown-menu">
				<li><a class="dropdown-item" href="${pageContext.request.contextPath }/">Home</a></li>
				<li><a class="dropdown-item" href="${pageContext.request.contextPath }/search-colleges">Search Colleges</a></li>
				<li><a class="dropdown-item" href="${pageContext.request.contextPath }/academics">Academics</a></li>
				<li><a class="dropdown-item" href="${pageContext.request.contextPath }/blogs">Blogs</a></li>
			</ul>
		</li>
	</ul>

	
	<div class="d-flex justify-content-center align-items-center " id="head-custom-nav" hidden="true">
		<ul class="d-flex justify-content-center align-items-center nav">
			<li class="nav-item"><a class="nav-link ms-2" href="${pageContext.request.contextPath }/">Home</a></li>
			<li class="nav-item"><a class="nav-link ms-2" href="${pageContext.request.contextPath }/search-colleges">Search Colleges</a></li>
			<li class="nav-item"><a class="nav-link ms-2" href="${pageContext.request.contextPath }/academics">Academics</a></li>
			<li class="nav-item"><a class="nav-link ms-2" href="${pageContext.request.contextPath }/blogs">Blogs</a></li>
			<c:if test="${user.getMsId()!=null}">
			<li class="nav-item"><a class="nav-link ms-2" href="${pageContext.request.contextPath }/profile">My Account</a></li>
			</c:if>
		
		</ul>
	</div>
	<c:if test="${user.getMsId()!=null}">
			
	<nav class="header-nav ms-auto">
		<ul class="d-flex align-items-center">
			<li class="nav-item dropdown pe-3"><a
				class="nav-link nav-profile d-flex align-items-center pe-0" href="#"
				data-bs-toggle="dropdown"> <img
					src="<c:out value="resources/assets/useruploads/${user.profileImage }"/>"
					alt="Profile" class="rounded-circle"> <span
					class="d-none d-md-block dropdown-toggle ps-2">${user.name }</span>
			</a> <!-- End Profile Iamge Icon -->

				<ul
					class="dropdown-menu dropdown-menu-end dropdown-menu-arrow profile">
					<li class="dropdown-header">
						<h6>${user.name }</h6>
					</li>
					<li>
						<hr class="dropdown-divider">
					</li>

					<li><a class="dropdown-item d-flex align-items-center"
						href="${pageContext.request.contextPath}/profile"> <i class="bi bi-person"></i> <span>My
								Profile</span>
					</a></li>
					<li>
						<hr class="dropdown-divider">
					</li>

					<li><a class="dropdown-item d-flex align-items-center"
						href="${pageContext.request.contextPath}/edit-profile"> <i class="bi bi-gear"></i> <span>Account
								Settings</span>
					</a></li>
					<li>
						<hr class="dropdown-divider">
					</li>
					<li>
						<hr class="dropdown-divider">
					</li>

					<li><a class="dropdown-item d-flex align-items-center"
						href="${pageContext.request.contextPath}/logout"> <i class="bi bi-box-arrow-right"></i> <span>Sign
								Out</span>
					</a></li>

				</ul>
				<!-- End Profile Dropdown Items --></li>
			<!-- End Profile Nav -->

		</ul>
	</nav>
	</c:if>
		
	<!-- End Icons Navigation -->
</header>
<!-- End Header -->
<script>
//Function to handle screen width changes
function handleScreenWidthChange() {
  // Get the current screen width
  	const screenWidth = window.innerWidth;
	const headCustomDropdown = document.getElementById("head-custom-dropdown");
	const headCustomNav = document.getElementById("head-custom-nav");
  // Example: Change the background color when screen width crosses a threshold
  if (screenWidth < 700 ) {
	  headCustomNav.setAttribute("hidden","");
	  headCustomNav.classList.remove("d-flex");
	  headCustomDropdown.removeAttribute("hidden");
  } else {
	  headCustomNav.removeAttribute("hidden")
	  headCustomNav.classList.add("d-flex");
	  headCustomDropdown.setAttribute("hidden","");
  }
}
window.addEventListener('resize', handleScreenWidthChange);
handleScreenWidthChange();
</script>