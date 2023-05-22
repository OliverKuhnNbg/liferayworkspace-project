<%@ include file="/init.jsp" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>  

<%@ page import="java.lang.*;"%>
<%@ page import="java.util.*;"%>

<portlet:actionURL name="addEntry" var="addEntryURL" />
 
<div class="codingchallenge-portlet">
	<div class="row">
		<div class="col-6 border-right">
			<h1 class="row ml-1">Ihre ToDo`s</h1>
			<p class="row ml-1">Für das Anlegen eines neuen Eintrages, verwenden Sie bitte das folgende Eingabeformular.</p>
			<div class="card mt-3">
			  <div class="card-header">
			    Hier können Sie eine neue Aufgabe Ihrer ToDo-Liste hinzufügen
			  </div>

			  <div class="card-body">
			    <form action="<%= addEntryURL %>" method="post">

				  <div class="form-group row">
				    <label for="inputTask" class="col-10 col-form-label">Neue Aufgabe *</label>
				    <div class="col-10">
				      <input type="text" name="<portlet:namespace />task" class="form-control" id="inputTask" placeholder="Neue Aufgabe" required="true">
				    </div>
				  </div>
				  
				  <div class="form-group row">
				    <label for="inputDate" class="col-10 col-form-label">Fälligkeitsdatum (tt.mm.yy) *</label>
				    <div class="col-10">
				      <input type="text" name="<portlet:namespace />duedate" class="form-control" id="inputDate" placeholder="Fälligkeitsdatum" required="true">
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

	<div class="col-6">
		<p>${requestScope.tasks.size()}</p>
		
		<table class="table">
		  <thead class="thead-dark">
		    <tr>
		      <th scope="col">#</th>
		      <th scope="col">Task</th>
		      <th scope="col">Fälligkeitsdatum</th>
		    </tr>
		  </thead>
		  <tbody>
		    <c:forEach items="${requestScope.tasks}" var="task" varStatus="status"> 
		    	<!--scriptlet tag -->
				<%
					//out is implicit object of JSP
					String name = "test front end scriptlet";
				%>
			    <tr>
			        <td><c:out value="${task.taskId}"/></td>
			        <td><c:out value="${task.toDoTask}"/></td>
			        <td><c:out value="${requestScope.convertedDateList[status.index]}"/></td>
			    </tr>
			</c:forEach>
			
		  </tbody>
		</table>
		
				
	</div>
	
</div>