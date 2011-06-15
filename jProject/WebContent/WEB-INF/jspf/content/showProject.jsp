<%-- 
    Document   : showProject
    Created on : 07.06.2011, 18:40:08
    Author     : MacYser
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div id="topcontent">
	<jsp:include page='projectheader.jsp' />
</div>
<div id="leftcontent">
	<c:forEach items="${memberList}" var="member" varStatus="i">
		<a href="JProjectServlet?do=ShowUserInfo&loginName=${member.user}">${member.user}</a><br>
	</c:forEach>
</div>
<div id="contentcontentsmall">
	<h2>${project} ${project.status}</h2><br />
	<jsp:include page='../addMember.jsp' />
	
</div>

<div id="footercontent">
	<input value="Show Comments" type="button" onclick="getShowAllComments41ProjectJSON('${project.name}');" />
	<div id="allComments41Project">
		
	</div>
</div>
