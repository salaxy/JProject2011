<%-- 
    Document   : addNewDocu
    Created on : 15.06.2011, 17:14:08
    Author     : MacYser
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<h3>Neues Dokument hinzufügen / Update<input type="checkbox" onclick="showHideText(this,'addBox');" /></h3>
<fieldset id="addBox" style="display:none;">
	<legend>Neues Dokument hinzufügen / Update</legend>
	<form method="POST" action="DataServlet" enctype="multipart/form-data">
		<input type="hidden" name="do" value="AddNewDocu" />
		<table border="0" cellspacing="3">
			<tbody>
				<!--TODO AJAX ADD FIELD-->
				<tr>
					Für ein Update des Dokuments, laden Sie bitte eine Datei mit gleichem Dateinamen hoch.
				</tr>
				<tr>
					<td>
						<input type="file" size="20" name="file1">
					</td>
					<td>
						<input type="submit" value="Upload" />
					</td>
				</tr>
			</tbody>
		</table>
	</form>
</fieldset>