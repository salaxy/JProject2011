<%-- 
    Document   : showAllProjects
    Created on : 14.06.2011, 16:45:57
    Author     : MacYser
--%>

<%-- 
    Document   : showAllUser
    Created on : 07.06.2011, 18:46:14
    Author     : MacYser
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div id="topcontent">
	<jsp:include page='adminheader.jsp' />
</div>

<div id="leftcontent">
	<c:forEach items="${projectList}" var="project" varStatus="i">
		<a href="AdminServlet?do=ShowAllProjects&projectName=${project.name}">${project}</a><br>
	</c:forEach>
</div>

<div id="contentcontentsmall">
	${project.name} ${project.status}<br />	
	
</div>

<div id="footercontent">
	<input value="Show Comments" type="button" onclick="getShowAllComments41ProjectJSON('${project.name}');" />
	<div id="allComments41Project">
		
	</div>
</div>
