<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>


</div>
<!-- ./wrapper -->



<form id="jobForm">	
	<input type='hidden' name="page" value="" />
	<input type='hidden' name="perPageNum" value="10"/>
	<input type='hidden' name="searchType" value="" />
	<input type='hidden' name="keyword" value="" />
	<!-- <input type='hidden' name="status" value="" /> -->
</form>
<!-- REQUIRED SCRIPTS -->


<!-- jQuery -->
<script src="<%=request.getContextPath() %>/resources/bootstrap/plugins/jquery/jquery.min.js"></script>
<!-- Bootstrap 4 -->
<script src="<%=request.getContextPath() %>/resources/bootstrap/plugins/bootstrap/js/bootstrap.bundle.min.js"></script>
<!-- AdminLTE App -->
<script src="<%=request.getContextPath() %>/resources/bootstrap/dist/js/adminlte.min.js"></script>
<!-- summernote -->
<script src="<%=request.getContextPath() %>/resources/bootstrap/plugins/summernote/summernote-bs4.min.js"></script>
<!-- common -->
<script src="<%=request.getContextPath() %>/resources/js/common.js"></script>


</body>
</html>