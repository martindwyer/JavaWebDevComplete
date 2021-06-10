<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Hello World</title>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/resources/css/my-test.css">

</head>
<body>

	<h1>Hello World of Spring</h1>
	<br>
	<br> Student Name: ${param.studentName}

	<br>
	<br>

	<div id="message">The message: ${message}</div>
	
	<br>
	<br>

	<img src="${pageContext.request.contextPath}/resources/images/spring-logo.png"> 

	<script
		src="${pageContext.request.contextPath}/resources/js/simple-test.js"></script>
</body>
</html>