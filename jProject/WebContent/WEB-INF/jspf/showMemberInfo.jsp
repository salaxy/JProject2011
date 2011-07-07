<%-- 
    Document   : showMemberInfo
    Created on : 07.07.2011, 15:47:45
    Author     : MacYser
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<fieldset>
	<legend>User Info</legend>
	<table border="0" cellspacing="3">
		<tbody>
			<tr>
				<td>Username:</td>
				<td>${user}</td>
			</tr>
			<tr>
				<td>Vorname:</td>
				<td>${user.vorname}</td>
			</tr>
			<tr>
				<td>Nachname:</td>
				<td>${user.nachname}</td>
			</tr>
			<tr>
				<td>Sprache:</td>
				<td>${user.sprache}</td>
			</tr>
			<tr>
				<td>Globale Rolle:</td>
				<td>${user.globalRole}</td>
			</tr>
			<tr>
				<td>Projekt Rolle:</td>
				<td>${member.projectRole}</td>
			</tr>
			<tr>
				<c:if test="${sessionScope.isAllowedShowAllTasks == true}">
					<td>Tasks:</td>
					<td>
						<c:forEach items="${memberTasks}" var="task" varStatus="i">
							<a href="${aktServlet}?do=ShowAllTasks&taskId=${task.id}">${task.titel}</a><br />
						</c:forEach>
					</td>
				</c:if>
			</tr>
		</tbody>
	</table>
</fieldset>
