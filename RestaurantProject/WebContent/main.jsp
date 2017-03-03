<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>        
<%@ include file="menu.jsp" %>    
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>หน้าหลัก</title>
</head>
<body>
<h2>หน้าหลัก</h2>

<table>
	<tr>
		<th>รหัสพนักงาน</th>
		<th>ชื่อ-นามสกุล</th>
		<th>ตำแหน่งพนักงาน</th>
		<th>เงินเดือนพนักงาน</th>
	</tr>
	<c:forEach items="${employees }" var="employee">
		<tr>
			<td style="text-align: center;">${employee.id }</td>
			<td>${employee.name }</td>
			<td style="text-align: center;">${employee.position }</td>
			<td style="text-align: center;">${employee.salary }</td>
		</tr>
	</c:forEach>
</table>

</body>
</html>