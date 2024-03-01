<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page isELIgnored="false"%>
<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="utf-8">
  <meta content="width=device-width, initial-scale=1.0" name="viewport">

  <title>Not Found 404 </title>
  <meta content="" name="description">
  <meta content="" name="keywords">

  <!-- Favicons -->
  <link href="<c:url value='/resources/assets/img/favicon.png'/>" rel="icon"/>
  <link href="<c:url value='/resources/assets/img/apple-touch-icon.png'/>" rel="apple-touch-icon"/>

  <!-- Google Fonts -->
  <link href="https://fonts.gstatic.com" rel="preconnect">
  <link href="https://fonts.googleapis.com/css?family=Open+Sans:300,300i,400,400i,600,600i,700,700i|Nunito:300,300i,400,400i,600,600i,700,700i|Poppins:300,300i,400,400i,500,500i,600,600i,700,700i" rel="stylesheet">

  <!-- Vendor CSS Files -->
  <link href="<c:url value='/resources/vendor/bootstrap/css/bootstrap.min.css'/>" rel="stylesheet"/>
  <link href="<c:url value='/resources/vendor/bootstrap-icons/bootstrap-icons.css'/>" rel="stylesheet"/>
  <link href="<c:url value='/resources/vendor/boxicons/css/boxicons.min.css'/>" rel="stylesheet"/>
  <link href="<c:url value='/resources/vendor/quill/quill.snow.css'/>" rel="stylesheet"/>
  <link href="<c:url value='/resources/vendor/quill/quill.bubble.css'/>" rel="stylesheet"/>
  <link href="<c:url value='/resources/vendor/remixicon/remixicon.css'/>" rel="stylesheet"/>
  
  <!-- Template Main CSS File -->
  <link href="<c:url value='/resources/assets/css/style.css'/>" rel="stylesheet"/>
</head>

<body>

  <main id="main" class="main">
      <section class="section error-404 text-center">
        <h1>404</h1>
        <h2>The page you are looking for doesn't exist.</h2>
        <a class="btn" href="${pageContext.request.contextPath}/">Back to home</a>
        <img src="<c:url value="/resources/assets/img/not-found.svg"/>" class="img-fluid py-5" alt="Page Not Found">
      </section>

    </div>
  </main><!-- End #main -->

  <a href="#" class="back-to-top d-flex align-items-center justify-content-center"><i class="bi bi-arrow-up-short"></i></a>

  <!-- Vendor JS Files -->
  <script src="<c:url value="/resources/assets/vendor/bootstrap/js/bootstrap.bundle.min.js"/>"></script>
  <script src="<c:url value="/resources/assets/vendor/quill/quill.min.js"/>"></script>
  <script src="<c:url value="/resources/assets/vendor/tinymce/tinymce.min.js"/>"></script>
  
  <!-- Template Main JS File -->
  <script src="<c:url value="/resources/assets/js/main.js"/>"></script>

</body>

</html>