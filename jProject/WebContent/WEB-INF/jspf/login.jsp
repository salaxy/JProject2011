<%-- 
    Document   : login
    Created on : 07.06.2011, 18:46:02
    Author     : MacYser
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<c:choose>
	<c:when test="${sessionScope.loggedIn == null}">
		<form class="buttonright" method="GET" action="JProjectServlet">
			<input name="do" value="Login" type="submit">
				<input value="Benutzername" name="loginName"	type="text"		size="15" maxlength="50">
				<input value="Password"		name="password"		type="password" size="10" maxlength="30">
			</input>
		</form>
	</c:when>
	<c:otherwise>
		<form class="buttonright" method="GET" action="JProjectServlet">
			Hallo ${sessionScope.aktUser.loginName} 
			<input value="Logout" name="do" type="submit"></input>
		</form>
	</c:otherwise>
</c:choose>