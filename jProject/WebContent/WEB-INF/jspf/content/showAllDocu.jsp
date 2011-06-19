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
	<c:forEach items="${documentList}" var="document" varStatus="i">
		<a href="${sessionScope.aktServlet}?do=ShowAllDocu&documentID=${document.id}">${document.dateiname}</a><br>
	</c:forEach>
</div>

<div id="contentcontentsmall">
	<h1>${document.dateiname}</h1>
	<div id="infoBoxBig">
		<jsp:include page='../addNewDocu.jsp' />
	</div>
	<div id="infoBoxBig">
		<form>
			<textarea cols="75" rows="5">${document.id} ${document.dateiname}
${documentContent}
			</textarea>
		</form>
	</div>
	<div id="infoBoxBig">
		
		<a href="DataServlet?do=DownloadDocu&documentId=${document.id}">Download ${document.dateiname}</a>
	</div>
</div>

<div id="footercontent">
	<input value="Show Comments" type="button" onclick="getShowAllComments41DocumentJSON(${document.id})" />
	<div id="allComments41Docu">
		
	</div>
</div>
