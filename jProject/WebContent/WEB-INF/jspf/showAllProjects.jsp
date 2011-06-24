<%-- 
    Document   : showAllProjects
    Created on : 14.06.2011, 16:45:57
    Author     : MacYser
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:forEach items="${projectList}" var="project" varStatus="i">
	<c:if test="${isAllowedDeleteProjectAction}">
		<form method="POST" action="${sessionScope.aktServlet}" onsubmit="return confirmDeleteProject()">
			<input name="do" value="DeleteProject" type="hidden" />
			<input name="projectName" value="${project.name}" type="hidden" />
			<input value="X" type="submit" />
	</c:if>
	<a href="${sessionScope.aktServlet}?do=ShowProject&projectName=${project.name}">${project}</a><br>
	<c:if test="${isAllowedDeleteProjectAction}">
		</form>
	</c:if>
</c:forEach>
