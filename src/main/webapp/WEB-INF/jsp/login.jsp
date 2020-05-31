<%@include file="common/header.jspf"%>
<%@include file="common/navigation.jspf"%>
<div class="container">
	<form:form name="submitForm" modelAttribute="loginBean" method="POST" >

		<div align="center">
			<table>
			<tr><td></tr><td> ${message} </td></tr>
				<tr>
					<td>User Name</td>
					<td><input type="text" name="username" /></td>
				</tr>
				<tr>
					<td>Password</td>
					<td><input type="password" name="password" /></td>
				</tr>
				<tr>
					<td></td>
					<td><input type="submit" value="Submit" /></td>
				</tr>
			</table>
			<div style="color: red">${error}</div>

		</div>
	</form:form>
</div>
<%@include file="common/footer.jspf"%>