<%-- 
    Document   : adminoverview
    Created on : 18.06.2011, 01:54:21
    Author     : MacYser
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div id="topcontent">
	<h1>Adminconsole</h1>
</div>
<div id="contentcontentbig">
	<h1>JProject</h1>
	<div id="infoBoxBig">
		<!--TODO OUTSOURCING SHOWSYSTEMINFO-->
		<h3>JProject Info</h3>
		<fieldset>
			<legend>JProjekt Info</legend>
			<table border="0" cellspacing="3">
				<tbody>
					<tr>
						<td>Anzahl Projekte:</td>
						<td>${anzProjects}</td>
					</tr>
					<tr>
						<td>Anzahl User:</td>
						<td>${anzUser}</td>
					</tr>
				</tbody>
			</table>
		</fieldset>
	</div>
	
	<div id="rightBox">
		<jsp:include page='../register.jsp' />
	</div>
	
</div>

<div id="footercontent">
	
</div>
