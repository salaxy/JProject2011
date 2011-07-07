<%-- 
    Document   : showAllTasks
    Created on : 07.07.2011, 15:26:15
    Author     : MacYser
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

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