<%-- 
    Document   : showAllOwnProjects
    Created on : 07.06.2011, 18:46:30
    Author     : MacYser
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<c:choose>
	<c:when test="${sessionScope.loggedIn == true}">
		<c:forEach items="${ownProjectList}" var="project" varStatus="i">
			<a href="JProjectServlet?do=ShowProject&projectName=${project.name}">${project.name}</a><br>
		</c:forEach>
	</c:when>
</c:choose>
