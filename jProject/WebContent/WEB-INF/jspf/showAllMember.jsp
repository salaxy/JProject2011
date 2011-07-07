<%-- 
    Document   : showAllMember
    Created on : 07.07.2011, 15:35:08
    Author     : MacYser
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:forEach items="${memberList}" var="member" varStatus="i">
	<a href="${sessionScope.aktServlet}?do=ShowProject&projectName=${sessionScope.aktProject}&loginName=${member.user}">(${member.projectRole}) ${member.user}</a><br>
</c:forEach>