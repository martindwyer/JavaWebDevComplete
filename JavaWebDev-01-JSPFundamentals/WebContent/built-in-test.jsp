<jsp:include page="my-header.jsp" />

	<h3>JSP Built-In Objects</h3>
	<br/>
	<br/>
	Request user agent:  <%= request.getHeader("User-Agent") %>
	<br/>
	<br/>
	Request language: <%=  request.getLocale() %>
	


<jsp:include page="my-footer.jsp" />
