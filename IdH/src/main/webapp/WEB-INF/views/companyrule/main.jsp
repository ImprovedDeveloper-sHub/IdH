<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>




<!--header row종료 -->

<div class="content">
	<div class="row">
		<div class="col-12">
      <div id="content" class="card">
         <div class="card-header">
            <h3 class="card-title">정책관리</h3>
         </div>
            <div class="card-tools"style="justify-content:space-between;display:flex;flex-direction:row-reverse;">
               <div class="input-group input-group-sm" style="width: 270px">
                  <select class="form-control-sm" name="searchType" id="searchType" style="hegith:30px; width:90px !important; border-color:#CED4DA !important;">
                     <option value="tcw"  ${cri.searchType eq 'n' ? 'selected':'' }>전 체</option>
                     <option value="t" ${cri.searchType eq 't' ? 'selected':'' }>제목</option>
                     <option value="w" ${cri.searchType eq 'l' ? 'selected':'' }>수준</option>
                     <option value="c" ${cri.searchType eq 'c' ? 'selected':'' }>내용</option>
                  </select>
                  <input type="text" name="table_search"
                     class="form-control float-right" placeholder="Search">
                  <div class="input-group-append">
                     
                     
                     <button type="submit" class="btn btn-default" onclick="list_go(1)">
                        <i class="fas fa-search"></i>
                     </button>
                  </div>
               </div>
         <button type="button" class="btn btn-block btn-info btn-sm"
            style="width: 80px;">등록</button>
            </div>
         <div id="table-content">
            <div class="card-body table-responsive p-0">
               <table class="table table-hover">
                  <thead class="text-left">
                <tr>
                  <th style="width:15%">번호</th>
                  <th style="width:20%">제목</th>
                  <th style="width:15%">담당자</th>
                  <th style="width:15%">등록일</th>
                  <th style="width:35%">내용</th>
                
                </tr>
              </thead>
              <tbody class="text-left">
              <c:if test="${empty companyruleList}">
              <tr><td colspan="5">데이터가 없습니다.</td></tr>
              </c:if>
              <c:forEach items="${companyruleList }" var="companyrule">
                <tr>
                           <td style="text-align:left;max-width:15%; overflow: hidden; 
                                    white-space: nowrap; text-overflow: ellipsis;">${companyrule.companyrule_number}</td>
                           <td style="text-align:left;max-width: 20%; overflow: hidden; 
                                    white-space: nowrap; text-overflow: ellipsis;">${companyrule.companyrule_title}</td>
                           <td style="text-align:left;max-width: 15%; overflow: hidden; 
                                    white-space: nowrap; text-overflow: ellipsis;">${companyrule.companyrule_member_id}</td>
                           <td style="text-align:left;max-width: 15%; overflow: hidden; 
                                    white-space: nowrap; text-overflow: ellipsis;" ><fmt:formatDate value="${companyrule.companyrule_regdate}" pattern="yyyy-MM-dd"/></td>
                           <td style="text-align:left;max-width: 35%; overflow: hidden; 
                                    white-space: nowrap; text-overflow: ellipsis;">${companyrule.companyrule_content}</td>
                           
                   </tr>
              </c:forEach>
              </tbody>
               </table>
            </div>
         </div>
      </div>
        
   </div>

		<!--row종료-->
	</div>


</div>
<!--content종료-->
