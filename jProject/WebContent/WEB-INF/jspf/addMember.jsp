<%-- 
    Document   : addMember
    Created on : 15.06.2011, 17:23:26
    Author     : MacYser
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:choose>
	<c:when test="${sessionScope.isAllowedAddMember == true}">
		<h3>Neuen Member hinzufügen</h3>
		<fieldset>
			<legend>Member hinzufügen</legend>
			<form method="POST" action="${sessionScope.aktServlet}">
				<input name="do" value="AddMember" type="hidden" />
				<table border="0" cellspacing="3">
					<tbody>
						<tr>
							<td>
								<label for="loginName">Member-LoginName:</label><br />
								<input value="MemberLoginName" name="loginName" type="text" size="20" maxlength="30" />
							</td>
						</tr>
						<tr>
							<td>
								<input value="Add" type="submit" />
							</td>
						</tr>
					</tbody>
				</table>
			</form>
			<!--
			req.getParameter("userLoginName"), 
			req.getParameter("projectName"), 
			req.getParameter("rolle")
			-->
		</fieldset>
		
	</c:when>
</c:choose>

