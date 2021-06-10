<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSTL Tag Demo</title>
</head>
<body>

<h1>JSTL Tag Demo Test</h1>

<c:set var="stuff" value="<%= new java.util.Date() %>" />

Time on server is ${stuff}

</body>
</html>