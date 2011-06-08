<%-- 
    Document   : showAllDocu
    Created on : 07.06.2011, 18:46:14
    Author     : MacYser
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<h2>showAllDocu</h2>
<div id="topcontent">
	<a class="buttoncontent" href="JProjectServlet?do=ShowProject&projectName=${sessionScope.aktProject}">Project</a>
	<a class="buttoncontent" href="JProjectServlet?do=ShowAllSource&projectName=${sessionScope.aktProject}">Sourcecode</a>
	<a class="buttoncontent" href="JProjectServlet?do=ShowAllDocu&projectName=${sessionScope.aktProject}">Documents</a>
	<a class="buttoncontent" href="JProjectServlet?do=ShowAllTasks&projectName=${sessionScope.aktProject}">Tasks</a>
</div>

<div id="leftcontent">
	<c:forEach items="${documentList}" var="document" varStatus="i">
		<a href="JProjectServlet?do=ShowDocu&documentID=${document.id}">${document.dateiname}</a><br>
	</c:forEach>
</div>

<div id="contentcontentsmall">
	${document.id} ${document.dateiname}<br />	
	
	
	<form action="JProjectServlet" method="POST" enctype="multipart/form-data">
		<input type="hidden" name="do" value="AddNewDocu">
		Files to upload:
		<br/>
		<input type="file" size="50" name="file1">
		<br/>
		<input type="submit" value="Upload">
	</form>
</div>

<div id="footercontent">
	<form>
		<textarea cols="93" rows="5">COMMENTS AJAX</textarea>
	</form>
</div>
