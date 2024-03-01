
  <aside id="sidebar" class="sidebar">

    <ul class="sidebar-nav" id="sidebar-nav">

      <li class="nav-item">
        <a class="nav-link " href="${pageContext.request.contextPath }/search-colleges">
          <i class="bi bi-search"></i>
          <span>Search</span>
        </a>
      </li><!-- End Dashboard Nav -->
      <li class="nav-item">
        <a class="nav-link " href="${pageContext.request.contextPath }/top-colleges">
          <i class="ri ri-arrow-up-double-line"></i>
          <span>Top Colleges</span>
        </a>
      </li><!-- End Dashboard Nav -->
      <li class="nav-item">
        <a class="nav-link " href="${pageContext.request.contextPath }/city-wise-colleges">
          <i class="ri ri-building-line"></i>
          <span>City Wise Search</span>
        </a>
      </li><!-- End Dashboard Nav -->
      <li class="nav-item">
        <a class="nav-link " href="${pageContext.request.contextPath }/course-wise-colleges">
          <i class="ri ri-slideshow-line"></i>
          <span>Course Wise Search</span>
        </a>
      </li><!-- End Dashboard Nav -->
      <li class="nav-item">
        <a class="nav-link " href="${pageContext.request.contextPath }/state-wise-colleges">
          <i class="ri ri-mind-map"></i>
          <span>State Wise Search</span>
        </a>
      </li><!-- End Dashboard Nav -->

      <%@include file="common-sidebar.jsp" %>
    </ul>

  </aside><!-- End Sidebar-->