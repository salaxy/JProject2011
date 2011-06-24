<%-- 
    Document   : showAllSource
    Created on : 07.06.2011, 18:46:46
    Author     : MacYser
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div id="topcontent">
	<jsp:include page='projectheader.jsp' />
</div>

<div id="leftcontent">
	<!--TODO OUTSOURCING-->
	<h1>Sourcecodes</h1>
	<c:forEach items="${sourcecodeList}" var="sourcecode" varStatus="i">
		<c:if test="${isAllowedDeleteSourceAction}">
			<form method="POST" action="${sessionScope.aktServlet}" onsubmit="return confirmDeleteSource()">
				<input name="do" value="DeleteSource" type="hidden" />
				<input name="sourcecodeId" value="${sourcecode.id}" type="hidden" />
				<input value="X" type="submit" />
		</c:if>
		<a href="${sessionScope.aktServlet}?do=ShowAllSource&sourcecodeId=${sourcecode.id}">${sourcecode.dateiname}</a><br>
		<c:choose>
			<c:when test="${isAllowedDeleteSourceAction}">
				</form>
			</c:when>
			<c:otherwise>
				<br />
			</c:otherwise>
		</c:choose>
	</c:forEach>
</div>

<div id="contentcontentsmall">
	<h1>${sourcecode.dateiname}</h1>
	<div id="infoBoxBig">
		<jsp:include page='../addNewSource.jsp' />
	</div>
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
</div>

<div id="footercontent">
	<c:choose>
		<c:when test="${!empty sourcecodeList}">
			<div id="allComments41Source">
				<input value="Show Comments" type="button" onclick="getShowAllComments41SourceJSON(${sourcecode.id})" />
			</div>
		</c:when>
	</c:choose>
</div>
