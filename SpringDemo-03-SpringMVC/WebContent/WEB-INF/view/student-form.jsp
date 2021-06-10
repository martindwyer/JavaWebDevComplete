<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Student Registration Form</title>
</head>
<body>


<form:form action ="processForm" modelAttribute="student">

First Name:  <form:input path="firstName" />
<br><br>

Last Name:  <form:input path="lastName" />
<br><br>

Country:    <form:select path="country" >
				<form:options items = "${student.countryOptions}" />
			</form:select>
<br><br>
Favorite Programming Language:<br>
				 Java <form:radiobutton path="favoriteLanguage" value="Java" />
				 C# <form:radiobutton path="favoriteLanguage" value="C#" />
				 PHP <form:radiobutton path="favoriteLanguage" value="PHP" />
				 Ruby <form:radiobutton path="favoriteLanguage" value="Ruby" />

<br><br>

Operating System Experience:<br>
				 Linux <form:checkbox path="osExperience" value="Linux" />
				 Mac OS <form:checkbox path="osExperience" value="Mac OS" />
				 MS Windows <form:checkbox path="osExperience" value="MS Windows" />
				 

<br><br>



<input type="submit" value="Submit" />
<br><br>

</form:form>


</body>
</html>