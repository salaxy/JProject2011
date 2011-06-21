<%-- 
    Document   : showAllTasks
    Created on : 07.06.2011, 18:46:58
    Author     : MacYser
--%>

<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String date = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
%>
<div id="topcontent">
	<jsp:include page='projectheader.jsp' />
</div>

<div id="leftcontent">
	<!--TODO OUTSOURCING-->
	<h1>Tasks</h1>
	<c:forEach items="${taskList}" var="task" varStatus="i">
		<a href="${sessionScope.aktServlet}?do=ShowAllTasks&taskId=${task.id}">${task.titel}</a><br>
	</c:forEach>

</div>

<div id="contentcontentsmall">	
	<h1>${task.titel}</h1>
	<div id="infoBoxBig">
		<c:choose>
			<c:when test="${sessionScope.isAllowedAddNewTaskAction == true}">
				<!--
				<a href="#" onclick="$('addNew').show();">Show</a>
				<a href="#" onclick="$('addNew').hide();">Hide</a><br />
				<div id="addNew">
					hallo
				</div>
				-->
				<script type="text/javascript"> 
					var hide = false;
					alert($('addNew'));
					window.addEvent('domready', function() {
						//time to implement basic show / hide
						Element.extend({
							//implement show
							show: function(e) {
								alert("Show");
								this.setStyle('display','block');
							},
							//implement hide
							hide: function(e) {
								alert("Hide");
								this.setStyle('display','none');
							}
						});
					});
				</script>
				<h3>Neuen Task hinzufügen</h3>
				<fieldset>
					<legend>Neuen Task hinzufügen</legend>
					<form method="POST" action="${sessionScope.aktServlet}">
						<input name="do" value="AddNewTask" type="hidden" />
						<table border="0" cellspacing="3">
							<tbody>
								<tr>
									<td>
										<label for="titel">Titel:</label><br />
										<input name="titel" value="Titel" type="text" />
									</td>
								</tr>
								<tr>
									<td>
										<label for="aufgabenstellung">Aufgabenstellung:</label><br />
										<textarea name="aufgabenstellung" cols="75" rows="1">Aufgabenstellung</textarea>
									</td>
								</tr>
								<tr>
									<td>
										<input value="Add" type="submit" />
									</td>
								</tr>
							</tbody>
						</table>
					</form>
				</fieldset>
			</c:when>
		</c:choose>
		
	</div>
	<div id="infoBoxBig">
		<fieldset>
			<legend>Aktueller Task</legend>
			<form method="POST" action="${sessionScope.aktServlet}">
				<input name="do" value="UpdateTask" type="hidden" />
				<input name="taskId" value="${task.id}" type="hidden" />
				
				<!--<input name="date" value="${task.termin}" type="text" />-->
				
				<table border="0" cellspacing="3">
					<tbody>
						<tr>
							<td>
								<label for="titel">Titel:</label><br />
								<input name="titel" value="${task.titel}" type="text" />
							</td>
						</tr>
						<tr>
							<td>
								<label for="aufgabenstellung">Aufgabenstellung:</label><br />
								<textarea name="aufgabenstellung" cols="75" rows="15" <% if(Boolean.valueOf(""+session.getAttribute("isAllowedUpdateTaskAction")) != true){out.print("readonly");} %>>${task.aufgabenstellung}</textarea>
							</td>
						</tr>
						<tr>
							<td>
								<c:choose>
									<c:when test="${sessionScope.isAllowedUpdateTaskAction == true}">
										<input value="Update" type="submit" />
									</c:when>
								</c:choose>
							</td>
						</tr>
					</tbody>
				</table>
			</form>
		</fieldset>
		<br />
	</div>
</div>

<div id="footercontent">
	<input value="Show Comments" type="button" onclick="getShowAllComments41TaskJSON(${task.id});" />
	<div id="allComments41Task">
		
	</div>
</div>
