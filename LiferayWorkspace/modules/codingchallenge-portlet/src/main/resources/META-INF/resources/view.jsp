<%@ include file="/init.jsp" %>

<portlet:actionURL name="addEntry" var="addEntryURL" />
 
<div class="codingchallenge-portlet">
	<div class="row mb-4">
		<div class="col-12">
			<h1>Ihre ToDo`s  Tests</h1>
			<b>Für das Anlegen eines neuen Eintrages, verwenden Sie bitte das folgende Eingabeformular</b>
		</div>
	</div>
	
	<div class="row"> 
		<div class="col-12">

			<div class="card">
			  <div class="card-header">
			    Hier können Sie eine neue Aufgabe Ihrer ToDo-Liste hinzufügen
			  </div>
			  <div class="card-body">
			  	<!--  
			    <h5 class="card-title">Special title treatment</h5>
			    <p class="card-text">With supporting text below as a natural lead-in to additional content.</p>
			    -->
			    <form action="<%= addEntryURL %>" method="post">
				  <div class="form-group row">
				    <label for="inputTask" class="col-sm-2 col-form-label">Neue Aufgabe</label>
				    <div class="col-sm-10">
				      <input type="text" name="<portlet:namespace />task" class="form-control" id="inputTask" placeholder="Neue Aufgabe">
				    </div>
				  </div>
				  
				  <div class="form-group row">
				  	<div class="col-sm-12 col-form-label">
				  		<button type="submit" class="btn btn-primary">Add Task</button>
				  	</div>
				  </div>
			  </form>
			</div>
		</div>
	</div>
</div>