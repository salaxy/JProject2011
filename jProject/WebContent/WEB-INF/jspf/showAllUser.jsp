<%-- 
    Document   : showAllUser
    Created on : 07.06.2011, 18:46:14
    Author     : MacYser
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:forEach items="${userList}" var="user" varStatus="i">
	<c:if test="${isAllowedDeleteUserAction}">
		<form method="POST" action="${sessionScope.aktServlet}" onsubmit="return confirmDeleteUser()">
			<input name="do" value="DeleteUser" type="hidden" />
			<input name="loginName" value="${user.loginName}" type="hidden" />
			<input value="X" type="submit" />
	</c:if>
	<a href="${sessionScope.aktServlet}?do=ShowUserInfo&loginName=${user.loginName}">${user}</a><br />
	<c:if test="${isAllowedDeleteUserAction}">
		</form>
	</c:if>
</c:forEach>

