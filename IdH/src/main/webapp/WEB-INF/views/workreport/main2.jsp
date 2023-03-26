<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>


<style>
.issue-th thead td {
	font-size: 14px;
}

.issue-th tbody td {
	font-size: 30px;
}
</style>


<div class="content-body row" style="height: 550px;">
	<div class="col-2 text-center">
			<div class="card" style="height: 50%;">
				<div style="height: 50%; border: solid green 3px;">
					<div class="badge-success">승인</div>
					<h2>7</h2>
				</div>
				<!-- <div style="height: 33.3%; border: solid gold 3px;">
					<div class="badge-warning">전체</div>
					<h2>${mytotal }</h2>
				</div> -->
				<div style="height: 50%; border: solid red 3px;">
					<div class="badge-danger">미승인</div>
					<h2>12</h2>
				</div>
			</div>
		</div>
		<div class="col-10">
			<div id="myworkreport-content" class="card"
				style="height: 98%;">
				<div class="card-header bg-info">
					<h3 class="card-title">받은 보고</h3>
				</div>
				<div class="card-tools"
					style="justify-content: space-between; display: flex; flex-direction: row-reverse;margin:3px;">
					<div class="input-group input-group-sm" style="width: 270px">
						<select id="myPerPageNum" name="myPerPageNum"
							style="display: none"><option value="5" selected></option></select>
						<select class="form-control-sm" name="mySearchType"
							id="mySearchType"
							style="hegith: 30px; width: 90px !important; border-color: #CED4DA !important;">
							<option value="tcw" ${cri.searchType eq 'tcw' ? 'selected':'' }>전체</option>
							<option value="t" ${cri.searchType eq 't' ? 'selected':'' }>제목</option>
							<option value="c" ${cri.searchType eq 'c' ? 'selected':'' }>내용</option>
						</select> <input id="myKeyword" type="text" name="myKeyword"
							class="form-control float-right" placeholder="Search">
						<div class="input-group-append">
							<button type="submit" class="btn btn-default"
								onclick="print_myworkreportlist(1)">
								<i class="fas fa-search"></i>

							</button>
						</div>
					</div>
					<button type="button" class="btn btn-block btn-info btn-sm"
					style="width: 80px"
               onclick="workreport_go('workreportEnd2');">결재</button>
				</div>
				<div id="table-content">
					<div class="card-body table-responsive p-0">
						<table class="table table-hover">
							<thead class="text-left myWorkreportThead">
								<tr>
									<th style="width: 20%">제목</th>
									<th style="width: 20%">첨부파일</th>
									<th style="width: 20%">작성일</th>
									<th style="width: 15%">상태</th>
									<th style="width: 15%">승인자</th>
									<th style="width: 10%">승인자</th>
								</tr>
							</thead>
							<tbody class="text-left myWorkreportTbody">
								<c:if test="${empty myWorkreportList}">
									<tr>
										<td colspan="5">데이터가 없습니다.</td>
									</tr>
								</c:if>
								<c:forEach items="${myWorkreportList }" var="workreport">
									<tr>
									
										<td
											style="text-align: left; max-width: 20%; overflow: hidden; white-space: nowrap; text-overflow: ellipsis;"onclick="javascript:OpenWindow('detail.do?from=main&workreport_number=${workreport.workreport_number}','상세보기',600,508);">${workreport.workreport_title}</td>
										<c:if test="${empty workreport.attachList }">
									<td
										style="text-align: left; max-width: 20%; overflow: hidden; white-space: nowrap; text-overflow: ellipsis;"onclick="javascript:OpenWindow('detail.do?from=main&workreport_number=${workreport.workreport_number}','상세보기',600,508);">-</td>										
										</c:if>
										<c:if test="${!empty workreport.attachList }">
									<td
										style="text-align: left; max-width: 20%; overflow: hidden; white-space: nowrap; text-overflow: ellipsis;"onclick="javascript:OpenWindow('detail.do?from=main&workreport_number=${workreport.workreport_number}','상세보기',600,508);"><i class="fa-sharp fa-solid fa-folder" style="color:gold;"></i></td>										
										</c:if>
										<td
											style="text-align: left; max-width: 20%; overflow: hidden; white-space: nowrap; text-overflow: ellipsis;"onclick="javascript:OpenWindow('detail.do?from=main&workreport_number=${workreport.workreport_number}','상세보기',600,508);"><fmt:formatDate
												value="${workreport.workreport_regdate}"
												pattern="yyyy-MM-dd" /></td>
										<td
											style="text-align: left; max-width: 15%; overflow: hidden; white-space: nowrap; text-overflow: ellipsis;"onclick="javascript:OpenWindow('detail.do?from=main&workreport_number=${workreport.workreport_number}','상세보기',600,508);">${workreport.workreport_check eq '1' ? '미승인' : '승인'}</td>
										<td
											style="text-align: left; max-width: 15%; overflow: hidden; white-space: nowrap; text-overflow: ellipsis;"onclick="javascript:OpenWindow('detail.do?from=main&workreport_number=${workreport.workreport_number}','상세보기',600,508);">${workreport.workreport_setter}</td>
										<td
                              style="text-align: left; max-width: 10%; overflow: hidden; white-space: nowrap; text-overflow: ellipsis;"><input type="checkbox" name="workreport" value="${workreport.workreport_number }"></td>
									</tr>
									
								</c:forEach>
							</tbody>
						</table>
					</div>
				</div>
				<div><nav id="paginationNav" aria-label="Navigation">
      <ul class="pagination justify-content-center m-0">
         <li class="page-item">
            <a class="page-link" href="javascript:print_myworkreportlist(1);">
               <i class="fas fa-angle-double-left"></i>
            </a>
         </li>
         <li class="page-item">
            <a class="page-link" href="javascript:print_myworkreportlist(${pageMaker.prev ? pageMaker.startPage-1 : pageMaker.cri.page});">
               <i class="fas fa-angle-left"></i>
            </a>                  
         </li>
         <c:forEach var="pageNum" begin="${pageMaker.startPage }" end="${pageMaker.endPage }" >
   
         <li class="page-item ${pageMaker.cri.page == pageNum?'active':''}">
            <a class="page-link" href="javascript:print_myworkreportlist('${pageNum}');" >${pageNum }</a>
         </li>
         </c:forEach>
         
         <li class="page-item">
            <a class="page-link" href="javascript:print_myworkreportlist(${pageMaker.next ? pageMaker.endPage+1 :pageMaker.cri.page});">
               <i class="fas fa-angle-right" ></i>
            </a>
         </li>
         
         <li class="page-item">
            <a class="page-link" href="javascript:print_myworkreportlist('${pageMaker.realEndPage}');">
               <i class="fas fa-angle-double-right"></i>
            </a>
         </li>   
      </ul>
   </nav></div>
			</div>

		</div>
</div>


<form id="workreportForm" action="" method="POST">   
   <input type="hidden" id=workreportparam name="workreportparam">
   <!-- <input type='hidden' name="status" value="" /> -->
</form>


<c:if test="${from eq 'regist' }">
	<script>
		alert("정상 등록이 되었습니다.");
		window.close();
		window.opener.location.reload();
	</script>
</c:if>
<c:if test="${from eq 'remove' }">
	<script>
		alert("정상 삭제 되었습니다.");
		window.close();
		window.opener.location.reload();
	</script>
</c:if>

<script>
	function print_myworkreportlist(page){
		var jobForm=$('#jobForm');
		jobForm.find("[name='page']").val(page);
		jobForm.find("[name='perPageNum']").val($('select[name="myPerPageNum"]').val());
		jobForm.find("[name='searchType']")
			.val($('select[name="mySearchType"]').val());
		jobForm.find("[name='keyword']")
			.val($('div.input-group>input[name="myKeyword"]').val());
		//alert(jobForm.serialize());
		$.ajax({
			url:'getMyworkreportlist',
			type:"POST",
			data:jobForm.serialize(),
			success:function(data){
				$('#myworkreport-content').html("").html(data);
			},
			error:function(error){
				alert('error');
			}
		});
	}
</script>

<script>
   function workreport_go(url) {
      alert("결재가 완료되었습니다.");
      var workreportArray = new Array();
      $('input:checkbox[name=workreport]:checked').each(function(){
    	  workreportArray.push(this.value);
      });
      $('#workreportparam').val(workreportArray);
      $('#workreportForm').attr("action",url);
   
      $('#workreportForm').submit();
      
   }
</script>
