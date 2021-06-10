<jsp:include page="my-header.jsp" />
<body class="container">
	<h3>Welcome to JSP Fundamentals</h3>
	<br />
	<h4>JSP Expressions</h4>

	<div>
		The time on the server is
		<%=new java.util.Date()%></div>
	<br />
	<div>
		Converting a string to upper case:
		<%=new String("Hello World!").toUpperCase()%></div>
	<br />
	<div>
		25 multiplied by 4 equals:
		<%=25 * 4%></div>
	<br />
	<div>
		75 is less than 69?
		<%=75 < 69%></div>
	<br />

	<h4>JSP Scriptlets</h4>
	<%
	for (int i = 1; i <= 5; i++) {
		out.println("<br/>I really love to code! " + i);
	}
	%>

	<br />
	<br />

	<h4>JSP Declaration</h4>

	<%!String makeItLower(String data) {
		return data.toLowerCase();
	}%>

	Lower case "Hello World":
	<%=makeItLower("Hello World")%><br />


	<br />
	<br />
	<h4>Calling a Java Class from JSP</h4>



<jsp:include page="my-footer.jsp" />