<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="java.util.*,com.mdbytes.jsp.tagdemo.Student" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSTL Tag Demo</title>
</head>
<body>

<h1>JSTL Tag Demo</h1>

<%
String[] cities = {"Mumbai","Singapore","Philadelphia"};
pageContext.setAttribute("myCities",cities);
%>


<c:forEach var="tempCity" items="${myCities}">
	${tempCity}<br/>
</c:forEach>
<br/><br/>

<c:set var="stuff" value="<%= new java.util.Date() %>" />

Time on server is ${stuff}

<br/><br/>

<%
List<Student> data = new ArrayList<>();

data.add(new Student("John","Doe",false));
data.add(new Student("Maxwell","Johnson",false));
data.add(new Student("Mary","Public",true));

pageContext.setAttribute("myStudents",data);
%>

<table border="1">
<tr>
<th>First Name</th>
<th>Last Name</th>
<th>Gold Customer</th>
<th>Discount</th>
</tr>
<c:forEach var="tempStudent" items="${myStudents}" >
	<tr>
	<td>${tempStudent.firstName}</td>
	<td>${tempStudent.lastName}</td>
	<td>${tempStudent.goldCustomer}</td>
	<td>
	<c:if test="${tempStudent.goldCustomer}">
		Special Discount
	</c:if>
	<c:if test="${not tempStudent.goldCustomer}">
		No Discount
	</c:if>
	</td>
	
	</tr>
</c:forEach>
</table>
<br/><br/><br/>

<table border="1">
<tr>
<th>First Name</th>
<th>Last Name</th>
<th>Gold Customer</th>
<th>Discount</th>
</tr>
<c:forEach var="tempStudent" items="${myStudents}" >
	<tr>
	<td>${tempStudent.firstName}</td>
	<td>${tempStudent.lastName}</td>
	<td>${tempStudent.goldCustomer}</td>
	<td>
	<c:choose>
		<c:when test="${tempStudent.goldCustomer}">
			Special Discount
		</c:when>
		<c:otherwise>
			No Discount
		</c:otherwise>
	</c:choose>
	</td>
	
	</tr>
</c:forEach>
</table>
<br/><br/><br/>



</body>
</html>