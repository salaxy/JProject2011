<%-- 
    Document   : showUserInfo
    Created on : 09.06.2011, 21:33:09
    Author     : MacYser
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div id="topcontent">
	<h1>${user}´s Info</h1>
</div>

<div id="contentcontentbig">	
	<div id="infoBoxBig">
		<!--TODO OUTSOURCING SHOWUSERINFO-->
		<h3>User Info</h3>
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
	</div>
	
	<div id="rightBox">
		<!--TODO OUTSOURCING SHOWUSERSETTINGS-->
		<c:choose>
			<c:when test="${sessionScope.isAllowedShowUserSettings == true}">
				<form method="POST" action="${sessionScope.aktServlet}">
					<input name="do" value="ShowUserSettings" type="hidden" />
					<input name="loginName" value="${user}" type="hidden" />
					<input value="Bearbeiten" type="submit" />
			</c:when>
		</c:choose>
	</div>
					
	<div id="rightBox">
		<!--TODO OUTSOURCING DELETEUSER-->
		<!--TODO REALISIERUNG-->
		<c:choose>
			<c:when test="${sessionScope.isAllowedDeleteUser == true}">
				<form method="POST" action="${sessionScope.aktServlet}">
					<input name="do" value="DeleteUser" type="hidden" />
					<input name="loginName" value="${user}" type="hidden" />
					<input value="Löschen" type="submit" />
			</c:when>
		</c:choose>
	</div>
</div>


<div id="footercontent">
	
</div>

