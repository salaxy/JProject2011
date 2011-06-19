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
		<!--TODO OUTSOURCING UPDATEUSERSETTINGS-->
		<h3>User Settings</h3>
		<fieldset>
			<legend>User Settings</legend>
			<form method="POST" action="${sessionScope.aktServlet}">
				<input name="do" value="UpdateUserSettings" type="hidden" />
				<input value="${user}" name="loginName" type="hidden">
				<table border="0" cellspacing="3">
					<tbody>
						<tr>
							<td>
								<label for="nachname">Nachname:</label><br />
								<input value="${user.nachname}"	name="nachname"	type="text" size="20" maxlength="30">
							</td>
						</tr>
						<tr>
							<td>
								<label for="vorname">Vorname:</label><br />
								<input value="${user.vorname}"	name="vorname"	type="text" size="20" maxlength="30">
							</td>
						</tr>
						<tr>
							<td>
								<label for="sprache">Sprache:</label><br />
								<input value="${user.sprache}"	name="sprache"	type="text" size="20" maxlength="30">
							</td>
						</tr>
						<tr>
							<td>
								<label for="neuesPasswortEins">Neues Passwort:</label><br />
								<input value=""	name="neuesPasswortEins" type="password" size="20" maxlength="30">
							</td>
						</tr>
						<tr>
							<td><label for="neuesPasswortZwei">Neues Passwort Wdhl.:</label><br />
							<input value=""	name="neuesPasswortZwei" type="password" size="20" maxlength="30"></td>
						</tr>
						<tr>
							<td>
								<c:choose>
									<c:when test="${sessionScope.isAllowedUpdateUserSettings == true}">
										<input value="Update" type="submit" />
									</c:when>
									<c:otherwise>
									</c:otherwise>
								</c:choose>
							</td>
						</tr>
					</tbody>
				</table>
				<!--
				loginName, 
				req.getParameter("nachname"), 
				req.getParameter("vorname"), 
				/*req.getParameter("neuIcq")*/null, 
				/*req.getParameter("neuSkype")*/null, 
				/*req.getParameter("neutelefon")*/null, 
				req.getParameter("sprache"), 
				req.getParameter("neuesPasswortEins"), 
				req.getParameter("neuesPasswortZwei")/*, 
				req.getParameter("altesPasswort")*/
				-->
			</form>
		</fieldset>
	</div>
</div>

<div id="footercontent">
</div>

