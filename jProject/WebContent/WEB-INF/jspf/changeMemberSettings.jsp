<%-- 
    Document   : changeMemberSettings
    Created on : 07.07.2011, 15:46:20
    Author     : MacYser
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:choose>
	<c:when test="${sessionScope.isAllowedAddMember == true}">
		<h3>Einstellungen eines Members ändern</h3>
		<fieldset>
			<legend>Einstellungen dieses Members ändern</legend>
			<form method="POST" action="${sessionScope.aktServlet}">
				<input name="do" value="UpdateMember" type="hidden" />
				<input name="loginName" value="${member.user}" type="hidden" />
				<table border="0" cellspacing="3">
					<tbody>
						<tr>
							<td>
								<label for="rolle">Rolle:</label><br />
								<select name="rolle" >
									<c:forEach items="${projectRoles}" var="role" varStatus="i">
										<c:choose>
											<c:when test="${member.projectRole eq role}">
												<option value="${role}" selected>${role}</option>
											</c:when>
											<c:otherwise>
												<option value="${role}">${role}</option>
											</c:otherwise>
										</c:choose>

									</c:forEach>
								</select>
							</td>
						</tr>
						<tr>
							<td>
								<input value="Einstellungen ändern" type="submit">
							</td>
						</tr>
					</tbody>
				</table>
			</form>
		</fieldset>
	</c:when>
</c:choose>