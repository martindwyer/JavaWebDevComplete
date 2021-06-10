<jsp:include page="my-header.jsp" />
<%@ page import="com.mdbytes.jsp.FunUtils"%>

	<h3>Testing FunUtils Class</h3>
	<br /> Let's have some fun:
	<%=FunUtils.makeItLower("FUN FUN FUN")%>

<jsp:include page="my-footer.jsp" />