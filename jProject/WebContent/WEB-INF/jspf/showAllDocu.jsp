<%-- 
    Document   : showAllDocu
    Created on : 07.07.2011, 14:55:14
    Author     : MacYser
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:forEach items="${documentList}" var="docu" varStatus="i">
	<c:if test="${isAllowedDeleteDocuAction}">
		<form method="POST" action="${sessionScope.aktServlet}" onsubmit="return confirmDeleteDocu()">
			<input name="do" value="DeleteDocu" type="hidden" />
			<input name="documentId" value="${docu.id}" type="hidden" />
			<input value="X" type="submit" />
	</c:if>
	<a href="${sessionScope.aktServlet}?do=ShowAllDocu&documentId=${docu.id}">${docu.dateiname}</a>
	<c:choose>
		<c:when test="${isAllowedDeleteDocuAction}">
			</form>
		</c:when>
		<c:otherwise>
			<br />
		</c:otherwise>
	</c:choose>

</c:forEach>