<%-- 
    Document   : showUserInfo
    Created on : 09.06.2011, 21:33:09
    Author     : MacYser
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<h1>${user}´s Info</h1>
Username: ${user}<br />
Vorname: ${user.vorname}<br />
Nachname: ${user.nachname}<br />
Sprache: ${user.sprache}<br />
Rolle: ${user.globalRole}<br />


<c:choose>
	<c:when test="${sessionScope.isAllowedShowUserSettings == true}">
		<form method="POST" action="${sessionScope.aktServlet}">
			<input name="do" value="ShowUserSettings" type="hidden" />
			<input name="loginName" value="${user}" type="hidden" />
			<input value="Bearbeiten" type="submit" />
	</c:when>
</c:choose>


<!--TODO BEARBEITEN -> showUserSettings-->
