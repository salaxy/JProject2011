<%-- 
    Document   : showProject
    Created on : 07.06.2011, 18:40:08
    Author     : MacYser
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div id="topcontent">
	<jsp:include page='projectnavi.jsp' />
</div>

<div id="contentcontentbig">
	<h2>${project} ${project.status}</h2><br />
	<c:forEach items="${memberList}" var="member" varStatus="i">
		<a href="JProjectServlet?do=ShowUserInfo&loginName=${member.user}">${member.user}</a><br>
	</c:forEach>
</div>

<div id="footercontent">
	<form>
		<textarea cols="93" rows="5">COMMENTS AJAX</textarea>
	</form>
</div>