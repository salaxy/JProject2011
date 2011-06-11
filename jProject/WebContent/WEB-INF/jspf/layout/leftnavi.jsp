<%-- 
    Document   : leftnavi
    Created on : 08.06.2011, 12:47:41
    Author     : MacYser
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:choose>
	<c:when test="${sessionScope.aktUser != null}">
		<%//Wenn kein ContentFile => Projectuebersicht%>
		<c:choose>
			<c:when test="${naviFile != null}">
				<jsp:include page='<%= "../leftnavi/"+(String)request.getAttribute("naviFile") %>' />
			</c:when>
			<c:otherwise>
				<jsp:include page='../leftnavi/projectnavi.jsp' />
			</c:otherwise>
		</c:choose>
	</c:when>
	<c:otherwise>
		<jsp:include page='../leftnavi/welcomenavi.jsp' />
	</c:otherwise>
</c:choose>
