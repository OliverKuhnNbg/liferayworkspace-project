<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>

<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %><%@
taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %><%@
taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %><%@
taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>

<portlet:actionURL name="addToDo" var="addToDoActionUrl" />
<portlet:actionURL name="doSomething" var="actionURL" />

<div class="container-fluid">
	<div class="row">
		<div class="col-12">
			<h4>Form Personen</h4>
		</div>
	</div>
	<div class="mt-4">
			<form action="<%= addToDoActionUrl %>" name="formSubmit" method="POST">
				<div class="form-group">
				    <label for="exampleInputName">Name</label>
				    <input type="text" class="form-control" id="exampleInputName" aria-describedby="emailHelp" placeholder="Enter Name" name="name">
				</div>
				
				<div class="form-group">
				    <label for="exampleInputEmail">Email address</label>
				    <input type="text" class="form-control" id="exampleInputEmail" aria-describedby="emailHelp" placeholder="Enter E-Mail" name="dueday">
				</div>
				
				<input type="submit" class="btn btn-primary" value="submit"/>
			</form>
	</div>
	<div class="mt-5 row">
		<a href="<%= actionURL %>">Do Something</a>
	</div>
</div>