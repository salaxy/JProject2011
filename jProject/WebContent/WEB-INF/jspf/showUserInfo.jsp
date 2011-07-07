<%-- 
    Document   : showUserInfo
    Created on : 07.07.2011, 15:54:14
    Author     : MacYser
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<fieldset>
	<legend>User Info</legend>
	<table border="0" cellspacing="3">
		<tbody>
			<tr>
				<td>Username:</td>
				<td>${user}</td>
			</tr>
			<tr>
				<td>Vorname:</td>
				<td>${user.vorname}</td>
			</tr>
			<tr>
				<td>Nachname:</td>
				<td>${user.nachname}</td>
			</tr>
			<tr>
				<td>Sprache:</td>
				<td>${user.sprache}</td>
			</tr>
			<tr>
				<td>Rolle:</td>
				<td>${user.globalRole}</td>
			</tr>
		</tbody>
	</table>
</fieldset>