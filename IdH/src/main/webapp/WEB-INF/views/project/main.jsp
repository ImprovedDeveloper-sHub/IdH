<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<style>
body {
	background: #eeeded;
}

.card {
	box-shadow: 0 1px 3px rgba(0, 0, 0, 0.12), 0 1px 2px rgba(0, 0, 0, 0.24);
	transition: all 0.2s ease-in-out;
	box-sizing: border-box;
	margin-top: 10px;
	margin-bottom: 10px;
	background-color: #FFF;
}

.card:hover {
	box-shadow: 0 5px 5px rgba(0, 0, 0, 0.19), 0 6px 6px rgba(0, 0, 0, 0.23);
}

.card>.card-inner {
	padding: 10px;
}

.card .header h2, h3 {
	margin-bottom: 0px;
	margin-top: 0px;
}

.card .header {
	margin-bottom: 5px;
}

.card img {
	width: 100%;
}
</style>

<div style="margin: 0 auto;">
	<div class="content">
		<div class="row">

			<div id="projectLi" class="col-12">
				<br /> <br />
				<div class="row">

					<c:if test="${empty proceedingProjectList}">
						<script>
							alert('프로젝트가 존재하지않습니다.');
							history.back();
						</script>
					</c:if>

					<c:forEach items="${proceedingProjectList}" var="project">

						<div class="col-3">

							<div class="card"
								onclick="select_project('${project.project_number}')">
								<div>
									<div class="image">
									<div style="text-align: center;"><img src="<%=request.getContextPath() %>/resources/img/프로젝트 이미지.jpg"style="width: 100px;height:100px;background-size: cover;"></div>
										
									</div>
									<div class="card-inner">
										<div class="header">
											<span class="info-box-text">${project.project_name} </span> <span
												class="info-box-number"></span>
											<div class="progress">
												<div class="progress-bar"
													style="width: ${project.project_percent}%"></div>
											</div>
										</div>
										<div class="content">
											<span class="progress-description">
												${project.project_percent}% 진행중 </span>
										</div>
									</div>
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
	function select_project(project_number) {
		location.href = "selectProject?project_number=" + project_number;
	}
</script>


