<%-- 
    Document   : showProject
    Created on : 07.06.2011, 18:40:08
    Author     : MacYser
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
		
<h2>showProject</h2>

<!--TODO Include Header JSP-->
<div id="topcontent">
	<a class="buttoncontent" href="JProjectServlet?do=ShowProject&projectName=${sessionScope.aktProject}">Project</a>
	<a class="buttoncontent" href="JProjectServlet?do=ShowAllSource&projectName=${sessionScope.aktProject}">Sourcecode</a>
	<a class="buttoncontent" href="JProjectServlet?do=ShowAllDocu&projectName=${sessionScope.aktProject}">Documents</a>
	<a class="buttoncontent" href="JProjectServlet?do=ShowAllTasks&projectName=${sessionScope.aktProject}">Tasks</a>
</div>

<div id="contentcontentbig">
	${project} ${project.status}<br />
</div>

<div id="footercontent">
	<form>
		<textarea cols="93" rows="5">COMMENTS AJAX</textarea>
	</form>
</div>
