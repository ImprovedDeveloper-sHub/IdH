<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:if test="${empty loginUser }">
	<script>		
		location.href="<%=request.getContextPath() %>/member/loginForm";
	</script>
</c:if>


<c:if test="${!empty loginUser }">
	<script>
		location.href="<%=request.getContextPath() %>/index"
	</script>
</c:if>

 
<%--  <script>
		location.href="<%=request.getContextPath() %>/index"
</script> --%>