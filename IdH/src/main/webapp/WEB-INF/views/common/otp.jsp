<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<c:set var="path" value="${pageContext.request.contextPath}" />




<div id="sign-body">
	<div class="form-signin">
		<div class="signin-box">
			<div id="member-box" class="login-wrap text-cetner">
				<div class="form-box ">
					<!-- login-top -->
					<div class="login-top">
						<h3 class="mb_10 fw-normal" style="font-weight: bold;">
							OTP인증
						</h3>
					</div>
					<!-- login-top //-->

					<!-- login-form -->
					<div class="login-form">
						<form action="checkotp" onsubmit="return frmCheck();">
							<ul class="login">
								<%-- 
        키 인증 번호 : ${encodedKey } <br>
        바코드 주소 : ${url } <br><br>
         --%>
								<p style="font-weight: bold;">키 인증 번호 :</p>
								<input type="text" class="form-control" name="encodedKey"
									value="${encodedKey }" readonly="readonly" />

								<p style="font-weight: bold;">바코드 주소 :</p>
								<input type="text" class="form-control" value="${QrUrl}"
									readonly="readonly" />
								</br>

								<p style="font-weight: bold;">코드 입력창 :</p>
								<input type="text" class="form-control" id="code" name="code"
									placeholder="코드를 입력해주세요" />
							</ul>
							<input type="submit" class="btn btn-lg btn-dark" value="전송"
								style="margin-top: 10px;">
						</form>
					</div>
					<!-- login-form //-->
				</div>
			</div>
		</div>
	</div>
</div>





<script type="text/javascript">
	$(function() {
		var errorMsg = "${errorMsg}";
		if (errorMsg != "") {
			alert(errorMsg);
		}
	});

	function frmCheck() {
		if ($("#code").val() == "") {
			alert("코드를 입력해주세요.");
			$("#code").focus();
			return false;
		}
	}
</script>