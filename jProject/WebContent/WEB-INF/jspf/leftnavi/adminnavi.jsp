<%-- 
    Document   : adminnavi
    Created on : 15.06.2011, 15:49:48
    Author     : MacYser
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<h1><%@include file="../stickyRed.jsp" %>Adminconsole</h1>
<div id="naviliste">
	<a href="AdminServlet?do=OpenAdminconsole">Adminconsole</a>
</div>
<br /><br />
<h1><%@include file="../stickyRed.jsp" %>Projekte</h1>
<div id="naviliste">
	<%@include file="../showAllProjects.jsp" %>
</div>
<br /><br />
<h1><%@include file="../stickyRed.jsp" %>User</h1>
<div id="naviliste">
	<%@include file="../showAllUser.jsp" %>
</div>
