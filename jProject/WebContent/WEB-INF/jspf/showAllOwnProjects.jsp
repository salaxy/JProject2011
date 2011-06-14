<%-- 
    Document   : showAllOwnProjects
    Created on : 07.06.2011, 18:46:30
    Author     : MacYser
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:choose>
	<c:when test="${sessionScope.aktUser != null}">
		<c:forEach items="${ownProjectSet}" var="member" varStatus="i">
			<a href="JProjectServlet?do=ShowProject&projectName=${member.project}">${member.project}</a><br>
		</c:forEach>
	</c:when>
</c:choose>
