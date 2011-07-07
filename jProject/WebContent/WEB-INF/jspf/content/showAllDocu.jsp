<%-- 
    Document   : showAllDocu
    Created on : 07.06.2011, 18:46:14
    Author     : MacYser
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div id="topcontent">
	<jsp:include page='projectheader.jsp' />
</div>

<div id="leftcontent">
	<!--TODO OUTSOURCING-->
	<h1>Documents</h1>
	<jsp:include page='../showAllDocu.jsp' />
</div>

<div id="contentcontentsmall">
	<h1>${document.dateiname}</h1>
	<div id="infoBoxBig">
		<jsp:include page='../addNewDocu.jsp' />
	</div>
	<jsp:include page='../showDocu.jsp' />
</div>

<div id="footercontent">
	<c:choose>
		<c:when test="${!empty documentList}">
			<div id="allComments41Docu">
				<input value="Show Comments" type="button" onclick="getShowAllComments41DocumentJSON(${document.id})" />
			</div>
		</c:when>
	</c:choose>
</div>
