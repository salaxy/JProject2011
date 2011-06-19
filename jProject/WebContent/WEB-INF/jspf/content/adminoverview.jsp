<%-- 
    Document   : adminoverview
    Created on : 18.06.2011, 01:54:21
    Author     : MacYser
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<h1>Adminconsole</h1><br />



<table >
	<tr>
		<td width="500">
			Anzahl Projekte: ${anzProjects}<br />
			Anzahl User: ${anzUser}<br />
		</td>
		<td>
			<jsp:include page='../register.jsp' />
		</td>
	</tr>
</table>