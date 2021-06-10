<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Md Bytes Home</title>
</head>
<body>

	<h1>Welcome to Md Bytes</h1>

	<form:form action="${pageContext.request.contextPath}/logout"
		method="POST">

		<hr>

		<!-- display user name and role -->
	
			User: <security:authentication property="principal.username" />
		<br>
		<br>
	
			Role(s): <security:authentication property="principal.authorities" />

		<hr>
		
		
		<security:authorize access="hasRole('MANAGER')">
		<!-- add link to /leaders for managers  -->
		
		<p>
			<a href="${pageContext.request.contextPath}/leaders">Leadership Meeting</a>
			(Only for manager peeps)
		</p>
		
		</security:authorize>
		
		<security:authorize access="hasRole('ADMIN')">
		
		<!-- add link to /systems for admins -->
		
		<p>
			<a href="${pageContext.request.contextPath}/systems">Systems</a>
			(Only for admin peeps)
		</p>
		</security:authorize>

		<input type="submit" value="Logout" />

	</form:form>

</body>
</html>