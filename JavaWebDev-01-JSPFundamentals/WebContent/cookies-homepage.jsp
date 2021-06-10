<jsp:include page="my-header.jsp" />

<h3>Personalized Resources</h3>
<br />
<br />

<%
	String favLang = "Java";
	Cookie[] theCookies = request.getCookies();
	
	if(theCookies != null) {
		for(Cookie tempCookie: theCookies) {
			if("myApp.favoriteLanguage".equals(tempCookie.getName())) {
				favLang = tempCookie.getValue();
				break;
			}
		}
	}
%>

<h3>New books for <%= favLang %></h3>
<ul>
<li>Blah blah blah</li>
<li>Blah blah blah</li>
</ul>

<h3>Latest news for <%= favLang %></h3>
<ul>
<li>Blah blah blah</li>
<li>Blah blah blah</li>
</ul>


<h3>Hot jobs for <%= favLang %></h3>
<ul>
<li>Blah blah blah</li>
<li>Blah blah blah</li>
</ul>

<a href="cookies-personalize-form.jsp">Personalize this page</a>


<jsp:include page="my-footer.jsp" />