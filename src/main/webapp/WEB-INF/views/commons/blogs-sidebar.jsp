
  <aside id="sidebar" class="sidebar">

    <ul class="sidebar-nav" id="sidebar-nav">

      <li class="nav-item">
        <a class="nav-link " href="${pageContext.request.contextPath }/blogs">
          <i class="bi bi-search"></i>
          <span>Search</span>
        </a>
      </li><!-- End Dashboard Nav -->
      <li class="nav-item">
        <a class="nav-link " href="${pageContext.request.contextPath }/trending-blogs">
          <i class="ri-bar-chart-grouped-fill"></i>
          <span>Trending Blogs</span>
        </a>
      </li><!-- End Dashboard Nav -->
      <li class="nav-item">
        <a class="nav-link " href="${pageContext.request.contextPath }/education-blogs">
          <i class="ri-community-line"></i>
          <span>Educational Blogs</span>
        </a>
      </li><!-- End Dashboard Nav -->
      <li class="nav-item">
        <a class="nav-link " href="${pageContext.request.contextPath }/other-blogs">
          <i class="ri-more-fill"></i>
          <span>Other</span>
        </a>
      </li><!-- End Dashboard Nav -->
      <li class="nav-item">
        <a class="nav-link " href="${pageContext.request.contextPath }/request-blog">
          <i class="ri-hand-heart-line"></i>
          <span>Request Blog</span>
        </a>
      </li><!-- End Dashboard Nav -->

       <%@include file="common-sidebar.jsp" %>
    </ul>

  </aside><!-- End Sidebar-->