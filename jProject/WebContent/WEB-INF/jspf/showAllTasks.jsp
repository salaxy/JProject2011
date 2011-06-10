<%-- 
    Document   : showAllTasks
    Created on : 07.06.2011, 18:46:58
    Author     : MacYser
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div id="topcontent">
	<jsp:include page='projectnavi.jsp' />
</div>

<div id="leftcontent">
	<c:forEach items="${taskList}" var="task" varStatus="i">
		<a href="JProjectServlet?do=ShowAllTasks&taskId=${task.id}">${task.titel}</a><br>
	</c:forEach>

</div>

<div id="contentcontentsmall">
	${task.id} ${task.titel}<br /><br />
	${task.aufgabenstellung}
</div>

<div id="footercontent">
	<form>
		<textarea cols="93" rows="5">COMMENTS AJAX</textarea>
	</form>
</div>
