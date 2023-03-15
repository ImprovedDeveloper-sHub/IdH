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
.login-test {
	margin: 0 auto;
	width: 1340px;
	height: 100vh;
}

.login-form {
	text-align: right;
	max-width: 100%;
	max-height: 100%;
}

.login {
	width: 475px;
	display: inline-block;
	margin-top : 250px;
	margin-right: 13px;
}

.backgroundimg {
	background-image: url(<%=request.getContextPath()%>/resources/img/로그인화면1.jpg);
	background-size: contain;
	background-repeat: no-repeat;
	width: 100%;
	height: 100%;
}

ul, li {
	list-sytle: none;
}

a {
	text-decoration: none;
}

body {
	margin: 0;
	padding: 0;
}

.main-custom {
	margin: 0 auto;
	width: 1224px;
	background-color: #eaedf2;
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

	<div style="margin: 0 auto; width: 1340px; height: 100vh;">
		<div class="backgroundimg">
			<div class="login-form">
				<div class="login">
					<div>


						<form action="login" method="post">
							<div class="card-body">
								<div class="form-group row">
									<label for="id" class="col-sm-3 col-form-label">아이디</label>
									<div class="col-sm-8">
										<input type="text" class="form-control" name="member_id"
											placeholder="아이디를 입력하세요.">
									</div>
								</div>
								<div class="form-group row">
									<label for="pwd" class="col-sm-3 col-form-label">비밀번호</label>
									<div class="col-sm-8">
										<input type="password" class="form-control" name="member_pwd"
											placeholder="패스워드를 입력하세요.">
									</div>
								</div>

							</div>

							<div style="background: white;">
							<div>
								<button type="submit" class="btn btn-info"
									style="background: #17A2B8; color: white; width: 440px; margin-right: 10px;">회원가입</button>
									</div>
									<br/> 
									<div>
								<button type="submit" class="btn btn-info float-right"
									style="background: #17A2B8; width: 440px; margin-right: 10px; color: white;">로그인</button>
							</div>
							</div>

						</form>
					</div>
				</div>
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