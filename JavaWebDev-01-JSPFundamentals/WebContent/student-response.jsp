<jsp:include page="my-header.jsp" />

<h3>Student Confirmation</h3>
<br />
<br />

The student is confirmed:  ${param.firstName}  ${param.lastName}<br/><br/>

Country of origin:  ${param.country}<br/><br/>

Favorite programming language:  ${param.favoriteLanguage}

<%
String[] langs = request.getParameterValues("languageExperience");

if(langs != null) {
	out.println("<br/><br/>Experience with: ");
	for(String lang: langs) {
		out.println(" " + lang );
	}
}
%>

<jsp:include page="my-footer.jsp" />