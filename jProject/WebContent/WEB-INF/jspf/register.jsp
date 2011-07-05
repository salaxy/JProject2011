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
		<fieldset>
				<legend>User hinzufügen</legend>
			<form method="POST" action="${sessionScope.aktServlet}">
				<input name="do" value="Register" type="hidden" />
				
				<table border="0" cellspacing="3">
					<thead>
						<tr>
							<th></th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td>
								<label for="loginName">Loginname:</label><br />
								<input value="Loginname" name="loginName" type="text" size="20" maxlength="15" />
							</td>
						</tr>
						<tr>
							<td>
								<label for="nachname">Nachname:</label><br />
								<input value="Nachname" name="nachname" type="text" size="20" maxlength="30" />
							</td>
						</tr>
						<tr>
							<td>
								<label for="vorname">Vorname:</label><br />
								<input value="Vorname" name="vorname" type="text" size="20" maxlength="30" />
							</td>
						</tr>
						<tr>
							<td>
								<label for="passwort">Passwort:</label><br />
								<input value="Password" name="passwort" type="text" size="20" maxlength="30" />
							</td>
						</tr>
						<tr>
							<td>
								<label for="passwortWdhl">Passwort Wdhl.:</label><br />
								<input value="Password Wdhl." name="passwortWdhl" type="text" size="20" maxlength="30" />
							</td>
						</tr>
						<tr>
							<td>
								<input value="Add" type="submit" />
							</td>
						</tr>
					</tbody>
				</table>
				<!--
				String loginName = req.getParameter("loginName");
				String passwort = req.getParameter("passwort");
				String passwortWdhl = req.getParameter("passwordWdhl");
				String nachname = req.getParameter("nachname");
				String vorname = req.getParameter("vorname");
				-->
			</form>
		</fieldset>
	</c:when>
</c:choose>
