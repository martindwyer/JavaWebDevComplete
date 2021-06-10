<jsp:include page="my-header.jsp" />

<h3>Confirmation</h3>
<br />
<br />
<%
String favLang = request.getParameter("favoriteLanguage");

Cookie theCookie = new Cookie("myApp.favoriteLanguage",favLang);

theCookie.setMaxAge(60*60*24*365);

response.addCookie(theCookie);
%>

Thanks!  We set you favorite language to ${param.favoriteLanguage} <br/><br/>

<a href="cookies-homepage.jsp">Return to Home Page</a>

<jsp:include page="my-footer.jsp" />