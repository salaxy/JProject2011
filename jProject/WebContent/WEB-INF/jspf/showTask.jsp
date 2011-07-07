<%-- 
    Document   : showTask
    Created on : 07.07.2011, 15:30:22
    Author     : MacYser
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

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
									<input name="titel" value="${task.titel}" type="text" maxlength="14"/>
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