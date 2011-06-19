<%-- 
    Document   : showAllProjects
    Created on : 14.06.2011, 16:45:57
    Author     : MacYser
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:forEach items="${projectList}" var="project" varStatus="i">
	<a href="${sessionScope.aktServlet}?do=ShowProject&projectName=${project.name}">${project}</a><br>
</c:forEach>
