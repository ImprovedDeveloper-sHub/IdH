<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<div style="margin: 0 auto;">
	<div class="content">
		<div class="row">

			<div id="projectLi" class="col-12">
				<br />
				<br />
				<br />
				<br />
				<br />
				<div class="row">

					<c:if test="${empty proceedingProjectList}"><script>alert('프로젝트가 존재하지않습니다.'); history.back();</script></c:if>
					
					<c:forEach items="${proceedingProjectList}" var="project">

						<div class="col-3">
							<div class="info-box bg-warning" onclick="select_project('${project.project_number}')">
								<span class="info-box-icon"><i
									class="fa-solid fa-clipboard"></i></span>
								<div class="info-box-content" >
									<span class="info-box-text">${project.project_name} </span> <span
										class="info-box-number"></span>
									<div class="progress">
										<div class="progress-bar" style="width: ${project.project_percent}%"></div>
									</div>
									<span class="progress-description"> ${project.project_percent}% 진행중 </span>
								</div>

							</div>

						</div>


					</c:forEach>







				</div>
			</div>
		</div>
	</div>
</div>


<script>
function select_project(project_number){
	location.href="selectProject?project_number="+project_number;
}
</script>


