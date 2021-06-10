<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page import="com.mdbytes.springdemo.utils.SortUtils" %>
...
						
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Customer List</title>
<link rel="preconnect" href="https://fonts.gstatic.com">
<link href="https://fonts.googleapis.com/css2?family=MuseoModerno:wght@700;900&family=Reggae+One&family=Roboto:wght@900&display=swap" rel="stylesheet">
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css" >
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/add-customer-style.css" >
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/logo-style.css" >

</head>
<body>


	<div id="wrapper">

	<div class="page-heading"><span class="crm">CRM.</span><span class="logo">md</span></div>
		<div id="header">
	

			<h2>Customer List</h2>

		</div>
		<!-- construct a sort link for first name -->
				<c:url var="sortLinkFirstName" value="/customer/list">
					<c:param name="sort" value="<%= Integer.toString(SortUtils.FIRST_NAME) %>" />
				</c:url>
				
				<!-- construct a sort link for last name -->
				<c:url var="sortLinkLastName" value="/customer/list">
					<c:param name="sort" value="<%= Integer.toString(SortUtils.LAST_NAME) %>" />
				</c:url>					
 
				<!-- construct a sort link for email -->
				<c:url var="sortLinkEmail" value="/customer/list">
					<c:param name="sort" value="<%= Integer.toString(SortUtils.EMAIL) %>" />
				</c:url>	
				
		

		<div id="container">

			<div id="content">
			
			<form:form action="search" method="GET">
                Search customer: <input type="text" name="theSearchName" />
                
                <input type="submit" value="Search" class="add-button" />
            </form:form>
            <input type="button" value="Add Customer" onclick="window.location.href='showFormForAdd'; return false;" class="add-button" />
			
			
			
				<table>
					<tr>
					<th><a href="${sortLinkFirstName}">First Name</a></th>
					<th><a href="${sortLinkLastName}">Last Name</a></th>
					<th><a href="${sortLinkEmail}">Email</a></th>
					<th>Action</th>
					</tr>

					<c:forEach var="tempCustomer" items="${customers}">
					
					<c:url var="updateLink" value="/customer/showFormForUpdate" >
						<c:param name="customerId" value="${tempCustomer.id}" />
					</c:url>
					<c:url var="deleteLink" value="/customer/delete" >
						<c:param name="customerId" value="${tempCustomer.id}" />
					</c:url>
						<tr>
							<td>${tempCustomer.firstName}</td>
							<td>${tempCustomer.lastName}</td>
							<td>${tempCustomer.email}</td>
							<td>
								<a href="${updateLink}" class="action-button">Update</a>		
								<a href="${deleteLink}" class="action-button" onclick="if(!(confirm('Are you sure you want to delete this customer?'))) return false;" >Delete</a>
							</td>
						</tr>

					</c:forEach>


				</table>



			</div>



		</div>



	</div>


</body>
</html>