<%-- 
    Document   : addNewSource
    Created on : 16.06.2011, 22:14:07
    Author     : MacYser
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<h3>Neuen Sourcecode hinzufügen<input type="checkbox" onclick="showHideText(this,'addBox');" /></h3>
<fieldset id="addBox" style="display:none;">
	<legend>Neuen Sourcecode hinzufügen</legend>
	<form method="POST" action="DataServlet" enctype="multipart/form-data">
		<input type="hidden" name="do" value="AddNewSource" />
		<table border="0" cellspacing="3">
			<tbody>
				<!--TODO AJAX ADD FIELD-->
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