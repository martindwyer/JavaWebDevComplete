<jsp:include page="my-header.jsp" />

<h3>Student Form</h3>
<br />
<br />
<form action="student-response.jsp">
	First Name: <input type="text" name="firstName" /> <br /> <br /> 
	Last Name: <input type="text" name="lastName" /> <br /> <br /> 
	Country of Origin:  
	<select name="country">
		<option>Brazil</option>
		<option>France</option>
		<option>Germany</option>
		<option>Spain</option>
		<option>England</option>
		<option>Ireland</option>
	</select>
	<br/><br/>
	Favorite Programming Language: <br/><br/>
	Java
	<input type="radio" name="favoriteLanguage" value="Java" />&nbsp;&nbsp;
	C#
	<input type="radio" name="favoriteLanguage" value="C#" />&nbsp;&nbsp;
	PHP
	<input type="radio" name="favoriteLanguage" value="PHP" />&nbsp;&nbsp;
	Python
	<input type="radio" name="favoriteLanguage" value="Python" />&nbsp;&nbsp;
	JavaScript
	<input type="radio" name="favoriteLanguage" value="JavaScript" />	&nbsp;&nbsp;
	<br/><br/>
	
	Programming experience with: <br/><br/>
	Java
	<input type="checkbox" name="languageExperience" value="Java" />&nbsp;&nbsp;
	C#
	<input type="checkbox" name="languageExperience" value="C#" />&nbsp;&nbsp;
	PHP
	<input type="checkbox" name="languageExperience" value="PHP" />&nbsp;&nbsp;
	Python
	<input type="checkbox" name="languageExperience" value="Python" />&nbsp;&nbsp;
	JavaScript
	<input type="checkbox" name="languageExperience" value="JavaScript" />	&nbsp;&nbsp;
	<br/><br/>
	
	<input type="submit" value="Submit" />
</form>



<jsp:include page="my-footer.jsp" />