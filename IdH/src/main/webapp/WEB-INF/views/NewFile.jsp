<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>



<!-- CSS start -->

<style>
#content {
   background: #eaedf2;
   position: relative;
   z-index: 10;
}

#table-content {
   background: #fff;
   margin-top: 20px;
   box-shadow: #dcdee3 0px 0px 10px;
}

#table-content table {
   width: 100%;
}

#table-content thead {
   background: #f2f3f5;
}

#table-content thead tr td {
   color: #757e92;
   font-size: 10px;
   text-transform: uppercase;
}

#table-content tbody tr td {
   border-bottom: #eaecee solid 1px;
}

.name-td {
   font-size: 13px;
   font-weight: 600;
   background-color: #E7E7E7;
}

.table-td {
   font-size: 13px;
   color: #64697a;
}

input {
   width: 100%;
   font-size: 13px;
   color: #64697a;
   border: none;
}
</style>

<!-- CSS end -->



<div class="header" style="width: 680px; height: 555px;">
   <div class="card card-info">
      <div class="card-header">
         <h3 class="card-title">요구사항등록</h3>
         <div class="card-tools">
            <div class="input-group input-group-sm" style="width: 150px;">
               <div class="input-group-append"></div>
            </div>
         </div>
      </div>
      <div id="content">
         <div id="table-content">
            <form enctype="multiaprt/form-data" role="form" method="post"
               action="regist" name="registForm">
               <table>
                  <thead>
                     <tr>

                        <td class="name-td" style="width: 15%;">분류</td>
                        <td class="name-td" colspan="3" style="width: 35%;">세부사항</td>
                        <td class="name-td" style="width: 15%;">분류</td>
                        <td class="name-td" style="width: 35%;">세부사항</td>
                     </tr>
                  </thead>
                  <tbody>
                     <tr>
                        <td class="name-td">글번호</td>
                        <td class="table-td"><input type="text" readonly
                           placeholder="요구사항 번호" /></td>
                        <td class="table-td"></td>
                        <td class="table-td"></td>
                        <td class="name-td">발의자</td>
                        <td class="table-td"><input type="text" readonly
                           placeholder="user.id" /></td>
                     </tr>
                     <tr>
                        <td class="name-td">제목</td>
                        <td class="table-td"><input type="text"
                           placeholder="제목을 입력하세요" /></td>
                        <td class="table-td"></td>
                        <td class="table-td"></td>
                        <td class="name-td">등록일</td>
                        <td colspan="5"><input type="text" readonly
                           placeholder="오늘날짜들어갈것" /></td>
                     </tr>
                     <tr>
                        <td class="name-td">중요도</td>
                        <td class="table-td"><input type="text" placeholder="중요도" /></td>
                        <td class="table-td"></td>
                        <td class="table-td"></td>
                        <td class="name-td">관련사업</td>
                        <td colspan="5"><input type="text" readonly
                           placeholder="관련사업" /></td>
                     </tr>
                     <tr>
                        <td class="name-td">프로젝트 팀</td>
                        <td class="table-td"><input type="text"
                           placeholder="프로젝트 팀" /></td>
                        <td class="table-td"></td>
                        <td class="table-td"></td>
                        <td class="name-td">담당자</td>
                        <td colspan="5"><input type="text" readonly
                           placeholder="담당자" /></td>
                     </tr>
                     <tr style="height: 100px;">
                        <td class="name-td">내용</td>
                        <td class="table-td td-summernote" colspan="5"><textarea
                              class="summernote" rows="15" cols="40"
                              style="display: none; width: 500px;"></textarea></td>
                     </tr>


                  </tbody>
               </table>
            </form>
         </div>
      </div>
      <div class="card-tools" style="margin-left: auto">
         <!-- <button type="button" id="tempbtn" class="btn btn-info"
            onclick="regist_go();">임시저장</button> -->
         <button type="button" id="regbtn" class="btn btn-info"
            onclick="regist_go();">등록</button>
         <button type="button" id="close" class="btn btn-info"
            onclick="CloseWindow();">닫기</button>
      </div>
   </div>
</div>
<script>
   window.onload = function() {
      summernote_go($('.summernote'),'<%=request.getContextPath()%>');
   };
</script>

<script>
 function regist_go(){
      
    
      alert('')
      $("form[role='form']").submit();
       
 }
</script>