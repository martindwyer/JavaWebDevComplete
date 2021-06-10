<%@ page import="java.util.*" %>
<jsp:include page="my-header.jsp" />

<h3>To Do List</h3>
<br />
<br />
<form action="todo-demo.jsp">
	Add new item: <input type="text" name="theItem" />
	<input type="submit" value="Submit" />
</form>
<hr />
<%
	List<String> items = (List<String>) session.getAttribute("myToDoList");

	if (items== null) {
		items = new ArrayList<String>();
		session.setAttribute("myToDoList",items);
	}
	
	String theItem = request.getParameter("theItem");
	
	if(theItem != null) {
		if(!theItem.equals("")) {
			items.add(theItem);
		}
	}
	
	

%>

To Do List Items: </b><br/><br/>
<ol>
<% for (String temp: items) {
		out.println("<li>" + temp + "</li>");
	}
	
%>
</ol>


<jsp:include page="my-footer.jsp" />