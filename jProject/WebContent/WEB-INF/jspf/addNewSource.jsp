<%-- 
    Document   : addNewSource
    Created on : 16.06.2011, 22:14:07
    Author     : MacYser
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<h3>Neuen Sourcecode hinzufügen</h3>
<form method="POST" action="DataServlet" enctype="multipart/form-data">
	<input type="hidden" name="do" value="AddNewSource" />
	<input type="file" size="20" name="file1">
	<!--TODO AJAX ADD FIELD-->
	<input type="submit" value="Upload" />
</form>
