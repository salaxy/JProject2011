<%-- 
    Document   : showAllUser
    Created on : 07.06.2011, 18:46:14
    Author     : MacYser
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div id="topcontent">
	<jsp:include page='adminheader.jsp' />
</div>

<div id="leftcontent">
	<c:forEach items="${userList}" var="user" varStatus="i">
		<a href="AdminServlet?do=ShowAllUser&loginName=${user.loginName}">${user}</a><br>
	</c:forEach>
</div>

<div id="contentcontentsmall">
	${user.loginName} ${user.globalRole}<br />	
	
</div>

<div id="footercontent">
	
</div>
