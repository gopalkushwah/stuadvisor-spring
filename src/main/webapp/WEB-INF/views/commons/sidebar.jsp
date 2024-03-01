
  <aside id="sidebar" class="sidebar">

    <ul class="sidebar-nav" id="sidebar-nav">

      <li class="nav-item">
        <a class="nav-link " href="${pageContext.request.contextPath }/">
          <i class="ri ri-home-3-fill"></i>
          <span>Get Started</span>
        </a>
      </li><!-- End Dashboard Nav -->
      <li class="nav-item">
        <a class="nav-link " href="${pageContext.request.contextPath }/reviews">
          <i class="ri ri-article-fill"></i>
          <span>Reviews</span>
        </a>
      </li><!-- End Dashboard Nav -->
      <li class="nav-item">
        <a class="nav-link " href="${pageContext.request.contextPath }/news">
          <i class="ri ri-chat-new-fill"></i>
          <span>News</span>
        </a>
      </li><!-- End Dashboard Nav -->
      <li class="nav-item">
        <a class="nav-link " href="${pageContext.request.contextPath }/about">
          <i class="ri ri-profile-fill"></i>
          <span>About us</span>
        </a>
      </li><!-- End Dashboard Nav -->
      <li class="nav-item">
        <a class="nav-link " href="${pageContext.request.contextPath }/contact">
          <i class="ri ri-contacts-book-fill"></i>
          <span>Contact us</span>
        </a>
      </li><!-- End Dashboard Nav -->

      <%@include file="common-sidebar.jsp" %>

    </ul>

  </aside><!-- End Sidebar-->