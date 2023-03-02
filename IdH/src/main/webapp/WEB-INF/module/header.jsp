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
   list-sytle:none;
}

a{
   text-decoration:none;
}

body{
  margin:0;
  padding:0;
}
.main-custom{
  margin:0 auto;
  width:1224px;
  background-color:#eaedf2;
}

.header-custom{
  width:1212px;
}

.logo{
  width:100px;
  height:100px;
}
.main-menu-custom{
  display:flex;
  align-items:center;
  justify-content:space-between;
  background-color:#B7C4CF;
  
}

.menu{
  display:inline-block;
  font-size:18px;
  color:black;
}
.menu:hover{
  color:white;
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
  background: #fff;
  width: 1200px;
  max-height: 56px;
  float: left;
  margin-bottom :15px;
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
   padding: 1.9em 3em 1.2em 1em;
   color: #757c8f;
   text-decoration: none;
   margin: 0 -2px;
  position: relative;
  top: 0px;
  font-size: 15px;
  font-weight: 600;
} 

nav a:hover::before {
   content: ''; /* To generate the box */
   position: absolute;
   top: 0; right: 0; bottom: .5em; left: 0;
   z-index: -1;
   border-bottom: none;
   border-radius: 5px 2px 0 0;
   background: #eaedf2;
   box-shadow: 0 2px hsla(0,0%,100%,.5) inset;
   transform: perspective(6px) rotateX(1.9deg);
   transform-origin: bottom left;
   height: 80px;
  margin-top: -24px;
}

.active-tab::before {
   content: ''; /* To generate the box */
   position: absolute;
  
   top: 0; right: 0; bottom: .5em; left: 0;
   z-index: -10;
   border-bottom: none;
   border-radius: 5px 2px 0 0;
   background: #eaedf2;
   box-shadow: 0 2px hsla(0,0%,100%,.5) inset;
   transform: perspective(6px) rotateX(1.9deg);
   transform-origin: bottom left;
  box-shadow: inset 0px 0px 10px #dadce0;
  height: 80px;
  margin-top: -24px;
}

.active-tab {
  color: #5e9cf7;
  padding: 1.9em 4em 1.2em 1em;
  margin-left: 1px
}
table th{
   font-size:12px;
}
table td{
   font-size:10px;
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
<div class="main-custom">
  <div class="header-custom row">
    <div class="header-logo col-1">
      <div class="logo"><img src="<%=request.getContextPath() %>/resources/img/IdH로고2.jpg"style="max-width: 100%;max-height: 100%;"/></div>
    </div>
    <!-- header종료 -->
    <div class="main-menu-custom col-11">
      <div class="menu"><i class="fa-solid fa-border-all"></i>&nbsp대시보드</div>
      <div class="menu"><i class="fa-solid fa-globe"></i>&nbsp사업관리</div>
      <div class="menu"><i class="fa-solid fa-keyboard"></i>&nbsp요구사항관리</div>
      <div class="menu"><i class="fa-solid fa-screwdriver-wrench"></i>&nbsp프로젝트구성</div>
      <div class="menu"><i class="fa-brands fa-r-project"></i>&nbsp프로젝트</div>
      <div class="menu active"><i class="fa-solid fa-users-line"></i>&nbsp커뮤니케이션</div>
      <div class="menu"><i class="fa-solid fa-bell"></i>&nbsp공지사항</div>
      <div class="menu"><i class="fa-sharp fa-solid fa-book"></i>&nbsp표준관리</div>
    </div>
    <!--main-menu종료 -->
    <div class="col-12 sub-menu">
      <div class="top-menu">
        <nav class="left">
          <a href="#">내 작업</a>
          <a class="selected active-tab" href="#" >업무관리</a>
          <a class="" href="#">회의관리</a>
        </nav>
      </div>
    </div>
  </div>
<decorator:head />
</head>
<body>