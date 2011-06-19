<%-- 
    Document   : showAllUser
    Created on : 07.06.2011, 18:46:14
    Author     : MacYser
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:forEach items="${userList}" var="user" varStatus="i">
	<a href="${sessionScope.aktServlet}?do=ShowUserInfo&loginName=${user.loginName}">${user}</a><br>
</c:forEach>

