<h1>Add team page</h1>
<p>Here you can add a new team.</p>
<form:form method="POST" commandname="team"
	action="${pageContext.request.contextPath}/team/add/process.html">
	<table>
		<tbody>
			<tr>
				<td>Name:</td>
				<td><form:input path="name"></form:input></td>
			</tr>
			<tr>
				<td>Rating:</td>
				<td><form:input path="rating"></form:input></td>
			</tr>
			<tr>
				<td><input value="Add" type="submit"></td>
				<td></td>
			</tr>
		</tbody>
	</table>
</form:form>

<p>
	<a href="${pageContext.request.contextPath}/index.html">Home page</a>
</p>
