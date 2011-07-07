<%-- 
    Document   : showAllTasks
    Created on : 07.06.2011, 18:46:58
    Author     : MacYser
--%>

<%--<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%--<%
	String date = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
%>--%>
<div id="topcontent">
	<jsp:include page='projectheader.jsp' />
</div>

<div id="leftcontent">
	<h1>Tasks</h1>
	<jsp:include page='../showAllTasks.jsp' />
</div>

<div id="contentcontentsmall">	
	<h1>${task.titel}</h1>
	<div id="infoBoxBig">
		<jsp:include page='../addNewTask.jsp' />
	</div>
	<jsp:include page='../showTask.jsp' />
</div>

<div id="footercontent">
	<c:choose>
		<c:when test="${!empty taskList}">
			
			<div id="allComments41Task">
				<input value="Show Comments" type="button" onclick="getShowAllComments41TaskJSON(${task.id});" />
			</div>
		</c:when>
	</c:choose>
</div>
