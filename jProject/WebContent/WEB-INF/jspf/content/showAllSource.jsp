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
	<h1>Sourcecodes</h1>
	<c:forEach items="${sourcecodeList}" var="sourcecode" varStatus="i">
		<a href="${sessionScope.aktServlet}?do=ShowAllSource&sourcecodeId=${sourcecode.id}">${sourcecode.dateiname}</a><br>
	</c:forEach>
</div>

<div id="contentcontentsmall">
	<h1>${sourcecode.dateiname}</h1>
	<div id="infoBoxBig">
		<jsp:include page='../addNewSource.jsp' />
	</div>
	<div id="infoBoxBig">
		<form>
			<textarea cols="75" rows="5" readonly="true">${sourceode.id} ${sourcecode.dateiname}
${sourcecodeContent}
			</textarea>
		</form>
	</div>
	<div id="infoBoxBig">
		<a href="DataServlet?do=DownloadSource&sourcecodeId=${sourcecode.id}">Download ${sourcecode.dateiname}</a>
	</div>
</div>

<div id="footercontent">
	<input value="Show Comments" type="button" onclick="getShowAllComments41SourceJSON(${sourcecode.id})" />
	<div id="allComments41Source">
		
	</div>
</div>
