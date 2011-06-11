<%-- 
    Document   : leftnavi
    Created on : 08.06.2011, 12:47:41
    Author     : MacYser
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:choose>
	<c:when test="${sessionScope.aktUser == null}">
		<h1><%@include file="../stickyRed.jsp" %>JProjekt</h1>
		<div id="naviliste">
			<a href="#">JProject</a><br />
			<a href="#">Referenzen</a><br />
			<a href="#">How To</a><br />
			<a href="#">Technische Details</a><br />
		</div>
	</c:when>
	<c:otherwise>
		<h1><%@include file="../stickyRed.jsp" %>Deine Projekte</h1>
		<div id="naviliste">
			<%@include file="../showAllOwnProjects.jsp" %>
		</div>
		<br /><br />
		<h1><%@include file="../stickyRed.jsp" %>Weitere<br />Funktionen</h1>
	</c:otherwise>
</c:choose>

