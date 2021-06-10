<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MVC Demo Two</title>
</head>
<body>
	<table border="1">
		<tr>
			<th>First Name</th>
			<th>Last Name</th>
			<th>Email</th>
		</tr>
		<c:forEach var="student" items="${student_list }">
			<tr>
				<td>${student.firstName }</td>
				<td>${student.lastName }</td>
				<td>${student.emailAddress }</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>