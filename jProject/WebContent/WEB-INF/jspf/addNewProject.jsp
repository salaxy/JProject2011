<%-- 
    Document   : addNewProject
    Created on : 15.06.2011, 17:09:49
    Author     : MacYser
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<h2>Neues Projekt hinzufügen</h2><br />
<form method="POST" action="JProjectServlet">
	<input name="do" value="AddNewProject" type="hidden" />
	<input value="Projectname"	name="projectName"	type="text" size="20" maxlength="30">
	<input value="Add" type="submit" />
	<!--
	req.getParameter("projectName")
	-->
</form>