<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:if test="${empty loginUser }">
	<script>		
		location.href="<%=request.getContextPath() %>/common/loginForm.do";
	</script>
</c:if>


<c:if test="${!empty loginUser }">
	<script>
		location.href="<%=request.getContextPath() %>/index.do"
	</script>
</c:if>
