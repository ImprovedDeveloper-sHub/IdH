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
ul,li{
   list-sytle:none !important;
}

a{
   text-decoration:none;
   color:inherit !important;
}

body{
  margin:0;
  padding:0;
}
.main-custom{
  margin:0 auto;
  width:1224px;
  height:100vh !important;
  background-color:#F0FBFC;
  overflow:hidden;
}

.header-custom{
  width:1212px;
}

.logo{
   margin-right:-5px;
   height:60px;
}
.main-menu-custom{
  display:flex;
  align-items:center;
  justify-content:space-between;
  background-color:#16A2B8;
  height:60px;
}
.menu{
  display:inline-block;
  font-size:16px;
  color:white;
}

.menu:hover{
  color:black;
}

.row{
  margin:0 !important;
  padding:0!important;
}

.active{
 color:white;
  font-weight:bold;
}

.top-menu {
  background: #F0FBFC;
  width: 1204.5px;
  max-height: 56px;
  float: left;
  margin-bottom:2px !important;
  text-align:center;
}

nav {
  position: relative;
  z-index: 1;
  white-space: nowrap;
  float: left;
  position: relative;
}

nav a {
  position: relative;
  display: inline-block;
  padding: 0.5em 3em 0.5em 1em;
  color: #757c8f;
  text-decoration: none;
  margin: 0 -2px;
  position: relative;
  top: 0px;
  font-size: 13px;
  font-weight: 600;
  float:center;
} 

.page-link {
   width: 30px;
   height: 30px;
}

input:focus {outline:none;}

nav a:hover::before {
   content: ''; /* To generate the box */
   /* position: absolute;
   top: 0; right: 0; bottom: .1em; left: 0;
   z-index: -1;
   border-bottom:solid 3px black;
   border-radius: 5px 2px 0 0;
   background: #dfdfdf;
   box-shadow: 0 2px hsla(0,0%,100%,.5) inset;
   transform: perspective(6px) rotateX(1.9deg);
   transform-origin: bottom left; 
   height: 35px;
   margin-top: -5px; */
}

nav a:hover{
   text-decoration:underline;
}

.active-tab::before {
   content: ''; /* To generate the box */
   /* position: absolute;
   top: 0; right: 0; bottom: .1em; left: 0;
   border-bottom: solid 3px black;

   background: #eaedf2;
   box-shadow: 0 2px hsla(0,0%,100%,.5) inset;
   transform: perspective(6px) rotateX(1.9deg);
   transform-origin: bottom left;
   box-shadow: inset 0px 0px 10px #dadce0;
   height: 80px;
   margin-top: -24px; */
}

.active-tab {
  color: #F0FBFC;
  
  margin-left: 1px;
}

/* table th{
   font-size:7px;
   padding: 0.3rem !important;
}
table td{
   font-size:10px;
   padding: 0.3rem !important;
} */

card-small-body{
   padding:5px;
}

table th{
   font-size:10px;
   padding:0.5rem !important;
   
}
table td{
   font-size:9px;
   padding:0.4rem !important;
}



.card-header{
   background-color:#16A2B8 !important;
   font-weight:bold !important;
}



/* .card{
   border:solid 2px #16A2B8 !important;
   border-top-radius: 0.5rem;
   border-radius: 0.25rem;
}
 */

.idhs{
   color:black !important;
}

</style>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title><decorator:title default="Improved Developer's Hub" /></title>
<!-- 부트스트랩 불러오기 -->
<!-- <script
   src="https://cdn.jsdelivr.net/npm/admin-lte@3.1/dist/js/adminlte.min.js"></script>

<link rel="stylesheet"
   href="https://cdn.jsdelivr.net/npm/admin-lte@3.1/dist/css/adminlte.min.css">

 -->
  
 
 <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
 <link rel="stylesheet" href="<%=request.getContextPath() %>/resources/bootstrap/plugins/summernote/summernote-bs4.min.css">
 
 <link rel="stylesheet" href="<%=request.getContextPath() %>/resources/bootstrap/dist/css/adminlte.min.css">
<!-- 폰트어썸 -->
<link rel="stylesheet"
   href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.1/css/all.min.css">
<div class="main-custom">
  <div class="header-custom row">
    <div class="header-logo"style="width:6%;">
      <div class="logo"><img src="<%=request.getContextPath() %>/resources/img/logo.jpg"style="width: 100%;height:100%;background-size: cover;"/></div>
    </div>
    <!-- header종료 -->
   <div class="main-menu-custom"style="width:81%;">
         <c:forEach items="${menuList }" var="menu">
          <div class="menu"><a href="javascript:subMenu_go('${menu.mcode}');goPage('<%=request.getContextPath() %>${menu.murl }','${menu.mcode }');anr('${menu.mcode }');" class="nav-link ${menu.mcode }"><i class="fa-solid ${menu.micon}"></i>
          ${menu.mname }</a></div>
         </c:forEach>
    <!-- 
      <div class="menu"><i class="fa-solid fa-border-all"></i>&nbsp대시보드</div>
      <div class="menu"><i class="fa-solid fa-globe"></i>&nbsp사업관리</div>
      <div class="menu"><i class="fa-solid fa-keyboard"></i>&nbsp요구사항관리</div>
      <div class="menu"><i class="fa-solid fa-screwdriver-wrench"></i>&nbsp프로젝트구성</div>
      <div class="menu"><i class="fa-brands fa-r-project"></i>&nbsp프로젝트</div>
      <div class="menu active"><i class="fa-solid fa-users-line"></i>&nbsp커뮤니케이션</div>
      <div class="menu"><i class="fa-solid fa-bell"></i>&nbsp공지사항</div>
      <div class="menu"><i class="fa-sharp fa-solid fa-book"></i>&nbsp표준관리</div>
       -->
    </div>
    
   <div class="bg-info">
            <div class="h-full flex items-center hover:underline px-[10px]">
              <span><i class="fas fa-user-plus"></i></span>
              <span class="hidden lg:block"></span>
              <span class="hidden lg:block">${loginUser.member_id}&nbsp;&nbsp;&nbsp; </span>
              <c:if test="${!empty loginUser}">
              <a href="member/logout" class="h-full flex items-center hover:underline px-[10px]">
              <span><i class="fas fa-sign-in-alt"></i></span>
              <span class="hidden lg:block"></span>
              <span class="hidden lg:block">로그아웃&nbsp;</span>
              </a>
         </c:if>    
         <c:if test="${empty loginUser}">
            <a href="member/login" class="h-full flex items-center hover:underline px-[10px]">
              <span><i class="fas fa-sign-in-alt"></i></span>
              <span class="hidden lg:block"></span>
              <span class="hidden lg:block">로그인</span>
            </a>
         </c:if>     
          
            </div>
          
         
                  
            
         </div>
    
    <!--main-menu종료 -->
    <div class="col-12 sub-menu">
      <div id="subMenuLi" class="top-menu">
         
        <nav id="subMenuList" class="subMenu left">
          
        </nav>
      </div>
    </div>
    
  </div>
<decorator:head />
</head>
<body>