<%@page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@page session="true"
	import="java.util.*, com.bit.java54th.softdrink.doore.dao.*"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description"
	content="Bootbusiness | Short description about company">
<meta name="author" content="Your name">
<title>Bootbusiness | Give unique title of the page here</title>
<!-- Bootstrap -->
<link href="css/bootstrap.min.css" rel="stylesheet">
<!-- Bootstrap responsive -->
<link href="css/bootstrap-responsive.min.css" rel="stylesheet">
<!-- Font awesome - iconic font with IE7 support -->
<link href="css/font-awesome.css" rel="stylesheet">
<link href="css/font-awesome-ie7.css" rel="stylesheet">
<!-- Bootbusiness theme -->
<link href="css/boot-business.css" rel="stylesheet">
<style>
div.widget-header {
	
}
left
</style>
</head>
<body>
	<!-- Start: HEADER -->
	<header>
		<!-- Start: Navigation wrapper -->

		<!-- End: Navigation wrapper -->
	</header>
	<!-- End: HEADER -->
	<!-- Start: MAIN CONTENT -->
	<div class="content">
		<div class="container">
			<div class="page-header">
				<h1>내정보관리</h1>
			</div>
			<div class="row">
				<div class="span6 offset4">
					<h4 class="widget-header">
						<div class="pull-left">
							<a href="#">내정보</a>
						</div>
						<div class="pull-left">
							<a href="#">회원탈퇴</a>
						</div>
					</h4>
					<div class="widget-body">
						<div class="left-align">

							<form action="<c:url value='/action/customer?todo=update'/>" method="post">
							<b>Email : </b><b>${customerVO.customerEmail}</b>
							<p></p>
							
							<b>Name : </b>
							<input type="text" name="customerName" placeholder="${customerVO.customerName}">
							<input type="submit" value="OK" class="btn btn-primary btn-large">
							<p></p>
							
							<p></p>
							<b>Password : </b><input type="password" name="customerPassword" value="12345">
							<input type="submit" value="OK" class="btn btn-primary btn-large">
							<p></p>
							
							<p></p>
							<b>Registry : </b><b>${customerVO.customerRegistry}</b>
							</form>
							
							
							
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- End: MAIN CONTENT -->
	<!-- Start: FOOTER -->
	<footer>

		<div class="span2">

			<p>&copy; 2012-3000 Bootbusiness, Inc. All Rights Reserved.</p>
		</div>
	</footer>
	<!-- End: FOOTER -->
	<script type="text/javascript" src="js/jquery.min.js"></script>
	<script type="text/javascript" src="js/bootstrap.min.js"></script>
	<script type="text/javascript" src="js/boot-business.js"></script>
</body>
</html>