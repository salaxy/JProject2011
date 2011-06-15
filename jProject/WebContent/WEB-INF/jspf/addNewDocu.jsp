<%-- 
    Document   : addNewDocu
    Created on : 15.06.2011, 17:14:08
    Author     : MacYser
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<h3>Neues Dokument hinzufügen</h3><br />
<form method="POST" action="DataServlet" enctype="multipart/form-data">
	<input type="hidden" name="do" value="AddNewDocu" />
	<input type="file" size="50" name="file1">
	<!--TODO AJAX ADD FIELD-->
	<input type="submit" value="Upload" />
</form>
