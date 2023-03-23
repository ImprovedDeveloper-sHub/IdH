<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<style>
#calendar1 {
	width: 100%;
	height: 88vh;
}

a {
	color: inherit;
	text-decoration: none;
}

#calendar1 button {
	width: 80px;
}

.tbtb {
	width:100%;
	height:22.5vh;
}

.name-td {
	width:25%;
	background-color: #E7E7E7;
	font-width:bold;
	font-size:12px;
	border:1px solid gray;
}

.table-td {
	width:25%;
	font-width:bold;
	font-size:10px;
	border:1px solid gray;
}
</style>									
<table class="tbtb" onclick="location.href='<%=request.getContextPath()%>/business/budget/detail?business_number=${business.business_number}'; " style="cursor: pointer;">
	<tr class="trtr">
		<td class="name-td" style="text-align: center;">사업번호</td>
		<td class="table-td">${business.business_number}</td>
		<td class="name-td" style="text-align: center;">투입인원</td>
		<td class="table-td">${business.business_people}</td>
	</tr>
	<tr class="trtr">
		<td class="name-td" style="text-align: center;">총예산</td>
		<td class="table-td"><fmt:formatNumber value="${business.business_budget}" pattern="#,###" /> 원</td>
		<td class="name-td" style="text-align: center;">사용예산</td>
		<td class="table-td"><fmt:formatNumber value="${business.business_usebudget}" pattern="#,###" /> 원</td>
	</tr>
	<tr class="trtr">
		<td class="name-td" style="text-align: center;">국가지원예산</td>
		<td class="table-td"><fmt:formatNumber value="${business.business_nationbudget}" pattern="#,###" /> 원</td>
		<td class="name-td" style="text-align: center;">회사자체예산</td>
		<td class="table-td"><fmt:formatNumber value="${business.business_companybudget}" pattern="#,###" /> 원</td>
	</tr>
</table>