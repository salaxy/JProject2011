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
	<!--TODO OUTSOURCING-->
	<h2>Memberliste</h2>
	<c:forEach items="${memberList}" var="member" varStatus="i">
		<a href="JProjectServlet?do=ShowUserInfo&loginName=${member.user}">(${member.projectRole}) ${member.user}</a><br>
	</c:forEach>
</div>
<div id="contentcontentsmall">
	<h2>${project} ${project.status}</h2><br />
	<jsp:include page='../addMember.jsp' />
	<form method="POST" action="JProjectServlet">
		<input name="do" value="DeleteMember" type="hidden" />
		<input value="Mitgliedschaft beenden" type="submit">
	</form>
	
</div>

<div id="footercontent">
	<br />
	<input value="Show Comments" type="button" onclick="getShowAllComments41ProjectJSON('${project.name}');" />
	<div id="allComments41Project">
		
	</div>
</div>
