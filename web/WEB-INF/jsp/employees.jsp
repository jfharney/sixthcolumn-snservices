<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Employees</title>
	
	<script type="text/javascript" src='<c:url value="/scripts/jquery-1.4.4.min.js" />'></script>
	
	
	
</head>
<body>

<div>Hello</div>
<%-- 
<table border=1>
	<thead><tr>
		<th>ID</th>
		<th>Name</th>
		<th>Email</th>
	</tr></thead>
	<c:forEach var="employee" items="${employees.employees}">
	<tr>
		<td>${employee.id}</td>
		<td>${employee.name}</td>
		<td>${employee.email}</td>
	</tr>
	</c:forEach>
</table>
--%>

</body>
</html>