<%-- 
    Document   : showUserSettings
    Created on : 07.06.2011, 18:47:10
    Author     : MacYser
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<form class="buttonright" method="POST" action="JProjectServlet">
	<input name="do" value="UpdateUserSettings" type="hidden" />
	${user.loginName}<br />
	<!--<input value="" name="loginName" type="text" size="15" maxlength="50">--><br />
	<input value="${user.nachname}"	name="nachname"	type="text" size="20" maxlength="30"><br />
	<input value="${user.vorname}"	name="vorname"	type="text" size="20" maxlength="30"><br />
	<input value="${user.sprache}"	name="sprache"	type="text" size="20" maxlength="30"><br />
	<input value="Update" type="submit" />
	<!--
	req.getParameter("nachname"), 
	req.getParameter("vorname"), 
	req.getParameter("neuIcq"), 
	req.getParameter("neuSkype"), 
	req.getParameter("neutelefon"), 
	req.getParameter("sprache"), 
	req.getParameter("neuesPasswortEins"), 
	req.getParameter("neuesPasswortZwei"), 
	req.getParameter("altesPasswort"));
	-->
</form>