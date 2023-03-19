<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="decorator"
	uri="http://www.opensymphony.com/sitemesh/decorator"%>

<!DOCTYPE html>
<!--
This is a starter template page. Use this page to start your new project from
scratch. This page gets rid of all links and provides the needed markup only.
-->
<html lang="kor">
<head>

<style>
#singup:hover>a {
	font-weight: bolder;
}

.login-section {
	width: 400px;
	position: absolute;
	top: 51%;
	left: 51%;
	transform: translate(-50%, -50%);
}

.login-idh {
	width: 99.5vw;
	height: 100vh;
}

.back-img {
	position: relative;
	width: 100%;
	height: 100%;
	background-repeat: no-repeat;
	background-size: contain;
	background-image: url(<%=request.getContextPath()%>/resources/img/logo22.png);
	background-position: center center;
}

ul, li {
	list-sytle: none;
}

a {
	text-decoration: none;
}

body {
	margin: 0 !important;
	padding: 0 !important;
}
</style>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title><decorator:title default="Improved Developer's Hub" /></title>
<!-- 부트스트랩 불러오기 -->
<script
	src="https://cdn.jsdelivr.net/npm/admin-lte@3.1/dist/js/adminlte.min.js"></script>

<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/admin-lte@3.1/dist/css/adminlte.min.css">

<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
<!-- 폰트어썸 -->
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.1/css/all.min.css">

</head>
<body>
	<div class="login-idh">
		<div class="login-form back-img">
			<div class="login-section">


				<form action="login" method="post">

					<div
						style="position: absolute; left: 50%; transform: translate(-54%, -95%)">
						<div class="test" style="width: 250px;">
							<input type="text" class="form-control" name="member_id"
								placeholder="아이디를 입력하세요.">
						</div>

						<br />

						<div class="test" style="width: 250px;">
							<input type="password" class="form-control" name="member_pwd"
								placeholder="패스워드를 입력하세요.">
						</div>
					</div>





					<div
						style="position: absolute; left: 50%; transform: translate(-68%, 90%)"
						id="singup">
						<a href="#" style="color: black; border-bottom: solid 1px black;">회원가입</a>
					</div>
					<br />
					<div
						style="position: absolute; left: 50%; transform: translate(-55%, 150%);">
						<button type="submit" class="btn btn-info"
							style="background: #17A2B8; color: white; width: 300px;">로그인</button>
					</div>


				</form>
			</div>
		</div>

	</div>



	<!-- jQuery -->
	<script
		src="<%=request.getContextPath()%>/resources/bootstrap/plugins/jquery/jquery.min.js"></script>
	<!-- Bootstrap 4 -->
	<script
		src="<%=request.getContextPath()%>/resources/bootstrap/plugins/bootstrap/js/bootstrap.bundle.min.js"></script>
	<!-- AdminLTE App -->
	<script
		src="<%=request.getContextPath()%>/resources/bootstrap/dist/js/adminlte.min.js"></script>
	<!-- common -->
	<script src="<%=request.getContextPath()%>/resources/js/common.min.js"></script>
</body>
</html>