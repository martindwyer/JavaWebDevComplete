<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Student Tracker App</title>
<link type="text/css" rel="stylesheet" href="css/style.css" >

</head>
<body>

	<div id="wrapper">
		<div id="header">
			<h2>FooBar University</h2>
		</div>		
	</div>

	<div id="container">
		<div id="content">
		
			<input 	type="button" 
					value="Add Student" 
					onClick="window.location.href='add-student-form.jsp'; return false"
					class="add-student-button"
			/>
			<table>
				<tr>
					<th>First Name</th>
					<th>Last Name</th>
					<th>Email Address</th>
					<th>Action</th>
				</tr>

				<c:forEach var="student" items="${STUDENT_LIST}" >
				<tr>
					
					<c:url var="studentLink" value="StudentController">
						<c:param name="command" value="LOAD" />
						<c:param name="studentId" value="${student.id}" />
					</c:url>
					
					<c:url var="deleteLink" value="StudentController">
						<c:param name="command" value="DELETE" />
						<c:param name="studentId" value="${student.id}" />
					</c:url>
					<td>${student.firstName}</td>
					<td>${student.lastName}</td>
					<td>${student.emailAddress}</td>
					<td>
					<a href="${studentLink}"><button>Update</button></a> | 
					<a	href="${deleteLink}" onclick="if (!(confirm('Are you sure you want to delete this student?'))) return false"><button>Delete</button></a></td>
				
				</tr>
				
				</c:forEach>			

			</table>

		</div>

	</div>

</body>
</html>