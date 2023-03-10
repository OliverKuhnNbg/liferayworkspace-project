<%@ include file="/init.jsp" %>

<p style="display:none">
	<b><liferay-ui:message key="codingchallenge.caption"/></b>
</p>

<portlet:actionURL name="formSubmit" var="formSubmit" />
<portlet:actionURL name="doSomething" var="actionURL" />

<div class="container-fluid">
	<div class="row">
		<div class="col-12">
			<h4>Form Personen</h4>
		</div>
	</div>
	<div class="mt-4">
			<form action="<%= formSubmit %>" method="post">
				<div class="form-group">
				    <label for="exampleInputName">Name</label>
				    <input type="text" class="form-control" id="exampleInputName" aria-describedby="emailHelp" placeholder="Enter Name" name="name">
				</div>
				
				<div class="form-group">
				    <label for="exampleInputEmail">Email address</label>
				    <input type="text" class="form-control" id="exampleInputEmail" aria-describedby="emailHelp" placeholder="Enter E-Mail" name="dueday">
				</div>
				
				<button type="submit" class="btn btn-primary">Submit</button>
			</form>
	</div>
	
	<div class="mt-5 row">
		<a href="<%= actionURL %>">Do Something</a>
	</div>
</div>