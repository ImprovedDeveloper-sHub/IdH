<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="decorator" uri="http://www.opensymphony.com/sitemesh/decorator" %>
    

<html lang="kor">
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
  overflow-x:hidden;
  background-color:#F0FBFC !important;
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
	background-color:#dfdfdf !important;
	font-color:black !important;
	font-weight:bold;
}

.card{
	border:solid 2px #16A2B8 !important;
	border-radius: 6.6px !important;
}

.card-title{
	font-size:12px !important;
}

.note-btn{
	width:1.9rem !important;
}

.note-btn>i{
	width:1rem;
}

.note-dropzone card-header{
	background-color:none !important;
}

td-summernote card{
	boarder-radius:0px !important;
}
.card .btn-block{
	width:60px !important;

}


.page-link{
	font-size:3px !important;
	padding : .5rem .75rem;
	
}



</style>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title><decorator:title default="Improved Developer's Hub" /></title>
<!-- 부트스트랩 불러오기 -->
 <link rel="stylesheet" href="<%=request.getContextPath() %>/resources/bootstrap/plugins/summernote/summernote-bs4.min.css">
 
 <link rel="stylesheet" href="<%=request.getContextPath() %>/resources/bootstrap/dist/css/adminlte.min.css">
<!-- 폰트어썸 -->
<link rel="stylesheet"
   href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.1/css/all.min.css">
  
<link rel="stylesheet" href="<%=request.getContextPath() %>/resources/bootstrap/plugins/jquery-ui/jquery-ui.min.css"  />