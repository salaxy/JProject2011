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
	<c:forEach items="${documentList}" var="document" varStatus="i">
		<a href="JProjectServlet?do=ShowAllDocu&documentID=${document.id}">${document.dateiname}</a><br>
	</c:forEach>
</div>

<div id="contentcontentsmall">
	<jsp:include page='../addNewDocu.jsp' />
	${document.id} ${document.dateiname}<br />	
	
	
</div>

<div id="footercontent">
	<input value="Show Comments" type="button" onclick="getShowAllComments41DocumentJSON(${document.id})" />
	<div id="allComments41Docu">
		
	</div>
	<!--<form>
		<textarea cols="93" rows="5">COMMENTS AJAX</textarea>
	</form>-->
</div>
