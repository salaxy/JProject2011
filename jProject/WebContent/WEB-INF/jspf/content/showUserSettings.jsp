<%-- 
    Document   : showUserSettings
    Created on : 07.06.2011, 18:47:10
    Author     : MacYser
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div id="topcontent">
	<h1>${user.loginName}´s Settings</h1>
</div>

<div id="contentcontentbig">
	<div id="infoBoxBig">
		<h3>User Settings</h3>
		<jsp:include page="../showUserSettings.jsp" />
	</div>
</div>

<div id="footercontent">
</div>

