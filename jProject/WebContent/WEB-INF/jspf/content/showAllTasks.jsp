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
	<h1>Tasks</h1>
	<c:forEach items="${taskList}" var="task" varStatus="i">
		<a href="${sessionScope.aktServlet}?do=ShowAllTasks&taskId=${task.id}">${task.titel}</a><br>
	</c:forEach>

</div>

<div id="contentcontentsmall">	
	<h1>${task.titel}</h1>
	<div id="infoBoxBig">
		<!--TODO addNewTask.jsp-->
		
	</div>
	<div id="infoBoxBig">
		<form>
			<textarea cols="75" rows="5">${task.id} ${task.titel}
${task.aufgabenstellung}
			</textarea>
		</form>
	</div>	
</div>

<div id="footercontent">
	<input value="Show Comments" type="button" onclick="getShowAllComments41TaskJSON(${task.id})" />
	<div id="allComments41Task">
		
	</div>
</div>
