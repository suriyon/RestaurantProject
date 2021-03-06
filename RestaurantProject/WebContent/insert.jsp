<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
<%@ include file="menu.jsp" %>    
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>เพิ่มข้อมูลพนักงาน</title>
</head>
<body>
<h2>เพิ่มข้อมูลพนักงาน</h2>
<form action="EmployeeServlet?action=insert" method="post">
	<table>
		<tr>
			<td>รหัสพนักงาน</td>
			<td>
				<input type="text" name="id" placeholder="S0001" pattern="[S][0-9]{4}"
				title="ขึ้นต้นด้วยตัว S ใหญ่ แล้วตามด้วยตัวเลขอีก 4 หลัก" required="required">
				<c:if test="${not empty checkid }">
					<label style="color: red;">* ${checkid }</label>
				</c:if>
			</td>
		</tr>
		<tr>
			<td>ชื่อ-นามสกุล</td>
			<td>
				<input type="text" name="name" required="required"
				 value="${employee.name }">
			</td>
		</tr>
		<tr>
			<td>ตำแหน่ง</td>
			<td>
				<select name="position">
					<c:if test="${not empty employee }">
						<c:if test="${employee.position == 1 }">
							<option value="1" selected="selected">1. ผู้จัดการร้าน</option>
							<option value="2">2. พ่อครัว</option>
							<option value="3">3. พนักงานเสริฟ</option>
							<option value="4">4. พนักงานขับรถ</option>
						</c:if>
						<c:if test="${employee.position == 2 }">
							<option value="1">1. ผู้จัดการร้าน</option>
							<option value="2" selected="selected">2. พ่อครัว</option>
							<option value="3">3. พนักงานเสริฟ</option>
							<option value="4">4. พนักงานขับรถ</option>
						</c:if>
						<c:if test="${employee.position == 3 }">
							<option value="1">1. ผู้จัดการร้าน</option>
							<option value="2">2. พ่อครัว</option>
							<option value="3" selected="selected">3. พนักงานเสริฟ</option>
							<option value="4">4. พนักงานขับรถ</option>
						</c:if>
						<c:if test="${employee.position == 4 }">
							<option value="1">1. ผู้จัดการร้าน</option>
							<option value="2">2. พ่อครัว</option>
							<option value="3">3. พนักงานเสริฟ</option>
							<option value="4" selected="selected">4. พนักงานขับรถ</option>
						</c:if>
					</c:if>
					<c:if test="${empty employee }">
						<option value="1">1. ผู้จัดการร้าน</option>
						<option value="2">2. พ่อครัว</option>
						<option value="3">3. พนักงานเสริฟ</option>
						<option value="4">4. พนักงานขับรถ</option>
					</c:if>
					
				</select>
			</td>
		</tr>
		<tr>
			<td>เงินเดือน</td>
			<td>
				<input type="text" name="salary" pattern="[0-9]{0,6}"
				 title="กรอกเป็นตัวเลขเท่านั้น ไม่เกิน  6 หลัก" value="${employee.salary }">
			</td>
		</tr>
		<tr>
			<td></td>
			<td>
				<input type="submit" value="เพิ่มข้อมูล">
			</td>
		</tr>
	</table>
</form>
</body>
</html>