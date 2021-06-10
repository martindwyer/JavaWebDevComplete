<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ page import="java.util.*,com.mdbytes.jsp.tagdemo.Student" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSTL Function Tags</title>
</head>
<body>

<h1>JSTL Function Tag Demo</h1>

<c:set var="data" value="mdbytes" />

length of the string <b>${data}</b>:  ${fn:length(data)}

<br/><br/><br/>

Upper case version of the string <b>${data }</b>:  ${fn:toUpperCase(data) }

<br/><br/><br/>

Does the string <b>${data }</b> with <b>md</b>:  ${fn:startsWith(data,"md")}

<br/><br/><br/>

<c:set var="data" value="Singapore,Tokyo,Mumbai,London" />

<c:set var="citiesArray" value="${fn:split(data,',')}" />

<c:forEach var="city" items="${citiesArray }" >

	${city } <br/>

</c:forEach>

<br/><br/><br/>
<c:set var="fun" value="${fn:join(citiesArray,',') }" />

${fun } 

 

</body>
</html>