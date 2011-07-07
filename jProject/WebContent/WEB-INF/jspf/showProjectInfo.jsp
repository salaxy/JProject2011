<%-- 
    Document   : showProjectInfo
    Created on : 07.07.2011, 15:48:34
    Author     : MacYser
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<fieldset>
	<legend>Projekt Info</legend>
	<table border="0" cellspacing="3">
		<tbody>
			<tr>
				<td>Anzahl Member:</td>
				<td>${anzMember}</td>
			</tr>
			<tr>
				<td>Anzahl Dokumente:</td>
				<td>${anzDocu}</td>
			</tr>
			<tr>
				<td>Anzahl Sourcecodes:</td>
				<td>${anzSource}</td>
			</tr>
			<tr>
				<td>Anzahl Tasks:</td>
				<td>${anzTask}</td>
			</tr>
		</tbody>
	</table>
</fieldset>