<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<!DOCTYPE html>
<html>
<head>
  <!-- =======================================================
    Theme Name: Flexor
    Theme URL: https://bootstrapmade.com/flexor-free-multipurpose-bootstrap-template/
    Author: BootstrapMade.com
    Author URL: https://bootstrapmade.com
  ======================================================= -->
<meta charset="UTF-8">
<title><tiles:getAsString name="title"/></title>
<meta content="width=device-width, initial-scale=1.0" name="viewport">
  <meta content="" name="keywords">
  <meta content="" name="description">

  <!-- Fav and touch icons -->
  <link rel="shortcut icon" href="${pageContext.request.contextPath}/resources/bootstrap/img/icons/favicon.png">
  <link rel="apple-touch-icon-precomposed" sizes="114x114" href="${pageContext.request.contextPath}/resources/bootstrap/img/icons/114x114.png">
  <link rel="apple-touch-icon-precomposed" sizes="72x72" href="${pageContext.request.contextPath}/resources/bootstrap/img/icons/72x72.png">
  <link rel="apple-touch-icon-precomposed" href="${pageContext.request.contextPath}/resources/bootstrap/img/icons/default.png">

  <!-- Google Fonts -->
  <link href="https://fonts.googleapis.com/css?family=Roboto:400,100,300,500,700,900" rel="stylesheet">

  <!-- Bootstrap CSS File -->
  <link href="${pageContext.request.contextPath}/resources/bootstrap/lib/bootstrap/css/bootstrap.min.css" rel="stylesheet">

  <!-- Libraries CSS Files -->
  <link href="${pageContext.request.contextPath}/resources/bootstrap/lib/font-awesome/css/font-awesome.min.css" rel="stylesheet">
  <link href="${pageContext.request.contextPath}/resources/bootstrap/lib/owlcarousel/owl.carousel.min.css" rel="stylesheet">
  <link href="${pageContext.request.contextPath}/resources/bootstrap/lib/owlcarousel/owl.theme.min.css" rel="stylesheet">
  <link href="${pageContext.request.contextPath}/resources/bootstrap/lib/owlcarousel/owl.transitions.min.css" rel="stylesheet">

  <!-- Main Stylesheet File -->
  <link href="${pageContext.request.contextPath}/resources/bootstrap/css/style.css" rel="stylesheet">

  <!--Your custom colour override - predefined colours are: colour-blue.css, colour-green.css, colour-lavander.css, orange is default-->
  <link href="${pageContext.request.contextPath}/resources/bootstrap/css/colour-blue.css" id="colour-scheme" rel="stylesheet">
	
	
  <!-- Required JavaScript Libraries -->
  <script src="${pageContext.request.contextPath}/resources/bootstrap/lib/jquery/jquery.min.js"></script>
  <script src="${pageContext.request.contextPath}/resources/bootstrap/lib/bootstrap/js/bootstrap.min.js"></script>
  <script src="${pageContext.request.contextPath}/resources/bootstrap/lib/owlcarousel/owl.carousel.min.js"></script>
  <script src="${pageContext.request.contextPath}/resources/bootstrap/lib/stellar/stellar.min.js"></script>
  <script src="${pageContext.request.contextPath}/resources/bootstrap/lib/waypoints/waypoints.min.js"></script>
  <script src="${pageContext.request.contextPath}/resources/bootstrap/lib/counterup/counterup.min.js"></script>
  <script src="${pageContext.request.contextPath}/resources/bootstrap/contactform/contactform.js"></script>

  <!-- Template Specisifc Custom Javascript File -->
  <script src="${pageContext.request.contextPath}/resources/bootstrap/js/custom.js"></script>

  <!--Custom scripts demo background & colour switcher - OPTIONAL -->
  <script src="${pageContext.request.contextPath}/resources/bootstrap/js/color-switcher.js"></script>

  <!--Contactform script -->
  <script src="${pageContext.request.contextPath}/resources/bootstrap/contactform/contactform.js"></script>


</head>
<body>
<div id="main">
	<div id="main_header">
		<tiles:insertAttribute name="header"/>
	</div>
	<div id="main_body">
		<tiles:insertAttribute name="body"/>
	</div>
	<div id="main_footer">
		<tiles:insertAttribute name="footer"/>
	</div>
</div>
</body>
</html>