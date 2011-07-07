<%-- 
    Document   : showAllSource
    Created on : 07.07.2011, 15:24:17
    Author     : MacYser
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:forEach items="${sourcecodeList}" var="sourcecode" varStatus="i">
	<c:if test="${isAllowedDeleteSourceAction}">
		<form method="POST" action="${sessionScope.aktServlet}" onsubmit="return confirmDeleteSource()">
			<input name="do" value="DeleteSource" type="hidden" />
			<input name="sourcecodeId" value="${sourcecode.id}" type="hidden" />
			<input value="X" type="submit" />
	</c:if>
	<a href="${sessionScope.aktServlet}?do=ShowAllSource&sourcecodeId=${sourcecode.id}">${sourcecode.dateiname}</a><br>
	<c:choose>
		<c:when test="${isAllowedDeleteSourceAction}">
			</form>
		</c:when>
		<c:otherwise>
			<br />
		</c:otherwise>
	</c:choose>
</c:forEach>