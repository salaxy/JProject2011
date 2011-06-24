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
		<c:if test="${isAllowedDeleteTaskAction}">
			<form method="POST" action="${sessionScope.aktServlet}" onsubmit="return confirmDeleteTask()">
				<input name="do" value="DeleteTask" type="hidden" />
				<input name="taskId" value="${task.id}" type="hidden" />
				<input value="X" type="submit" />
		</c:if>
		<a href="${sessionScope.aktServlet}?do=ShowAllTasks&taskId=${task.id}">${task.titel}</a>
		<c:choose>
			<c:when test="${isAllowedDeleteTaskAction}">
				</form>
			</c:when>
			<c:otherwise>
				<br />
			</c:otherwise>
		</c:choose>
	</c:forEach>

</div>

<div id="contentcontentsmall">	
	<h1>${task.titel}</h1>
	<div id="infoBoxBig">
		<c:choose>
			<c:when test="${isAllowedAddNewTaskAction == true}">
				<h3>Neuen Task hinzufügen<input type="checkbox" onclick="showHideText(this,'addBox');" /></h3>
				<fieldset id="addBox" style="display:none;">
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
	<c:choose>
		<c:when test="${!empty taskList}">
			<div id="infoBoxBig">
				<h3>Aktueller Task anzeigen</h3>
				<fieldset>
					<legend>Aktueller Task</legend>
					<!--TODO start: if isAllowedShowAllMember-->
					<table border="0" cellspacing="3">
						<tbody>
							<tr>
								<td>
									<c:if test="${isAllowedAssignTaskAction}">
										<fieldset>
											<legend>Einem Member diesen Task zuweisen</legend>
											<form method="POST" action="${sessionScope.aktServlet}">
												<input name="do" value="AssignTask" type="hidden" />
												<input name="taskId" value="${task.id}" type="hidden" />
												<select id ="selectbox" name="loginName">
													<c:forEach items="${memberList}" var="member" varStatus="i">
														<option>${member.user}</option>
													</c:forEach>
												</select>
												<input value="Zuweisen" type="submit" />
											</form>
										</fieldset>
									</c:if>
								</td>
								<td>
									<c:if test="${isAllowedDeAssignTaskAction}">
										<fieldset>
											<legend>Einen Member von diesem Task ablösen</legend>
											<form method="POST" action="${sessionScope.aktServlet}">
												<input name="do" value="DeAssignTask" type="hidden" />
												<input name="taskId" value="${task.id}" type="hidden" />
												<select id ="selectbox" name="loginName">
													<c:forEach items="${taskMemberList}" var="member" varStatus="i">
														<option>${member.user}</option>
													</c:forEach>
												</select>
												<input value="Ablösen" type="submit" />
											</form>
										</fieldset>
									</c:if>
								</td>
							</tr>
						</tbody>
					</table>
					<!--TODO end-->
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
										<textarea name="aufgabenstellung" cols="70" rows="15" <% if(Boolean.valueOf(""+session.getAttribute("isAllowedUpdateTaskAction")) != true){out.print("readonly");} %>>${task.aufgabenstellung}</textarea>
									</td>
								</tr>
								<tr>
									<td>
										<c:choose>
											<c:when test="${isAllowedUpdateTaskAction == true}">
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
		</c:when>
		<c:otherwise>
			<div id="infoBoxBig">
				Kein Task vorhanden!
			</div>
		</c:otherwise>
	</c:choose>
</div>

<div id="footercontent">
	<c:choose>
		<c:when test="${!empty taskList}">
			
			<div id="allComments41Task">
				<input value="Show Comments" type="button" onclick="getShowAllComments41TaskJSON(${task.id});" />
			</div>
		</c:when>
	</c:choose>
</div>
