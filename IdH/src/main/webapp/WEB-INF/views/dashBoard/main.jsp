<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>




<c:if test="${ loginUser.member_rank eq 1 }">
	<script>
		alert('임원')
		location.href="<%=request.getContextPath() %>/dashBoard/executives";
	</script>
</c:if>



<c:if test="${ loginUser.member_rank eq 2 }">
	<script>
		location.href="<%=request.getContextPath() %>/dashBoard/teamLeader";
	</script>
</c:if>

<c:if test="${ loginUser.member_rank eq 3 }">
	<script>
		location.href="<%=request.getContextPath() %>/dashBoard/teamMember";
	</script>
</c:if>
