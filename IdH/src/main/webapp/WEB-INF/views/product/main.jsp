<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>




   
    <div class="row">
<div class="content-parts col-8">
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
              <c:if test="${empty productList}">
              <tr><td colspan="5">데이터가 없습니다.</td></tr>
              </c:if>
              <c:forEach items="${productList }" var="product">
                <tr>
                           <td style="text-align:left;max-width:15%; overflow: hidden; 
                                    white-space: nowrap; text-overflow: ellipsis;">${product.product_number}</td>
                           <td style="text-align:left;max-width: 20%; overflow: hidden; 
                                    white-space: nowrap; text-overflow: ellipsis;">${product.product_title}</td>
                           <td style="text-align:left;max-width: 15%; overflow: hidden; 
                                    white-space: nowrap; text-overflow: ellipsis;">${product.product_member_id}</td>
                           <td style="text-align:left;max-width: 15%; overflow: hidden; 
                                    white-space: nowrap; text-overflow: ellipsis;" ><fmt:formatDate value="${product.product_regdate}" pattern="yyyy-MM-dd"/></td>
                           <c:forEach items="${product.attachList }" var="attach">
                           <td style="text-align:left;max-width: 35%; overflow: hidden; 
                                    white-space: nowrap; text-overflow: ellipsis;">${attach.ano}</td>
                           </c:forEach>
                   </tr>
              </c:forEach>
              </tbody>
               </table>
            </div>
         </div>
      </div>
   </div>
  
 <div class="col-4">
    <div class="card card-info">
   
<div class="card-header">
<h3 class="card-title">협업요청목록</h3>
<div class="card-tools">
<button type="button" class="btn btn-tool" data-card-widget="collapse" title="Collapse">
<i class="fas fa-minus"></i>
</button>
</div>
</div>
<div class="card-body p-0" style="display: block;">
<table class="table">
<thead>
<tr>
<th>협업 산출물</th>
<th>상태</th>
<th></th>
</tr>
</thead>
<tbody>
<tr>
<td>Functional-requirements.docx</td>
<td>49.8005 kb</td>
<td class="text-right py-0 align-middle">
<div class="btn-group btn-group-sm">
<a href="#" class="btn btn-info"><i class="fas fa-eye"></i></a>
<a href="#" class="btn btn-danger"><i class="fas fa-trash"></i></a>
</div>
</td>
</tr><tr>
<td>UAT.pdf</td>
<td>28.4883 kb</td>
<td class="text-right py-0 align-middle">
<div class="btn-group btn-group-sm">
<a href="#" class="btn btn-info"><i class="fas fa-eye"></i></a>
<a href="#" class="btn btn-danger"><i class="fas fa-trash"></i></a>
</div>
</td>
</tr><tr>
<td>Email-from-flatbal.mln</td>
<td>57.9003 kb</td>
<td class="text-right py-0 align-middle">
<div class="btn-group btn-group-sm">
<a href="#" class="btn btn-info"><i class="fas fa-eye"></i></a>
<a href="#" class="btn btn-danger"><i class="fas fa-trash"></i></a>
</div>
</td>
</tr><tr>
<td>Logo.png</td>
<td>50.5190 kb</td>
<td class="text-right py-0 align-middle">
<div class="btn-group btn-group-sm">
<a href="#" class="btn btn-info"><i class="fas fa-eye"></i></a>
<a href="#" class="btn btn-danger"><i class="fas fa-trash"></i></a>
</div>
</td>
</tr><tr>
<td>Contract-10_12_2014.docx</td>
<td>44.9715 kb</td>
<td class="text-right py-0 align-middle">
<div class="btn-group btn-group-sm">
<a href="#" class="btn btn-info"><i class="fas fa-eye"></i></a>
<a href="#" class="btn btn-danger"><i class="fas fa-trash"></i></a>
</div>
</td>
</tr></tbody>
</table>
   <br>                                                       <div class="row">




<div class="col">

<div class="small-box bg-success">
<div class="inner">
<h3>53<sup style="font-size: 20px">%</sup></h3>
<p>Progress</p>
</div>
<div class="icon">
<i class="ion ion-stats-bars"></i>
</div>
<a href="#" class="small-box-footer">More info <i class="fas fa-arrow-circle-right"></i></a>
</div>
</div>

<div class="col">

<div class="small-box bg-warning">
<div class="inner">
<h3>44</h3>
<p>Delay</p>
</div>
<div class="icon">
<i class="ion ion-person-add"></i>
</div>
<a href="#" class="small-box-footer">More info <i class="fas fa-arrow-circle-right"></i></a>
</div>
</div>

<div class="col">

<div class="small-box bg-danger">
<div class="inner">
<h3>65</h3>
<p>Finished </p>
</div>
<div class="icon">
<i class="ion ion-pie-graph"></i>
</div>
<a href="#" class="small-box-footer">More info <i class="fas fa-arrow-circle-right"></i></a>
</div>
</div>

</div>
     


  
      <!--row종료-->
    </div>
   
  </div>
  
  </div>
  <!--content종료-->

<!--main(container)종료 -->


</div>
