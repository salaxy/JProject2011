<%-- 
    Document   : showAllTasks
    Created on : 07.06.2011, 18:46:58
    Author     : MacYser
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div id="topcontent">
	<jsp:include page='projectheader.jsp' />
</div>

<div id="leftcontent">
	<!--TODO OUTSOURCING-->
	<h2>Taskliste</h2>
	<c:forEach items="${taskList}" var="task" varStatus="i">
		<a href="JProjectServlet?do=ShowAllTasks&taskId=${task.id}">${task.titel}</a><br>
	</c:forEach>

</div>

<div id="contentcontentsmall">
	${task.id} ${task.titel}<br /><br />
	${task.aufgabenstellung}
</div>

<div id="footercontent">
	<br />
	<input value="Show Comments" type="button" onclick="getShowAllComments41TaskJSON(${task.id})" />
	<div id="allComments41Task">
		
	</div>
</div>
