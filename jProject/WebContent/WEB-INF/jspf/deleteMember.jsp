<%-- 
    Document   : deleteMember
    Created on : 07.07.2011, 15:39:32
    Author     : MacYser
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:choose>
	<c:when test="${sessionScope.isAllowedDeleteMember == true}">
		<form method="POST" action="${sessionScope.aktServlet}" onsubmit="return confirmDeleteMember()">
			<input name="do" value="DeleteMember" type="hidden" />
			<input name="loginName" value="${member.user}" type="hidden" />
			<input value="Diesen Member löschen" type="submit">
		</form>
	</c:when>
</c:choose>