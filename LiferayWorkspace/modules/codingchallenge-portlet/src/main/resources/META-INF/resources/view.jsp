<%@ include file="/init.jsp" %>

<p style="display:none">
	<b><liferay-ui:message key="codingchallenge.caption"/></b>
</p>

<portlet:actionURL name="employeeSubmit" var="employeeSubmit" />

<div class="container-fluid">
	<div class="row">
		<div class="col-12">
			<h4>Form Personen</h4>
		</div>
	</div>
	<div class="mt-4">
			<form action="<%=employeeSubmit%>" method="post">
			
				<div class="form-group">
				    <label for="exampleInputEmail1">Name</label>
				    <input type="text" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="Enter Name" name="<porlet:namesapces>name">
				</div>
				
				<div class="form-group">
				    <label for="exampleInputEmail1">Email address</label>
				    <input type="text" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="Enter email" name="<porlet:namesapces>dueday">
				</div>
				
				<button type="submit" class="btn btn-primary">Submit</button>
			</form>
	</div>
</div>