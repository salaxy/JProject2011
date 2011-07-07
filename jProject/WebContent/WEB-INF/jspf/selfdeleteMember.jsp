<%-- 
    Document   : selfdeleteMember
    Created on : 07.07.2011, 15:33:51
    Author     : MacYser
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:choose>
	<c:when test="${aktServlet != 'AdminServlet'}">
		<form method="POST" action="${sessionScope.aktServlet}" onsubmit="return confirmSelfDeleteMember()">
			<input name="do" value="DeleteMember" type="hidden" />
			<input name="loginName" value="${sessionScope.aktUser}" type="hidden" />
			<input value="Eigene Mitgliedschaft beenden" type="submit">
		</form>
	</c:when>
</c:choose>
