<%-- 
    Document   : addNewTask
    Created on : 07.07.2011, 15:29:04
    Author     : MacYser
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:choose>
	<c:when test="${isAllowedAddNewTaskAction == true}">
		<h3>Neuen Task hinzufügen<input type="checkbox" onclick="showHideText(this,'addBox');" /></h3>
		<fieldset id="addBox" style="display:none;">
			<legend>Neuen Task hinzufügen</legend>
			<form method="POST" action="${sessionScope.aktServlet}">
				<input name="do" value="AddNewTask" type="hidden" />
				<table border="0" cellspacing="3">
					<tbody>
						<tr>
							<td>
								<label for="titel">Titel:</label><br />
								<input name="titel" value="Titel" type="text" maxlength="14"/>
							</td>
						</tr>
						<tr>
							<td>
								<label for="aufgabenstellung">Aufgabenstellung:</label><br />
								<textarea name="aufgabenstellung" cols="75" rows="1">Aufgabenstellung</textarea>
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
		</fieldset>
	</c:when>
</c:choose>