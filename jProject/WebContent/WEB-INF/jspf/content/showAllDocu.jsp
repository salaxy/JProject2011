<%-- 
    Document   : showAllDocu
    Created on : 07.06.2011, 18:46:14
    Author     : MacYser
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div id="topcontent">
	<jsp:include page='projectheader.jsp' />
</div>

<div id="leftcontent">
	<!--TODO OUTSOURCING-->
	<h1>Documents</h1>
	<c:forEach items="${documentList}" var="docu" varStatus="i">
		<c:if test="${isAllowedDeleteDocuAction}">
			<form method="POST" action="${sessionScope.aktServlet}" onsubmit="return confirmDeleteDocu()">
				<input name="do" value="DeleteDocu" type="hidden" />
				<input name="documentId" value="${docu.id}" type="hidden" />
				<input value="X" type="submit" />
		</c:if>
		<a href="${sessionScope.aktServlet}?do=ShowAllDocu&documentId=${docu.id}">${docu.dateiname}</a>
		<c:if test="${isAllowedDeleteDocuAction}">
			</form>
		</c:if>
		
	</c:forEach>
</div>

<div id="contentcontentsmall">
	<h1>${document.dateiname}</h1>
	<div id="infoBoxBig">
		<jsp:include page='../addNewDocu.jsp' />
	</div>
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
</div>

<div id="footercontent">
	<c:choose>
		<c:when test="${!empty documentList}">
			<input value="Show Comments" type="button" onclick="getShowAllComments41DocumentJSON(${document.id})" />
			<div id="allComments41Docu">

			</div>
		</c:when>
	</c:choose>
</div>
