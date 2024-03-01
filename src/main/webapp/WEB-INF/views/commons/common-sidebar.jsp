<c:forEach items="${cookie }" var="cookies">
	<c:if test='${cookies.key.equals("ehsk75jh5k5dfs5hjflsa75s4f5sd5f5")}'>
		<c:set var="valid" value="true1" />
	</c:if>
</c:forEach>

<li class="nav-heading">Pages</li>
<c:if test="${valid.equals('true1')}">
	<li class="nav-item"><a class="nav-link collapsed"
		href="${pageContext.request.contextPath }/profile"> <i
			class="bi bi-person"></i> <span>Profile</span>
	</a></li>
	<!-- End Profile Page Nav -->
</c:if>


<c:if test="${!valid.equals('true1')}">
	<li class="nav-item"><a class="nav-link collapsed"
		href="${pageContext.request.contextPath }/signup"> <i
			class="bi bi-card-list"></i> <span>Sign Up</span>
	</a></li>
	<!-- End Register Page Nav -->

	<li class="nav-item"><a class="nav-link collapsed"
		href="${pageContext.request.contextPath }/login"> <i
			class="bi bi-box-arrow-in-right"></i> <span>Sing In</span>
	</a></li>
	<!-- End Login Page Nav -->
</c:if>

<li class="nav-item"><a class="nav-link collapsed"
	href="${pageContext.request.contextPath}/"> <i class="bi bi-house"></i>
		<span>Home</span>
</a></li>


<c:if test="${valid.equals('true1')}">
	<li class="nav-item"><a class="nav-link collapsed" href="${pageContext.request.contextPath}/logout">
			<i class="bx bx-log-out"></i><span>Sign Out</span>
		</a></li>
</c:if>


<!-- End Login Page Nav -->