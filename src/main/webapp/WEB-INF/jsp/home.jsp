<%@include file="common/header.jspf"%>
<%@include file="common/navigation.jspf"%>
<div class="container">
<form action="addUser">
 ID:<br/>   
 <input type="text" name="t1"/><br/>
 UserName:<br/> ${name} 
 <input type="text" name="t2"/><br/>
 
<input type="submit" value="Add"/> 
<br/>
${todos}
</form>
</div>
<%@include file="common/footer.jspf"%>