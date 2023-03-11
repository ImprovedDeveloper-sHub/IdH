<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


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
	width: 600px;
	display: inline-block;
}

.backgroundimg {
	background-image: url(<%=request.getContextPath()%>/resources/img/로그인화면.jpg);
	background-size: contain;
	background-repeat: no-repeat;
	width: 100%;
	height: 100%;
}
</style>
<div style="margin: 0 auto; width: 1340px; height: 100vh;">
	<div class="backgroundimg">
		<div class="login-form">
			<div class="login">
				<div class="card card-info">
					<div class="card-header" style="background: white; color: black;">
						<h3 class="card-title">로그인</h3>
					</div>


					<form action="login" method="post">
						<div class="card-body">
							<div class="form-group row">
								<label for="id" class="col-sm-2 col-form-label">아이디</label>
								<div class="col-sm-10">
									<input type="text" class="form-control" name="member_id" placeholder="아이디를 입력하세요." >
								</div>
							</div>
							<div class="form-group row">
								<label for="pwd" class="col-sm-2 col-form-label">비밀번호</label>
								<div class="col-sm-10">
									<input type="password" class="form-control" name="member_pwd" placeholder="패스워드를 입력하세요.">
								</div>
							</div>

						</div>

						<div class="card-footer">
							<button type="submit" class="btn btn-info"
								style="background: #17A2B8; color: white;">회원가입</button>
							<button type="submit" class="btn btn-info float-right"
								style="background: #17A2B8; color: white;">로그인</button>
						</div>

					</form>
				</div>
			</div>
		</div>

	</div>
</div>