<%-- 
    Document   : register
    Created on : 19.06.2011, 16:25:38
    Author     : MacYser
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:choose>
	<c:when test="${sessionScope.isAllowedRegister == true}">
		<h3>Neuen User hinzufügen</h3>
		<form method="POST" action="${sessionScope.aktServlet}">
			<input name="do" value="Register" type="hidden" />
			<input value="Loginname" name="loginName" type="text" size="20" maxlength="30">
			<input value="Nachname" name="nachname" type="text" size="20" maxlength="30">
			<input value="Vorname" name="vorname" type="text" size="20" maxlength="30">
			<input value="Password" name="passwort" type="text" size="20" maxlength="30">
			<input value="Password Wdhl." name="passwortWdhl" type="text" size="20" maxlength="30">
			<input value="Add" type="submit" />
			<!--
			String loginName = req.getParameter("loginName");
			String passwort = req.getParameter("passwort");
			String passwortWdhl = req.getParameter("passwordWdhl");
			String nachname = req.getParameter("nachname");
			String vorname = req.getParameter("vorname");
			-->
		</form>
	</c:when>
</c:choose>
