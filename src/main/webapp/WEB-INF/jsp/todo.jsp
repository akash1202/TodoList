<%@include file="common/header.jspf"%>
<%@include file="common/navigation.jspf"%>
<div class="container">
<h2>Add Todo page </h2>
<form:form name="form" method="POST" modelAttribute="todo" >
<form:hidden path="id"/>
<fieldset class="form-group" >
<form:label path="desc"> Description:</form:label>
<form:input path="desc" class="form-cotrol" type="text"  required="required" /><br/>
<form:errors path="desc" cssClass="text-warning" /> 
</fieldset>
<fieldset class="form-group" >
<form:label path="targetDate"> Date:</form:label>
<form:input path="targetDate" class="form-cotrol" type="text"  required="required" /><br/>
<form:errors path="targetDate" cssClass="text-warning" /> 
</fieldset>

<button class="btn btn-success" type="submit" name="submit" >Add</button><br/>
</form:form> 
<h1>Todo's List</h1>
<table class="table table-striped">   
<caption>Todo's List</caption>
<thead>
	<tr>
		<th>Description</th>
		<th>Target Time</th>
		<th>Is it done?</th>
		<th>Update</th>
		<th>Delete</th>
	</tr>
</thead>
<tbody>

<c:forEach items="${todos}" var="todo" >
	<tr>
		<td>${todo.desc} </td>
		<td> <fmt:formatDate value="${todo.targetDate}" pattern="dd/MM/yyyy"/> </td>
		<td>${todo.isDone} </td>
		<td><a href="/update-todo?id=${todo.id}" type="button" class ="btn btn-success">Update</a>
		<td><a href="/delete-todo?id=${todo.id}" type="button" class ="btn btn-warning">Delete</a>
	</tr>
</c:forEach>
</tbody>

</table>
</div>
<%@include file="common/footer.jspf"%>