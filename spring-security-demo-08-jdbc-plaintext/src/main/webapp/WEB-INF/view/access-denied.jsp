<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Access Denied</title>
</head>
<body>

	<h1>Access Denied</h1>
	
	<p>You are not authorized to access this page</p>

	<a href="${pageContext.request.contextPath}/">Back to Home Page</a>

</body>
</html>