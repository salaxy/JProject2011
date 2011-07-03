<%-- 
    Document   : addNewProject
    Created on : 15.06.2011, 17:09:49
    Author     : MacYser
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<h3>Neues Projekt hinzufügen</h3>
<fieldset>
	<legend>Neues Projekt hinzufügen</legend>
	<form method="POST" action="JProjectServlet">
		<input name="do" value="AddNewProject" type="hidden" />
		<table border="0" cellspacing="3">
			<tbody>
				<tr>
					<td>
						<label for="projectName">Projectname:</label><br />
						<input value="Projectname"	name="projectName"	type="text" size="20" maxlength="15">
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
	req.getParameter("projectName"), 
	req.getParameter("status")
	-->
	</form>
</fieldset>