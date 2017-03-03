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
<c:if test="${not empty message }">
	<label>${message }</label>
</c:if>
</body>
</html>