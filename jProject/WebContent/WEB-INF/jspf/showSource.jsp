<%-- 
    Document   : showSource
    Created on : 07.07.2011, 15:25:13
    Author     : MacYser
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:choose>
	<c:when test="${!empty sourcecodeList}">
		<div id="infoBoxBig">
			<h3>Aktuellen Sourcecode anzeigen</h3>
			<fieldset>
				<legend>Aktueller Sourcecode</legend>
				<form>
					<table border="0" cellspacing="3">
						<tbody>
							<tr>
								<td>
									<textarea cols="75" rows="5" readonly="true">${sourceode.id} ${sourcecode.dateiname}
${sourcecodeContent}
									</textarea>
								</td>
							</tr>
						</tbody>
					</table>
				</form>
			</fieldset>
		</div>
		<div id="infoBoxBig">
			<a href="DataServlet?do=DownloadSource&sourcecodeId=${sourcecode.id}">Download ${sourcecode.dateiname}</a>
		</div>
	</c:when>
	<c:otherwise>
		<div id="infoBoxBig">
			Kein Sourcecode vorhanden!
		</div>
	</c:otherwise>
</c:choose>