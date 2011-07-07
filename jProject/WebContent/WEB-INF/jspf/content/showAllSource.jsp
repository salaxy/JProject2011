<%-- 
    Document   : showAllSource
    Created on : 07.06.2011, 18:46:46
    Author     : MacYser
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div id="topcontent">
	<jsp:include page='projectheader.jsp' />
</div>

<div id="leftcontent">
	<h1>Sourcecodes</h1>
	<jsp:include page='../showAllSource.jsp' />
</div>

<div id="contentcontentsmall">
	<h1>${sourcecode.dateiname}</h1>
	<div id="infoBoxBig">
		<jsp:include page='../addNewSource.jsp' />
	</div>
	<jsp:include page='../showSource.jsp' />
</div>

<div id="footercontent">
	<c:choose>
		<c:when test="${!empty sourcecodeList}">
			<div id="allComments41Source">
				<input value="Show Comments" type="button" onclick="getShowAllComments41SourceJSON(${sourcecode.id})" />
			</div>
		</c:when>
	</c:choose>
</div>
