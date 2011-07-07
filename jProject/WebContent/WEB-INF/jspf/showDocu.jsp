<%-- 
    Document   : showDocu
    Created on : 07.07.2011, 15:21:26
    Author     : MacYser
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:choose>
	<c:when test="${!empty documentList}">
		<div id="infoBoxBig">
			<h3>Aktuelles Dokument anzeigen</h3>
			<fieldset>
				<legend>Aktuelles Dokument</legend>
				<form>
					<table border="0" cellspacing="3">
						<tbody>
							<tr>
								<td>
									<textarea cols="75" rows="5" readonly="true">${document.id} ${document.dateiname}
${documentContent}
									</textarea>
								</td>
							</tr>
						</tbody>
					</table>
				</form>
			</fieldset>
		</div>
		<div id="infoBoxBig">
			<a href="DataServlet?do=DownloadDocu&documentId=${document.id}">Download ${document.dateiname}</a>
		</div>
	</c:when>
	<c:otherwise>
		<div id="infoBoxBig">
			Kein Document vorhanden!
		</div>
	</c:otherwise>
</c:choose>