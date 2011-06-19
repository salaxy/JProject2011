<%-- 
    Document   : login
    Created on : 07.06.2011, 18:46:02
    Author     : MacYser
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:choose>
	<c:when test="${sessionScope.aktUser == null}">
		<form class="buttonright" method="POST" action="JProjectServlet">
			<input name="do" value="Login" type="hidden" />
			<input value="Benutzername" name="loginName"	type="text"		size="15" maxlength="50">
			<input value="Password"		name="password"		type="password" size="10" maxlength="30">
			<input value="login" type="submit" />
		</form>
	</c:when>
	<c:otherwise>
		<form class="buttonright" method="GET" action="JProjectServlet">
			Willkommen <a href="JProjectServlet?do=ShowUserSettings&loginName=${sessionScope.aktUser}">${sessionScope.aktUser}</a>
			<input value="Logout" name="do" type="submit" />
		</form>
	</c:otherwise>
</c:choose>