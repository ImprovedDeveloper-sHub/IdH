<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<div class="register-box">
	<div class="card card-outline card-primary">
		<div class="card-header text-center">
			<a href="../../index2.html" class="h1"><b>IdH</b></a>
		</div>
		<div class="card-body">
			<p class="login-box-msg">회원가입</p>
			<form action="../../index.html" method="post">
				<div class="input-group mb-3">
					<input type="text" class="form-control" placeholder="아이디">
					<div class="input-group-append">
						<div class="input-group-text">
							<span class="fas fa-user"></span>
						</div>
					</div>
				</div>
				<div class="input-group mb-3">
					<input type="password" class="form-control" placeholder="비밀번호">
					<div class="input-group-append">
						<div class="input-group-text">
							<span class="fas fa-lock"></span>
						</div>
					</div>
				</div>
				<div class="input-group mb-3">
					<input type="password" class="form-control" placeholder="비밀번호 확인">
					<div class="input-group-append">
						<div class="input-group-text">
							<span class="fas fa-lock"></span>
						</div>
					</div>
				</div>
				<div class="input-group mb-3">
					<input type="name" class="form-control" placeholder="이름">
					<div class="input-group-append">
						<div class="input-group-text">
							<span class="fa-solid fa-address-card"></span>
						</div>
					</div>
				</div>
				<div class="input-group mb-3">
					<input type="email" class="form-control" placeholder="이메일">
					<div class="input-group-append">
						<div class="input-group-text">
							<span class="fas fa-envelope"></span>
						</div>
					</div>
				</div>
				<div class="input-group mb-3">
					<input type="tel" class="form-control" placeholder="전화번호">
					<div class="input-group-append">
						<div class="input-group-text">
							<span class="fa-solid fa-phone"></span>
						</div>
					</div>
				</div>



				<div class="col-4">
					<button type="submit" class="btn btn-primary btn-block"
						style="width: 300px;">회원가입</button>
				</div>
		</div>
		</form>
	</div>

</div>
</div>


<div class="card">				
				<div class="register-card-body">
				<p class="login-box-msg">회원가입</p>
				
					<form role="form" class="form-horizontal" role="form" method="post"
					action="regist" name="registForm">
					
					<div class="input-group mb-3">
					<input type="text" class="form-control" placeholder="아이디">
					<div class="input-group-append">
					<input name="id" onkeyup="this.value=this.value.replace(/[\ㄱ-ㅎㅏ-ㅣ가-힣]/g, &#39;&#39;);"
								type="text" class="form-control" id="id" placeholder="13글자 영문자,숫자 조합">
								<span class="input-group-append-sm">	
									<button type="button" onclick="idCheck_go();"  class="btn btn-info btn-sm btn-append">중복확인</button>
								</span>
					
							<span class="fas fa-user"></span>
					</div>
				</div>
					
					
					
					
											
						  <div class="form-group row">
							 <label for="id" class="col-sm-3" style="font-size:0.9em;" >
							 	<span style="color:red;font-weight:bold;">*</span>아이디</label>	
							<div class="col-sm-9 input-group input-group-sm">
								<input name="id" onkeyup="this.value=this.value.replace(/[\ㄱ-ㅎㅏ-ㅣ가-힣]/g, &#39;&#39;);"
								type="text" class="form-control" id="id" placeholder="13글자 영문자,숫자 조합">
								<span class="input-group-append-sm">	
									<button type="button" onclick="idCheck_go();"  class="btn btn-info btn-sm btn-append">중복확인</button>
								</span>								
							</div>								
						</div>
						<div class="form-group row">
							<label for="pwd" class="col-sm-3" style="font-size:0.9em;">
								<span style="color:red;font-weight:bold;">*</span>패스워드</label>
							<div class="col-sm-9 input-group-sm">								
								<input class="form-control" name="pwd" type="password" class="form-control" id="pwd"
										placeholder="20글자 영문자,숫자,특수문자 조합" />
							</div>
							
						</div>
						<div class="form-group row">
							<label for="name" class="col-sm-3" style="font-size:0.9em;">
								<span style="color:red;font-weight:bold;">*</span>이 름</label>
							<div class="col-sm-9 input-group-sm">								
								<input class="form-control" name="name" type="text" class="form-control" id="name"
										placeholder="이름을 입력하세요"
										onkeyup="this.value=this.value.trim();" />
							</div>
							
						</div>				
						<div class="form-group row">
							<label for="email" class="col-sm-3" style="font-size:0.9em;">이메일</label>
							<div class="col-sm-9 input-group-sm">
								<input name="email" type="email" class="form-control" id="email"
										placeholder="example@naver.com">
							</div>
						</div>
						<div class="form-group row">
							<label for="phone" class="col-sm-3 control-label">전화번호</label>
							<div class="col-sm-9">	
								<div class="input-group-sm">
									<select style="width:75px;" name="phone" id="phone" class="form-control float-left">
										<option value="">-선택-</option>
										<option value="010">010</option>
										<option value="011">011</option>
										<option value="017">017</option>
										<option value="018">018</option>
									</select>							
									<label class="float-left" style="padding: 0; text-align: center;">&nbsp;-&nbsp;</label>										
									<input style="width:68px;" name="phone" type="text" class="form-control float-left" />
									<label class="float-left" style="padding: 0; text-align: center;">&nbsp;-</label>
									<input style="width:68px;" name="phone" type="text" class="form-control float-right" />						
								</div>
							</div>
						</div>
						
						<div class="card-footer">
							<div class="row">								
								<div class="col-sm-6">
									<button type="button" id="registBtn" onclick="regist_go();" class="btn btn-info">등&nbsp;&nbsp;록</button>
							 	</div>
							 	
							 	<div class="col-sm-6">
									<button type="button" id="cancelBtn" onclick="CloseWindow();"
										class="btn btn-default float-right">&nbsp;&nbsp;&nbsp;취 &nbsp;&nbsp;소&nbsp;&nbsp;&nbsp;</button>
								</div>
							
							</div>
						</div>
					</form>					
				</div><!-- register-card-body -->
			</div>



<script>
function regist_go(){
	var uploadCheck = $('input[name="checkUpload"]').val();  	
	}
	if(!$('input[name="id"]').val()){
	    alert("아이디는 필수입니다.");
	    return;
	}
	if($('input[name="id"]').val()!=checkedID){
	    alert("아이디는 중복 확인이 필요합니다.");
	    return;
	}
	if(!$('input[name="pwd"]').val()){
	   alert("패스워드는 필수입니다.");
	   return;
    }
	if(!$('input[name="name"]').val()){
       alert("이름은 필수입니다.");
       return;
    }
	if(!$('input[name="email"]').val()){
	   alert("이메일은 필수입니다.");
	   return;
	}
    
	var form = $('form[role="form"]');
	form.submit();
}
</script>

<script>



<!-- 아이디 중복체크 -->
var checkedID ="";
function idCheck_go(){
	//alert("id check btn click");
	
	var input_ID=$('input[name="id"]');
	
	if(!input_ID.val()){
       alert("아이디를 입력하시오");
       input_ID.focus();
       return;
	}
	
	 $.ajax({
		 url : "idCheck.do?id="+input_ID.val().trim(),    	 	
    	 success : function(result){
    	
    	  console.log(result);
   		  if(result.toUpperCase() == "DUPLICATED"){
                 alert("중복된 아이디 입니다.");
                 $('input[name="id"]').focus();
   		  }else{
              alert("사용가능한 아이디 입니다.");
              checkedID=input_ID.val().trim();
              $('input[name="id"]').val(input_ID.val().trim());             
           } 
    	 },
    	 error:function(error){
    		 AjaxErrorSecurityRedirectHandler(error.status);	
    	 }
	 });
}
</script>
