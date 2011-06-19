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
	<!--TODO OUTSOURCING-->
	<h2>Sourcecodeliste</h2>
	<c:forEach items="${sourcecodeList}" var="sourcecode" varStatus="i">
		<a href="${sessionScope.aktServlet}?do=ShowSource&sourcecodeID=${sourcecode.id}">${sourcecode.dateiname}</a><br>
	</c:forEach>
</div>

<div id="contentcontentsmall">
	${sourcecode.id} ${sourcecode.dateiname}<br />
</div>

<div id="footercontent">
	<input value="Show Comments" type="button" onclick="getShowAllComments41SourceJSON(${sourcecode.id})" />
	<div id="allComments41Source">
		
	</div>
</div>
