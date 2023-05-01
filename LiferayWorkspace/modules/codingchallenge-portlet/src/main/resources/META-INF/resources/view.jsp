<%@ include file="/init.jsp" %>

<!-- 
<h1>It is alive!!!</h1>
<p>
	<b><liferay-ui:message key="codingchallenge.caption"/></b>
</p>
 -->
<div class="codingchallenge-portlet">
	<div class="row mb-4">
		<div class="col-12">
			<h1> Ihre ToDo`s</h1>
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
			    <form>
				  <div class="form-group row">
				    <label for="inputPassword" class="col-sm-2 col-form-label">Neue Aufgabe</label>
				    <div class="col-sm-10">
				      <input type="text" class="form-control" id="inputPassword" placeholder="Neue Aufgabe">
				    </div>
				  </div>
				</form>
			    <a href="#" class="btn btn-primary">Add Task</a>
			  </div>
			</div>
		</div>
	</div>
</div>