<%-- 
    Document   : showAllSource
    Created on : 07.06.2011, 18:46:46
    Author     : MacYser
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<h2>showAllSource</h2>
<div id="topcontent">
	<a class="buttoncontent" href="JProjectServlet?do=ShowProject&projectName=${sessionScope.aktProject}">Project</a>
	<a class="buttoncontent" href="JProjectServlet?do=ShowAllSource&projectName=${sessionScope.aktProject}">Sourcecode</a>
	<a class="buttoncontent" href="JProjectServlet?do=ShowAllDocu&projectName=${sessionScope.aktProject}">Documents</a>
	<a class="buttoncontent" href="JProjectServlet?do=ShowAllTasks&projectName=${sessionScope.aktProject}">Tasks</a>
</div>

<div id="leftcontent">
	<c:forEach items="${sourcecodeList}" var="sourcecode" varStatus="i">
		<a href="JProjectServlet?do=ShowSource&sourcecodeID=${sourcecode.id}">${sourcecode.dateiname}</a><br>
	</c:forEach>
</div>

<div id="contentcontentsmall">
	${sourcecode.id} ${sourcecode.dateiname}<br />
</div>

<div id="footercontent">
	<form>
		<textarea cols="93" rows="5">COMMENTS AJAX</textarea>
	</form>
</div>
