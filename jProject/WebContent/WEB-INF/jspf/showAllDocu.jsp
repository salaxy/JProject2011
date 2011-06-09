<%-- 
    Document   : showAllDocu
    Created on : 07.06.2011, 18:46:14
    Author     : MacYser
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div id="topcontent">
	<jsp:include page='projectnavi.jsp' />
</div>

<div id="leftcontent">
	<c:forEach items="${documentList}" var="document" varStatus="i">
		<a href="JProjectServlet?do=ShowDocu&documentID=${document.id}">${document.dateiname}</a><br>
	</c:forEach>
</div>

<div id="contentcontentsmall">
	${document.id} ${document.dateiname}<br />	
	
	<form method="POST" action="DataServlet" enctype="multipart/form-data">
		<input type="hidden" name="do" value="AddNewDocu" />
		<input type="file" size="50" name="file1">
		<input type="submit" value="Upload" />
	</form>
</div>

<div id="footercontent">
	<form>
		<textarea cols="93" rows="5">COMMENTS AJAX</textarea>
	</form>
</div>
